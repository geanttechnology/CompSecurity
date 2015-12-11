// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.d.ke;

// Referenced classes of package com.google.android.gms.e:
//            cz, aj, cy, a, 
//            d

public final class a
    implements com.google.android.gms.d.a
{

    final String a;
    final cz b;

    public final void a(ke ke1)
    {
        if (ke1.a.a != Status.a)
        {
            aj.a((new StringBuilder("Load request failed for the container ")).append(b.f).toString());
            b.a(b.c(Status.c));
            return;
        }
        com.google.android.gms.d.api.g g = ke1.a.f;
        if (g == null)
        {
            aj.a("Response doesn't have the requested container");
            b.a(b.c(new Status(8, "Response doesn't have the requested container", null)));
            return;
        } else
        {
            long l = ke1.a.d;
            b.h = new cy(b.e, b.b, new a(b.d, b.e.c, b.f, l, g), new cy.a() {

                final cz._cls1 a;

            
            {
                a = cz._cls1.this;
                super();
            }
            });
            b.a(b.h);
            return;
        }
    }

    public _cls1.a(cz cz1, String s)
    {
        b = cz1;
        a = s;
        super();
    }
}
