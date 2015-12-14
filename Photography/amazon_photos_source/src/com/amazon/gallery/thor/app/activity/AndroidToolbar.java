// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.thor.app.actions.SortActionProvider;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GalleryToolbar, GalleryNavigationSetting

public class AndroidToolbar
    implements GalleryToolbar
{

    private final ActionBarDrawerToggle actionBarDrawerToggle;
    private GalleryNavigationSetting navigationSetting;
    private final SortActionProvider sortActionProvider;
    private final Toolbar toolbar;

    public AndroidToolbar(Activity activity, Toolbar toolbar1, PhotosNavigationPane photosnavigationpane)
    {
        toolbar = toolbar1;
        sortActionProvider = new SortActionProvider(activity);
        if (photosnavigationpane != null)
        {
            actionBarDrawerToggle = new ActionBarDrawerToggle(activity, (DrawerLayout)photosnavigationpane, toolbar1, 0, 0);
            actionBarDrawerToggle.syncState();
            return;
        } else
        {
            actionBarDrawerToggle = null;
            return;
        }
    }

    public Drawable getBackground()
    {
        return toolbar.getBackground();
    }

    public Menu getMenu()
    {
        return toolbar.getMenu();
    }

    public GalleryNavigationSetting getNavigationSetting()
    {
        return navigationSetting;
    }

    public Toolbar getToolbar()
    {
        return toolbar;
    }

    public void inflateMenu(int i)
    {
        toolbar.inflateMenu(i);
        MenuItemCompat.setActionProvider(toolbar.getMenu().findItem(0x7f0c023a), sortActionProvider);
    }

    public void invalidateActionsMenu()
    {
        toolbar.invalidate();
    }

    public void removeRefineMenus()
    {
    }

    public void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        toolbar.setNavigationOnClickListener(onclicklistener);
    }

    public void setNavigationSetting(GalleryNavigationSetting gallerynavigationsetting)
    {
        navigationSetting = gallerynavigationsetting;
        if (GalleryNavigationSetting.BACK == gallerynavigationsetting)
        {
            toolbar.setNavigationIcon(0x7f020013);
        }
        if (actionBarDrawerToggle != null)
        {
            ActionBarDrawerToggle actionbardrawertoggle = actionBarDrawerToggle;
            boolean flag;
            if (GalleryNavigationSetting.BACK != gallerynavigationsetting)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            actionbardrawertoggle.setDrawerIndicatorEnabled(flag);
        }
        toolbar.setNavigationContentDescription(0x7f0e0003);
    }

    public void setOnMenuItemClickListener(android.support.v7.widget.Toolbar.OnMenuItemClickListener onmenuitemclicklistener)
    {
        toolbar.setOnMenuItemClickListener(onmenuitemclicklistener);
    }

    public void setOnSortChangedListener(OnSortingChangedListener onsortingchangedlistener)
    {
        sortActionProvider.setOnSortChangedListener(onsortingchangedlistener);
    }

    public void setSubtitle(CharSequence charsequence)
    {
        toolbar.setSubtitle(charsequence);
    }

    public void setTitle(CharSequence charsequence)
    {
        toolbar.setTitle(charsequence);
    }

    public void setupSort(int i, int j)
    {
        sortActionProvider.setupSort(i, j);
    }
}
