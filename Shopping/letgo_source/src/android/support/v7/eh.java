// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package android.support.v7:
//            ajx

public class eh extends ajx
{

    private final Handler a = new Handler(Looper.getMainLooper());

    public eh()
    {
    }

    static void a(eh eh1, Object obj)
    {
        eh1.ajx.a(obj);
    }

    public void a(Object obj)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            super.a(obj);
            return;
        } else
        {
            a.post(new Runnable(obj) {

                final Object a;
                final eh b;

                public void run()
                {
                    eh.a(b, a);
                }

            
            {
                b = eh.this;
                a = obj;
                super();
            }
            });
            return;
        }
    }
}
