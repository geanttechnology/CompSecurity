// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.digimarc.dms.DMSCpmBase;
import com.digimarc.dms.barcodereader.QRCodeResolver;
import com.digimarc.dms.imagereader.Payload;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms.resolver:
//            DigimarcEncoder, ResolveItem, Payoff, StandardPayoff, 
//            PayoffContainer, ResolverServiceHandler

class DigimarcResolver
{

    private static String TAG = "DiscoverResolver";
    private static String mAppName = null;
    private static String mAppVersion;
    private static final String mSdkVersion = "1.8.0.20150408143830";
    private final String DEVICEID_HASHKEY = "649091556682846";
    private final String googleSearch = "https://www.google.com/search?q=%s&amp;tbm=shop";
    private String mBaseUrl;
    private Context mContext;
    private final String mPassword;
    private String mPath;
    private final String mServer;
    private final String mUserName;

    DigimarcResolver(Context context, ResolverServiceHandler resolverservicehandler, String s, String s1, boolean flag, String s2)
    {
        mPath = "/api/v2/";
        mUserName = s;
        mPassword = s1;
        mContext = context;
        mServer = s2;
        if (flag)
        {
            mBaseUrl = "http://labs-resolver.digimarc.net";
            return;
        }
        if (mServer != null)
        {
            try
            {
                context = new URL(s2);
                mBaseUrl = (new StringBuilder()).append(context.getProtocol()).append("://").append(context.getHost()).toString();
                mPath = (new StringBuilder()).append(context.getPath()).append(mPath).toString();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                mBaseUrl = mServer;
            }
            context.printStackTrace();
            return;
        } else
        {
            mBaseUrl = "http://resolver.digimarc.net";
            return;
        }
    }

