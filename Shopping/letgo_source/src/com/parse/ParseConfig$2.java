// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseConfig, ParseConfigController

static final class val.toAwait
    implements ct
{

    final cu val$toAwait;

    public cu then(final cu sessionToken)
        throws Exception
    {
        sessionToken = (String)sessionToken.e();
        return val$toAwait.b(new ct() {

            final ParseConfig._cls2 this$0;
            final String val$sessionToken;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseConfig.getConfigController().getAsync(sessionToken);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseConfig._cls2.this;
                sessionToken = s;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.val.sessionToken(cu cu1)
    {
        val$toAwait = cu1;
        super();
    }
}
