// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TadvertiseUtil

class versionCode
{

    private String appname;
    private Drawable icon;
    private String pname;
    private int versionCode;
    private String versionName;

    private void prettyPrint()
    {
        TadvertiseUtil.logMessage(null, 3, (new StringBuilder()).append(appname).append("\t ").append(pname).append("\t ").append(versionName).append("\t ").append(versionCode).toString());
    }

    public String getappname()
    {
        return appname;
    }

    public String getpname()
    {
        return pname;
    }

    public int getversionCode()
    {
        return versionCode;
    }

    public String getversionName()
    {
        return versionName;
    }



/*
    static String access$302( , String s)
    {
        .appname = s;
        return s;
    }

*/


/*
    static String access$402(appname appname1, String s)
    {
        appname1.pname = s;
        return s;
    }

*/


/*
    static String access$502(pname pname1, String s)
    {
        pname1.versionName = s;
        return s;
    }

*/


/*
    static int access$602(versionName versionname, int i)
    {
        versionname.versionCode = i;
        return i;
    }

*/


/*
    static Drawable access$702(versionCode versioncode, Drawable drawable)
    {
        versioncode.icon = drawable;
        return drawable;
    }

*/

    icon()
    {
        appname = "";
        pname = "";
        versionName = "";
        versionCode = 0;
    }
}
