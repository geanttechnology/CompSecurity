// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;


// Referenced classes of package com.exacttarget.etpushsdk.data:
//            Region, Message

public class RegionMessage
{

    private Integer a;
    private Region b;
    private Message c;

    public RegionMessage()
    {
    }

    public RegionMessage(Region region, Message message)
    {
        b = region;
        c = message;
    }

    public Integer getId()
    {
        return a;
    }

    public Message getMessage()
    {
        return c;
    }

    public Region getRegion()
    {
        return b;
    }

    public void setId(Integer integer)
    {
        a = integer;
    }

    public void setMessage(Message message)
    {
        c = message;
    }

    public void setRegion(Region region)
    {
        b = region;
    }
}
