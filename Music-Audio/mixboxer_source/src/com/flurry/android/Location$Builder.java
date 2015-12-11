// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

// Referenced classes of package com.flurry.android:
//            Location

public class SpecificRecordBuilderBase extends SpecificRecordBuilderBase
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

    public build clearLat()
    {
        fieldSetFlags()[0] = false;
        return this;
    }

    public fieldSetFlags clearLon()
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

    public fieldSetFlags setLat(float f)
    {
        validate(fields()[0], Float.valueOf(f));
        eO = f;
        fieldSetFlags()[0] = true;
        return this;
    }

    public fieldSetFlags setLon(float f)
    {
        validate(fields()[1], Float.valueOf(f));
        eP = f;
        fieldSetFlags()[1] = true;
        return this;
    }

    meException()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super(Location.SCHEMA$);
    }
}
