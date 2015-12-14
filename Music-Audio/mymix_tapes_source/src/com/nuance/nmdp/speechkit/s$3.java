// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            s, p, Prompt

final class b
    implements Runnable
{

    private int a;
    private Prompt b;
    private s c;

    public final void run()
    {
        s.d(c).a(a, b);
    }

    pt(s s1, int i, Prompt prompt)
    {
        c = s1;
        a = i;
        b = prompt;
        super();
    }
}
