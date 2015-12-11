// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            qu, ul, tp, nf, 
//            tg

public class qn extends qu
{

    private final Map a;
    private final Context b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public qn(ul ul1, Map map)
    {
        super(ul1, "createCalendarEvent");
        a = map;
        b = ul1.c();
        c();
    }

    static Context a(qn qn1)
    {
        return qn1.b;
    }

    private String a(String s)
    {
        if (TextUtils.isEmpty((CharSequence)a.get(s)))
        {
            return "";
        } else
        {
            return (String)a.get(s);
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

    private long e(String s)
    {
        s = (String)a.get(s);
        if (s == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
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
        if (!zzp.zzbx().e(b).f())
        {
            b("This feature is not available on the device.");
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = zzp.zzbx().d(b);
            builder.setTitle(zzp.zzbA().a(ks.b.create_calendar_title, "Create calendar event"));
            builder.setMessage(zzp.zzbA().a(ks.b.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(zzp.zzbA().a(ks.b.accept, "Accept"), new android.content.DialogInterface.OnClickListener() {

                final qn a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = a.b();
                    qn.a(a).startActivity(dialoginterface);
                }

            
            {
                a = qn.this;
                super();
            }
            });
            builder.setNegativeButton(zzp.zzbA().a(ks.b.decline, "Decline"), new android.content.DialogInterface.OnClickListener() {

                final qn a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.b("Operation denied by user.");
                }

            
            {
                a = qn.this;
                super();
            }
            });
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
}
