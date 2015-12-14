// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ax;
import ba;
import e;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            x

public final class Prompt
{

    private final ba a;
    private final x b;

    Prompt(ba ba, x x)
    {
        a = ba;
        b = x;
    }

    static x a(Prompt prompt)
    {
        return prompt.b;
    }

    public static Prompt vibration(int i)
    {
        if (i <= 0)
        {
            return null;
        } else
        {
            return new Prompt(new e(i), null);
        }
    }

    final ba a()
    {
        return a;
    }

    public final void release()
    {
        ax.a(new Runnable() {

            private Prompt a;

            public final void run()
            {
                if (Prompt.a(a) != null)
                {
                    Prompt.a(a).a(a);
                }
            }

            
            {
                a = Prompt.this;
                super();
            }
        });
    }
}
