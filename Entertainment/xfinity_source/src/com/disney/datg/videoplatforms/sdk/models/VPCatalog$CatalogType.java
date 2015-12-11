// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.models:
//            VPCatalog

public static final class  extends Enum
{

    private static final SCHEDULE $VALUES[];
    public static final SCHEDULE CHANNEL;
    public static final SCHEDULE SCHEDULE;
    public static final SCHEDULE VIDEO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VIDEO = new <init>("VIDEO", 0);
        CHANNEL = new <init>("CHANNEL", 1);
        SCHEDULE = new <init>("SCHEDULE", 2);
        $VALUES = (new .VALUES[] {
            VIDEO, CHANNEL, SCHEDULE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
