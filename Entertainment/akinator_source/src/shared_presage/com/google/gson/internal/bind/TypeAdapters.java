// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import shared_presage.com.google.gson.JsonElement;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.annotations.SerializedName;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            j, u, G, J, 
//            K, L, M, N, 
//            O, k, l, m, 
//            n, o, p, q, 
//            r, s, t, v, 
//            w, x, z, A, 
//            B, C, F, E, 
//            D, H, I

public final class TypeAdapters
{
    private static final class a extends TypeAdapter
    {

        private final Map a;
        private final Map b;

        public final Object read(JsonReader jsonreader)
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return (Enum)a.get(jsonreader.nextString());
            }
        }

        public final void write(JsonWriter jsonwriter, Object obj)
        {
            obj = (Enum)obj;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = (String)b.get(obj);
            }
            jsonwriter.value(((String) (obj)));
        }

        public a(Class class1)
        {
            a = new HashMap();
            b = new HashMap();
            String s1;
            Enum aenum[];
            Enum enum;
            SerializedName serializedname;
            int i;
            int i1;
            try
            {
                aenum = (Enum[])class1.getEnumConstants();
                i1 = aenum.length;
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new AssertionError();
            }
            i = 0;
            if (i >= i1)
            {
                break; /* Loop/switch isn't completed */
            }
            enum = aenum[i];
            s1 = enum.name();
            serializedname = (SerializedName)class1.getField(s1).getAnnotation(shared_presage/com/google/gson/annotations/SerializedName);
            if (serializedname == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            s1 = serializedname.value();
            a.put(s1, enum);
            b.put(enum, s1);
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_41;
_L1:
        }
    }


    public static final TypeAdapter BIG_DECIMAL = new o();
    public static final TypeAdapter BIG_INTEGER = new p();
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING = new J();
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter DOUBLE = new k();
    public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();
    public static final TypeAdapter FLOAT = new O();
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG = new N();
    public static final TypeAdapter NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = new x();
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    private TypeAdapters()
    {
    }

    public static TypeAdapterFactory newEnumTypeHierarchyFactory()
    {
        return new C();
    }

    public static TypeAdapterFactory newFactory(Class class1, Class class2, TypeAdapter typeadapter)
    {
        return new F(class1, class2, typeadapter);
    }

    public static TypeAdapterFactory newFactory(Class class1, TypeAdapter typeadapter)
    {
        return new E(class1, typeadapter);
    }

    public static TypeAdapterFactory newFactory(TypeToken typetoken, TypeAdapter typeadapter)
    {
        return new D(typetoken, typeadapter);
    }

    public static TypeAdapterFactory newFactoryForMultipleTypes(Class class1, Class class2, TypeAdapter typeadapter)
    {
        return new H(class1, class2, typeadapter);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class class1, TypeAdapter typeadapter)
    {
        return new I(class1, typeadapter);
    }

    static 
    {
        CLASS = new j();
        CLASS_FACTORY = newFactory(java/lang/Class, CLASS);
        BIT_SET = new u();
        BIT_SET_FACTORY = newFactory(java/util/BitSet, BIT_SET);
        BOOLEAN = new G();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, java/lang/Boolean, BOOLEAN);
        BYTE = new K();
        BYTE_FACTORY = newFactory(Byte.TYPE, java/lang/Byte, BYTE);
        SHORT = new L();
        SHORT_FACTORY = newFactory(Short.TYPE, java/lang/Short, SHORT);
        INTEGER = new M();
        INTEGER_FACTORY = newFactory(Integer.TYPE, java/lang/Integer, INTEGER);
        NUMBER = new l();
        NUMBER_FACTORY = newFactory(java/lang/Number, NUMBER);
        CHARACTER = new m();
        CHARACTER_FACTORY = newFactory(Character.TYPE, java/lang/Character, CHARACTER);
        STRING = new n();
        STRING_FACTORY = newFactory(java/lang/String, STRING);
        STRING_BUILDER = new q();
        STRING_BUILDER_FACTORY = newFactory(java/lang/StringBuilder, STRING_BUILDER);
        STRING_BUFFER = new r();
        STRING_BUFFER_FACTORY = newFactory(java/lang/StringBuffer, STRING_BUFFER);
        URL = new s();
        URL_FACTORY = newFactory(java/net/URL, URL);
        URI = new t();
        URI_FACTORY = newFactory(java/net/URI, URI);
        INET_ADDRESS = new v();
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(java/net/InetAddress, INET_ADDRESS);
        UUID = new w();
        UUID_FACTORY = newFactory(java/util/UUID, UUID);
        CALENDAR = new z();
        CALENDAR_FACTORY = newFactoryForMultipleTypes(java/util/Calendar, java/util/GregorianCalendar, CALENDAR);
        LOCALE = new A();
        LOCALE_FACTORY = newFactory(java/util/Locale, LOCALE);
        JSON_ELEMENT = new B();
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(shared_presage/com/google/gson/JsonElement, JSON_ELEMENT);
    }

    // Unreferenced inner class shared_presage/com/google/gson/internal/bind/TypeAdapters$1

/* anonymous class */
    static final class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[JsonToken.values().length];
            try
            {
                a[JsonToken.NUMBER.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                a[JsonToken.BOOLEAN.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                a[JsonToken.STRING.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                a[JsonToken.NULL.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[JsonToken.NAME.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[JsonToken.END_OBJECT.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[JsonToken.END_ARRAY.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
