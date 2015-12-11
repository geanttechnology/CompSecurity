// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            GcmRegistrar, ParseInstallation, PushType

class on
    implements i
{

    final GcmRegistrar this$0;
    final ParseInstallation val$installation;

    public j then(j j1)
        throws Exception
    {
        if (!((Boolean)j1.e()).booleanValue())
        {
            return j.a(null);
        }
        if (val$installation.getPushType() != PushType.GCM)
        {
            val$installation.setPushType(PushType.GCM);
            j1 = val$installation.saveInBackground();
        } else
        {
            j1 = j.a(null);
        }
        j _tmp = GcmRegistrar.access$000(GcmRegistrar.this);
        return j1;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    on()
    {
        this$0 = final_gcmregistrar;
        val$installation = ParseInstallation.this;
        super();
    }
}
