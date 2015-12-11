// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch;

import android.util.SparseArray;
import com.flow.android.engine.library.FlowStateEngineMetrics;
import com.flow.android.engine.library.impl.servermatch.threads.FlowServerRequestThread;
import com.flow.android.engine.library.impl.servermatch.threads.ImageServerMatch;
import com.flow.android.engine.library.impl.servermatch.threads.MetricsReporter;
import com.flow.android.engine.library.impl.servermatch.threads.TextServerMatcher;
import com.flow.android.engine.library.impl.servermatch.threads.ThreadPoolManagerInterface;
import java.io.ByteArrayInputStream;
import java.util.Map;

// Referenced classes of package com.flow.android.engine.library.impl.servermatch:
//            ClientDeviceInfo, HttpManagerInterface

public class HttpManager
    implements ThreadPoolManagerInterface
{

    static ClientDeviceInfo m_clientDevice = null;
    private static String s_metricsServer = "https://eventlog-visualsearch.amazon.com/vsmetrics";
    final HttpManagerInterface m_cb;
    SparseArray m_outstandingFseThreads;

    public HttpManager(HttpManagerInterface httpmanagerinterface, ClientDeviceInfo clientdeviceinfo)
    {
        m_outstandingFseThreads = new SparseArray();
        m_cb = httpmanagerinterface;
        m_clientDevice = clientdeviceinfo;
    }

    public void cancelFSERequests()
    {
        for (int i = 0; i < m_outstandingFseThreads.size(); i++)
        {
            int j = m_outstandingFseThreads.keyAt(i);
            ((FlowServerRequestThread)m_outstandingFseThreads.get(j)).cancelRequest();
        }

        m_outstandingFseThreads.clear();
    }

    public void doImageMatch(ByteArrayInputStream bytearrayinputstream, Map map, Map map1)
    {
        (new ImageServerMatch(m_cb, this, m_clientDevice, m_clientDevice.getHttpImageMatchServer(), m_clientDevice.getImageMatchServerResponseType(), bytearrayinputstream, map, map1)).start();
    }

    public void doMetricsReporting(FlowStateEngineMetrics flowstateenginemetrics)
    {
        (new MetricsReporter(m_cb, this, m_clientDevice, s_metricsServer, null, null, flowstateenginemetrics)).start();
    }

    public void doTextMatch(ByteArrayInputStream bytearrayinputstream, Map map, Map map1)
    {
        (new TextServerMatcher(m_cb, this, m_clientDevice, m_clientDevice.getHttpTextServer(), m_clientDevice.getTextServerResponseType(), bytearrayinputstream, map, map1)).start();
    }

    public void onFinish(int i)
    {
        m_outstandingFseThreads.remove(i);
    }

    public void onRun(int i, FlowServerRequestThread flowserverrequestthread)
    {
        m_outstandingFseThreads.append(i, flowserverrequestthread);
    }

}
