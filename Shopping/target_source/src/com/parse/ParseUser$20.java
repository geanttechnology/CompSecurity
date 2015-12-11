// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, ParseSession

class 
    implements i
{

    final ParseUser this$0;
    final String val$sessionToken;

    public j then(j j)
        throws Exception
    {
        return ParseSession.upgradeToRevocableSessionAsync(val$sessionToken);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ()
    {
        this$0 = final_parseuser;
        val$sessionToken = String.this;
        super();
    }
}
