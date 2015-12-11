// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkObjectController, ParseDecoder

class val.decoder
    implements ct
{

    final NetworkObjectController this$0;
    final ParseDecoder val$decoder;
    final then val$state;

    public val.decoder then(cu cu1)
        throws Exception
    {
        cu1 = (JSONObject)cu1.e();
        return stateFromJSON(val$state, cu1, val$decoder, true);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_networkobjectcontroller;
        val$state = ;
        val$decoder = ParseDecoder.this;
        super();
    }
}
