// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.com.google.gson.internal.bind;

import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.TypeAdapter;
import com.newrelic.com.google.gson.TypeAdapterFactory;
import com.newrelic.com.google.gson.reflect.TypeToken;

// Referenced classes of package com.newrelic.com.google.gson.internal.bind:
//            TypeAdapters

static final class val.typeAdapter
    implements TypeAdapterFactory
{

    final TypeToken val$type;
    final TypeAdapter val$typeAdapter;

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        if (typetoken.equals(val$type))
        {
            return val$typeAdapter;
        } else
        {
            return null;
        }
    }

    (TypeToken typetoken, TypeAdapter typeadapter)
    {
        val$type = typetoken;
        val$typeAdapter = typeadapter;
        super();
    }
}
