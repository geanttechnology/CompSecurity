// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.c;
import com.nostra13.universalimageloader.core.c.a;
import com.nostra13.universalimageloader.core.d.b;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            d

final class m
{

    final String a;
    final String b;
    final a c;
    final c d;
    final d e;
    final com.nostra13.universalimageloader.core.d.a f;
    final b g;
    final ReentrantLock h;

    public m(String s, a a1, c c1, String s1, d d1, com.nostra13.universalimageloader.core.d.a a2, b b1, 
            ReentrantLock reentrantlock)
    {
        a = s;
        c = a1;
        d = c1;
        e = d1;
        f = a2;
        g = b1;
        h = reentrantlock;
        b = s1;
    }
}
