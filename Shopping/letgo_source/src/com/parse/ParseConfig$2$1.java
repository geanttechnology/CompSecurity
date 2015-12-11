// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseConfig, ParseConfigController

class val.sessionToken
    implements ct
{

    final then this$0;
    final String val$sessionToken;

    public cu then(cu cu)
        throws Exception
    {
        return ParseConfig.getConfigController().getAsync(val$sessionToken);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    l.toAwait()
    {
        this$0 = final_toawait;
        val$sessionToken = String.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseConfig$2

/* anonymous class */
    static final class ParseConfig._cls2
        implements ct
    {

        final cu val$toAwait;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (String)cu1.e();
            return toAwait.b(cu1. new ParseConfig._cls2._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                toAwait = cu1;
                super();
            }
    }

}
