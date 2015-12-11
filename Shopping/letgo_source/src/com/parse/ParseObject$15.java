// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class et
    implements ct
{

    final ParseObject this$0;
    final ParseOperationSet val$operationSet;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (JSONObject)cu1.e();
        return handleSaveEventuallyResultAsync(cu1, val$operationSet);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}
