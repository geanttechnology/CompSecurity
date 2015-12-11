// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.player.notification;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import atp;
import cuh;
import cui;
import cuj;
import cuq;
import cur;
import cus;
import cut;

public final class ExternalPlaybackControllerV14
    implements cuq
{

    static cur a;
    public final cur b;
    public final RemoteControlClient c;
    public android.media.RemoteControlClient.OnGetPlaybackPositionListener d;
    private final cuj e;
    private final AudioManager f;
    private final ComponentName g;
    private boolean h;
    private Bitmap i;
    private Bitmap j;

    public ExternalPlaybackControllerV14(Context context, cur cur, cuj cuj1)
    {
        b = cur;
        e = cuj1;
        f = (AudioManager)context.getSystemService("audio");
        g = new ComponentName(context.getPackageName(), com/google/android/libraries/youtube/player/notification/ExternalPlaybackControllerV14$RemoteControlIntentReceiver.getName());
        cur = new Intent("android.intent.action.MEDIA_BUTTON");
        cur.setComponent(g);
        c = new RemoteControlClient(PendingIntent.getBroadcast(context.getApplicationContext(), 0, cur, 0));
        if (atp.a >= 18)
        {
            c.setPlaybackPositionUpdateListener(new cuh(this));
        }
    }

    private static int a(boolean flag, boolean flag1)
    {
        byte byte0 = 8;
        if (flag)
        {
            byte0 = 9;
        }
        int k = byte0;
        if (flag1)
        {
            k = byte0 | 0x80;
        }
        return k;
    }

    public final void a()
    {
        if (h)
        {
            c.setTransportControlFlags(0);
            c.editMetadata(true).apply();
            f.unregisterMediaButtonEventReceiver(g);
            f.unregisterRemoteControlClient(c);
            if (e != null)
            {
                e.b(c);
            }
            h = false;
        }
        a = null;
    }

    public final void a(cus cus1)
    {
        cut cut1;
        boolean flag;
        flag = true;
        if (!h)
        {
            f.registerMediaButtonEventReceiver(g);
            f.registerRemoteControlClient(c);
            if (e != null)
            {
                e.a(c);
            }
            h = true;
        }
        a = b;
        cut1 = cus1.b;
        cui.a[cut1.ordinal()];
        JVM INSTR tableswitch 1 6: default 116
    //                   1 354
    //                   2 361
    //                   3 367
    //                   4 373
    //                   5 373
    //                   6 379;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_379;
_L1:
        int k = 1;
_L7:
        String s;
        Bitmap bitmap;
        long l1;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (atp.a >= 18 && d != null)
        {
            c.setPlaybackState(k, d.onGetPlaybackPosition(), 1.0F);
        } else
        {
            c.setPlaybackState(k);
        }
        flag1 = cus1.c;
        flag2 = cus1.d;
        flag3 = cus1.g;
        if (atp.a >= 18)
        {
            int l = a(flag1, flag2);
            k = l;
            if (flag3)
            {
                k = l;
                if (d != null)
                {
                    k = l | 0x100;
                }
            }
        } else
        {
            k = a(flag1, flag2);
        }
        c.setTransportControlFlags(k);
        s = cus1.a;
        bitmap = cus1.e;
        l1 = cus1.f;
        if (bitmap == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        cus1 = c.editMetadata(flag1);
        cus1.putString(7, s);
        k = ((flag) ? 1 : 0);
        if (j != null)
        {
            if (j.isRecycled())
            {
                k = ((flag) ? 1 : 0);
            } else
            {
                k = 0;
            }
        }
        if (bitmap != null && (!bitmap.equals(i) || k != 0))
        {
            i = bitmap;
            j = bitmap.copy(bitmap.getConfig(), false);
            cus1.putBitmap(100, j);
        }
        cus1.putLong(9, l1);
        cus1.apply();
        return;
_L2:
        k = 8;
          goto _L7
_L3:
        k = 2;
          goto _L7
_L4:
        k = 3;
          goto _L7
_L5:
        k = 1;
          goto _L7
        k = 9;
          goto _L7
    }

    public final void a(String s)
    {
    }
}
