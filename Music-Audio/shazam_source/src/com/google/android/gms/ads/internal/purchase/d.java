// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.ge;
import com.google.android.gms.d.gm;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d extends com.google.android.gms.d.el.a
{

    private String a;
    private Context b;
    private String c;
    private ArrayList d;

    public d(String s, ArrayList arraylist, Context context, String s1)
    {
        c = s;
        d = arraylist;
        a = s1;
        b = context;
    }

    private String a(String s, HashMap hashmap)
    {
        String s1 = b.getPackageName();
        Object obj;
        long l;
        long l1;
        try
        {
            obj = b.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            obj = "";
        }
        l = p.h().b().b;
        l1 = SystemClock.elapsedRealtime();
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext();)
        {
            String s2 = (String)iterator.next();
            s = s.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
                s2
            }), String.format("$1%s$2", new Object[] {
                hashmap.get(s2)
            }));
        }

        return s.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "sessionid"
        }), String.format("$1%s$2", new Object[] {
            p.h().b
        })).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "appid"
        }), String.format("$1%s$2", new Object[] {
            s1
        })).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "osversion"
        }), String.format("$1%s$2", new Object[] {
            String.valueOf(android.os.Build.VERSION.SDK_INT)
        })).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "sdkversion"
        }), String.format("$1%s$2", new Object[] {
            a
        })).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "appversion"
        }), String.format("$1%s$2", new Object[] {
            obj
        })).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "timestamp"
        }), String.format("$1%s$2", new Object[] {
            String.valueOf(l1 - l)
        })).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {
            "[^@]+"
        }), String.format("$1%s$2", new Object[] {
            ""
        })).replaceAll("@@", "@");
    }

    private void b()
    {
        try
        {
            b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[] {
                android/content/Context, java/lang/String, java/lang/String, Boolean.TYPE
            }).invoke(null, new Object[] {
                b, c, "", Boolean.valueOf(true)
            });
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final String a()
    {
        return c;
    }

    public final void a(int i)
    {
        if (i == 1)
        {
            b();
        }
        HashMap hashmap = new HashMap();
        hashmap.put("status", String.valueOf(i));
        hashmap.put("sku", c);
        LinkedList linkedlist = new LinkedList();
        for (Iterator iterator = d.iterator(); iterator.hasNext(); linkedlist.add(a((String)iterator.next(), hashmap))) { }
        p.e();
        gm.a(b, a, linkedlist);
    }

    public final void b(int i)
    {
        boolean flag = true;
        if (i == 0)
        {
            b();
        }
        HashMap hashmap = new HashMap();
        hashmap.put("google_play_status", String.valueOf(i));
        hashmap.put("sku", c);
        LinkedList linkedlist;
        if (i == 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        if (i == 1)
        {
            i = 2;
        } else
        if (i == 4)
        {
            i = 3;
        } else
        {
            i = 0;
        }
        hashmap.put("status", String.valueOf(i));
        linkedlist = new LinkedList();
        for (Iterator iterator = d.iterator(); iterator.hasNext(); linkedlist.add(a((String)iterator.next(), hashmap))) { }
        p.e();
        gm.a(b, a, linkedlist);
    }
}
