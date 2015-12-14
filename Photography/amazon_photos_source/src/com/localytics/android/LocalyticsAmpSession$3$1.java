// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.IOException;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.localytics.android:
//            LocalyticsProvider, SessionHandler, LocalyticsAmpSession, DatapointHelper

class this._cls1
    implements Runnable
{

    final  this$1;

    public void run()
    {
        Object obj;
        String s;
        obj = null;
        s = null;
        Object obj1 = provider.query("info", null, null, null, null);
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        obj = obj1;
        s = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("registration_id"));
        Object obj2;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        obj = SessionHandler.getInstallationId(provider, apiKey);
        obj1 = (String)provider.getUserIdAndType().get("id");
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj2 = String.format("http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s", new Object[] {
            campaign, creative, s, obj
        });
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        obj2 = new HttpGet(((String) (obj2)));
        ((HttpGet) (obj2)).addHeader("x-install-id", ((String) (obj)));
        ((HttpGet) (obj2)).addHeader("x-app-id", apiKey);
        ((HttpGet) (obj2)).addHeader("x-client-version", "androida_2.70");
        ((HttpGet) (obj2)).addHeader("x-app-version", DatapointHelper.getAppVersion(mContext));
        ((HttpGet) (obj2)).addHeader("x-customer-id", ((String) (obj1)));
        defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
        return;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/localytics/android/LocalyticsAmpSession$3

/* anonymous class */
    class LocalyticsAmpSession._cls3 extends AsyncTask
    {

        final LocalyticsAmpSession this$0;
        final String val$apiKey;
        final String val$campaign;
        final String val$creative;
        final LocalyticsProvider val$provider;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            provider.runBatchTransaction(new LocalyticsAmpSession._cls3._cls1());
            return null;
        }

        protected void onPreExecute()
        {
            Toast.makeText(mContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
        }
    }

}
