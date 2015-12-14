// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import java.util.Queue;
import myobfuscated.aj.j;

// Referenced classes of package com.bumptech.glide:
//            h

public final class i
{

    private final Queue a;

    public i(int k)
    {
        a = j.a(k);
        for (int l = 0; l < k; l++)
        {
            a.offer(new h((byte)0));
        }

    }

    public final h a(int k, int l)
    {
        h h1 = (h)a.poll();
        a.offer(h1);
        h1.b = k;
        h1.a = l;
        return h1;
    }
}
