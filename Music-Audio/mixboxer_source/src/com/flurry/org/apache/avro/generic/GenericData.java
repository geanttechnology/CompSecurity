// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.UnresolvedUnionException;
import com.flurry.org.apache.avro.io.BinaryData;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.util.Utf8;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericDatumReader, GenericFixed, IndexedRecord, GenericContainer, 
//            GenericEnumSymbol, GenericArray, GenericRecord

public class GenericData
{
    public static class Array extends AbstractList
        implements GenericArray, Comparable
    {

        private static final Object EMPTY[] = new Object[0];
        private Object elements[];
        private final Schema schema;
        private int size;

        public void add(int i, Object obj)
        {
            if (i > size || i < 0)
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
            }
            if (size == elements.length)
            {
                Object aobj[] = new Object[(size * 3) / 2 + 1];
                System.arraycopy(((Object) (elements)), 0, ((Object) (aobj)), 0, size);
                elements = aobj;
            }
            System.arraycopy(((Object) (elements)), i, ((Object) (elements)), i + 1, size - i);
            elements[i] = obj;
            size = size + 1;
        }

        public boolean add(Object obj)
        {
            if (size == elements.length)
            {
                Object aobj[] = new Object[(size * 3) / 2 + 1];
                System.arraycopy(((Object) (elements)), 0, ((Object) (aobj)), 0, size);
                elements = aobj;
            }
            Object aobj1[] = elements;
            int i = size;
            size = i + 1;
            aobj1[i] = obj;
            return true;
        }

        public void clear()
        {
            size = 0;
        }

        public int compareTo(GenericArray genericarray)
        {
            return GenericData.get().compare(this, genericarray, getSchema());
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((GenericArray)obj);
        }

