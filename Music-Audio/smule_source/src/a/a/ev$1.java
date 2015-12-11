// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            ev, em, ao, x, 
//            ay

final class .Object
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

    .Throwable(ev ev1, Throwable throwable, long l)
    {
        c = ev1;
        a = throwable;
        b = l;
        super();
    }
}
