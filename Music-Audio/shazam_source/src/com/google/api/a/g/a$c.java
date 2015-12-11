// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.google.api.a.g:
//            a

final class init> extends AbstractSet
{

    final a a;

    public final Iterator iterator()
    {
        return new <init>(a);
    }

    public final int size()
    {
        return a.a;
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
