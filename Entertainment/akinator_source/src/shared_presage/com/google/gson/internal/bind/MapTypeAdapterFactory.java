// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.JsonElement;
import shared_presage.com.google.gson.JsonPrimitive;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.internal.ConstructorConstructor;
import shared_presage.com.google.gson.internal.JsonReaderInternalAccess;
import shared_presage.com.google.gson.internal.ObjectConstructor;
import shared_presage.com.google.gson.internal.Streams;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            TypeAdapters, i

public final class MapTypeAdapterFactory
    implements TypeAdapterFactory
{
    private final class a extends TypeAdapter
    {

        final MapTypeAdapterFactory a;
        private final TypeAdapter b;
        private final TypeAdapter c;
        private final ObjectConstructor d;

        public final Object read(JsonReader jsonreader)
        {
            JsonToken jsontoken = jsonreader.peek();
            if (jsontoken == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            Map map = (Map)d.construct();
            if (jsontoken == JsonToken.BEGIN_ARRAY)
            {
                jsonreader.beginArray();
                for (; jsonreader.hasNext(); jsonreader.endArray())
                {
                    jsonreader.beginArray();
                    Object obj = b.read(jsonreader);
                    if (map.put(obj, c.read(jsonreader)) != null)
                    {
                        throw new JsonSyntaxException((new StringBuilder("duplicate key: ")).append(obj).toString());
                    }
                }

                jsonreader.endArray();
                return map;
            }
            jsonreader.beginObject();
            while (jsonreader.hasNext()) 
            {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonreader);
                Object obj1 = b.read(jsonreader);
                if (map.put(obj1, c.read(jsonreader)) != null)
                {
                    throw new JsonSyntaxException((new StringBuilder("duplicate key: ")).append(obj1).toString());
                }
            }
            jsonreader.endObject();
            return map;
        }

        public final void write(JsonWriter jsonwriter, Object obj)
        {
            boolean flag3 = false;
            boolean flag2 = false;
            obj = (Map)obj;
            if (obj == null)
            {
                jsonwriter.nullValue();
                return;
            }
            if (!a.complexMapKeySerialization)
            {
                jsonwriter.beginObject();
                java.util.Map.Entry entry;
                for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); c.write(jsonwriter, entry.getValue()))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    jsonwriter.name(String.valueOf(entry.getKey()));
                }

                jsonwriter.endObject();
                return;
            }
            ArrayList arraylist = new ArrayList(((Map) (obj)).size());
            ArrayList arraylist1 = new ArrayList(((Map) (obj)).size());
            obj = ((Map) (obj)).entrySet().iterator();
            boolean flag = false;
            while (((Iterator) (obj)).hasNext()) 
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                JsonElement jsonelement = b.toJsonTree(entry1.getKey());
                arraylist.add(jsonelement);
                arraylist1.add(entry1.getValue());
                boolean flag1;
                if (jsonelement.isJsonArray() || jsonelement.isJsonObject())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = flag1 | flag;
            }
            if (flag)
            {
                jsonwriter.beginArray();
                for (int j = ((flag2) ? 1 : 0); j < arraylist.size(); j++)
                {
                    jsonwriter.beginArray();
                    Streams.write((JsonElement)arraylist.get(j), jsonwriter);
                    c.write(jsonwriter, arraylist1.get(j));
                    jsonwriter.endArray();
                }

                jsonwriter.endArray();
                return;
            }
            jsonwriter.beginObject();
            int k = ((flag3) ? 1 : 0);
            while (k < arraylist.size()) 
            {
                obj = (JsonElement)arraylist.get(k);
                if (((JsonElement) (obj)).isJsonPrimitive())
                {
                    obj = ((JsonElement) (obj)).getAsJsonPrimitive();
                    if (((JsonPrimitive) (obj)).isNumber())
                    {
                        obj = String.valueOf(((JsonPrimitive) (obj)).getAsNumber());
                    } else
                    if (((JsonPrimitive) (obj)).isBoolean())
                    {
                        obj = Boolean.toString(((JsonPrimitive) (obj)).getAsBoolean());
                    } else
                    if (((JsonPrimitive) (obj)).isString())
                    {
                        obj = ((JsonPrimitive) (obj)).getAsString();
                    } else
                    {
                        throw new AssertionError();
                    }
                } else
                if (((JsonElement) (obj)).isJsonNull())
                {
                    obj = "null";
                } else
                {
                    throw new AssertionError();
                }
                jsonwriter.name(((String) (obj)));
                c.write(jsonwriter, arraylist1.get(k));
                k++;
            }
            jsonwriter.endObject();
        }

        public a(Gson gson, Type type, TypeAdapter typeadapter, Type type1, TypeAdapter typeadapter1, ObjectConstructor objectconstructor)
        {
            a = MapTypeAdapterFactory.this;
            super();
            b = new i(gson, typeadapter, type);
            c = new i(gson, typeadapter1, type1);
            d = objectconstructor;
        }
    }


    private final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(ConstructorConstructor constructorconstructor, boolean flag)
    {
        constructorConstructor = constructorconstructor;
        complexMapKeySerialization = flag;
    }

    private TypeAdapter getKeyAdapter(Gson gson, Type type)
    {
        if (type == Boolean.TYPE || type == java/lang/Boolean)
        {
            return TypeAdapters.BOOLEAN_AS_STRING;
        } else
        {
            return gson.getAdapter(TypeToken.get(type));
        }
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Type type = typetoken.getType();
        if (!java/util/Map.isAssignableFrom(typetoken.getRawType()))
        {
            return null;
        } else
        {
            Type atype[] = shared_presage.com.google.gson.internal..Gson.Types.getMapKeyAndValueTypes(type, shared_presage.com.google.gson.internal..Gson.Types.getRawType(type));
            TypeAdapter typeadapter = getKeyAdapter(gson, atype[0]);
            TypeAdapter typeadapter1 = gson.getAdapter(TypeToken.get(atype[1]));
            typetoken = constructorConstructor.get(typetoken);
            return new a(gson, atype[0], typeadapter, atype[1], typeadapter1, typetoken);
        }
    }

}
