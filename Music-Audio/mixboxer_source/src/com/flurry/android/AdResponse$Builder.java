// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            AdResponse

public class ecificRecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private List fq;
    private List gk;

    public AdResponse build()
    {
        AdResponse adresponse = new AdResponse();
        if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
        List list = gk;
_L3:
        adresponse.gk = list;
        if (!fieldSetFlags()[1])
        {
            break MISSING_BLOCK_LABEL_65;
        }
        list = fq;
_L4:
        adresponse.fq = list;
        return adresponse;
_L2:
        try
        {
            list = (List)defaultValue(fields()[0]);
        }
        catch (Exception exception)
        {
            throw new AvroRuntimeException(exception);
        }
          goto _L3
        list = (List)defaultValue(fields()[1]);
          goto _L4
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearAdUnits()
    {
        gk = null;
        fieldSetFlags()[0] = false;
        return this;
    }

    public fieldSetFlags clearErrors()
    {
        fq = null;
        fieldSetFlags()[1] = false;
        return this;
    }

    public List getAdUnits()
    {
        return gk;
    }

    public List getErrors()
    {
        return fq;
    }

    public boolean hasAdUnits()
    {
        return fieldSetFlags()[0];
    }

    public boolean hasErrors()
    {
        return fieldSetFlags()[1];
    }

    public fieldSetFlags setAdUnits(List list)
    {
        validate(fields()[0], list);
        gk = list;
        fieldSetFlags()[0] = true;
        return this;
    }

    public fieldSetFlags setErrors(List list)
    {
        validate(fields()[1], list);
        fq = list;
        fieldSetFlags()[1] = true;
        return this;
    }

    private Exception()
    {
        super(AdResponse.SCHEMA$);
    }
}
