// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.os.Handler;
import com.mopub.d.b;
import com.mopub.d.f;
import com.mopub.d.l;
import com.mopub.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class h extends m
{
    final class a
    {

        final int a;
        final Handler b;
        final Runnable c;
        final h d;

        a(l l1, int i)
        {
            this(l1, i, new Handler());
        }

        private a(l l1, int i, Handler handler)
        {
            d = h.this;
            super();
            a = i;
            b = handler;
            c = new _cls1(this, h.this, l1);
        }
    }


    final Map a = new HashMap(10);

    h(b b, f f)
    {
        super(b, f, (byte)0);
    }

    public final void a(l l1)
    {
        com.mopub.common.m.a(l1);
        a(new com.mopub.d.m.a(l1) {

            final l a;
            final h b;

            public final boolean a(l l2)
            {
                return a == l2;
            }

            
            {
                b = h.this;
                a = l1;
                super();
            }
        });
    }

    public final void a(com.mopub.d.m.a a1)
    {
        com.mopub.common.m.a(a1);
        super.a(a1);
        Iterator iterator = a.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            if (a1.a((l)((java.util.Map.Entry) (obj)).getKey()))
            {
                ((l)((java.util.Map.Entry) (obj)).getKey()).h = true;
                obj = (a)((java.util.Map.Entry) (obj)).getValue();
                ((a) (obj)).b.removeCallbacks(((a) (obj)).c);
                iterator.remove();
            }
        } while (true);
    }

    // Unreferenced inner class com/mopub/c/h$a$1

/* anonymous class */
    final class a._cls1
        implements Runnable
    {

        final h a;
        final l b;
        final a c;

        public final void run()
        {
            c.d.a.remove(b);
            c.d.b(b);
        }

            
            {
                c = a1;
                a = h1;
                b = l1;
                super();
            }
    }

}
