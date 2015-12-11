// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch.threads;

import com.flow.android.engine.library.impl.servermatch.ClientDeviceInfo;
import com.flow.android.engine.library.impl.servermatch.HttpManagerInterface;
import java.io.ByteArrayInputStream;
import java.util.Map;

// Referenced classes of package com.flow.android.engine.library.impl.servermatch.threads:
//            FlowServerRequestThread, ThreadPoolManagerInterface

public class ImageServerMatch extends FlowServerRequestThread
{

    protected static Object sLockObject = new Object();

    public ImageServerMatch(HttpManagerInterface httpmanagerinterface, ThreadPoolManagerInterface threadpoolmanagerinterface, ClientDeviceInfo clientdeviceinfo, String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, ByteArrayInputStream bytearrayinputstream, Map map, 
            Map map1)
    {
        super(httpmanagerinterface, threadpoolmanagerinterface, clientdeviceinfo, s, type, bytearrayinputstream, map, map1);
    }

    private String sendImageToServer()
    {
        return getResponseFromServer("GET", false);
    }

    public void run()
    {
        mThreadPoolManagerInterface.onRun(mId, this);
        long l = System.currentTimeMillis();
        String s;
        synchronized (sLockObject)
        {
            s = sendImageToServer();
        }
        double d = (double)(System.currentTimeMillis() - l) / 1000D;
        if (mHttpManagerInterface != null && !m_isCancelled)
        {
            mHttpManagerInterface.didReceiveImageMatchResponse(s, mResponseType, d);
        }
        mThreadPoolManagerInterface.onFinish(mId);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
