// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkQueryController

class this._cls0
    implements i
{

    final NetworkQueryController this$0;

    public Integer then(j j1)
        throws Exception
    {
        return Integer.valueOf(((JSONObject)j1.e()).optInt("count"));
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = NetworkQueryController.this;
        super();
    }
}
