// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            ResourceUtil

public static class <init>
{

    private final Map mPropertiesMap;

    public e addProperty(String s, com.google.analytics.midtier.proto.containertag. )
    {
        mPropertiesMap.put(s, );
        return this;
    }

    public mPropertiesMap build()
    {
        return new mPropertiesMap(mPropertiesMap, null);
    }

    private e()
    {
        mPropertiesMap = new HashMap();
    }

    mPropertiesMap(mPropertiesMap mpropertiesmap)
    {
        this();
    }
}
