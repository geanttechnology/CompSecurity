// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aai, wy, aag, wx

public class wz
{
    public static interface a
    {

        public abstract void zzbo();
    }


    private static wz a;
    private wy b;
    private final Set c = new HashSet();
    private aai d;
    private boolean e;
    private Context f;

    wz(Context context, aai aai1)
    {
        d = null;
        f = context;
        d = aai1;
    }

    static Context a(wz wz1)
    {
        return wz1.f;
    }

    static wy a(wz wz1, wy wy1)
    {
        wz1.b = wy1;
        return wy1;
    }

    public static wz a(Context context)
    {
        x.a(context);
        if (a != null) goto _L2; else goto _L1
_L1:
        android/support/v7/wz;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new wz(context, aai.a(context.getApplicationContext()));
        }
        android/support/v7/wz;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        android/support/v7/wz;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void b(wz wz1)
    {
        wz1.c();
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a)iterator.next()).zzbo()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public wy a()
    {
        this;
        JVM INSTR monitorenter ;
        wy wy1 = b;
        this;
        JVM INSTR monitorexit ;
        return wy1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(wy wy1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IllegalStateException("Settings can't be changed after TagManager has been started");
        }
        break MISSING_BLOCK_LABEL_24;
        wy1;
        this;
        JVM INSTR monitorexit ;
        throw wy1;
        b = wy1;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        c.add(a1);
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void b()
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IllegalStateException("Method start() has already been called");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (b == null)
        {
            throw new IllegalStateException("No settings configured");
        }
        e = true;
        d.a(b.a(), -1, "admob").a(new h() {

            final wz a;

            public void a(aag aag1)
            {
                if (aag1.a().f())
                {
                    aag1 = aag1.c();
                } else
                {
                    aag1 = null;
                }
                aag1 = new wx(wz.a(a), aag1, a.a());
                wz.a(a, aag1.a());
                wz.b(a);
            }

            public void a(g g)
            {
                a((aag)g);
            }

            
            {
                a = wz.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
    }
}
