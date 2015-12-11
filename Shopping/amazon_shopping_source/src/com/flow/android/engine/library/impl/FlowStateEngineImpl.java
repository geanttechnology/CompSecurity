// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl;

import com.a9.vs.mobile.library.impl.jni.ByteArray;
import com.flow.android.engine.library.FlowStateEngineInterface;
import com.flow.android.engine.library.FlowStateEngineMetrics;
import com.flow.android.engine.library.impl.servermatch.ClientDeviceInfo;
import com.flow.android.engine.library.impl.servermatch.HttpManager;
import com.flow.android.engine.library.impl.servermatch.HttpManagerInterface;
import java.io.ByteArrayInputStream;
import java.util.Map;

// Referenced classes of package com.flow.android.engine.library.impl:
//            FlowServerCallback, FlowEventCallback

public class FlowStateEngineImpl
    implements HttpManagerInterface
{

    private FlowEventCallback m_eventCallback;
    private HttpManager m_httpManager;
    private FlowServerCallback m_imageMatchServerCallback;
    private FlowStateEngineInterface m_interface;
    private FlowServerCallback m_textServerCallback;

    public FlowStateEngineImpl(FlowStateEngineInterface flowstateengineinterface, ClientDeviceInfo clientdeviceinfo)
    {
        m_httpManager = null;
        m_interface = flowstateengineinterface;
        m_httpManager = new HttpManager(this, clientdeviceinfo);
        m_imageMatchServerCallback = new FlowServerCallback(this, FlowServerCallback.Mode.IMAGEMATCH);
        m_textServerCallback = new FlowServerCallback(this, FlowServerCallback.Mode.TEXT);
        m_eventCallback = new FlowEventCallback(m_interface);
    }

    public void didReceiveImageMatchResponse(String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, double d)
    {
        m_imageMatchServerCallback.gotServerResponse(s, type, d);
        m_eventCallback.setNetworkErrorMode(false);
    }

    public void didReceiveTextMatchResponse(String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, double d)
    {
        m_textServerCallback.gotServerResponse(s, type, d);
        m_eventCallback.setNetworkErrorMode(false);
    }

    public boolean doImageMatch(ByteArray bytearray, Map map, Map map1)
    {
        bytearray = new ByteArrayInputStream(bytearray.getData());
        m_httpManager.doImageMatch(bytearray, map, map1);
        return true;
    }

    public void doMetricsReporting(FlowStateEngineMetrics flowstateenginemetrics)
    {
        m_httpManager.doMetricsReporting(flowstateenginemetrics);
    }

    public boolean doTextMatch(ByteArray bytearray, Map map, Map map1)
    {
        bytearray = new ByteArrayInputStream(bytearray.getData());
        m_httpManager.doTextMatch(bytearray, map, map1);
        return true;
    }

    public FlowEventCallback getEventCallback()
    {
        return m_eventCallback;
    }

    public FlowServerCallback getImageMatchServerCallback()
    {
        return m_imageMatchServerCallback;
    }

    public FlowServerCallback getTextServerCallback()
    {
        return m_textServerCallback;
    }

    public void resetServerDelegates()
    {
        if (m_imageMatchServerCallback != null)
        {
            m_imageMatchServerCallback.resetServerState();
        }
        if (m_textServerCallback != null)
        {
            m_textServerCallback.resetServerState();
        }
    }

    public void setInterface(FlowStateEngineInterface flowstateengineinterface)
    {
        m_interface = flowstateengineinterface;
        m_eventCallback.setInterface(m_interface);
    }

    public void shutdownServerDelegates()
    {
        m_httpManager.cancelFSERequests();
        if (m_imageMatchServerCallback != null)
        {
            m_imageMatchServerCallback.shutdownServerState();
        }
        if (m_textServerCallback != null)
        {
            m_textServerCallback.shutdownServerState();
        }
    }
}
