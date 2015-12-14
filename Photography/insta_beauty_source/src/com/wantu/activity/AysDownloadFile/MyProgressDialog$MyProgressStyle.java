// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.AysDownloadFile;


public final class I extends Enum
{

    private static final STYLE_MYSPINNER $VALUES[];
    public static final STYLE_MYSPINNER STYLE_MYPROGRESS;
    public static final STYLE_MYSPINNER STYLE_MYSPINNER;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/wantu/activity/AysDownloadFile/MyProgressDialog$MyProgressStyle, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        STYLE_MYPROGRESS = new <init>("STYLE_MYPROGRESS", 0);
        STYLE_MYSPINNER = new <init>("STYLE_MYSPINNER", 1);
        $VALUES = (new .VALUES[] {
            STYLE_MYPROGRESS, STYLE_MYSPINNER
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
