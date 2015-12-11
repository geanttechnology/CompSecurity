// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.b:
//            e, b, a

final class a
    implements e
{

    final b a;

    public final void a(a a1)
    {
        a.a = a1;
        for (a1 = a.c.iterator(); a1.hasNext(); (()a1.next()).b()) { }
        a.c.clear();
        a.b = null;
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
