// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            e, p, k

class g extends e
{

    g(Map map, p p1)
    {
        super(map, p1);
    }

    void a()
    {
        int j = a("w");
        int l = a("h");
        String s = b("url");
        boolean flag = c("shouldUseCustomClose");
        boolean flag1 = c("lockOrientation");
        int i = j;
        if (j <= 0)
        {
            i = b.g().c;
        }
        j = l;
        if (l <= 0)
        {
            j = b.g().d;
        }
        b.g().a(s, i, j, flag, flag1);
    }
}
