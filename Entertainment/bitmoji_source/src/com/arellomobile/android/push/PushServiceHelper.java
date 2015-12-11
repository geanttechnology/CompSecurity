// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.arellomobile.android.push.utils.GeneralUtils;
import com.arellomobile.android.push.utils.PreferenceUtils;
import com.arellomobile.android.push.utils.notification.BannerNotificationFactory;
import com.arellomobile.android.push.utils.notification.BaseNotificationFactory;
import com.arellomobile.android.push.utils.notification.SimpleNotificationFactory;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push:
//            DeviceFeature2_5, PushHandlerActivity

public class PushServiceHelper
{

    public PushServiceHelper()
    {
    }

    public static void generateBroadcast(Context context, Bundle bundle)
    {
        Intent intent;
        JSONObject jsonobject;
        Iterator iterator;
        intent = new Intent();
        intent.setAction((new StringBuilder()).append(context.getPackageName()).append(".action.PUSH_MESSAGE_RECEIVE").toString());
        intent.putExtras(bundle);
        jsonobject = new JSONObject();
        iterator = bundle.keySet().iterator();
_L9:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (!s.equals("u")) goto _L4; else goto _L3
_L3:
        Object obj1 = bundle.get("u");
        if (obj1 == null) goto _L4; else goto _L5
_L5:
        if (!(obj1 instanceof String)) goto _L4; else goto _L6
_L6:
        if (!((String)obj1).startsWith("{")) goto _L8; else goto _L7
_L7:
        Object obj = new JSONObject((String)obj1);
_L11:
        jsonobject.put("userdata", obj);
_L4:
        try
        {
            jsonobject.put(s, bundle.get(s));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L9
_L8:
        obj = obj1;
        if (!((String)obj1).startsWith("[")) goto _L11; else goto _L10
_L10:
        obj = new JSONArray((String)obj1);
          goto _L11
_L2:
        intent.putExtra("pw_data_json_string", jsonobject.toString());
        if (GeneralUtils.isAmazonDevice())
        {
            context.sendBroadcast(intent, (new StringBuilder()).append(context.getPackageName()).append(".permission.RECEIVE_ADM_MESSAGE").toString());
            return;
        } else
        {
            context.sendBroadcast(intent, (new StringBuilder()).append(context.getPackageName()).append(".permission.C2D_MESSAGE").toString());
            return;
        }
        JSONException jsonexception;
        jsonexception;
          goto _L4
    }

    public static void generateNotification(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            bundle.putBoolean("foreground", GeneralUtils.isAppOnForeground(context));
            Object obj;
            NotificationManager notificationmanager;
            String s;
            String s1;
            int i;
            int j;
            boolean flag;
            if (!GeneralUtils.isAppOnForeground(context))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bundle.putBoolean("onStart", flag);
            s = (String)bundle.get("title");
            obj = (String)bundle.get("header");
            intent = (String)bundle.get("l");
            if (intent != null)
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(intent));
                intent.addFlags(0x10000000);
            } else
            {
                intent = new Intent(context, com/arellomobile/android/push/PushHandlerActivity);
                intent.addFlags(0x24000000);
                intent.putExtra("pushBundle", bundle);
            }
            if (obj == null)
            {
                CharSequence charsequence = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
                obj = charsequence;
                if (charsequence == null)
                {
                    obj = "";
                }
                obj = obj.toString();
            }
            notificationmanager = (NotificationManager)context.getSystemService("notification");
            s1 = (String)bundle.get("b");
            if (context.getResources().getIdentifier("notification", "layout", context.getPackageName()) != 0 && s1 != null)
            {
                obj = new BannerNotificationFactory(context, bundle, ((String) (obj)), s, PreferenceUtils.getSoundType(context), PreferenceUtils.getVibrateType(context));
            } else
            {
                obj = new SimpleNotificationFactory(context, bundle, ((String) (obj)), s, PreferenceUtils.getSoundType(context), PreferenceUtils.getVibrateType(context));
            }
            ((BaseNotificationFactory) (obj)).generateNotification();
            ((BaseNotificationFactory) (obj)).addSoundAndVibrate();
            ((BaseNotificationFactory) (obj)).addCancel();
            if (PreferenceUtils.getEnableLED(context))
            {
                ((BaseNotificationFactory) (obj)).addLED(true);
            }
            obj = ((BaseNotificationFactory) (obj)).getNotification();
            j = PreferenceUtils.getMessageId(context);
            i = j;
            if (PreferenceUtils.getMultiMode(context))
            {
                i = j + 1;
                PreferenceUtils.setMessageId(context, i);
            }
            obj.contentIntent = PendingIntent.getActivity(context, i, intent, 0x10000000);
            if (!bundle.getBoolean("silent", false))
            {
                notificationmanager.notify(i, ((Notification) (obj)));
            }
            generateBroadcast(context, bundle);
            if (!bundle.getBoolean("local", false))
            {
                try
                {
                    DeviceFeature2_5.sendMessageDeliveryEvent(context, bundle.getString("p"));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
            }
        }
    }

    public static String getPushServiceClassName(Context context)
    {
        context = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
        if (((ApplicationInfo) (context)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        context = ((ApplicationInfo) (context)).metaData.getString("PW_PUSH_SERVICE");
        if (context != null)
        {
            return context;
        }
        break MISSING_BLOCK_LABEL_43;
        context;
        return "com.arellomobile.android.push.PushGCMIntentService";
    }
}
