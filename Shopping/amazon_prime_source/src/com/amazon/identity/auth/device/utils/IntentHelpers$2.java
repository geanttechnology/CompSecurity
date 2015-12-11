// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            IntentHelpers

static final class ceiverQuerier
    implements ceiverQuerier
{

    public boolean existsReceiverThatRespondsToIntent(Context context, Intent intent)
    {
        boolean flag1 = false;
        context = context.getPackageManager().queryIntentServices(intent, 0);
        boolean flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (context.size() > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    ceiverQuerier()
    {
    }
}
