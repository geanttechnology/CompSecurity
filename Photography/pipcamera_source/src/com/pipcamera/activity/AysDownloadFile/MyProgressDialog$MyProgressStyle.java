// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.AysDownloadFile;


public final class  extends Enum
{

    private static final STYLE_MYSPINNER $VALUES[];
    public static final STYLE_MYSPINNER STYLE_MYPROGRESS;
    public static final STYLE_MYSPINNER STYLE_MYSPINNER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pipcamera/activity/AysDownloadFile/MyProgressDialog$MyProgressStyle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STYLE_MYPROGRESS = new <init>("STYLE_MYPROGRESS", 0);
        STYLE_MYSPINNER = new <init>("STYLE_MYSPINNER", 1);
        $VALUES = (new .VALUES[] {
            STYLE_MYPROGRESS, STYLE_MYSPINNER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
