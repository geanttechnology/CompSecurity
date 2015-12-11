// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.provider;


// Referenced classes of package com.comcast.cim.cmasl.utils.provider:
//            Provider

public class StringProvider
    implements Provider
{

    private final String string;

    public volatile Object get()
    {
        return get();
    }

    public String get()
    {
        return string;
    }
}
