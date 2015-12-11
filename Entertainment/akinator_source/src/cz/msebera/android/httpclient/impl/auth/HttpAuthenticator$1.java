// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.auth.AuthProtocolState;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            HttpAuthenticator

static class A
{

    static final int $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[];

    static 
    {
        $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.HANDSHAKE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.UNCHALLENGED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
