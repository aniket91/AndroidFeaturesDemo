package androidfeaturesdemo.com.osfg.androiddemofeatures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by athakur on 4/1/17.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        //set the toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //lets hide the tabs for now. Well add later if required
        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setVisibility(View.GONE);
    }
}
