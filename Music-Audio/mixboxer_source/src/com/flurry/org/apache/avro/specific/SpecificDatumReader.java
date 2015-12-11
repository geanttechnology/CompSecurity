// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericDatumReader;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificData, SpecificRecord

public class SpecificDatumReader extends GenericDatumReader
{

    public SpecificDatumReader()
    {
        this(null, null, SpecificData.get());
    }

    public SpecificDatumReader(Schema schema)
    {
        this(schema, schema, SpecificData.get());
    }

    public SpecificDatumReader(Schema schema, Schema schema1)
    {
        this(schema, schema1, SpecificData.get());
    }

    public SpecificDatumReader(Schema schema, Schema schema1, SpecificData specificdata)
    {
        super(schema, schema1, specificdata);
    }

    public SpecificDatumReader(Class class1)
    {
        this(SpecificData.get().getSchema(class1));
    }

    protected Object createEnum(String s, Schema schema)
    {
        Class class1 = getSpecificData().getClass(schema);
        if (class1 == null)
        {
            return super.createEnum(s, schema);
        } else
        {
            return Enum.valueOf(class1, s);
        }
    }

    public SpecificData getSpecificData()
    {
        return (SpecificData)getData();
    }

    public void setSchema(Schema schema)
    {
        if (getExpected() == null && schema != null && schema.getType() == com.flurry.org.apache.avro.Schema.Type.RECORD)
        {
            SpecificData specificdata = getSpecificData();
            Class class1 = specificdata.getClass(schema);
            if (class1 != null && com/flurry/org/apache/avro/specific/SpecificRecord.isAssignableFrom(class1))
            {
                setExpected(specificdata.getSchema(class1));
            }
        }
        super.setSchema(schema);
    }
}
