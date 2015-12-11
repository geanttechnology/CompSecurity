// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;


// Referenced classes of package com.poshmark.utils.sharing:
//            PM_State_Machine

public static final class I extends Enum
{

    private static final CANCEL $VALUES[];
    public static final CANCEL CANCEL;
    public static final CANCEL FAILED;
    public static final CANCEL OK;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        OK = new <init>("OK", 0);
        FAILED = new <init>("FAILED", 1);
        CANCEL = new <init>("CANCEL", 2);
        $VALUES = (new .VALUES[] {
            OK, FAILED, CANCEL
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
