// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import com.flow.android.engine.library.constants.ConnectionType;
import com.flow.android.engine.library.utils.ConnectivityUtil;
import com.flow.android.engine.models.FlowStateEngineIO;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class ClientDeviceInfo
{

    private String application;
    private String clientDevice;
    private String clientDeviceId;
    private String clientId;
    private String clientVersion;
    private Context context;
    private String deviceVersion;
    private com.a9.vs.mobile.library.impl.jni.ServerResponse.Type errorReportingResponseType;
    private String errorReportingServer;
    private String imageMatchServer;
    private com.a9.vs.mobile.library.impl.jni.ServerResponse.Type imageMatchServerResponseType;
    private boolean isDataCollectionDisabled;
    private String key;
    private com.a9.vs.mobile.library.impl.jni.ServerResponse.Type logoMatchServerResponseType;
    private String secret;
    private String textServer;
    private com.a9.vs.mobile.library.impl.jni.ServerResponse.Type textServerResponseType;

    public ClientDeviceInfo()
    {
        textServerResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_TERS_TR;
        imageMatchServerResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_VSEARCH;
        logoMatchServerResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_LOGO;
        errorReportingResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_VSEARCH;
    }

    public ClientDeviceInfo(FlowStateEngineIO flowstateengineio)
    {
        textServerResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_TERS_TR;
        imageMatchServerResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_VSEARCH;
        logoMatchServerResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_LOGO;
        errorReportingResponseType = com.a9.vs.mobile.library.impl.jni.ServerResponse.Type.JSON_VSEARCH;
        setKey(flowstateengineio.getUsername());
        setSecret(flowstateengineio.getSecret());
        setApplication(flowstateengineio.getApplication());
        setClientVersion(flowstateengineio.getClientVersion());
        setClientDeviceId(flowstateengineio.getClientDeviceID());
        String s = flowstateengineio.getClientSessionID();
        if (flowstateengineio.getClientSessionID() == null)
        {
            s = UUID.randomUUID().toString();
        }
        setClientId(s);
        setDeviceVersion(android.os.Build.VERSION.RELEASE);
        setClientDevice((new StringBuilder()).append("Android - ").append(Build.MODEL).toString());
        setHttpTextServer(flowstateengineio.getTextServer());
        setHttpImageMatchServer(flowstateengineio.getImgServer());
        setDataCollectionDisabled(flowstateengineio.isDataCollectionDisabled());
        setHttpErrorReportingServer(flowstateengineio.getErrorReportingServer());
    }

    private String getMD5FromString(String s)
    {
        byte abyte0[] = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
        String s1;
        int i;
        s1 = "";
        i = 0;
_L2:
        String s2 = s1;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (new StringBuilder()).append(s1).append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1).toUpperCase()).toString();
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        s2 = s;
_L1:
        return s2;
    }

    private void setHttpErrorReportingServer(String s)
    {
        errorReportingServer = s;
    }

    private void setHttpImageMatchServer(String s)
    {
        imageMatchServer = s;
    }

    private void setHttpTextServer(String s)
    {
        textServer = s;
    }

    public String getApplication()
    {
        return application;
    }

    public String getAuthtoken(String s)
    {
        return getMD5FromString((new StringBuilder()).append(getSecret()).append(getKey()).append(getApplication()).append(s).toString());
    }

    public String getClientDevice()
    {
        return clientDevice;
    }

    public String getClientDeviceId()
    {
        return clientDeviceId;
    }

    public String getClientId()
    {
        return clientId;
    }

    public String getClientVersion()
    {
        return clientVersion;
    }

    public ConnectionType getConnectionType()
    {
        NetworkInfo networkinfo = ConnectivityUtil.getNetworkInfo(context);
        return ConnectionType.findGroupByTypeSubtypeId(networkinfo.getType(), networkinfo.getSubtype());
    }

    public String getDeviceVersion()
    {
        return deviceVersion;
    }

    public String getHttpImageMatchServer()
    {
        return imageMatchServer;
    }

    public String getHttpTextServer()
    {
        return textServer;
    }

    public com.a9.vs.mobile.library.impl.jni.ServerResponse.Type getImageMatchServerResponseType()
    {
        return imageMatchServerResponseType;
    }

    public String getKey()
    {
        return key;
    }

    public int getRawNetworkSubTypeId()
    {
        return ConnectivityUtil.getNetworkInfo(context).getSubtype();
    }

    public String getSecret()
    {
        return secret;
    }

    public com.a9.vs.mobile.library.impl.jni.ServerResponse.Type getTextServerResponseType()
    {
        return textServerResponseType;
    }

    public String getTimestampInEpochSeconds()
    {
        Date date = new Date();
        return (new StringBuilder()).append("").append(date.getTime() / 1000L).toString();
    }

    public boolean isDataCollectionDisabled()
    {
        return isDataCollectionDisabled;
    }

    public void setApplication(String s)
    {
        application = s;
    }

    public void setClientDevice(String s)
    {
        clientDevice = s;
    }

    public void setClientDeviceId(String s)
    {
        clientDeviceId = s;
    }

    public void setClientId(String s)
    {
        clientId = s;
    }

    public void setClientVersion(String s)
    {
        clientVersion = s;
    }

    public void setContext(Context context1)
    {
        context = context1;
    }

    public void setDataCollectionDisabled(boolean flag)
    {
        isDataCollectionDisabled = flag;
    }

    public void setDeviceVersion(String s)
    {
        deviceVersion = s;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setSecret(String s)
    {
        secret = s;
    }
}
