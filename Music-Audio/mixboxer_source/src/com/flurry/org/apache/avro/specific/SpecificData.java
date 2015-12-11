// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Protocol;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericData;
import com.flurry.org.apache.avro.io.DatumReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificDatumReader

public class SpecificData extends GenericData
{
    public static interface SchemaConstructable
    {
    }


    private static final Map CTOR_CACHE = new ConcurrentHashMap();
    private static final SpecificData INSTANCE = new SpecificData();
    private static final Class NO_ARG[] = new Class[0];
    private static final Class NO_CLASS = (new Object() {

    }).getClass();
    private static final Schema NULL_SCHEMA;
    private static final Class SCHEMA_ARG[] = {
        com/flurry/org/apache/avro/Schema
    };
    private Map classCache;
    private final ClassLoader classLoader;
    private final WeakHashMap schemaCache;

    protected SpecificData()
    {
        this(com/flurry/org/apache/avro/specific/SpecificData.getClassLoader());
    }

    public SpecificData(ClassLoader classloader)
    {
        classCache = new ConcurrentHashMap();
        schemaCache = new WeakHashMap();
        classLoader = classloader;
    }

    public static SpecificData get()
    {
        return INSTANCE;
    }

    public static String getClassName(Schema schema)
    {
        String s = schema.getNamespace();
        String s1 = schema.getName();
        if (s == null || "".equals(s))
        {
            return s1;
        }
        if (s.endsWith("$"))
        {
            schema = "";
        } else
        {
            schema = ".";
        }
        return (new StringBuilder()).append(s).append(schema).append(s1).toString();
    }

