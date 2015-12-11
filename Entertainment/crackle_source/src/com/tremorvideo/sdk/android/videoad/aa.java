// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, bo, Settings, at, 
//            br, ac, z

public class aa
{
    class a extends AsyncTask
    {

        final String a;
        final boolean b;
        final List c;
        final int d;

        protected transient Void a(String as[])
        {
            int i;
            i = aa.d();
            ad.d((new StringBuilder()).append("Sending Communication: ").append(i).append(a).toString());
            as = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(as, 18000);
            HttpConnectionParams.setSoTimeout(as, 18000);
            as.setBooleanParameter("http.protocol.expect-continue", false);
            as.setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
            as = new DefaultHttpClient(as);
            if (aa.e() != null)
            {
                as.setCookieStore(aa.e());
            }
            if (!b || c == null) goto _L2; else goto _L1
_L1:
            HttpPost httppost;
            String s;
            httppost = new HttpPost(a);
            s = ae.a(a, b, d);
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_155;
            }
            httppost.setHeader("User-Agent", s);
            if (c != null)
            {
                httppost.setEntity(new UrlEncodedFormEntity(c, "utf-8"));
            }
            as = as.execute(httppost);
_L3:
            aa.a();
            as = as.getStatusLine();
            HttpGet httpget;
            String s1;
            if (as != null)
            {
                try
                {
                    ad.d((new StringBuilder()).append("Status: ").append(i).append(" : ").append(as.toString()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    ad.d((new StringBuilder()).append("Error Firing Tracking Pixel: ").append(a).append(" :: ").append(as.getMessage()).toString());
                    ad.a(as);
                }
            }
            break MISSING_BLOCK_LABEL_327;
_L2:
            httpget = new HttpGet(a);
            s1 = ae.a(a, b, d);
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_276;
            }
            httpget.setHeader("User-Agent", s1);
            as = as.execute(httpget);
              goto _L3
            return null;
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        a(String s, boolean flag, List list, int i)
        {
            a = s;
            b = flag;
            c = list;
            d = i;
            super();
        }
    }

    class b extends AsyncTask
    {

        final String a;
        final String b;

