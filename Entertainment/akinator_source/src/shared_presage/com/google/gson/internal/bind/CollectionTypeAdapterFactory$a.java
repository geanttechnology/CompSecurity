// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.internal.ObjectConstructor;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            CollectionTypeAdapterFactory, i

private static final class b extends TypeAdapter
{

    private final TypeAdapter a;
    private final ObjectConstructor b;

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        Collection collection = (Collection)b.construct();
        jsonreader.beginArray();
        for (; jsonreader.hasNext(); collection.add(a.read(jsonreader))) { }
        jsonreader.endArray();
        return collection;
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (Collection)obj;
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginArray();
        Object obj1;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.write(jsonwriter, obj1))
        {
            obj1 = ((Iterator) (obj)).next();
        }

        jsonwriter.endArray();
    }

    public Q(Gson gson, Type type, TypeAdapter typeadapter, ObjectConstructor objectconstructor)
    {
        a = new i(gson, typeadapter, type);
        b = objectconstructor;
    }
}
