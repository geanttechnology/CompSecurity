// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseCloud, ParseCloudCodeController

static final class 
    implements ct
{

    final String val$name;
    final Map val$params;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        return ParseCloud.getCloudCodeController().callFunctionInBackground(val$name, val$params, cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    eController(String s, Map map)
    {
        val$name = s;
        val$params = map;
        super();
    }
}
