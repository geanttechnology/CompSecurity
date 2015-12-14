// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            DetEndpointConfig, Domain

static class 
{

    static final int $SwitchMap$com$amazon$device$crashmanager$Domain[];

    static 
    {
        $SwitchMap$com$amazon$device$crashmanager$Domain = new int[Domain.values().length];
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$Domain[Domain.PROD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$Domain[Domain.BETA.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
