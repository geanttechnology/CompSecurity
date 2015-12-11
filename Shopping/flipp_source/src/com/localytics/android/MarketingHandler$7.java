// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.os.AsyncTask;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, LocalyticsDao

class val.customerID extends AsyncTask
{

    final MarketingHandler this$0;
    final Context val$appContext;
    final String val$campaign;
    final String val$creative;
    final String val$customerID;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return mLocalyticsDao.getPushRegistrationId();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(final String pushRegID)
    {
        class _cls1 extends AsyncTask
        {

            final MarketingHandler._cls7 this$1;
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
                if (TextUtils.isEmpty(pushRegID))
                {
                    break MISSING_BLOCK_LABEL_251;
                }
                obj2 = mLocalyticsDao.getInstallationId();
                s = String.format("http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s", new Object[] {
                    campaign, creative, pushRegID, obj2, Long.toString(Math.round((double)mLocalyticsDao.getCurrentTimeMillis() / 1000D))
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
                Localytics.Log.e("Activating push test has failed", ((Throwable) (obj1)));
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
                if (!TextUtils.isEmpty(pushRegID))
                {
                    Toast.makeText(appContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
                    return;
                } else
                {
                    Toast.makeText(appContext, "App isn't registered with GCM to receive push notifications. Please make sure that Localytics.registerPush(<PROJECT_ID>) has been called.", 1).show();
                    return;
                }
            }

            _cls1()
            {
                this$1 = MarketingHandler._cls7.this;
                pushRegID = s;
                super();
            }
        }

        (new _cls1()).execute(new Void[0]);
    }

    _cls1()
    {
        this$0 = final_marketinghandler;
        val$appContext = context;
        val$campaign = s;
        val$creative = s1;
        val$customerID = String.this;
        super();
    }
}
