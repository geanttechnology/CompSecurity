// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAEnums

public static final class _cls9 extends Enum
{

    private static final Controller $VALUES[];
    public static final Controller Controller;
    public static final Controller Device;
    public static final Controller None;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$BackButtonState, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Device = new <init>("Device", 1);
        Controller = new <init>("Controller", 2);
        $VALUES = (new .VALUES[] {
            None, Device, Controller
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
