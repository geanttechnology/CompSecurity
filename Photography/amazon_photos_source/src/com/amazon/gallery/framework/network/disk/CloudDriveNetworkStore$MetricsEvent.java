// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.disk;


// Referenced classes of package com.amazon.gallery.framework.network.disk:
//            CloudDriveNetworkStore

public static final class  extends Enum
{

    private static final LoadContent $VALUES[];
    public static final LoadContent LoadContent;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/disk/CloudDriveNetworkStore$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LoadContent = new <init>("LoadContent", 0);
        $VALUES = (new .VALUES[] {
            LoadContent
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
