// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


// Referenced classes of package com.g.c:
//            c

static final class ject
    implements Runnable
{

    final StringBuilder a;

    public final void run()
    {
        throw new NullPointerException(a.toString());
    }

    ringBuilder(StringBuilder stringbuilder)
    {
        a = stringbuilder;
        super();
    }
}
