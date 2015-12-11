// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.d.ke;

// Referenced classes of package com.google.android.gms.e:
//            cz, aj, cy, a, 
//            d

final class a
    implements a
{

    final a a;

    i.Status(i.Status status)
    {
        a = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/e/cz$1

/* anonymous class */
    public final class cz._cls1
        implements com.google.android.gms.d.ka.a
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
            com.google.android.gms.d.kf.c c = ke1.a.f;
            if (c == null)
            {
                aj.a("Response doesn't have the requested container");
                b.a(b.c(new Status(8, "Response doesn't have the requested container", null)));
                return;
            } else
            {
                long l = ke1.a.d;
                b.h = new cy(b.e, b.b, new a(b.d, b.e.c, b.f, l, c), new cz._cls1._cls1(this));
                b.a(b.h);
                return;
            }
        }

            public 
            {
                b = cz1;
                a = s;
                super();
            }
    }

}
