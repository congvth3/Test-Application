package helloworld.chcompany.vuthecong.travelapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by vuthecong on 1/30/16.
 */

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {
    TabHost tabHost;
    // Called when the activity is first created.

    public void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = getTabHost();
        setTabs();
    }
    public void setTabs() {
        addTab("Home", R.drawable.tab_home, MainActivity.class);
        addTab("Map", R.drawable.tab_map, MapActivity.class);
        addTab("List", R.drawable.tab_list_location, NewFeed.class);
        addTab("Profile", R.drawable.tab_profile, ProfileActivity.class);

    }
    public void addTab(String labelId, int drawableId, Class<?> c) {
        Intent intent = new Intent(this, c);
        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText(labelId);
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(drawableId);
        spec.setIndicator(labelId);
        spec.setContent(intent);
        tabHost.addTab(spec);
    }
}
