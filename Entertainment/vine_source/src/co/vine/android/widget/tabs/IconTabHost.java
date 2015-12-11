// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TabHost;

public class IconTabHost extends TabHost
{
    public static interface OnTabClickedListener
    {

        public abstract void onCurrentTabClicked();
    }


    private OnTabClickedListener mOnTabClickedListener;

    public IconTabHost(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void dispatchWindowFocusChanged(boolean flag)
    {
        if (getCurrentView() != null)
        {
            super.dispatchWindowFocusChanged(flag);
        }
    }

    public void setCurrentTab(int i)
    {
        if (i == getCurrentTab())
        {
            if (mOnTabClickedListener != null)
            {
                mOnTabClickedListener.onCurrentTabClicked();
            }
            return;
        } else
        {
            super.setCurrentTab(i);
            return;
        }
    }

    public void setOnTabClickedListener(OnTabClickedListener ontabclickedlistener)
    {
        mOnTabClickedListener = ontabclickedlistener;
    }

    public void setTabExplicit(int i)
    {
        super.setCurrentTab(i);
    }
}
