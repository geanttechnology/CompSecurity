// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.smule.android.c.aa;
import com.smule.android.notifications.AlarmReceiver;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import java.util.Calendar;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.e:
//            h, g

public class f
{

    private static final String a = com/smule/pianoandroid/e/f.getName();
    private static f c;
    private Context b;

    private f()
    {
        b = MagicApplication.getContext();
    }

    private Intent a(h h1, int i)
    {
        Intent intent = new Intent(b, com/smule/android/notifications/AlarmReceiver);
        intent.setData(Uri.parse((new StringBuilder()).append("blah://").append(i).toString()));
        intent.putExtra("DESTINATION_URI", h.b(h1));
        intent.putExtra("MESSAGE", h.c(h1));
        intent.putExtra("HEADER", h.d(h1));
        intent.putExtra("PARAMS", "{\"react_local\":true}");
        return intent;
    }

    public static f a()
    {
        if (c == null)
        {
            c = new f();
        }
        return c;
    }

    private void a(g g1)
    {
        AlarmManager alarmmanager = (AlarmManager)b.getSystemService("alarm");
        List list = h.a(b);
        if (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); i++)
            {
                Object obj = a((h)list.get(i), i);
                obj = PendingIntent.getBroadcast(b, i + 323, ((Intent) (obj)), 0);
                g1.a(alarmmanager, (h)list.get(i), ((PendingIntent) (obj)));
            }

        }
    }

    static String d()
    {
        return a;
    }

    public void b()
    {
        a(new g() {

            final f a;

            public void a(AlarmManager alarmmanager, h h1, PendingIntent pendingintent)
            {
                alarmmanager.cancel(pendingintent);
                aa.a(f.d(), (new StringBuilder()).append("Schedule alarm for ").append(h1).toString());
                alarmmanager.set(0, h.a(h1).getTimeInMillis(), pendingintent);
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

    public void c()
    {
        a(new g() {

            final f a;

            public void a(AlarmManager alarmmanager, h h1, PendingIntent pendingintent)
            {
                aa.a(f.d(), (new StringBuilder()).append("Remove alarm for ").append(h1).toString());
                alarmmanager.cancel(pendingintent);
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

}
