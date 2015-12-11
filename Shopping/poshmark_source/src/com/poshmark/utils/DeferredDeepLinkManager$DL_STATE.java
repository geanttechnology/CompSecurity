// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            DeferredDeepLinkManager

public static final class _cls9 extends Enum
{

    private static final DL_EXPIRED $VALUES[];
    public static final DL_EXPIRED DL_CONSUMED;
    public static final DL_EXPIRED DL_EXPIRED;
    public static final DL_EXPIRED DL_RECEIVED;
    public static final DL_EXPIRED DL_REQUESTED;
    public static final DL_EXPIRED INIT;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/poshmark/utils/DeferredDeepLinkManager$DL_STATE, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        DL_REQUESTED = new <init>("DL_REQUESTED", 1);
        DL_RECEIVED = new <init>("DL_RECEIVED", 2);
        DL_CONSUMED = new <init>("DL_CONSUMED", 3);
        DL_EXPIRED = new <init>("DL_EXPIRED", 4);
        $VALUES = (new .VALUES[] {
            INIT, DL_REQUESTED, DL_RECEIVED, DL_CONSUMED, DL_EXPIRED
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
