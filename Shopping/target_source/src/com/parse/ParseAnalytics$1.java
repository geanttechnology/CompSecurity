// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseAnalytics, ParseAnalyticsController

static final class val.pushHash
    implements i
{

    final h val$pushHash;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        return ParseAnalytics.getAnalyticsController().trackAppOpenedInBackground((String)val$pushHash.a(), j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    troller(h h1)
    {
        val$pushHash = h1;
        super();
    }
}
