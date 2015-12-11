// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider, ParseUser

class val.user
    implements ct
{

    final ParseAuthenticationProvider this$0;
    final ParseUser val$user;

    public cu then(cu cu1)
        throws Exception
    {
        return linkAsync(val$user, (Map)cu1.e());
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parseauthenticationprovider;
        val$user = ParseUser.this;
        super();
    }
}
