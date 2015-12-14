// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import myobfuscated.ak.a;
import myobfuscated.ak.b;

// Referenced classes of package com.bumptech.glide.load.engine:
//            h, DecodeJob

public final class n
{

    final h a;
    public final android.support.v4.util.Pools.Pool b = myobfuscated.ak.a.a(new b() {

        private n a;

        public final Object a()
        {
            return new DecodeJob(a.a, a.b);
        }

            
            {
                a = n.this;
                super();
            }
    });
    public int c;

    n(h h)
    {
        a = h;
    }
}
