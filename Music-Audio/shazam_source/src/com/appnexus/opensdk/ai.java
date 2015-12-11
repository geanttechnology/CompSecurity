// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.graphics.Bitmap;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.appnexus.opensdk:
//            c, ap, aj, z, 
//            d, i, aq, al

public final class ai
    implements c
{
    final class a
        implements com.appnexus.opensdk.b.h.c, d
    {

        h a;
        al b;
        final ai c;

        public final void a()
        {
        }

        public final void a(aq aq1)
        {
            c.f = false;
        }

        public final void a(i j)
        {
            if (!j.a().equals(z.c))
            {
                a(aq.f);
            } else
            {
                j = j.d();
                if (!c.d && !c.e)
                {
                    if (c.a == null)
                    {
                        j.c();
                    }
                    c.f = false;
                    return;
                }
                a = new h();
                b = j;
                if (c.d)
                {
                    com.appnexus.opensdk.b.h.b b1 = new com.appnexus.opensdk.b.h.b(this, j) {

                        final al a;
                        final a b;

                        public final void a()
                        {
                            com.appnexus.opensdk.b.b.e(b.f, (new StringBuilder("Image downloading failed for url ")).append(a.a()).toString());
                        }

                        public final void a(Bitmap bitmap)
                        {
                            a.a(bitmap);
                        }

            
            {
                b = a1;
                a = al1;
                super();
            }
                    };
                    a.a(b1, j.a());
                }
                if (c.e)
                {
                    com.appnexus.opensdk.b.h.b b2 = new com.appnexus.opensdk.b.h.b(this, j) {

                        final al a;
                        final a b;

                        public final void a()
                        {
                            com.appnexus.opensdk.b.b.e(b.f, (new StringBuilder("Image downloading failed for url ")).append(a.b()).toString());
                        }

                        public final void a(Bitmap bitmap)
                        {
                            a.b(bitmap);
                        }

            
            {
                b = a1;
                a = al1;
                super();
            }
                    };
                    a.a(b2, j.b());
                }
                a.b = this;
                j = a;
                if (((h) (j)).b == null)
                {
                    j.a();
                    return;
                }
                if (((h) (j)).a != null && !((h) (j)).a.isEmpty())
                {
                    Iterator iterator = ((h) (j)).a.entrySet().iterator();
                    while (iterator.hasNext()) 
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                        com.appnexus.opensdk.b.h.a a1 = new com.appnexus.opensdk.b.h.a(j, (com.appnexus.opensdk.b.h.b)entry.getKey(), (String)entry.getValue(), j);
                        com.appnexus.opensdk.b.b.b(b.b, (new StringBuilder("Downloading image from url: ")).append(entry.getValue()).toString());
                        a1.execute(new Void[0]);
                    }
                } else
                {
                    ((h) (j)).b.d();
                    j.a();
                    return;
                }
            }
        }

        public final void a(String s, String s1)
        {
        }

        public final void b()
        {
        }

        public final void c()
        {
        }

        public final void d()
        {
            if (c.a == null)
            {
                b.c();
            }
            a = null;
            b = null;
            c.f = false;
        }
    }


    aj a;
    final ap b;
    final a c;
    boolean d;
    boolean e;
    boolean f;

    public final boolean a()
    {
        return a != null;
    }

    public final z getMediaType()
    {
        return b.a;
    }
}
