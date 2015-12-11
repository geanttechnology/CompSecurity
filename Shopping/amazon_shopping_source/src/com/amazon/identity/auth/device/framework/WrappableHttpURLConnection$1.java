// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            WrappableHttpURLConnection

static class nnectionState
{

    static final int $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[];

    static 
    {
        $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState = new int[nnectionState.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[nnectionState.Initial.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[nnectionState.Connecting.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[nnectionState.Connected.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
