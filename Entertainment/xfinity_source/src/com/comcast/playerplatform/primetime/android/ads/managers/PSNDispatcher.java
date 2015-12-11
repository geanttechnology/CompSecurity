// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import android.util.Log;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.impl.client.DefaultHttpClient;
import com.comcast.playerplatform.primetime.android.ads.PlacementEvent;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.MoneyTrace;
import com.comcast.playerplatform.util.android.XrestHelper;

class PSNDispatcher
{

    private String endpoint;
    private HttpClient httpClient;
    private MoneyTrace moneyTrace;

    PSNDispatcher(HttpClient httpclient, MoneyTrace moneytrace)
    {
        endpoint = (new ConfigurationHelper()).getValue("PlacementStatusNotificationEndPoint");
        if (httpclient == null)
        {
            httpclient = new DefaultHttpClient();
        }
        httpClient = httpclient;
        moneyTrace = moneytrace;
    }

    public void dispatchPSN(PlacementEvent placementevent)
    {
        placementevent = placementevent.getPsn();
        Log.d("PaukTest", placementevent);
        ThreadManager.getInstance().executeRunnable(new XrestHelper(placementevent, endpoint, "POST", null, new AbstractResponseEventListener() {

            final PSNDispatcher this$0;

            public void configurationNotReady()
            {
                super.configurationNotReady();
            }

            public void redirectUrlFound(String s)
            {
                super.redirectUrlFound(s);
            }

            public void requestFailed(String s)
            {
                super.requestFailed(s);
                Log.d("PaukTest", (new StringBuilder()).append("PSN failed:").append(s).toString());
            }

            public void responseReceived(String s)
            {
                Log.d("PaukTest", (new StringBuilder()).append("PSN success:").append(s).toString());
            }

            
            {
                this$0 = PSNDispatcher.this;
                super();
            }
        }, httpClient, moneyTrace));
    }
}
