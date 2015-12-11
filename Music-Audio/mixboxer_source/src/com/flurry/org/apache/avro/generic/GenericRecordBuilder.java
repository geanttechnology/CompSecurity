// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.data.RecordBuilderBase;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericData

public class GenericRecordBuilder extends RecordBuilderBase
{

    private final GenericData.Record record;

    public GenericRecordBuilder(Schema schema)
    {
        super(schema, GenericData.get());
        record = new GenericData.Record(schema);
    }

    public GenericRecordBuilder(GenericData.Record record1)
    {
        super(record1.getSchema(), GenericData.get());
        record = new GenericData.Record(record1, true);
        Iterator iterator = schema().getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)iterator.next();
            Object obj = record1.get(field.pos());
            if (isValidValue(field, obj))
            {
                set(field, data().deepCopy(field.schema(), obj));
            }
        } while (true);
    }

    public GenericRecordBuilder(GenericRecordBuilder genericrecordbuilder)
    {
        super(genericrecordbuilder, GenericData.get());
        record = new GenericData.Record(genericrecordbuilder.record, true);
    }

    private Object getWithDefault(com.flurry.org.apache.avro.Schema.Field field)
        throws IOException
    {
        if (fieldSetFlags()[field.pos()])
        {
            return record.get(field.pos());
        } else
        {
            return defaultValue(field);
        }
    }

    private GenericRecordBuilder set(com.flurry.org.apache.avro.Schema.Field field, int i, Object obj)
    {
        validate(field, obj);
        record.put(i, obj);
        fieldSetFlags()[i] = true;
        return this;
    }

    public GenericData.Record build()
    {
        Object obj;
        com.flurry.org.apache.avro.Schema.Field afield[];
        int i;
        int j;
        try
        {
            obj = new GenericData.Record(schema());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AvroRuntimeException(((Throwable) (obj)));
        }
        afield = fields();
        j = afield.length;
        i = 0;
        while (i < j) 
        {
            com.flurry.org.apache.avro.Schema.Field field = afield[i];
            Object obj1;
            try
            {
                obj1 = getWithDefault(field);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AvroRuntimeException(((Throwable) (obj)));
            }
            if (obj1 != null)
            {
                ((GenericData.Record) (obj)).put(field.pos(), obj1);
            }
            i++;
        }
        return ((GenericData.Record) (obj));
    }

    public volatile Object build()
    {
        return build();
    }

    protected GenericRecordBuilder clear(int i)
    {
        record.put(i, null);
        fieldSetFlags()[i] = false;
        return this;
    }

    public GenericRecordBuilder clear(com.flurry.org.apache.avro.Schema.Field field)
    {
        return clear(field.pos());
    }

    public GenericRecordBuilder clear(String s)
    {
        return clear(schema().getField(s));
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!super.equals(obj))
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (GenericRecordBuilder)obj;
        if (record != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((GenericRecordBuilder) (obj)).record == null) goto _L1; else goto _L3
_L3:
        return false;
        if (record.equals(((GenericRecordBuilder) (obj)).record)) goto _L1; else goto _L4
_L4:
        return false;
    }

    protected Object get(int i)
    {
        return record.get(i);
    }

    public Object get(com.flurry.org.apache.avro.Schema.Field field)
    {
        return get(field.pos());
    }

    public Object get(String s)
    {
        return get(schema().getField(s));
    }

    protected boolean has(int i)
    {
        return fieldSetFlags()[i];
    }

    public boolean has(com.flurry.org.apache.avro.Schema.Field field)
    {
        return has(field.pos());
    }

    public boolean has(String s)
    {
        return has(schema().getField(s));
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int i;
        if (record == null)
        {
            i = 0;
        } else
        {
            i = record.hashCode();
        }
        return j * 31 + i;
    }

    protected GenericRecordBuilder set(int i, Object obj)
    {
        return set(fields()[i], i, obj);
    }

    public GenericRecordBuilder set(com.flurry.org.apache.avro.Schema.Field field, Object obj)
    {
        return set(field, field.pos(), obj);
    }

    public GenericRecordBuilder set(String s, Object obj)
    {
        return set(schema().getField(s), obj);
    }
}
