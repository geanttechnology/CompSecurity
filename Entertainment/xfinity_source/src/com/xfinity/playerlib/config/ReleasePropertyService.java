// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.config;

import com.comcast.cim.android.PropertyService;

public class ReleasePropertyService
    implements PropertyService
{

    public ReleasePropertyService()
    {
    }

    public String getOmnitureAccount()
    {
        return "comcastipadprod";
    }

    public boolean getOmnitureDebug()
    {
        return false;
    }
}
