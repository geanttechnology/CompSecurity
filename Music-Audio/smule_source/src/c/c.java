// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.a.f;
import com.immersion.hapticmediasdk.b;
import com.immersion.hapticmediasdk.e;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends Handler
{

    public static int b = 1;
    public static int c = 0;
    public static int d = 1;
    public static int e = 2;
    public final f a;

    public c(f f1, Looper looper)
    {
        a = f1;
        super(looper);
    }

    public static int a()
    {
        return 35;
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 6 8: default 209
    //                   6 32
    //                   7 188
    //                   8 200;
           goto _L1 _L2 _L3 _L4
_L1:
        break MISSING_BLOCK_LABEL_209;
_L2:
        int i;
        int j;
        if (f.a(a).get() != message.arg1)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        i = f.b(a).get();
        j = message.arg2;
        if (i != j)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        try
        {
            message = f.c(a);
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
            c = a();
            break;

        case 0: // '\0'
            break;
        }
        if (message.g() != b.h) goto _L6; else goto _L5
_L5:
        message = a;
        f.c(message).a(b.c);
        return;
_L6:
        f f1;
        message = a;
        f1 = a;
        try
        {
            f.a(message, f.a(f1).get(), SystemClock.uptimeMillis());
            a.e();
            return;
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
}
