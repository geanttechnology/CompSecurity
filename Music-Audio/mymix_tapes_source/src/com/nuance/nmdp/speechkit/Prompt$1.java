// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            Prompt, x

final class a
    implements Runnable
{

    private Prompt a;

    public final void run()
    {
        if (Prompt.a(a) != null)
        {
            Prompt.a(a).a(a);
        }
    }

    (Prompt prompt)
    {
        a = prompt;
        super();
    }
}
