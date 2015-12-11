// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            SdkLogRequest

public class ficRecordBuilderBase extends SpecificRecordBuilderBase
    implements RecordBuilder
{

    private List cR;
    private long cS;
    private CharSequence ch;
    private List ck;
    private boolean cm;

    public SdkLogRequest build()
    {
        SdkLogRequest sdklogrequest = new SdkLogRequest();
        if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
        Object obj = ch;
_L9:
        sdklogrequest.ch = ((CharSequence) (obj));
        if (!fieldSetFlags()[1]) goto _L4; else goto _L3
_L3:
        obj = ck;
_L10:
        sdklogrequest.ck = ((List) (obj));
        if (!fieldSetFlags()[2]) goto _L6; else goto _L5
_L5:
        obj = cR;
_L11:
        sdklogrequest.cR = ((List) (obj));
        if (!fieldSetFlags()[3]) goto _L8; else goto _L7
_L7:
        long l = cS;
_L12:
        boolean flag;
        sdklogrequest.cS = l;
        if (!fieldSetFlags()[4])
        {
            break MISSING_BLOCK_LABEL_178;
        }
        flag = cm;
_L13:
        sdklogrequest.cm = flag;
        return sdklogrequest;
_L2:
        try
        {
            obj = (CharSequence)defaultValue(fields()[0]);
        }
        catch (Exception exception)
        {
            throw new AvroRuntimeException(exception);
        }
          goto _L9
_L4:
        obj = (List)defaultValue(fields()[1]);
          goto _L10
_L6:
        obj = (List)defaultValue(fields()[2]);
          goto _L11
_L8:
        l = ((Long)defaultValue(fields()[3])).longValue();
          goto _L12
        flag = ((Boolean)defaultValue(fields()[4])).booleanValue();
          goto _L13
    }

    public volatile Object build()
    {
        return build();
    }

    public build clearAdReportedIds()
    {
        ck = null;
        fieldSetFlags()[1] = false;
        return this;
    }

    public fieldSetFlags clearAgentTimestamp()
    {
        fieldSetFlags()[3] = false;
        return this;
    }

    public fieldSetFlags clearApiKey()
    {
        ch = null;
        fieldSetFlags()[0] = false;
        return this;
    }

    public fieldSetFlags clearSdkAdLogs()
    {
        cR = null;
        fieldSetFlags()[2] = false;
        return this;
    }

    public fieldSetFlags clearTestDevice()
    {
        fieldSetFlags()[4] = false;
        return this;
    }

    public List getAdReportedIds()
    {
        return ck;
    }

    public Long getAgentTimestamp()
    {
        return Long.valueOf(cS);
    }

    public CharSequence getApiKey()
    {
        return ch;
    }

    public List getSdkAdLogs()
    {
        return cR;
    }

    public Boolean getTestDevice()
    {
        return Boolean.valueOf(cm);
    }

    public boolean hasAdReportedIds()
    {
        return fieldSetFlags()[1];
    }

    public boolean hasAgentTimestamp()
    {
        return fieldSetFlags()[3];
    }

    public boolean hasApiKey()
    {
        return fieldSetFlags()[0];
    }

    public boolean hasSdkAdLogs()
    {
        return fieldSetFlags()[2];
    }

    public boolean hasTestDevice()
    {
        return fieldSetFlags()[4];
    }

    public fieldSetFlags setAdReportedIds(List list)
    {
        validate(fields()[1], list);
        ck = list;
        fieldSetFlags()[1] = true;
        return this;
    }

    public fieldSetFlags setAgentTimestamp(long l)
    {
        validate(fields()[3], Long.valueOf(l));
        cS = l;
        fieldSetFlags()[3] = true;
        return this;
    }

    public fieldSetFlags setApiKey(CharSequence charsequence)
    {
        validate(fields()[0], charsequence);
        ch = charsequence;
        fieldSetFlags()[0] = true;
        return this;
    }

    public fieldSetFlags setSdkAdLogs(List list)
    {
        validate(fields()[2], list);
        cR = list;
        fieldSetFlags()[2] = true;
        return this;
    }

    public fieldSetFlags setTestDevice(boolean flag)
    {
        validate(fields()[4], Boolean.valueOf(flag));
        cm = flag;
        fieldSetFlags()[4] = true;
        return this;
    }

    eption()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super(SdkLogRequest.SCHEMA$);
    }
}
