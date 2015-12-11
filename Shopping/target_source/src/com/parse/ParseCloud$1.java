// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseCloud, ParseCloudCodeController

static final class 
    implements i
{

    final String val$name;
    final Map val$params;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        return ParseCloud.getCloudCodeController().callFunctionInBackground(val$name, val$params, j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    eController(String s, Map map)
    {
        val$name = s;
        val$params = map;
        super();
    }
}
