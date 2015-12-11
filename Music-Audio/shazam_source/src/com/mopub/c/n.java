// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.common.a.g;
import com.mopub.d.d;
import com.mopub.d.i;
import com.mopub.d.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class n extends l
{
    public static interface a
        extends com.mopub.d.a
    {

        public abstract void g_();
    }

    public static interface b
        extends k.a
    {

        public abstract n a(a a1);
    }


    private final List l;
    private final g m;
    private final a n;

    public n(String s, List list, g g1, a a1)
    {
        super(1, s, a1);
        l = list;
        m = g1;
        n = a1;
        super.g = false;
        super.j = new d();
    }

    protected final com.mopub.d.n a(i i)
    {
        return com.mopub.d.n.a(null, com.mopub.d.a.d.a(i));
    }

    protected final void a(Object obj)
    {
        n.g_();
    }

    protected final Map b()
    {
        JSONArray jsonarray = g.a(l);
        HashMap hashmap = new HashMap();
        hashmap.put("log", jsonarray.toString());
        return hashmap;
    }
}
