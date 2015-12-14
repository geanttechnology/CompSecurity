// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

// Referenced classes of package com.pf.common.a:
//            g, d

final class f extends PhantomReference
{

    final d a;

    f(g g1, ReferenceQueue referencequeue)
    {
        super(g1, referencequeue);
        a = g1.a;
    }
}
