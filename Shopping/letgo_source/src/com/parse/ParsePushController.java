// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseRESTPushCommand, ParseRESTCommand, ParseHttpClient

class ParsePushController
{

    static final String DEVICE_TYPE_ANDROID = "android";
    static final String DEVICE_TYPE_IOS = "ios";
    private final ParseHttpClient restClient;

    public ParsePushController(ParseHttpClient parsehttpclient)
    {
        restClient = parsehttpclient;
    }

    ParseRESTCommand buildRESTSendPushCommand(ParsePush.State state, String s)
    {
        boolean flag1 = true;
        if (state.queryState() != null) goto _L2; else goto _L1
_L1:
        String s1;
        boolean flag;
        if (state.pushToAndroid() != null && state.pushToAndroid().booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (state.pushToIOS() == null || !state.pushToIOS().booleanValue())
        {
            flag1 = false;
        }
        if (!flag1 || !flag) goto _L4; else goto _L3
_L3:
        s1 = null;
_L6:
        return ParseRESTPushCommand.sendPushCommand(state.queryState(), state.channelSet(), s1, state.expirationTime(), state.expirationTimeInterval(), state.data(), s);
_L4:
        if (flag1)
        {
            s1 = "ios";
            continue; /* Loop/switch isn't completed */
        }
        if (flag)
        {
            s1 = "android";
            continue; /* Loop/switch isn't completed */
        }
_L2:
        s1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public cu sendInBackground(ParsePush.State state, String s)
    {
        return buildRESTSendPushCommand(state, s).executeAsync(restClient).j();
    }
}
