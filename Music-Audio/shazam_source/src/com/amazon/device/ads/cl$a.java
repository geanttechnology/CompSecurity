// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads:
//            cl

static final class c extends cl
{

    private final ArrayList c;

    public final void a(c c1)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).a(c1)) { }
    }

    public final void a(r r, long l)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).a(r, l)) { }
    }

    public final void a(r r, String s)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).a(r, s)) { }
    }

    public final void b(r r)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).b(r)) { }
    }

    public final void b(r r, long l)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).b(r, l)) { }
    }

    public final void c(r r)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).c(r)) { }
    }

    public final void c(r r, long l)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).c(r, l)) { }
    }

    public (ArrayList arraylist)
    {
        c = arraylist;
    }
}
