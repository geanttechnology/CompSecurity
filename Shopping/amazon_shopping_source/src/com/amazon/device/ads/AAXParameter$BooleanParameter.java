// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, DebugProperties

static class _cls9 extends AAXParameter
{

    protected Boolean getFromDebugProperties()
    {
        return DebugProperties.getDebugPropertyAsBoolean(getDebugName(), null);
    }

    protected volatile Object getFromDebugProperties()
    {
        return getFromDebugProperties();
    }

    protected Boolean parseFromString(String s)
    {
        return Boolean.valueOf(Boolean.parseBoolean(s));
    }

    protected volatile Object parseFromString(String s)
    {
        return parseFromString(s);
    }

    _cls9(String s, String s1)
    {
        super(s, s1);
    }
}
