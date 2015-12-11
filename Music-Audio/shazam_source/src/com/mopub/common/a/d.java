// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mopub.common.c.a;
import java.util.Iterator;

// Referenced classes of package com.mopub.common.a:
//            a, e

public final class d
{

    final Iterable a;
    final Handler b;
    private final Looper c;
    private final android.os.Handler.Callback d = new android.os.Handler.Callback() {

        final d a;

        public final boolean handleMessage(Message message)
        {
            if (message.obj instanceof com.mopub.common.a.a)
            {
                for (Iterator iterator = a.a.iterator(); iterator.hasNext(); ((e)iterator.next()).a((com.mopub.common.a.a)message.obj)) { }
            } else
            {
                com.mopub.common.c.a.b("EventDispatcher received non-BaseEvent message type.");
            }
            return true;
        }

            
            {
                a = d.this;
                super();
            }
    };

    d(Iterable iterable, Looper looper)
    {
        a = iterable;
        c = looper;
        b = new Handler(c, d);
    }
}
