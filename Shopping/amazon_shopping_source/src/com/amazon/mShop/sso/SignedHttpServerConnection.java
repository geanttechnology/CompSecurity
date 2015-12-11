// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.util.Log;
import com.amazon.identity.auth.device.api.AuthenticatedURLConnection;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.AuthenticationType;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.trans.IServiceConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil

class SignedHttpServerConnection
    implements IServiceConnection
{

    private volatile boolean mCancelled;
    private volatile HttpURLConnection mHttpConnection;
    private volatile boolean mRunning;
    private String mUrl;

    public SignedHttpServerConnection(String s)
    {
        if (DebugSettings.isDebugEnabled())
        {
            String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentSSOCheckLoginServer");
            mUrl = ConfigUtils.getString((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_serviceURL);
            if (!Util.isEmpty(s1) && s1.equals("SHM"))
            {
                mUrl.replace("msh", "shm");
            }
        }
        mUrl = s.replace("/mShop/service", "/mShop/signed");
    }

    private boolean isCancelled()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mCancelled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean isRunning()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mRunning;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private void setRunning(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mRunning = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void addCustomHeaders(String s)
    {
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "SignedHttpServerConnection.cancel");
        }
        mCancelled = true;
        close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "SignedHttpServerConnection.close");
        }
        if (!isRunning()) goto _L2; else goto _L1
_L1:
        mCancelled = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        HttpURLConnection httpurlconnection = mHttpConnection;
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        mHttpConnection.getInputStream().close();
_L7:
        mHttpConnection.disconnect();
          goto _L4
        Object obj;
        obj;
        if (!SSOUtil.DEBUG) goto _L4; else goto _L5
_L5:
        Log.v("Amazon.SSOUtil", ((Exception) (obj)).toString());
        ((Exception) (obj)).printStackTrace();
          goto _L4
        obj;
        throw obj;
        obj;
        if (!SSOUtil.DEBUG) goto _L7; else goto _L6
_L6:
        Log.v("Amazon.SSOUtil", ((Exception) (obj)).toString());
        ((Exception) (obj)).printStackTrace();
          goto _L7
    }

    public String getUrl()
    {
        return mUrl;
    }

    public InputStream send(byte abyte0[][])
        throws IOException
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "SignedHttpServerConnection.send START");
        }
        this;
        JVM INSTR monitorenter ;
        if (!isCancelled())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        close();
        this;
        JVM INSTR monitorexit ;
        return null;
        this;
        JVM INSTR monitorexit ;
        NetInfo.waitForNetworkConnectivity();
        this;
        JVM INSTR monitorenter ;
        if (!isCancelled())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        close();
        this;
        JVM INSTR monitorexit ;
        return null;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        setRunning(true);
        this;
        JVM INSTR monitorexit ;
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "SignedHttpServerConnection.send AFTER WAIT FOR CONNECTION");
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        for (int i = 0; i < abyte0.length; i++)
        {
            bytearrayoutputstream.write(abyte0[i]);
        }

        abyte0 = bytearrayoutputstream.toByteArray();
        Object obj = AndroidPlatform.getInstance().getApplicationContext();
        String s = SSOUtil.getCurrentAccount(((Context) (obj)));
        URL url = new URL(getUrl());
        obj = (new AuthenticationMethodFactory(((Context) (obj)), s)).newAuthenticationMethod(AuthenticationType.ADPAuthenticator);
        if (SSOUtil.DEBUG)
        {
            Log.d("Amazon.SSOUtil", "New apporach with ADP authenticator");
            Log.d("Amazon.SSOUtil", (new StringBuilder()).append("Current MAP account ").append(s).toString());
        }
        mHttpConnection = AuthenticatedURLConnection.openConnection(url, ((com.amazon.identity.auth.device.api.AuthenticationMethod) (obj)));
        mHttpConnection.setRequestMethod("POST");
        mHttpConnection.setDoOutput(true);
        mHttpConnection.setRequestProperty("Content-Type", "application/octet-stream");
        mHttpConnection.setRequestProperty("Content-Length", Integer.toString(abyte0.length));
        mHttpConnection.setConnectTimeout(30000);
        mHttpConnection.setReadTimeout(30000);
        mHttpConnection.getOutputStream().write(abyte0);
        abyte0 = mHttpConnection.getInputStream();
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "SignedHttpServerConnection.send END");
        }
        this;
        JVM INSTR monitorenter ;
        setRunning(false);
        if (isCancelled())
        {
            close();
        }
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        StringBuilder stringbuilder;
        if (!SSOUtil.DEBUG)
        {
            break MISSING_BLOCK_LABEL_515;
        }
        Log.v("Amazon.SSOUtil", (new StringBuilder()).append("IOException in send ").append(abyte0).toString());
        stringbuilder = new StringBuilder();
        stringbuilder.append(mHttpConnection.getResponseCode());
        stringbuilder.append(" ");
        stringbuilder.append(mHttpConnection.getResponseMessage());
        stringbuilder.append(" ");
        InputStream inputstream = mHttpConnection.getErrorStream();
        for (byte abyte1[] = new byte[mHttpConnection.getContentLength()]; -1 != inputstream.read(abyte1); stringbuilder.append(new String(abyte1))) { }
        break MISSING_BLOCK_LABEL_505;
        abyte0;
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "SignedHttpServerConnection.send END");
        }
        this;
        JVM INSTR monitorenter ;
        setRunning(false);
        if (isCancelled())
        {
            close();
        }
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        Log.v("Amazon.SSOUtil", stringbuilder.toString());
        throw abyte0;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
    }
}
