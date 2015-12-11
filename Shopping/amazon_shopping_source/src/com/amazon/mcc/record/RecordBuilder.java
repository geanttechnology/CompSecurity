// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;


// Referenced classes of package com.amazon.mcc.record:
//            Record

public class RecordBuilder
{

    private Record record;

    RecordBuilder(String s, String s1)
    {
        record = new Record();
        record.setName(s);
        record.setType(s1);
    }

    public Record create()
    {
        return new Record(record);
    }

    public RecordBuilder with(String s, Object obj)
    {
        record.setProperty(s, obj);
        return this;
    }
}
