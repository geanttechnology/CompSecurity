// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.a;

import com.shazam.b.a.a;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.server.response.config.Provider;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.j.a:
//            a

public final class b
    implements com.shazam.android.j.a.a
{

    private final Provider a;
    private final a b;

    public b(a a1, Provider provider)
    {
        b = a1;
        a = provider;
    }

    public final String a()
    {
        return a.getName();
    }

    public final String a(AdvertSiteIdKey advertsiteidkey)
    {
        if (advertsiteidkey == null)
        {
            advertsiteidkey = null;
        } else
        {
            String s = (String)b.a(advertsiteidkey);
            advertsiteidkey = s;
            if ("0".equals(s))
            {
                return null;
            }
        }
        return advertsiteidkey;
    }

    public final String[] b()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = a.getSites().entrySet().iterator(); iterator.hasNext(); arraylist.add(((java.util.Map.Entry)iterator.next()).getValue())) { }
        return (String[])arraylist.toArray((Object[])(Object[])Array.newInstance(java/lang/String, arraylist.size()));
    }

    public final Map c()
    {
        return a.getParameters();
    }

    public final String d()
    {
        return a.getProviderKey();
    }
}
