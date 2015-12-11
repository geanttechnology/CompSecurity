// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package android.support.v7:
//            abb, abo, abd, adc

class abc extends Thread
    implements abb
{

    private static abc d;
    private final LinkedBlockingQueue a = new LinkedBlockingQueue();
    private volatile boolean b;
    private volatile boolean c;
    private volatile abd e;
    private final Context f;

    private abc(Context context)
    {
        super("GAThread");
        b = false;
        c = false;
        if (context != null)
        {
            f = context.getApplicationContext();
        } else
        {
            f = context;
        }
        start();
    }

    static abc a(Context context)
    {
        if (d == null)
        {
            d = new abc(context);
        }
        return d;
    }

    static abd a(abc abc1)
    {
        return abc1.e;
    }

    static abd a(abc abc1, abd abd)
    {
        abc1.e = abd;
        return abd;
    }

    private String a(Throwable throwable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        printstream.flush();
        return new String(bytearrayoutputstream.toByteArray());
    }

    static Context b(abc abc1)
    {
        return abc1.f;
    }

    public void a(Runnable runnable)
    {
        a.add(runnable);
    }

    public void a(String s)
    {
        a(s, System.currentTimeMillis());
    }

    void a(String s, long l)
    {
        a(new Runnable(this, l, s) {

            final abb a;
            final long b;
            final String c;
            final abc d;

            public void run()
            {
                if (abc.a(d) == null)
                {
                    adc adc1 = adc.c();
                    adc1.a(abc.b(d), a);
                    abc.a(d, adc1.d());
                }
                abc.a(d).a(b, c);
            }

            
            {
                d = abc.this;
                a = abb1;
                b = l;
                c = s;
                super();
            }
        });
    }

    public void run()
    {
_L2:
        if (c)
        {
            break; /* Loop/switch isn't completed */
        }
        Runnable runnable = (Runnable)a.take();
        if (!b)
        {
            runnable.run();
        }
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        try
        {
            abo.c(interruptedexception.toString());
        }
        catch (Throwable throwable)
        {
            abo.a((new StringBuilder()).append("Error on Google TagManager Thread: ").append(a(throwable)).toString());
            abo.a("Google TagManager is shutting down.");
            b = true;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
