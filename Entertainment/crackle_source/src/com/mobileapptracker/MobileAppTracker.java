// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
//            Parameters, b, MATTestRequest, MATResponse, 
//            d, c, Encryption, MATEventQueue, 
//            o, bg, MATEventItem, bq, 
//            ak, av, z, br, 
//            bs, e, f, g, 
//            h, i, bo, j, 
//            k, l, m, bp, 
//            n, x, y, aa, 
//            ab, ac, q, p, 
//            v, w, r, s, 
//            u, t, ad, ae, 
//            af, ag, ah, ai, 
//            aj, al, am, an, 
//            ao, ap, aq, a, 
//            bn, ar, as, ba, 
//            bb, bc, bd, be, 
//            at, au, aw, ax, 
//            ay, az, bf, bh, 
//            bi, bj, bk, bl, 
//            bm

public class MobileAppTracker
{

    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    private static volatile MobileAppTracker g = null;
    private final String a = "heF9BATUfWuISyO8";
    private c b;
    private Encryption c;
    private boolean d;
    private boolean e;
    protected MATEventQueue eventQueue;
    private ExecutorService f;
    protected boolean initialized;
    protected boolean isRegistered;
    protected Context mContext;
    protected MATTestRequest matRequest;
    protected MATResponse matResponse;
    protected BroadcastReceiver networkStateReceiver;
    protected Parameters params;
    protected ExecutorService pubQueue;

    protected MobileAppTracker()
    {
    }

    static void a(MobileAppTracker mobileapptracker, Object obj, JSONArray jsonarray, double d1, String s1, String s2, String s3, 
            String s4)
    {
        mobileapptracker.a(obj, jsonarray, d1, s1, s2, s3, s4, false);
    }

