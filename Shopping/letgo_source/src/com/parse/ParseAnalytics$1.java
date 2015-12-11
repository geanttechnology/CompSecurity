// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseAnalytics, ParseAnalyticsController

static final class val.pushHash
    implements ct
{

    final cs val$pushHash;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        return ParseAnalytics.getAnalyticsController().trackAppOpenedInBackground((String)val$pushHash.a(), cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    troller(cs cs1)
    {
        val$pushHash = cs1;
        super();
    }
}