        public Object get(int i)
        {
            if (i >= size)
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
            } else
            {
                return elements[i];
            }
        }

        public Schema getSchema()
        {
            return schema;
        }

        public Iterator iterator()
        {
            return new Iterator() {

                private int position;
                final Array this$0;

                public boolean hasNext()
                {
                    return position < size;
                }

                public Object next()
                {
                    Object aobj[] = elements;
                    int i = position;
                    position = i + 1;
                    return aobj[i];
                }

                public void remove()
                {
                    throw new UnsupportedOperationException();
                }

            
            {
                this$0 = Array.this;
                super();
                position = 0;
            }
            };
        }

        public Object peek()
        {
            if (size < elements.length)
            {
                return elements[size];
            } else
            {
                return null;
            }
        }

        public Object remove(int i)
        {
            if (i >= size)
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
            } else
            {
                Object obj = elements[i];
                size = size - 1;
                System.arraycopy(((Object) (elements)), i + 1, ((Object) (elements)), i, size - i);
                elements[size] = null;
                return obj;
            }
        }

        public void reverse()
        {
            int j = 0;
            for (int i = elements.length - 1; j < i; i--)
            {
                Object obj = elements[j];
                elements[j] = elements[i];
                elements[i] = obj;
                j++;
            }

        }

        public Object set(int i, Object obj)
        {
            if (i >= size)
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
            } else
            {
                Object obj1 = elements[i];
                elements[i] = obj;
                return obj1;
            }
        }

        public int size()
        {
            return size;
        }

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append("[");
            int i = 0;
            Iterator iterator1 = iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                Object obj = iterator1.next();
                int j;
                if (obj == null)
                {
                    obj = "null";
                } else
                {
                    obj = obj.toString();
                }
                stringbuffer.append(((String) (obj)));
                j = i + 1;
                i = j;
                if (j < size())
                {
                    stringbuffer.append(", ");
                    i = j;
                }
            } while (true);
            stringbuffer.append("]");
            return stringbuffer.toString();
        }




        public Array(int i, Schema schema1)
        {
            elements = EMPTY;
            if (schema1 == null || !com.flurry.org.apache.avro.Schema.Type.ARRAY.equals(schema1.getType()))
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Not an array schema: ").append(schema1).toString());
            }
            schema = schema1;
            if (i != 0)
            {
                elements = new Object[i];
            }
        }

        public Array(Schema schema1, Collection collection)
        {
            elements = EMPTY;
            if (schema1 == null || !com.flurry.org.apache.avro.Schema.Type.ARRAY.equals(schema1.getType()))
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Not an array schema: ").append(schema1).toString());
            }
            schema = schema1;
            if (collection != null)
            {
                elements = new Object[collection.size()];
                addAll(collection);
            }
        }
    }

    public static class EnumSymbol
        implements GenericEnumSymbol
    {

        private Schema schema;
        private String symbol;

        public boolean equals(Object obj)
        {
            while (obj == this || (obj instanceof GenericEnumSymbol) && symbol.equals(obj.toString())) 
            {
                return true;
            }
            return false;
        }

        public Schema getSchema()
        {
            return schema;
        }

        public int hashCode()
        {
            return symbol.hashCode();
        }

        public String toString()
        {
            return symbol;
        }

        public EnumSymbol(Schema schema1, String s)
        {
            schema = schema1;
            symbol = s;
        }
    }

    public static class Fixed
        implements GenericFixed, Comparable
    {

        private byte bytes[];
        private Schema schema;

        public void bytes(byte abyte0[])
        {
            bytes = abyte0;
        }

        public byte[] bytes()
        {
            return bytes;
        }

        public int compareTo(Fixed fixed)
        {
            return BinaryData.compareBytes(bytes, 0, bytes.length, fixed.bytes, 0, fixed.bytes.length);
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Fixed)obj);
        }

        public boolean equals(Object obj)
        {
            while (obj == this || (obj instanceof GenericFixed) && Arrays.equals(bytes, ((GenericFixed)obj).bytes())) 
            {
                return true;
            }
            return false;
        }

        public Schema getSchema()
        {
            return schema;
        }

        public int hashCode()
        {
            return Arrays.hashCode(bytes);
        }

        protected void setSchema(Schema schema1)
        {
            schema = schema1;
            bytes = new byte[schema1.getFixedSize()];
        }

        public String toString()
        {
            return Arrays.toString(bytes);
        }

        protected Fixed()
        {
        }

        public Fixed(Schema schema1)
        {
            setSchema(schema1);
        }

        public Fixed(Schema schema1, byte abyte0[])
        {
            schema = schema1;
            bytes = abyte0;
        }
    }

    public static class Record
        implements GenericRecord, Comparable
    {

        private final Schema schema;
        private final Object values[];

        public int compareTo(Record record)
        {
            return GenericData.get().compare(this, record, schema);
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Record)obj);
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof Record))
                {
                    return false;
                }
                obj = (Record)obj;
                if (!schema.getFullName().equals(((Record) (obj)).schema.getFullName()))
                {
                    return false;
                }
                if (GenericData.get().compare(this, obj, schema, true) != 0)
                {
                    return false;
                }
            }
            return true;
        }

        public Object get(int i)
        {
            return values[i];
        }

        public Object get(String s)
        {
            s = schema.getField(s);
            if (s == null)
            {
                return null;
            } else
            {
                return values[s.pos()];
            }
        }

        public Schema getSchema()
        {
            return schema;
        }

        public int hashCode()
        {
            return GenericData.get().hashCode(this, schema);
        }

        public void put(int i, Object obj)
        {
            values[i] = obj;
        }

        public void put(String s, Object obj)
        {
            com.flurry.org.apache.avro.Schema.Field field = schema.getField(s);
            if (field == null)
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Not a valid schema field: ").append(s).toString());
            } else
            {
                values[field.pos()] = obj;
                return;
            }
        }

        public String toString()
        {
            return GenericData.get().toString(this);
        }

        public Record(Schema schema1)
        {
            if (schema1 == null || !com.flurry.org.apache.avro.Schema.Type.RECORD.equals(schema1.getType()))
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Not a record schema: ").append(schema1).toString());
            } else
            {
                schema = schema1;
                values = new Object[schema1.getFields().size()];
                return;
            }
        }

        public Record(Record record, boolean flag)
        {
            schema = record.schema;
            values = new Object[schema.getFields().size()];
            if (flag)
            {
                for (int i = 0; i < values.length; i++)
                {
                    values[i] = GenericData.INSTANCE.deepCopy(((com.flurry.org.apache.avro.Schema.Field)schema.getFields().get(i)).schema(), record.values[i]);
                }

            } else
            {
                System.arraycopy(((Object) (record.values)), 0, ((Object) (values)), 0, record.values.length);
            }
        }
    }

    public static final class StringType extends Enum
    {

        private static final StringType $VALUES[];
        public static final StringType CharSequence;
        public static final StringType String;
        public static final StringType Utf8;

        public static StringType valueOf(String s)
        {
            return (StringType)Enum.valueOf(com/flurry/org/apache/avro/generic/GenericData$StringType, s);
        }

        public static StringType[] values()
        {
            return (StringType[])$VALUES.clone();
        }

        static 
        {
            CharSequence = new StringType("CharSequence", 0);
            String = new StringType("String", 1);
            Utf8 = new StringType("Utf8", 2);
            $VALUES = (new StringType[] {
                CharSequence, String, Utf8
            });
        }

        private StringType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final GenericData INSTANCE = new GenericData();
    private static final Schema STRINGS;
    protected static final String STRING_PROP = "avro.java.string";
    protected static final String STRING_TYPE_STRING = "String";

    protected GenericData()
    {
    }

    public static GenericData get()
    {
        return INSTANCE;
    }

    public static void setStringType(Schema schema, StringType stringtype)
    {
        if (stringtype == StringType.String)
        {
            schema.addProp("avro.java.string", "String");
        }
    }

    private void writeEscapedString(String s, StringBuilder stringbuilder)
    {
        int i = 0;
_L11:
        char c;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_282;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 8: default 96
    //                   8: 201
    //                   9: 241
    //                   10: 221
    //                   12: 211
    //                   13: 231
    //                   34: 175
    //                   47: 251
    //                   92: 191;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        stringbuilder.append("\\\"");
_L12:
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        stringbuilder.append("\\\\");
          goto _L12
_L2:
        stringbuilder.append("\\b");
          goto _L12
_L5:
        stringbuilder.append("\\f");
          goto _L12
_L4:
        stringbuilder.append("\\n");
          goto _L12
_L6:
        stringbuilder.append("\\r");
          goto _L12
_L3:
        stringbuilder.append("\\t");
          goto _L12
_L8:
        stringbuilder.append("\\/");
          goto _L12
_L1:
        if ((c < 0 || c > '\037') && (c < '\177' || c > '\237') && (c < '\u2000' || c > '\u20FF'))
        {
            break MISSING_BLOCK_LABEL_273;
        }
        Integer.toHexString(c);
        stringbuilder.append("\\u");
        for (int j = 0; j < 4 - stringbuilder.length(); j++)
        {
            stringbuilder.append('0');
        }

        stringbuilder.append(s.toUpperCase());
        break; /* Loop/switch isn't completed */
        stringbuilder.append(c);
          goto _L12
    }

    public int compare(Object obj, Object obj1, Schema schema)
    {
        return compare(obj, obj1, schema, false);
    }

    protected int compare(Object obj, Object obj1, Schema schema, boolean flag)
    {
        if (obj == obj1)
        {
            return 0;
        }
        static class _cls1
        {

            static final int $SwitchMap$org$apache$avro$Schema$Type[];

            static 
            {
                $SwitchMap$org$apache$avro$Schema$Type = new int[com.flurry.org.apache.avro.Schema.Type.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.RECORD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ENUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ARRAY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.MAP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.UNION.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FIXED.ordinal()] = 6;
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

        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()])
        {
        case 6: // '\006'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        default:
            return ((Comparable)obj).compareTo(obj1);

        case 1: // '\001'
            for (schema = schema.getFields().iterator(); schema.hasNext();)
            {
                com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
                if (field.order() != com.flurry.org.apache.avro.Schema.Field.Order.IGNORE)
                {
                    int i = field.pos();
                    String s = field.name();
                    int i1 = compare(getField(obj, s, i), getField(obj1, s, i), field.schema(), flag);
                    if (i1 != 0)
                    {
                        int j = i1;
                        if (field.order() == com.flurry.org.apache.avro.Schema.Field.Order.DESCENDING)
                        {
                            j = -i1;
                        }
                        return j;
                    }
                }
            }

            return 0;

        case 2: // '\002'
            return schema.getEnumOrdinal(obj.toString()) - schema.getEnumOrdinal(obj1.toString());

        case 3: // '\003'
            obj = (Collection)obj;
            obj1 = (Collection)obj1;
            obj = ((Collection) (obj)).iterator();
            obj1 = ((Collection) (obj1)).iterator();
            schema = schema.getElementType();
            while (((Iterator) (obj)).hasNext() && ((Iterator) (obj1)).hasNext()) 
            {
                int k = compare(((Iterator) (obj)).next(), ((Iterator) (obj1)).next(), schema, flag);
                if (k != 0)
                {
                    return k;
                }
            }
            if (((Iterator) (obj)).hasNext())
            {
                return 1;
            }
            return !((Iterator) (obj1)).hasNext() ? 0 : -1;

        case 4: // '\004'
            if (flag)
            {
                return !((Map)obj).equals(obj1) ? 1 : 0;
            } else
            {
                throw new AvroRuntimeException("Can't compare maps!");
            }

        case 5: // '\005'
            int l = resolveUnion(schema, obj);
            int j1 = resolveUnion(schema, obj1);
            if (l == j1)
            {
                return compare(obj, obj1, (Schema)schema.getTypes().get(l), flag);
            } else
            {
                return l - j1;
            }

        case 14: // '\016'
            return 0;

        case 7: // '\007'
            if (obj instanceof Utf8)
            {
                obj = (Utf8)obj;
            } else
            {
                obj = new Utf8(obj.toString());
            }
            if (obj1 instanceof Utf8)
            {
                obj1 = (Utf8)obj1;
            } else
            {
                obj1 = new Utf8(obj1.toString());
            }
            return ((Utf8) (obj)).compareTo(((Utf8) (obj1)));
        }
    }

    public DatumReader createDatumReader(Schema schema)
    {
        return new GenericDatumReader(schema, schema, this);
    }

    public Object createFixed(Object obj, Schema schema)
    {
        if ((obj instanceof GenericFixed) && ((GenericFixed)obj).bytes().length == schema.getFixedSize())
        {
            return obj;
        } else
        {
            return new Fixed(schema);
        }
    }

    public Object createFixed(Object obj, byte abyte0[], Schema schema)
    {
        obj = (GenericFixed)createFixed(obj, schema);
        System.arraycopy(abyte0, 0, ((GenericFixed) (obj)).bytes(), 0, schema.getFixedSize());
        return obj;
    }

    public Object deepCopy(Schema schema, Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return obj1;
_L2:
        obj1 = obj;
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()])
        {
        default:
            throw new AvroRuntimeException((new StringBuilder()).append("Deep copy failed for schema \"").append(schema).append("\" and value \"").append(obj).append("\"").toString());

        case 3: // '\003'
            obj1 = (List)obj;
            obj = new Array(((List) (obj1)).size(), schema);
            Object obj2;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(deepCopy(schema.getElementType(), obj2)))
            {
                obj2 = ((Iterator) (obj1)).next();
            }

            return obj;

        case 13: // '\r'
            return new Boolean(((Boolean)obj).booleanValue());

        case 8: // '\b'
            schema = (ByteBuffer)obj;
            obj = new byte[schema.capacity()];
            schema.rewind();
            schema.get(((byte []) (obj)));
            schema.rewind();
            return ByteBuffer.wrap(((byte []) (obj)));

        case 12: // '\f'
            return new Double(((Double)obj).doubleValue());

        case 6: // '\006'
            return createFixed(null, ((GenericFixed)obj).bytes(), schema);

        case 11: // '\013'
            return new Float(((Float)obj).floatValue());

        case 9: // '\t'
            return new Integer(((Integer)obj).intValue());

        case 10: // '\n'
            return new Long(((Long)obj).longValue());

        case 4: // '\004'
            obj1 = (Map)obj;
            obj = new HashMap(((Map) (obj1)).size());
            java.util.Map.Entry entry;
            for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((Map) (obj)).put((CharSequence)(CharSequence)deepCopy(STRINGS, entry.getKey()), deepCopy(schema.getValueType(), entry.getValue())))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            }

            return obj;

        case 14: // '\016'
            return null;

        case 1: // '\001'
            obj = (IndexedRecord)obj;
            obj1 = (IndexedRecord)newRecord(null, schema);
            com.flurry.org.apache.avro.Schema.Field field;
            for (schema = schema.getFields().iterator(); schema.hasNext(); ((IndexedRecord) (obj1)).put(field.pos(), deepCopy(field.schema(), ((IndexedRecord) (obj)).get(field.pos()))))
            {
                field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
            }

            return obj1;

        case 7: // '\007'
            obj1 = obj;
            if (!(obj instanceof String))
            {
                if (obj instanceof Utf8)
                {
                    return new Utf8((Utf8)obj);
                } else
                {
                    return new Utf8(obj.toString());
                }
            }
            break;

        case 5: // '\005'
            return deepCopy((Schema)schema.getTypes().get(resolveUnion(schema, obj)), obj);

        case 2: // '\002'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Schema getEnumSchema(Object obj)
    {
        return ((GenericContainer)obj).getSchema();
    }

    public Object getField(Object obj, String s, int i)
    {
        return ((IndexedRecord)obj).get(i);
    }

    protected Object getField(Object obj, String s, int i, Object obj1)
    {
        return getField(obj, s, i);
    }

    protected Schema getFixedSchema(Object obj)
    {
        return ((GenericContainer)obj).getSchema();
    }

    protected Schema getRecordSchema(Object obj)
    {
        return ((GenericContainer)obj).getSchema();
    }

    protected Object getRecordState(Object obj, Schema schema)
    {
        return null;
    }

    protected String getSchemaName(Object obj)
    {
        if (obj == null)
        {
            return com.flurry.org.apache.avro.Schema.Type.NULL.getName();
        }
        if (isRecord(obj))
        {
            return getRecordSchema(obj).getFullName();
        }
        if (isEnum(obj))
        {
            return getEnumSchema(obj).getFullName();
        }
        if (isArray(obj))
        {
            return com.flurry.org.apache.avro.Schema.Type.ARRAY.getName();
        }
        if (isMap(obj))
        {
            return com.flurry.org.apache.avro.Schema.Type.MAP.getName();
        }
        if (isFixed(obj))
        {
            return getFixedSchema(obj).getFullName();
        }
        if (isString(obj))
        {
            return com.flurry.org.apache.avro.Schema.Type.STRING.getName();
        }
        if (isBytes(obj))
        {
            return com.flurry.org.apache.avro.Schema.Type.BYTES.getName();
        }
        if (obj instanceof Integer)
        {
            return com.flurry.org.apache.avro.Schema.Type.INT.getName();
        }
        if (obj instanceof Long)
        {
            return com.flurry.org.apache.avro.Schema.Type.LONG.getName();
        }
        if (obj instanceof Float)
        {
            return com.flurry.org.apache.avro.Schema.Type.FLOAT.getName();
        }
        if (obj instanceof Double)
        {
            return com.flurry.org.apache.avro.Schema.Type.DOUBLE.getName();
        }
        if (obj instanceof Boolean)
        {
            return com.flurry.org.apache.avro.Schema.Type.BOOLEAN.getName();
        } else
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Unknown datum type: ").append(obj).toString());
        }
    }

    public int hashCode(Object obj, Schema schema)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L11:
        return i;
