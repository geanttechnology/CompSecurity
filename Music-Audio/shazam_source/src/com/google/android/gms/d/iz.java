// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            ix, ja, ii

public abstract class iz
{

    private final List a = new ArrayList();
    public final ja h;
    protected final ix i;

    public iz(ja ja, ii ii)
    {
        w.a(ja);
        h = ja;
        ja = new ix(this, ii);
        ja.g = true;
        i = ja;
    }

    public void a(ix ix1)
    {
    }

    public ix c()
    {
        ix ix1 = i.a();
        f();
        return ix1;
    }

    public final ix d()
    {
        return i;
    }

    public final List e()
    {
        return i.i;
    }

    public final void f()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); iterator.next()) { }
    }
}
