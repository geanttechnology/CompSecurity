// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements ct
{

    final ParseUser this$0;
    final String val$sessionToken;
    final cu val$toAwait;

    public cu then(cu cu)
        throws Exception
    {
        return saveAsync(val$sessionToken, val$toAwait);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    ()
    {
        this$0 = final_parseuser;
        val$sessionToken = s;
        val$toAwait = cu.this;
        super();
    }
}
