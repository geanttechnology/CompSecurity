// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkUserController, ParseDecoder, ParseObjectCoder, ParseRESTUserCommand

class val.authData
    implements i
{

    final NetworkUserController this$0;
    final Map val$authData;
    final String val$authType;
    final ParseRESTUserCommand val$command;

    public val.authData then(j j1)
        throws Exception
    {
        boolean flag = true;
        j1 = (JSONObject)j1.e();
        j1 = (val.authData)((val.authData)NetworkUserController.access$000(NetworkUserController.this).decode(new <init>(), j1, ParseDecoder.get())).isComplete(true);
        if (val$command.getStatusCode() != 201)
        {
            flag = false;
        }
        return j1.isNew(flag).putAuthData(val$authType, val$authData).build();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_networkusercontroller;
        val$command = parserestusercommand;
        val$authType = s;
        val$authData = Map.this;
        super();
    }
}
