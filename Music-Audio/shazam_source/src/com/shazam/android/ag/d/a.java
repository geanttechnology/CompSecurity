// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.d;

import android.content.Intent;
import android.net.Uri;
import com.shazam.android.k.i;
import com.shazam.b.b.e;
import com.shazam.n.m;
import java.util.Map;
import java.util.Set;

public class a
    implements i
{

    private static final String a = (new StringBuilder()).append(com/shazam/android/ag/d/a.getName()).append("_MARKER_AMAZON_MP3").toString();
    private static final Set b = com.shazam.b.b.e.a(new String[] {
        "http", "https"
    });
    private final Map c = com.shazam.i.e.a.a(0);
    private final i d;
    private final m e;
    private long f;

    public a(i j, m m1)
    {
        d = j;
        e = m1;
    }

    public final boolean a(Intent intent)
    {
        boolean flag1 = true;
        long l = e.b();
        if (l - f > 5000L)
        {
            c.clear();
        }
        f = l;
        if (intent == null)
        {
            return false;
        }
        Object obj = intent.getData();
        boolean flag;
        if (obj != null && "android.intent.action.VIEW".equals(intent.getAction()) && com.shazam.b.e.a.a(intent.getPackage()) && b.contains(((Uri) (obj)).getScheme()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return true;
        }
        obj = intent.getPackage();
        if (intent.getPackage() == null && "com.amazon.mp3.action.EXTERNAL_EVENT".equals(intent.getAction()) && "com.amazon.mp3.type.SHOW_TRACK_DETAIL".equals(intent.getStringExtra("com.amazon.mp3.extra.EXTERNAL_EVENT_TYPE")))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = a;
        }
        if (obj == null || !c.containsKey(obj))
        {
            boolean flag2 = d.a(intent);
            c.put(obj, Boolean.valueOf(flag2));
            return flag2;
        } else
        {
            return ((Boolean)c.get(obj)).booleanValue();
        }
    }

}
