// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.c;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            be, cj, bz, s, 
//            bu

public class ay extends be
{

    private final Map a;
    private final Context b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public ay(cj cj1, Map map)
    {
        super(cj1, "createCalendarEvent");
        a = map;
        b = cj1.c();
        c();
    }

    static Context a(ay ay1)
    {
        return ay1.b;
    }

    private String a(String s1)
    {
        if (TextUtils.isEmpty((CharSequence)a.get(s1)))
        {
            return "";
        } else
        {
            return (String)a.get(s1);
        }
    }

    private void c()
    {
        c = a("description");
        f = a("summary");
        d = e("start_ticks");
        e = e("end_ticks");
        g = a("location");
    }

    private long e(String s1)
    {
        s1 = (String)a.get(s1);
        if (s1 == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return -1L;
        }
        return l;
    }

    public void a()
    {
        if (b == null)
        {
            b("Activity context is not available.");
            return;
        }
        if (!com.google.android.gms.ads.internal.c.c().c(b).f())
        {
            b("This feature is not available on the device.");
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = com.google.android.gms.ads.internal.c.c().b(b);
            builder.setTitle(com.google.android.gms.ads.internal.c.f().a(com.google.android.gms.a.a.create_calendar_title, "Create calendar event"));
            builder.setMessage(com.google.android.gms.ads.internal.c.f().a(com.google.android.gms.a.a.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(com.google.android.gms.ads.internal.c.f().a(com.google.android.gms.a.a.accept, "Accept"), new _cls1());
            builder.setNegativeButton(com.google.android.gms.ads.internal.c.f().a(com.google.android.gms.a.a.decline, "Decline"), new _cls2());
            builder.create().show();
            return;
        }
    }

    Intent b()
    {
        Intent intent = (new Intent("android.intent.action.EDIT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
        intent.putExtra("title", c);
        intent.putExtra("eventLocation", g);
        intent.putExtra("description", f);
        if (d > -1L)
        {
            intent.putExtra("beginTime", d);
        }
        if (e > -1L)
        {
            intent.putExtra("endTime", e);
        }
        intent.setFlags(0x10000000);
        return intent;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
