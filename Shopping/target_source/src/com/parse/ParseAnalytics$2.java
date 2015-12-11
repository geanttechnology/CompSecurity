// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseAnalytics, ParseAnalyticsController

static final class val.jsonDimensions
    implements i
{

    final JSONObject val$jsonDimensions;
    final String val$name;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        return ParseAnalytics.getAnalyticsController().trackEventInBackground(val$name, val$jsonDimensions, j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    troller(String s, JSONObject jsonobject)
    {
        val$name = s;
        val$jsonDimensions = jsonobject;
        super();
    }
}
