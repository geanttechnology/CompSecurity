// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mobileapptracker:
//            MATParameters, MATResponse, MATEvent, c, 
//            e, MATEventItem, MATTestRequest, b, 
//            f, MATEncryption, MATEventQueue, g, 
//            ac, r, an, ao, 
//            aj, ak, ap, aq, 
//            ar, as, h, i, 
//            j, al, k, am, 
//            l, m, n, o, 
//            p, q, s, t, 
//            u, v, w, x, 
//            y, z, a, ai, 
//            aa, ab, ad, ae, 
//            af, ag, ah, MATPreloadData

public class MobileAppTracker
{

    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    private static volatile MobileAppTracker f = null;
    private final String a = "heF9BATUfWuISyO8";
    private b b;
    private f c;
    private MATEncryption d;
    private boolean e;
    protected MATEventQueue eventQueue;
    protected boolean fbLogging;
    protected boolean firstInstall;
    protected boolean firstSession;
    protected boolean gotGaid;
    protected boolean gotReferrer;
    protected long initTime;
    protected boolean initialized;
    protected boolean isRegistered;
    protected Context mContext;
    protected MATPreloadData mPreloadData;
    protected MATTestRequest matRequest;
    protected MATResponse matResponse;
    protected BroadcastReceiver networkStateReceiver;
    protected boolean notifiedPool;
    protected MATParameters params;
    protected ExecutorService pool;
    protected ExecutorService pubQueue;
    protected long referrerTime;

    protected MobileAppTracker()
    {
    }

