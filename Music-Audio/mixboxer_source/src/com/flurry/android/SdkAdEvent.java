// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.Map;

class SdkAdEvent extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}");
    public CharSequence ab;
    public Map ac;
    public long ad;

    SdkAdEvent()
    {
    }

    public final void a(CharSequence charsequence)
    {
        ab = charsequence;
    }

    public final void a(Long long1)
    {
        ad = long1.longValue();
    }

    public final void a(Map map)
    {
        ac = map;
    }

    public Object get(int i)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            return ab;

        case 1: // '\001'
            return ac;

        case 2: // '\002'
            return Long.valueOf(ad);
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
            ab = (CharSequence)obj;
            return;

        case 1: // '\001'
            ac = (Map)obj;
            return;

        case 2: // '\002'
            ad = ((Long)obj).longValue();
            break;
        }
    }

}
