// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.offerup.android.utils.d;
import java.util.ArrayList;

public final class a
{

    private static a b;
    private SharedPreferences a;
    private Context c;

    private a(Context context)
    {
        c = context.getApplicationContext();
        a = c.getSharedPreferences("ASYNC_IMAGE_UTILS", 0);
    }

    public static a a(Context context)
    {
        com/b/a/a/a;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new a(context.getApplicationContext());
        }
        context = b;
        com/b/a/a/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private static String a(Long long1, int i)
    {
        if (long1 == null)
        {
            long1 = "create";
        } else
        {
            long1 = "update";
        }
        return String.format("%s::%d", new Object[] {
            long1, Integer.valueOf(i)
        });
    }

    public final d a(Long long1)
    {
        d d1 = new d(c, long1);
        ArrayList arraylist = new ArrayList(com.offerup.android.c.a.a());
        for (int i = 0; i < com.offerup.android.c.a.a(); i++)
        {
            String s = a(long1, i);
            s = a.getString(s, "invalid");
            if (!s.equals("invalid"))
            {
                arraylist.add(Uri.parse(s));
            }
        }

        d1.a(arraylist);
        return d1;
    }

    public final void a()
    {
        android.content.SharedPreferences.Editor editor = a.edit();
        editor.clear();
        editor.apply();
    }

    public final void a(d d1)
    {
        android.content.SharedPreferences.Editor editor = a.edit();
        editor.clear();
        ArrayList arraylist = d1.b();
        d1 = d1.f();
        int i = 0;
        while (i < arraylist.size()) 
        {
            String s = a(((Long) (d1)), i);
            Uri uri = (Uri)arraylist.get(i);
            if (uri == null)
            {
                editor.putString(s, "invalid");
            } else
            {
                editor.putString(s, uri.toString());
            }
            i++;
        }
        editor.apply();
    }
}
