// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, DebugProperties

static class  extends AAXParameter
{

    protected Long getFromDebugProperties()
    {
        return DebugProperties.getDebugPropertyAsLong(getDebugName(), null);
    }

    protected volatile Object getFromDebugProperties()
    {
        return getFromDebugProperties();
    }

    protected Long parseFromString(String s)
    {
        return Long.valueOf(Long.parseLong(s));
    }

    protected volatile Object parseFromString(String s)
    {
        return parseFromString(s);
    }

    (String s, String s1)
    {
        super(s, s1);
    }
}
