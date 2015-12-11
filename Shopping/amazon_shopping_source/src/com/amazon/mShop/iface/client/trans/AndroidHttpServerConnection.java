// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.iface.client.trans;

import android.util.Log;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.customclientfields.RefmarkerClientField;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.feature.FeatureTrigger;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.sso.AccountCookiesSyncManager;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.trans.ServerConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AndroidHttpServerConnection extends ServerConnection
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final String TAG = com/amazon/mShop/iface/client/trans/AndroidHttpServerConnection.getSimpleName();
    private Map mCustomHeaders;
    private HttpURLConnection mHttpConnection;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    public AndroidHttpServerConnection(String s)
    {
        super(s);
        mHttpConnection = null;
        mOutputStream = null;
        mInputStream = null;
        mCustomHeaders = new ConcurrentHashMap();
    }

    private void close(InputStream inputstream, OutputStream outputstream, HttpURLConnection httpurlconnection)
    {
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                if (DEBUG)
                {
                    Log.w(TAG, inputstream);
                }
            }
        }
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                if (DEBUG)
                {
                    Log.w(TAG, inputstream);
                }
            }
        }
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
    }

    public void addCustomHeaders(String s)
    {
        Object obj = FeatureTrigger.getHttpHeaderFeatureTriggers(s);
        if (!Util.isEmpty(((String) (obj))))
        {
            mCustomHeaders.put("x-amz-msh-feature-trigger", obj);
        }
        obj = CustomClientFields.getCustomHeaderFields(s);
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            obj = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                if (!Util.isEmpty((String)entry.getKey()) && !Util.isEmpty((String)entry.getValue()))
                {
                    mCustomHeaders.put(entry.getKey(), entry.getValue());
                }
            } while (true);
        }
        s = RefmarkerClientField.getHttpHeaderForRefmarker(s);
        if (!Util.isEmpty(s))
        {
            mCustomHeaders.put("x-amz-msh-ref-marker", s);
        }
    }

    protected InputStream getInputStream()
        throws IOException
    {
        if (mInputStream == null)
        {
            int i = mHttpConnection.getResponseCode();
            if (i != 200)
            {
                String s = (new StringBuilder()).append("HTTP response error: ").append(i).append(" ").append(mHttpConnection.getResponseMessage()).toString();
                if (DEBUG)
                {
                    Log.w(TAG, (new StringBuilder()).append("getInputStream(): ").append(s).toString());
                }
                throw new IOException(s);
            }
            mInputStream = mHttpConnection.getInputStream();
        }
        return mInputStream;
    }

    protected OutputStream getOutputStream()
        throws IOException
    {
        if (mOutputStream == null)
        {
            if (mInputStream != null)
            {
                if (DEBUG)
                {
                    Log.w(TAG, "getOutputStream(): output stream must be opened before input stream");
                }
                throw new IllegalStateException("output stream must be opened before input stream");
            }
            mHttpConnection.setDoOutput(true);
            mOutputStream = mHttpConnection.getOutputStream();
        }
        return mOutputStream;
    }

    protected void initializeNetworkConnection(int i)
        throws IOException
    {
        NetInfo.waitForNetworkConnectivity();
        AccountCookiesSyncManager.checkAndWait();
        mHttpConnection = (HttpURLConnection)(new URL(getUrl())).openConnection();
        mHttpConnection.setRequestMethod("POST");
        mHttpConnection.setRequestProperty("Content-Type", "application/octet-stream");
        mHttpConnection.setConnectTimeout(30000);
        mHttpConnection.setReadTimeout(30000);
        mHttpConnection.setRequestProperty("Content-Length", Integer.toString(i));
        String s = System.getProperty("http.agent");
        if (!Util.isEmpty(s))
        {
            mHttpConnection.setRequestProperty("User-Agent", s);
        }
        java.util.Map.Entry entry;
        for (Iterator iterator = mCustomHeaders.entrySet().iterator(); iterator.hasNext(); mHttpConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    protected void releaseNetworkConnection()
    {
        close(mInputStream, mOutputStream, mHttpConnection);
    }

    static 
    {
        System.setProperty("http.keepAlive", "true");
    }
}
