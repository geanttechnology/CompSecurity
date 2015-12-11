// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineStore

class val.result
    implements i
{

    final val.result this$1;
    final JSONObject val$result;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public Void then(j j1)
        throws Exception
    {
        val$result.put("uuid", j1.e());
        return null;
    }

    ()
    {
        this$1 = final_;
        val$result = JSONObject.this;
        super();
    }
}
