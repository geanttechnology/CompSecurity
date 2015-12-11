// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import co.vine.android.BaseControllerActionBarActivity;

public class TabScrollListener
{

    private final BaseControllerActionBarActivity mActivity;
    private final int mTabIndex;

    public TabScrollListener(BaseControllerActionBarActivity basecontrolleractionbaractivity, int i)
    {
        mTabIndex = i;
        mActivity = basecontrolleractionbaractivity;
    }

    public void onScrollFirstItem()
    {
    }
}
