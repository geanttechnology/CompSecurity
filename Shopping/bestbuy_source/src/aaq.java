// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class aaq extends abn
{

    private final aab a;
    private final fj b;
    private final abe c;
    private final aar d;
    private final Object e;
    private Future f;

    aaq(abe abe1, aab aab, aar aar1)
    {
        e = new Object();
        c = abe1;
        b = abe1.b;
        a = aab;
        d = aar1;
    }

    public aaq(Context context, ahi ahi, st st, abe abe1, aab aab)
    {
        this(abe1, aab, new aar(context, ahi, st, new abw(), abe1));
    }

    static aab a(aaq aaq1)
    {
        return aaq1.a;
    }

    private abd a(int i)
    {
        return new abd(c.a.c, null, null, i, null, null, b.l, b.k, c.a.i, false, null, null, null, null, null, b.i, c.d, b.g, c.f, b.n, b.o, c.h, null);
    }

    public void a()
    {
        synchronized (e)
        {
            f = abp.a(d);
        }
        obj = (abd)f.get(60000L, TimeUnit.MILLISECONDS);
        byte byte0 = -2;
_L1:
        if (obj == null)
        {
            obj = a(byte0);
        }
        aca.a.post(new Runnable(((abd) (obj))) {

            final abd a;
            final aaq b;

            public void run()
            {
                aaq.a(b).a(a);
            }

            
            {
                b = aaq.this;
                a = abd1;
                super();
            }
        });
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            acb.e("Timed out waiting for native ad.");
            byte0 = 2;
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            byte0 = 0;
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            byte0 = -1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            byte0 = -1;
        }
          goto _L1
    }

    public void b()
    {
        synchronized (e)
        {
            if (f != null)
            {
                f.cancel(true);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
