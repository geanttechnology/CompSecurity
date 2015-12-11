// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseConfig, ParseConfigController

class val.sessionToken
    implements i
{

    final then this$0;
    final String val$sessionToken;

    public j then(j j)
        throws Exception
    {
        return ParseConfig.getConfigController().getAsync(val$sessionToken);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
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
        implements i
    {

        final j val$toAwait;

        public j then(j j1)
            throws Exception
        {
            j1 = (String)j1.e();
            return toAwait.b(j1. new ParseConfig._cls2._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                toAwait = j1;
                super();
            }
    }

}
