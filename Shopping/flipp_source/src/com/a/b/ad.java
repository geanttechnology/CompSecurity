// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.a.b:
//            ae, ag, af, ba, 
//            x, an, ak, as, 
//            n, aq, a, m, 
//            h, ai, ao

public final class ad
{

    static final Handler a = new ae(Looper.getMainLooper());
    static ad b = null;
    public final Context c;
    final n d;
    final h e;
    final as f;
    final Map g = new WeakHashMap();
    final Map h = new WeakHashMap();
    final ReferenceQueue i = new ReferenceQueue();
    boolean j;
    boolean k;
    private final ai l;
    private final ak m;
    private final ag n;

    private ad(Context context, n n1, h h1, ai ai, ak ak1, as as1, boolean flag)
    {
        c = context;
        d = n1;
        e = h1;
        l = ai;
        m = ak1;
        f = as1;
        j = flag;
        n = new ag(i, a);
        n.start();
    }

    public static ad a(Context context)
    {
        if (b == null)
        {
            context = new af(context);
            Context context1 = ((af) (context)).a;
            if (((af) (context)).b == null)
            {
                context.b = ba.a(context1);
            }
            if (((af) (context)).d == null)
            {
                context.d = new x(context1);
            }
            if (((af) (context)).c == null)
            {
                context.c = new an();
            }
            if (((af) (context)).f == null)
            {
                context.f = ak.a;
            }
            as as1 = new as(((af) (context)).d);
            b = new ad(context1, new n(context1, ((af) (context)).c, a, ((af) (context)).b, ((af) (context)).d, as1), ((af) (context)).d, ((af) (context)).e, ((af) (context)).f, as1, ((af) (context)).g);
        }
        return b;
    }

    static void a(ad ad1, Object obj)
    {
        ad1.a(obj);
    }

    public final ao a(ao ao)
    {
        ao ao1 = m.a(ao);
        if (ao1 == null)
        {
            throw new IllegalStateException((new StringBuilder("Request transformer ")).append(m.getClass().getCanonicalName()).append(" returned null for ").append(ao).toString());
        } else
        {
            return ao1;
        }
    }

    public final aq a(String s)
    {
        if (s == null)
        {
            return new aq(this, null);
        }
        if (s.trim().length() == 0)
        {
            throw new IllegalArgumentException("Path must not be empty.");
        } else
        {
            return new aq(this, Uri.parse(s));
        }
    }

    public final void a(a a1)
    {
        Object obj = a1.c.get();
        if (obj != null)
        {
            a(obj);
            g.put(obj, a1);
        }
        obj = d;
        ((n) (obj)).f.sendMessage(((n) (obj)).f.obtainMessage(1, a1));
    }

    public final void a(Object obj)
    {
        a a1 = (a)g.remove(obj);
        if (a1 != null)
        {
            a1.b();
            n n1 = d;
            n1.f.sendMessage(n1.f.obtainMessage(2, a1));
        }
        if (obj instanceof ImageView)
        {
            obj = (ImageView)obj;
            obj = (m)h.remove(obj);
            if (obj != null)
            {
                obj.c = null;
                Object obj1 = (ImageView)((m) (obj)).b.get();
                if (obj1 != null)
                {
                    obj1 = ((ImageView) (obj1)).getViewTreeObserver();
                    if (((ViewTreeObserver) (obj1)).isAlive())
                    {
                        ((ViewTreeObserver) (obj1)).removeOnPreDrawListener(((android.view.ViewTreeObserver.OnPreDrawListener) (obj)));
                    }
                }
            }
        }
    }

    public final Bitmap b(String s)
    {
        s = e.a(s);
        if (s != null)
        {
            f.a();
            return s;
        } else
        {
            f.c.sendEmptyMessage(1);
            return s;
        }
    }

}
