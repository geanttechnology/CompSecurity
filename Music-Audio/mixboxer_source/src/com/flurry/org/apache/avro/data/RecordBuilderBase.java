// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.data;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericData;
import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.BinaryEncoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.EncoderFactory;
import com.flurry.org.apache.avro.io.parsing.ResolvingGrammarGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.flurry.org.apache.avro.data:
//            RecordBuilder

public abstract class RecordBuilderBase
    implements RecordBuilder
{

    private static final ConcurrentMap DEFAULT_VALUE_CACHE = new ConcurrentHashMap();
    private static final com.flurry.org.apache.avro.Schema.Field EMPTY_FIELDS[] = new com.flurry.org.apache.avro.Schema.Field[0];
    private final GenericData data;
    private BinaryDecoder decoder;
    private BinaryEncoder encoder;
    private final boolean fieldSetFlags[];
    private final com.flurry.org.apache.avro.Schema.Field fields[];
    private final Schema schema;

    protected RecordBuilderBase(Schema schema1, GenericData genericdata)
    {
        encoder = null;
        decoder = null;
        schema = schema1;
        data = genericdata;
        fields = (com.flurry.org.apache.avro.Schema.Field[])(com.flurry.org.apache.avro.Schema.Field[])schema1.getFields().toArray(EMPTY_FIELDS);
        fieldSetFlags = new boolean[fields.length];
    }

    protected RecordBuilderBase(RecordBuilderBase recordbuilderbase, GenericData genericdata)
    {
        encoder = null;
        decoder = null;
        schema = recordbuilderbase.schema;
        data = genericdata;
        fields = (com.flurry.org.apache.avro.Schema.Field[])(com.flurry.org.apache.avro.Schema.Field[])schema.getFields().toArray(EMPTY_FIELDS);
        fieldSetFlags = new boolean[recordbuilderbase.fieldSetFlags.length];
        System.arraycopy(recordbuilderbase.fieldSetFlags, 0, fieldSetFlags, 0, fieldSetFlags.length);
    }

    protected static boolean isValidValue(com.flurry.org.apache.avro.Schema.Field field, Object obj)
    {
        if (obj == null)
        {
            field = field.schema();
            obj = field.getType();
            if (obj != com.flurry.org.apache.avro.Schema.Type.NULL)
            {
label0:
                {
                    if (obj != com.flurry.org.apache.avro.Schema.Type.UNION)
                    {
                        break label0;
                    }
                    field = field.getTypes().iterator();
                    do
                    {
                        if (!field.hasNext())
                        {
                            break label0;
                        }
                    } while (((Schema)field.next()).getType() != com.flurry.org.apache.avro.Schema.Type.NULL);
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    protected final GenericData data()
    {
        return data;
    }

    protected Object defaultValue(com.flurry.org.apache.avro.Schema.Field field)
        throws IOException
    {
        JsonNode jsonnode = field.defaultValue();
        if (jsonnode == null)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Field ").append(field).append(" not set and has no default value").toString());
        }
        if (jsonnode.isNull() && (field.schema().getType() == com.flurry.org.apache.avro.Schema.Type.NULL || field.schema().getType() == com.flurry.org.apache.avro.Schema.Type.UNION && ((Schema)field.schema().getTypes().get(0)).getType() == com.flurry.org.apache.avro.Schema.Type.NULL))
        {
            return null;
        }
        Object obj = (ConcurrentMap)DEFAULT_VALUE_CACHE.get(schema.getFullName());
        ConcurrentMap concurrentmap = ((ConcurrentMap) (obj));
        if (obj == null)
        {
            DEFAULT_VALUE_CACHE.putIfAbsent(schema.getFullName(), new ConcurrentHashMap(fields.length));
            concurrentmap = (ConcurrentMap)DEFAULT_VALUE_CACHE.get(schema.getFullName());
        }
        Object obj1 = concurrentmap.get(Integer.valueOf(field.pos()));
        obj = obj1;
        if (obj1 == null)
        {
            obj = new ByteArrayOutputStream();
            encoder = EncoderFactory.get().binaryEncoder(((java.io.OutputStream) (obj)), encoder);
            ResolvingGrammarGenerator.encode(encoder, field.schema(), jsonnode);
            encoder.flush();
            decoder = DecoderFactory.get().binaryDecoder(((ByteArrayOutputStream) (obj)).toByteArray(), decoder);
            obj = data.createDatumReader(field.schema()).read(null, decoder);
            concurrentmap.putIfAbsent(Integer.valueOf(field.pos()), obj);
        }
        return data.deepCopy(field.schema(), obj);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (RecordBuilderBase)obj;
        if (!Arrays.equals(fieldSetFlags, ((RecordBuilderBase) (obj)).fieldSetFlags))
        {
            return false;
        }
        if (schema != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((RecordBuilderBase) (obj)).schema == null) goto _L1; else goto _L3
_L3:
        return false;
        if (schema.equals(((RecordBuilderBase) (obj)).schema)) goto _L1; else goto _L4
_L4:
        return false;
    }

    protected final boolean[] fieldSetFlags()
    {
        return fieldSetFlags;
    }

    protected final com.flurry.org.apache.avro.Schema.Field[] fields()
    {
        return fields;
    }

    public int hashCode()
    {
        int j = Arrays.hashCode(fieldSetFlags);
        int i;
        if (schema == null)
        {
            i = 0;
        } else
        {
            i = schema.hashCode();
        }
        return (j + 31) * 31 + i;
    }

    protected final Schema schema()
    {
        return schema;
    }

    protected void validate(com.flurry.org.apache.avro.Schema.Field field, Object obj)
    {
        while (isValidValue(field, obj) || field.defaultValue() != null) 
        {
            return;
        }
        throw new AvroRuntimeException((new StringBuilder()).append("Field ").append(field).append(" does not accept null values").toString());
    }

}
