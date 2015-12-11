// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            a, i

public final class ArrayTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new a();
    private final Class componentType;
    private final TypeAdapter componentTypeAdapter;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeadapter, Class class1)
    {
        componentTypeAdapter = new i(gson, typeadapter, class1);
        componentType = class1;
    }

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        jsonreader.beginArray();
        for (; jsonreader.hasNext(); arraylist.add(componentTypeAdapter.read(jsonreader))) { }
        jsonreader.endArray();
        jsonreader = ((JsonReader) (Array.newInstance(componentType, arraylist.size())));
        for (int j = 0; j < arraylist.size(); j++)
        {
            Array.set(jsonreader, j, arraylist.get(j));
        }

        return jsonreader;
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginArray();
        int j = 0;
        for (int k = Array.getLength(obj); j < k; j++)
        {
            Object obj1 = Array.get(obj, j);
            componentTypeAdapter.write(jsonwriter, obj1);
        }

        jsonwriter.endArray();
    }

}
