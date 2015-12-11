// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.content.Context;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtil;

public final class MapsInitializer
{

    private MapsInitializer()
    {
    }

    public static int initialize(Context context)
    {
        if (context == null)
        {
            throw new NullPointerException("Context cannot be null");
        }
        if (AmazonMapsRuntimeUtil.getRemoteContext(context) == null)
        {
            return AmazonMapsRuntimeUtil.isAmazonMapsRuntimeAvailable(context);
        } else
        {
            return 0;
        }
    }
}
