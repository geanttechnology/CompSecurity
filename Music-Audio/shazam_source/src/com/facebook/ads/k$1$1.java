// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import com.facebook.ads.a.b;
import com.facebook.ads.a.b.u;
import com.facebook.ads.a.c;
import com.facebook.ads.a.f.l;
import com.facebook.ads.a.f.m;
import com.facebook.ads.a.i;
import java.util.ArrayList;
import java.util.EnumSet;

// Referenced classes of package com.facebook.ads:
//            k, c

final class 
    implements l
{

    final u a;
    final b b;

    public final void a()
    {
        k.a(b.b, a);
        k.d(b.b);
        if (k.a(b.b) != null)
        {
            k.a(b.b).a(b.b);
        }
    }

    nit>(nit> nit>, u u)
    {
        b = nit>;
        a = u;
        super();
    }

    // Unreferenced inner class com/facebook/ads/k$1

/* anonymous class */
    final class k._cls1 extends b
    {

        final EnumSet a;
        final k b;

        public final void a()
        {
            if (com.facebook.ads.k.b(b) != null)
            {
                com.facebook.ads.k.b(b).c();
            }
        }

        public final void a(u u1)
        {
            if (u1 == null)
            {
                return;
            }
            ArrayList arraylist = new ArrayList(2);
            if (a.contains(com.facebook.ads.k.b.b) && u1.i() != null)
            {
                arraylist.add(u1.i().a);
            }
            if (a.contains(com.facebook.ads.k.b.c) && u1.j() != null)
            {
                arraylist.add(u1.j().a);
            }
            m.a(com.facebook.ads.k.c(b), arraylist, new k._cls1._cls1(this, u1));
        }

        public final void a(c c1)
        {
            if (k.a(b) != null)
            {
                k.a(b).a(b, c1.a());
            }
        }

        public final void b()
        {
            if (k.a(b) != null)
            {
                k.a(b).b(b);
            }
        }

        public final void c()
        {
            throw new IllegalStateException("Native ads manager their own impressions.");
        }

            
            {
                b = k1;
                a = enumset;
                super();
            }
    }

}
