// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ba;
import com.nuance.nmdp.speechkit.recognitionresult.b;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            x, Prompt

final class d
    implements Runnable
{

    private Prompt a;
    private Prompt b;
    private Prompt c;
    private Prompt d;
    private x e;

    public final void run()
    {
label0:
        {
            x.a(e, null);
            com.nuance.nmdp.speechkit.x.b(e, null);
            x.c(e, null);
            x.d(e, null);
            if (a != null)
            {
                if (!a.a().b())
                {
                    x.a(e, a);
                } else
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Recording start prompt is invalid");
                }
            }
            if (b != null)
            {
                if (!b.a().b())
                {
                    com.nuance.nmdp.speechkit.x.b(e, b);
                } else
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Recording stop prompt is invalid");
                }
            }
            if (c != null)
            {
                if (!c.a().b())
                {
                    x.c(e, c);
                } else
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Result prompt is invalid");
                }
            }
            if (d != null)
            {
                if (d.a().b())
                {
                    break label0;
                }
                x.d(e, d);
            }
            return;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Error prompt is invalid");
    }

    pt(x x1, Prompt prompt, Prompt prompt1, Prompt prompt2, Prompt prompt3)
    {
        e = x1;
        a = prompt;
        b = prompt1;
        c = prompt2;
        d = prompt3;
        super();
    }
}
