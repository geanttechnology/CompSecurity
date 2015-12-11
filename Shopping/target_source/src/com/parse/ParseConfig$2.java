// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseConfig, ParseConfigController

static final class val.toAwait
    implements i
{

    final j val$toAwait;

    public j then(final j sessionToken)
        throws Exception
    {
        sessionToken = (String)sessionToken.e();
        return val$toAwait.b(new i() {

            final ParseConfig._cls2 this$0;
            final String val$sessionToken;

            public j then(j j1)
                throws Exception
            {
                return ParseConfig.getConfigController().getAsync(sessionToken);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseConfig._cls2.this;
                sessionToken = s;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.sessionToken(j j1)
    {
        val$toAwait = j1;
        super();
    }
}
