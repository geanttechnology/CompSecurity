// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            SlidingMenu

public class SlidingActivityHelper
{
    public static class MenuStateHandler
        implements android.view.View.OnDragListener, SlidingMenu.OnClosedListener, SlidingMenu.OnCloseListener, SlidingMenu.OnOpenedListener, SlidingMenu.OnOpenListener, android.view.View.OnClickListener
    {

        private final MenuStateListener mListener;

        public void onClick(View view)
        {
            mListener.onMenuClick(view);
        }

        public void onClose()
        {
            mListener.onMenuClose();
        }

        public void onClosed()
        {
            mListener.onMenuClosed();
        }

        public boolean onDrag(View view, DragEvent dragevent)
        {
            return mListener.onMenuDrag(view, dragevent);
        }

        public void onOpen()
        {
            mListener.onMenuOpen();
        }

        public void onOpened()
        {
            mListener.onMenuOpened();
        }

        public MenuStateHandler(MenuStateListener menustatelistener)
        {
            mListener = menustatelistener;
        }
    }

    public static interface MenuStateHandler.MenuStateListener
    {

        public abstract void onMenuClick(View view);

        public abstract void onMenuClose();

        public abstract void onMenuClosed();

        public abstract boolean onMenuDrag(View view, DragEvent dragevent);

        public abstract void onMenuOpen();

        public abstract void onMenuOpened();
    }


    private Activity mActivity;
    private boolean mBroadcasting;
    private boolean mEnableSlide;
    private boolean mOnPostCreateCalled;
    private SlidingMenu mSlidingMenu;
    private View mViewAbove;
    private View mViewBehind;

    public SlidingActivityHelper(Activity activity)
    {
        mBroadcasting = false;
        mOnPostCreateCalled = false;
        mEnableSlide = true;
        mActivity = activity;
    }

    public View findViewById(int i)
    {
        if (mSlidingMenu != null)
        {
            View view = mSlidingMenu.findViewById(i);
            if (view != null)
            {
                return view;
            }
        }
        return null;
    }

    public SlidingMenu getSlidingMenu()
    {
        return mSlidingMenu;
    }

    public void onCreate(Bundle bundle)
    {
        mSlidingMenu = (SlidingMenu)LayoutInflater.from(mActivity).inflate(R.layout.slidingmenumain, null);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4 && mSlidingMenu.isMenuShowing())
        {
            showContent();
            return true;
        } else
        {
            return false;
        }
    }

    public void onPostCreate(Bundle bundle)
    {
        int i = 1;
        if (mViewBehind == null || mViewAbove == null)
        {
            throw new IllegalStateException("Both setBehindContentView must be called in onCreate in addition to setContentView.");
        }
        mOnPostCreateCalled = true;
        SlidingMenu slidingmenu = mSlidingMenu;
        Activity activity = mActivity;
        if (mEnableSlide)
        {
            i = 0;
        }
        slidingmenu.attachToActivity(activity, i);
        final boolean open;
        final boolean secondary;
        if (bundle != null)
        {
            open = bundle.getBoolean("SlidingActivityHelper.open");
            secondary = bundle.getBoolean("SlidingActivityHelper.secondary");
        } else
        {
            open = false;
            secondary = false;
        }
        (new Handler()).post(new Runnable() {

            final SlidingActivityHelper this$0;
            final boolean val$open;
            final boolean val$secondary;

            public void run()
            {
                if (open)
                {
                    if (secondary)
                    {
                        mSlidingMenu.showSecondaryMenu(false);
                        return;
                    } else
                    {
                        mSlidingMenu.showMenu(false);
                        return;
                    }
                } else
                {
                    mSlidingMenu.showContent(false);
                    return;
                }
            }

            
            {
                this$0 = SlidingActivityHelper.this;
                open = flag;
                secondary = flag1;
                super();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("SlidingActivityHelper.open", mSlidingMenu.isMenuShowing());
        bundle.putBoolean("SlidingActivityHelper.secondary", mSlidingMenu.isSecondaryMenuShowing());
    }

    public void registerAboveContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (!mBroadcasting)
        {
            mViewAbove = view;
        }
    }

    public void setBehindContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        mViewBehind = view;
        mSlidingMenu.setMenu(mViewBehind);
    }

    public void setContentView(View view)
    {
        mBroadcasting = true;
        mActivity.setContentView(view);
    }

    public void setMenuStateListener(MenuStateHandler.MenuStateListener menustatelistener)
    {
        menustatelistener = new MenuStateHandler(menustatelistener);
        mSlidingMenu.setOnClosedListener(menustatelistener);
        mSlidingMenu.setOnCloseListener(menustatelistener);
        mSlidingMenu.setOnOpenedListener(menustatelistener);
        mSlidingMenu.setOnOpenListener(menustatelistener);
        mSlidingMenu.setOnClickListener(menustatelistener);
        mSlidingMenu.setOnDragListener(menustatelistener);
    }

    public void setSlidingActionBarEnabled(boolean flag)
    {
        if (mOnPostCreateCalled)
        {
            throw new IllegalStateException("enableSlidingActionBar must be called in onCreate.");
        } else
        {
            mEnableSlide = flag;
            return;
        }
    }

    public void showContent()
    {
        mSlidingMenu.showContent();
    }

    public void showMenu()
    {
        mSlidingMenu.showMenu();
    }

    public void showSecondaryMenu()
    {
        mSlidingMenu.showSecondaryMenu();
    }

    public void toggle()
    {
        mSlidingMenu.toggle();
    }

}