        protected transient Void a(String as[])
        {
            int i;
            i = aa.d();
            ad.d((new StringBuilder()).append("Sending Communication: ").append(i).toString());
            as = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(as, 18000);
            HttpConnectionParams.setSoTimeout(as, 18000);
            as.setBooleanParameter("http.protocol.expect-continue", false);
            as.setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
            as = new DefaultHttpClient(as);
            HttpPost httppost = new HttpPost(a);
            ae.a(httppost, a);
            httppost.setEntity(new StringEntity(b));
            if (aa.e() != null)
            {
                as.setCookieStore(aa.e());
            }
            aa.a(httppost, b);
            as = as.execute(httppost);
            if (as == null)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            as = as.getStatusLine();
            if (as != null)
            {
                try
                {
                    ad.d((new StringBuilder()).append("Status: ").append(i).append(" : ").append(as.toString()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    ad.a("Error Sending Response: Exectuing POST", as);
                }
            }
            return null;
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        b(String s, String s1)
        {
            a = s;
            b = s1;
            super();
        }
    }

    class c extends AsyncTask
    {

        final String a;
        final String b;

        protected transient Void a(String as[])
        {
            int i;
            i = aa.d();
            ad.d((new StringBuilder()).append("Sending Communication: ").append(i).toString());
            as = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(as, 18000);
            HttpConnectionParams.setSoTimeout(as, 18000);
            as.setBooleanParameter("http.protocol.expect-continue", false);
            as.setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
            as = new DefaultHttpClient(as);
            HttpPost httppost = new HttpPost(a);
            ae.a(httppost, a);
            httppost.setEntity(new StringEntity(b));
            if (aa.e() != null)
            {
                as.setCookieStore(aa.e());
            }
            aa.a(httppost, b);
            as = as.execute(httppost);
            if (as == null)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            as = as.getStatusLine();
            if (as != null)
            {
                try
                {
                    ad.d((new StringBuilder()).append("Status: ").append(i).append(" : ").append(as.toString()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    ad.a("Error Sending Response: Exectuing POST", as);
                }
            }
            return null;
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        c(String s, String s1)
        {
            a = s;
            b = s1;
            super();
        }
    }


    private static int a = 1;
    private static CookieStore b = null;
    private static String c = "TremoPrefs";
    private static String d = "TremorBis";

    private static String a(String s)
    {
        StringBuffer stringbuffer;
        int i;
        int j;
        try
        {
            s = MessageDigest.getInstance("MD5").digest(s.getBytes());
            stringbuffer = new StringBuffer(s.length * 2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a(ad.d.b, "Error encoding mac.", s);
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j = s[i] & 0xff;
        if (j >= 16)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        stringbuffer.append('0');
        stringbuffer.append(Integer.toHexString(j));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_27;
_L1:
        s = stringbuffer.toString().toLowerCase();
        return s;
    }

    private static String a(CookieStore cookiestore)
    {
        JSONArray jsonarray = new JSONArray();
        cookiestore = cookiestore.getCookies().iterator();
        do
        {
            if (!cookiestore.hasNext())
            {
                break;
            }
            JSONObject jsonobject = a((Cookie)cookiestore.next());
            if (jsonobject != null)
            {
                jsonarray.put(jsonobject);
            }
        } while (true);
        if (jsonarray.length() > 0)
        {
            return jsonarray.toString();
        } else
        {
            return null;
        }
    }

    private static Cookie a(JSONObject jsonobject)
    {
        Object obj;
        try
        {
            obj = jsonobject.getString("name");
            String s2 = jsonobject.getString("value");
            String s = jsonobject.getString("domain");
            String s1 = jsonobject.getString("path");
            int i = jsonobject.getInt("version");
            boolean flag = jsonobject.getBoolean("isSecure");
            obj = new BasicClientCookie(((String) (obj)), s2);
            ((BasicClientCookie) (obj)).setDomain(s);
            ((BasicClientCookie) (obj)).setPath(s1);
            ((BasicClientCookie) (obj)).setVersion(i);
            ((BasicClientCookie) (obj)).setSecure(Boolean.valueOf(flag).booleanValue());
            if (jsonobject.has("expiryDate"))
            {
                ((BasicClientCookie) (obj)).setExpiryDate(new Date(jsonobject.getLong("expiryDate")));
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            ad.d("Error Loading Cookie");
            return null;
        }
        return ((Cookie) (obj));
    }

    public static JSONObject a(Settings settings)
    {
        bo.a(ad.v(), true);
_L1:
        Object obj;
        try
        {
            obj = new JSONArray();
            for (Iterator iterator = settings.userInterests.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put((String)iterator.next())) { }
        }
        // Misplaced declaration of an exception variable
        catch (Settings settings)
        {
            ad.a("Error creating JSON user data", settings);
            return null;
        }
        break MISSING_BLOCK_LABEL_96;
        obj;
        ad.d((new StringBuilder()).append("Communication: Unable to get location: ").append(((Exception) (obj)).toString()).toString());
          goto _L1
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        String s;
        for (Iterator iterator1 = settings.misc.keySet().iterator(); iterator1.hasNext(); jsonobject.put(s, settings.misc.get(s)))
        {
            s = (String)iterator1.next();
        }

        double d1;
        double d2;
        JSONObject jsonobject1;
        jsonobject1 = new JSONObject();
        jsonobject1.put("age", settings.userAge);
        jsonobject1.put("gender", settings.userGender.ordinal());
        jsonobject1.put("locale", settings.userCountry);
        jsonobject1.put("lang", settings.userLanguage);
        jsonobject1.put("zip", settings.userZip);
        jsonobject1.put("income", settings.userIncomeRange.ordinal());
        jsonobject1.put("education", settings.userEducation.ordinal());
        jsonobject1.put("race", settings.userRace.ordinal());
        jsonobject1.put("interests", obj);
        jsonobject1.put("misc", jsonobject);
        d1 = bo.a;
        d2 = bo.b;
        if (d1 != 0.0D || d2 != 0.0D)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        jsonobject1.put("long", settings.userLongitude);
        jsonobject1.put("lat", settings.userLatitude);
        return jsonobject1;
        jsonobject1.put("long", d2);
        jsonobject1.put("lat", d1);
        return jsonobject1;
    }

    public static JSONObject a(at at1)
    {
        JSONArray jsonarray;
        try
        {
            jsonarray = new JSONArray();
            for (Iterator iterator = at1.t.iterator(); iterator.hasNext(); jsonarray.put((String)iterator.next())) { }
        }
        // Misplaced declaration of an exception variable
        catch (at at1)
        {
            ad.a("Error creating JSON device info", at1);
            return null;
        }
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("sdk_version", at1.a);
        jsonobject.put("timezone", at1.y);
        jsonobject.put("make", at1.b);
        jsonobject.put("width", at1.j);
        jsonobject.put("height", at1.k);
        jsonobject.put("carrier", at1.l);
        jsonobject.put("mcc", at1.z);
        jsonobject.put("mnc", at1.A);
        jsonobject.put("color_depth", at1.m);
        jsonobject.put("model", at1.c);
        jsonobject.put("OS", at1.d);
        jsonobject.put("OS_version", at1.e);
        jsonobject.put("udid", at1.f);
        jsonobject.put("opt-out", at1.g);
        jsonobject.put("androidID", at1.h);
        jsonobject.put("connection", at1.i);
        jsonobject.put("disk_space", at1.o);
        jsonobject.put("heap", at1.n);
        jsonobject.put("bandwith", at1.p);
        jsonobject.put("accelerometer", at1.q);
        jsonobject.put("gps", at1.r);
        jsonobject.put("gyroscope", at1.s);
        jsonobject.put("apps", jsonarray);
        jsonobject.put("networkISO", at1.v);
        jsonobject.put("simISO", at1.u);
        jsonobject.put("carrierCountryISO", at1.w);
        jsonobject.put("user_agent", at1.B);
        jsonobject.put("location_access", at1.D);
        return jsonobject;
    }

    public static JSONObject a(at at1, Settings settings, z z, TremorVideo.a a1, String s, boolean flag)
    {
        try
        {
            z = new JSONObject();
            z.put("version", "3.8.0.0");
            z.put("adtype", "video");
            z.put("mode", 38);
            z.put("placement", a1.ordinal());
            z.put("previous_session_id", ad.z());
            z.put("appId", 0);
            z.put("device_info", a(at1));
            z.put("user_info", a(settings));
            at1 = new JSONObject();
            a1 = new JSONArray();
            for (Iterator iterator = settings.category.iterator(); iterator.hasNext(); a1.put((String)iterator.next())) { }
        }
        // Misplaced declaration of an exception variable
        catch (at at1)
        {
            ad.a("Error creating JSON request", at1);
            return null;
        }
        JSONArray jsonarray;
        jsonarray = new JSONArray();
        for (Iterator iterator1 = settings.adBlocks.iterator(); iterator1.hasNext(); jsonarray.put((String)iterator1.next())) { }
        at1.put("cid", 0);
        at1.put("pid", 0);
        at1.put("cch", s);
        at1.put("cp", "");
        at1.put("cat", a1);
        at1.put("preferred_orientation", settings.preferredOrientation.ordinal());
        at1.put("adBlocks", jsonarray);
        at1.put("policyId", settings.policyID);
        at1.put("maxAdTimeSeconds", settings.maxAdTimeSeconds);
        at1.put("contentID", settings.contentID);
        at1.put("contentDescription", settings.contentDescription);
        at1.put("contentTitle", settings.contentTitle);
        at1.put("bundleid", ad.i());
        at1.put("appversion", ad.j());
        at1.put("returnStreamingAd", flag);
        z.put("contextual_info", at1);
        ad.a(ad.d.c, z.toString(2));
        return z;
    }

    private static JSONObject a(Cookie cookie)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("name", cookie.getName());
            jsonobject.put("value", cookie.getValue());
            jsonobject.put("domain", cookie.getDomain());
            jsonobject.put("path", cookie.getPath());
            jsonobject.put("version", cookie.getVersion());
            jsonobject.put("isSecure", cookie.isSecure());
            cookie = cookie.getExpiryDate();
        }
        // Misplaced declaration of an exception variable
        catch (Cookie cookie)
        {
            ad.d("Error Storing cookie");
            return null;
        }
        if (cookie == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        jsonobject.put("expiryDate", cookie.getTime());
        return jsonobject;
    }

    public static void a()
    {
        SharedPreferences sharedpreferences;
        String s;
        try
        {
            if (b == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            sharedpreferences = ad.v().getSharedPreferences(c, 0);
            s = a(b);
        }
        catch (Exception exception)
        {
            ad.d((new StringBuilder()).append("saveCookies Exception=").append(exception).toString());
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (s.length() > 0)
        {
            sharedpreferences.edit().putString(d, s).commit();
        }
    }

    public static void a(Activity activity, br br1)
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        try
        {
            Settings settings = ad.t();
            jsonobject = new JSONObject();
            jsonobject1 = new JSONObject();
            jsonobject1.put("protocol_version", "3.8.0.0");
            jsonobject1.put("pid", 0);
            jsonobject1.put("cch", ad.o());
            jsonobject1.put("appId", 0);
            jsonobject1.put("policyId", settings.policyID);
            jsonobject1.put("init_tapResponse_delta", ad.D());
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ad.a("Error Sending Avail: ", activity);
            return;
        }
        if (br1 != null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        jsonobject1.put("session_id", 0);
        jsonobject1.put("tap_response_timestamp", "");
_L2:
        jsonobject.put("avail", jsonobject1);
        ad.a(ad.d.c, jsonobject.toString(2));
        a(activity, jsonobject.toString(), ad.e());
        return;
        jsonobject1.put("session_id", br1.c());
        jsonobject1.put("tap_response_timestamp", br1.a());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void a(Activity activity, String s)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("protocol_version", "3.8.0.0");
            jsonobject.put("cch", ad.o());
            jsonobject.put("state", s);
            jsonobject.put("timestamp", ad.a(new GregorianCalendar()));
            jsonobject.put("app", ad.n());
            jsonobject.put("app_version", ad.j());
            jsonobject.put("device_info", a(at.a()));
            s = new JSONObject();
            s.put("appAnalyticsStateChange", jsonobject);
            ad.a(ad.d.c, s.toString(2));
            a(activity, s.toString(), ad.h());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ad.a("Error Sending Custom Event: ", activity);
        }
    }

    private static void a(Activity activity, String s, String s1)
    {
        while (s1 == null || s1.equalsIgnoreCase("")) 
        {
            return;
        }
        activity.runOnUiThread(new Runnable(s, s1) {

            final String a;
            final String b;

            public void run()
            {
                try
                {
                    (new b(b, a)).execute(new String[0]);
                    return;
                }
                catch (Exception exception)
                {
                    ad.a("Error sending response: ", exception);
                }
            }

            
            {
                a = s;
                b = s1;
                super();
            }
        });
    }

    public static void a(Activity activity, String s, Map map)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            String s1;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); jsonobject.put(s1, map.get(s1)))
            {
                s1 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ad.a("Error Sending Custom Event: ", activity);
            return;
        }
        map = new JSONObject();
        map.put("protocol_version", "3.8.0.0");
        map.put("cch", ad.o());
        map.put("event", s);
        map.put("timestamp", ad.a(new GregorianCalendar()));
        map.put("app", ad.n());
        map.put("app_version", ad.j());
        map.put("parameters", jsonobject);
        map.put("device_info", a(at.a()));
        s = new JSONObject();
        s.put("appAnalyticsCustomEvent", map);
        ad.a(ad.d.c, s.toString(2));
        a(activity, s.toString(), ad.h());
        return;
    }

    public static void a(String s, long l)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("protocol_version", "3.8.0.0");
            jsonobject.put("cch", ad.o());
            jsonobject.put("timeDeltaMS", String.valueOf(l));
            jsonobject.put("startTime", s);
            jsonobject.put("app", ad.n());
            jsonobject.put("app_version", ad.j());
            s = at.b();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a(s);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        jsonobject.put("device_info", a(((at) (s))));
        jsonobject.put("cookies", ad.f().a());
        s = new JSONObject();
        s.put("appSessionEnd", jsonobject);
        ad.a(ad.d.c, s.toString(2));
        a(s.toString(), ad.h());
        return;
    }

    private static void a(String s, String s1)
    {
        try
        {
            (new c(s1, s)).execute(new String[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a("Error sending response: ", s);
        }
    }

    public static void a(String s, List list, boolean flag, int i)
    {
        ad.d((new StringBuilder()).append("Firing Tracking Pixel: ").append(s).toString());
        (new a(s, flag, list, i)).execute(new String[0]);
    }

    public static void a(HttpPost httppost, String s)
    {
        Object obj = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        obj = (new StringBuilder()).append("").append(((GregorianCalendar) (obj)).getTimeInMillis() / 1000L).toString();
        httppost.addHeader("mac", a((new StringBuilder()).append("a5e8fa6812cd60cfff77db9728ccfa70").append(s).append(((String) (obj))).toString()));
        httppost.addHeader("rts", ((String) (obj)));
    }

    public static void b()
    {
        Object obj;
        int i;
        i = 0;
        if (b == null)
        {
            b = new BasicCookieStore();
        }
        obj = ad.v().getSharedPreferences(c, 0).getString(d, null);
        if (obj == null || ((String) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        obj = new JSONArray(((String) (obj)));
_L1:
        int j = ((JSONArray) (obj)).length();
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        Cookie cookie = a(((JSONArray) (obj)).getJSONObject(i));
        if (cookie == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        b.addCookie(cookie);
_L2:
        i++;
          goto _L1
        Exception exception1;
        exception1;
        ad.d("Error loading cookie");
          goto _L2
        Exception exception;
        exception;
        ad.d("Error loading cookies from memory");
    }

    public static CookieStore c()
    {
        return b;
    }

    static int d()
    {
        int i = a + 1;
        a = i;
        return i;
    }

    static CookieStore e()
    {
        return b;
    }

}
