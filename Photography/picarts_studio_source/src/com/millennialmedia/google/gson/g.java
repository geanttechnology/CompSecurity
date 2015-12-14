// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.LinkedHashTreeMap;

// Referenced classes of package com.millennialmedia.google.gson:
//            e, f

public final class g extends e
{

    public final LinkedHashTreeMap a = new LinkedHashTreeMap();

    public g()
    {
    }

    public final void a(String s, e e1)
    {
        Object obj = e1;
        if (e1 == null)
        {
            obj = f.a;
        }
        a.put(s, obj);
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof g) && ((g)obj).a.equals(a);
    }

    public final int hashCode()
    {
        return a.hashCode();
    }
}