    private JSONObject buildDeviceInfo(ResolveItem resolveitem)
    {
        JSONObject jsonobject = new JSONObject();
        Object obj = mContext.getResources();
        resolveitem = (TelephonyManager)mContext.getSystemService("phone");
        getAppInfo(mContext);
        String s = resolveitem.getDeviceId();
        resolveitem = s;
        if (s == null)
        {
            resolveitem = getMacAddress();
        }
        String s1;
        String s2;
        Locale locale;
        if (resolveitem == null)
        {
            resolveitem = "None";
        } else
        {
            resolveitem = DigimarcEncoder.encodeString(resolveitem, "649091556682846", DigimarcEncoder.ALGORITHM_TYPE.SHA256);
        }
        locale = ((Resources) (obj)).getConfiguration().locale;
        obj = getManufacturer();
        s = ((String) (obj));
        if (obj == null)
        {
            s = "None";
        }
        s1 = Build.MODEL;
        obj = s1;
        if (s1 == null)
        {
            obj = "None";
        }
        s2 = Integer.toString(android.os.Build.VERSION.SDK_INT);
        s1 = s2;
        if (s2 == null)
        {
            s1 = "None";
        }
        try
        {
            jsonobject.put("DeviceIdentifier", resolveitem);
            jsonobject.put("SystemName", "Android");
            jsonobject.put("SystemVersion", s1);
            jsonobject.put("Manufacturer", s);
            jsonobject.put("Model", obj);
            jsonobject.put("Latitude", "");
            jsonobject.put("Longitude", "");
            jsonobject.put("Language", locale);
            jsonobject.put("AppName", mAppName);
            jsonobject.put("AppVersion", mAppVersion);
        }
        // Misplaced declaration of an exception variable
        catch (ResolveItem resolveitem)
        {
            resolveitem.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    private void buildHttpPost(HttpPost httppost, String s, String s1)
    {
        int i = 0;
        Object obj = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.US);
        simpledateformat.setCalendar(Calendar.getInstance(new SimpleTimeZone(0, "GMT"), Locale.US));
        obj = simpledateformat.format(((Date) (obj)));
        obj = (new StringBuilder()).append(((String) (obj))).append(" GMT").toString();
        if (s1 != null)
        {
            httppost.setEntity(new StringEntity(s1, "UTF-8"));
            i = (int)httppost.getEntity().getContentLength();
        }
        httppost.setHeader("Content-Type", "application/json; charset=utf-8");
        httppost.setHeader("Date", ((String) (obj)));
        s1 = new StringBuilder();
        s1.append(((String) (obj)));
        s1.append("\n");
        s1.append("application/json; charset=utf-8");
        s1.append("\n");
        s1.append(String.valueOf(i));
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("POST");
        ((StringBuilder) (obj)).append("\n");
        ((StringBuilder) (obj)).append(s1.toString());
        ((StringBuilder) (obj)).append("\n");
        ((StringBuilder) (obj)).append(s);
        httppost.setHeader("Authorization", (new StringBuilder()).append(mUserName).append(":").append(DigimarcEncoder.encodeString(((StringBuilder) (obj)).toString(), mPassword, DigimarcEncoder.ALGORITHM_TYPE.SHA512)).toString());
        httppost.setHeader("Cache-Control", "no-transform");
        httppost.addHeader("Accept-Encoding", "gzip");
    }

    private String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    public static void getAppInfo(Context context)
    {
        mAppName = "Unknown";
        mAppVersion = "Unknown";
        Object obj;
        try
        {
            obj = context.getPackageName();
            context = context.getPackageManager();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (obj == null || context == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        mAppVersion = context.getPackageInfo(((String) (obj)), 0).versionName;
        obj = context.getApplicationInfo(((String) (obj)), 0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        mAppName = context.getApplicationLabel(((android.content.pm.ApplicationInfo) (obj))).toString();
    }

    public static String getAppName()
    {
        return mAppName;
    }

    public static String getAppVersion()
    {
        return mAppVersion;
    }

    private String getMacAddress()
    {
        WifiInfo wifiinfo = ((WifiManager)mContext.getSystemService("wifi")).getConnectionInfo();
        if (wifiinfo != null)
        {
            return wifiinfo.getMacAddress();
        } else
        {
            return null;
        }
    }

    private String getManufacturer()
    {
        String s1 = "Unknown";
        String s;
        Object obj;
        try
        {
            obj = Class.forName("android.os.Build");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            classnotfoundexception.printStackTrace();
            return "Unknown";
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            nosuchfieldexception.printStackTrace();
            return "Unknown";
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
            return "Unknown";
        }
        s = s1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = ((Class) (obj)).getField("MANUFACTURER");
        s = s1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        s = ((Field) (obj)).get(null).toString();
        return s;
    }

    public static String getSdkVersion()
    {
        return "1.8.0.20150408143830";
    }

    private boolean isResolvable(ResolveItem resolveitem)
    {
        resolveitem = new DMSCpmBase(resolveitem.getPayload().getCpmPath());
        return !resolveitem.isQRCode() && !resolveitem.isCode39() && !resolveitem.isCode128();
    }

    private String reformatForResolve(String s)
    {
        DMSCpmBase dmscpmbase = new DMSCpmBase(s);
        Object obj = s;
        if (dmscpmbase.isBarCode())
        {
            obj = s;
            if (!dmscpmbase.isCode39())
            {
                obj = s;
                if (!dmscpmbase.isCode128())
                {
                    s = s.split("[.]");
                    obj = new StringBuilder();
                    int i = 0;
                    while (i < s.length) 
                    {
                        if (i == s.length - 1)
                        {
                            String s1 = s[s.length - 1];
                            StringBuilder stringbuilder = new StringBuilder();
                            for (int j = 0; j < s1.length(); j++)
                            {
                                stringbuilder.append(String.format("%02X", new Object[] {
                                    Integer.valueOf(s1.charAt(j))
                                }));
                            }

                            ((StringBuilder) (obj)).append(stringbuilder.toString());
                        } else
                        {
                            ((StringBuilder) (obj)).append(s[i]);
                            ((StringBuilder) (obj)).append(".");
                        }
                        i++;
                    }
                    (new StringBuilder("Resolving CPM Path: ")).append(((StringBuilder) (obj)).toString());
                    obj = ((StringBuilder) (obj)).toString();
                }
            }
        }
        return ((String) (obj));
    }

    private PayoffContainer simulateResolver(ResolveItem resolveitem)
    {
        Object obj;
        DMSCpmBase dmscpmbase;
        dmscpmbase = new DMSCpmBase(resolveitem.getPayload().getCpmPath());
        obj = dmscpmbase.getId();
        if (!dmscpmbase.isCode39() && !dmscpmbase.isCode128()) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        String s1 = dmscpmbase.getId();
        obj1 = dmscpmbase.getProtocol();
        String s;
        int i;
        try
        {
            obj2 = String.format("https://www.google.com/search?q=%s&amp;tbm=shop", new Object[] {
                URLEncoder.encode(s1, "UTF-8")
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            ((UnsupportedEncodingException) (obj2)).printStackTrace();
            obj2 = obj;
            obj = obj1;
            obj1 = obj2;
            obj2 = s1;
            continue; /* Loop/switch isn't completed */
        }
        obj = obj2;
        s = ((String) (obj1));
        obj2 = s1;
        obj1 = obj;
        obj = s;
_L4:
        obj = new Payoff(((String) (obj2)), ((String) (obj)), null, null);
        obj.mCorrelationKey = dmscpmbase.getCpmPath();
        obj.mSynthesizedContent = true;
        obj.mThumbnailUrl = "";
        obj.mThumbnailFocalPt = null;
        obj = new StandardPayoff(((Payoff) (obj)), ((String) (obj1)), ((String) (obj2)), ((String) (obj2)), "");
        i = (int)(new Date()).getTime();
        return new PayoffContainer(resolveitem.getPayload(), "RESOLVED", ((Payoff) (obj)), i);
_L2:
        if (dmscpmbase.isQRCode())
        {
            obj2 = dmscpmbase.getId();
            obj1 = obj;
            if (!(new QRCodeResolver(((String) (obj2)))).isWebUri.booleanValue())
            {
                try
                {
                    obj1 = String.format("https://www.google.com/search?q=%s&amp;tbm=shop", new Object[] {
                        URLEncoder.encode(((String) (obj2)), "UTF-8")
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    ((UnsupportedEncodingException) (obj1)).printStackTrace();
                    obj1 = obj;
                }
            }
            obj = dmscpmbase.getProtocol();
        } else
        {
            obj1 = obj;
            obj2 = null;
            obj = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    String getVersion()
    {
        return "1.8.0.20150408143830";
    }

    int reportAction(String s)
    {
        StringBuilder stringbuilder1 = new StringBuilder();
        stringbuilder1.append(mPath);
        stringbuilder1.append("action/");
        stringbuilder1.append(s);
        StringBuilder stringbuilder = new StringBuilder(mBaseUrl);
        stringbuilder.append(stringbuilder1.toString());
        int i;
        try
        {
            (new StringBuilder("Reporting action\nToken: ")).append(s).append("\nFull URL: ").append(stringbuilder.toString());
            s = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(stringbuilder.toString());
            buildHttpPost(httppost, stringbuilder1.toString(), null);
            s = s.execute(httppost).getStatusLine();
            if (s.getStatusCode() != 200)
            {
                Log.e(TAG, (new StringBuilder("Error reporting action. Http Status Code = ")).append(String.valueOf(s.getStatusCode())).toString());
            }
            i = s.getStatusCode();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return -1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, (new StringBuilder("Illegal argument in report action URL: ")).append(stringbuilder.toString()).toString());
            return -1;
        }
        return i;
    }

    PayoffContainer resolve(ResolveItem resolveitem)
    {
        if (isResolvable(resolveitem)) goto _L2; else goto _L1
_L1:
        Object obj = simulateResolver(resolveitem);
_L4:
        return ((PayoffContainer) (obj));
_L2:
        Payload payload;
        DefaultHttpClient defaulthttpclient;
        Object obj1;
        payload = resolveitem.getPayload();
        obj = new StringBuilder(mPath);
        ((StringBuilder) (obj)).append("payoffcpm/");
        ((StringBuilder) (obj)).append(reformatForResolve(payload.getCpmPath()));
        ((StringBuilder) (obj)).append((new StringBuilder("?clientdata=")).append(getVersion()).toString());
        obj1 = new StringBuilder(mBaseUrl);
        ((StringBuilder) (obj1)).append(((StringBuilder) (obj)).toString());
        (new StringBuilder("Resolver query URL:")).append(obj1);
        defaulthttpclient = new DefaultHttpClient();
        long l;
        obj1 = new HttpPost(((StringBuilder) (obj1)).toString());
        resolveitem = buildDeviceInfo(resolveitem).toString();
        buildHttpPost(((HttpPost) (obj1)), ((StringBuilder) (obj)).toString(), resolveitem);
        l = System.currentTimeMillis();
        obj = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        l = System.currentTimeMillis() - l;
        resolveitem = ((HttpResponse) (obj)).getStatusLine();
        if (resolveitem.getStatusCode() != 200)
        {
            Log.e(TAG, (new StringBuilder("Error in resolve(), check your resolver credentials.  Http Status Code = ")).append(String.valueOf(resolveitem.getStatusCode())).toString());
            return PayoffContainer.parsePayoffJson(null, payload, (int)l);
        }
        resolveitem = ((HttpResponse) (obj)).getEntity();
        if (resolveitem != null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        return PayoffContainer.parsePayoffJson(null, payload, (int)l);
        resolveitem = resolveitem.getContent();
        obj = ((HttpResponse) (obj)).getFirstHeader("Content-Encoding");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        if (((Header) (obj)).getValue().equalsIgnoreCase("gzip"))
        {
            resolveitem = new GZIPInputStream(resolveitem);
        }
        obj = convertStreamToString(resolveitem);
        resolveitem.close();
        resolveitem = PayoffContainer.parsePayoffJson(((String) (obj)), payload, (int)l);
_L5:
        obj = resolveitem;
        if (resolveitem == null)
        {
            return PayoffContainer.parsePayoffJson(null, payload, 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
        resolveitem;
        resolveitem.printStackTrace();
        resolveitem = null;
          goto _L5
        resolveitem;
        resolveitem.printStackTrace();
        resolveitem = null;
          goto _L5
        resolveitem;
        resolveitem.printStackTrace();
        resolveitem = null;
          goto _L5
        resolveitem;
        resolveitem = null;
          goto _L5
    }

}
