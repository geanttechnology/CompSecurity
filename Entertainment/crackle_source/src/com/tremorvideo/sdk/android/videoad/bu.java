// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.io.BufferedInputStream;
import java.util.GregorianCalendar;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad

public class bu
    implements ax.a, ax.e
{
    public static interface a
    {

        public abstract void a(int j, int k, int l);

        public abstract void a(String s);

        public abstract void a(JSONObject jsonobject);

        public abstract void h();
    }

    class b extends AsyncTask
    {

        final bu a;

        protected transient String a(String as[])
        {
            Object obj = null;
            Object obj1;
            Object obj2;
            try
            {
                obj2 = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj2)), 18000);
                HttpConnectionParams.setSoTimeout(((HttpParams) (obj2)), 18000);
                ((HttpParams) (obj2)).setBooleanParameter("http.protocol.expect-continue", false);
                ((HttpParams) (obj2)).setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
                obj1 = a.h.replace("__ZIP__", a.d).replace("__DATE__", bu.a(a));
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                ad.a("Error Sending Response: Exectuing POST", as);
                return null;
            }
            as = ((String []) (obj1));
            if (a.e.length() > 0)
            {
                as = ((String) (obj1)).replace("__ID__", a.e);
            }
            ad.d((new StringBuilder()).append("TMS Date: ").append(bu.a(a)).toString());
            ad.d((new StringBuilder()).append("TMS URL: ").append(as).toString());
            obj1 = new DefaultHttpClient(((HttpParams) (obj2)));
            obj2 = new HttpGet(as);
            ae.a(((HttpGet) (obj2)), as);
            obj1 = ((HttpClient) (obj1)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
            as = obj;
            if (!isCancelled())
            {
                as = bu.a(a, ((HttpResponse) (obj1)).getEntity());
            }
            return as;
        }

        protected void a(String s)
        {
            if (!isCancelled() && a.f == this)
            {
                bu.a(a, s);
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        b()
        {
            a = bu.this;
            super();
        }
    }


    int a;
    int b;
    int c;
    String d;
    String e;
    b f;
    a g;
    String h;
    private final String i = "http://data.tmsapi.com/v1/movies/__ID__/showings?startDate=__DATE__&zip=__ZIP__&api_key=dn3gkyv4pzcmfcp5fakh7raz&numDays=1&radius=20&units=mi";

    public bu()
    {
        d = "";
        e = "";
        h = null;
    }

    static String a(bu bu1)
    {
        return bu1.c();
    }

    static String a(bu bu1, HttpEntity httpentity)
        throws Exception
    {
        return bu1.a(httpentity);
    }

    private String a(HttpEntity httpentity)
        throws Exception
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(httpentity.getContent());
        httpentity = new StringBuilder(Math.max(0, (int)httpentity.getContentLength()));
        byte abyte0[] = new byte[1024];
        do
        {
            int j = bufferedinputstream.read(abyte0);
            if (j > 0)
            {
                httpentity.append(new String(abyte0, 0, j));
            } else
            {
                return httpentity.toString();
            }
        } while (true);
    }

    static void a(bu bu1, String s)
    {
        bu1.a(s);
    }

    private void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        f = null;
        a1 = g;
        ad.d(s);
        if (a1 == null || s == null) goto _L2; else goto _L1
