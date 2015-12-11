// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            GcmRegistrar, ParseInstallation, PushType

class on
    implements ct
{

    final GcmRegistrar this$0;
    final ParseInstallation val$installation;

    public cu then(cu cu1)
        throws Exception
    {
        if (!((Boolean)cu1.e()).booleanValue())
        {
            return cu.a(null);
        }
        if (val$installation.getPushType() != PushType.GCM)
        {
            val$installation.setPushType(PushType.GCM);
            cu1 = val$installation.saveInBackground();
        } else
        {
            cu1 = cu.a(null);
        }
        cu _tmp = GcmRegistrar.access$000(GcmRegistrar.this);
        return cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    on()
    {
        this$0 = final_gcmregistrar;
        val$installation = ParseInstallation.this;
        super();
    }
}
