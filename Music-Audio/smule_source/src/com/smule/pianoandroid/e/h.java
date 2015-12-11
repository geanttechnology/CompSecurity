// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.Context;
import android.content.res.Resources;
import com.smule.android.c.aa;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.e:
//            f

class h
{

    private Calendar a;
    private String b;
    private String c;
    private String d;

    public h(String s, String s1, String s2, String s3)
    {
        a = Calendar.getInstance();
        if (s.endsWith("d"))
        {
            a.add(10, Integer.parseInt(s.substring(0, s.length() - 1)) * 24);
            a.set(11, 18);
            a.set(12, 0);
            a.set(13, 0);
        } else
        if (s.endsWith("m"))
        {
            a.add(12, Integer.parseInt(s.substring(0, s.length() - 1)));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad time parameter ").append(s).toString());
        }
        b = s1;
        c = s2;
        d = s3;
    }

    static Calendar a(h h1)
    {
        return h1.a;
    }

    public static List a(Context context)
    {
        String as[] = context.getResources().getStringArray(0x7f060003);
        String as1[] = context.getResources().getStringArray(0x7f060004);
        String as2[] = context.getResources().getStringArray(0x7f060001);
        context = context.getResources().getStringArray(0x7f060002);
        if (as.length != as1.length || as.length != context.length || as1.length != context.length)
        {
            aa.b(f.d(), (new StringBuilder()).append("Local notifications time (").append(as.length).append("), URIs (").append(as1.length).append(") and messages (").append(context.length).append(") are different").toString());
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList(as.length);
        for (int i = 0; i < as.length; i++)
        {
            aa.a(f.d(), (new StringBuilder()).append("Adding new schedule ").append(i).toString());
            arraylist.add(i, new h(as[i], as1[i], as2[i], context[i]));
        }

        return arraylist;
    }

    static String b(h h1)
    {
        return h1.b;
    }

    static String c(h h1)
    {
        return h1.d;
    }

    static String d(h h1)
    {
        return h1.c;
    }

    public String toString()
    {
        return (new StringBuilder()).append("NotificationSchedule(when=").append(a).append(";uri=").append(b).append(";header=").append(c).append(";message=").append(d).append(")").toString();
    }
}
