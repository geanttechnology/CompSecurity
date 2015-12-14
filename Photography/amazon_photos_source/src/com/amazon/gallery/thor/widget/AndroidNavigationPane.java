// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.amazon.gallery.framework.gallery.widget.GalleryDrawerLayout;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.ui.ScreenUtil;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AndroidNavigationPane extends GalleryDrawerLayout
    implements PhotosNavigationPane
{
    private class NavigationPaneListener
        implements android.support.v4.widget.DrawerLayout.DrawerListener
    {

        boolean isDragging;
        final AndroidNavigationPane this$0;

        public void onDrawerClosed(View view)
        {
        }

        public void onDrawerOpened(View view)
        {
        }

        public void onDrawerSlide(View view, float f)
        {
            if (!isDragging && sidePanelListeners != null)
            {
                isDragging = true;
                for (view = sidePanelListeners.iterator(); view.hasNext(); ((com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener)view.next()).onDragged()) { }
            }
        }

        public void onDrawerStateChanged(int i)
        {
            if (i == 0)
            {
                isDragging = false;
                for (Iterator iterator = sidePanelListeners.iterator(); iterator.hasNext();)
                {
                    com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener sidepanellistener = (com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener)iterator.next();
                    if (isDrawerOpen(0x800003))
                    {
                        sidepanellistener.onOpened();
                    } else
                    {
                        sidepanellistener.onClosed();
                    }
                }

            }
        }

        private NavigationPaneListener()
        {
            this$0 = AndroidNavigationPane.this;
            super();
            isDragging = false;
        }

    }

    private class OnNavigationItemClickListener
        implements android.support.design.widget.NavigationView.OnNavigationItemSelectedListener
    {

        final AndroidNavigationPane this$0;

        public boolean onNavigationItemSelected(MenuItem menuitem)
        {
            boolean flag;
            if (navigationSelectedListener == null)
            {
                flag = false;
            } else
            {
                flag = navigationSelectedListener.onNavigationItemSelected(menuitem);
            }
            if (flag)
            {
                select(menuitem.getItemId());
                for (Iterator iterator = sidePanelListeners.iterator(); iterator.hasNext(); ((com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener)iterator.next()).onNavigate(menuitem)) { }
                close();
            }
            return flag;
        }

        private OnNavigationItemClickListener()
        {
            this$0 = AndroidNavigationPane.this;
            super();
        }

    }


    private boolean enabled;
    private com.amazon.gallery.thor.view.PhotosNavigationPane.EnabledChangedListener enabledChangedListener;
    private MenuItem lastSelectedMenuItem;
    private NavigationView navigationPaneList;
    private final NavigationPaneListener navigationPaneListener;
    private android.support.design.widget.NavigationView.OnNavigationItemSelectedListener navigationSelectedListener;
    private final Set sidePanelListeners;

    public AndroidNavigationPane(Context context)
    {
        super(context);
        enabled = true;
        sidePanelListeners = new HashSet();
        navigationPaneListener = new NavigationPaneListener();
    }

    public AndroidNavigationPane(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        enabled = true;
        sidePanelListeners = new HashSet();
        navigationPaneListener = new NavigationPaneListener();
    }

    public AndroidNavigationPane(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        enabled = true;
        sidePanelListeners = new HashSet();
        navigationPaneListener = new NavigationPaneListener();
    }

    private void updatePadding()
    {
        android.content.res.Resources resources = getContext().getResources();
        int j = 0;
        int i = 0;
        if (getContext() instanceof NativeGalleryActivity)
        {
            j = ScreenUtil.getStatusBarHeightForPadding(resources);
            i = ScreenUtil.getNavigationBarHeightForPadding(getContext());
        }
        navigationPaneList.setPadding(navigationPaneList.getPaddingLeft(), j, navigationPaneList.getPaddingRight(), i);
    }

    public void addSidePanelListener(com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener sidepanellistener)
    {
        if (sidePanelListeners.isEmpty())
        {
            setDrawerListener(navigationPaneListener);
        }
        sidePanelListeners.add(sidepanellistener);
    }

    public void close()
    {
        if (enabled && isDrawerOpen(0x800003))
        {
            super.closeDrawer(0x800003);
        }
    }

    public boolean getSideBarEnabled()
    {
        return enabled;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updatePadding();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        navigationPaneList = (NavigationView)findViewById(0x7f0c0186);
        updatePadding();
        navigationPaneList.setNavigationItemSelectedListener(new OnNavigationItemClickListener());
    }

    public void open()
    {
        if (enabled && !isDrawerOpen(0x800003))
        {
            super.openDrawer(0x800003);
        }
    }

    public void removeSidePanelListener(com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener sidepanellistener)
    {
        sidePanelListeners.remove(sidepanellistener);
        if (sidePanelListeners.isEmpty())
        {
            setDrawerListener(null);
        }
    }

    public void select(int i)
    {
        if (lastSelectedMenuItem != null)
        {
            lastSelectedMenuItem.setChecked(false);
        }
        MenuItem menuitem = navigationPaneList.getMenu().findItem(i);
        if (menuitem != null)
        {
            menuitem.setChecked(true);
            lastSelectedMenuItem = menuitem;
        }
    }

    public void setEnabledChangedListener(com.amazon.gallery.thor.view.PhotosNavigationPane.EnabledChangedListener enabledchangedlistener)
    {
        enabledChangedListener = enabledchangedlistener;
    }

    public void setItemInvisible(int i)
    {
        MenuItem menuitem = navigationPaneList.getMenu().findItem(i);
        if (menuitem != null)
        {
            menuitem.setVisible(false);
        }
    }

    public void setItemVisible(int i)
    {
        MenuItem menuitem = navigationPaneList.getMenu().findItem(i);
        if (menuitem != null)
        {
            menuitem.setVisible(true);
        }
    }

    public void setOnNavigationItemSelectedListener(android.support.design.widget.NavigationView.OnNavigationItemSelectedListener onnavigationitemselectedlistener)
    {
        navigationSelectedListener = onnavigationitemselectedlistener;
    }

    public void setSideBarEnabled(boolean flag)
    {
        close();
        int i;
        boolean flag1;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        setDrawerLockMode(i, 0x800003);
        flag1 = enabled;
        enabled = flag;
        if (flag1 != enabled && enabledChangedListener != null)
        {
            enabledChangedListener.OnEnabledChanged(enabled);
        }
    }


}
