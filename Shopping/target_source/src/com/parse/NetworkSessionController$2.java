// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkSessionController, ParseDecoder, ParseObjectCoder

class this._cls0
    implements i
{

    final NetworkSessionController this$0;

    public this._cls0 then(j j1)
        throws Exception
    {
        j1 = (JSONObject)j1.e();
        return ((this._cls0)((this._cls0)NetworkSessionController.access$000(NetworkSessionController.this).decode(new init>("_Session"), j1, ParseDecoder.get())).sComplete(true)).uild();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = NetworkSessionController.this;
        super();
    }
}
