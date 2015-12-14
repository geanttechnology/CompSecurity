// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.socialin.android.util.b;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.log:
//            EventLoggingService, Attribute

public final class PanalyticsAgent extends Enum
{

    private static final PanalyticsAgent $VALUES[];
    public static final PanalyticsAgent INSTANCE;

    private PanalyticsAgent(String s, int i)
    {
        super(s, i);
    }

    public static PanalyticsAgent valueOf(String s)
    {
        return (PanalyticsAgent)Enum.valueOf(com/socialin/android/apiv3/log/PanalyticsAgent, s);
    }

    public static PanalyticsAgent[] values()
    {
        return (PanalyticsAgent[])$VALUES.clone();
    }

    public final void logAttribute(Context context, Attribute attribute)
    {
        Intent intent = new Intent(context, com/socialin/android/apiv3/log/EventLoggingService);
        intent.putExtra("attribute_name", attribute.getAttributeName());
        String s;
        if (TextUtils.isEmpty(attribute.getAttributeType()))
        {
            s = "$overwrite";
        } else
        {
            s = attribute.getAttributeType();
        }
        intent.putExtra("attribute_type", s);
        intent.putExtra("attribute_value", attribute.getAttributeValue().toString());
        context.startService(intent);
    }

    public final void logEvent(Context context, String s, String s1)
    {
        long l1;
        long l2;
        l2 = System.currentTimeMillis();
        l1 = l2;
        if (!"app_install".equals(s))
        {
            break MISSING_BLOCK_LABEL_102;
        }
        l1 = l2;
        long l = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        l1 = l;
        Intent intent;
        try
        {
            b.a(context).a("Date Installed PicsArt", l);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            l = l1;
        }
        intent = new Intent(context, com/socialin/android/apiv3/log/EventLoggingService);
        intent.putExtra("data", s1);
        intent.putExtra("timeStamp", l);
        intent.putExtra("event_id", s);
        context.startService(intent);
        return;
        l = l2;
        l1 = l2;
        if (!"app_update".equals(s))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        l1 = l2;
        l = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        break MISSING_BLOCK_LABEL_54;
    }

    public final void sendEvent(Context context, String s, String s1)
    {
        long l = System.currentTimeMillis();
        Intent intent = new Intent("picsart.contact.send.action");
        intent.putExtra("data", s1);
        intent.putExtra("timeStamp", l);
        intent.putExtra("event_id", s);
        context.sendBroadcast(intent);
    }

    static 
    {
        INSTANCE = new PanalyticsAgent("INSTANCE", 0);
        $VALUES = (new PanalyticsAgent[] {
            INSTANCE
        });
    }
}
