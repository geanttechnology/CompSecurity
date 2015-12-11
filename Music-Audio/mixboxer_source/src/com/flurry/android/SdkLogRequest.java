// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;

class SdkLogRequest extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"SdkLogRequest\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"sdkAdLogs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdLog\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}}},{\"name\":\"agentTimestamp\",\"type\":\"long\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false}]}");
    public List cR;
    public long cS;
    public CharSequence ch;
    public List ck;
    public boolean cm;

    SdkLogRequest()
    {
    }

    public static Builder X()
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
            return ch;

        case 1: // '\001'
            return ck;

        case 2: // '\002'
            return cR;

        case 3: // '\003'
            return Long.valueOf(cS);

        case 4: // '\004'
            return Boolean.valueOf(cm);
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
            ch = (CharSequence)obj;
            return;

        case 1: // '\001'
            ck = (List)obj;
            return;

        case 2: // '\002'
            cR = (List)obj;
            return;

        case 3: // '\003'
            cS = ((Long)obj).longValue();
            return;

        case 4: // '\004'
            cm = ((Boolean)obj).booleanValue();
            break;
        }
    }


    private class Builder extends SpecificRecordBuilderBase
        implements RecordBuilder
    {

        private List cR;
        private long cS;
        private CharSequence ch;
        private List ck;
        private boolean cm;

        public SdkLogRequest build()
        {
            SdkLogRequest sdklogrequest = new SdkLogRequest();
            if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
            Object obj = ch;
_L9:
            sdklogrequest.ch = ((CharSequence) (obj));
            if (!fieldSetFlags()[1]) goto _L4; else goto _L3
_L3:
            obj = ck;
_L10:
            sdklogrequest.ck = ((List) (obj));
            if (!fieldSetFlags()[2]) goto _L6; else goto _L5
_L5:
            obj = cR;
_L11:
            sdklogrequest.cR = ((List) (obj));
            if (!fieldSetFlags()[3]) goto _L8; else goto _L7
_L7:
            long l = cS;
_L12:
            boolean flag;
            sdklogrequest.cS = l;
            if (!fieldSetFlags()[4])
            {
                break MISSING_BLOCK_LABEL_178;
            }
            flag = cm;
_L13:
            sdklogrequest.cm = flag;
            return sdklogrequest;
_L2:
            try
            {
                obj = (CharSequence)defaultValue(fields()[0]);
            }
            catch (Exception exception)
            {
                throw new AvroRuntimeException(exception);
            }
              goto _L9
_L4:
            obj = (List)defaultValue(fields()[1]);
              goto _L10
_L6:
            obj = (List)defaultValue(fields()[2]);
              goto _L11
_L8:
            l = ((Long)defaultValue(fields()[3])).longValue();
              goto _L12
            flag = ((Boolean)defaultValue(fields()[4])).booleanValue();
              goto _L13
        }

        public volatile Object build()
        {
            return build();
        }

        public Builder clearAdReportedIds()
        {
            ck = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        public Builder clearAgentTimestamp()
        {
            fieldSetFlags()[3] = false;
            return this;
        }

        public Builder clearApiKey()
        {
            ch = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        public Builder clearSdkAdLogs()
        {
            cR = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        public Builder clearTestDevice()
        {
            fieldSetFlags()[4] = false;
            return this;
        }

        public List getAdReportedIds()
        {
            return ck;
        }

        public Long getAgentTimestamp()
        {
            return Long.valueOf(cS);
        }

        public CharSequence getApiKey()
        {
            return ch;
        }

        public List getSdkAdLogs()
        {
            return cR;
        }

        public Boolean getTestDevice()
        {
            return Boolean.valueOf(cm);
        }

        public boolean hasAdReportedIds()
        {
            return fieldSetFlags()[1];
        }

        public boolean hasAgentTimestamp()
        {
            return fieldSetFlags()[3];
        }

        public boolean hasApiKey()
        {
            return fieldSetFlags()[0];
        }

        public boolean hasSdkAdLogs()
        {
            return fieldSetFlags()[2];
        }

        public boolean hasTestDevice()
        {
            return fieldSetFlags()[4];
        }

        public Builder setAdReportedIds(List list)
        {
            validate(fields()[1], list);
            ck = list;
            fieldSetFlags()[1] = true;
            return this;
        }

        public Builder setAgentTimestamp(long l)
        {
            validate(fields()[3], Long.valueOf(l));
            cS = l;
            fieldSetFlags()[3] = true;
            return this;
        }

        public Builder setApiKey(CharSequence charsequence)
        {
            validate(fields()[0], charsequence);
            ch = charsequence;
            fieldSetFlags()[0] = true;
            return this;
        }

        public Builder setSdkAdLogs(List list)
        {
            validate(fields()[2], list);
            cR = list;
            fieldSetFlags()[2] = true;
            return this;
        }

        public Builder setTestDevice(boolean flag)
        {
            validate(fields()[4], Boolean.valueOf(flag));
            cm = flag;
            fieldSetFlags()[4] = true;
            return this;
        }

        Builder()
        {
            this((byte)0);
        }

        private Builder(byte byte0)
        {
            super(SdkLogRequest.SCHEMA$);
        }
    }

}
