// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

// Referenced classes of package com.flurry.android:
//            TestAds

public class .SpecificRecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private int eh;

    public TestAds build()
    {
        TestAds testads;
        int i;
        testads = new TestAds();
        if (!fieldSetFlags()[0])
        {
            break MISSING_BLOCK_LABEL_29;
        }
        i = eh;
_L1:
        testads.eh = i;
        return testads;
        try
        {
            i = ((Integer)defaultValue(fields()[0])).intValue();
        }
        catch (Exception exception)
        {
            throw new AvroRuntimeException(exception);
        }
          goto _L1
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearAdspacePlacement()
    {
        fieldSetFlags()[0] = false;
        return this;
    }

    public Integer getAdspacePlacement()
    {
        return Integer.valueOf(eh);
    }

    public boolean hasAdspacePlacement()
    {
        return fieldSetFlags()[0];
    }

    public fieldSetFlags setAdspacePlacement(int i)
    {
        validate(fields()[0], Integer.valueOf(i));
        eh = i;
        fieldSetFlags()[0] = true;
        return this;
    }

    imeException()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super(TestAds.SCHEMA$);
    }
}
