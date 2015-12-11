// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Field;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            i, ReflectiveTypeAdapterFactory

final class f extends ReflectiveTypeAdapterFactory.a
{

    final TypeAdapter a;
    final Gson b;
    final TypeToken c;
    final Field d;
    final boolean e;
    final ReflectiveTypeAdapterFactory f;

    f(ReflectiveTypeAdapterFactory reflectivetypeadapterfactory, String s, boolean flag, boolean flag1, Gson gson, TypeToken typetoken, Field field, 
            boolean flag2)
    {
        f = reflectivetypeadapterfactory;
        b = gson;
        c = typetoken;
        d = field;
        e = flag2;
        super(s, flag, flag1);
        a = b.getAdapter(c);
    }

    final void a(JsonReader jsonreader, Object obj)
    {
        jsonreader = ((JsonReader) (a.read(jsonreader)));
        if (jsonreader != null || !e)
        {
            d.set(obj, jsonreader);
        }
    }

    final void a(JsonWriter jsonwriter, Object obj)
    {
        obj = d.get(obj);
        (new i(b, a, c.getType())).write(jsonwriter, obj);
    }
}
