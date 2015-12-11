// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonWriter;

final class i extends TypeAdapter
{

    private final Gson a;
    private final TypeAdapter b;
    private final Type c;

    i(Gson gson, TypeAdapter typeadapter, Type type)
    {
        a = gson;
        b = typeadapter;
        c = type;
    }

    public final Object read(JsonReader jsonreader)
    {
        return b.read(jsonreader);
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        Object obj1;
        TypeAdapter typeadapter;
label0:
        {
            typeadapter = b;
            Type type = c;
            obj1 = type;
            if (obj == null)
            {
                break label0;
            }
            if (type != java/lang/Object && !(type instanceof TypeVariable))
            {
                obj1 = type;
                if (!(type instanceof Class))
                {
                    break label0;
                }
            }
            obj1 = obj.getClass();
        }
        if (obj1 != c)
        {
            typeadapter = a.getAdapter(TypeToken.get(((Type) (obj1))));
            obj1 = typeadapter;
            if (typeadapter instanceof ReflectiveTypeAdapterFactory.Adapter)
            {
                obj1 = typeadapter;
                if (!(b instanceof ReflectiveTypeAdapterFactory.Adapter))
                {
                    obj1 = b;
                }
            }
        } else
        {
            obj1 = typeadapter;
        }
        ((TypeAdapter) (obj1)).write(jsonwriter, obj);
    }
}
