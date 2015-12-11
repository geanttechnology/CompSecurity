// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.analytics.g;

// Referenced classes of package com.google.android.gms.e:
//            cg, aj

static final class cs.g
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
        switch (aj.e())
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

    cs.g()
    {
    }
}
