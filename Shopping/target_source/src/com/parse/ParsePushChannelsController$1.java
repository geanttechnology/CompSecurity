// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePushChannelsController, ParseInstallation

class val.channel
    implements i
{

    final ParsePushChannelsController this$0;
    final String val$channel;

    public j then(j j1)
        throws Exception
    {
        j1 = (ParseInstallation)j1.e();
        List list = j1.getList("channels");
        if (list == null || j1.isDirty("channels") || !list.contains(val$channel))
        {
            j1.addUnique("channels", val$channel);
            return j1.saveInBackground();
        } else
        {
            return j.a(null);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_parsepushchannelscontroller;
        val$channel = String.this;
        super();
    }
}
