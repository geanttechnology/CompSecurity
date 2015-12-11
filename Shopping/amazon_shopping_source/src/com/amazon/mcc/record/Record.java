// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mcc.record:
//            Recordable, RecordBuilder

public class Record
    implements Recordable
{

    private final Map properties;

    Record()
    {
        properties = new HashMap();
    }

    protected Record(Recordable recordable)
    {
        properties = new HashMap();
        properties.putAll(recordable.getProperties());
    }

    public Record(String s)
    {
        this();
        setName(s);
        setType("Simple");
    }

    public Record(String s, long l, TimeUnit timeunit)
    {
        this();
        setName(s);
        setType("Duration");
        setValue(Long.valueOf(l));
        properties.put("TimeUnit", timeunit);
    }

    public Record(String s, String s1)
    {
        this();
        setName(s);
        setType("Message");
        properties.put("MessageContents", s1);
    }

    public static RecordBuilder build(String s, String s1)
    {
        return new RecordBuilder(s, s1);
    }

    private void setValue(Number number)
    {
        properties.put("Value", number);
    }

    public Map getProperties()
    {
        return Collections.unmodifiableMap(properties);
    }

    void setName(String s)
    {
        properties.put("Name", s);
    }

    protected void setProperty(String s, Object obj)
    {
        properties.put(s, obj);
    }

    protected void setType(String s)
    {
        properties.put("RecordType", s);
    }
}
