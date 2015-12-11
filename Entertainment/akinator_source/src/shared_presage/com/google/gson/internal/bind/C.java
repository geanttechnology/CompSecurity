// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.reflect.TypeToken;

final class C
    implements TypeAdapterFactory
{

    C()
    {
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        typetoken = typetoken.getRawType();
        if (!java/lang/Enum.isAssignableFrom(typetoken) || typetoken == java/lang/Enum)
        {
            return null;
        }
        gson = typetoken;
        if (!typetoken.isEnum())
        {
            gson = typetoken.getSuperclass();
        }
        return new TypeAdapters.a(gson);
    }
}
