// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;

// Referenced classes of package com.millennialmedia.google.gson.internal.bind:
//            ArrayTypeAdapter

static final class 
    implements TypeAdapterFactory
{

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        typetoken = typetoken.getType();
        if (!(typetoken instanceof GenericArrayType) && (!(typetoken instanceof Class) || !((Class)typetoken).isArray()))
        {
            return null;
        } else
        {
            typetoken = com.millennialmedia.google.gson.internal.yComponentType(typetoken);
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(typetoken)), com.millennialmedia.google.gson.internal.ype(typetoken));
        }
    }

    ()
    {
    }
}
