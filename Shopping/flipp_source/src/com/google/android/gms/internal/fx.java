// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.a;

// Referenced classes of package com.google.android.gms.internal:
//            fw, fy, ge

final class fx extends Handler
{

    final fw a;

    public fx(fw fw1, Looper looper)
    {
        a = fw1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 1 && !a.f())
        {
            ((fy)message.obj).b();
            return;
        }
        synchronized (fw.b(a))
        {
            a.d = false;
        }
        if (message.what == 3)
        {
            com.google.android.gms.internal.fw.a(a).a(new a(((Integer)message.obj).intValue(), null));
            return;
        }
        break MISSING_BLOCK_LABEL_91;
        message;
        obj;
        JVM INSTR monitorexit ;
        throw message;
        if (message.what == 4)
        {
            ge ge1 = com.google.android.gms.internal.fw.a(a);
            ((Integer)message.obj).intValue();
            ge1.a();
            return;
        }
        if (message.what == 2 && !a.e())
        {
            ((fy)message.obj).b();
            return;
        }
        if (message.what == 2 || message.what == 1)
        {
            ((fy)message.obj).a();
            return;
        } else
        {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
            return;
        }
    }
}
