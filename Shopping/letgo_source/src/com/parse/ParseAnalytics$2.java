// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseAnalytics, ParseAnalyticsController

static final class val.jsonDimensions
    implements ct
{

    final JSONObject val$jsonDimensions;
    final String val$name;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        return ParseAnalytics.getAnalyticsController().trackEventInBackground(val$name, val$jsonDimensions, cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    troller(String s, JSONObject jsonobject)
    {
        val$name = s;
        val$jsonDimensions = jsonobject;
        super();
    }
}
