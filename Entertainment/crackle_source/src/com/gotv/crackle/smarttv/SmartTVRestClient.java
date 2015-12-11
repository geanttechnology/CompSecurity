// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import com.gotv.crackle.util.Log;
import com.samsung.rest.OnRequestCallbackListener;
import com.samsung.rest.RestClient;
import java.net.URL;

public class SmartTVRestClient extends RestClient
{

    public SmartTVRestClient(OnRequestCallbackListener onrequestcallbacklistener)
    {
        super(onrequestcallbacklistener);
    }

    public void connect(URL url, String s)
    {
        executeURL(url, s, "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/connect", "POST", 9001);
    }

    public void disconnect(URL url, String s)
    {
        if (isConnected())
        {
            executeURL(url, s, "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/disconnect", "POST", 9004);
            return;
        } else
        {
            Log.w("RestClient", "Application not connected!");
            return;
        }
    }

    public void launchWidget(URL url, String s)
    {
        executeURL(url, s, "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID", "POST", 9006);
    }

    public void requestApplicationStatus(URL url, String s)
    {
        executeURL(url, s, "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/info", "GET", 9005);
    }

    public void sendData(URL url, String s, String s1)
    {
        executeURL(url, s, "http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/queue", "POST", s1, 9002);
    }
}
