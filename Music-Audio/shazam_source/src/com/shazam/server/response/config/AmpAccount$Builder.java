// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.server.response.config:
//            AmpAccount

public static class 
{

    private final Map hrefMap = new HashMap();

    public static  ampAccount()
    {
        return new <init>();
    }

    public AmpAccount build()
    {
        return new AmpAccount(this, null);
    }

    public <init> withHrefMap(Map map)
    {
        hrefMap.clear();
        hrefMap.putAll(map);
        return this;
    }


    public ()
    {
    }
}
