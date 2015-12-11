// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, LocalyticsDao, BaseUploadThread, DatapointHelper, 
//            Localytics

class val.pushRegID extends AsyncTask
{

    final l.appContext this$1;
    final String val$pushRegID;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s;
        obj = null;
        obj1 = null;
        if (TextUtils.isEmpty(val$pushRegID))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        obj2 = mLocalyticsDao.getInstallationId();
        s = String.format("http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s", new Object[] {
            campaign, creative, val$pushRegID, obj2, Long.toString(Math.round((double)mLocalyticsDao.getCurrentTimeMillis() / 1000D))
        });
        avoid = ((Void []) (obj));
        java.net.Proxy proxy = mLocalyticsDao.getProxy();
        avoid = ((Void []) (obj));
        obj = (HttpURLConnection)BaseUploadThread.createURLConnection(new URL(s), proxy);
        ((HttpURLConnection) (obj)).setConnectTimeout(5000);
        ((HttpURLConnection) (obj)).setReadTimeout(5000);
        ((HttpURLConnection) (obj)).setDoOutput(false);
        ((HttpURLConnection) (obj)).setRequestProperty("x-install-id", ((String) (obj2)));
        ((HttpURLConnection) (obj)).setRequestProperty("x-app-id", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        ((HttpURLConnection) (obj)).setRequestProperty("x-client-version", "androida_3.4.0");
        ((HttpURLConnection) (obj)).setRequestProperty("x-app-version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        ((HttpURLConnection) (obj)).setRequestProperty("x-customer-id", customerID);
        ((HttpURLConnection) (obj)).getInputStream();
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        avoid = null;
_L2:
        return avoid;
        avoid;
        obj = obj1;
        obj1 = avoid;
_L5:
        avoid = ((Void []) (obj));
        obj2 = new StringBuilder("Unfortunately, something went wrong. Push test activation was unsuccessful.");
        avoid = ((Void []) (obj));
        if (!Localytics.isLoggingEnabled())
        {
            break MISSING_BLOCK_LABEL_309;
        }
        avoid = ((Void []) (obj));
        if (!(obj1 instanceof FileNotFoundException))
        {
            break MISSING_BLOCK_LABEL_309;
        }
        avoid = ((Void []) (obj));
        ((StringBuilder) (obj2)).append("\n\nCause:\nPush registration token has not yet been processed. Please wait a few minutes and try again.");
        avoid = ((Void []) (obj));
        nabled("Activating push test has failed", ((Throwable) (obj1)));
        avoid = ((Void []) (obj));
        obj1 = ((StringBuilder) (obj2)).toString();
        avoid = ((Void []) (obj1));
        if (obj == null) goto _L2; else goto _L1
_L1:
        ((HttpURLConnection) (obj)).disconnect();
        return ((String) (obj1));
        Exception exception;
        exception;
        obj = avoid;
        avoid = exception;
_L4:
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw avoid;
        avoid;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
          goto _L5
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (s != null)
        {
            Toast.makeText(appContext, s, 1).show();
        }
    }

    protected void onPreExecute()
    {
        if (!TextUtils.isEmpty(val$pushRegID))
        {
            Toast.makeText(appContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
            return;
        } else
        {
            Toast.makeText(appContext, "App isn't registered with GCM to receive push notifications. Please make sure that Localytics.registerPush(<PROJECT_ID>) has been called.", 1).show();
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$pushRegID = String.this;
        super();
    }
}
