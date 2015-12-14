// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.executor.GlideExecutor;
import myobfuscated.ak.a;
import myobfuscated.ak.b;

// Referenced classes of package com.bumptech.glide.load.engine:
//            v, s

public final class o
{

    final GlideExecutor a;
    final GlideExecutor b;
    final v c;
    public final android.support.v4.util.Pools.Pool d = myobfuscated.ak.a.a(new b() {

        private o a;

        public final Object a()
        {
            return new s(a.a, a.b, a.c, a.d);
        }

            
            {
                a = o.this;
                super();
            }
    });

    o(GlideExecutor glideexecutor, GlideExecutor glideexecutor1, v v)
    {
        a = glideexecutor;
        b = glideexecutor1;
        c = v;
    }
}
