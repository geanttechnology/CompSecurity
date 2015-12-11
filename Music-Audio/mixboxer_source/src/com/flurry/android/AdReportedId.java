// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.nio.ByteBuffer;

class AdReportedId extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"AdReportedId\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}");
    public ByteBuffer dW;
    public int type;

    AdReportedId()
    {
    }

    public static Builder bO()
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
            return Integer.valueOf(type);

        case 1: // '\001'
            return dW;
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
            type = ((Integer)obj).intValue();
            return;

        case 1: // '\001'
            dW = (ByteBuffer)obj;
            break;
        }
    }


    private class Builder extends SpecificRecordBuilderBase
        implements RecordBuilder
    {

        private ByteBuffer dW;
        private int type;

        public AdReportedId build()
        {
            AdReportedId adreportedid = new AdReportedId();
            if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
            int i = type;
_L3:
            ByteBuffer bytebuffer;
            adreportedid.type = i;
            if (!fieldSetFlags()[1])
            {
                break MISSING_BLOCK_LABEL_68;
            }
            bytebuffer = dW;
_L4:
            adreportedid.dW = bytebuffer;
            return adreportedid;
_L2:
            try
            {
                i = ((Integer)defaultValue(fields()[0])).intValue();
            }
            catch (Exception exception)
            {
                throw new AvroRuntimeException(exception);
            }
              goto _L3
            bytebuffer = (ByteBuffer)defaultValue(fields()[1]);
              goto _L4
        }

        public volatile Object build()
        {
            return build();
        }

        public Builder clearId()
        {
            dW = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        public Builder clearType()
        {
            fieldSetFlags()[0] = false;
            return this;
        }

        public ByteBuffer getId()
        {
            return dW;
        }

        public Integer getType()
        {
            return Integer.valueOf(type);
        }

        public boolean hasId()
        {
            return fieldSetFlags()[1];
        }

        public boolean hasType()
        {
            return fieldSetFlags()[0];
        }

        public Builder setId(ByteBuffer bytebuffer)
        {
            validate(fields()[1], bytebuffer);
            dW = bytebuffer;
            fieldSetFlags()[1] = true;
            return this;
        }

        public Builder setType(int i)
        {
            validate(fields()[0], Integer.valueOf(i));
            type = i;
            fieldSetFlags()[0] = true;
            return this;
        }

        Builder()
        {
            this((byte)0);
        }

        private Builder(byte byte0)
        {
            super(AdReportedId.SCHEMA$);
        }
    }

}
