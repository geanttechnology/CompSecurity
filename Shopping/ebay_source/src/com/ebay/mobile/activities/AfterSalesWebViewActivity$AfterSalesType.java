// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            AfterSalesWebViewActivity

public static final class I extends Enum
{

    private static final NOT_APPLICABLE $VALUES[];
    public static final NOT_APPLICABLE CANCEL;
    public static final NOT_APPLICABLE CANCEL_ENTRY;
    public static final NOT_APPLICABLE CASE;
    public static final NOT_APPLICABLE INQUIRY;
    public static final NOT_APPLICABLE NOT_APPLICABLE;
    public static final NOT_APPLICABLE RETURN;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/mobile/activities/AfterSalesWebViewActivity$AfterSalesType, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        RETURN = new <init>("RETURN", 0);
        CASE = new <init>("CASE", 1);
        CANCEL = new <init>("CANCEL", 2);
        CANCEL_ENTRY = new <init>("CANCEL_ENTRY", 3);
        INQUIRY = new <init>("INQUIRY", 4);
        NOT_APPLICABLE = new <init>("NOT_APPLICABLE", 5);
        $VALUES = (new .VALUES[] {
            RETURN, CASE, CANCEL, CANCEL_ENTRY, INQUIRY, NOT_APPLICABLE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
