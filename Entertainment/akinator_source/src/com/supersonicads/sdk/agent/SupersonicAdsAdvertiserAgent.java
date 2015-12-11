// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.agent;

import android.content.Context;
import android.text.TextUtils;
import com.supersonicads.sdk.SSAAdvertiserTest;
import com.supersonicads.sdk.data.SSAObj;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SDKUtils;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;

public class SupersonicAdsAdvertiserAgent
    implements SSAAdvertiserTest
{
    private class Result
    {

        private int mResponseCode;
        private String mResponseString;
        final SupersonicAdsAdvertiserAgent this$0;

        public int getResponseCode()
        {
            return mResponseCode;
        }

        public String getResponseString()
        {
            return mResponseString;
        }

        public void setResponseCode(int i)
        {
            mResponseCode = i;
        }

        public void setResponseString(String s)
        {
            mResponseString = s;
        }

        public Result()
        {
            this$0 = SupersonicAdsAdvertiserAgent.this;
            super();
        }

        public Result(int i, String s)
        {
            this$0 = SupersonicAdsAdvertiserAgent.this;
            super();
            setResponseCode(i);
            setResponseString(s);
        }
    }

    public static final class SuperSonicAdsAdvertiserException extends RuntimeException
    {

        private static final long serialVersionUID = 0x715ec0528ac5af19L;

        public SuperSonicAdsAdvertiserException(Throwable throwable)
        {
            super(throwable);
        }
    }


    private static final String BUNDLE_ID = "bundleId";
    private static final String DEVICE_IDS = "deviceIds";
    private static final String DOMAIN = "/campaigns/onLoad?";
    private static String PACKAGE_NAME = null;
    private static String SERVICE_HOST_NAME = "www.supersonicads.com";
    private static int SERVICE_PORT = 0;
    private static String SERVICE_PROTOCOL = "http";
    private static final String SIGNATURE = "signature";
    private static final String TAG = "SupersonicAdsAdvertiserAgent";
    private static String TIME_API = "http://www.supersonicads.com/timestamp.php";
    public static SupersonicAdsAdvertiserAgent sInstance;

    private SupersonicAdsAdvertiserAgent()
    {
    }

    public static SupersonicAdsAdvertiserAgent getInstance()
    {
        com/supersonicads/sdk/agent/SupersonicAdsAdvertiserAgent;
        JVM INSTR monitorenter ;
        SupersonicAdsAdvertiserAgent supersonicadsadvertiseragent;
        Logger.i("SupersonicAdsAdvertiserAgent", "getInstance()");
        if (sInstance == null)
        {
            sInstance = new SupersonicAdsAdvertiserAgent();
        }
        supersonicadsadvertiseragent = sInstance;
        com/supersonicads/sdk/agent/SupersonicAdsAdvertiserAgent;
        JVM INSTR monitorexit ;
        return supersonicadsadvertiseragent;
        Exception exception;
        exception;
        throw exception;
    }

    private String getRequestParameters(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        String s1;
        StringBuilder stringbuilder1;
        boolean flag;
        if (TextUtils.isEmpty(PACKAGE_NAME))
        {
            s = SDKUtils.getPackageName(context);
        } else
        {
            s = PACKAGE_NAME;
        }
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append("&").append("bundleId").append("=").append(SDKUtils.encodeString(s));
        }
        SDKUtils.loadGoogleAdvertiserInfo(context);
        s1 = SDKUtils.getAdvertiserId();
        flag = SDKUtils.isLimitAdTrackingEnabled();
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append("&").append("deviceIds").append(SDKUtils.encodeString("[")).append(SDKUtils.encodeString("AID")).append(SDKUtils.encodeString("]")).append("=").append(SDKUtils.encodeString(s1));
            stringbuilder.append("&").append(SDKUtils.encodeString("isLimitAdTrackingEnabled")).append("=").append(SDKUtils.encodeString(Boolean.toString(flag)));
        } else
        {
            s1 = "";
        }
        stringbuilder1 = new StringBuilder();
        stringbuilder1.append(s);
        stringbuilder1.append(s1);
        stringbuilder1.append(getUTCTimeStamp(context));
        context = SDKUtils.getMD5(stringbuilder1.toString());
        stringbuilder.append("&").append("signature").append("=").append(context);
        return stringbuilder.toString();
    }

    private int getUTCTimeStamp(Context context)
    {
        int i;
        context = performRequest(new URL(TIME_API), context);
        if (context.getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        context = new SSAObj(context.getResponseString());
        if (!context.containsKey("timestamp"))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        i = Integer.parseInt(context.getString("timestamp"));
        return i - i % 60;
        context;
        return 0;
    }

    public void clearReportApp(Context context)
    {
        SupersonicSharedPrefHelper.getSupersonicPrefHelper(context).setReportAppStarted(false);
    }

    public Result performRequest(URL url, Context context)
    {
        Object obj;
        byte abyte0[];
        Object obj1;
        Object obj3;
        Context context1;
        Context context2;
        Context context3;
        Context context4;
        Object obj4;
        Context context5;
        InputStream inputstream;
        InputStream inputstream1;
        InputStream inputstream2;
        InputStream inputstream3;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Result result;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        result = new Result();
        obj15 = null;
        obj16 = null;
        obj17 = null;
        obj18 = null;
        obj19 = null;
        context = null;
        flag = false;
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        i = 0;
        abyte0 = null;
        obj11 = null;
        obj12 = null;
        obj13 = null;
        obj14 = null;
        obj = null;
        obj6 = null;
        obj7 = null;
        obj8 = null;
        obj9 = null;
        obj5 = null;
        obj10 = null;
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = obj15;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = obj16;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = obj17;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = obj18;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = obj19;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        url.toURI();
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = obj15;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = obj16;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = obj17;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = obj18;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = obj19;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        context = (HttpURLConnection)url.openConnection();
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = context;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = context;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = context;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = context;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        context.setRequestMethod("GET");
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = context;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = context;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = context;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = context;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        context.setConnectTimeout(5000);
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = context;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = context;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = context;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = context;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        context.setReadTimeout(5000);
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = context;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = context;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = context;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = context;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        context.connect();
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = abyte0;
        k = ((flag) ? 1 : 0);
        context3 = context;
        inputstream2 = obj11;
        l = ((flag1) ? 1 : 0);
        context4 = context;
        inputstream3 = obj12;
        i1 = ((flag2) ? 1 : 0);
        obj1 = context;
        obj4 = obj13;
        j1 = ((flag3) ? 1 : 0);
        context5 = context;
        obj3 = obj14;
        k1 = ((flag4) ? 1 : 0);
        i = context.getResponseCode();
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = abyte0;
        k = i;
        context3 = context;
        inputstream2 = obj11;
        l = i;
        context4 = context;
        inputstream3 = obj12;
        i1 = i;
        obj1 = context;
        obj4 = obj13;
        j1 = i;
        context5 = context;
        obj3 = obj14;
        k1 = i;
        obj = context.getInputStream();
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = ((InputStream) (obj));
        k = i;
        context3 = context;
        inputstream2 = ((InputStream) (obj));
        l = i;
        context4 = context;
        inputstream3 = ((InputStream) (obj));
        i1 = i;
        obj1 = context;
        obj4 = obj;
        j1 = i;
        context5 = context;
        obj3 = obj;
        k1 = i;
        abyte0 = new byte[0x19000];
        context1 = context;
        inputstream = ((InputStream) (obj));
        j = i;
        context2 = context;
        inputstream1 = ((InputStream) (obj));
        k = i;
        context3 = context;
        inputstream2 = ((InputStream) (obj));
        l = i;
        context4 = context;
        inputstream3 = ((InputStream) (obj));
        i1 = i;
        obj1 = context;
        obj4 = obj;
        j1 = i;
        context5 = context;
        obj3 = obj;
        k1 = i;
        StringBuilder stringbuilder = new StringBuilder();
        obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
_L3:
        obj3 = ((BufferedReader) (obj1)).readLine();
        if (obj3 == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append((new StringBuilder()).append(((String) (obj3))).append("\n").toString());
          goto _L3
        obj1;
        context5 = context;
        context = stringbuilder;
_L15:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context5 != null)
        {
            context5.disconnect();
        }
        result.setResponseCode(i);
        if (context == null)
        {
            result.setResponseString("empty");
            return result;
        } else
        {
            result.setResponseString(context.toString());
            return result;
        }
_L2:
        if (false);
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context != null)
        {
            context.disconnect();
        }
        result.setResponseCode(i);
        if (stringbuilder == null)
        {
            result.setResponseString("empty");
            return result;
        } else
        {
            result.setResponseString(stringbuilder.toString());
            return result;
        }
        context;
        i = j;
        obj = inputstream;
        context = context1;
        stringbuilder = obj6;
_L13:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context != null)
        {
            context.disconnect();
        }
        result.setResponseCode(i);
        if (stringbuilder == null)
        {
            result.setResponseString("empty");
            return result;
        } else
        {
            result.setResponseString(stringbuilder.toString());
            return result;
        }
        context;
        i = k;
        obj = inputstream1;
        context = context2;
        stringbuilder = obj7;
