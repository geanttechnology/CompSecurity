// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.paypal.android.sdk:
//            cg, cj, ck, bl, 
//            bk

public class cf extends Thread
{

    private final ck a;
    private final List b = Collections.synchronizedList(new LinkedList());
    private boolean c;
    private final cg d;

    public cf(ck ck1, cg cg1)
    {
        a = ck1;
        d = cg1;
        start();
    }

    public final void a()
    {
        if (!c)
        {
            d.a();
            c = true;
            synchronized (b)
            {
                b.notifyAll();
            }
            interrupt();
            while (isAlive()) 
            {
                try
                {
                    Thread.sleep(10L);
                    (new StringBuilder("Waiting for ")).append(getClass().getSimpleName()).append(" to die");
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(cj cj1)
    {
        synchronized (b)
        {
            b.add(cj1);
            (new StringBuilder("Queued ")).append(cj1.n());
            b.notifyAll();
        }
        return;
        cj1;
        list;
        JVM INSTR monitorexit ;
        throw cj1;
    }

    public void run()
    {
        (new StringBuilder("Starting ")).append(getClass().getSimpleName());
_L3:
        if (c)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        List list = b;
        list;
        JVM INSTR monitorenter ;
        boolean flag = b.isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        b.wait();
        Object obj = null;
_L1:
        list;
        JVM INSTR monitorexit ;
        if (obj != null)
        {
            try
            {
                ((cj) (obj)).a(((cj) (obj)).b());
            }
            catch (JSONException jsonexception)
            {
                Log.e("paypal.sdk", "Exception computing request", jsonexception);
                ((cj) (obj)).a(new bl(bk.c.toString(), "JSON Exception in computeRequest", jsonexception.getMessage()));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.e("paypal.sdk", "Exception computing request", unsupportedencodingexception);
                ((cj) (obj)).a(new bl(bk.c.toString(), "Unsupported encoding", unsupportedencodingexception.getMessage()));
            }
            if (!d.b(((cj) (obj))))
            {
                a.a(((cj) (obj)));
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        obj = null;
          goto _L1
        obj = (cj)b.remove(0);
          goto _L1
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
        (new StringBuilder()).append(getClass().getSimpleName()).append(" exiting");
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    static 
    {
        com/paypal/android/sdk/cf.getSimpleName();
    }
}
