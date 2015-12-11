// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.DatumWriter;
import com.flurry.org.apache.avro.io.Encoder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericData, GenericFixed

public class GenericDatumWriter
    implements DatumWriter
{

    private final GenericData data;
    private Schema root;

    public GenericDatumWriter()
    {
        this(GenericData.get());
    }

    public GenericDatumWriter(Schema schema)
    {
        this();
        setSchema(schema);
    }

    protected GenericDatumWriter(Schema schema, GenericData genericdata)
    {
        this(genericdata);
        setSchema(schema);
    }

    protected GenericDatumWriter(GenericData genericdata)
    {
        data = genericdata;
    }

    private void error(Schema schema, Object obj)
    {
        throw new AvroTypeException((new StringBuilder()).append("Not a ").append(schema).append(": ").append(obj).toString());
    }

    protected Iterator getArrayElements(Object obj)
    {
        return ((Collection)obj).iterator();
    }

    protected long getArraySize(Object obj)
    {
        return (long)((Collection)obj).size();
    }

    public GenericData getData()
    {
        return data;
    }

    protected Iterable getMapEntries(Object obj)
    {
        return ((Map)obj).entrySet();
    }

    protected int getMapSize(Object obj)
    {
        return ((Map)obj).size();
    }

    protected NullPointerException npe(NullPointerException nullpointerexception, String s)
    {
        s = new NullPointerException((new StringBuilder()).append(nullpointerexception.getMessage()).append(s).toString());
        if (nullpointerexception.getCause() != null)
        {
            nullpointerexception = nullpointerexception.getCause();
        }
        s.initCause(nullpointerexception);
        return s;
    }

    protected int resolveUnion(Schema schema, Object obj)
    {
        return data.resolveUnion(schema, obj);
    }

    public void setSchema(Schema schema)
    {
        root = schema;
    }

    protected void write(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
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

        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 271
    //                   1 87
    //                   2 124
    //                   3 132
    //                   4 140
    //                   5 148
    //                   6 183
    //                   7 191
    //                   8 199
    //                   9 206
    //                   10 218
    //                   11 230
    //                   12 242
    //                   13 254
    //                   14 266;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        error(schema, obj);
        return;
_L2:
        try
        {
            writeRecord(schema, obj, encoder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw npe(((NullPointerException) (obj)), (new StringBuilder()).append(" of ").append(schema.getFullName()).toString());
        }
_L3:
        writeEnum(schema, obj, encoder);
        return;
_L4:
        writeArray(schema, obj, encoder);
        return;
_L5:
        writeMap(schema, obj, encoder);
        return;
_L6:
        int i = resolveUnion(schema, obj);
        encoder.writeIndex(i);
        write((Schema)schema.getTypes().get(i), obj, encoder);
        return;
_L7:
        writeFixed(schema, obj, encoder);
        return;
_L8:
        writeString(schema, obj, encoder);
        return;
_L9:
        writeBytes(obj, encoder);
        return;
_L10:
        encoder.writeInt(((Number)obj).intValue());
        return;
_L11:
        encoder.writeLong(((Long)obj).longValue());
        return;
_L12:
        encoder.writeFloat(((Float)obj).floatValue());
        return;
_L13:
        encoder.writeDouble(((Double)obj).doubleValue());
        return;
_L14:
        encoder.writeBoolean(((Boolean)obj).booleanValue());
        return;
_L15:
        encoder.writeNull();
        return;
    }

    public void write(Object obj, Encoder encoder)
        throws IOException
    {
        write(root, obj, encoder);
    }

    protected void writeArray(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        schema = schema.getElementType();
        long l = getArraySize(obj);
        encoder.writeArrayStart();
        encoder.setItemCount(l);
        for (obj = getArrayElements(obj); ((Iterator) (obj)).hasNext(); write(schema, ((Iterator) (obj)).next(), encoder))
        {
            encoder.startItem();
        }

        encoder.writeArrayEnd();
    }

    protected void writeBytes(Object obj, Encoder encoder)
        throws IOException
    {
        encoder.writeBytes((ByteBuffer)obj);
    }

    protected void writeEnum(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        encoder.writeEnum(schema.getEnumOrdinal(obj.toString()));
    }

    protected void writeFixed(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        encoder.writeFixed(((GenericFixed)obj).bytes(), 0, schema.getFixedSize());
    }

    protected void writeMap(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        schema = schema.getValueType();
        int i = getMapSize(obj);
        encoder.writeMapStart();
        encoder.setItemCount(i);
        java.util.Map.Entry entry;
        for (obj = getMapEntries(obj).iterator(); ((Iterator) (obj)).hasNext(); write(schema, entry.getValue(), encoder))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            encoder.startItem();
            writeString(entry.getKey(), encoder);
        }

        encoder.writeMapEnd();
    }

    protected void writeRecord(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        Object obj1 = data.getRecordState(obj, schema);
        for (Iterator iterator = schema.getFields().iterator(); iterator.hasNext();)
        {
            schema = (com.flurry.org.apache.avro.Schema.Field)iterator.next();
            Object obj2 = data.getField(obj, schema.name(), schema.pos(), obj1);
            try
            {
                write(schema.schema(), obj2, encoder);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw npe(((NullPointerException) (obj)), (new StringBuilder()).append(" in field ").append(schema.name()).toString());
            }
        }

    }

    protected void writeString(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        writeString(obj, encoder);
    }

    protected void writeString(Object obj, Encoder encoder)
        throws IOException
    {
        encoder.writeString((CharSequence)obj);
    }
}
