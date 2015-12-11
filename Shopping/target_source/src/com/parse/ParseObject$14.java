// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class et
    implements i
{

    final ParseObject this$0;
    final ParseOperationSet val$operationSet;

    public j then(j j1)
        throws Exception
    {
        j1 = (JSONObject)j1.e();
        return handleSaveEventuallyResultAsync(j1, val$operationSet);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}
