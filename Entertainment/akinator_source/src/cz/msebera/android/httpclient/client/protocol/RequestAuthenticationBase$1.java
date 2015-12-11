// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.auth.AuthProtocolState;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            RequestAuthenticationBase

static class 
{

    static final int $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[];

    static 
    {
        $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
