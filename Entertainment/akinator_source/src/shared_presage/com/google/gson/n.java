// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import shared_presage.com.google.gson.internal.Streams;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson:
//            TypeAdapter, Gson, JsonElement, JsonDeserializer, 
//            JsonSerializer, TypeAdapterFactory

final class n extends TypeAdapter
{
    private static final class a
        implements TypeAdapterFactory
    {

        private final TypeToken a;
        private final boolean b;
        private final Class c;
        private final JsonSerializer d;
        private final JsonDeserializer e;

        public final TypeAdapter create(Gson gson, TypeToken typetoken)
        {
            boolean flag;
            if (a != null)
            {
                if (a.equals(typetoken) || b && a.getType() == typetoken.getRawType())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = c.isAssignableFrom(typetoken.getRawType());
            }
            if (flag)
            {
                return new n(d, e, gson, typetoken, this, (byte)0);
            } else
            {
                return null;
            }
        }

        private a(Object obj, TypeToken typetoken, boolean flag, Class class1)
        {
            JsonSerializer jsonserializer;
            boolean flag1;
            if (obj instanceof JsonSerializer)
            {
                jsonserializer = (JsonSerializer)obj;
            } else
            {
                jsonserializer = null;
            }
            d = jsonserializer;
            if (obj instanceof JsonDeserializer)
            {
                obj = (JsonDeserializer)obj;
            } else
            {
                obj = null;
            }
            e = ((JsonDeserializer) (obj));
            if (d != null || e != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            shared_presage.com.google.gson.internal..Gson.Preconditions.checkArgument(flag1);
            a = typetoken;
            b = flag;
            c = class1;
        }

        a(Object obj, TypeToken typetoken, boolean flag, Class class1, byte byte0)
        {
            this(obj, typetoken, flag, class1);
        }
    }


    private final JsonSerializer a;
    private final JsonDeserializer b;
    private final Gson c;
    private final TypeToken d;
    private final TypeAdapterFactory e;
    private TypeAdapter f;

    private n(JsonSerializer jsonserializer, JsonDeserializer jsondeserializer, Gson gson, TypeToken typetoken, TypeAdapterFactory typeadapterfactory)
    {
        a = jsonserializer;
        b = jsondeserializer;
        c = gson;
        d = typetoken;
        e = typeadapterfactory;
    }

    n(JsonSerializer jsonserializer, JsonDeserializer jsondeserializer, Gson gson, TypeToken typetoken, TypeAdapterFactory typeadapterfactory, byte byte0)
    {
        this(jsonserializer, jsondeserializer, gson, typetoken, typeadapterfactory);
    }

    private TypeAdapter a()
    {
        TypeAdapter typeadapter = f;
        if (typeadapter != null)
        {
            return typeadapter;
        } else
        {
            TypeAdapter typeadapter1 = c.getDelegateAdapter(e, d);
            f = typeadapter1;
            return typeadapter1;
        }
    }

    public static TypeAdapterFactory a(Class class1, Object obj)
    {
        return new a(obj, null, false, class1, (byte)0);
    }

    public static TypeAdapterFactory a(TypeToken typetoken, Object obj)
    {
        return new a(obj, typetoken, false, null, (byte)0);
    }

    public static TypeAdapterFactory b(TypeToken typetoken, Object obj)
    {
        boolean flag;
        if (typetoken.getType() == typetoken.getRawType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new a(obj, typetoken, flag, null, (byte)0);
    }

    public final Object read(JsonReader jsonreader)
    {
        if (b == null)
        {
            return a().read(jsonreader);
        }
        jsonreader = Streams.parse(jsonreader);
        if (jsonreader.isJsonNull())
        {
            return null;
        } else
        {
            return b.deserialize(jsonreader, d.getType(), c.deserializationContext);
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (a == null)
        {
            a().write(jsonwriter, obj);
            return;
        }
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            Streams.write(a.serialize(obj, d.getType(), c.serializationContext), jsonwriter);
            return;
        }
    }
}
