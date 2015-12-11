// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import java.util.concurrent.FutureTask;

// Referenced classes of package com.g.c:
//            w, c

private static final class a extends FutureTask
    implements Comparable
{

    private final c a;

    public final int compareTo(Object obj)
    {
        obj = (ject)obj;
        ject ject = a.s;
        ject ject1 = ((a) (obj)).a.s;
        if (ject == ject1)
        {
            return a.a - ((a) (obj)).a.a;
        } else
        {
            return ject1.ordinal() - ject.ordinal();
        }
    }

    public ject(c c1)
    {
        super(c1, null);
        a = c1;
    }
}
