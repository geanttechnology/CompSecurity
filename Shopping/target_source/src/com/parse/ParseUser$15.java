// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements i
{

    final ParseUser this$0;
    final Map val$authData;
    final String val$authType;
    final String val$sessionToken;

    public j then(j j)
        throws Exception
    {
        return ParseUser.access$700(ParseUser.this, val$authType, val$authData, j, val$sessionToken);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ()
    {
        this$0 = final_parseuser;
        val$authType = s;
        val$authData = map;
        val$sessionToken = String.this;
        super();
    }
}
