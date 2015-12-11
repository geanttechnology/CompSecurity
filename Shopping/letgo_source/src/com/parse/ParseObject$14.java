// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder, ParseObjectController, ParseOperationSet

class val.sessionToken
    implements ct
{

    final ParseObject this$0;
    final ParseOperationSet val$operations;
    final String val$sessionToken;

    public cu then(cu cu)
        throws Exception
    {
        cu = new KnownParseObjectDecoder(ParseObject.access$800(ParseObject.this));
        return ParseObject.access$900().saveAsync(getState(), val$operations, val$sessionToken, cu);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operations = parseoperationset;
        val$sessionToken = String.this;
        super();
    }
}
