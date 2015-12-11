// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


// Referenced classes of package com.g.c:
//            c, af

static final class ject
    implements Runnable
{

    final af a;

    public final void run()
    {
        throw new IllegalStateException((new StringBuilder("Transformation ")).append(a.a()).append(" mutated input Bitmap but failed to recycle the original.").toString());
    }

    ringBuilder(af af1)
    {
        a = af1;
        super();
    }
}
