// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;


public final class NativeAssetType extends Enum
{

    private static final NativeAssetType $VALUES[];
    public static final NativeAssetType IMAGE;
    public static final NativeAssetType RICH_MEDIA;
    public static final NativeAssetType STRING;
    public static final NativeAssetType VAST_VIDEO;
    public static final NativeAssetType VIDEO;

    private NativeAssetType(String s, int i)
    {
        super(s, i);
    }

    public static NativeAssetType valueOf(String s)
    {
        return (NativeAssetType)Enum.valueOf(com/flurry/android/impl/ads/protocol/v13/NativeAssetType, s);
    }

    public static NativeAssetType[] values()
    {
        return (NativeAssetType[])$VALUES.clone();
    }

    static 
    {
        STRING = new NativeAssetType("STRING", 0);
        IMAGE = new NativeAssetType("IMAGE", 1);
        VIDEO = new NativeAssetType("VIDEO", 2);
        VAST_VIDEO = new NativeAssetType("VAST_VIDEO", 3);
        RICH_MEDIA = new NativeAssetType("RICH_MEDIA", 4);
        $VALUES = (new NativeAssetType[] {
            STRING, IMAGE, VIDEO, VAST_VIDEO, RICH_MEDIA
        });
    }
}
