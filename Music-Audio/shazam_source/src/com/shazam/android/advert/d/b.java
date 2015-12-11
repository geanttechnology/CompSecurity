// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.d;

import com.shazam.b.a.a;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.server.response.config.Provider;
import java.util.Map;

public final class b
    implements a
{

    private final Provider a;

    public b(Provider provider)
    {
        a = provider;
    }

    public final Object a(Object obj)
    {
        obj = (AdvertSiteIdKey)obj;
        obj = (String)a.getSites().get(((AdvertSiteIdKey) (obj)).siteIdKey);
        if (obj != null)
        {
            return obj;
        } else
        {
            return "0";
        }
    }
}
