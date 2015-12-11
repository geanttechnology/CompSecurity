// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import shared_presage.com.google.gson.FieldNamingStrategy;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.annotations.SerializedName;
import shared_presage.com.google.gson.internal.ConstructorConstructor;
import shared_presage.com.google.gson.internal.Excluder;
import shared_presage.com.google.gson.internal.ObjectConstructor;
import shared_presage.com.google.gson.internal.Primitives;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            f

public final class ReflectiveTypeAdapterFactory
    implements TypeAdapterFactory
{
    public static final class Adapter extends TypeAdapter
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
            obj1 = (a)boundFields.get(obj1);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            if (((a) (obj1)).i)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            jsonreader.skipValue();
              goto _L1
            try
            {
                ((a) (obj1)).a(jsonreader, obj);
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
                    a a1 = (a)iterator.next();
                    if (a1.h)
                    {
                        jsonwriter.name(a1.g);
                        a1.a(jsonwriter, obj);
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

        private Adapter(ObjectConstructor objectconstructor, Map map)
        {
            constructor = objectconstructor;
            boundFields = map;
        }

        Adapter(ObjectConstructor objectconstructor, Map map, f f1)
        {
            this(objectconstructor, map);
        }
    }

    static abstract class a
    {

        final String g;
        final boolean h;
        final boolean i;

        abstract void a(JsonReader jsonreader, Object obj);

        abstract void a(JsonWriter jsonwriter, Object obj);

        protected a(String s, boolean flag, boolean flag1)
        {
            g = s;
            h = flag;
            i = flag1;
        }
    }


    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorconstructor, FieldNamingStrategy fieldnamingstrategy, Excluder excluder1)
    {
        constructorConstructor = constructorconstructor;
        fieldNamingPolicy = fieldnamingstrategy;
        excluder = excluder1;
    }

    private a createBoundField(Gson gson, Field field, String s, TypeToken typetoken, boolean flag, boolean flag1)
    {
        return new f(this, s, flag, flag1, gson, typetoken, field, Primitives.isPrimitive(typetoken.getRawType()));
    }

    private Map getBoundFields(Gson gson, TypeToken typetoken, Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        java.lang.reflect.Type type = typetoken.getType();
        for (; class1 != java/lang/Object; class1 = typetoken.getRawType())
        {
            Field afield[] = class1.getDeclaredFields();
            int j = afield.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = afield[i];
                boolean flag = excludeField(((Field) (obj)), true);
                boolean flag1 = excludeField(((Field) (obj)), false);
                if (!flag && !flag1)
                {
                    continue;
                }
                ((Field) (obj)).setAccessible(true);
                java.lang.reflect.Type type1 = shared_presage.com.google.gson.internal..Gson.Types.resolve(typetoken.getType(), class1, ((Field) (obj)).getGenericType());
                obj = createBoundField(gson, ((Field) (obj)), getFieldName(((Field) (obj))), TypeToken.get(type1), flag, flag1);
                obj = (a)linkedhashmap.put(((a) (obj)).g, obj);
                if (obj != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(((a) (obj)).g).toString());
                }
            }

            typetoken = TypeToken.get(shared_presage.com.google.gson.internal..Gson.Types.resolve(typetoken.getType(), class1, class1.getGenericSuperclass()));
        }

        return linkedhashmap;
    }

    private String getFieldName(Field field)
    {
        SerializedName serializedname = (SerializedName)field.getAnnotation(shared_presage/com/google/gson/annotations/SerializedName);
        if (serializedname == null)
        {
            return fieldNamingPolicy.translateName(field);
        } else
        {
            return serializedname.value();
        }
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Class class1 = typetoken.getRawType();
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new Adapter(constructorConstructor.get(typetoken), getBoundFields(gson, typetoken, class1), null);
        }
    }

    public final boolean excludeField(Field field, boolean flag)
    {
        return !excluder.excludeClass(field.getType(), flag) && !excluder.excludeField(field, flag);
    }
}
