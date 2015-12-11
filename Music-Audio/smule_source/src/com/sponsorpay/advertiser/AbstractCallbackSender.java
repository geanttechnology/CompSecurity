// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.advertiser;

import android.os.AsyncTask;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SPHttpConnection;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import com.sponsorpay.utils.UrlBuilder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.advertiser:
//            SponsorPayAdvertiserState

public abstract class AbstractCallbackSender extends AsyncTask
{

    private static final String INSTALL_SUBID_KEY = "subid";
    protected static final String SUCCESSFUL_ANSWER_RECEIVED_KEY = "answer_received";
    protected static final int SUCCESSFUL_HTTP_STATUS_CODE = 200;
    private static final String TAG = "AbstractCallbackSender";
    private SPCredentials mCredentials;
    private Map mCustomParams;
    protected SponsorPayAdvertiserState mState;

    public AbstractCallbackSender(SPCredentials spcredentials, SponsorPayAdvertiserState sponsorpayadvertiserstate)
    {
        mState = sponsorpayadvertiserstate;
        mCredentials = spcredentials;
    }

    private String buildUrl()
    {
        Object obj1 = getParams();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new HashMap();
        }
        if (mCustomParams != null)
        {
            ((Map) (obj)).putAll(mCustomParams);
        }
        ((Map) (obj)).put("answer_received", getAnswerReceived());
        obj1 = mState.getInstallSubId();
        if (StringUtils.notNullNorEmpty(((String) (obj1))))
        {
            ((Map) (obj)).put("subid", obj1);
        }
        obj = UrlBuilder.newBuilder(getBaseUrl(), mCredentials).addExtraKeysValues(((Map) (obj))).addScreenMetrics().buildUrl();
        SponsorPayLogger.d("AbstractCallbackSender", (new StringBuilder("Callback will be sent to: ")).append(((String) (obj))).toString());
        return ((String) (obj));
    }

    protected transient Boolean doInBackground(String as[])
    {
        Thread.currentThread().setName("AbstractCallbackSender");
        as = buildUrl();
        int i;
        boolean flag;
        try
        {
            i = SPHttpConnection.getConnection(as).open().getResponseCode();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            SponsorPayLogger.e("AbstractCallbackSender", (new StringBuilder("An exception occurred when trying to send advertiser callback: ")).append(as).toString());
            return Boolean.valueOf(false);
        }
        if (i == 200)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SponsorPayLogger.d("AbstractCallbackSender", (new StringBuilder("Server returned status code: ")).append(i).toString());
        return Boolean.valueOf(flag);
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected abstract String getAnswerReceived();

    protected abstract String getBaseUrl();

    protected abstract Map getParams();

    protected void onPostExecute(Boolean boolean1)
    {
        processRequest(boolean1);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected abstract void processRequest(Boolean boolean1);

    public void setCustomParams(Map map)
    {
        mCustomParams = map;
    }

    public void trigger()
    {
        execute(null);
    }
}
