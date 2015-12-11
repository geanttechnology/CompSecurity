// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            x, eb, em, ao, 
//            ay

public final class ev
{

    x a;
    ExecutorService b;
    eb c;
    em d;

    public ev()
    {
    }

    public ev(x x, ExecutorService executorservice, eb eb, em em)
    {
        a = x;
        b = executorservice;
        c = eb;
        d = em;
    }

    // Unreferenced inner class a/a/ev$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final Throwable a;
        final long b;
        final ev c;

        public final void run()
        {
            ao ao1;
            try
            {
                if (c.d.b())
                {
                    return;
                }
            }
            catch (ThreadDeath threaddeath)
            {
                return;
            }
            catch (Throwable throwable)
            {
                Object obj = c;
                obj = a;
                return;
            }
            ao1 = new ao(a, b);
            ao1.f = "he";
            try
            {
                ao1.g.put("app_version", "5.0.6");
            }
            catch (JSONException jsonexception) { }
            ao1.g.remove("logcat");
            c.a.p().a(ao1);
            return;
        }

            
            {
                c = ev.this;
                a = throwable;
                b = l;
                super();
            }
    }

}
