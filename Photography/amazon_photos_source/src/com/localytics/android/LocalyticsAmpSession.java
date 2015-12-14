// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.localytics.android:
//            LocalyticsSession, AmpSessionHandler, AmpConstants, SessionHandler, 
//            LocalyticsProvider, DatapointHelper

public class LocalyticsAmpSession extends LocalyticsSession
{

    public LocalyticsAmpSession(Context context)
    {
        this(context, null);
    }

    public LocalyticsAmpSession(Context context, String s)
    {
        this(context, s, null);
    }

    LocalyticsAmpSession(Context context, String s, String s1)
    {
        super(context, s, s1);
        sSessionHandlerThread.setName(com/localytics/android/AmpSessionHandler.getSimpleName());
        createLocalyticsDirectory(context);
    }

    private boolean createLocalyticsDirectory(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        context = new File(stringbuilder.toString());
        return context.mkdirs() || context.isDirectory();
    }

    public static boolean isTestModeEnabled()
    {
        return AmpConstants.isTestModeEnabled();
    }

    public void attach(FragmentActivity fragmentactivity)
    {
        if (fragmentactivity == null)
        {
            throw new IllegalArgumentException("attached activity cannot be null");
        }
        AmpSessionHandler ampsessionhandler = (AmpSessionHandler)getSessionHandler();
        ampsessionhandler.setFragmentManager(fragmentactivity.getSupportFragmentManager());
        if (isTestModeEnabled())
        {
            ampsessionhandler.sendMessage(ampsessionhandler.obtainMessage(15));
        }
    }

    protected SessionHandler createSessionHandler(Context context, String s, Looper looper)
    {
        return new AmpSessionHandler(context, s, looper);
    }

    public void detach()
    {
        ((AmpSessionHandler)getSessionHandler()).setFragmentManager(null);
    }

    protected void uploadAnalytics()
    {
        final AmpSessionHandler handler = (AmpSessionHandler)getSessionHandler();
        handler.sendMessage(handler.obtainMessage(4, new Runnable() {

            final LocalyticsAmpSession this$0;
            final AmpSessionHandler val$handler;

            public void run()
            {
                handler.sendMessage(handler.obtainMessage(13, ((Object) (new Object[] {
                    "AMP Loaded", null
                }))));
            }

            
            {
                this$0 = LocalyticsAmpSession.this;
                handler = ampsessionhandler;
                super();
            }
        }));
    }

    // Unreferenced inner class com/localytics/android/LocalyticsAmpSession$3

/* anonymous class */
    class _cls3 extends AsyncTask
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
            provider.runBatchTransaction(new Runnable() {

                final _cls3 this$1;

                public void run()
                {
                    Object obj;
                    String s;
                    obj = null;
                    s = null;
    class _cls3 extends AsyncTask
    {
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

            
            {
                this$1 = _cls3.this;
                super();
            }
            });
            return null;
        }

        protected void onPreExecute()
        {
            Toast.makeText(mContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
        }
    }

}
