// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseConfig, ParseConfigController, ParseDecoder, ParseCurrentConfigController

class val.config
    implements i
{

    final then this$1;
    final ParseConfig val$config;

    public ParseConfig then(j j)
        throws Exception
    {
        return val$config;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$config = ParseConfig.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseConfigController$1

/* anonymous class */
    class ParseConfigController._cls1
        implements i
    {

        final ParseConfigController this$0;

        public j then(j j1)
            throws Exception
        {
            j1 = new ParseConfig((JSONObject)j1.e(), ParseDecoder.get());
            return ParseConfigController.access$000(ParseConfigController.this).setCurrentConfigAsync(j1).a(j1. new ParseConfigController._cls1._cls1());
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
    }

}
