// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            af, ce, ae

public final class ag
    implements af
{

    private final ae a;
    private final HashSet b = new HashSet();

    public ag(ae ae1)
    {
        a = ae1;
    }

    public final void a()
    {
        java.util.AbstractMap.SimpleEntry simpleentry;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); a.b((String)simpleentry.getKey(), (ce)simpleentry.getValue()))
        {
            simpleentry = (java.util.AbstractMap.SimpleEntry)iterator.next();
            (new StringBuilder("Unregistering eventhandler: ")).append(((ce)simpleentry.getValue()).toString());
            com.google.android.gms.ads.internal.util.client.b.a(2);
        }

        b.clear();
    }

    public final void a(String s, ce ce1)
    {
        a.a(s, ce1);
        b.add(new java.util.AbstractMap.SimpleEntry(s, ce1));
    }

    public final void a(String s, String s1)
    {
        a.a(s, s1);
    }

    public final void a(String s, JSONObject jsonobject)
    {
        a.a(s, jsonobject);
    }

    public final void b(String s, ce ce1)
    {
        a.b(s, ce1);
        b.remove(new java.util.AbstractMap.SimpleEntry(s, ce1));
    }
}
