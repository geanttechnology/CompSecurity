// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.barcodereader;


// Referenced classes of package com.digimarc.dms.barcodereader:
//            PayoffHandler

public static final class  extends Enum
{

    private static final EMAIL $VALUES[];
    public static final EMAIL BRIGHTCOVE;
    public static final EMAIL DIAL;
    public static final EMAIL EMAIL;
    public static final EMAIL SMS;
    public static final EMAIL VIDEO;
    public static final EMAIL WEB;
    public static final EMAIL WIFI;
    public static final EMAIL YOUTUBE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/barcodereader/PayoffHandler$PayoffType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        WEB = new <init>("WEB", 0);
        VIDEO = new <init>("VIDEO", 1);
        YOUTUBE = new <init>("YOUTUBE", 2);
        SMS = new <init>("SMS", 3);
        DIAL = new <init>("DIAL", 4);
        WIFI = new <init>("WIFI", 5);
        BRIGHTCOVE = new <init>("BRIGHTCOVE", 6);
        EMAIL = new <init>("EMAIL", 7);
        $VALUES = (new .VALUES[] {
            WEB, VIDEO, YOUTUBE, SMS, DIAL, WIFI, BRIGHTCOVE, EMAIL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
