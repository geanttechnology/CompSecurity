// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;


// Referenced classes of package com.inmobi.signals:
//            LocationInfo

public static final class  extends Enum
{

    private static final UNDETERMINED $VALUES[];
    public static final UNDETERMINED AUTHORISED;
    public static final UNDETERMINED DENIED;
    public static final UNDETERMINED UNDETERMINED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/signals/LocationInfo$LocationConsentStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUTHORISED = new <init>("AUTHORISED", 0);
        DENIED = new <init>("DENIED", 1);
        UNDETERMINED = new <init>("UNDETERMINED", 2);
        $VALUES = (new .VALUES[] {
            AUTHORISED, DENIED, UNDETERMINED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
