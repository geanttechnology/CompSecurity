// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;

class Location extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"Location\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]}");
    public float eO;
    public float eP;

    Location()
    {
    }

    public static Builder bS()
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
            return Float.valueOf(eO);

        case 1: // '\001'
            return Float.valueOf(eP);
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
            eO = ((Float)obj).floatValue();
            return;

        case 1: // '\001'
            eP = ((Float)obj).floatValue();
            break;
        }
    }


    private class Builder extends SpecificRecordBuilderBase
        implements RecordBuilder
    {

        private float eO;
        private float eP;

        public Location build()
        {
            Location location = new Location();
            if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
            float f = eO;
_L3:
            location.eO = f;
            if (!fieldSetFlags()[1])
            {
                break MISSING_BLOCK_LABEL_68;
            }
            f = eP;
_L4:
            location.eP = f;
            return location;
_L2:
            try
            {
                f = ((Float)defaultValue(fields()[0])).floatValue();
            }
            catch (Exception exception)
            {
                throw new AvroRuntimeException(exception);
            }
              goto _L3
            f = ((Float)defaultValue(fields()[1])).floatValue();
              goto _L4
        }

        public volatile Object build()
        {
            return build();
        }

        public Builder clearLat()
        {
            fieldSetFlags()[0] = false;
            return this;
        }

        public Builder clearLon()
        {
            fieldSetFlags()[1] = false;
            return this;
        }

        public Float getLat()
        {
            return Float.valueOf(eO);
        }

        public Float getLon()
        {
            return Float.valueOf(eP);
        }

        public boolean hasLat()
        {
            return fieldSetFlags()[0];
        }

        public boolean hasLon()
        {
            return fieldSetFlags()[1];
        }

        public Builder setLat(float f)
        {
            validate(fields()[0], Float.valueOf(f));
            eO = f;
            fieldSetFlags()[0] = true;
            return this;
        }

        public Builder setLon(float f)
        {
            validate(fields()[1], Float.valueOf(f));
            eP = f;
            fieldSetFlags()[1] = true;
            return this;
        }

        Builder()
        {
            this((byte)0);
        }

        private Builder(byte byte0)
        {
            super(Location.SCHEMA$);
        }
    }

}
