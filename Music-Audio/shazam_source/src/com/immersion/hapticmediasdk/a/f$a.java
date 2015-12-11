// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.d;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            f, c

private final class a extends Handler
{

    public static int b = 1;
    public static int c = 0;
    public static int d = 1;
    public static int e = 2;
    public final f a;

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 6 8: default 390
    //                   6 32
    //                   7 369
    //                   8 381;
           goto _L1 _L2 _L3 _L4
_L1:
        break MISSING_BLOCK_LABEL_390;
_L2:
        Object obj;
        int i;
        if (f.a(a).get() != message.arg1)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        obj = a;
        i = f.g;
        (i * (f.i + i)) % f.j;
        JVM INSTR tableswitch 0 0: default 391
    //                   0 98;
           goto _L5 _L6
_L5:
        f.g = 31;
        f.h = 73;
_L6:
        int j;
        i = ((f) (obj)).b.get();
        j = message.arg2;
        if (i != j)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        try
        {
            message = f.b(a);
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            throw message;
        }
        i = b;
        switch ((i * (d + i)) % e)
        {
        default:
            b = 55;
            c = 35;
            break;

        case 0: // '\0'
            break;
        }
        if (message.c() != com.immersion.hapticmediasdk.h) goto _L8; else goto _L7
_L7:
        message = a;
        f.b(message).a(com.immersion.hapticmediasdk.c);
        return;
_L8:
        obj = a;
        message = a;
        long l;
        j = f.a(message).get();
        l = SystemClock.uptimeMillis();
        i = f.g;
        (i * (f.i + i)) % f.j;
        JVM INSTR tableswitch 0 0: default 394
    //                   0 266;
           goto _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_266;
_L9:
        f.g = 79;
        f.h = 74;
        obj = ((f) (obj)).d;
        if (((f.g + f.i) * f.g) % f.j != f.h)
        {
            f.g = 10;
            f.h = 4;
        }
        ((c) (obj)).d();
        ((c) (obj)).a.removeMessages(2);
        message = new Bundle();
        message.putInt("playback_timecode", j);
        message.putLong("playback_uptime", l);
        ((c) (obj)).a.obtainMessage(2);
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Message message) { }
        try
        {
            c.i = 75;
            do
            {
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Message message) { }
        try
        {
            throw message;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            throw message;
        }
_L3:
        f.a(a, message.arg1);
        return;
_L4:
        f.a(a, message);
        return;
    }

    public nteger(f f1, Looper looper)
    {
        a = f1;
        super(looper);
    }
}
