// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;

import com.flurry.android.impl.ads.protocol.v13.NativeAssetType;

// Referenced classes of package com.flurry.android.ads:
//            FlurryAdNativeAsset

class veAssetType
{

    static final int a[];

    static 
    {
        a = new int[NativeAssetType.values().length];
        try
        {
            a[NativeAssetType.STRING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[NativeAssetType.IMAGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
