// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.identity.snds.api:
//            SSOIntentFactory, SNDSClient

private static final class Q extends SSOIntentFactory
{

    public static Q findIsAccountLinkedService(Context context)
    {
        context = findSSOComponent(context, "com.amazon.identity.snds.SNDSLinkStatusService", SERVICE_FINDER);
        if (context == null)
        {
            return null;
        } else
        {
            return new <init>(context);
        }
    }

    public Intent buildIntentForService()
    {
        return buildIntent("com.amazon.dcp.snds.action.SNDS.link_status.get");
    }

    private Q(ComponentName componentname)
    {
        super(componentname);
    }
}
