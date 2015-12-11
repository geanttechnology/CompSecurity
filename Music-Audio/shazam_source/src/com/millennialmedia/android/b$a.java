// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            b, r, v, a

private final class t>
    implements Comparable, Runnable
{

    final b a;
    private WeakReference b;
    private String c;
    private r d;
    private WeakReference e;

    public final volatile int compareTo(Object obj)
    {
        obj = (t>)obj;
        return d.f - ((d) (obj)).d.f;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof d))
        {
            return false;
        } else
        {
            obj = (d)obj;
            return d.equals(((uals) (obj)).d);
        }
    }

    public final void run()
    {
        String s;
        Context context;
        d d1;
        String s1;
        boolean flag;
        if (e != null)
        {
            d1 = (e)e.get();
        } else
        {
            d1 = null;
        }
        if (d1 != null)
        {
            d1.a();
        }
        v.a((Context)b.get()).c(c);
        flag = d.a((Context)b.get());
        v.a((Context)b.get()).d(c);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        s = com.millennialmedia.android.a.d((Context)b.get(), c);
        if (s == null || !d.a.equals(s)) goto _L2; else goto _L1
_L1:
        d.b((Context)b.get());
        context = (Context)b.get();
        s = c;
_L4:
        s1 = null;
_L5:
        com.millennialmedia.android.a.b(context, s, s1);
_L6:
        if (d1 != null)
        {
            d1.a(d, flag);
        }
        return;
_L2:
        context = (Context)b.get();
        s = c;
        if (d.g) goto _L4; else goto _L3
_L3:
        s1 = d.a;
          goto _L5
        com.millennialmedia.android.a.b((Context)b.get(), c, null);
          goto _L6
    }

    (b b1, Context context, String s, r r1,  )
    {
        a = b1;
        super();
        b = new WeakReference(context.getApplicationContext());
        c = s;
        d = r1;
        if ( != null)
        {
            e = new WeakReference();
        }
    }
}
