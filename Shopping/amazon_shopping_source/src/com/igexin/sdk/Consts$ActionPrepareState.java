// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;


// Referenced classes of package com.igexin.sdk:
//            Consts

public static final class  extends Enum
{

    private static final stop $VALUES[];
    public static final stop stop;
    public static final stop success;
    public static final stop wait;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/igexin/sdk/Consts$ActionPrepareState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        success = new <init>("success", 0);
        wait = new <init>("wait", 1);
        stop = new <init>("stop", 2);
        $VALUES = (new .VALUES[] {
            success, wait, stop
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
