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
//            d, ai, i, z, 
//            aq, al

final class _cls2.a
    implements com.appnexus.opensdk.b.a, d
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
                com.appnexus.opensdk.b.a a1 = new com.appnexus.opensdk.b.h.b(j) {

                    final al a;
                    final ai.a b;

                    public final void a()
                    {
                        com.appnexus.opensdk.b.b.e(b.f, (new StringBuilder("Image downloading failed for url ")).append(a.a()).toString());
                    }

                    public final void a(Bitmap bitmap)
                    {
                        a.a(bitmap);
                    }

            
            {
                b = ai.a.this;
                a = al1;
                super();
            }
                };
                a.a(a1, j.a());
            }
            if (c.e)
            {
                com.appnexus.opensdk.b.a a2 = new com.appnexus.opensdk.b.h.b(j) {

                    final al a;
                    final ai.a b;

                    public final void a()
                    {
                        com.appnexus.opensdk.b.b.e(b.f, (new StringBuilder("Image downloading failed for url ")).append(a.b()).toString());
                    }

                    public final void a(Bitmap bitmap)
                    {
                        a.b(bitmap);
                    }

            
            {
                b = ai.a.this;
                a = al1;
                super();
            }
                };
                a.a(a2, j.b());
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
                    java.util.ntry ntry = (java.util.ntry)iterator.next();
                    com.appnexus.opensdk.b.a a3 = new com.appnexus.opensdk.b.init>(j, (com.appnexus.opensdk.b.)ntry.getKey(), (String)ntry.getValue(), j);
                    com.appnexus.opensdk.b.b.b(b.b, (new StringBuilder("Downloading image from url: ")).append(ntry.getValue()).toString());
                    a3.xecute(new Void[0]);
                }
            } else
            {
                ((h) (j)).b.();
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
