// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.data.RecordBuilderBase;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificData, SpecificRecord

public abstract class SpecificRecordBuilderBase extends RecordBuilderBase
{

    protected SpecificRecordBuilderBase(Schema schema)
    {
        super(schema, SpecificData.get());
    }

    protected SpecificRecordBuilderBase(SpecificRecord specificrecord)
    {
        super(specificrecord.getSchema(), SpecificData.get());
    }

    protected SpecificRecordBuilderBase(SpecificRecordBuilderBase specificrecordbuilderbase)
    {
        super(specificrecordbuilderbase, SpecificData.get());
    }
}
