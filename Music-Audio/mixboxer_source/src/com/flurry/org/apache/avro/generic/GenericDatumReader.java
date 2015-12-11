// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.ResolvingDecoder;
import com.flurry.org.apache.avro.util.Utf8;
import com.flurry.org.apache.avro.util.WeakIdentityHashMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericData, GenericArray, GenericFixed

public class GenericDatumReader
    implements DatumReader
{

    private static final ThreadLocal RESOLVER_CACHE = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Map initialValue()
        {
            return new WeakIdentityHashMap();
        }

    };
    private Schema actual;
    private final Thread creator;
    private ResolvingDecoder creatorResolver;
    private final GenericData data;
    private Schema expected;

    public GenericDatumReader()
    {
        this(null, null, GenericData.get());
    }

    public GenericDatumReader(Schema schema)
    {
        this(schema, schema, GenericData.get());
    }

    public GenericDatumReader(Schema schema, Schema schema1)
    {
        this(schema, schema1, GenericData.get());
    }

    protected GenericDatumReader(Schema schema, Schema schema1, GenericData genericdata)
    {
        creatorResolver = null;
        actual = schema;
        expected = schema1;
        data = genericdata;
        creator = Thread.currentThread();
    }

    public static void skip(Schema schema, Decoder decoder)
        throws IOException
    {
        static class _cls2
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

        _cls2..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 80
    //                   1 107
    //                   2 145
    //                   3 151
    //                   4 199
    //                   5 251
    //                   6 272
    //                   7 281
    //                   8 286
    //                   9 291
    //                   10 297
    //                   11 303
    //                   12 309
    //                   13 315
    //                   14 150;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L7:
        break MISSING_BLOCK_LABEL_272;
_L8:
        break MISSING_BLOCK_LABEL_281;
_L9:
        break MISSING_BLOCK_LABEL_286;
_L10:
        break MISSING_BLOCK_LABEL_291;
_L11:
        break MISSING_BLOCK_LABEL_297;
_L12:
        break MISSING_BLOCK_LABEL_303;
_L13:
        break MISSING_BLOCK_LABEL_309;
_L14:
        break MISSING_BLOCK_LABEL_315;
_L15:
        break; /* Loop/switch isn't completed */
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unknown type: ").append(schema).toString());
_L2:
        for (schema = schema.getFields().iterator(); schema.hasNext(); skip(((com.flurry.org.apache.avro.Schema.Field)schema.next()).schema(), decoder)) { }
        break; /* Loop/switch isn't completed */
_L3:
        decoder.readInt();
_L16:
        return;
_L4:
        schema = schema.getElementType();
        long l = decoder.skipArray();
        while (l > 0L) 
        {
            for (long l2 = 0L; l2 < l; l2++)
            {
                skip(schema, decoder);
            }

            l = decoder.skipArray();
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        schema = schema.getValueType();
        long l1 = decoder.skipMap();
        while (l1 > 0L) 
        {
            for (long l3 = 0L; l3 < l1; l3++)
            {
                decoder.skipString();
                skip(schema, decoder);
            }

            l1 = decoder.skipMap();
        }
        if (true) goto _L16; else goto _L6
_L6:
        skip((Schema)schema.getTypes().get(decoder.readIndex()), decoder);
        return;
        decoder.skipFixed(schema.getFixedSize());
        return;
        decoder.skipString();
        return;
        decoder.skipBytes();
        return;
        decoder.readInt();
        return;
        decoder.readLong();
        return;
        decoder.readFloat();
        return;
        decoder.readDouble();
        return;
        decoder.readBoolean();
        return;
    }

    protected void addToArray(Object obj, long l, Object obj1)
    {
        ((Collection)obj).add(obj1);
    }

    protected void addToMap(Object obj, Object obj1, Object obj2)
    {
        ((Map)obj).put(obj1, obj2);
    }

    protected Object createBytes(byte abyte0[])
    {
        return ByteBuffer.wrap(abyte0);
    }

    protected Object createEnum(String s, Schema schema)
    {
        return new GenericData.EnumSymbol(schema, s);
    }

    protected Object createFixed(Object obj, Schema schema)
    {
        return data.createFixed(obj, schema);
    }

    protected Object createFixed(Object obj, byte abyte0[], Schema schema)
    {
        return data.createFixed(obj, abyte0, schema);
    }

    protected Object createString(String s)
    {
        return new Utf8(s);
    }

    public GenericData getData()
    {
        return data;
    }

    public Schema getExpected()
    {
        return expected;
    }

    protected final ResolvingDecoder getResolver(Schema schema, Schema schema1)
        throws IOException
    {
        Thread thread = Thread.currentThread();
        if (thread == creator && creatorResolver != null)
        {
            schema = creatorResolver;
        } else
        {
            Object obj = (Map)((Map)RESOLVER_CACHE.get()).get(schema);
            Object obj1 = obj;
            if (obj == null)
            {
                obj1 = new WeakIdentityHashMap();
                ((Map)RESOLVER_CACHE.get()).put(schema, obj1);
            }
            ResolvingDecoder resolvingdecoder = (ResolvingDecoder)((Map) (obj1)).get(schema1);
            obj = resolvingdecoder;
            if (resolvingdecoder == null)
            {
                obj = DecoderFactory.get().resolvingDecoder(Schema.applyAliases(schema, schema1), schema1, null);
                ((Map) (obj1)).put(schema1, obj);
            }
            schema = ((Schema) (obj));
            if (thread == creator)
            {
                creatorResolver = ((ResolvingDecoder) (obj));
                return ((ResolvingDecoder) (obj));
            }
        }
        return schema;
    }

    public Schema getSchema()
    {
        return actual;
    }

    protected Object newArray(Object obj, int i, Schema schema)
    {
        if (obj instanceof Collection)
        {
            ((Collection)obj).clear();
            return obj;
        } else
        {
            return new GenericData.Array(i, schema);
        }
    }

    protected Object newMap(Object obj, int i)
    {
        if (obj instanceof Map)
        {
            ((Map)obj).clear();
            return obj;
        } else
        {
            return new HashMap(i);
        }
    }

    protected Object newRecord(Object obj, Schema schema)
    {
        return data.newRecord(obj, schema);
    }

    protected Object peekArray(Object obj)
    {
        if (obj instanceof GenericArray)
        {
            return ((GenericArray)obj).peek();
        } else
        {
            return null;
        }
    }

    protected Object read(Object obj, Schema schema, ResolvingDecoder resolvingdecoder)
        throws IOException
    {
        switch (_cls2..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()])
        {
        default:
            throw new AvroRuntimeException((new StringBuilder()).append("Unknown type: ").append(schema).toString());

        case 1: // '\001'
            return readRecord(obj, schema, resolvingdecoder);

        case 2: // '\002'
            return readEnum(schema, resolvingdecoder);

        case 3: // '\003'
            return readArray(obj, schema, resolvingdecoder);

        case 4: // '\004'
            return readMap(obj, schema, resolvingdecoder);

        case 5: // '\005'
            return read(obj, (Schema)schema.getTypes().get(resolvingdecoder.readIndex()), resolvingdecoder);

        case 6: // '\006'
            return readFixed(obj, schema, resolvingdecoder);

        case 7: // '\007'
            return readString(obj, schema, resolvingdecoder);

        case 8: // '\b'
            return readBytes(obj, resolvingdecoder);

        case 9: // '\t'
            return readInt(obj, schema, resolvingdecoder);

        case 10: // '\n'
            return Long.valueOf(resolvingdecoder.readLong());

        case 11: // '\013'
            return Float.valueOf(resolvingdecoder.readFloat());

        case 12: // '\f'
            return Double.valueOf(resolvingdecoder.readDouble());

        case 13: // '\r'
            return Boolean.valueOf(resolvingdecoder.readBoolean());

        case 14: // '\016'
            resolvingdecoder.readNull();
            break;
        }
        return null;
    }

    public Object read(Object obj, Decoder decoder)
        throws IOException
    {
        ResolvingDecoder resolvingdecoder = getResolver(actual, expected);
        resolvingdecoder.configure(decoder);
        obj = read(obj, expected, resolvingdecoder);
        resolvingdecoder.drain();
        return obj;
    }

    protected Object readArray(Object obj, Schema schema, ResolvingDecoder resolvingdecoder)
        throws IOException
    {
        Schema schema1 = schema.getElementType();
        long l = resolvingdecoder.readArrayStart();
        long l1 = 0L;
        if (l > 0L)
        {
            obj = newArray(obj, (int)l, schema);
            long l3;
            do
            {
                for (long l2 = 0L; l2 < l; l2++)
                {
                    addToArray(obj, l1 + l2, read(peekArray(obj), schema1, resolvingdecoder));
                }

                l1 += l;
                l3 = resolvingdecoder.arrayNext();
                l = l3;
            } while (l3 > 0L);
            return obj;
        } else
        {
            return newArray(obj, 0, schema);
        }
    }

    protected Object readBytes(Object obj, Decoder decoder)
        throws IOException
    {
        if (obj instanceof ByteBuffer)
        {
            obj = (ByteBuffer)obj;
        } else
        {
            obj = null;
        }
        return decoder.readBytes(((ByteBuffer) (obj)));
    }

    protected Object readEnum(Schema schema, Decoder decoder)
        throws IOException
    {
        return createEnum((String)schema.getEnumSymbols().get(decoder.readEnum()), schema);
    }

    protected Object readFixed(Object obj, Schema schema, Decoder decoder)
        throws IOException
    {
        obj = (GenericFixed)data.createFixed(obj, schema);
        decoder.readFixed(((GenericFixed) (obj)).bytes(), 0, schema.getFixedSize());
        return obj;
    }

    protected Object readInt(Object obj, Schema schema, Decoder decoder)
        throws IOException
    {
        return Integer.valueOf(decoder.readInt());
    }

    protected Object readMap(Object obj, Schema schema, ResolvingDecoder resolvingdecoder)
        throws IOException
    {
        Schema schema1 = schema.getValueType();
        long l = resolvingdecoder.readMapStart();
        obj = newMap(obj, (int)l);
        long l1;
        if (l > 0L)
        {
            do
            {
                for (int i = 0; (long)i < l; i++)
                {
                    addToMap(obj, readString(null, schema, resolvingdecoder), read(null, schema1, resolvingdecoder));
                }

                l1 = resolvingdecoder.mapNext();
                l = l1;
            } while (l1 > 0L);
        }
        return obj;
    }

    protected Object readRecord(Object obj, Schema schema, ResolvingDecoder resolvingdecoder)
        throws IOException
    {
        Object obj1 = data.newRecord(obj, schema);
        Object obj2 = data.getRecordState(obj1, schema);
        com.flurry.org.apache.avro.Schema.Field afield[] = resolvingdecoder.readFieldOrder();
        int j = afield.length;
        int i = 0;
        while (i < j) 
        {
            com.flurry.org.apache.avro.Schema.Field field = afield[i];
            int k = field.pos();
            String s = field.name();
            if (obj != null)
            {
                schema = ((Schema) (data.getField(obj1, s, k, obj2)));
            } else
            {
                schema = null;
            }
            data.setField(obj1, s, k, read(schema, field.schema(), resolvingdecoder), obj2);
            i++;
        }
        return obj1;
    }

    protected Object readString(Object obj, Schema schema, Decoder decoder)
        throws IOException
    {
        GenericData genericdata = data;
        genericdata = data;
        if ("String".equals(schema.getProp("avro.java.string")))
        {
            return decoder.readString();
        } else
        {
            return readString(obj, decoder);
        }
    }

    protected Object readString(Object obj, Decoder decoder)
        throws IOException
    {
        if (obj instanceof Utf8)
        {
            obj = (Utf8)obj;
        } else
        {
            obj = null;
        }
        return decoder.readString(((Utf8) (obj)));
    }

    public void setExpected(Schema schema)
    {
        expected = schema;
        creatorResolver = null;
    }

    public void setSchema(Schema schema)
    {
        actual = schema;
        if (expected == null)
        {
            expected = actual;
        }
        creatorResolver = null;
    }

}