    private void a(Object obj, JSONArray jsonarray, double d1, String s1, String s2, String s3, 
            String s4, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = initialized;
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj1;
        dumpQueue();
        params.setAction("conversion");
        obj1 = new Date();
        if (!(obj instanceof String)) goto _L4; else goto _L3
_L3:
        if (obj.equals("close")) goto _L1; else goto _L5
_L5:
        if (!obj.equals("open") && !obj.equals("install") && !obj.equals("update") && !obj.equals("session")) goto _L7; else goto _L6
_L6:
        if (!flag) goto _L9; else goto _L8
_L8:
        params.setAction("install");
_L10:
        obj = new Date(((Date) (obj1)).getTime() + 5000L);
_L11:
        params.setRevenue(Double.toString(d1));
        if (d1 <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        params.setIsPayingUser(Integer.toString(1));
        params.setCurrencyCode(s1);
        params.setRefId(s2);
        s1 = com.mobileapptracker.b.a(d, e, flag);
        obj1 = com.mobileapptracker.b.a();
        jsonarray = com.mobileapptracker.b.a(jsonarray, s3, s4);
        if (matRequest != null)
        {
            matRequest.constructedRequest(s1, ((String) (obj1)), jsonarray);
        }
        addEventToQueue(s1, ((String) (obj1)), jsonarray, ((Date) (obj)));
        dumpQueue();
        if (matResponse != null)
        {
            matResponse.enqueuedActionWithRefId(s2);
        }
        params.resetAfterRequest();
          goto _L1
        obj;
        throw obj;
_L9:
        params.setAction("session");
          goto _L10
_L7:
        params.setEventName((String)obj);
        obj = obj1;
          goto _L11
_L4:
        if (!(obj instanceof Integer))
        {
            break MISSING_BLOCK_LABEL_323;
        }
        params.setEventId(Integer.toString(((Integer)obj).intValue()));
        obj = obj1;
          goto _L11
        Log.d("MobileAppTracker", "Received invalid event name or id value, not measuring event");
          goto _L1
    }

    static boolean a(MobileAppTracker mobileapptracker, boolean flag)
    {
        mobileapptracker.d = flag;
        return flag;
    }

    static MobileAppTracker b()
    {
        return g;
    }

    private void c()
    {
        Date date1 = null;
_L2:
        Date date;
label0:
        {
            if (params == null)
            {
                date = date1;
                if (date1 == null)
                {
                    date = new Date((new Date()).getTime() + 1000L);
                }
                if (!date.before(new Date()))
                {
                    break label0;
                }
                Log.w("MobileAppTracker", "after waiting 1 s, params is still null -- will probably lead to NullPointerException");
            }
            return;
        }
        Thread.sleep(50L);
        date1 = date;
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception = date;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static MobileAppTracker getInstance()
    {
        com/mobileapptracker/MobileAppTracker;
        JVM INSTR monitorenter ;
        MobileAppTracker mobileapptracker = g;
        com/mobileapptracker/MobileAppTracker;
        JVM INSTR monitorexit ;
        return mobileapptracker;
        Exception exception;
        exception;
        throw exception;
    }

    public static void init(Context context, String s1, String s2)
    {
        MobileAppTracker mobileapptracker = new MobileAppTracker();
        g = mobileapptracker;
        mobileapptracker.mContext = context.getApplicationContext();
        g.pubQueue = Executors.newSingleThreadExecutor();
        g.pubQueue.execute(new d(s1, s2));
    }

    public static boolean isOnline(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    final void a()
    {
        a("install", ((JSONArray) (null)), 0.0D, ((String) (null)), null, null, null, true);
    }

    protected void addEventToQueue(String s1, String s2, JSONObject jsonobject, Date date)
    {
        ExecutorService executorservice = f;
        MATEventQueue mateventqueue = eventQueue;
        mateventqueue.getClass();
        executorservice.execute(new MATEventQueue.Add(mateventqueue, s1, s2, jsonobject, date));
    }

    protected void dumpQueue()
    {
        if (!isOnline(mContext))
        {
            return;
        } else
        {
            ExecutorService executorservice = f;
            MATEventQueue mateventqueue = eventQueue;
            mateventqueue.getClass();
            executorservice.execute(new MATEventQueue.Dump(mateventqueue));
            return;
        }
    }

    public String getAction()
    {
        c();
        return params.getAction();
    }

    public String getAdvertiserId()
    {
        c();
        return params.getAdvertiserId();
    }

    public int getAge()
    {
        c();
        return Integer.parseInt(params.getAge());
    }

    public double getAltitude()
    {
        c();
        return Double.parseDouble(params.getAltitude());
    }

    public boolean getAppAdTrackingEnabled()
    {
        c();
        return Integer.parseInt(params.getAppAdTrackingEnabled()) == 1;
    }

    public String getAppName()
    {
        c();
        return params.getAppName();
    }

    public int getAppVersion()
    {
        c();
        return Integer.parseInt(params.getAppVersion());
    }

    public String getConnectionType()
    {
        c();
        return params.getConnectionType();
    }

    public String getCountryCode()
    {
        c();
        return params.getCountryCode();
    }

    public String getCurrencyCode()
    {
        c();
        return params.getCurrencyCode();
    }

    public String getDeviceBrand()
    {
        c();
        return params.getDeviceBrand();
    }

    public String getDeviceCarrier()
    {
        c();
        return params.getDeviceCarrier();
    }

    public String getDeviceModel()
    {
        c();
        return params.getDeviceModel();
    }

    public String getEventAttribute1()
    {
        c();
        return params.getEventAttribute1();
    }

    public String getEventAttribute2()
    {
        c();
        return params.getEventAttribute2();
    }

    public String getEventAttribute3()
    {
        c();
        return params.getEventAttribute3();
    }

    public String getEventAttribute4()
    {
        c();
        return params.getEventAttribute4();
    }

    public String getEventAttribute5()
    {
        c();
        return params.getEventAttribute5();
    }

    public String getEventId()
    {
        c();
        return params.getEventId();
    }

    public String getEventName()
    {
        c();
        return params.getEventName();
    }

    public boolean getExistingUser()
    {
        c();
        return Integer.parseInt(params.getExistingUser()) == 1;
    }

    public String getFacebookUserId()
    {
        c();
        return params.getFacebookUserId();
    }

    public int getGender()
    {
        c();
        return Integer.parseInt(params.getGender());
    }

    public boolean getGoogleAdTrackingLimited()
    {
        c();
        return Integer.parseInt(params.getGoogleAdTrackingLimited()) != 0;
    }

    public String getGoogleAdvertisingId()
    {
        c();
        return params.getGoogleAdvertisingId();
    }

    public String getGoogleUserId()
    {
        c();
        return params.getGoogleUserId();
    }

    public long getInstallDate()
    {
        c();
        return Long.parseLong(params.getInstallDate());
    }

    public String getInstallLogId()
    {
        c();
        return params.getInstallLogId();
    }

    public String getInstallReferrer()
    {
        c();
        return params.getInstallReferrer();
    }

    public boolean getIsPayingUser()
    {
        c();
        return params.getIsPayingUser().equals("1");
    }

    public String getLanguage()
    {
        c();
        return params.getLanguage();
    }

    public String getLastOpenLogId()
    {
        c();
        return params.getLastOpenLogId();
    }

    public double getLatitude()
    {
        c();
        return Double.parseDouble(params.getLatitude());
    }

    public double getLongitude()
    {
        c();
        return Double.parseDouble(params.getLongitude());
    }

    public String getMCC()
    {
        c();
        return params.getMCC();
    }

    public String getMNC()
    {
        c();
        return params.getMNC();
    }

    public String getMatId()
    {
        c();
        return params.getMatId();
    }

    public String getOpenLogId()
    {
        c();
        return params.getOpenLogId();
    }

    public String getOsVersion()
    {
        c();
        return params.getOsVersion();
    }

    public String getPackageName()
    {
        c();
        return params.getPackageName();
    }

    public String getPluginName()
    {
        c();
        return params.getPluginName();
    }

    public String getRefId()
    {
        c();
        return params.getRefId();
    }

    public String getReferralSource()
    {
        c();
        return params.getReferralSource();
    }

    public String getReferralUrl()
    {
        c();
        return params.getReferralUrl();
    }

    public Double getRevenue()
    {
        c();
        return Double.valueOf(Double.parseDouble(params.getRevenue()));
    }

    public String getSDKVersion()
    {
        c();
        return params.getSdkVersion();
    }

    public String getScreenDensity()
    {
        c();
        return params.getScreenDensity();
    }

    public String getScreenHeight()
    {
        c();
        return params.getScreenHeight();
    }

    public String getScreenWidth()
    {
        c();
        return params.getScreenWidth();
    }

    public String getSiteId()
    {
        c();
        return params.getSiteId();
    }

    public String getTRUSTeId()
    {
        c();
        return params.getTRUSTeId();
    }

    public String getTwitterUserId()
    {
        c();
        return params.getTwitterUserId();
    }

    public String getUpdateLogId()
    {
        c();
        return params.getUpdateLogId();
    }

    public String getUserAgent()
    {
        c();
        return params.getUserAgent();
    }

    public String getUserEmail()
    {
        c();
        return params.getUserEmail();
    }

    public String getUserId()
    {
        c();
        return params.getUserId();
    }

    public String getUserName()
    {
        c();
        return params.getUserName();
    }

    protected void initAll(String s1, String s2)
    {
        Parameters.init(mContext, s1, s2);
        params = Parameters.getInstance();
        f = Executors.newSingleThreadExecutor();
        b = new c();
        c = new Encryption(s2.trim(), "heF9BATUfWuISyO8");
        initialized = false;
        isRegistered = false;
        d = false;
        e = false;
        eventQueue = new MATEventQueue(mContext, g);
        dumpQueue();
        networkStateReceiver = new o(this);
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
        if (d)
        {
            Log.d("MobileAppTracker", "Sending event to server...");
        }
        s2 = com.mobileapptracker.b.a(s2, c);
        s1 = (new StringBuilder()).append(s1).append("&data=").append(s2).toString();
        s1 = b.a(s1, jsonobject, d);
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
            if (d)
            {
                Log.d("MobileAppTracker", "Request failed, event will remain in queue");
            }
            return false;
        }
        if (matResponse != null)
        {
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
        }
        try
        {
            if (s1.getString("site_event_type").equals("open"))
            {
                s2 = s1.getString("log_id");
                if (getOpenLogId().equals(""))
                {
                    params.setOpenLogId(s2);
                }
                params.setLastOpenLogId(s2);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s2) { }
        if (!d) goto _L4; else goto _L3
_L3:
        Log.d("MobileAppTracker", (new StringBuilder("Server response: ")).append(s1.toString()).toString());
        if (s1.length() <= 0) goto _L4; else goto _L5
_L5:
        if (!s1.has("log_action") || s1.getString("log_action").equals("null"))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = s1.getJSONObject("log_action");
        if (!s1.has("conversion")) goto _L4; else goto _L6
_L6:
        s1 = s1.getJSONObject("conversion");
        if (!s1.has("status")) goto _L4; else goto _L7
_L7:
        if (!s1.getString("status").equals("rejected"))
        {
            break MISSING_BLOCK_LABEL_400;
        }
        s1 = s1.getString("status_code");
        Log.d("MobileAppTracker", (new StringBuilder("Event was rejected by server: status code ")).append(s1).toString());
        return true;
        try
        {
            Log.d("MobileAppTracker", "Event was accepted by server");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("MobileAppTracker", "Server response status could not be parsed");
            s1.printStackTrace();
            return true;
        }
        return true;
        if (!s1.has("options")) goto _L4; else goto _L8
_L8:
        s1 = s1.getJSONObject("options");
        if (!s1.has("conversion_status")) goto _L4; else goto _L9
_L9:
        s1 = s1.getString("conversion_status");
        Log.d("MobileAppTracker", (new StringBuilder("Event was ")).append(s1).append(" by server").toString());
        return true;
    }

    public void measureAction(int i1)
    {
        pubQueue.execute(new bg(this, i1));
    }

    public void measureAction(int i1, double d1, String s1)
    {
        measureAction(i1, null, d1, s1, null, null, null);
    }

    public void measureAction(int i1, double d1, String s1, String s2)
    {
        measureAction(i1, null, d1, s1, s2, null, null);
    }

    public void measureAction(int i1, List list, double d1, String s1, String s2)
    {
        measureAction(i1, list, d1, s1, s2, null, null);
    }

    public void measureAction(int i1, List list, double d1, String s1, String s2, String s3, 
            String s4)
    {
        JSONArray jsonarray = new JSONArray();
        if (list != null)
        {
            for (int j1 = 0; j1 < list.size(); j1++)
            {
                jsonarray.put(((MATEventItem)list.get(j1)).toJSON());
            }

        }
        pubQueue.execute(new bq(this, i1, jsonarray, d1, s1, s2, s3, s4));
    }

    public void measureAction(String s1)
    {
        pubQueue.execute(new ak(this, s1));
    }

    public void measureAction(String s1, double d1, String s2)
    {
        measureAction(s1, null, d1, s2, null, null, null);
    }

    public void measureAction(String s1, double d1, String s2, String s3)
    {
        measureAction(s1, null, d1, s2, s3, null, null);
    }

    public void measureAction(String s1, List list, double d1, String s2, String s3)
    {
        measureAction(s1, list, d1, s2, s3, null, null);
    }

    public void measureAction(String s1, List list, double d1, String s2, String s3, String s4, 
            String s5)
    {
        JSONArray jsonarray = new JSONArray();
        if (list != null)
        {
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                jsonarray.put(((MATEventItem)list.get(i1)).toJSON());
            }

        }
        pubQueue.execute(new av(this, s1, jsonarray, d1, s2, s3, s4, s5));
    }

    public void measureSession()
    {
        pubQueue.execute(new z(this));
    }

    public void setAdvertiserSubAd(String s1)
    {
        pubQueue.execute(new br(this, s1));
    }

    public void setAdvertiserSubAdgroup(String s1)
    {
        pubQueue.execute(new bs(this, s1));
    }

    public void setAdvertiserSubCampaign(String s1)
    {
        pubQueue.execute(new e(this, s1));
    }

    public void setAdvertiserSubKeyword(String s1)
    {
        pubQueue.execute(new f(this, s1));
    }

    public void setAdvertiserSubPublisher(String s1)
    {
        pubQueue.execute(new g(this, s1));
    }

    public void setAdvertiserSubSite(String s1)
    {
        pubQueue.execute(new h(this, s1));
    }

    public void setAge(int i1)
    {
        pubQueue.execute(new i(this, i1));
    }

    public void setAllowDuplicates(boolean flag)
    {
        pubQueue.execute(new bo(this, flag));
    }

    public void setAltitude(double d1)
    {
        pubQueue.execute(new j(this, d1));
    }

    public void setAndroidId(String s1)
    {
        pubQueue.execute(new k(this, s1));
    }

    public void setAppAdTrackingEnabled(boolean flag)
    {
        pubQueue.execute(new l(this, flag));
    }

    public void setCurrencyCode(String s1)
    {
        pubQueue.execute(new m(this, s1));
    }

    public void setDebugMode(boolean flag)
    {
        pubQueue.execute(new bp(this, flag));
    }

    public void setDeviceId(String s1)
    {
        pubQueue.execute(new n(this, s1));
    }

    public void setEventAttribute1(String s1)
    {
        pubQueue.execute(new x(this, s1));
    }

    public void setEventAttribute2(String s1)
    {
        pubQueue.execute(new y(this, s1));
    }

    public void setEventAttribute3(String s1)
    {
        pubQueue.execute(new aa(this, s1));
    }

    public void setEventAttribute4(String s1)
    {
        pubQueue.execute(new ab(this, s1));
    }

    public void setEventAttribute5(String s1)
    {
        pubQueue.execute(new ac(this, s1));
    }

    public void setEventContentId(String s1)
    {
        pubQueue.execute(new q(this, s1));
    }

    public void setEventContentType(String s1)
    {
        pubQueue.execute(new p(this, s1));
    }

    public void setEventDate1(Date date)
    {
        pubQueue.execute(new v(this, date));
    }

    public void setEventDate2(Date date)
    {
        pubQueue.execute(new w(this, date));
    }

    public void setEventLevel(int i1)
    {
        pubQueue.execute(new r(this, i1));
    }

    public void setEventQuantity(int i1)
    {
        pubQueue.execute(new s(this, i1));
    }

    public void setEventRating(float f1)
    {
        pubQueue.execute(new u(this, f1));
    }

    public void setEventSearchString(String s1)
    {
        pubQueue.execute(new t(this, s1));
    }

    public void setExistingUser(boolean flag)
    {
        pubQueue.execute(new ad(this, flag));
    }

    public void setFacebookUserId(String s1)
    {
        pubQueue.execute(new ae(this, s1));
    }

    public void setGender(int i1)
    {
        pubQueue.execute(new af(this, i1));
    }

    public void setGoogleAdvertisingId(String s1, boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        pubQueue.execute(new ag(this, s1, i1));
    }

    public void setGoogleUserId(String s1)
    {
        pubQueue.execute(new ah(this, s1));
    }

    public void setInstallReferrer(String s1)
    {
        pubQueue.execute(new ai(this, s1));
    }

    public void setIsPayingUser(boolean flag)
    {
        pubQueue.execute(new aj(this, flag));
    }

    public void setLatitude(double d1)
    {
        pubQueue.execute(new al(this, d1));
    }

    public void setLocation(Location location)
    {
        pubQueue.execute(new am(this, location));
    }

    public void setLongitude(double d1)
    {
        pubQueue.execute(new an(this, d1));
    }

    public void setMATResponse(MATResponse matresponse)
    {
        matResponse = matresponse;
    }

    public void setMacAddress(String s1)
    {
        pubQueue.execute(new ao(this, s1));
    }

    public void setOfferId(String s1)
    {
        pubQueue.execute(new ap(this, s1));
    }

    public void setPackageName(String s1)
    {
        pubQueue.execute(new aq(this, s1));
    }

    public void setPluginName(String s1)
    {
        if (Arrays.asList(a.a).contains(s1))
        {
            pubQueue.execute(new bn(this, s1));
        } else
        if (d)
        {
            throw new IllegalArgumentException("Plugin name not acceptable");
        }
    }

    public void setPublisherId(String s1)
    {
        e = true;
        pubQueue.execute(new ar(this, s1));
    }

    public void setPublisherReferenceId(String s1)
    {
        pubQueue.execute(new as(this, s1));
    }

    public void setPublisherSub1(String s1)
    {
        pubQueue.execute(new ba(this, s1));
    }

    public void setPublisherSub2(String s1)
    {
        pubQueue.execute(new bb(this, s1));
    }

    public void setPublisherSub3(String s1)
    {
        pubQueue.execute(new bc(this, s1));
    }

    public void setPublisherSub4(String s1)
    {
        pubQueue.execute(new bd(this, s1));
    }

    public void setPublisherSub5(String s1)
    {
        pubQueue.execute(new be(this, s1));
    }

    public void setPublisherSubAd(String s1)
    {
        pubQueue.execute(new at(this, s1));
    }

    public void setPublisherSubAdgroup(String s1)
    {
        pubQueue.execute(new au(this, s1));
    }

    public void setPublisherSubCampaign(String s1)
    {
        pubQueue.execute(new aw(this, s1));
    }

    public void setPublisherSubKeyword(String s1)
    {
        pubQueue.execute(new ax(this, s1));
    }

    public void setPublisherSubPublisher(String s1)
    {
        pubQueue.execute(new ay(this, s1));
    }

    public void setPublisherSubSite(String s1)
    {
        pubQueue.execute(new az(this, s1));
    }

    public void setReferralSources(Activity activity)
    {
        pubQueue.execute(new bf(this, activity));
    }

    public void setSiteId(String s1)
    {
        pubQueue.execute(new bh(this, s1));
    }

    public void setTRUSTeId(String s1)
    {
        pubQueue.execute(new bi(this, s1));
    }

    public void setTwitterUserId(String s1)
    {
        pubQueue.execute(new bj(this, s1));
    }

    public void setUserEmail(String s1)
    {
        pubQueue.execute(new bk(this, s1));
    }

    public void setUserId(String s1)
    {
        pubQueue.execute(new bl(this, s1));
    }

    public void setUserName(String s1)
    {
        pubQueue.execute(new bm(this, s1));
    }

}
