// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.reflect.TypeToken;

final class D
    implements TypeAdapterFactory
{

    final TypeToken a;
    final TypeAdapter b;

    D(TypeToken typetoken, TypeAdapter typeadapter)
    {
        a = typetoken;
        b = typeadapter;
        super();
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        if (typetoken.equals(a))
        {
            return b;
        } else
        {
            return null;
        }
    }
}
