// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.gson;

import com.socialin.gson.internal.ConstructorConstructor;
import com.socialin.gson.internal.Excluder;
import com.socialin.gson.internal.GsonInternalAccess;
import com.socialin.gson.internal.Primitives;
import com.socialin.gson.internal.Streams;
import com.socialin.gson.internal.bind.ArrayTypeAdapter;
import com.socialin.gson.internal.bind.BigDecimalTypeAdapter;
import com.socialin.gson.internal.bind.BigIntegerTypeAdapter;
import com.socialin.gson.internal.bind.CollectionTypeAdapterFactory;
import com.socialin.gson.internal.bind.DateTypeAdapter;
import com.socialin.gson.internal.bind.JsonTreeReader;
import com.socialin.gson.internal.bind.JsonTreeWriter;
import com.socialin.gson.internal.bind.MapTypeAdapterFactory;
import com.socialin.gson.internal.bind.ObjectTypeAdapter;
import com.socialin.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.socialin.gson.internal.bind.SqlDateTypeAdapter;
import com.socialin.gson.internal.bind.TimeTypeAdapter;
import com.socialin.gson.internal.bind.TypeAdapters;
import com.socialin.gson.reflect.TypeToken;
import com.socialin.gson.stream.JsonReader;
import com.socialin.gson.stream.JsonToken;
import com.socialin.gson.stream.JsonWriter;
import com.socialin.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.socialin.gson:
//            FieldNamingPolicy, LongSerializationPolicy, JsonIOException, JsonSyntaxException, 
//            TypeAdapter, TypeAdapterFactory, JsonNull, JsonDeserializationContext, 
//            JsonSerializationContext, FieldNamingStrategy, JsonElement

public final class Gson
{

    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private final ThreadLocal calls;
    private final ConstructorConstructor constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map typeTokenCache;

