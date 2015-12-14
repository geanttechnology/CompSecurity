// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.support.v7.widget.Toolbar;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity, GridActivityParams

public abstract class LeftPanelListActivity extends BasicListActivity
{

    private NavigationPaneController navController;
    private PhotosNavigationPane navPane;
    private ThorActionBar thorActionBar;

    public LeftPanelListActivity(GridActivityParams gridactivityparams)
    {
        super(gridactivityparams);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (thorActionBar != null)
        {
            thorActionBar.onDestroy();
        }
        navController.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        navController.onPause();
    }

    public void onResume()
    {
        super.onResume();
        navController.onResume();
    }

    public void setTitle(String s)
    {
        super.setTitle(s);
        if (thorActionBar != null)
        {
            thorActionBar.setTitle(s);
        }
    }

    protected void setupActionBar()
    {
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        navController = new NavigationPaneController(this, navPane, tagDao, mediaItemDao, (Executor)getApplicationBean(Keys.UI_READY_EXECUTOR));
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            thorActionBar = new ThorActionBar(navPane, this, false, (Toolbar)findViewById(0x7f0c0086));
            thorActionBar.setup(-1, -1, -1, null);
            thorActionBar.updateHeaderOptions(null, null);
            navigationBar = thorActionBar;
        }
    }
}
