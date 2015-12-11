// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericDatumWriter;
import com.flurry.org.apache.avro.io.Encoder;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificData

public class SpecificDatumWriter extends GenericDatumWriter
{

    public SpecificDatumWriter()
    {
        super(SpecificData.get());
    }

    public SpecificDatumWriter(Schema schema)
    {
        super(schema, SpecificData.get());
    }

    protected SpecificDatumWriter(Schema schema, SpecificData specificdata)
    {
        super(schema, specificdata);
    }

    protected SpecificDatumWriter(SpecificData specificdata)
    {
        super(specificdata);
    }

    public SpecificDatumWriter(Class class1)
    {
        super(SpecificData.get().getSchema(class1), SpecificData.get());
    }

    protected void writeEnum(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        if (!(obj instanceof Enum))
        {
            super.writeEnum(schema, obj, encoder);
            return;
        } else
        {
            encoder.writeEnum(((Enum)obj).ordinal());
            return;
        }
    }
}
