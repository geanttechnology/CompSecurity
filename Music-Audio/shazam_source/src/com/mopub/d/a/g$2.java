// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import com.mopub.d.s;
import java.util.HashMap;

// Referenced classes of package com.mopub.d.a:
//            g

final class init>
    implements com.mopub.d.
{

    final String a;
    final g b;

    public final void a(s s)
    {
        g g1 = b;
        String s1 = a;
        init> init> = (a)g1.b.remove(s1);
        if (init> != null)
        {
            init>.b = s;
            g1.a(s1, init>);
        }
    }

    (g g1, String s)
    {
        b = g1;
        a = s;
        super();
    }
}
