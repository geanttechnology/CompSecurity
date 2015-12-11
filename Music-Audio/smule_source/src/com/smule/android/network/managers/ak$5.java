// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.network.core.o;

// Referenced classes of package com.smule.android.network.managers:
//            ak

class b
    implements Runnable
{

    final o a;
    final long b;
    final ak c;

    public void run()
    {
        ak.a(c, a.j.get("store"));
        ak.a(c, a.h);
        ak.a(c, true, a.l, true, b);
    }

    (ak ak1, o o1, long l)
    {
        c = ak1;
        a = o1;
        b = l;
        super();
    }
}
