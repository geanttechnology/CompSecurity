// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, DatapointHelper, BaseHandler, Constants

abstract class BaseUploadThread extends Thread
{

    String customerID;
    final TreeMap mData;
    LocalyticsDao mLocalyticsDao;
    private final BaseHandler mSessionHandler;
    private String uploadResponseString;

    BaseUploadThread(BaseHandler basehandler, TreeMap treemap, String s, LocalyticsDao localyticsdao)
    {
        uploadResponseString = null;
        mSessionHandler = basehandler;
        mData = treemap;
        customerID = s;
        mLocalyticsDao = localyticsdao;
    }

    static URLConnection createURLConnection(URL url, Proxy proxy)
    {
        if (proxy == null)
        {
            return url.openConnection();
        } else
        {
            return url.openConnection(proxy);
        }
    }

    private static String formatUploadBody(String s)
    {
        String s1;
        try
        {
            s1 = (new JSONObject(s)).toString(3);
        }
        catch (Exception exception)
        {
            return s;
        }
        return s1;
    }

    private void retrieveHttpResponse(InputStream inputstream)
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        Object obj = new StringBuilder();
        do
        {
            String s = inputstream.readLine();
            if (s == null)
            {
                break;
            }
            ((StringBuilder) (obj)).append(s);
        } while (true);
        obj = ((StringBuilder) (obj)).toString();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            onUploadResponded(((String) (obj)));
        }
        inputstream.close();
    }

    String getApiKey()
    {
        String s = mLocalyticsDao.getApiKey();
        String s1 = DatapointHelper.getLocalyticsRollupKeyOrNull(mLocalyticsDao.getAppContext());
        if (s1 != null && !TextUtils.isEmpty(s1))
        {
            return s1;
        } else
        {
            return s;
        }
    }

    void onUploadResponded(String s)
    {
        Localytics.Log.w(String.format("%s upload response: \n%s", new Object[] {
            mSessionHandler.siloName, s
        }));
        uploadResponseString = s;
    }

    public void run()
    {
        int i = uploadData();
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(i), uploadResponseString
        }))));
        return;
        Exception exception;
        exception;
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(0), uploadResponseString
        }))));
        throw exception;
    }

    boolean upload(UploadType uploadtype, String s, String s1, int i)
    {
        return upload(uploadtype, s, s1, i, false);
    }

    boolean upload(UploadType uploadtype, String s, String s1, int i, boolean flag)
    {
        Object obj;
        Object obj1;
        OutputStream outputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        int j;
        boolean flag1;
        if (s == null)
        {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("body cannot be null");
        }
        byte abyte0[];
        Proxy proxy;
        if (uploadtype == UploadType.ANALYTICS)
        {
            Localytics.Log.v(String.format("Analytics upload body before compression is: \n%s", new Object[] {
                s1
            }));
        } else
        if (uploadtype == UploadType.PROFILES)
        {
            Localytics.Log.v(String.format("Profile upload body is: \n%s", new Object[] {
                formatUploadBody(s1)
            }));
        }
        obj = null;
        outputstream = null;
        obj1 = obj;
        abyte0 = s1.getBytes("UTF-8");
        obj1 = obj;
        if (uploadtype != UploadType.ANALYTICS) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        bytearrayoutputstream = new ByteArrayOutputStream(abyte0.length);
        obj1 = obj;
        obj = new GZIPOutputStream(bytearrayoutputstream);
        obj1 = obj;
        ((GZIPOutputStream) (obj)).write(abyte0);
        obj1 = obj;
        ((GZIPOutputStream) (obj)).finish();
        obj1 = obj;
        if (DatapointHelper.getApiLevel() >= 19)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj1 = obj;
        ((GZIPOutputStream) (obj)).flush();
        obj1 = obj;
        abyte0 = bytearrayoutputstream.toByteArray();
_L22:
        if (obj != null)
        {
            try
            {
                ((GZIPOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        bytearrayoutputstream = null;
        obj = null;
        outputstream = null;
        obj1 = obj;
        proxy = mLocalyticsDao.getProxy();
        obj1 = obj;
        obj = (HttpURLConnection)createURLConnection(new URL(s), proxy);
        ((HttpURLConnection) (obj)).setConnectTimeout(60000);
        ((HttpURLConnection) (obj)).setReadTimeout(60000);
        if (uploadtype != UploadType.MARKETING)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((HttpURLConnection) (obj)).setDoOutput(flag1);
        if (uploadtype != UploadType.ANALYTICS) goto _L4; else goto _L3
_L3:
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/x-gzip");
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Encoding", "gzip");
        ((HttpURLConnection) (obj)).setRequestProperty("X-DONT-SEND-AMP", "1");
_L7:
        if (uploadtype == UploadType.MARKETING && Constants.isTestModeEnabled())
        {
            ((HttpURLConnection) (obj)).setRequestProperty("AMP-Test-Mode", "1");
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_323;
        }
        ((HttpURLConnection) (obj)).setRequestProperty("X-NO-DELAY", "1");
        ((HttpURLConnection) (obj)).setRequestProperty("Accept-Encoding", "");
        ((HttpURLConnection) (obj)).setRequestProperty("x-upload-time", Long.toString(Math.round((double)System.currentTimeMillis() / 1000D)));
        ((HttpURLConnection) (obj)).setRequestProperty("x-install-id", mLocalyticsDao.getInstallationId());
        ((HttpURLConnection) (obj)).setRequestProperty("x-app-id", mLocalyticsDao.getApiKey());
        ((HttpURLConnection) (obj)).setRequestProperty("x-client-version", "androida_3.4.0");
        ((HttpURLConnection) (obj)).setRequestProperty("x-app-version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        ((HttpURLConnection) (obj)).setRequestProperty("x-customer-id", customerID);
        if (uploadtype == UploadType.MARKETING)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        ((HttpURLConnection) (obj)).setFixedLengthStreamingMode(abyte0.length);
        obj1 = null;
        outputstream = ((HttpURLConnection) (obj)).getOutputStream();
        obj1 = outputstream;
        outputstream.write(abyte0);
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        outputstream.flush();
        outputstream.close();
        j = ((HttpURLConnection) (obj)).getResponseCode();
        Localytics.Log.v(String.format("%s upload complete with status %d", new Object[] {
            mSessionHandler.siloName, Integer.valueOf(j)
        }));
        if (j != 429) goto _L6; else goto _L5
_L5:
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        flag = false;
_L11:
        return flag;
        uploadtype;
        obj = null;
_L20:
        obj1 = obj;
        Localytics.Log.w("UnsupportedEncodingException", uploadtype);
        if (obj != null)
        {
            try
            {
                ((GZIPOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        return false;
        s;
        uploadtype = outputstream;
_L19:
        obj1 = uploadtype;
        Localytics.Log.w("IOException", s);
        if (uploadtype != null)
        {
            try
            {
                uploadtype.close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        return false;
        uploadtype;
_L18:
        if (obj1 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        throw uploadtype;
_L4:
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/json; charset=utf-8");
          goto _L7
        obj1;
_L17:
        if (i != 2) goto _L9; else goto _L8
_L8:
        Localytics.Log.w("ClientProtocolException", ((Throwable) (obj1)));
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        return false;
        Exception exception;
        exception;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_753;
        }
        ((OutputStream) (obj1)).flush();
        ((OutputStream) (obj1)).close();
        throw exception;
        s;
        uploadtype = ((UploadType) (obj));
_L16:
        obj1 = uploadtype;
        Localytics.Log.w("ClientProtocolException", s);
        if (uploadtype != null)
        {
            uploadtype.disconnect();
        }
        return false;
_L6:
        if (j >= 400 && j <= 499)
        {
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            return true;
        }
        if (j >= 500 && j <= 599)
        {
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            return false;
        }
        retrieveHttpResponse(((HttpURLConnection) (obj)).getInputStream());
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        return true;
_L9:
        flag1 = upload(uploadtype, s, s1, i + 1, flag);
        flag = flag1;
        if (obj == null) goto _L11; else goto _L10
_L10:
        ((HttpURLConnection) (obj)).disconnect();
        return flag1;
        s;
        uploadtype = bytearrayoutputstream;
_L15:
        obj1 = uploadtype;
        Localytics.Log.w("ClientProtocolException", s);
        if (uploadtype != null)
        {
            uploadtype.disconnect();
        }
        return false;
        uploadtype;
_L13:
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        throw uploadtype;
        uploadtype;
        obj1 = obj;
        continue; /* Loop/switch isn't completed */
        uploadtype;
        obj1 = obj;
        if (true) goto _L13; else goto _L12
_L12:
        s;
        uploadtype = ((UploadType) (obj));
        if (true) goto _L15; else goto _L14
_L14:
        s;
        uploadtype = outputstream;
          goto _L16
        obj1;
        obj = null;
          goto _L17
        uploadtype;
          goto _L18
        s;
        uploadtype = ((UploadType) (obj));
          goto _L19
        uploadtype;
          goto _L20
_L2:
        obj = null;
        if (true) goto _L22; else goto _L21
_L21:
    }

    abstract int uploadData();

    private class UploadType extends Enum
    {

        private static final UploadType $VALUES[];
        public static final UploadType ANALYTICS;
        public static final UploadType MARKETING;
        public static final UploadType PROFILES;

        public static UploadType valueOf(String s)
        {
            return (UploadType)Enum.valueOf(com/localytics/android/BaseUploadThread$UploadType, s);
        }

        public static UploadType[] values()
        {
            return (UploadType[])$VALUES.clone();
        }

        static 
        {
            ANALYTICS = new UploadType("ANALYTICS", 0);
            PROFILES = new UploadType("PROFILES", 1);
            MARKETING = new UploadType("MARKETING", 2);
            $VALUES = (new UploadType[] {
                ANALYTICS, PROFILES, MARKETING
            });
        }

        private UploadType(String s, int i)
        {
            super(s, i);
        }
    }

}
