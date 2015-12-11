// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            SdkLogResponse

public class icRecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private CharSequence fp;
    private List fq;

    public SdkLogResponse build()
    {
        SdkLogResponse sdklogresponse = new SdkLogResponse();
        if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
        Object obj = fp;
_L3:
        sdklogresponse.fp = ((CharSequence) (obj));
        if (!fieldSetFlags()[1])
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = fq;
_L4:
        sdklogresponse.fq = ((List) (obj));
        return sdklogresponse;
_L2:
        try
        {
            obj = (CharSequence)defaultValue(fields()[0]);
        }
        catch (Exception exception)
        {
            throw new AvroRuntimeException(exception);
        }
          goto _L3
        obj = (List)defaultValue(fields()[1]);
          goto _L4
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearErrors()
    {
        fq = null;
        fieldSetFlags()[1] = false;
        return this;
    }

    public fieldSetFlags clearResult()
    {
        fp = null;
        fieldSetFlags()[0] = false;
        return this;
    }

    public List getErrors()
    {
        return fq;
    }

    public CharSequence getResult()
    {
        return fp;
    }

    public boolean hasErrors()
    {
        return fieldSetFlags()[1];
    }

    public boolean hasResult()
    {
        return fieldSetFlags()[0];
    }

    public fieldSetFlags setErrors(List list)
    {
        validate(fields()[1], list);
        fq = list;
        fieldSetFlags()[1] = true;
        return this;
    }

    public fieldSetFlags setResult(CharSequence charsequence)
    {
        validate(fields()[0], charsequence);
        fp = charsequence;
        fieldSetFlags()[0] = true;
        return this;
    }

    private ption()
    {
        super(SdkLogResponse.SCHEMA$);
    }
}
