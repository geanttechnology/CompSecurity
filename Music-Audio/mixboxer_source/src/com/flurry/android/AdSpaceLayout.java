// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;

class AdSpaceLayout extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}");
    public int cU;
    public int cV;
    public CharSequence cW;
    public CharSequence cX;
    public CharSequence cY;

    AdSpaceLayout()
    {
    }

    public Object get(int i)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            return Integer.valueOf(cU);

        case 1: // '\001'
            return Integer.valueOf(cV);

        case 2: // '\002'
            return cW;

        case 3: // '\003'
            return cX;

        case 4: // '\004'
            return cY;
        }
    }

    public final Integer getAdHeight()
    {
        return Integer.valueOf(cV);
    }

    public final Integer getAdWidth()
    {
        return Integer.valueOf(cU);
    }

    public final CharSequence getAlignment()
    {
        return cY;
    }

    public final CharSequence getFix()
    {
        return cW;
    }

    public final CharSequence getFormat()
    {
        return cX;
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
            cU = ((Integer)obj).intValue();
            return;

        case 1: // '\001'
            cV = ((Integer)obj).intValue();
            return;

        case 2: // '\002'
            cW = (CharSequence)obj;
            return;

        case 3: // '\003'
            cX = (CharSequence)obj;
            return;

        case 4: // '\004'
            cY = (CharSequence)obj;
            break;
        }
    }

}
