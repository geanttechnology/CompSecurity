// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.util.Log;
import com.b.a.a.g;
import com.b.a.a.j;
import com.omniata.android.sdk.Omniata;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.utils:
//            b, aw

public class av
{

    public av()
    {
    }

    public static void a(Context context)
    {
        String s1;
        String s2;
        JSONObject jsonobject;
        try
        {
            Omniata.initialize(context, "c221b4b5", b.a(context), "offerup");
            Omniata.trackLoad();
            Omniata.channel(32, new aw((byte)0));
        }
        catch (Exception exception)
        {
            g.a(context, exception);
        }
        try
        {
            String s = UAirship.shared().getPushManager().getGcmId();
            if (StringUtils.isNotEmpty(s))
            {
                Omniata.enablePushNotifications(s);
            }
        }
        catch (Exception exception1)
        {
            g.c(com/offerup/android/utils/av.getSimpleName(), Log.getStackTraceString(exception1));
        }
        try
        {
            s1 = UAirship.shared().getPushManager().getChannelId();
        }
        catch (Exception exception2)
        {
            g.a(context, exception2);
            exception2 = "";
        }
        s2 = j.a().l();
        jsonobject = new JSONObject();
        jsonobject.put("ou_ua_token", s1);
        if (StringUtils.isNotEmpty(s2))
        {
            jsonobject.put("ou_api_token", s2);
        }
        jsonobject.put("ou_push_enabled", 1);
        try
        {
            Omniata.trackLoad(jsonobject);
            return;
        }
        catch (Exception exception3)
        {
            try
            {
                g.a(context.getClass().getSimpleName(), "Exception logging Omniata data", exception3);
                return;
            }
            catch (Throwable throwable)
            {
                g.a(context, throwable);
            }
        }
        return;
    }

    public static void a(String s, JSONObject jsonobject)
    {
        try
        {
            Omniata.track(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(com/offerup/android/utils/av.getSimpleName(), "Exception logging Omniata data", s);
        }
    }
}
