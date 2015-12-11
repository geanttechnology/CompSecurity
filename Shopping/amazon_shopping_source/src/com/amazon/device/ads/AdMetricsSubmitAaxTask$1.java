// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdMetricsSubmitAaxTask

static class us
{

    static final int $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[];

    static 
    {
        $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus = new int[us.values().length];
        try
        {
            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[us.INVALID_CLIENT_PROTOCOL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[us.NETWORK_FAILURE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[us.MALFORMED_URL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[us.UNSUPPORTED_ENCODING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
