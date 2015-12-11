// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;


// Referenced classes of package com.xfinity.playerlib.model.downloads:
//            PlayerDownloadFile

public static final class  extends Enum
{

    private static final AAW_EXPIRED $VALUES[];
    public static final AAW_EXPIRED AAW_EXPIRED;
    public static final AAW_EXPIRED NOT_EXPIRED;
    public static final AAW_EXPIRED OVP_EXPIRED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_EXPIRED = new <init>("NOT_EXPIRED", 0);
        OVP_EXPIRED = new <init>("OVP_EXPIRED", 1);
        AAW_EXPIRED = new <init>("AAW_EXPIRED", 2);
        $VALUES = (new .VALUES[] {
            NOT_EXPIRED, OVP_EXPIRED, AAW_EXPIRED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
