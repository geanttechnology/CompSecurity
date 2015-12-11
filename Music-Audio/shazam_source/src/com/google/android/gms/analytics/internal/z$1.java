// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.d.ja;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            z, o, r

final class a
    implements Callable
{

    final z a;

    public final Object call()
    {
        z z1 = a;
        String s1 = z1.a(((o) (z1)).i.b().a);
        String s = s1;
        if (s1 == null)
        {
            s = z1.d();
        }
        return s;
    }

    (z z1)
    {
        a = z1;
        super();
    }
}
