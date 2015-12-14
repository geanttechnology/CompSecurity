// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import com.bumptech.glide.request.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import myobfuscated.aj.j;

public final class n
{

    public final Set a = Collections.newSetFromMap(new WeakHashMap());
    public final List b = new ArrayList();
    public boolean c;

    public n()
    {
    }

    public final void a()
    {
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); a((b)iterator.next())) { }
        b.clear();
    }

    public final boolean a(b b1)
    {
        boolean flag;
        if (b1 != null && (a.remove(b1) || b.remove(b1)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b1.d();
            b1.i();
        }
        return flag;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("{numRequests=").append(a.size()).append(", isPaused=").append(c).append("}").toString();
    }
}
