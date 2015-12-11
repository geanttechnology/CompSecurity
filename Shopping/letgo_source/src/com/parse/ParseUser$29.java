// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser, ParseRESTUserCommand

class 
    implements ct
{

    final ParseUser this$0;
    final String val$sessionToken;

    public cu then(cu cu1)
        throws Exception
    {
        return ParseRESTUserCommand.upgradeRevocableSessionCommand(val$sessionToken).executeAsync().i();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    Command()
    {
        this$0 = final_parseuser;
        val$sessionToken = String.this;
        super();
    }
}
