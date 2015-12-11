// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.server.response.config:
//            AmpSocial

public static class _cls9
{

    private final Map hrefMap = new HashMap();

    public static _cls9 ampSocial()
    {
        return new <init>();
    }

    public AmpSocial build()
    {
        return new AmpSocial(this, null);
    }

    public <init> withHrefMap(Map map)
    {
        hrefMap.clear();
        hrefMap.putAll(map);
        return this;
    }


    public _cls9()
    {
    }
}
