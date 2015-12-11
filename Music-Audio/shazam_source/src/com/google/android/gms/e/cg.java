// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import com.google.android.gms.analytics.e;
import com.google.android.gms.analytics.g;
import com.google.android.gms.analytics.h;
import com.google.android.gms.analytics.internal.ak;
import com.google.android.gms.analytics.internal.f;

// Referenced classes of package com.google.android.gms.e:
//            aj

public final class cg
{
    static final class a
        implements g
    {

        public final void a()
        {
            aj.a();
        }

        public final void a(int i)
        {
            aj.a();
        }

        public final void a(String s)
        {
            aj.a(s);
        }

        public final int b()
        {
            switch (com.google.android.gms.e.aj.e())
            {
            case 6: // '\006'
            default:
                return 3;

            case 5: // '\005'
                return 2;

            case 3: // '\003'
            case 4: // '\004'
                return 1;

            case 2: // '\002'
                return 0;
            }
        }

        a()
        {
        }
    }


    h a;
    private e b;
    private Context c;

    public cg(Context context)
    {
        c = context;
    }

    final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = e.a(c);
            e e1 = b;
            f.a(new a());
            if (!e1.e)
            {
                ak.c.a();
                (new StringBuilder("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.")).append((String)ak.c.a()).append(" DEBUG");
                e1.e = true;
            }
            a = b.a(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
