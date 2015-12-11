// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.a.a.a.a.b.x;
import c.a.a.a.a.c.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package c.a.a.a:
//            q, k, e, n

public final class h
{

    private final Context a;
    private n b[];
    private w c;
    private Handler d;
    private q e;
    private String f;
    private k g;

    public h(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            a = context.getApplicationContext();
            return;
        }
    }

    public final e a()
    {
        if (c == null)
        {
            c = w.a();
        }
        if (d == null)
        {
            d = new Handler(Looper.getMainLooper());
        }
        if (e == null)
        {
            e = new q();
        }
        if (f == null)
        {
            f = a.getPackageName();
        }
        if (g == null)
        {
            g = k.a;
        }
        Object obj;
        x x1;
        if (b == null)
        {
            obj = new HashMap();
        } else
        {
            obj = c.a.a.a.e.a(Arrays.asList(b));
        }
        x1 = new x(a, f, null, ((Map) (obj)).values());
        return new e(a, ((Map) (obj)), c, d, e, false, g, x1);
    }

    public final transient h a(n an[])
    {
        if (b != null)
        {
            throw new IllegalStateException("Kits already set.");
        } else
        {
            b = an;
            return this;
        }
    }
}
