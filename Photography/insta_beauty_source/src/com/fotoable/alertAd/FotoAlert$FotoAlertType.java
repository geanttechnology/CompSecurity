// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.alertad;


public final class  extends Enum
{

    private static final FotoAlertFun $VALUES[];
    public static final FotoAlertFun FotoAlertApp;
    public static final FotoAlertFun FotoAlertFun;
    public static final FotoAlertFun FotoAlertNone;
    public static final FotoAlertFun FotoAlertUpdate;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/alertad/FotoAlert$FotoAlertType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FotoAlertNone = new <init>("FotoAlertNone", 0);
        FotoAlertUpdate = new <init>("FotoAlertUpdate", 1);
        FotoAlertApp = new <init>("FotoAlertApp", 2);
        FotoAlertFun = new <init>("FotoAlertFun", 3);
        $VALUES = (new .VALUES[] {
            FotoAlertNone, FotoAlertUpdate, FotoAlertApp, FotoAlertFun
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