_L11:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context != null)
        {
            context.disconnect();
        }
        result.setResponseCode(i);
        if (stringbuilder == null)
        {
            result.setResponseString("empty");
            return result;
        } else
        {
            result.setResponseString(stringbuilder.toString());
            return result;
        }
        context;
        i = l;
        obj = inputstream2;
        context = context3;
        stringbuilder = obj8;
_L9:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context != null)
        {
            context.disconnect();
        }
        result.setResponseCode(i);
        if (stringbuilder == null)
        {
            result.setResponseString("empty");
            return result;
        } else
        {
            result.setResponseString(stringbuilder.toString());
            return result;
        }
        context;
        i = i1;
        obj = inputstream3;
        context = context4;
        stringbuilder = obj9;
_L7:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context != null)
        {
            context.disconnect();
        }
        result.setResponseCode(i);
        if (stringbuilder == null)
        {
            result.setResponseString("empty");
            return result;
        } else
        {
            result.setResponseString(stringbuilder.toString());
            return result;
        }
        obj;
        i = j1;
        context = ((Context) (obj1));
        stringbuilder = obj5;
_L5:
        if (obj4 != null)
        {
            try
            {
                ((InputStream) (obj4)).close();
            }
            catch (IOException ioexception) { }
        }
        if (i != 200)
        {
            Logger.i("SupersonicAdsAdvertiserAgent", (new StringBuilder()).append(" RESPONSE CODE: ").append(i).append(" URL: ").append(url).toString());
        }
        if (context != null)
        {
            context.disconnect();
        }
        result.setResponseCode(i);
        if (stringbuilder == null)
        {
            result.setResponseString("empty");
        } else
        {
            result.setResponseString(stringbuilder.toString());
        }
        throw obj;
        Object obj2;
        obj2;
        obj4 = obj;
        obj = obj2;
        if (true) goto _L5; else goto _L4
