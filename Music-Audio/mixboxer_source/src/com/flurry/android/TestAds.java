// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;

class TestAds extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"TestAds\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]}");
    public int eh;

    TestAds()
    {
    }

    public static Builder bN()
    {
        return new Builder();
    }

    public Object get(int i)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            return Integer.valueOf(eh);
        }
    }

    public Schema getSchema()
    {
        return SCHEMA$;
    }

    public void put(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            eh = ((Integer)obj).intValue();
            break;
        }
    }


    private class Builder extends SpecificRecordBuilderBase
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

        public Builder clearAdspacePlacement()
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

        public Builder setAdspacePlacement(int i)
        {
            validate(fields()[0], Integer.valueOf(i));
            eh = i;
            fieldSetFlags()[0] = true;
            return this;
        }

        Builder()
        {
            this((byte)0);
        }

        private Builder(byte byte0)
        {
            super(TestAds.SCHEMA$);
        }
    }

}
