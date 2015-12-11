// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.AvroRemoteException;
import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Protocol;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericContainer;
import com.flurry.org.apache.avro.generic.GenericFixed;
import com.flurry.org.apache.avro.generic.IndexedRecord;
import com.flurry.org.apache.avro.io.BinaryData;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.specific.FixedSize;
import com.flurry.org.apache.avro.specific.SpecificData;
import com.flurry.org.codehaus.jackson.node.NullNode;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.flurry.org.apache.avro.reflect:
//            Union, Nullable, ReflectDatumReader, Stringable

public class ReflectData extends SpecificData
{
    public static class AllowNull extends ReflectData
    {

        private static final AllowNull INSTANCE = new AllowNull();

        public static AllowNull get()
        {
            return INSTANCE;
        }

        protected Schema createFieldSchema(Field field, Map map)
        {
            return makeNullable(createFieldSchema(field, map));
        }


        public AllowNull()
        {
        }
    }


    private static final Class BYTES_CLASS = (new byte[0]).getClass();
    static final String CLASS_PROP = "java-class";
    static final String ELEMENT_PROP = "java-element-class";
    private static final Map FIELD_CACHE = new ConcurrentHashMap();
    private static final ReflectData INSTANCE = new ReflectData();
    private static final Schema THROWABLE_MESSAGE;
    private final Paranamer paranamer = new CachingParanamer();

    protected ReflectData()
    {
    }

    private static Field findField(Class class1, String s)
    {
        Class class2 = class1;
_L2:
        Field field;
        field = class2.getDeclaredField(s);
        field.setAccessible(true);
        return field;
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        Class class3 = class2.getSuperclass();
        class2 = class3;
        if (class3 == null)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("No field named ").append(s).append(" in: ").append(class1).toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static ReflectData get()
    {
        return INSTANCE;
    }

    private Schema getAnnotatedUnion(Union union, Map map)
    {
        ArrayList arraylist = new ArrayList();
        union = union.value();
        int j = union.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(createSchema(union[i], map));
        }

        return Schema.createUnion(arraylist);
    }

    static Class getClassProp(Schema schema, String s)
    {
        schema = schema.getProp(s);
        if (schema == null)
        {
            return null;
        }
        try
        {
            schema = Class.forName(schema);
        }
        // Misplaced declaration of an exception variable
        catch (Schema schema)
        {
            throw new AvroRuntimeException(schema);
        }
        return schema;
    }

