// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import com.livemixtapes.library.JSONParser;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.livemixtapes:
//            MainActivity, User

public class GCMIntentService extends GCMBaseIntentService
{

    public static final String DISPLAY_MESSAGE_ACTION = "com.livemixtapes.DISPLAY_MESSAGE";
    public static final String EXTRA_MESSAGE = "message";
    public static final String SENDER_ID = "663004151835";
    private static final String TAG = "LiveMixTapes";
    Context ctx;
    AsyncTask mRegisterTask;

    public GCMIntentService()
    {
        super(new String[] {
            "663004151835"
        });
    }

    private static String capitalize(String s)
    {
        String s1;
        if (s == null || s.length() == 0)
        {
            s1 = "";
        } else
        {
            char c = s.charAt(0);
            s1 = s;
            if (!Character.isUpperCase(c))
            {
                return (new StringBuilder(String.valueOf(Character.toUpperCase(c)))).append(s.substring(1)).toString();
            }
        }
        return s1;
    }

    private static void generateNotification(Context context, String s, String s1)
    {
        long l = System.currentTimeMillis();
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        Notification notification = new Notification(0x7f02005b, s, l);
        String s2 = context.getString(0x7f0a003a);
        Intent intent = new Intent(context, com/livemixtapes/MainActivity);
        intent.putExtra("message", s);
        if (s1 != null && s1.length() > 0)
        {
            intent.putExtra("mixtapeId", s1);
        }
        intent.setFlags(0x24000000);
        s1 = PendingIntent.getActivity(context, 0, intent, 0x8000000);
        notification.setLatestEventInfo(context, (new StringBuilder(String.valueOf(s2))).append(" sent you a message").toString(), s, s1);
        notification.defaults = -1;
        notification.flags = notification.flags | 0x10;
        notificationmanager.notify(0, notification);
    }

    public static String getDeviceName()
    {
        String s = Build.MANUFACTURER;
        String s1 = Build.MODEL;
        if (s1.startsWith(s))
        {
            return capitalize(s1);
        } else
        {
            return (new StringBuilder(String.valueOf(capitalize(s)))).append(" ").append(s1).toString();
        }
    }

    protected void onDeletedMessages(Context context, int i)
    {
        Log.i("LiveMixTapes", "Received deleted messages notification");
    }

    public void onError(Context context, String s)
    {
        Log.i("LiveMixTapes", (new StringBuilder("Received error: ")).append(s).toString());
    }

    protected void onMessage(Context context, Intent intent)
    {
        Log.i("LiveMixTapes", "Received message");
        Log.d("Nithin", (new StringBuilder("YYY")).append(intent.getExtras().getString("message")).toString());
        ctx = context;
        generateNotification(context, intent.getExtras().getString("message"), intent.getExtras().getString("mixtape_id"));
    }

    protected boolean onRecoverableError(Context context, String s)
    {
        Log.i("LiveMixTapes", (new StringBuilder("Received recoverable error: ")).append(s).toString());
        return super.onRecoverableError(context, s);
    }

    protected void onRegistered(final Context context, final String registrationId)
    {
        Log.i("LiveMixTapes", (new StringBuilder("Device registered: regId = ")).append(registrationId).toString());
        mRegisterTask = new AsyncTask() {

            final GCMIntentService this$0;
            private final Context val$context;
            private final String val$registrationId;

            protected transient Boolean doInBackground(Void avoid[])
            {
                avoid = new ArrayList(3);
                String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                JSONParser jsonparser = new JSONParser();
                avoid.add(new BasicNameValuePair("auth", User.getAuth()));
                avoid.add(new BasicNameValuePair("device_id", s));
                avoid.add(new BasicNameValuePair("device_token", registrationId));
                avoid.add(new BasicNameValuePair("device_description", (new StringBuilder(String.valueOf(GCMIntentService.getDeviceName()))).append(" - ").append(android.os.Build.VERSION.RELEASE).toString()));
                return Boolean.valueOf(jsonparser.isSuccessfulRequest(jsonparser.postData("https://api.livemixtapes.com/api/user/android_push", avoid)));
            }

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Boolean boolean1)
            {
                mRegisterTask = null;
                if (boolean1.booleanValue())
                {
                    GCMRegistrar.setRegisteredOnServer(context, true);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Boolean)obj);
            }

            
            {
                this$0 = GCMIntentService.this;
                context = context1;
                registrationId = s;
                super();
            }
        };
        mRegisterTask.execute(new Void[] {
            null, null, null
        });
    }

    protected void onUnregistered(Context context, String s)
    {
        Log.i("LiveMixTapes", "Device unregistered");
    }
}
