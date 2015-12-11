// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Html;
import android.widget.RemoteViews;

public final class cul
    implements cuq
{

    private final Context a;
    private final String b;
    private final Class c;
    private final int d;
    private Service e;
    private NotificationManager f;
    private Resources g;
    private String h;
    private final BroadcastReceiver i;
    private final IntentFilter j;
    private final cuk k;
    private boolean l;
    private au m;

    private cul(Context context, String s, Class class1, cur cur, int i1, cuk cuk1, Service service)
    {
        a = (Context)b.a(context);
        c = (Class)b.a(class1);
        k = (cuk)b.a(cuk1);
        b = s;
        d = i1;
        f = (NotificationManager)context.getSystemService("notification");
        g = context.getResources();
        b.a(cur);
        j = new IntentFilter();
        j.addAction("com.google.android.youtube.action.controller_notification_prev");
        j.addAction("com.google.android.youtube.action.controller_notification_play_pause");
        j.addAction("com.google.android.youtube.action.controller_notification_next");
        j.addAction("com.google.android.youtube.action.controller_notification_close");
        j.addAction("com.google.android.youtube.action.controller_notification_replay");
        i = new cum(this, cur);
    }

    public cul(Context context, String s, Class class1, cur cur, cuk cuk1, int i1)
    {
        this(context, s, class1, cur, i1, cuk1, null);
    }

    private RemoteViews a(cus cus1, boolean flag)
    {
        RemoteViews remoteviews;
        int i1;
        boolean flag1;
        int i2 = 1;
        flag1 = false;
        int k1;
        int l1;
        if (flag)
        {
            i1 = 0x7f040055;
        } else
        {
            i1 = 0x7f040057;
        }
        remoteviews = new RemoteViews(a.getPackageName(), i1);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            remoteviews.setInt(0x7f100183, "setBackgroundColor", 0xff464646);
        }
        remoteviews.setTextViewText(0x7f100072, cus1.a);
        remoteviews.setTextViewText(0x7f10018e, b);
        if (cus1.b == cut.c)
        {
            i1 = 0x7f02014e;
        } else
        {
            i1 = 0x7f02014f;
        }
        remoteviews.setImageViewResource(0x7f100188, i1);
        if (cus1.b == cut.a)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            k1 = 0;
        } else
        {
            k1 = 8;
        }
        remoteviews.setViewVisibility(0x7f100189, k1);
        if (cus1.b == cut.e)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (k1 != 0)
        {
            l1 = 0;
        } else
        {
            l1 = 8;
        }
        remoteviews.setViewVisibility(0x7f1000ce, l1);
        if (cus1.b == cut.f)
        {
            l1 = i2;
        } else
        {
            l1 = 0;
        }
        if (l1 != 0)
        {
            i2 = 0;
        } else
        {
            i2 = 8;
        }
        remoteviews.setViewVisibility(0x7f10018a, i2);
        if (i1 == 0 && k1 == 0 && l1 == 0)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        remoteviews.setViewVisibility(0x7f100188, i1);
        if (cus1.e != null)
        {
            Object obj = g;
            float f1;
            float f2;
            if (flag)
            {
                i1 = 0x7f0a0008;
            } else
            {
                i1 = 0x7f0a0006;
            }
            f1 = ((Resources) (obj)).getDimensionPixelSize(i1);
            obj = g;
            if (flag)
            {
                i1 = 0x7f0a0009;
            } else
            {
                i1 = 0x7f0a0007;
            }
            f2 = ((Resources) (obj)).getDimensionPixelSize(i1);
            obj = cus1.e;
            f1 = Math.max(f1 / (float)((Bitmap) (obj)).getWidth(), f2 / (float)((Bitmap) (obj)).getHeight());
            remoteviews.setImageViewBitmap(0x7f10008a, Bitmap.createScaledBitmap(((Bitmap) (obj)), (int)((float)((Bitmap) (obj)).getWidth() * f1), (int)(f1 * (float)((Bitmap) (obj)).getHeight()), false));
        }
        if (flag && k.b())
        {
            remoteviews.addView(0x7f1000bf, k.a());
            remoteviews.setViewVisibility(0x7f1000bf, 0);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        remoteviews.setBoolean(0x7f100187, "setEnabled", cus1.c);
        remoteviews.setBoolean(0x7f100098, "setEnabled", cus1.d);
        if (cus1.c)
        {
            i1 = 0x7f020150;
        } else
        {
            i1 = 0x7f020151;
        }
        remoteviews.setImageViewResource(0x7f100187, i1);
        if (cus1.d)
        {
            i1 = 0x7f02014c;
        } else
        {
            i1 = 0x7f02014d;
        }
        remoteviews.setImageViewResource(0x7f100098, i1);
_L4:
        if (flag)
        {
            a(remoteviews, 0x7f100187, "com.google.android.youtube.action.controller_notification_prev");
        }
        a(remoteviews, 0x7f100188, "com.google.android.youtube.action.controller_notification_play_pause");
        a(remoteviews, 0x7f100098, "com.google.android.youtube.action.controller_notification_next");
        a(remoteviews, 0x7f1000ce, "com.google.android.youtube.action.controller_notification_replay");
        a(remoteviews, 0x7f100185, "com.google.android.youtube.action.controller_notification_close");
        return remoteviews;
_L2:
        int j1;
        if (cus1.d)
        {
            j1 = ((flag1) ? 1 : 0);
        } else
        {
            j1 = 8;
        }
        remoteviews.setViewVisibility(0x7f100098, j1);
        if (h != null)
        {
            remoteviews.setTextViewText(0x7f10018e, Html.fromHtml(h));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(RemoteViews remoteviews, int i1, String s)
    {
        remoteviews.setOnClickPendingIntent(i1, PendingIntent.getBroadcast(a, 0, new Intent(s), 0x8000000));
    }

    public final void a()
    {
        if (e != null)
        {
            e.stopForeground(true);
        } else
        {
            f.cancel(2);
        }
        if (l)
        {
            a.unregisterReceiver(i);
            l = false;
        }
    }

    public final void a(cus cus1)
    {
        RemoteViews remoteviews1 = a(cus1, false);
        RemoteViews remoteviews = a(cus1, true);
        cus1 = cus1.a;
        if (m == null)
        {
            Intent intent = new Intent(a, c);
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(0x4000000);
            au au2 = new au(a);
            int i1 = d;
            au2.i.icon = i1;
            Notification notification = au2.i;
            notification.flags = notification.flags | 2;
            au2.b = PendingIntent.getActivity(a, 0, intent, 0x8000000);
            au2.h = 1;
            m = au2;
        }
        au au1 = m;
        au1.i.contentView = remoteviews1;
        cus1 = au1.a(cus1);
        cus1 = aq.a().a(cus1);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            cus1.bigContentView = remoteviews;
        }
        if (e != null)
        {
            e.startForeground(2, cus1);
        } else
        {
            f.notify(2, cus1);
        }
        if (!l)
        {
            a.registerReceiver(i, j);
            l = true;
        }
    }

    public final void a(String s)
    {
        h = s;
    }
}