    public static Object newInstance(Class class1, Schema schema)
    {
        boolean flag = com/flurry/org/apache/avro/specific/SpecificData$SchemaConstructable.isAssignableFrom(class1);
        Object obj;
        Constructor constructor;
        try
        {
            constructor = (Constructor)CTOR_CACHE.get(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1);
        }
        obj = constructor;
        if (constructor != null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        obj = SCHEMA_ARG;
_L5:
        obj = class1.getDeclaredConstructor(((Class []) (obj)));
        ((Constructor) (obj)).setAccessible(true);
        CTOR_CACHE.put(class1, obj);
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        class1 = ((Class) (new Object[1]));
        class1[0] = schema;
_L6:
        return ((Constructor) (obj)).newInstance(class1);
_L4:
        obj = NO_ARG;
          goto _L5
        class1 = ((Class) ((Object[])null));
          goto _L6
    }

    protected int compare(Object obj, Object obj1, Schema schema, boolean flag)
    {
        static class _cls2
        {

            static final int $SwitchMap$org$apache$avro$Schema$Type[];

            static 
            {
                $SwitchMap$org$apache$avro$Schema$Type = new int[com.flurry.org.apache.avro.Schema.Type.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FIXED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.RECORD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ENUM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ARRAY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.MAP.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.UNION.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.STRING.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BYTES.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.INT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.LONG.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FLOAT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.DOUBLE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BOOLEAN.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.NULL.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 3 3: default 28
    //                   3 38;
           goto _L1 _L2
_L1:
        return super.compare(obj, obj1, schema, flag);
_L2:
        if (obj instanceof Enum)
        {
            return ((Enum)obj).ordinal() - ((Enum)obj1).ordinal();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public DatumReader createDatumReader(Schema schema)
    {
        return new SpecificDatumReader(schema, schema, this);
    }

    public Object createFixed(Object obj, Schema schema)
    {
        Class class1 = get().getClass(schema);
        Object obj1;
        if (class1 == null)
        {
            obj1 = super.createFixed(obj, schema);
        } else
        {
            obj1 = obj;
            if (!class1.isInstance(obj))
            {
                return newInstance(class1, schema);
            }
        }
        return obj1;
    }

    protected Schema createSchema(Type type, Map map)
    {
        if ((type instanceof Class) && java/lang/CharSequence.isAssignableFrom((Class)type))
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.STRING);
        }
        if (type == java/nio/ByteBuffer)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.BYTES);
        }
        if (type == java/lang/Integer || type == Integer.TYPE)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.INT);
        }
        if (type == java/lang/Long || type == Long.TYPE)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.LONG);
        }
        if (type == java/lang/Float || type == Float.TYPE)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.FLOAT);
        }
        if (type == java/lang/Double || type == Double.TYPE)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.DOUBLE);
        }
        if (type == java/lang/Boolean || type == Boolean.TYPE)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.BOOLEAN);
        }
        if (type == java/lang/Void || type == Void.TYPE)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.NULL);
        }
        if (type instanceof ParameterizedType)
        {
            ParameterizedType parameterizedtype = (ParameterizedType)type;
            Object obj = (Class)parameterizedtype.getRawType();
            Type atype[] = parameterizedtype.getActualTypeArguments();
            if (java/util/Collection.isAssignableFrom(((Class) (obj))))
            {
                if (atype.length != 1)
                {
                    throw new AvroTypeException("No array type specified.");
                } else
                {
                    return Schema.createArray(createSchema(atype[0], map));
                }
            }
            if (java/util/Map.isAssignableFrom(((Class) (obj))))
            {
                obj = atype[0];
                Type type1 = atype[1];
                if (!(type instanceof Class) || !java/lang/CharSequence.isAssignableFrom((Class)type))
                {
                    throw new AvroTypeException((new StringBuilder()).append("Map key class not CharSequence: ").append(obj).toString());
                } else
                {
                    return Schema.createMap(createSchema(type1, map));
                }
            } else
            {
                return createSchema(((Type) (obj)), map);
            }
        }
        if (!(type instanceof Class))
        {
            break MISSING_BLOCK_LABEL_464;
        }
        Class class1 = (Class)type;
        String s = class1.getName();
        Schema schema = (Schema)map.get(s);
        type = schema;
        if (schema != null)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        try
        {
            schema = (Schema)(Schema)class1.getDeclaredField("SCHEMA$").get(null);
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Not a Specific class: ").append(class1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            throw new AvroRuntimeException(type);
        }
        type = schema;
        if (!s.equals(getClassName(schema)))
        {
            type = Schema.parse(schema.toString().replace(schema.getNamespace(), class1.getPackage().getName()));
        }
        map.put(s, type);
        return type;
        throw new AvroTypeException((new StringBuilder()).append("Unknown type: ").append(type).toString());
    }

    public Class getClass(Schema schema)
    {
        switch (_cls2..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()])
        {
        default:
            throw new AvroRuntimeException((new StringBuilder()).append("Unknown type: ").append(schema).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            String s = schema.getFullName();
            if (s == null)
            {
                return null;
            }
            Class class2 = (Class)classCache.get(s);
            Class class1 = class2;
            if (class2 == null)
            {
                try
                {
                    class1 = classLoader.loadClass(getClassName(schema));
                }
                // Misplaced declaration of an exception variable
                catch (Schema schema)
                {
                    class1 = NO_CLASS;
                }
                classCache.put(s, class1);
            }
            schema = class1;
            if (class1 == NO_CLASS)
            {
                schema = null;
            }
            return schema;

        case 4: // '\004'
            return java/util/List;

        case 5: // '\005'
            return java/util/Map;

        case 6: // '\006'
            schema = schema.getTypes();
            if (schema.size() == 2 && schema.contains(NULL_SCHEMA))
            {
                int i;
                if (((Schema)schema.get(0)).equals(NULL_SCHEMA))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                return getClass((Schema)schema.get(i));
            } else
            {
                return java/lang/Object;
            }

        case 7: // '\007'
            if ("String".equals(schema.getProp("avro.java.string")))
            {
                return java/lang/String;
            } else
            {
                return java/lang/CharSequence;
            }

        case 8: // '\b'
            return java/nio/ByteBuffer;

        case 9: // '\t'
            return Integer.TYPE;

        case 10: // '\n'
            return Long.TYPE;

        case 11: // '\013'
            return Float.TYPE;

        case 12: // '\f'
            return Double.TYPE;

        case 13: // '\r'
            return Boolean.TYPE;

        case 14: // '\016'
            return Void.TYPE;
        }
    }

    protected Schema getEnumSchema(Object obj)
    {
        if (obj instanceof Enum)
        {
            return getSchema(obj.getClass());
        } else
        {
            return super.getEnumSchema(obj);
        }
    }

    public Protocol getProtocol(Class class1)
    {
        Protocol protocol;
        Protocol protocol1;
        try
        {
            protocol1 = (Protocol)(Protocol)class1.getDeclaredField("PROTOCOL").get(null);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Not a Specific protocol: ").append(class1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AvroRuntimeException(class1);
        }
        protocol = protocol1;
        if (!protocol1.getNamespace().equals(class1.getPackage().getName()))
        {
            protocol = Protocol.parse(protocol1.toString().replace(protocol1.getNamespace(), class1.getPackage().getName()));
        }
        return protocol;
    }

    public Schema getSchema(Type type)
    {
        Schema schema1 = (Schema)schemaCache.get(type);
        Schema schema = schema1;
        if (schema1 == null)
        {
            schema = createSchema(type, new LinkedHashMap());
            schemaCache.put(type, schema);
        }
        return schema;
    }

    protected boolean isEnum(Object obj)
    {
        return (obj instanceof Enum) || super.isEnum(obj);
    }

    public Object newRecord(Object obj, Schema schema)
    {
        Class class1 = get().getClass(schema);
        Object obj1;
        if (class1 == null)
        {
            obj1 = super.newRecord(obj, schema);
        } else
        {
            obj1 = obj;
            if (!class1.isInstance(obj))
            {
                return newInstance(class1, schema);
            }
        }
        return obj1;
    }

    static 
    {
        NULL_SCHEMA = Schema.create(com.flurry.org.apache.avro.Schema.Type.NULL);
    }
}
