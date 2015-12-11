// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseAuthenticationManager, ParseUser

class val.authType
    implements i
{

    final ParseAuthenticationManager this$0;
    final String val$authType;

    public j then(j j1)
        throws Exception
    {
        j1 = (ParseUser)j1.e();
        if (j1 != null)
        {
            return j1.synchronizeAuthDataAsync(val$authType);
        } else
        {
            return null;
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_parseauthenticationmanager;
        val$authType = String.this;
        super();
    }
}
