// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.h;
import com.shazam.h.j;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.shazam.android.an.b:
//            h

public final class o
    implements Runnable
{

    private final com.shazam.android.an.b.h a;
    private final String b;
    private final List c;
    private final h d;

    public o(com.shazam.android.an.b.h h1, String s, List list, h h2)
    {
        a = h1;
        b = s;
        c = list;
        d = h2;
    }

    public final void run()
    {
        a.a(b, c);
        d.a();
        return;
        Object obj;
        obj;
_L2:
        d.a(((Exception) (obj)).getMessage());
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
