// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.b;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            ge, gg

final class gf extends Handler
{

    final ge a;

    public gf(ge ge1, Looper looper)
    {
        a = ge1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            synchronized (a.b)
            {
                if (a.a.j() && a.a.e() && a.b.contains(message.obj))
                {
                    ((b)message.obj).a();
                }
            }
            return;
        } else
        {
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
            return;
        }
        message;
        arraylist;
        JVM INSTR monitorexit ;
        throw message;
    }
}
