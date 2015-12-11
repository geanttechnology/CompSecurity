// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.api.a.g:
//            l, i, f

final class assInfo extends AbstractSet
{

    final l a;
    private final size b;

    public final void clear()
    {
        a.unknownFields.clear();
        b.clear();
    }

    public final Iterator iterator()
    {
        return new <init>(a, b);
    }

    public final int size()
    {
        return a.unknownFields.size() + b.size();
    }

    (l l1)
    {
        a = l1;
        super();
        b = (new i(l1, l1.classInfo.b)).a();
    }
}
