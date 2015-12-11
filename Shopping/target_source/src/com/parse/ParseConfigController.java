// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTConfigCommand, ParseRESTCommand, ParseCurrentConfigController, ParseHttpClient, 
//            ParseConfig, ParseDecoder

class ParseConfigController
{

    private ParseCurrentConfigController currentConfigController;
    private final ParseHttpClient restClient;

    public ParseConfigController(ParseHttpClient parsehttpclient, ParseCurrentConfigController parsecurrentconfigcontroller)
    {
        restClient = parsehttpclient;
        currentConfigController = parsecurrentconfigcontroller;
    }

    public j getAsync(String s)
    {
        s = ParseRESTConfigCommand.fetchConfigCommand(s);
        s.enableRetrying();
        return s.executeAsync(restClient).d(new i() {

            final ParseConfigController this$0;

            public j then(j j1)
                throws Exception
            {
                j1 = new ParseConfig((JSONObject)j1.e(), ParseDecoder.get());
                return currentConfigController.setCurrentConfigAsync(j1).a(j1. new i() {

                    final _cls1 this$1;
                    final ParseConfig val$config;

                    public ParseConfig then(j j1)
                        throws Exception
                    {
                        return config;
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = final__pcls1;
                config = ParseConfig.this;
                super();
            }
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseConfigController.this;
                super();
            }
        });
    }

    ParseCurrentConfigController getCurrentConfigController()
    {
        return currentConfigController;
    }

}
