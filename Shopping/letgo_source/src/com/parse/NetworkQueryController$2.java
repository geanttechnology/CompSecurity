// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkQueryController

class this._cls0
    implements ct
{

    final NetworkQueryController this$0;

    public Integer then(cu cu1)
        throws Exception
    {
        return Integer.valueOf(((JSONObject)cu1.e()).optInt("count"));
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = NetworkQueryController.this;
        super();
    }
}
