// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.AdLaunchHelper;
import com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics;
import com.amazon.gallery.framework.kindle.fragment.SettingsFragment;
import com.amazon.gallery.framework.kindle.metrics.UIClickMetrics;
import com.amazon.gallery.framework.kindle.util.KindleSearch;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidSimpleToolbar, GallerySimpleToolbar, GalleryNavigationSetting

public class ThorSettingsActivity extends AppCompatActivity
{

    private NavigationPaneController navController;
    private PhotosNavigationPane navPane;
    private UIClickMetrics profiler;
    private GallerySimpleToolbar toolbar;

    public ThorSettingsActivity()
    {
    }

    public static String getSharedPreferencesGroup(Context context)
    {
        return (new StringBuilder()).append(context.getPackageName()).append("_preferences").toString();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c5);
        profiler = (UIClickMetrics)ThorGalleryApplication.getBean(Keys.UI_METRICS_PROFILER);
        bundle = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        TagDao tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        if (AdLaunchHelper.isAdLaunch(getIntent()))
        {
            AdLaunchHelper.logLaunchMetric((LaunchSourceMetrics)ThorGalleryApplication.getBean(Keys.LAUNCH_SOURCE_PROFILER), getIntent());
        }
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        navController = new NavigationPaneController(this, navPane, tagdao, bundle, (Executor)ThorGalleryApplication.getBean(Keys.UI_READY_EXECUTOR));
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            setupActionBar(navPane);
        }
        getFragmentManager().beginTransaction().replace(0x7f0c01bf, new SettingsFragment()).commit();
    }

    protected void onNewIntent(Intent intent)
    {
        setIntent(intent);
        super.onNewIntent(intent);
    }

    protected void onPause()
    {
        super.onPause();
        navController.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        navController.onResume();
        navPane.select(0x7f0c0270);
    }

    public boolean onSearchRequested()
    {
        return KindleSearch.launchSearch(this);
    }

    public void setupActionBar(final PhotosNavigationPane navPane)
    {
        toolbar = new AndroidSimpleToolbar((Toolbar)findViewById(0x7f0c0085).findViewById(0x7f0c0086));
        toolbar.setTitle(getResources().getString(0x7f0e0154));
        toolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final ThorSettingsActivity this$0;
            final PhotosNavigationPane val$navPane;

            public void onClick(View view)
            {
                if (BuildFlavors.isFireOS4OrLater() && getIntent().hasExtra("com.amazon.photos.FROM_PHOTOS"))
                {
                    navPane.open();
                } else
                {
                    finish();
                    if (AdLaunchHelper.isAdLaunch(getIntent()))
                    {
                        startActivity(new Intent("com.amazon.photos.LAUNCH_PHOTOS"));
                        return;
                    }
                }
            }

            
            {
                this$0 = ThorSettingsActivity.this;
                navPane = photosnavigationpane;
                super();
            }
        });
    }
}
