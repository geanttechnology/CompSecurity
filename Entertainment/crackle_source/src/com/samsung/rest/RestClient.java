// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import android.util.Log;
import java.net.URL;
import java.util.HashMap;

// Referenced classes of package com.samsung.rest:
//            RequestExecuter, RestUtil, Request, DeviceInfo, 
//            OnRequestCallbackListener

public class RestClient
{

    protected static final String GET_STR = "GET";
    protected static final String LOG_TAG = "RestClient";
    protected static final String POST_STR = "POST";
    protected boolean _connected;
    protected OnRequestCallbackListener _onRequestCallbackListener;
    protected RequestExecuter _requestExecuter;

    public RestClient(OnRequestCallbackListener onrequestcallbacklistener)
    {
        _connected = false;
        _onRequestCallbackListener = onrequestcallbacklistener;
        _requestExecuter = new RequestExecuter();
    }

    public final void changePort(int i)
    {
        this;
        JVM INSTR monitorenter ;
        RestUtil.changePort(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void executeURL(URL url, String s, String s1, String s2, int i)
    {
        executeURL(url, s, s1, s2, null, i);
    }

    protected void executeURL(URL url, String s, String s1, String s2, String s3, int i)
    {
        url = new Request(RestUtil.prepareConnectionUrl(s1, url, s), s2, true);
        if (s3 != null)
        {
            url.addBody(s3);
        }
        _requestExecuter.execute(url, i, _onRequestCallbackListener);
    }

    public void get(URL url, HashMap hashmap, String s)
    {
        if (isConnected())
        {
            url = new Request(RestUtil.prepareGetUrl("http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/queue/device/DEVICE_ID", url, "interactivity_Button_label", DeviceInfo.getDeviceId()), "GET", true);
            url.addHeaders(hashmap);
            url.addBody(s);
            _requestExecuter.execute(url, 9003, _onRequestCallbackListener);
            return;
        } else
        {
            Log.w("RestClient", "Application not connected!");
            return;
        }
    }

    public boolean isConnected()
    {
        return _connected;
    }

    public void post(URL url, HashMap hashmap, String s)
    {
        if (isConnected())
        {
            url = new Request(RestUtil.preparePostUrl("http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/queue", url, "interactivity_Button_label"), "POST", false);
            url.addHeaders(hashmap);
            url.addBody(s);
            _requestExecuter.execute(url, 9002, _onRequestCallbackListener);
            return;
        } else
        {
            Log.w("RestClient", "Application not connected!");
            return;
        }
    }

    public void postImage(URL url, HashMap hashmap, String s, String s1, byte abyte0[])
    {
        if (isConnected())
        {
            url = new Request(RestUtil.preparePostUrl("http://IP_ADDRESS:PORT/ws/app/WIDGET_ID/queue", url, "interactivity_Button_label"), "POST", "image/png");
            url.addHeaders(hashmap);
            url.makeFileRequest(s1);
            _requestExecuter.execute(url, 9002, _onRequestCallbackListener);
            return;
        } else
        {
            Log.w("RestClient", "Application not connected!");
            return;
        }
    }

    public void setConnected(boolean flag)
    {
        _connected = flag;
    }
}