_L2:
        int j;
        i = 1;
        j = 1;
        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 96
    //                   1 101
    //                   2 248
    //                   3 172
    //                   4 96
    //                   5 224
    //                   6 96
    //                   7 259
    //                   8 96
    //                   9 96
    //                   10 96
    //                   11 96
    //                   12 96
    //                   13 96
    //                   14 257;
           goto _L3 _L4 _L5 _L6 _L3 _L7 _L3 _L8 _L3 _L3 _L3 _L3 _L3 _L3 _L9
_L3:
        return obj.hashCode();
_L4:
        schema = schema.getFields().iterator();
_L12:
        i = j;
        if (!schema.hasNext()) goto _L11; else goto _L10
_L10:
        com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
        if (field.order() != com.flurry.org.apache.avro.Schema.Field.Order.IGNORE)
        {
            j = hashCodeAdd(j, getField(obj, field.name(), field.pos()), field.schema());
        }
          goto _L12
_L6:
        obj = (Collection)obj;
        schema = schema.getElementType();
        obj = ((Collection) (obj)).iterator();
        j = i;
_L14:
        i = j;
        if (!((Iterator) (obj)).hasNext()) goto _L11; else goto _L13
_L13:
        j = hashCodeAdd(j, ((Iterator) (obj)).next(), schema);
          goto _L14
          goto _L11
