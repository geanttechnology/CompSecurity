// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
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

    public cu getAsync(String s)
    {
        s = ParseRESTConfigCommand.fetchConfigCommand(s);
        s.enableRetrying();
        return s.executeAsync(restClient).d(new ct() {

            final ParseConfigController this$0;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = new ParseConfig((JSONObject)cu1.e(), ParseDecoder.get());
                return currentConfigController.setCurrentConfigAsync(cu1).a(cu1. new ct() {

                    final _cls1 this$1;
                    final ParseConfig val$config;

                    public ParseConfig then(cu cu1)
                        throws Exception
                    {
                        return config;
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls1;
                config = ParseConfig.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
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
