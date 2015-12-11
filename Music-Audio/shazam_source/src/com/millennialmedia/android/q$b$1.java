// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechKit;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            q, ar, al

final class a
    implements Runnable
{

    final a a;

    public final void run()
    {
        synchronized (a)
        {
            if (a.a != null)
            {
                ar ar1 = a.a;
                if (ar1.g != null)
                {
                    al.b();
                    ar1.g.cancel();
                    ar1.g = null;
                    ar1.a();
                }
                ar1 = a.a;
                al.b();
                ar1.c();
                if (ar1.e != null)
                {
                    ar1.e.removeCallbacks(ar1.k);
                    ar1.e.removeCallbacks(ar1.l);
                }
                if (ar1.d != null)
                {
                    ar1.d.release();
                    ar1.a();
                    ar1.d = null;
                }
                ar1.j = null;
                if (ar1.a() != null)
                {
                    ar1.a.clear();
                }
                a.a = null;
            }
        }
        return;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    t(t t)
    {
        a = t;
        super();
    }
}