_L7:
        return hashCode(obj, (Schema)schema.getTypes().get(resolveUnion(schema, obj)));
_L5:
        return schema.getEnumOrdinal(obj.toString());
_L9:
        return 0;
_L8:
        if (!(obj instanceof Utf8))
        {
            obj = new Utf8(obj.toString());
        }
        return obj.hashCode();
    }

    protected int hashCodeAdd(int i, Object obj, Schema schema)
    {
        return i * 31 + hashCode(obj, schema);
    }

    public Schema induce(Object obj)
    {
label0:
        {
            Schema schema;
label1:
            {
                if (isRecord(obj))
                {
                    return getRecordSchema(obj);
                }
                if (!(obj instanceof Collection))
                {
                    break label0;
                }
                schema = null;
                Object obj2;
label2:
                do
                {
                    for (Iterator iterator = ((Collection)obj).iterator(); iterator.hasNext();)
                    {
                        obj2 = iterator.next();
                        if (schema != null)
                        {
                            continue label2;
                        }
                        schema = induce(obj2);
                    }

                    break label1;
                } while (schema.equals(induce(obj2)));
                throw new AvroTypeException("No mixed type arrays.");
            }
            if (schema == null)
            {
                throw new AvroTypeException((new StringBuilder()).append("Empty array: ").append(obj).toString());
            } else
            {
                return Schema.createArray(schema);
            }
        }
label3:
        {
            Schema schema1;
label4:
            {
                if (!(obj instanceof Map))
                {
                    break label3;
                }
                Object obj1 = (Map)obj;
                schema1 = null;
                java.util.Map.Entry entry;
label5:
                do
                {
                    for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext();)
                    {
                        entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                        if (schema1 != null)
                        {
                            continue label5;
                        }
                        schema1 = induce(entry.getValue());
                    }

                    break label4;
                } while (schema1.equals(induce(entry.getValue())));
                throw new AvroTypeException("No mixed type map values.");
            }
            if (schema1 == null)
            {
                throw new AvroTypeException((new StringBuilder()).append("Empty map: ").append(obj).toString());
            } else
            {
                return Schema.createMap(schema1);
            }
        }
        if (obj instanceof GenericFixed)
        {
            return Schema.createFixed(null, null, null, ((GenericFixed)obj).bytes().length);
        }
        if (obj instanceof CharSequence)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.STRING);
        }
        if (obj instanceof ByteBuffer)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.BYTES);
        }
        if (obj instanceof Integer)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.INT);
        }
        if (obj instanceof Long)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.LONG);
        }
        if (obj instanceof Float)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.FLOAT);
        }
        if (obj instanceof Double)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.DOUBLE);
        }
        if (obj instanceof Boolean)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.BOOLEAN);
        }
        if (obj == null)
        {
            return Schema.create(com.flurry.org.apache.avro.Schema.Type.NULL);
        } else
        {
            throw new AvroTypeException((new StringBuilder()).append("Can't create schema for: ").append(obj).toString());
        }
    }

    protected boolean instanceOf(Schema schema, Object obj)
    {
        boolean flag;
        boolean flag2;
        flag2 = true;
        flag = true;
        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 88
    //                   1 116
    //                   2 170
    //                   3 194
    //                   4 200
    //                   5 88
    //                   6 206
    //                   7 230
    //                   8 236
    //                   9 242
    //                   10 247
    //                   11 252
    //                   12 257
    //                   13 262
    //                   14 267;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        throw new AvroRuntimeException((new StringBuilder()).append("Unexpected type: ").append(schema).toString());
_L2:
        if (isRecord(obj)) goto _L16; else goto _L15
_L15:
        return false;
_L16:
        if (schema.getFullName() == null)
        {
            if (getRecordSchema(obj).getFullName() != null)
            {
                flag = false;
            }
        } else
        {
            flag = schema.getFullName().equals(getRecordSchema(obj).getFullName());
        }
        return flag;
_L3:
        if (!isEnum(obj)) goto _L15; else goto _L17
_L17:
        return schema.getFullName().equals(getEnumSchema(obj).getFullName());
_L4:
        return isArray(obj);
_L5:
        return isMap(obj);
_L6:
        if (!isFixed(obj)) goto _L15; else goto _L18
_L18:
        return schema.getFullName().equals(getFixedSchema(obj).getFullName());
_L7:
        return isString(obj);
_L8:
        return isBytes(obj);
_L9:
        return obj instanceof Integer;
_L10:
        return obj instanceof Long;
_L11:
        return obj instanceof Float;
_L12:
        return obj instanceof Double;
_L13:
        return obj instanceof Boolean;
_L14:
        boolean flag1;
        if (obj == null)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    protected boolean isArray(Object obj)
    {
        return obj instanceof Collection;
    }

    protected boolean isBytes(Object obj)
    {
        return obj instanceof ByteBuffer;
    }

    protected boolean isEnum(Object obj)
    {
        return obj instanceof GenericEnumSymbol;
    }

    protected boolean isFixed(Object obj)
    {
        return obj instanceof GenericFixed;
    }

    protected boolean isMap(Object obj)
    {
        return obj instanceof Map;
    }

    protected boolean isRecord(Object obj)
    {
        return obj instanceof IndexedRecord;
    }

    protected boolean isString(Object obj)
    {
        return obj instanceof CharSequence;
    }

    public Object newRecord(Object obj, Schema schema)
    {
        if (obj instanceof IndexedRecord)
        {
            obj = (IndexedRecord)obj;
            if (((IndexedRecord) (obj)).getSchema() == schema)
            {
                return obj;
            }
        }
        return new Record(schema);
    }

    public int resolveUnion(Schema schema, Object obj)
    {
        Integer integer = schema.getIndexNamed(getSchemaName(obj));
        if (integer != null)
        {
            return integer.intValue();
        } else
        {
            throw new UnresolvedUnionException(schema, obj);
        }
    }

    public void setField(Object obj, String s, int i, Object obj1)
    {
        ((IndexedRecord)obj).put(i, obj1);
    }

    protected void setField(Object obj, String s, int i, Object obj1, Object obj2)
    {
        setField(obj, s, i, obj1);
    }

    public String toString(Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder();
        toString(obj, stringbuilder);
        return stringbuilder.toString();
    }

    protected void toString(Object obj, StringBuilder stringbuilder)
    {
        if (isRecord(obj))
        {
            stringbuilder.append("{");
            int i = 0;
            Schema schema = getRecordSchema(obj);
            Iterator iterator1 = schema.getFields().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)iterator1.next();
                toString(field.name(), stringbuilder);
                stringbuilder.append(": ");
                toString(getField(obj, field.name(), field.pos()), stringbuilder);
                int i1 = i + 1;
                i = i1;
                if (i1 < schema.getFields().size())
                {
                    stringbuilder.append(", ");
                    i = i1;
                }
            } while (true);
            stringbuilder.append("}");
            return;
        }
        if (obj instanceof Collection)
        {
            obj = (Collection)obj;
            stringbuilder.append("[");
            long l1 = ((Collection) (obj)).size() - 1;
            int j = 0;
            for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                toString(((Iterator) (obj)).next(), stringbuilder);
                if ((long)j < l1)
                {
                    stringbuilder.append(", ");
                }
                j++;
            }

            stringbuilder.append("]");
            return;
        }
        if (obj instanceof Map)
        {
            stringbuilder.append("{");
            int k = 0;
            obj = (Map)obj;
            Iterator iterator = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                toString(entry.getKey(), stringbuilder);
                stringbuilder.append(": ");
                toString(entry.getValue(), stringbuilder);
                int j1 = k + 1;
                k = j1;
                if (j1 < ((Map) (obj)).size())
                {
                    stringbuilder.append(", ");
                    k = j1;
                }
            } while (true);
            stringbuilder.append("}");
            return;
        }
        if ((obj instanceof CharSequence) || (obj instanceof GenericEnumSymbol))
        {
            stringbuilder.append("\"");
            writeEscapedString(obj.toString(), stringbuilder);
            stringbuilder.append("\"");
            return;
        }
        if (obj instanceof ByteBuffer)
        {
            stringbuilder.append("{\"bytes\": \"");
            obj = (ByteBuffer)obj;
            for (int l = ((ByteBuffer) (obj)).position(); l < ((ByteBuffer) (obj)).limit(); l++)
            {
                stringbuilder.append((char)((ByteBuffer) (obj)).get(l));
            }

            stringbuilder.append("\"}");
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    public boolean validate(Schema schema, Object obj)
    {
        boolean flag;
        boolean flag2;
        flag2 = true;
        flag = true;
        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 88
    //                   1 90
    //                   2 155
    //                   3 169
    //                   4 218
    //                   5 280
    //                   6 318
    //                   7 351
    //                   8 357
    //                   9 363
    //                   10 368
    //                   11 373
    //                   12 378
    //                   13 383
    //                   14 388;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L7:
        break MISSING_BLOCK_LABEL_318;
_L8:
        break MISSING_BLOCK_LABEL_351;
_L9:
        break MISSING_BLOCK_LABEL_357;
_L10:
        break MISSING_BLOCK_LABEL_363;
_L11:
        break MISSING_BLOCK_LABEL_368;
_L12:
        break MISSING_BLOCK_LABEL_373;
_L13:
        break MISSING_BLOCK_LABEL_378;
_L14:
        break MISSING_BLOCK_LABEL_383;
_L1:
        break; /* Loop/switch isn't completed */
_L15:
        break MISSING_BLOCK_LABEL_388;
_L16:
        return false;
_L2:
        if (isRecord(obj))
        {
            for (schema = schema.getFields().iterator(); schema.hasNext();)
            {
                com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
                if (!validate(field.schema(), getField(obj, field.name(), field.pos())))
                {
                    return false;
                }
            }

            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        return schema.getEnumSymbols().contains(obj.toString());
_L4:
        if (obj instanceof Collection)
        {
            for (obj = ((Collection)obj).iterator(); ((Iterator) (obj)).hasNext();)
            {
                Object obj1 = ((Iterator) (obj)).next();
                if (!validate(schema.getElementType(), obj1))
                {
                    return false;
                }
            }

            return true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (obj instanceof Map)
        {
            for (obj = ((Map)obj).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                if (!validate(schema.getValueType(), entry.getValue()))
                {
                    return false;
                }
            }

            return true;
        }
        if (true) goto _L16; else goto _L6
_L6:
        schema = schema.getTypes().iterator();
_L19:
        if (!schema.hasNext()) goto _L16; else goto _L17
_L17:
        if (!validate((Schema)schema.next(), obj)) goto _L19; else goto _L18
_L18:
        return true;
        if (!(obj instanceof GenericFixed) || ((GenericFixed)obj).bytes().length != schema.getFixedSize())
        {
            flag = false;
        }
        return flag;
        return isString(obj);
        return isBytes(obj);
        return obj instanceof Integer;
        return obj instanceof Long;
        return obj instanceof Float;
        return obj instanceof Double;
        return obj instanceof Boolean;
        boolean flag1;
        if (obj == null)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    static 
    {
        STRINGS = Schema.create(com.flurry.org.apache.avro.Schema.Type.STRING);
    }

}
