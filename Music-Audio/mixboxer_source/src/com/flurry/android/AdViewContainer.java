// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;

class AdViewContainer extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"AdViewContainer\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0}]}");
    public int bp;
    public int bq;
    public int br;
    public int bs;
    public float density;

    AdViewContainer()
    {
    }

    public static Builder B()
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
            return Integer.valueOf(bp);

        case 1: // '\001'
            return Integer.valueOf(bq);

        case 2: // '\002'
            return Integer.valueOf(br);

        case 3: // '\003'
            return Integer.valueOf(bs);

        case 4: // '\004'
            return Float.valueOf(density);
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
            bp = ((Integer)obj).intValue();
            return;

        case 1: // '\001'
            bq = ((Integer)obj).intValue();
            return;

        case 2: // '\002'
            br = ((Integer)obj).intValue();
            return;

        case 3: // '\003'
            bs = ((Integer)obj).intValue();
            return;

        case 4: // '\004'
            density = ((Float)obj).floatValue();
            break;
        }
    }


    private class Builder extends SpecificRecordBuilderBase
        implements RecordBuilder
    {

        private int bp;
        private int bq;
        private int br;
        private int bs;
        private float density;

        public AdViewContainer build()
        {
            AdViewContainer adviewcontainer = new AdViewContainer();
            if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
            int i = bp;
_L9:
            adviewcontainer.bp = i;
            if (!fieldSetFlags()[1]) goto _L4; else goto _L3
_L3:
            i = bq;
_L10:
            adviewcontainer.bq = i;
            if (!fieldSetFlags()[2]) goto _L6; else goto _L5
_L5:
            i = br;
_L11:
            adviewcontainer.br = i;
            if (!fieldSetFlags()[3]) goto _L8; else goto _L7
_L7:
            i = bs;
_L12:
            float f;
            adviewcontainer.bs = i;
            if (!fieldSetFlags()[4])
            {
                break MISSING_BLOCK_LABEL_185;
            }
            f = density;
_L13:
            adviewcontainer.density = f;
            return adviewcontainer;
_L2:
            try
            {
                i = ((Integer)defaultValue(fields()[0])).intValue();
            }
            catch (Exception exception)
            {
                throw new AvroRuntimeException(exception);
            }
              goto _L9
_L4:
            i = ((Integer)defaultValue(fields()[1])).intValue();
              goto _L10
_L6:
            i = ((Integer)defaultValue(fields()[2])).intValue();
              goto _L11
_L8:
            i = ((Integer)defaultValue(fields()[3])).intValue();
              goto _L12
            f = ((Float)defaultValue(fields()[4])).floatValue();
              goto _L13
        }

        public volatile Object build()
        {
            return build();
        }

        public Builder clearDensity()
        {
            fieldSetFlags()[4] = false;
            return this;
        }

        public Builder clearScreenHeight()
        {
            fieldSetFlags()[3] = false;
            return this;
        }

        public Builder clearScreenWidth()
        {
            fieldSetFlags()[2] = false;
            return this;
        }

        public Builder clearViewHeight()
        {
            fieldSetFlags()[1] = false;
            return this;
        }

        public Builder clearViewWidth()
        {
            fieldSetFlags()[0] = false;
            return this;
        }

        public Float getDensity()
        {
            return Float.valueOf(density);
        }

        public Integer getScreenHeight()
        {
            return Integer.valueOf(bs);
        }

        public Integer getScreenWidth()
        {
            return Integer.valueOf(br);
        }

        public Integer getViewHeight()
        {
            return Integer.valueOf(bq);
        }

        public Integer getViewWidth()
        {
            return Integer.valueOf(bp);
        }

        public boolean hasDensity()
        {
            return fieldSetFlags()[4];
        }

        public boolean hasScreenHeight()
        {
            return fieldSetFlags()[3];
        }

        public boolean hasScreenWidth()
        {
            return fieldSetFlags()[2];
        }

        public boolean hasViewHeight()
        {
            return fieldSetFlags()[1];
        }

        public boolean hasViewWidth()
        {
            return fieldSetFlags()[0];
        }

        public Builder setDensity(float f)
        {
            validate(fields()[4], Float.valueOf(f));
            density = f;
            fieldSetFlags()[4] = true;
            return this;
        }

        public Builder setScreenHeight(int i)
        {
            validate(fields()[3], Integer.valueOf(i));
            bs = i;
            fieldSetFlags()[3] = true;
            return this;
        }

        public Builder setScreenWidth(int i)
        {
            validate(fields()[2], Integer.valueOf(i));
            br = i;
            fieldSetFlags()[2] = true;
            return this;
        }

        public Builder setViewHeight(int i)
        {
            validate(fields()[1], Integer.valueOf(i));
            bq = i;
            fieldSetFlags()[1] = true;
            return this;
        }

        public Builder setViewWidth(int i)
        {
            validate(fields()[0], Integer.valueOf(i));
            bp = i;
            fieldSetFlags()[0] = true;
            return this;
        }

        Builder()
        {
            this((byte)0);
        }

        private Builder(byte byte0)
        {
            super(AdViewContainer.SCHEMA$);
        }
    }

}
