// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            AreYouSureDialogActivity

public static final class I extends Enum
{

    private static final YES_NO $VALUES[];
    public static final YES_NO OK;
    public static final YES_NO OK_CANCEL;
    public static final YES_NO YES_NO;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/mobile/activities/AreYouSureDialogActivity$DEFAULT_BUTTONS, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        OK = new <init>("OK", 0);
        OK_CANCEL = new <init>("OK_CANCEL", 1);
        YES_NO = new <init>("YES_NO", 2);
        $VALUES = (new .VALUES[] {
            OK, OK_CANCEL, YES_NO
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