_L1:
        Object obj = (new JSONTokener(s)).nextValue();
        if (!(obj instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        s = new JSONObject(s);
        if (!s.has("errorMessage")) goto _L6; else goto _L5
_L5:
        ad.d((new StringBuilder()).append("Error getting TMS data: ").append(s.getString("errorMessage")).toString());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        ad.d("Error getting TMS data.");
          goto _L2
        s;
        ad.a(s);
          goto _L2
        s;
        throw s;
_L4:
        if (!(obj instanceof JSONArray)) goto _L2; else goto _L7
_L7:
        JSONArray jsonarray = new JSONArray(s);
        if (jsonarray.length() <= 0) goto _L2; else goto _L8
_L8:
        JSONArray jsonarray1 = new JSONArray();
        int j = 0;
_L14:
        if (j >= jsonarray.length()) goto _L2; else goto _L9
_L9:
        s = jsonarray.getJSONObject(j);
        if (!s.has("showtimes")) goto _L11; else goto _L10
_L10:
        JSONArray jsonarray2 = s.getJSONArray("showtimes");
        int k = 0;
_L13:
        if (k >= jsonarray2.length()) goto _L11; else goto _L12
_L12:
        JSONObject jsonobject1;
        String as[];
        Object obj1;
        jsonobject1 = jsonarray2.getJSONObject(k);
        as = jsonobject1.getString("dateTime").split("T");
        obj1 = jsonobject1.getJSONObject("theatre");
        int l;
        obj = null;
        l = 0;
_L15:
        s = ((String) (obj));
        if (l < jsonarray1.length())
        {
            if (!jsonarray1.getJSONObject(l).getString("theatreId").equals(((JSONObject) (obj1)).getString("id")))
            {
                break MISSING_BLOCK_LABEL_556;
            }
            s = jsonarray1.getJSONObject(l);
        }
        obj = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_423;
        }
        obj = new JSONObject();
        ((JSONObject) (obj)).put("theatreId", ((JSONObject) (obj1)).getString("id"));
        ((JSONObject) (obj)).put("theatreName", ((JSONObject) (obj1)).getString("name"));
        obj1 = new JSONArray();
        s = new JSONObject();
        s.put("showtimes", obj1);
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(s);
        s = new JSONObject();
        s.put("day", as[0]);
        s.put("movies", obj1);
        JSONArray jsonarray3 = new JSONArray();
        jsonarray3.put(s);
        ((JSONObject) (obj)).put("theatreDays", jsonarray3);
        jsonarray1.put(obj);
        s = new JSONObject();
        s.put("datetime", jsonobject1.getString("dateTime"));
        if (jsonobject1.has("ticketURI"))
        {
            s.put("clickURL", jsonobject1.getString("ticketURI"));
        }
        ((JSONObject) (obj)).getJSONArray("theatreDays").getJSONObject(0).getJSONArray("movies").getJSONObject(0).getJSONArray("showtimes").put(s);
        k++;
          goto _L13
_L11:
        s = new JSONObject();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("theatres", jsonarray1);
        s.put("theatresAndShowtimesByMovie", jsonobject);
        a1.a(s);
        j++;
          goto _L14
        l++;
          goto _L15
    }

    private String c()
    {
        return String.format("%04d-%02d-%02d", new Object[] {
            Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c)
        });
    }

    public void a()
    {
        if (f == null)
        {
            f = new b();
            f.execute(new String[0]);
        }
    }

    public void a(aw.b b1, int j, int k, int l)
    {
        if (b1 == aw.b.F)
        {
            a(d, j, k + 1, l);
            g.a(j, k, l);
        }
    }

    public void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        g = a1;
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    public void a(String s, int j, int k, int l)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        if (d == s)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        d = s;
        flag = true;
        if (a == j && b == k && c == l)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        a = j;
        b = k;
        c = l;
        flag = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (g != null)
        {
            g.h();
        }
        b();
        a();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void a(String s, String s1, String s2, GregorianCalendar gregoriancalendar)
    {
        d = s;
        e = s1;
        if (s2 == null || s2.length() == 0)
        {
            h = "http://data.tmsapi.com/v1/movies/__ID__/showings?startDate=__DATE__&zip=__ZIP__&api_key=dn3gkyv4pzcmfcp5fakh7raz&numDays=1&radius=20&units=mi";
        } else
        {
            h = s2;
        }
        a = gregoriancalendar.get(1);
        b = gregoriancalendar.get(2) + 1;
        c = gregoriancalendar.get(5);
    }

    public void b()
    {
        if (f != null)
        {
            f.cancel(true);
            f = null;
        }
    }

    public void f(String s)
    {
        for (; s.length() < 5; s = (new StringBuilder()).append("0").append(s).toString()) { }
        a(s, a, b, c);
        g.a(s);
    }
}
