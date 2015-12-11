// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.util;

import android.support.v7.app.ActionBarActivity;
import android.view.View;

// Referenced classes of package com.google.util:
//            SystemUiHiderHoneycomb, SystemUiHiderBase

public abstract class SystemUiHider
{
    public static interface OnVisibilityChangeListener
    {

        public abstract void onVisibilityChange(boolean flag);
    }


    public static final int FLAG_FULLSCREEN = 2;
    public static final int FLAG_HIDE_NAVIGATION = 6;
    public static final int FLAG_LAYOUT_IN_SCREEN_OLDER_DEVICES = 1;
    private static OnVisibilityChangeListener sDummyListener = new OnVisibilityChangeListener() {

        public void onVisibilityChange(boolean flag)
        {
        }

    };
    protected ActionBarActivity mActivity;
    protected View mAnchorView;
    protected int mFlags;
    protected OnVisibilityChangeListener mOnVisibilityChangeListener;

    protected SystemUiHider(ActionBarActivity actionbaractivity, View view, int i)
    {
        mOnVisibilityChangeListener = sDummyListener;
        mActivity = actionbaractivity;
        mAnchorView = view;
        mFlags = i;
    }

    public static SystemUiHider getInstance(ActionBarActivity actionbaractivity, View view, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return new SystemUiHiderHoneycomb(actionbaractivity, view, i);
        } else
        {
            return new SystemUiHiderBase(actionbaractivity, view, i);
        }
    }

    public abstract void hide();

    public abstract boolean isVisible();

    public void setOnVisibilityChangeListener(OnVisibilityChangeListener onvisibilitychangelistener)
    {
        OnVisibilityChangeListener onvisibilitychangelistener1 = onvisibilitychangelistener;
        if (onvisibilitychangelistener == null)
        {
            onvisibilitychangelistener1 = sDummyListener;
        }
        mOnVisibilityChangeListener = onvisibilitychangelistener1;
    }

    public abstract void setup();

    public abstract void show();

    public void toggle()
    {
        if (isVisible())
        {
            hide();
            return;
        } else
        {
            show();
            return;
        }
    }

}
