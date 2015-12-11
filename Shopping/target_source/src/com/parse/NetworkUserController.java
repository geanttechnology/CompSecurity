// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUserController, ParseObjectCoder, ParseRESTUserCommand, ParseRESTCommand, 
//            PointerEncoder, ParseHttpClient, ParseOperationSet, ParseDecoder

class NetworkUserController
    implements ParseUserController
{

    private static final int STATUS_CODE_CREATED = 201;
    private final ParseHttpClient client;
    private final ParseObjectCoder coder;
    private final boolean revocableSession;

    public NetworkUserController(ParseHttpClient parsehttpclient)
    {
        this(parsehttpclient, false);
    }

    public NetworkUserController(ParseHttpClient parsehttpclient, boolean flag)
    {
        client = parsehttpclient;
        coder = ParseObjectCoder.get();
        revocableSession = flag;
    }

    public j getUserAsync(String s)
    {
        return ParseRESTUserCommand.getCurrentUserCommand(s).executeAsync(client).c(new i() {

            final NetworkUserController this$0;

            public ParseUser.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                return ((ParseUser.State.Builder)((ParseUser.State.Builder)coder.decode(new ParseUser.State.Builder(), j1, ParseDecoder.get())).isComplete(true)).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkUserController.this;
                super();
            }
        });
    }

    public j logInAsync(final ParseUser.State command, ParseOperationSet parseoperationset)
    {
        command = ParseRESTUserCommand.serviceLogInUserCommand(coder.encode(command, parseoperationset, PointerEncoder.get()), command.sessionToken(), revocableSession);
        return command.executeAsync(client).c(new i() {

            final NetworkUserController this$0;
            final ParseRESTUserCommand val$command;

            public ParseUser.State then(j j1)
                throws Exception
            {
                boolean flag1 = true;
                j1 = (JSONObject)j1.e();
                boolean flag;
                if (command.getStatusCode() == 201)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag1 = false;
                }
                return ((ParseUser.State.Builder)((ParseUser.State.Builder)coder.decode(new ParseUser.State.Builder(), j1, ParseDecoder.get())).isComplete(flag1)).isNew(flag).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkUserController.this;
                command = parserestusercommand;
                super();
            }
        });
    }

    public j logInAsync(String s, String s1)
    {
        return ParseRESTUserCommand.logInUserCommand(s, s1, revocableSession).executeAsync(client).c(new i() {

            final NetworkUserController this$0;

            public ParseUser.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                return ((ParseUser.State.Builder)((ParseUser.State.Builder)coder.decode(new ParseUser.State.Builder(), j1, ParseDecoder.get())).isComplete(true)).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkUserController.this;
                super();
            }
        });
    }

    public j logInAsync(final String authType, final Map authData)
    {
        final ParseRESTUserCommand command = ParseRESTUserCommand.serviceLogInUserCommand(authType, authData, revocableSession);
        return command.executeAsync(client).c(new i() {

            final NetworkUserController this$0;
            final Map val$authData;
            final String val$authType;
            final ParseRESTUserCommand val$command;

            public ParseUser.State then(j j1)
                throws Exception
            {
                boolean flag = true;
                j1 = (JSONObject)j1.e();
                j1 = (ParseUser.State.Builder)((ParseUser.State.Builder)coder.decode(new ParseUser.State.Builder(), j1, ParseDecoder.get())).isComplete(true);
                if (command.getStatusCode() != 201)
                {
                    flag = false;
                }
                return j1.isNew(flag).putAuthData(authType, authData).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkUserController.this;
                command = parserestusercommand;
                authType = s;
                authData = map;
                super();
            }
        });
    }

    public j requestPasswordResetAsync(String s)
    {
        return ParseRESTUserCommand.resetPasswordResetCommand(s).executeAsync(client).j();
    }

    public j signUpAsync(ParseObject.State state, ParseOperationSet parseoperationset, String s)
    {
        return ParseRESTUserCommand.signUpUserCommand(coder.encode(state, parseoperationset, PointerEncoder.get()), s, revocableSession).executeAsync(client).c(new i() {

            final NetworkUserController this$0;

            public ParseUser.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                return ((ParseUser.State.Builder)((ParseUser.State.Builder)coder.decode(new ParseUser.State.Builder(), j1, ParseDecoder.get())).isComplete(false)).isNew(true).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkUserController.this;
                super();
            }
        });
    }

}
