// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

// Referenced classes of package com.flurry.android:
//            AdViewContainer

public class cRecordBuilderBase extends SpecificRecordBuilderBase
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

    public build clearDensity()
    {
        fieldSetFlags()[4] = false;
        return this;
    }

    public fieldSetFlags clearScreenHeight()
    {
        fieldSetFlags()[3] = false;
        return this;
    }

    public fieldSetFlags clearScreenWidth()
    {
        fieldSetFlags()[2] = false;
        return this;
    }

    public fieldSetFlags clearViewHeight()
    {
        fieldSetFlags()[1] = false;
        return this;
    }

    public fieldSetFlags clearViewWidth()
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

    public fieldSetFlags setDensity(float f)
    {
        validate(fields()[4], Float.valueOf(f));
        density = f;
        fieldSetFlags()[4] = true;
        return this;
    }

    public fieldSetFlags setScreenHeight(int i)
    {
        validate(fields()[3], Integer.valueOf(i));
        bs = i;
        fieldSetFlags()[3] = true;
        return this;
    }

    public fieldSetFlags setScreenWidth(int i)
    {
        validate(fields()[2], Integer.valueOf(i));
        br = i;
        fieldSetFlags()[2] = true;
        return this;
    }

    public fieldSetFlags setViewHeight(int i)
    {
        validate(fields()[1], Integer.valueOf(i));
        bq = i;
        fieldSetFlags()[1] = true;
        return this;
    }

    public fieldSetFlags setViewWidth(int i)
    {
        validate(fields()[0], Integer.valueOf(i));
        bp = i;
        fieldSetFlags()[0] = true;
        return this;
    }

    tion()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super(AdViewContainer.SCHEMA$);
    }
}
