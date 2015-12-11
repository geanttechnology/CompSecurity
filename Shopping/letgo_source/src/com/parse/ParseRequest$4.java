// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseRequest, ParseHttpRequest

class t
    implements ct
{

    final ParseRequest this$0;
    final ParseHttpRequest val$request;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        val$request.cancel();
        return null;
    }

    t()
    {
        this$0 = final_parserequest;
        val$request = ParseHttpRequest.this;
        super();
    }
}
