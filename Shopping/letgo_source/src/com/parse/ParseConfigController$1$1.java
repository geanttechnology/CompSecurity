// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseConfig, ParseConfigController, ParseDecoder, ParseCurrentConfigController

class val.config
    implements ct
{

    final then this$1;
    final ParseConfig val$config;

    public ParseConfig then(cu cu)
        throws Exception
    {
        return val$config;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
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
        implements ct
    {

        final ParseConfigController this$0;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = new ParseConfig((JSONObject)cu1.e(), ParseDecoder.get());
            return ParseConfigController.access$000(ParseConfigController.this).setCurrentConfigAsync(cu1).a(cu1. new ParseConfigController._cls1._cls1());
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
    }

}