    public Gson()
    {
        this(Excluder.DEFAULT, ((FieldNamingStrategy) (FieldNamingPolicy.IDENTITY)), Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldnamingstrategy, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, LongSerializationPolicy longserializationpolicy, List list)
    {
        calls = new _cls1();
        typeTokenCache = Collections.synchronizedMap(new HashMap());
        deserializationContext = new _cls2();
        serializationContext = new _cls3();
        constructorConstructor = new ConstructorConstructor(map);
        serializeNulls = flag;
        generateNonExecutableJson = flag2;
        htmlSafe = flag3;
        prettyPrinting = flag4;
        fieldnamingstrategy = new ReflectiveTypeAdapterFactory(constructorConstructor, fieldnamingstrategy, excluder);
        map = new ConstructorConstructor();
        ArrayList arraylist = new ArrayList();
        arraylist.add(TypeAdapters.STRING_FACTORY);
        arraylist.add(TypeAdapters.INTEGER_FACTORY);
        arraylist.add(TypeAdapters.BOOLEAN_FACTORY);
        arraylist.add(TypeAdapters.BYTE_FACTORY);
        arraylist.add(TypeAdapters.SHORT_FACTORY);
        arraylist.add(TypeAdapters.newFactory(Long.TYPE, java/lang/Long, longAdapter(longserializationpolicy)));
        arraylist.add(TypeAdapters.newFactory(Double.TYPE, java/lang/Double, doubleAdapter(flag5)));
        arraylist.add(TypeAdapters.newFactory(Float.TYPE, java/lang/Float, floatAdapter(flag5)));
        arraylist.add(excluder);
        arraylist.add(TypeAdapters.NUMBER_FACTORY);
        arraylist.add(TypeAdapters.CHARACTER_FACTORY);
        arraylist.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arraylist.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arraylist.add(TypeAdapters.newFactory(java/math/BigDecimal, new BigDecimalTypeAdapter()));
        arraylist.add(TypeAdapters.newFactory(java/math/BigInteger, new BigIntegerTypeAdapter()));
        arraylist.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arraylist.add(ObjectTypeAdapter.FACTORY);
        arraylist.addAll(list);
        arraylist.add(new CollectionTypeAdapterFactory(map));
        arraylist.add(TypeAdapters.URL_FACTORY);
        arraylist.add(TypeAdapters.URI_FACTORY);
        arraylist.add(TypeAdapters.UUID_FACTORY);
        arraylist.add(TypeAdapters.LOCALE_FACTORY);
        arraylist.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arraylist.add(TypeAdapters.BIT_SET_FACTORY);
        arraylist.add(DateTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.CALENDAR_FACTORY);
        arraylist.add(TimeTypeAdapter.FACTORY);
        arraylist.add(SqlDateTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.TIMESTAMP_FACTORY);
        arraylist.add(new MapTypeAdapterFactory(map, flag1));
        arraylist.add(ArrayTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.ENUM_FACTORY);
        arraylist.add(TypeAdapters.CLASS_FACTORY);
        arraylist.add(fieldnamingstrategy);
        factories = Collections.unmodifiableList(arraylist);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonreader)
    {
        if (obj != null)
        {
            try
            {
                if (jsonreader.peek() != JsonToken.END_DOCUMENT)
                {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new JsonSyntaxException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new JsonIOException(((Throwable) (obj)));
            }
        }
    }

    private void checkValidFloatingPoint(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialDoubleValues() method.").toString());
        } else
        {
            return;
        }
    }

    private TypeAdapter doubleAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.DOUBLE;
        } else
        {
            return new _cls4();
        }
    }

    private TypeAdapter floatAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.FLOAT;
        } else
        {
            return new _cls5();
        }
    }

    private TypeAdapter longAdapter(LongSerializationPolicy longserializationpolicy)
    {
        if (longserializationpolicy == LongSerializationPolicy.DEFAULT)
        {
            return TypeAdapters.LONG;
        } else
        {
            return new _cls6();
        }
    }

    private JsonWriter newJsonWriter(Writer writer)
    {
        if (generateNonExecutableJson)
        {
            writer.write(")]}'\n");
        }
        writer = new JsonWriter(writer);
        if (prettyPrinting)
        {
            writer.setIndent("  ");
        }
        writer.setSerializeNulls(serializeNulls);
        return writer;
    }

    public final Object fromJson(JsonElement jsonelement, Class class1)
    {
        jsonelement = ((JsonElement) (fromJson(jsonelement, ((Type) (class1)))));
        return Primitives.wrap(class1).cast(jsonelement);
    }

    public final Object fromJson(JsonElement jsonelement, Type type)
    {
        if (jsonelement == null)
        {
            return null;
        } else
        {
            return fromJson(((JsonReader) (new JsonTreeReader(jsonelement))), type);
        }
    }

    public final Object fromJson(JsonReader jsonreader, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = jsonreader.isLenient();
        jsonreader.setLenient(true);
        jsonreader.peek();
        flag = false;
        type = ((Type) (getAdapter(TypeToken.get(type)).read(jsonreader)));
        jsonreader.setLenient(flag1);
        return type;
        type;
        if (flag)
        {
            jsonreader.setLenient(flag1);
            return null;
        }
        throw new JsonSyntaxException(type);
        type;
        jsonreader.setLenient(flag1);
        throw type;
        type;
        throw new JsonSyntaxException(type);
        type;
        throw new JsonSyntaxException(type);
    }

    public final Object fromJson(Reader reader, Class class1)
    {
        reader = new JsonReader(reader);
        Object obj = fromJson(((JsonReader) (reader)), ((Type) (class1)));
        assertFullConsumption(obj, reader);
        return Primitives.wrap(class1).cast(obj);
    }

    public final Object fromJson(Reader reader, Type type)
    {
        reader = new JsonReader(reader);
        type = ((Type) (fromJson(((JsonReader) (reader)), type)));
        assertFullConsumption(type, reader);
        return type;
    }

    public final Object fromJson(String s, Class class1)
    {
        s = ((String) (fromJson(s, ((Type) (class1)))));
        return Primitives.wrap(class1).cast(s);
    }

    public final Object fromJson(String s, Type type)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return fromJson(((Reader) (new StringReader(s))), type);
        }
    }

    public final TypeAdapter getAdapter(TypeToken typetoken)
    {
        Object obj;
        FutureTypeAdapter futuretypeadapter;
        obj = (TypeAdapter)typeTokenCache.get(typetoken);
        if (obj != null)
        {
            return ((TypeAdapter) (obj));
        }
        obj = (Map)calls.get();
        futuretypeadapter = (FutureTypeAdapter)((Map) (obj)).get(typetoken);
        if (futuretypeadapter != null)
        {
            return futuretypeadapter;
        }
        futuretypeadapter = new FutureTypeAdapter();
        ((Map) (obj)).put(typetoken, futuretypeadapter);
        Iterator iterator = factories.iterator();
        TypeAdapter typeadapter;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_140;
            }
            typeadapter = ((TypeAdapterFactory)iterator.next()).create(this, typetoken);
        } while (typeadapter == null);
        futuretypeadapter.setDelegate(typeadapter);
        typeTokenCache.put(typetoken, typeadapter);
        ((Map) (obj)).remove(typetoken);
        return typeadapter;
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(typetoken).toString());
        Exception exception;
        exception;
        ((Map) (obj)).remove(typetoken);
        throw exception;
    }

    public final TypeAdapter getAdapter(Class class1)
    {
        return getAdapter(TypeToken.get(class1));
    }

    public final String toJson(JsonElement jsonelement)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(jsonelement, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    public final String toJson(Object obj)
    {
        if (obj == null)
        {
            return toJson(((JsonElement) (JsonNull.INSTANCE)));
        } else
        {
            return toJson(obj, ((Type) (obj.getClass())));
        }
    }

    public final String toJson(Object obj, Type type)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(obj, type, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    public final void toJson(JsonElement jsonelement, JsonWriter jsonwriter)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(htmlSafe);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(serializeNulls);
        Streams.write(jsonelement, jsonwriter);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        jsonelement;
        throw new JsonIOException(jsonelement);
        jsonelement;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw jsonelement;
    }

    public final void toJson(JsonElement jsonelement, Appendable appendable)
    {
        try
        {
            toJson(jsonelement, newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JsonElement jsonelement)
        {
            throw new RuntimeException(jsonelement);
        }
    }

    public final void toJson(Object obj, Appendable appendable)
    {
        if (obj != null)
        {
            toJson(obj, ((Type) (obj.getClass())), appendable);
            return;
        } else
        {
            toJson(((JsonElement) (JsonNull.INSTANCE)), appendable);
            return;
        }
    }

    public final void toJson(Object obj, Type type, JsonWriter jsonwriter)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        type = getAdapter(TypeToken.get(type));
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(htmlSafe);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(serializeNulls);
        type.write(jsonwriter, obj);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        obj;
        throw new JsonIOException(((Throwable) (obj)));
        obj;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw obj;
    }

    public final void toJson(Object obj, Type type, Appendable appendable)
    {
        try
        {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new JsonIOException(((Throwable) (obj)));
        }
    }

    public final JsonElement toJsonTree(Object obj)
    {
        if (obj == null)
        {
            return JsonNull.INSTANCE;
        } else
        {
            return toJsonTree(obj, ((Type) (obj.getClass())));
        }
    }

    public final JsonElement toJsonTree(Object obj, Type type)
    {
        JsonTreeWriter jsontreewriter = new JsonTreeWriter();
        toJson(obj, type, jsontreewriter);
        return jsontreewriter.get();
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(serializeNulls).append("factories:").append(factories).append(",instanceCreators:").append(constructorConstructor).append("}").toString();
    }

    static 
    {
        GsonInternalAccess.INSTANCE = new _cls7();
    }



    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class FutureTypeAdapter {}


    /* member class not found */
    class _cls7 {}

}
