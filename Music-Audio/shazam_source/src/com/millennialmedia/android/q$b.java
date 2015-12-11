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

private static final class <init>
{

    ar a;

    public final boolean a()
    {
        if (a == null)
        {
            return false;
        } else
        {
            .a(new Runnable() {

                final q.b a;

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
                                ar1.a(ar.e.d);
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
                                ar1.a(ar.e.d);
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
                    b1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                a = q.b.this;
                super();
            }
            });
            return true;
        }
    }

    private _cls1.a()
    {
    }

    _cls1.a(byte byte0)
    {
        this();
    }
}
