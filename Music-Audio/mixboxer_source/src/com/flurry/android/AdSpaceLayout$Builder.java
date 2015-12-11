// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

// Referenced classes of package com.flurry.android:
//            AdSpaceLayout

public class ficRecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private int cU;
    private int cV;
    private CharSequence cW;
    private CharSequence cX;
    private CharSequence cY;

    public AdSpaceLayout build()
    {
        AdSpaceLayout adspacelayout = new AdSpaceLayout();
        if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
        int i = cU;
_L9:
        adspacelayout.cU = i;
        if (!fieldSetFlags()[1]) goto _L4; else goto _L3
_L3:
        i = cV;
_L10:
        adspacelayout.cV = i;
        if (!fieldSetFlags()[2]) goto _L6; else goto _L5
_L5:
        CharSequence charsequence = cW;
_L11:
        adspacelayout.cW = charsequence;
        if (!fieldSetFlags()[3]) goto _L8; else goto _L7
_L7:
        charsequence = cX;
_L12:
        adspacelayout.cX = charsequence;
        if (!fieldSetFlags()[4])
        {
            break MISSING_BLOCK_LABEL_179;
        }
        charsequence = cY;
_L13:
        adspacelayout.cY = charsequence;
        return adspacelayout;
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
        charsequence = (CharSequence)defaultValue(fields()[2]);
          goto _L11
_L8:
        charsequence = (CharSequence)defaultValue(fields()[3]);
          goto _L12
        charsequence = (CharSequence)defaultValue(fields()[4]);
          goto _L13
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearAdHeight()
    {
        fieldSetFlags()[1] = false;
        return this;
    }

    public fieldSetFlags clearAdWidth()
    {
        fieldSetFlags()[0] = false;
        return this;
    }

    public fieldSetFlags clearAlignment()
    {
        cY = null;
        fieldSetFlags()[4] = false;
        return this;
    }

    public fieldSetFlags clearFix()
    {
        cW = null;
        fieldSetFlags()[2] = false;
        return this;
    }

    public fieldSetFlags clearFormat()
    {
        cX = null;
        fieldSetFlags()[3] = false;
        return this;
    }

    public Integer getAdHeight()
    {
        return Integer.valueOf(cV);
    }

    public Integer getAdWidth()
    {
        return Integer.valueOf(cU);
    }

    public CharSequence getAlignment()
    {
        return cY;
    }

    public CharSequence getFix()
    {
        return cW;
    }

    public CharSequence getFormat()
    {
        return cX;
    }

    public boolean hasAdHeight()
    {
        return fieldSetFlags()[1];
    }

    public boolean hasAdWidth()
    {
        return fieldSetFlags()[0];
    }

    public boolean hasAlignment()
    {
        return fieldSetFlags()[4];
    }

    public boolean hasFix()
    {
        return fieldSetFlags()[2];
    }

    public boolean hasFormat()
    {
        return fieldSetFlags()[3];
    }

    public fieldSetFlags setAdHeight(int i)
    {
        validate(fields()[1], Integer.valueOf(i));
        cV = i;
        fieldSetFlags()[1] = true;
        return this;
    }

    public fieldSetFlags setAdWidth(int i)
    {
        validate(fields()[0], Integer.valueOf(i));
        cU = i;
        fieldSetFlags()[0] = true;
        return this;
    }

    public fieldSetFlags setAlignment(CharSequence charsequence)
    {
        validate(fields()[4], charsequence);
        cY = charsequence;
        fieldSetFlags()[4] = true;
        return this;
    }

    public fieldSetFlags setFix(CharSequence charsequence)
    {
        validate(fields()[2], charsequence);
        cW = charsequence;
        fieldSetFlags()[2] = true;
        return this;
    }

    public fieldSetFlags setFormat(CharSequence charsequence)
    {
        validate(fields()[3], charsequence);
        cX = charsequence;
        fieldSetFlags()[3] = true;
        return this;
    }

    private eption()
    {
        super(AdSpaceLayout.SCHEMA$);
    }
}
