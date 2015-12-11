// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch.threads;

import android.util.Log;
import com.flow.android.engine.library.constants.ConnectionType;
import com.flow.android.engine.library.impl.servermatch.ClientDeviceInfo;
import com.flow.android.engine.library.impl.servermatch.HttpManagerInterface;
import com.flow.android.engine.library.impl.servermatch.MultipartFormOutputStream;
import com.flow.android.engine.library.impl.servermatch.StreamHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

// Referenced classes of package com.flow.android.engine.library.impl.servermatch.threads:
//            ThreadPoolManagerInterface

public abstract class FlowServerRequestThread extends Thread
{

    protected String mApplicationURL;
    protected Map mCustomParamsPair;
    protected ClientDeviceInfo mDeviceInfo;
    protected HttpManagerInterface mHttpManagerInterface;
    protected int mId;
    protected ByteArrayInputStream mInputStream;
    protected Map mMetadataParamsPair;
    protected com.a9.vs.mobile.library.impl.jni.ServerResponse.Type mResponseType;
    AtomicInteger mThreadIdAssigner;
    protected ThreadPoolManagerInterface mThreadPoolManagerInterface;
    protected boolean m_isCancelled;

    public FlowServerRequestThread(HttpManagerInterface httpmanagerinterface, ThreadPoolManagerInterface threadpoolmanagerinterface, ClientDeviceInfo clientdeviceinfo, String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, ByteArrayInputStream bytearrayinputstream, Map map, 
            Map map1)
    {
        m_isCancelled = false;
        mThreadIdAssigner = new AtomicInteger(0);
        mHttpManagerInterface = httpmanagerinterface;
        mDeviceInfo = clientdeviceinfo;
        mApplicationURL = s;
        mResponseType = type;
        mInputStream = bytearrayinputstream;
        mId = mThreadIdAssigner.getAndIncrement();
        mThreadPoolManagerInterface = threadpoolmanagerinterface;
        mCustomParamsPair = map;
        mMetadataParamsPair = map1;
    }

    public void cancelRequest()
    {
        m_isCancelled = true;
    }

    protected JSONObject getCommonPOSTData()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(mMetadataParamsPair);
            jsonobject.put("clientVersion", mDeviceInfo.getClientVersion());
            jsonobject.put("clientDeviceId", mDeviceInfo.getClientDeviceId());
            jsonobject.put("clientId", mDeviceInfo.getClientId());
            jsonobject.put("clientDevice", mDeviceInfo.getClientDevice());
            jsonobject.put("clientDeviceVersion", mDeviceInfo.getDeviceVersion());
            ConnectionType connectiontype = mDeviceInfo.getConnectionType();
            jsonobject.put("connectionType", connectiontype.getNetworkName());
            jsonobject.put("connectionCellularGeneration", connectiontype.getNetworkType());
            jsonobject.put("connectionCellularRadioTechnology", String.valueOf(mDeviceInfo.getRawNetworkSubTypeId()));
        }
        catch (Exception exception)
        {
            Log.e("FlowServerRequestThread", "Error ", exception);
            return new JSONObject();
        }
        return jsonobject;
    }

    protected String getResponseFromServer(String s, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        obj7 = mApplicationURL;
        obj3 = null;
        obj4 = null;
        obj6 = null;
        obj5 = null;
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        obj7 = (HttpURLConnection)(new URL(((String) (obj7)))).openConnection();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setRequestMethod(s);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setDoOutput(true);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setDoInput(true);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setUseCaches(false);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setDefaultUseCaches(false);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setConnectTimeout(1500);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s = MultipartFormOutputStream.createBoundary();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setRequestProperty("Accept", "*/*");
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setRequestProperty("Content-Type", MultipartFormOutputStream.getContentType(s));
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setRequestProperty("Connection", "Keep-Alive");
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setRequestProperty("Cache-Control", "no-cache");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).setRequestProperty("Accept-Encoding", "gzip");
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        ((HttpURLConnection) (obj7)).connect();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s = new MultipartFormOutputStream(((HttpURLConnection) (obj7)).getOutputStream(), s);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField("username", mDeviceInfo.getKey());
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        Object obj8 = mDeviceInfo.getTimestampInEpochSeconds();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField("authtoken", mDeviceInfo.getAuthtoken(((String) (obj8))));
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField("ts", ((String) (obj8)));
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField("application", mDeviceInfo.getApplication());
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField("disableImageStorage", mDeviceInfo.isDataCollectionDisabled());
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField("query_metadata", getCommonPOSTData().toString());
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        if (mCustomParamsPair == null) goto _L2; else goto _L1
_L1:
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        obj8 = mCustomParamsPair.entrySet().iterator();
_L3:
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        if (!((Iterator) (obj8)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj8)).next();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeField((String)entry.getKey(), (String)entry.getValue());
        if (true) goto _L3; else goto _L2
        obj3;
        s = obj4;
_L9:
        obj1 = s;
        obj = obj2;
        Log.e("FlowServerRequestThread", "Error ", ((Throwable) (obj3)));
        StreamHelper.closeOutputStream(s);
        StreamHelper.closeInputStream(((InputStream) (obj2)));
        return "";
_L2:
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.writeFile("file", "image/jpeg", "image.jpg", mInputStream);
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.flush();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s.close();
        obj2 = obj5;
        obj1 = obj3;
        obj = obj6;
        s = ((HttpURLConnection) (obj7)).getInputStream();
        obj2 = s;
        obj1 = obj3;
        obj = s;
        obj3 = new ByteArrayOutputStream();
        obj = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_769;
        }
        obj = s;
        obj2 = s;
        obj1 = s;
        if (!"gzip".equals(((HttpURLConnection) (obj7)).getContentEncoding()))
        {
            break MISSING_BLOCK_LABEL_769;
        }
        obj2 = s;
        obj1 = s;
        obj = new GZIPInputStream(s);
_L5:
        obj2 = obj;
        obj1 = obj;
        int i = ((InputStream) (obj)).read();
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        obj1 = obj;
        ((ByteArrayOutputStream) (obj3)).write(i);
        if (true) goto _L5; else goto _L4
_L4:
        obj2 = obj;
        obj1 = obj;
        ((ByteArrayOutputStream) (obj3)).flush();
        obj2 = obj;
        obj1 = obj;
        s = ((ByteArrayOutputStream) (obj3)).toString();
        StreamHelper.closeOutputStream(((java.io.OutputStream) (obj3)));
        StreamHelper.closeInputStream(((InputStream) (obj)));
        return s;
        s;
_L7:
        StreamHelper.closeOutputStream(((java.io.OutputStream) (obj1)));
        StreamHelper.closeInputStream(((InputStream) (obj)));
        throw s;
        s;
        obj1 = obj3;
        obj = obj2;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        s = ((String) (obj3));
        obj3 = exception;
        obj2 = obj1;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
