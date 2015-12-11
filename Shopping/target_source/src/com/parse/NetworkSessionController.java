// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseSessionController, ParseObjectCoder, ParseRESTSessionCommand, ParseHttpClient, 
//            ParseDecoder

class NetworkSessionController
    implements ParseSessionController
{

    private final ParseHttpClient client;
    private final ParseObjectCoder coder = ParseObjectCoder.get();

    public NetworkSessionController(ParseHttpClient parsehttpclient)
    {
        client = parsehttpclient;
    }

    public j getSessionAsync(String s)
    {
        return ParseRESTSessionCommand.getCurrentSessionCommand(s).executeAsync(client).c(new i() {

            final NetworkSessionController this$0;

            public ParseObject.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                return ((ParseObject.State.Builder)((ParseObject.State.Builder)coder.decode(new ParseObject.State.Builder("_Session"), j1, ParseDecoder.get())).isComplete(true)).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkSessionController.this;
                super();
            }
        });
    }

    public j revokeAsync(String s)
    {
        return ParseRESTSessionCommand.revoke(s).executeAsync(client).j();
    }

    public j upgradeToRevocable(String s)
    {
        return ParseRESTSessionCommand.upgradeToRevocableSessionCommand(s).executeAsync(client).c(new i() {

            final NetworkSessionController this$0;

            public ParseObject.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                return ((ParseObject.State.Builder)((ParseObject.State.Builder)coder.decode(new ParseObject.State.Builder("_Session"), j1, ParseDecoder.get())).isComplete(true)).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkSessionController.this;
                super();
            }
        });
    }

}
