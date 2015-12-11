// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

// Referenced classes of package com.flurry.android:
//            FrequencyCapInfo

public class RecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private CharSequence bJ;
    private long bK;
    private int bL;
    private int bM;
    private int bN;
    private long bO;
    private int cI;

    public FrequencyCapInfo build()
    {
        FrequencyCapInfo frequencycapinfo = new FrequencyCapInfo();
        if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
        CharSequence charsequence = bJ;
_L13:
        frequencycapinfo.bJ = charsequence;
        if (!fieldSetFlags()[1]) goto _L4; else goto _L3
_L3:
        long l = bK;
_L14:
        frequencycapinfo.bK = l;
        if (!fieldSetFlags()[2]) goto _L6; else goto _L5
_L5:
        l = bO;
_L15:
        frequencycapinfo.bO = l;
        if (!fieldSetFlags()[3]) goto _L8; else goto _L7
_L7:
        int i = cI;
_L16:
        frequencycapinfo.cI = i;
        if (!fieldSetFlags()[4]) goto _L10; else goto _L9
_L9:
        i = bL;
_L17:
        frequencycapinfo.bL = i;
        if (!fieldSetFlags()[5]) goto _L12; else goto _L11
_L11:
        i = bM;
_L18:
        frequencycapinfo.bM = i;
        if (!fieldSetFlags()[6])
        {
            break MISSING_BLOCK_LABEL_267;
        }
        i = bN;
_L19:
        frequencycapinfo.bN = i;
        return frequencycapinfo;
_L2:
        try
        {
            charsequence = (CharSequence)defaultValue(fields()[0]);
        }
        catch (Exception exception)
        {
            throw new AvroRuntimeException(exception);
        }
          goto _L13
_L4:
        l = ((Long)defaultValue(fields()[1])).longValue();
          goto _L14
_L6:
        l = ((Long)defaultValue(fields()[2])).longValue();
          goto _L15
_L8:
        i = ((Integer)defaultValue(fields()[3])).intValue();
          goto _L16
_L10:
        i = ((Integer)defaultValue(fields()[4])).intValue();
          goto _L17
_L12:
        i = ((Integer)defaultValue(fields()[5])).intValue();
          goto _L18
        i = ((Integer)defaultValue(fields()[6])).intValue();
          goto _L19
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearExpirationTime()
    {
        fieldSetFlags()[2] = false;
        return this;
    }

    public fieldSetFlags clearIdHash()
    {
        bJ = null;
        fieldSetFlags()[0] = false;
        return this;
    }

    public fieldSetFlags clearNewCap()
    {
        fieldSetFlags()[4] = false;
        return this;
    }

    public fieldSetFlags clearPreviousCap()
    {
        fieldSetFlags()[5] = false;
        return this;
    }

    public fieldSetFlags clearPreviousCapType()
    {
        fieldSetFlags()[6] = false;
        return this;
    }

    public fieldSetFlags clearServeTime()
    {
        fieldSetFlags()[1] = false;
        return this;
    }

    public fieldSetFlags clearViews()
    {
        fieldSetFlags()[3] = false;
        return this;
    }

    public Long getExpirationTime()
    {
        return Long.valueOf(bO);
    }

    public CharSequence getIdHash()
    {
        return bJ;
    }

    public Integer getNewCap()
    {
        return Integer.valueOf(bL);
    }

    public Integer getPreviousCap()
    {
        return Integer.valueOf(bM);
    }

    public Integer getPreviousCapType()
    {
        return Integer.valueOf(bN);
    }

    public Long getServeTime()
    {
        return Long.valueOf(bK);
    }

    public Integer getViews()
    {
        return Integer.valueOf(cI);
    }

    public boolean hasExpirationTime()
    {
        return fieldSetFlags()[2];
    }

    public boolean hasIdHash()
    {
        return fieldSetFlags()[0];
    }

    public boolean hasNewCap()
    {
        return fieldSetFlags()[4];
    }

    public boolean hasPreviousCap()
    {
        return fieldSetFlags()[5];
    }

    public boolean hasPreviousCapType()
    {
        return fieldSetFlags()[6];
    }

    public boolean hasServeTime()
    {
        return fieldSetFlags()[1];
    }

    public boolean hasViews()
    {
        return fieldSetFlags()[3];
    }

    public fieldSetFlags setExpirationTime(long l)
    {
        validate(fields()[2], Long.valueOf(l));
        bO = l;
        fieldSetFlags()[2] = true;
        return this;
    }

    public fieldSetFlags setIdHash(CharSequence charsequence)
    {
        validate(fields()[0], charsequence);
        bJ = charsequence;
        fieldSetFlags()[0] = true;
        return this;
    }

    public fieldSetFlags setNewCap(int i)
    {
        validate(fields()[4], Integer.valueOf(i));
        bL = i;
        fieldSetFlags()[4] = true;
        return this;
    }

    public fieldSetFlags setPreviousCap(int i)
    {
        validate(fields()[5], Integer.valueOf(i));
        bM = i;
        fieldSetFlags()[5] = true;
        return this;
    }

    public fieldSetFlags setPreviousCapType(int i)
    {
        validate(fields()[6], Integer.valueOf(i));
        bN = i;
        fieldSetFlags()[6] = true;
        return this;
    }

    public fieldSetFlags setServeTime(long l)
    {
        validate(fields()[1], Long.valueOf(l));
        bK = l;
        fieldSetFlags()[1] = true;
        return this;
    }

    public fieldSetFlags setViews(int i)
    {
        validate(fields()[3], Integer.valueOf(i));
        cI = i;
        fieldSetFlags()[3] = true;
        return this;
    }

    ion()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super(FrequencyCapInfo.SCHEMA$);
    }
}
