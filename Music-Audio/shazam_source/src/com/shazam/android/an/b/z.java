// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.u;
import com.shazam.android.an.v;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android.an.b:
//            aa

public final class z
    implements u
{

    private final ExecutorService a;
    private final aa b;

    public z(ExecutorService executorservice, aa aa1)
    {
        a = executorservice;
        b = aa1;
    }

    public final void a(v v)
    {
        b.a = v;
        a.execute(b);
    }
}
