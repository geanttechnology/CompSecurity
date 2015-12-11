// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.internal.LinkedTreeMap;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            e

public final class ObjectTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new e();
    private final Gson gson;

    private ObjectTypeAdapter(Gson gson1)
    {
        gson = gson1;
    }

    ObjectTypeAdapter(Gson gson1, e e1)
    {
        this(gson1);
    }

    public final Object read(JsonReader jsonreader)
    {
        JsonToken jsontoken = jsonreader.peek();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[JsonToken.values().length];
                try
                {
                    a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[JsonToken.STRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[JsonToken.NUMBER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[JsonToken.BOOLEAN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[JsonToken.NULL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[jsontoken.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); arraylist.add(read(jsonreader))) { }
            jsonreader.endArray();
            return arraylist;

        case 2: // '\002'
            LinkedTreeMap linkedtreemap = new LinkedTreeMap();
            jsonreader.beginObject();
            for (; jsonreader.hasNext(); linkedtreemap.put(jsonreader.nextName(), read(jsonreader))) { }
            jsonreader.endObject();
            return linkedtreemap;

        case 3: // '\003'
            return jsonreader.nextString();

        case 4: // '\004'
            return Double.valueOf(jsonreader.nextDouble());

        case 5: // '\005'
            return Boolean.valueOf(jsonreader.nextBoolean());

        case 6: // '\006'
            jsonreader.nextNull();
            return null;
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        TypeAdapter typeadapter = gson.getAdapter(obj.getClass());
        if (typeadapter instanceof ObjectTypeAdapter)
        {
            jsonwriter.beginObject();
            jsonwriter.endObject();
            return;
        } else
        {
            typeadapter.write(jsonwriter, obj);
            return;
        }
    }

}
