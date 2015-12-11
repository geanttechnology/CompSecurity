// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkObjectController, ParseObjectCoder, ParseDecoder

class val.decoder
    implements i
{

    final NetworkObjectController this$0;
    final ParseDecoder val$decoder;
    final then val$state;

    public val.decoder then(j j1)
        throws Exception
    {
        j1 = (JSONObject)j1.e();
        val.decoder decoder1 = val$state.er().ar();
        return NetworkObjectController.access$000(NetworkObjectController.this).decode(decoder1, j1, val$decoder).omplete(false).ld();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_networkobjectcontroller;
        val$state = ;
        val$decoder = ParseDecoder.this;
        super();
    }
}
