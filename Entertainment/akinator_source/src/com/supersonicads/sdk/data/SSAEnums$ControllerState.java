// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAEnums

public static final class _cls9 extends Enum
{

    private static final Failed $VALUES[];
    public static final Failed Failed;
    public static final Failed FailedToDownload;
    public static final Failed FailedToLoad;
    public static final Failed Loaded;
    public static final Failed None;
    public static final Failed Ready;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$ControllerState, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        FailedToDownload = new <init>("FailedToDownload", 1);
        FailedToLoad = new <init>("FailedToLoad", 2);
        Loaded = new <init>("Loaded", 3);
        Ready = new <init>("Ready", 4);
        Failed = new <init>("Failed", 5);
        $VALUES = (new .VALUES[] {
            None, FailedToDownload, FailedToLoad, Loaded, Ready, Failed
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
