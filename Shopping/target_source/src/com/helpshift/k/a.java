// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.k;

import android.util.Log;
import com.helpshift.i.h;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{

    public static String a = "HelpShiftDebug";
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public Boolean i;
    public Boolean j;
    public Boolean k;
    public String l;

    public a(String s, String s1, String s2, String s3, String s4, Boolean boolean1, String s5, 
            int i1, Boolean boolean2, String s6)
    {
        i = Boolean.valueOf(true);
        j = Boolean.valueOf(false);
        k = Boolean.valueOf(false);
        l = "";
        g = s;
        b = s1;
        c = s2;
        j = boolean1;
        h = s5;
        f = i1;
        k = boolean2;
        d = s3;
        if (s2.equals("admin") && !s6.equals(""))
        {
            l = (new StringBuilder()).append(s6).append(", ").toString();
        }
        s = new Date();
        s1 = h.d.parse(s4);
        s = s1;
_L2:
        e = (new StringBuilder()).append(l).append(h.e.format(s)).toString();
        return;
        s1;
        Log.d(a, s1.toString(), s1);
        if (true) goto _L2; else goto _L1
_L1:
    }

}
