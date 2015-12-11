// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.g;

import java.util.ArrayList;

public class i
{

    public static final String a = "embed";
    public static final String b = "adslot";
    public static final String c = "adslot";
    public static final String d = "impression";
    public static final String e = "accept";
    public static final String f = "clickthru";
    public static final String g = "view";
    public static final String h = "mute";
    public static final String i = "unmute";
    public static final String j = "minimize";
    public static final String k = "maximize";
    public static final String l = "pause";
    public static final String m = "resume";
    public static final String n = "close";
    public static final String o = "fullscreen";
    public static final String p = "leaveFullscreen";
    public static final String q = "error";
    public static final String r = "skip";
    public String s;
    public int t;
    public ArrayList u;

    public i(String s1)
    {
        u = new ArrayList();
        s = s1;
    }

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder(String.valueOf(s));
        Object obj;
        if (t > 0)
        {
            obj = Integer.valueOf(t);
        } else
        {
            obj = "";
        }
        return stringbuilder.append(obj).toString();
    }
}
