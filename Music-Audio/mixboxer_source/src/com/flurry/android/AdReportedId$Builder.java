// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.android:
//            AdReportedId

public class ificRecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private ByteBuffer dW;
    private int type;

    public AdReportedId build()
    {
        AdReportedId adreportedid = new AdReportedId();
        if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
        int i = type;
_L3:
        ByteBuffer bytebuffer;
        adreportedid.type = i;
        if (!fieldSetFlags()[1])
        {
            break MISSING_BLOCK_LABEL_68;
        }
        bytebuffer = dW;
_L4:
        adreportedid.dW = bytebuffer;
        return adreportedid;
_L2:
        try
        {
            i = ((Integer)defaultValue(fields()[0])).intValue();
        }
        catch (Exception exception)
        {
            throw new AvroRuntimeException(exception);
        }
          goto _L3
        bytebuffer = (ByteBuffer)defaultValue(fields()[1]);
          goto _L4
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearId()
    {
        dW = null;
        fieldSetFlags()[1] = false;
        return this;
    }

    public fieldSetFlags clearType()
    {
        fieldSetFlags()[0] = false;
        return this;
    }

    public ByteBuffer getId()
    {
        return dW;
    }

    public Integer getType()
    {
        return Integer.valueOf(type);
    }

    public boolean hasId()
    {
        return fieldSetFlags()[1];
    }

    public boolean hasType()
    {
        return fieldSetFlags()[0];
    }

    public fieldSetFlags setId(ByteBuffer bytebuffer)
    {
        validate(fields()[1], bytebuffer);
        dW = bytebuffer;
        fieldSetFlags()[1] = true;
        return this;
    }

    public fieldSetFlags setType(int i)
    {
        validate(fields()[0], Integer.valueOf(i));
        type = i;
        fieldSetFlags()[0] = true;
        return this;
    }

    ception()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super(AdReportedId.SCHEMA$);
    }
}
