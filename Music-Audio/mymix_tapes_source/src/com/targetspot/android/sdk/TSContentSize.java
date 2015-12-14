// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public final class TSContentSize extends Enum
{

    private static final TSContentSize $VALUES[];
    public static final TSContentSize TSContentSizeDefault;
    public static final TSContentSize TSContentSizeLarge;
    public static final TSContentSize TSContentSizeMedium;
    public static final TSContentSize TSContentSizeSmall;
    private final int contentSize;

    private TSContentSize(String s, int i, int j)
    {
        super(s, i);
        contentSize = j;
    }

    public static TSContentSize valueOf(String s)
    {
        return (TSContentSize)Enum.valueOf(com/targetspot/android/sdk/TSContentSize, s);
    }

    public static TSContentSize[] values()
    {
        return (TSContentSize[])$VALUES.clone();
    }

    public int getContentSize()
    {
        return contentSize;
    }

    static 
    {
        TSContentSizeDefault = new TSContentSize("TSContentSizeDefault", 0, 0);
        TSContentSizeSmall = new TSContentSize("TSContentSizeSmall", 1, 1);
        TSContentSizeMedium = new TSContentSize("TSContentSizeMedium", 2, 2);
        TSContentSizeLarge = new TSContentSize("TSContentSizeLarge", 3, 3);
        $VALUES = (new TSContentSize[] {
            TSContentSizeDefault, TSContentSizeSmall, TSContentSizeMedium, TSContentSizeLarge
        });
    }
}