_L4:
        obj2;
        if (true) goto _L7; else goto _L6
_L6:
        obj2;
        if (true) goto _L9; else goto _L8
_L8:
        obj2;
        if (true) goto _L11; else goto _L10
_L10:
        obj2;
        if (true) goto _L13; else goto _L12
_L12:
        context;
        context = obj10;
        obj = obj3;
        i = k1;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public void reportAppStarted(final Context context)
    {
        if (SupersonicSharedPrefHelper.getSupersonicPrefHelper(context).getReportAppStarted())
        {
            return;
        } else
        {
            (new Thread(new Runnable() {

                final SupersonicAdsAdvertiserAgent this$0;
                final Context val$context;

                public void run()
                {
                    Object obj = getRequestParameters(context);
                    obj = (new StringBuilder()).append("/campaigns/onLoad?").append(((String) (obj))).toString();
                    try
                    {
                        obj = new URL(SupersonicAdsAdvertiserAgent.SERVICE_PROTOCOL, SupersonicAdsAdvertiserAgent.SERVICE_HOST_NAME, SupersonicAdsAdvertiserAgent.SERVICE_PORT, ((String) (obj)));
                        if (performRequest(((URL) (obj)), context).getResponseCode() == 200)
                        {
                            SupersonicSharedPrefHelper.getSupersonicPrefHelper(context).setReportAppStarted(true);
                        }
                        return;
                    }
                    catch (MalformedURLException malformedurlexception)
                    {
                        return;
                    }
                }

            
            {
                this$0 = SupersonicAdsAdvertiserAgent.this;
                context = context1;
                super();
            }
            })).start();
            return;
        }
    }

    public void setDomain(String s, String s1, int i)
    {
        SERVICE_PROTOCOL = s;
        SERVICE_HOST_NAME = s1;
        SERVICE_PORT = i;
    }

    public void setPackageName(String s)
    {
        PACKAGE_NAME = s;
    }

    public void setTimeAPI(String s)
    {
        TIME_API = s;
    }

    static 
    {
        SERVICE_PORT = 80;
    }




}
