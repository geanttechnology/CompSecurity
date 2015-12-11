// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.type;

import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Map;

// Referenced classes of package com.newrelic.agent.android.harvest.type:
//            HarvestableObject

static final class nit> extends HarvestableObject
{

    final Map val$map;

    public JsonObject asJsonObject()
    {
        return (JsonObject)(new Gson()).toJsonTree(val$map, GSON_STRING_MAP_TYPE);
    }

    A(Map map1)
    {
        val$map = map1;
        super();
    }
}
