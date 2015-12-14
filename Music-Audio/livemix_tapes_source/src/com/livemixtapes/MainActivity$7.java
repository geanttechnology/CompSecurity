// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gcm.GCMRegistrar;
import com.livemixtapes.library.JSONParser;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.livemixtapes:
//            MainActivity, GCMIntentService

class val.RegistrationId extends AsyncTask
{

    final MainActivity this$0;
    private final String val$RegistrationId;
    private final Context val$context;

    protected transient Boolean doInBackground(Void avoid[])
    {
        avoid = new ArrayList(3);
        String s = android.provider..getString(val$context.getContentResolver(), "android_id");
        JSONParser jsonparser = new JSONParser();
        avoid.add(new BasicNameValuePair("device_id", s));
        avoid.add(new BasicNameValuePair("device_token", val$RegistrationId));
        avoid.add(new BasicNameValuePair("device_description", (new StringBuilder(String.valueOf(GCMIntentService.getDeviceName()))).append(" - ").append(android.os.ELEASE).toString()));
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
            GCMRegistrar.setRegisteredOnServer(val$context, true);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    rar()
    {
        this$0 = final_mainactivity;
        val$context = context1;
        val$RegistrationId = String.this;
        super();
    }
}
