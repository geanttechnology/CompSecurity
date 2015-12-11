// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.shazam.model.store:
//            ParameterizedStores, Stores

public static class urlParameters
{

    public Stores stores;
    public Map urlParameters;

    public static urlParameters a()
    {
        return new <init>();
    }

    static Map a(<init> <init>1)
    {
        return <init>1.urlParameters;
    }

    static Stores b(urlParameters urlparameters)
    {
        return urlparameters.stores;
    }

    public final ParameterizedStores b()
    {
        return new ParameterizedStores(this, null);
    }

    public ()
    {
        urlParameters = Collections.emptyMap();
    }
}
