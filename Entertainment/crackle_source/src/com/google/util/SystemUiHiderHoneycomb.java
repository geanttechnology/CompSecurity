// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.util;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import com.gotv.crackle.Application;

// Referenced classes of package com.google.util:
//            SystemUiHiderBase

public class SystemUiHiderHoneycomb extends SystemUiHiderBase
{

    private int mHideFlags;
    private int mShowFlags;
    private android.view.View.OnSystemUiVisibilityChangeListener mSystemUiVisibilityChangeListener;
    private int mTestFlags;
    private boolean mVisible;

    protected SystemUiHiderHoneycomb(ActionBarActivity actionbaractivity, View view, int i)
    {
        super(actionbaractivity, view, i);
        mVisible = true;
        mSystemUiVisibilityChangeListener = new android.view.View.OnSystemUiVisibilityChangeListener() {

            final SystemUiHiderHoneycomb this$0;

            public void onSystemUiVisibilityChange(int j)
            {
                if ((mTestFlags & j) != 0)
                {
                    mActivity.getSupportActionBar().hide();
                    if (android.os.Build.VERSION.SDK_INT < 16)
                    {
                        mActivity.getWindow().setFlags(1024, 1024);
                    }
                    mOnVisibilityChangeListener.onVisibilityChange(false);
                    mVisible = false;
                    return;
                }
                mActivity.getSupportActionBar().show();
                mAnchorView.setSystemUiVisibility(mShowFlags);
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    mActivity.getWindow().setFlags(0, 1024);
                }
                mOnVisibilityChangeListener.onVisibilityChange(true);
                mVisible = true;
            }

            
            {
                this$0 = SystemUiHiderHoneycomb.this;
                super();
            }
        };
        mShowFlags = 0;
        mHideFlags = 1;
        mTestFlags = 1;
        if ((mFlags & 2) != 0)
        {
            mShowFlags = mShowFlags | 0x400;
            mHideFlags = mHideFlags | 0x404;
        }
        if ((mFlags & 6) != 0)
        {
            mShowFlags = mShowFlags | 0x200;
            mHideFlags = mHideFlags | 0x202;
            mTestFlags = 2;
        }
    }

    public void hide()
    {
        if (Application.isLeanBack())
        {
            if (mSystemUiVisibilityChangeListener != null)
            {
                mSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(mHideFlags);
            }
            return;
        } else
        {
            mAnchorView.setSystemUiVisibility(mHideFlags);
            return;
        }
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public void setup()
    {
        mAnchorView.setOnSystemUiVisibilityChangeListener(mSystemUiVisibilityChangeListener);
    }

    public void show()
    {
        if (Application.isLeanBack())
        {
            if (mSystemUiVisibilityChangeListener != null)
            {
                mSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(mShowFlags);
            }
            return;
        } else
        {
            mAnchorView.setSystemUiVisibility(mShowFlags);
            return;
        }
    }



/*
    static boolean access$102(SystemUiHiderHoneycomb systemuihiderhoneycomb, boolean flag)
    {
        systemuihiderhoneycomb.mVisible = flag;
        return flag;
    }

*/

}
