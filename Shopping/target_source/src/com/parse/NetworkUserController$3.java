// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            NetworkUserController, ParseRESTUserCommand, ParseDecoder, ParseObjectCoder

class val.command
    implements i
{

    final NetworkUserController this$0;
    final ParseRESTUserCommand val$command;

    public val.command then(j j1)
        throws Exception
    {
        boolean flag1 = true;
        j1 = (JSONObject)j1.e();
        boolean flag;
        if (val$command.getStatusCode() == 201)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag1 = false;
        }
        return ((StatusCode)((StatusCode)NetworkUserController.access$000(NetworkUserController.this).decode(new <init>(), j1, ParseDecoder.get())).isComplete(flag1)).isNew(flag).build();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_networkusercontroller;
        val$command = ParseRESTUserCommand.this;
        super();
    }
}
