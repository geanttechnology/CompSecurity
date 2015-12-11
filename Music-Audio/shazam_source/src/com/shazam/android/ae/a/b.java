// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae.a;

import android.content.Context;
import com.shazam.i.b.ah.c.d;
import com.shazam.model.configuration.InstallationIdRepository;
import net.hockeyapp.android.c;

// Referenced classes of package com.shazam.android.ae.a:
//            a

public final class b
    implements a
{

    private final Context b;
    private final String c;

    public b(Context context, String s)
    {
        b = context;
        c = s;
    }

    public final void a()
    {
        net.hockeyapp.android.b.a(b, c, new c() {

            final b a;

            public final boolean a()
            {
                return true;
            }

            public final boolean b()
            {
                return true;
            }

            public final String c()
            {
                return d.a().b();
            }

            
            {
                a = b.this;
                super();
            }
        });
    }
}
