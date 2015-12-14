// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Vibrator;
import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class e
    implements ba
{

    private boolean a;
    private final int b;
    private Vibrator c;

    public e(int i)
    {
        a = false;
        b = i;
        c = null;
    }

    static Vibrator a(e e1)
    {
        e1.c = null;
        return null;
    }

    public final void a()
    {
        if (c == null)
        {
            return;
        } else
        {
            c.cancel();
            c = null;
            return;
        }
    }

    public final void a(Object obj, az az1, Object obj1)
    {
        c = (Vibrator)((Context)obj).getSystemService("vibrator");
        if (c == null)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to get vibrator service");
            az1.a(obj1);
            return;
        }
        if (a)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Can't start disposed vibration prompt.");
            az1.a(obj1);
            return;
        }
        try
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, (new StringBuilder()).append("Starting vibration (").append(b).append(" ms)").toString());
            c.vibrate(b);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Unable to vibrate", ((Throwable) (obj)));
            az1.a(obj1);
            return;
        }
        ax.a(new Runnable(az1, obj1) {

            private az a;
            private Object b;
            private e c;

            public final void run()
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Vibration finished");
                a.c(b);
                e.a(c);
            }

            
            {
                c = e.this;
                a = az1;
                b = obj;
                super();
            }
        }, b);
    }

    public final boolean b()
    {
        return a;
    }

    public final void c()
    {
        a = true;
        if (c != null)
        {
            c.cancel();
            c = null;
        }
    }
}
