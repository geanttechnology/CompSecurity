// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.config;

import com.comcast.cim.android.PropertyService;

public class DebugPropertyService
    implements PropertyService
{

    public DebugPropertyService()
    {
    }

    public String getOmnitureAccount()
    {
        return "comcastipaddev";
    }

    public boolean getOmnitureDebug()
    {
        return true;
    }
}
