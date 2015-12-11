// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mobile.appdrawer.AppDrawerShowHideCallback;
import com.amazon.mobile.appdrawer.LeftNavAppDrawerFragment;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter, AmazonDrawerLayout, GNOMenuItemController, GNODrawerItem

public class GNODrawer
    implements com.amazon.mShop.localeswitch.LocaleSwitchActivity.LocaleSwitchListener, AppDrawerShowHideCallback
{
    private class DrawerListener
        implements android.support.v4.widget.DrawerLayout.DrawerListener
    {

        final GNODrawer this$0;

        public void onDrawerClosed(View view)
        {
            for (view = getListenersCopy().iterator(); view.hasNext(); ((GNODrawerListener)view.next()).onDrawerClosed(GNODrawer.this)) { }
        }

        public void onDrawerOpened(View view)
        {
            for (view = getListenersCopy().iterator(); view.hasNext(); ((GNODrawerListener)view.next()).onDrawerOpened(GNODrawer.this)) { }
        }

        public void onDrawerSlide(View view, float f)
        {
            for (view = getListenersCopy().iterator(); view.hasNext(); ((GNODrawerListener)view.next()).onDrawerSlide(GNODrawer.this, f)) { }
        }

        public void onDrawerStateChanged(int i)
        {
            i;
            JVM INSTR tableswitch 1 2: default 24
        //                       1 25
        //                       2 25;
               goto _L1 _L2 _L2
_L1:
            AmazonActivity amazonactivity;
            return;
_L2:
            if ((amazonactivity = AmazonActivity.getTopMostBaseActivity()) != null)
            {
                amazonactivity.closeSoftKeyboard();
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        private DrawerListener()
        {
            this$0 = GNODrawer.this;
            super();
        }

    }

    public static interface GNODrawerListener
    {

        public abstract void onDrawerClosed(GNODrawer gnodrawer);

        public abstract void onDrawerOpened(GNODrawer gnodrawer);

        public abstract void onDrawerSlide(GNODrawer gnodrawer, float f);
    }

    public static class SimpleGNODrawerListener
        implements GNODrawerListener
    {

        public void onDrawerClosed(GNODrawer gnodrawer)
        {
        }

        public void onDrawerOpened(GNODrawer gnodrawer)
        {
        }

        public void onDrawerSlide(GNODrawer gnodrawer, float f)
        {
        }

        public SimpleGNODrawerListener()
        {
        }
    }


    private static GNOItemAdapter sDrawerItemAdapter = new GNOItemAdapter();
    private LeftNavAppDrawerFragment mAppDrawerFragment;
    private AmazonDrawerLayout mDrawer;
    private Set mListeners;
    private ListView mMenuList;

    private GNODrawer(AmazonActivity amazonactivity)
    {
        mDrawer = (AmazonDrawerLayout)LayoutInflater.from(amazonactivity).inflate(com.amazon.mShop.android.lib.R.layout.gno_drawer, null);
        mDrawer.setDrawerShadow(com.amazon.mShop.android.lib.R.drawable.gno_drawer_shadow, 3);
        mDrawer.setDrawerListener(new DrawerListener());
        mListeners = new HashSet();
        LocaleUtils.addLocaleSwitchListener(this);
        mMenuList = (ListView)mDrawer.findViewById(com.amazon.mShop.android.lib.R.id.gno_drawer_list);
        buildMenu();
        mAppDrawerFragment = (LeftNavAppDrawerFragment)amazonactivity.getSupportFragmentManager().findFragmentById(com.amazon.mShop.android.lib.R.id.amazon_app_drawer_fragment);
        if (ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.R.string.config_is_app_drawer_enabled))
        {
            addListener(new GNODrawerListener() {

                final GNODrawer this$0;

                public void onDrawerClosed(GNODrawer gnodrawer)
                {
                    mAppDrawerFragment.onNavDrawerClosed();
                }

                public void onDrawerOpened(GNODrawer gnodrawer)
                {
                    mAppDrawerFragment.onNavDrawerOpened();
                }

                public void onDrawerSlide(GNODrawer gnodrawer, float f)
                {
                }

            
            {
                this$0 = GNODrawer.this;
                super();
            }
            });
            mAppDrawerFragment.setShowHideCallback(this);
            return;
        } else
        {
            amazonactivity.getSupportFragmentManager().beginTransaction().remove(mAppDrawerFragment).commit();
            hideAppDrawer();
            return;
        }
    }

    private void buildMenu()
    {
        mMenuList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final GNODrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (AmazonActivity.getTopMostBaseActivity() != null)
                {
                    ((GNODrawerItem)adapterview.getItemAtPosition(i)).onClick(AmazonActivity.getTopMostBaseActivity(), GNODrawer.this);
                }
            }

            
            {
                this$0 = GNODrawer.this;
                super();
            }
        });
        mMenuList.setDescendantFocusability(0x20000);
        mMenuList.setAdapter(getGNOItemAdapter());
    }

    public static GNOItemAdapter getGNOItemAdapter()
    {
        return sDrawerItemAdapter;
    }

    public static GNODrawer getInstance(AmazonActivity amazonactivity)
    {
        return new GNODrawer(amazonactivity);
    }

    private Set getListenersCopy()
    {
        return new HashSet(mListeners);
    }

    public static void reset()
    {
        getGNOItemAdapter().clearItems();
        getGNOItemAdapter().notifyDataSetChanged();
        GNOMenuItemController.getInstance().resetUpdate();
        LeftNavAppDrawerFragment.reset();
    }

    public void addListener(GNODrawerListener gnodrawerlistener)
    {
        mListeners.add(gnodrawerlistener);
    }

    public View applyGNODrawer(View view)
    {
        View view1 = mDrawer.findViewById(com.amazon.mShop.android.lib.R.id.content_frame);
        int i = mDrawer.indexOfChild(view1);
        mDrawer.removeView(view1);
        mDrawer.addView(view, i);
        return mDrawer;
    }

    public void close()
    {
        if (isUnlocked())
        {
            mDrawer.closeDrawer(3);
        }
    }

    public void closeAppDrawer()
    {
        mAppDrawerFragment.closeAppDrawer(true);
    }

    public void destroy()
    {
        mMenuList.setAdapter(null);
        mListeners.clear();
        LocaleUtils.removeLocaleSwitchListener(this);
    }

    public boolean focusOn(String s)
    {
        return focusOn(s, false);
    }

    public boolean focusOn(final String id, final boolean pinToTop)
    {
        final GNODrawerItem item = getGNOItemAdapter().getItem(id);
        if (item != null)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

                final GNODrawer this$0;
                final String val$id;
                final GNODrawerItem val$item;
                final boolean val$pinToTop;

                public void run()
                {
                    Object obj = item.getParent();
                    GNOItemAdapter gnoitemadapter = GNODrawer.getGNOItemAdapter();
                    if (obj != null)
                    {
                        obj = ((GNODrawerItem) (obj)).getId();
                    } else
                    {
                        obj = id;
                    }
                    gnoitemadapter.expandGroup(((String) (obj)));
                    if (pinToTop)
                    {
                        int i = GNOItemAdapter.getListViewPosition(GNODrawer.getGNOItemAdapter().getVisibleItemPosition(id));
                        if (i != -1)
                        {
                            mMenuList.setSelection(i);
                        }
                    }
                }

            
            {
                this$0 = GNODrawer.this;
                item = gnodraweritem;
                id = s;
                pinToTop = flag;
                super();
            }
            });
            return true;
        } else
        {
            return false;
        }
    }

    public ListView getListView()
    {
        return mMenuList;
    }

    public void hideAppDrawer()
    {
        mDrawer.findViewById(com.amazon.mShop.android.lib.R.id.app_drawer_frame_layout).setVisibility(4);
        mDrawer.findViewById(com.amazon.mShop.android.lib.R.id.more_amazon_apps_placeholder).setVisibility(8);
    }

    public boolean isAppDrawerOpen()
    {
        return mAppDrawerFragment.isAppDrawerOpen();
    }

    public boolean isClosed()
    {
        return !isOpen();
    }

    public boolean isItemDisplayed(String s)
    {
        int i = GNOItemAdapter.getListViewPosition(getGNOItemAdapter().getVisibleItemPosition(s));
        int j = mMenuList.getFirstVisiblePosition();
        int k = mMenuList.getLastVisiblePosition();
        return i >= j && i <= k;
    }

    public boolean isLastVisibleItem(String s)
    {
        return getGNOItemAdapter().getVisibleItemPosition(s) == GNOItemAdapter.getAdapterPosition(mMenuList.getLastVisiblePosition());
    }

    public boolean isOpen()
    {
        return mDrawer.isDrawerOpen(3);
    }

    public boolean isUnlocked()
    {
        return mDrawer.getDrawerLockMode(3) == 0;
    }

    public boolean isVisible()
    {
        return mDrawer.isDrawerVisible(3);
    }

    public void lock()
    {
        lock(mDrawer.isDrawerOpen(3));
    }

    public void lock(boolean flag)
    {
        if (flag)
        {
            mDrawer.setDrawerLockMode(2, 3);
            return;
        } else
        {
            mDrawer.setDrawerLockMode(1, 3);
            return;
        }
    }

    public void onLocaleSwitch(String s, String s1)
    {
        reset();
    }

    public void refresh()
    {
        getGNOItemAdapter().notifyDataSetChanged();
    }

    public void removeListener(GNODrawerListener gnodrawerlistener)
    {
        mListeners.remove(gnodrawerlistener);
    }

    public void resetPosition()
    {
        getGNOItemAdapter().collapseExpandedGroup();
        mMenuList.setSelection(0);
    }

    public void scrollItemToTop(String s)
    {
        int i;
label0:
        {
            i = GNOItemAdapter.getListViewPosition(getGNOItemAdapter().getVisibleItemPosition(s));
            if (i >= 0)
            {
                if (android.os.Build.VERSION.SDK_INT <= 10)
                {
                    break label0;
                }
                mMenuList.smoothScrollToPositionFromTop(i, 0);
            }
            return;
        }
        mMenuList.setSelection(i);
    }

    public void showAppDrawer()
    {
        mDrawer.findViewById(com.amazon.mShop.android.lib.R.id.app_drawer_frame_layout).setVisibility(0);
        mDrawer.findViewById(com.amazon.mShop.android.lib.R.id.more_amazon_apps_placeholder).setVisibility(0);
    }

    public void toggle()
    {
label0:
        {
            if (isUnlocked())
            {
                if (!mDrawer.isDrawerOpen(3))
                {
                    break label0;
                }
                mDrawer.closeDrawer(3);
            }
            return;
        }
        mDrawer.openDrawer(3);
    }

    public void unlock()
    {
        mDrawer.setDrawerLockMode(0, 3);
    }

    public void updateMenuItems(boolean flag)
    {
        GNOMenuItemController.getInstance().updateMenuItems(sDrawerItemAdapter, flag);
    }




}
