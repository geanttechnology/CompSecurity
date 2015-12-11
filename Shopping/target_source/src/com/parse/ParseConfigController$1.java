// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseConfigController, ParseConfig, ParseDecoder, ParseCurrentConfigController

class this._cls0
    implements i
{

    final ParseConfigController this$0;

    public j then(final j config)
        throws Exception
    {
        config = new ParseConfig((JSONObject)config.e(), ParseDecoder.get());
        return ParseConfigController.access$000(ParseConfigController.this).setCurrentConfigAsync(config).a(new i() {

            final ParseConfigController._cls1 this$1;
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
                this$1 = ParseConfigController._cls1.this;
                config = parseconfig;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.config()
    {
        this$0 = ParseConfigController.this;
        super();
    }
}
