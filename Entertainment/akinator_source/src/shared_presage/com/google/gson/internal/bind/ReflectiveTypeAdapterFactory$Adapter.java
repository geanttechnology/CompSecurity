// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.internal.ObjectConstructor;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            ReflectiveTypeAdapterFactory, f

public static final class <init> extends TypeAdapter
{

    private final Map boundFields;
    private final ObjectConstructor constructor;

    public final Object read(JsonReader jsonreader)
    {
        Object obj;
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        obj = constructor.construct();
        jsonreader.beginObject();
_L1:
        Object obj1;
        if (!jsonreader.hasNext())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj1 = jsonreader.nextName();
        obj1 = (constructor)boundFields.get(obj1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((boundFields) (obj1)).boundFields)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        jsonreader.skipValue();
          goto _L1
        try
        {
            ((boundFields) (obj1)).boundFields(jsonreader, obj);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException(jsonreader);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new AssertionError(jsonreader);
        }
          goto _L1
        jsonreader.endObject();
        return obj;
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginObject();
        try
        {
            Iterator iterator = boundFields.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                boundFields boundfields = (boundFields)iterator.next();
                if (boundfields.boundFields)
                {
                    jsonwriter.name(boundfields.boundFields);
                    boundfields.boundFields(jsonwriter, obj);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (JsonWriter jsonwriter)
        {
            throw new AssertionError();
        }
        jsonwriter.endObject();
    }

    private (ObjectConstructor objectconstructor, Map map)
    {
        constructor = objectconstructor;
        boundFields = map;
    }

    boundFields(ObjectConstructor objectconstructor, Map map, f f)
    {
        this(objectconstructor, map);
    }
}
