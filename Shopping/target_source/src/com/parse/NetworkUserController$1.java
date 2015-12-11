// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkUserController, ParseDecoder, ParseObjectCoder

class this._cls0
    implements i
{

    final NetworkUserController this$0;

    public this._cls0 then(j j1)
        throws Exception
    {
        j1 = (JSONObject)j1.e();
        return ((this._cls0)((this._cls0)NetworkUserController.access$000(NetworkUserController.this).decode(new <init>(), j1, ParseDecoder.get())).isComplete(false)).isNew(true).build();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = NetworkUserController.this;
        super();
    }
}
