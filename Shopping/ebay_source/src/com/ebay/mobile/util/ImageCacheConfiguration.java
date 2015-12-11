// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.app.ActivityManager;
import android.content.Context;

public class ImageCacheConfiguration
    implements com.ebay.common.util.ImageCache.ICacheConfiguration
{

    private final Context context;

    public ImageCacheConfiguration(Context context1)
    {
        context = context1;
    }

    public int getMaxCacheSize()
    {
        return ((ActivityManager)context.getSystemService("activity")).getMemoryClass() / 8 << 20;
    }

    public int getMissingImageResource()
    {
        return 0x7f0201f5;
    }
}
