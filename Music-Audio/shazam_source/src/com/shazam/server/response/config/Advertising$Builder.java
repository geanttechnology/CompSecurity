// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.server.response.config:
//            Advertising

public static class 
{

    private final List providers = new ArrayList();

    public static  advertising()
    {
        return new <init>();
    }

    public Advertising build()
    {
        return new Advertising(this, null);
    }

    public <init> withProviders(List list)
    {
        providers.clear();
        providers.addAll(list);
        return this;
    }


    public ()
    {
    }
}