    private static Field getField(Class class1, String s)
    {
        Object obj1 = (Map)FIELD_CACHE.get(class1);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new ConcurrentHashMap();
            FIELD_CACHE.put(class1, obj);
        }
        Field field = (Field)((Map) (obj)).get(s);
        obj1 = field;
        if (field == null)
        {
            obj1 = findField(class1, s);
            ((Map) (obj)).put(s, obj1);
        }
        return ((Field) (obj1));
    }

    private Collection getFields(Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
_L3:
        if (class1.getPackage() == null || !class1.getPackage().getName().startsWith("java.")) goto _L2; else goto _L1
_L1:
        return linkedhashmap.values();
_L2:
        Class class2;
        Field afield[] = class1.getDeclaredFields();
        int j = afield.length;
        for (int i = 0; i < j; i++)
        {
            Field field = afield[i];
            if ((field.getModifiers() & 0x88) == 0 && linkedhashmap.put(field.getName(), field) != null)
            {
                throw new AvroTypeException((new StringBuilder()).append(class1).append(" contains two fields named: ").append(field).toString());
            }
        }

        class2 = class1.getSuperclass();
        class1 = class2;
        if (class2 != null) goto _L3; else goto _L1
    }

    private com.flurry.org.apache.avro.Protocol.Message getMessage(Method method, Protocol protocol, Map map)
    {
        Object obj2 = new ArrayList();
        Object aobj[] = paranamer.lookupParameterNames(method);
        Type atype[] = method.getGenericParameterTypes();
        java.lang.annotation.Annotation aannotation[][] = method.getParameterAnnotations();
        int i = 0;
        do
        {
            if (i >= atype.length)
            {
                break;
            }
            Schema schema1 = getSchema(atype[i], map);
            int k = 0;
            while (k < aannotation[i].length) 
            {
                Schema schema;
                if (aannotation[i][k] instanceof Union)
                {
                    schema = getAnnotatedUnion((Union)aannotation[i][k], map);
                } else
                {
                    schema = schema1;
                    if (aannotation[i][k] instanceof Nullable)
                    {
                        schema = makeNullable(schema1);
                    }
                }
                k++;
                schema1 = schema;
            }
            String s;
            if (aobj.length == atype.length)
            {
                s = aobj[i];
            } else
            {
                s = (new StringBuilder()).append(schema1.getName()).append(i).toString();
            }
            ((List) (obj2)).add(new com.flurry.org.apache.avro.Schema.Field(s, schema1, null, null));
            i++;
        } while (true);
        obj2 = Schema.createRecord(((List) (obj2)));
        Object obj = (Union)method.getAnnotation(com/flurry/org/apache/avro/reflect/Union);
        Object obj1;
        int l;
        if (obj == null)
        {
            obj = getSchema(method.getGenericReturnType(), map);
        } else
        {
            obj = getAnnotatedUnion(((Union) (obj)), map);
        }
        obj1 = obj;
        if (method.isAnnotationPresent(com/flurry/org/apache/avro/reflect/Nullable))
        {
            obj1 = makeNullable(((Schema) (obj)));
        }
        obj = new ArrayList();
        ((List) (obj)).add(Protocol.SYSTEM_ERROR);
        aobj = method.getGenericExceptionTypes();
        l = aobj.length;
        for (int j = 0; j < l; j++)
        {
            Type type = aobj[j];
            if (type != com/flurry/org/apache/avro/AvroRemoteException)
            {
                ((List) (obj)).add(getSchema(type, map));
            }
        }

        map = Schema.createUnion(((List) (obj)));
        return protocol.createMessage(method.getName(), null, ((Schema) (obj2)), ((Schema) (obj1)), map);
    }

    private Schema getSchema(Type type, Map map)
    {
        try
        {
            map = createSchema(type, map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new AvroTypeException((new StringBuilder()).append("Error getting schema for ").append(type).append(": ").append(map.getMessage()).toString(), map);
        }
        return map;
    }

    public static Schema makeNullable(Schema schema)
    {
        return Schema.createUnion(Arrays.asList(new Schema[] {
            Schema.create(com.flurry.org.apache.avro.Schema.Type.NULL), schema
        }));
    }

    private void setElement(Schema schema, Type type)
    {
        if (type instanceof Class)
        {
            if ((Union)(type = (Class)type).getAnnotation(com/flurry/org/apache/avro/reflect/Union) != null)
            {
                schema.addProp("java-element-class", type.getName());
                return;
            }
        }
    }

    protected int compare(Object obj, Object obj1, Schema schema, boolean flag)
    {
        static class _cls1
        {

            static final int $SwitchMap$org$apache$avro$Schema$Type[];

            static 
            {
                $SwitchMap$org$apache$avro$Schema$Type = new int[com.flurry.org.apache.avro.Schema.Type.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BYTES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.INT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 50
    //                   2 36
    //                   3 141;
           goto _L1 _L2 _L1 _L3
_L1:
        int i = super.compare(obj, obj1, schema, flag);
_L5:
        return i;
_L2:
        int l;
        int i1;
        if (!obj.getClass().isArray())
        {
            continue; /* Loop/switch isn't completed */
        }
        schema = schema.getElementType();
        l = Array.getLength(obj);
        i1 = Array.getLength(obj1);
        int j1 = Math.min(l, i1);
        int j = 0;
        do
        {
            if (j >= j1)
            {
                break; /* Loop/switch isn't completed */
            }
            int k = compare(Array.get(obj, j), Array.get(obj1, j), schema, flag);
            i = k;
            if (k != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        if (true) goto _L5; else goto _L4
_L4:
        return l - i1;
_L3:
        if (obj.getClass().isArray())
        {
            obj = (byte[])(byte[])obj;
            obj1 = (byte[])(byte[])obj1;
            return BinaryData.compareBytes(((byte []) (obj)), 0, obj.length, ((byte []) (obj1)), 0, obj1.length);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public DatumReader createDatumReader(Schema schema)
    {
        return new ReflectDatumReader(schema, schema, this);
    }

    protected Schema createFieldSchema(Field field, Map map)
    {
        Schema schema = createSchema(field.getGenericType(), map);
        map = schema;
        if (field.isAnnotationPresent(com/flurry/org/apache/avro/reflect/Nullable))
        {
            map = makeNullable(schema);
        }
        return map;
    }

    protected Schema createSchema(Type type, Map map)
    {
        if (type instanceof GenericArrayType)
        {
            type = ((GenericArrayType)type).getGenericComponentType();
            if (type == Byte.TYPE)
            {
                return Schema.create(com.flurry.org.apache.avro.Schema.Type.BYTES);
            } else
            {
                map = Schema.createArray(createSchema(type, map));
                setElement(map, type);
                return map;
            }
        }
        if (type instanceof ParameterizedType)
        {
            ParameterizedType parameterizedtype = (ParameterizedType)type;
            Object obj = (Class)parameterizedtype.getRawType();
            Type atype[] = parameterizedtype.getActualTypeArguments();
            if (java/util/Map.isAssignableFrom(((Class) (obj))))
            {
                type = atype[0];
                obj = atype[1];
                if (type != java/lang/String)
                {
                    throw new AvroTypeException((new StringBuilder()).append("Map key class not String: ").append(type).toString());
                } else
                {
                    return Schema.createMap(createSchema(((Type) (obj)), map));
                }
            }
            if (java/util/Collection.isAssignableFrom(((Class) (obj))))
            {
                if (atype.length != 1)
                {
                    throw new AvroTypeException("No array type specified.");
                } else
                {
                    type = Schema.createArray(createSchema(atype[0], map));
                    type.addProp("java-class", ((Class) (obj)).getName());
                    return type;
                }
            }
        } else
        {
            if (type == java/lang/Byte || type == Byte.TYPE)
            {
                type = Schema.create(com.flurry.org.apache.avro.Schema.Type.INT);
                type.addProp("java-class", java/lang/Byte.getName());
                return type;
            }
            if (type == java/lang/Short || type == Short.TYPE)
            {
                type = Schema.create(com.flurry.org.apache.avro.Schema.Type.INT);
                type.addProp("java-class", java/lang/Short.getName());
                return type;
            }
            if (type instanceof Class)
            {
                Object obj3 = (Class)type;
                if (((Class) (obj3)).isPrimitive() || java/lang/Number.isAssignableFrom(((Class) (obj3))) || obj3 == java/lang/Void || obj3 == java/lang/Boolean)
                {
                    return super.createSchema(type, map);
                }
                if (((Class) (obj3)).isArray())
                {
                    type = ((Class) (obj3)).getComponentType();
                    if (type == Byte.TYPE)
                    {
                        return Schema.create(com.flurry.org.apache.avro.Schema.Type.BYTES);
                    } else
                    {
                        map = Schema.createArray(createSchema(type, map));
                        setElement(map, type);
                        return map;
                    }
                }
                if (java/lang/CharSequence.isAssignableFrom(((Class) (obj3))))
                {
                    return Schema.create(com.flurry.org.apache.avro.Schema.Type.STRING);
                }
                if (java/nio/ByteBuffer.isAssignableFrom(((Class) (obj3))))
                {
                    return Schema.create(com.flurry.org.apache.avro.Schema.Type.BYTES);
                }
                if (java/util/Collection.isAssignableFrom(((Class) (obj3))))
                {
                    throw new AvroRuntimeException("Can't find element type of Collection");
                }
                String s1 = ((Class) (obj3)).getName();
                Schema schema = (Schema)map.get(s1);
                Object obj1 = schema;
                if (schema == null)
                {
                    String s = ((Class) (obj3)).getSimpleName();
                    Union union;
                    if (((Class) (obj3)).getPackage() == null)
                    {
                        obj1 = "";
                    } else
                    {
                        obj1 = ((Class) (obj3)).getPackage().getName();
                    }
                    if (((Class) (obj3)).getEnclosingClass() != null)
                    {
                        obj1 = (new StringBuilder()).append(((Class) (obj3)).getEnclosingClass().getName()).append("$").toString();
                    }
                    union = (Union)((Class) (obj3)).getAnnotation(com/flurry/org/apache/avro/reflect/Union);
                    if (union != null)
                    {
                        return getAnnotatedUnion(union, map);
                    }
                    if (((Class) (obj3)).isAnnotationPresent(com/flurry/org/apache/avro/reflect/Stringable))
                    {
                        type = Schema.create(com.flurry.org.apache.avro.Schema.Type.STRING);
                        type.addProp("java-class", ((Class) (obj3)).getName());
                        return type;
                    }
                    if (((Class) (obj3)).isEnum())
                    {
                        type = new ArrayList();
                        obj3 = (Enum[])(Enum[])((Class) (obj3)).getEnumConstants();
                        for (int i = 0; i < obj3.length; i++)
                        {
                            type.add(obj3[i].name());
                        }

                        type = Schema.createEnum(s, null, ((String) (obj1)), type);
                    } else
                    if (com/flurry/org/apache/avro/generic/GenericFixed.isAssignableFrom(((Class) (obj3))))
                    {
                        type = Schema.createFixed(s, null, ((String) (obj1)), ((FixedSize)((Class) (obj3)).getAnnotation(com/flurry/org/apache/avro/specific/FixedSize)).value());
                    } else
                    {
                        if (com/flurry/org/apache/avro/generic/IndexedRecord.isAssignableFrom(((Class) (obj3))))
                        {
                            return super.createSchema(type, map);
                        }
                        ArrayList arraylist = new ArrayList();
                        boolean flag = java/lang/Throwable.isAssignableFrom(((Class) (obj3)));
                        obj1 = Schema.createRecord(s, null, ((String) (obj1)), flag);
                        map.put(((Class) (obj3)).getName(), obj1);
                        obj3 = getFields(((Class) (obj3))).iterator();
                        do
                        {
                            if (!((Iterator) (obj3)).hasNext())
                            {
                                break;
                            }
                            Field field = (Field)((Iterator) (obj3)).next();
                            if ((field.getModifiers() & 0x88) == 0)
                            {
                                Schema schema1 = createFieldSchema(field, map);
                                Object obj2 = null;
                                type = obj2;
                                if (schema1.getType() == com.flurry.org.apache.avro.Schema.Type.UNION)
                                {
                                    type = obj2;
                                    if (((Schema)schema1.getTypes().get(0)).getType() == com.flurry.org.apache.avro.Schema.Type.NULL)
                                    {
                                        type = NullNode.getInstance();
                                    }
                                }
                                arraylist.add(new com.flurry.org.apache.avro.Schema.Field(field.getName(), schema1, null, type));
                            }
                        } while (true);
                        if (flag)
                        {
                            arraylist.add(new com.flurry.org.apache.avro.Schema.Field("detailMessage", THROWABLE_MESSAGE, null, null));
                        }
                        ((Schema) (obj1)).setFields(arraylist);
                        type = ((Type) (obj1));
                    }
                    map.put(s1, type);
                    obj1 = type;
                }
                return ((Schema) (obj1));
            }
        }
        return super.createSchema(type, map);
    }

    public Class getClass(Schema schema)
    {
        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 48
    //                   2 77
    //                   3 80
    //                   4 84;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        Class class1 = super.getClass(schema);
_L7:
        return class1;
_L2:
        Class class2;
        class2 = getClassProp(schema, "java-class");
        class1 = class2;
        if (class2 != null) goto _L7; else goto _L6
_L6:
        return Array.newInstance(getClass(schema.getElementType()), 0).getClass();
_L3:
        return java/lang/String;
_L4:
        return BYTES_CLASS;
_L5:
        String s = schema.getProp("java-class");
        if (java/lang/Byte.getName().equals(s))
        {
            return Byte.TYPE;
        }
        if (java/lang/Short.getName().equals(s))
        {
            return Short.TYPE;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public Object getField(Object obj, String s, int i)
    {
        if (obj instanceof IndexedRecord)
        {
            return super.getField(obj, s, i);
        }
        try
        {
            obj = getField(obj.getClass(), s).get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AvroRuntimeException(((Throwable) (obj)));
        }
        return obj;
    }

    public Protocol getProtocol(Class class1)
    {
        Object obj1 = class1.getSimpleName();
        Object obj;
        Map map;
        int j;
        if (class1.getPackage() == null)
        {
            obj = "";
        } else
        {
            obj = class1.getPackage().getName();
        }
        obj = new Protocol(((String) (obj1)), ((String) (obj)));
        obj1 = new LinkedHashMap();
        map = ((Protocol) (obj)).getMessages();
        class1 = class1.getMethods();
        j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Method method = class1[i];
            if ((method.getModifiers() & 8) != 0)
            {
                continue;
            }
            String s = method.getName();
            if (map.containsKey(s))
            {
                throw new AvroTypeException((new StringBuilder()).append("Two methods with same name: ").append(s).toString());
            }
            map.put(s, getMessage(method, ((Protocol) (obj)), ((Map) (obj1))));
        }

        class1 = new ArrayList();
        class1.addAll(((Map) (obj1)).values());
        Collections.reverse(class1);
        ((Protocol) (obj)).setTypes(class1);
        return ((Protocol) (obj));
    }

    protected Schema getRecordSchema(Object obj)
    {
        if (obj instanceof GenericContainer)
        {
            return super.getRecordSchema(obj);
        } else
        {
            return getSchema(obj.getClass());
        }
    }

    protected boolean isArray(Object obj)
    {
        while (obj == null || !(obj instanceof Collection) && !obj.getClass().isArray()) 
        {
            return false;
        }
        return true;
    }

    protected boolean isBytes(Object obj)
    {
        boolean flag1 = true;
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (super.isBytes(obj)) goto _L4; else goto _L3
_L3:
        obj = obj.getClass();
        if (!((Class) (obj)).isArray())
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((Class) (obj)).getComponentType() == Byte.TYPE) goto _L4; else goto _L5
_L5:
        return false;
    }

    protected boolean isRecord(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (super.isRecord(obj))
            {
                return true;
            }
            if (!(obj instanceof Collection))
            {
                if (getSchema(obj.getClass()).getType() != com.flurry.org.apache.avro.Schema.Type.RECORD)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public void setField(Object obj, String s, int i, Object obj1)
    {
        if (obj instanceof IndexedRecord)
        {
            super.setField(obj, s, i, obj1);
            return;
        }
        try
        {
            getField(obj.getClass(), s).set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AvroRuntimeException(((Throwable) (obj)));
        }
    }

    public boolean validate(Schema schema, Object obj)
    {
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()])
        {
        default:
            return super.validate(schema, obj);

        case 1: // '\001'
            break;
        }
        if (!obj.getClass().isArray())
        {
            return super.validate(schema, obj);
        }
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            if (!validate(schema.getElementType(), Array.get(obj, i)))
            {
                return false;
            }
        }

        return true;
    }

    static 
    {
        THROWABLE_MESSAGE = makeNullable(Schema.create(com.flurry.org.apache.avro.Schema.Type.STRING));
    }
}