    private String a(int i1)
    {
        Object obj;
        Object obj2;
        obj = "";
        for (long l1 = System.currentTimeMillis(); !gotReferrer && System.currentTimeMillis() - l1 <= (long)i1;)
        {
            try
            {
                Thread.sleep(50L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }

        obj2 = obj;
        if (!gotReferrer) goto _L2; else goto _L1
_L1:
        Object obj1;
        int j1;
        obj2 = params.getInstallReferrer();
        obj1 = obj;
        try
        {
            i1 = ((String) (obj2)).indexOf("mat_deeplink=");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return ((String) (obj1));
        }
        if (i1 == -1)
        {
            return "";
        }
        i1 += 13;
        obj1 = obj;
        j1 = ((String) (obj2)).indexOf("&", i1);
        if (j1 != -1) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        obj = ((String) (obj2)).substring(i1);
_L5:
        obj1 = obj;
        obj2 = obj;
        if (((String) (obj)).length() == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        if (matResponse == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        obj1 = obj;
        matResponse.didReceiveDeeplink(((String) (obj)));
        obj1 = obj;
        obj2 = new Intent("android.intent.action.VIEW");
        obj1 = obj;
        ((Intent) (obj2)).setData(Uri.parse(((String) (obj))));
        obj1 = obj;
        ((Intent) (obj2)).setFlags(0x10000000);
        obj1 = obj;
        mContext.startActivity(((Intent) (obj2)));
        return ((String) (obj));
_L4:
        obj1 = obj;
        obj = ((String) (obj2)).substring(i1, j1);
        if (true) goto _L5; else goto _L2
_L2:
        return ((String) (obj2));
    }

    private void a(MATEvent matevent)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = initialized;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        String s2;
        Object obj1;
        dumpQueue();
        params.setAction("conversion");
        obj = new Date();
        if (matevent.getEventName() != null)
        {
            String s1 = matevent.getEventName();
            if (fbLogging)
            {
                com.mobileapptracker.c.a(matevent);
            }
            if (s1.equals("close"))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (s1.equals("open") || s1.equals("install") || s1.equals("update") || s1.equals("session"))
            {
                params.setAction("session");
                new Date(((Date) (obj)).getTime() + 60000L);
            }
        }
        if (matevent.getRevenue() > 0.0D)
        {
            params.setIsPayingUser(Integer.toString(1));
        }
        obj = com.mobileapptracker.e.a(matevent, mPreloadData, e);
        s2 = com.mobileapptracker.e.a(matevent);
        obj1 = new JSONArray();
        if (matevent.getEventItems() == null) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L5:
        if (i1 >= matevent.getEventItems().size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((JSONArray) (obj1)).put(((MATEventItem)matevent.getEventItems().get(i1)).toJSON());
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
        obj1 = com.mobileapptracker.e.a(((JSONArray) (obj1)), matevent.getReceiptData(), matevent.getReceiptSignature(), params.getUserEmails());
        if (matRequest != null)
        {
            matRequest.constructedRequest(((String) (obj)), s2, ((JSONObject) (obj1)));
        }
        addEventToQueue(((String) (obj)), s2, ((JSONObject) (obj1)), firstSession);
        firstSession = false;
        dumpQueue();
        if (matResponse != null)
        {
            matResponse.enqueuedActionWithRefId(matevent.getRefId());
        }
        if (true) goto _L1; else goto _L6
_L6:
        matevent;
        throw matevent;
    }

    static void a(MobileAppTracker mobileapptracker, MATEvent matevent)
    {
        mobileapptracker.a(matevent);
    }

    public static MobileAppTracker getInstance()
    {
        com/mobileapptracker/MobileAppTracker;
        JVM INSTR monitorenter ;
        MobileAppTracker mobileapptracker = f;
        com/mobileapptracker/MobileAppTracker;
        JVM INSTR monitorexit ;
        return mobileapptracker;
        Exception exception;
        exception;
        throw exception;
    }

    public static MobileAppTracker init(Context context, String s1, String s2)
    {
        com/mobileapptracker/MobileAppTracker;
        JVM INSTR monitorenter ;
        MobileAppTracker mobileapptracker = new MobileAppTracker();
        f = mobileapptracker;
        mobileapptracker.mContext = context.getApplicationContext();
        f.pubQueue = Executors.newSingleThreadExecutor();
        f.initAll(s1, s2);
        context = f;
        com/mobileapptracker/MobileAppTracker;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static boolean isOnline(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    protected void addEventToQueue(String s1, String s2, JSONObject jsonobject, boolean flag)
    {
        ExecutorService executorservice = pool;
        MATEventQueue mateventqueue = eventQueue;
        mateventqueue.getClass();
        executorservice.execute(new MATEventQueue.Add(mateventqueue, s1, s2, jsonobject, flag));
    }

    public String checkForDeferredDeeplink(int i1)
    {
        if (firstInstall)
        {
            if (params.getInstaller() != null && params.getInstaller().equals("com.android.vending"))
            {
                return a(i1);
            } else
            {
                b b1 = b;
                com.mobileapptracker.b.d(params.getUserAgent());
                b1 = b;
                Context context = mContext;
                f f1 = c;
                return b1.a(context, i1);
            }
        } else
        {
            return "";
        }
    }

    protected void dumpQueue()
    {
        if (!isOnline(mContext))
        {
            return;
        } else
        {
            ExecutorService executorservice = pool;
            MATEventQueue mateventqueue = eventQueue;
            mateventqueue.getClass();
            executorservice.execute(new MATEventQueue.Dump(mateventqueue));
            return;
        }
    }

    public String getAction()
    {
        return params.getAction();
    }

    public String getAdvertiserId()
    {
        return params.getAdvertiserId();
    }

    public int getAge()
    {
        return Integer.parseInt(params.getAge());
    }

    public double getAltitude()
    {
        return Double.parseDouble(params.getAltitude());
    }

    public boolean getAppAdTrackingEnabled()
    {
        return Integer.parseInt(params.getAppAdTrackingEnabled()) == 1;
    }

    public String getAppName()
    {
        return params.getAppName();
    }

    public int getAppVersion()
    {
        return Integer.parseInt(params.getAppVersion());
    }

    public String getConnectionType()
    {
        return params.getConnectionType();
    }

    public String getCountryCode()
    {
        return params.getCountryCode();
    }

    public String getCurrencyCode()
    {
        return params.getCurrencyCode();
    }

    public String getDeviceBrand()
    {
        return params.getDeviceBrand();
    }

    public String getDeviceCarrier()
    {
        return params.getDeviceCarrier();
    }

    public String getDeviceModel()
    {
        return params.getDeviceModel();
    }

    public String getEventAttribute1()
    {
        return params.getEventAttribute1();
    }

    public String getEventAttribute2()
    {
        return params.getEventAttribute2();
    }

    public String getEventAttribute3()
    {
        return params.getEventAttribute3();
    }

    public String getEventAttribute4()
    {
        return params.getEventAttribute4();
    }

    public String getEventAttribute5()
    {
        return params.getEventAttribute5();
    }

    public String getEventId()
    {
        return params.getEventId();
    }

    public String getEventName()
    {
        return params.getEventName();
    }

    public boolean getExistingUser()
    {
        return Integer.parseInt(params.getExistingUser()) == 1;
    }

    public String getFacebookUserId()
    {
        return params.getFacebookUserId();
    }

    public int getGender()
    {
        return Integer.parseInt(params.getGender());
    }

    public boolean getGoogleAdTrackingLimited()
    {
        return Integer.parseInt(params.getGoogleAdTrackingLimited()) != 0;
    }

    public String getGoogleAdvertisingId()
    {
        return params.getGoogleAdvertisingId();
    }

    public String getGoogleUserId()
    {
        return params.getGoogleUserId();
    }

    public long getInstallDate()
    {
        return Long.parseLong(params.getInstallDate());
    }

    public String getInstallReferrer()
    {
        return params.getInstallReferrer();
    }

    public boolean getIsPayingUser()
    {
        return params.getIsPayingUser().equals("1");
    }

    public String getLanguage()
    {
        return params.getLanguage();
    }

    public String getLastOpenLogId()
    {
        return params.getLastOpenLogId();
    }

    public double getLatitude()
    {
        return Double.parseDouble(params.getLatitude());
    }

    public double getLongitude()
    {
        return Double.parseDouble(params.getLongitude());
    }

    public String getMCC()
    {
        return params.getMCC();
    }

    public String getMNC()
    {
        return params.getMNC();
    }

    public String getMatId()
    {
        return params.getMatId();
    }

    public String getOpenLogId()
    {
        return params.getOpenLogId();
    }

    public String getOsVersion()
    {
        return params.getOsVersion();
    }

    public String getPackageName()
    {
        return params.getPackageName();
    }

    public String getPluginName()
    {
        return params.getPluginName();
    }

    public String getRefId()
    {
        return params.getRefId();
    }

    public String getReferralSource()
    {
        return params.getReferralSource();
    }

    public String getReferralUrl()
    {
        return params.getReferralUrl();
    }

    public Double getRevenue()
    {
        return Double.valueOf(Double.parseDouble(params.getRevenue()));
    }

    public String getSDKVersion()
    {
        return params.getSdkVersion();
    }

    public String getScreenDensity()
    {
        return params.getScreenDensity();
    }

    public String getScreenHeight()
    {
        return params.getScreenHeight();
    }

    public String getScreenWidth()
    {
        return params.getScreenWidth();
    }

    public String getSiteId()
    {
        return params.getSiteId();
    }

    public String getTRUSTeId()
    {
        return params.getTRUSTeId();
    }

    public String getTwitterUserId()
    {
        return params.getTwitterUserId();
    }

    public String getUserAgent()
    {
        return params.getUserAgent();
    }

    public String getUserEmail()
    {
        return params.getUserEmail();
    }

    public String getUserId()
    {
        return params.getUserId();
    }

    public String getUserName()
    {
        return params.getUserName();
    }

    protected void initAll(String s1, String s2)
    {
        MATParameters.init(mContext, s1, s2);
        params = MATParameters.getInstance();
        pool = Executors.newSingleThreadExecutor();
        c = new f();
        d = new MATEncryption(s2.trim(), "heF9BATUfWuISyO8");
        initTime = System.currentTimeMillis();
        b b1;
        boolean flag;
        if (!mContext.getSharedPreferences("com.mobileapptracking", 0).getString("mat_referrer", "").equals(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gotReferrer = flag;
        firstInstall = false;
        firstSession = true;
        initialized = false;
        isRegistered = false;
        e = false;
        fbLogging = false;
        com.mobileapptracker.b.a();
        b = com.mobileapptracker.b.b();
        b1 = b;
        com.mobileapptracker.b.a(s1);
        s1 = b;
        com.mobileapptracker.b.b(s2);
        s1 = b;
        com.mobileapptracker.b.c(params.getPackageName());
        eventQueue = new MATEventQueue(mContext, this);
        dumpQueue();
        networkStateReceiver = new g(this);
        if (isRegistered)
        {
            try
            {
                mContext.unregisterReceiver(networkStateReceiver);
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            isRegistered = false;
        }
        s1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        mContext.registerReceiver(networkStateReceiver, s1);
        isRegistered = true;
        initialized = true;
    }

    protected boolean makeRequest(String s1, String s2, JSONObject jsonobject)
    {
        boolean flag;
        flag = false;
        if (e)
        {
            Log.d("MobileAppTracker", "Sending event to server...");
        }
        s2 = com.mobileapptracker.e.a(s2, d);
        s1 = (new StringBuilder()).append(s1).append("&data=").append(s2).toString();
        s1 = c.a(s1, jsonobject, e);
        if (s1 != null) goto _L2; else goto _L1
_L1:
        if (matResponse != null)
        {
            matResponse.didFailWithError(s1);
        }
_L4:
        return true;
_L2:
        if (!s1.has("success"))
        {
            if (e)
            {
                Log.d("MobileAppTracker", "Request failed, event will remain in queue");
            }
            return false;
        }
        if (matResponse == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1;
        try
        {
            flag1 = s1.getString("success").equals("true");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return false;
        }
        if (flag1)
        {
            flag = true;
        }
        if (flag)
        {
            matResponse.didSucceedWithData(s1);
        } else
        {
            matResponse.didFailWithError(s1);
        }
        if (!s1.getString("site_event_type").equals("open")) goto _L4; else goto _L3
_L3:
        s1 = s1.getString("log_id");
        if (getOpenLogId().equals(""))
        {
            params.setOpenLogId(s1);
        }
        params.setLastOpenLogId(s1);
        return true;
        s1;
        return true;
    }

    public void measureAction(int i1)
    {
        measureEvent(new MATEvent(i1));
    }

    public void measureAction(int i1, double d1, String s1)
    {
        measureEvent((new MATEvent(i1)).withRevenue(d1).withCurrencyCode(s1));
    }

    public void measureAction(int i1, double d1, String s1, String s2)
    {
        measureEvent((new MATEvent(i1)).withRevenue(d1).withCurrencyCode(s1).withAdvertiserRefId(s2));
    }

    public void measureAction(int i1, List list, double d1, String s1, String s2)
    {
        measureEvent((new MATEvent(i1)).withEventItems(list).withRevenue(d1).withCurrencyCode(s1).withAdvertiserRefId(s2));
    }

    public void measureAction(int i1, List list, double d1, String s1, String s2, String s3, 
            String s4)
    {
        measureEvent((new MATEvent(i1)).withEventItems(list).withRevenue(d1).withCurrencyCode(s1).withAdvertiserRefId(s2).withReceipt(s3, s4));
    }

    public void measureAction(String s1)
    {
        measureEvent(new MATEvent(s1));
    }

    public void measureAction(String s1, double d1, String s2)
    {
        measureEvent((new MATEvent(s1)).withRevenue(d1).withCurrencyCode(s2));
    }

    public void measureAction(String s1, double d1, String s2, String s3)
    {
        measureEvent((new MATEvent(s1)).withRevenue(d1).withCurrencyCode(s2).withAdvertiserRefId(s3));
    }

    public void measureAction(String s1, List list, double d1, String s2, String s3)
    {
        measureEvent((new MATEvent(s1)).withEventItems(list).withRevenue(d1).withCurrencyCode(s2).withAdvertiserRefId(s3));
    }

    public void measureAction(String s1, List list, double d1, String s2, String s3, String s4, 
            String s5)
    {
        measureEvent((new MATEvent(s1)).withEventItems(list).withRevenue(d1).withCurrencyCode(s2).withAdvertiserRefId(s3).withReceipt(s4, s5));
    }

    public void measureEvent(int i1)
    {
        measureEvent(new MATEvent(i1));
    }

    public void measureEvent(MATEvent matevent)
    {
        pubQueue.execute(new ac(this, matevent));
    }

    public void measureEvent(String s1)
    {
        measureEvent(new MATEvent(s1));
    }

    public void measureSession()
    {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences("com.mobileapptracking", 0);
        if (!sharedpreferences.contains("mat_installed"))
        {
            sharedpreferences.edit().putBoolean("mat_installed", true).commit();
            firstInstall = true;
        }
        pubQueue.execute(new r(this));
    }

    public void setAdvertiserId(String s1)
    {
        pubQueue.execute(new an(this, s1));
    }

    public void setAge(int i1)
    {
        pubQueue.execute(new ao(this, i1));
    }

    public void setAllowDuplicates(boolean flag)
    {
        pubQueue.execute(new aj(this, flag));
        if (flag)
        {
            (new Handler(Looper.getMainLooper())).post(new ak(this));
        }
    }

    public void setAltitude(double d1)
    {
        pubQueue.execute(new ap(this, d1));
    }

    public void setAndroidId(String s1)
    {
        b b1 = b;
        com.mobileapptracker.b.e(s1);
        pubQueue.execute(new aq(this, s1));
    }

    public void setAndroidIdMd5(String s1)
    {
        pubQueue.execute(new ar(this, s1));
    }

    public void setAndroidIdSha1(String s1)
    {
        pubQueue.execute(new as(this, s1));
    }

    public void setAndroidIdSha256(String s1)
    {
        pubQueue.execute(new h(this, s1));
    }

    public void setAppAdTrackingEnabled(boolean flag)
    {
        pubQueue.execute(new i(this, flag));
    }

    public void setCurrencyCode(String s1)
    {
        pubQueue.execute(new j(this, s1));
    }

    public void setDebugMode(boolean flag)
    {
        e = flag;
        if (flag)
        {
            (new Handler(Looper.getMainLooper())).post(new al(this));
        }
    }

    public void setDeviceId(String s1)
    {
        pubQueue.execute(new k(this, s1));
    }

    public void setEmailCollection(boolean flag)
    {
        pubQueue.execute(new am(this, flag));
    }

    public void setExistingUser(boolean flag)
    {
        pubQueue.execute(new l(this, flag));
    }

    public void setFacebookEventLogging(boolean flag, Context context, boolean flag1)
    {
        fbLogging = flag;
        if (flag)
        {
            com.mobileapptracker.c.a(context, flag1);
        }
    }

    public void setFacebookUserId(String s1)
    {
        pubQueue.execute(new m(this, s1));
    }

    public void setGender(int i1)
    {
        pubQueue.execute(new n(this, i1));
    }

    public void setGoogleAdvertisingId(String s1, boolean flag)
    {
        b b1;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        b1 = b;
        com.mobileapptracker.b.a(s1, i1);
        pubQueue.execute(new o(this, s1, i1));
    }

    public void setGoogleUserId(String s1)
    {
        pubQueue.execute(new p(this, s1));
    }

    public void setInstallReferrer(String s1)
    {
        gotReferrer = true;
        referrerTime = System.currentTimeMillis();
        if (params != null)
        {
            params.setReferrerDelay(referrerTime - initTime);
        }
        pubQueue.execute(new q(this, s1));
    }

    public void setIsPayingUser(boolean flag)
    {
        pubQueue.execute(new s(this, flag));
    }

    public void setLatitude(double d1)
    {
        pubQueue.execute(new t(this, d1));
    }

    public void setLocation(Location location)
    {
        pubQueue.execute(new u(this, location));
    }

    public void setLongitude(double d1)
    {
        pubQueue.execute(new v(this, d1));
    }

    public void setMATResponse(MATResponse matresponse)
    {
        matResponse = matresponse;
        b b1 = b;
        com.mobileapptracker.b.a(matresponse);
    }

    public void setMacAddress(String s1)
    {
        pubQueue.execute(new w(this, s1));
    }

    public void setOfferId(String s1)
    {
        pubQueue.execute(new x(this, s1));
    }

    public void setPackageName(String s1)
    {
        b b1 = b;
        com.mobileapptracker.b.c(s1);
        pubQueue.execute(new y(this, s1));
    }

    public void setPhoneNumber(String s1)
    {
        pubQueue.execute(new z(this, s1));
    }

    public void setPluginName(String s1)
    {
        if (Arrays.asList(a.a).contains(s1))
        {
            pubQueue.execute(new ai(this, s1));
        } else
        if (e)
        {
            throw new IllegalArgumentException("Plugin name not acceptable");
        }
    }

    public void setPreloadedApp(MATPreloadData matpreloaddata)
    {
        mPreloadData = matpreloaddata;
    }

    public void setReferralSources(Activity activity)
    {
        pubQueue.execute(new aa(this, activity));
    }

    public void setSiteId(String s1)
    {
        pubQueue.execute(new ab(this, s1));
    }

    public void setTRUSTeId(String s1)
    {
        pubQueue.execute(new ad(this, s1));
    }

    public void setTwitterUserId(String s1)
    {
        pubQueue.execute(new ae(this, s1));
    }

    public void setUserEmail(String s1)
    {
        pubQueue.execute(new af(this, s1));
    }

    public void setUserId(String s1)
    {
        pubQueue.execute(new ag(this, s1));
    }

    public void setUserName(String s1)
    {
        pubQueue.execute(new ah(this, s1));
    }

    public MobileAppTracker withAllowDuplicates(boolean flag)
    {
        f.setAllowDuplicates(flag);
        return f;
    }

    public MobileAppTracker withDebugMode(boolean flag)
    {
        f.setDebugMode(flag);
        return f;
    }

    public MobileAppTracker withEmailCollection(boolean flag)
    {
        f.setEmailCollection(flag);
        return f;
    }

    public MobileAppTracker withFacebookEventLogging(boolean flag, Context context, boolean flag1)
    {
        f.setFacebookEventLogging(flag, context, flag1);
        return f;
    }

    public MobileAppTracker withListener(MATResponse matresponse)
    {
        f.setMATResponse(matresponse);
        return f;
    }

    public MobileAppTracker withPackageName(String s1)
    {
        f.setPackageName(s1);
        return f;
    }

    public MobileAppTracker withSiteId(String s1)
    {
        f.setSiteId(s1);
        return f;
    }

}
