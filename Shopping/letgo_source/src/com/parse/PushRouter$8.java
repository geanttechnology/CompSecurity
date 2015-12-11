// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements ct
{

    final JSONObject val$pushPayload;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
    {
        if (val$pushPayload != null)
        {
            PushRouter.access$000().handlePpnsPush(val$pushPayload);
        }
        return null;
    }

    (JSONObject jsonobject)
    {
        val$pushPayload = jsonobject;
        super();
    }
}
