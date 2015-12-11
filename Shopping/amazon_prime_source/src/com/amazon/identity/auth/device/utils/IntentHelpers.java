// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            CentralApkUtils

public final class IntentHelpers
{
    private static interface ReceiverQuerier
    {

        public abstract boolean existsReceiverThatRespondsToIntent(Context context, Intent intent);
    }


    private static final ReceiverQuerier ACTIVITY_QUERIER = new ReceiverQuerier() {

        public boolean existsReceiverThatRespondsToIntent(Context context, Intent intent)
        {
            boolean flag1 = false;
            context = context.getPackageManager().queryIntentActivities(intent, 0);
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

    };
    private static final ReceiverQuerier SERVICE_QUERIER = new ReceiverQuerier() {

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

    };

    public static Intent constructIntent$66a1abe0(String s, String s1)
    {
        Intent intent = new Intent();
        if (s1 != null)
        {
            intent.setClassName(s, s1);
        }
        return intent;
    }

    public static Intent getBestIntentForActivity$49025054(Context context, String s)
    {
        return getBestIntentForReceiver$c8035a8(context, ACTIVITY_QUERIER, s);
    }

    private static Intent getBestIntentForReceiver$c8035a8(Context context, ReceiverQuerier receiverquerier, String s)
    {
        Object obj = CentralApkUtils.getCentralApkInfo(context);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = getIntentIfItIsHandled(context, receiverquerier, constructIntent$66a1abe0(((CentralApkUtils.CentralApkDescription) (obj)).mPackageName, s));
        }
        if (obj != null)
        {
            return ((Intent) (obj));
        } else
        {
            return getIntentIfItIsHandled(context, receiverquerier, constructIntent$66a1abe0(context.getPackageName(), s));
        }
    }

    public static Intent getBestIntentForService$49025054(Context context, String s)
    {
        return getBestIntentForReceiver$c8035a8(context, SERVICE_QUERIER, s);
    }

    private static Intent getIntentIfItIsHandled(Context context, ReceiverQuerier receiverquerier, Intent intent)
    {
        if (receiverquerier.existsReceiverThatRespondsToIntent(context, intent))
        {
            return intent;
        } else
        {
            return null;
        }
    }

}
