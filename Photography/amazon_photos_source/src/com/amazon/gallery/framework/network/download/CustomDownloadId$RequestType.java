// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;


// Referenced classes of package com.amazon.gallery.framework.network.download:
//            CustomDownloadId

public static final class  extends Enum
{

    private static final ASSET $VALUES[];
    public static final ASSET ASSET;
    public static final ASSET ORIGINAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/download/CustomDownloadId$RequestType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ORIGINAL = new <init>("ORIGINAL", 0);
        ASSET = new <init>("ASSET", 1);
        $VALUES = (new .VALUES[] {
            ORIGINAL, ASSET
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
