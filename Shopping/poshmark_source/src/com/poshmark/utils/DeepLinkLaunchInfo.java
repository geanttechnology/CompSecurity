// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;

public class DeepLinkLaunchInfo
{

    public Bundle bundle;
    public Object data;
    public Class fragmentClass;
    public boolean switchTabs;
    public int tab;

    public DeepLinkLaunchInfo()
    {
        switchTabs = false;
    }

    public DeepLinkLaunchInfo(Bundle bundle1, Class class1, Object obj)
    {
        switchTabs = false;
        bundle = bundle1;
        fragmentClass = class1;
        data = obj;
    }

    public void setTabSwitch(int i)
    {
        tab = i;
        switchTabs = true;
    }
}
