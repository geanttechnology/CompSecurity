// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.RemoteViews;
import java.text.NumberFormat;

public final class b
{

    public static RemoteViews a(Context context, android.support.v4.app.x.a a1)
    {
        boolean flag;
        if (a1.c() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context = new RemoteViews(context.getPackageName(), android.support.v7.b.a.h.notification_media_action);
        context.setImageViewResource(android.support.v7.b.a.f.action0, a1.a());
        if (!flag)
        {
            context.setOnClickPendingIntent(android.support.v7.b.a.f.action0, a1.c());
        }
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            context.setContentDescription(android.support.v7.b.a.f.action0, a1.b());
        }
        return context;
    }

    public static RemoteViews a(Context context, CharSequence charsequence, CharSequence charsequence1, CharSequence charsequence2, int i, Bitmap bitmap, CharSequence charsequence3, boolean flag, 
            long l, int j, boolean flag1)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), j);
        j = 0;
        boolean flag2 = false;
        if (bitmap != null && android.os.Build.VERSION.SDK_INT >= 16)
        {
            remoteviews.setImageViewBitmap(android.support.v7.b.a.f.icon, bitmap);
        } else
        {
            remoteviews.setViewVisibility(android.support.v7.b.a.f.icon, 8);
        }
        if (charsequence != null)
        {
            remoteviews.setTextViewText(android.support.v7.b.a.f.title, charsequence);
        }
        if (charsequence1 != null)
        {
            remoteviews.setTextViewText(android.support.v7.b.a.f.text, charsequence1);
            j = 1;
        }
        if (charsequence2 != null)
        {
            remoteviews.setTextViewText(android.support.v7.b.a.f.info, charsequence2);
            remoteviews.setViewVisibility(android.support.v7.b.a.f.info, 0);
            i = 1;
        } else
        if (i > 0)
        {
            if (i > context.getResources().getInteger(android.support.v7.b.a.g.status_bar_notification_info_maxnum))
            {
                remoteviews.setTextViewText(android.support.v7.b.a.f.info, context.getResources().getString(android.support.v7.b.a.i.status_bar_notification_info_overflow));
            } else
            {
                charsequence = NumberFormat.getIntegerInstance();
                remoteviews.setTextViewText(android.support.v7.b.a.f.info, charsequence.format(i));
            }
            remoteviews.setViewVisibility(android.support.v7.b.a.f.info, 0);
            i = 1;
        } else
        {
            remoteviews.setViewVisibility(android.support.v7.b.a.f.info, 8);
            i = j;
        }
        j = ((flag2) ? 1 : 0);
        if (charsequence3 != null)
        {
            j = ((flag2) ? 1 : 0);
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                remoteviews.setTextViewText(android.support.v7.b.a.f.text, charsequence3);
                float f;
                if (charsequence1 != null)
                {
                    remoteviews.setTextViewText(android.support.v7.b.a.f.text2, charsequence1);
                    remoteviews.setViewVisibility(android.support.v7.b.a.f.text2, 0);
                    j = 1;
                } else
                {
                    remoteviews.setViewVisibility(android.support.v7.b.a.f.text2, 8);
                    j = ((flag2) ? 1 : 0);
                }
            }
        }
        if (j != 0 && android.os.Build.VERSION.SDK_INT >= 16)
        {
            if (flag1)
            {
                f = context.getResources().getDimensionPixelSize(android.support.v7.b.a.d.notification_subtext_size);
                remoteviews.setTextViewTextSize(android.support.v7.b.a.f.text, 0, f);
            }
            remoteviews.setViewPadding(android.support.v7.b.a.f.line1, 0, 0, 0, 0);
        }
        if (l != 0L)
        {
            if (flag)
            {
                remoteviews.setViewVisibility(android.support.v7.b.a.f.chronometer, 0);
                remoteviews.setLong(android.support.v7.b.a.f.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + l);
                remoteviews.setBoolean(android.support.v7.b.a.f.chronometer, "setStarted", true);
            } else
            {
                remoteviews.setViewVisibility(android.support.v7.b.a.f.time, 0);
                remoteviews.setLong(android.support.v7.b.a.f.time, "setTime", l);
            }
        }
        j = android.support.v7.b.a.f.line3;
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        remoteviews.setViewVisibility(j, i);
        return remoteviews;
    }
}
