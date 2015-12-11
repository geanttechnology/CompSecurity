// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.os.ConditionVariable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            ed, ba, ay, v, 
//            bq, au, ai, aj, 
//            en, eu, dx

public final class al extends ed
    implements ba
{

    private long a;
    private volatile long b;
    private ConditionVariable c;
    private ConditionVariable d;
    private v e;
    private ay f;
    private ay g;
    private ay h;
    private ay i;
    private String j;
    private Context k;
    private volatile boolean l;

    public al(Context context, v v1, ay ay1, ay ay2, ay ay3, ay ay4, String s)
    {
        a = System.currentTimeMillis();
        b = 10000L;
        c = new ConditionVariable(false);
        d = new ConditionVariable(false);
        l = false;
        k = context;
        f = ay1;
        g = ay2;
        h = ay3;
        i = ay4;
        e = v1;
        j = s;
        v1 = f;
        if (this != null)
        {
            synchronized (((ay) (v1)).c)
            {
                ((ay) (v1)).c.add(this);
            }
        }
    }

    private JSONObject a(JSONArray jsonarray)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("appID", e.a());
            jsonobject1.put("deviceID", e.c());
            jsonobject1.put("crPlatform", "android");
            jsonobject1.put("crVersion", e.d());
            jsonobject1.put("deviceModel", e.j());
            jsonobject1.put("osName", "android");
            jsonobject1.put("osVersion", e.k());
            jsonobject1.put("carrier", e.f());
            jsonobject1.put("mobileCountryCode", e.g());
            jsonobject1.put("mobileNetworkCode", e.h());
            jsonobject1.put("appVersion", e.b());
            jsonobject1.put("locale", (new bq()).a);
            jsonobject.put("appState", jsonobject1);
            jsonobject.put("transactions", jsonarray);
            if (b(jsonarray))
            {
                jsonobject.put("breadcrumbs", (new au(g)).a);
                jsonobject.put("endpoints", (new au(h)).a);
                jsonobject.put("systemBreadcrumbs", (new au(i)).a);
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            return null;
        }
        return jsonobject;
    }

    private static boolean b(JSONArray jsonarray)
    {
        int i1;
        boolean flag1;
        flag1 = false;
        i1 = 0;
_L1:
        Object obj;
        boolean flag;
        flag = flag1;
        if (i1 >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = jsonarray.optJSONArray(i1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        aj aj1;
        obj = (new ai(((JSONArray) (obj)))).g();
        if (obj == aj.c || obj == aj.i)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        aj1 = aj.h;
        if (obj == aj1)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        flag = true;
        return flag;
        Object obj1;
        obj1;
        en.a(((Throwable) (obj1)));
_L2:
        i1++;
          goto _L1
        obj1;
        en.a(((Throwable) (obj1)));
          goto _L2
    }

    public final void a()
    {
        do
        {
label0:
            {
                if (!l)
                {
                    c.block();
                    d.block();
                    if (!l)
                    {
                        break label0;
                    }
                }
                return;
            }
            long l1 = b - (System.currentTimeMillis() - a);
            ay ay1;
            JSONArray jsonarray;
            if (l1 > 0L)
            {
                try
                {
                    Thread.sleep(l1);
                }
                catch (InterruptedException interruptedexception) { }
            }
            a = System.currentTimeMillis();
            ay1 = f.a(k);
            f.a(ay1);
            jsonarray = (new au(ay1)).a;
            eu.a(ay1.a);
            if (jsonarray.length() > 0 && a(jsonarray) != null)
            {
                JSONObject jsonobject = a(jsonarray);
                try
                {
                    HttpURLConnection httpurlconnection = (new dx(new URL(j))).a();
                    OutputStream outputstream = httpurlconnection.getOutputStream();
                    outputstream.write(jsonobject.toString().getBytes("UTF8"));
                    outputstream.close();
                    httpurlconnection.getResponseCode();
                    httpurlconnection.disconnect();
                }
                catch (IOException ioexception)
                {
                    (new StringBuilder("Request failed for ")).append(j);
                    en.a();
                }
                catch (GeneralSecurityException generalsecurityexception)
                {
                    (new StringBuilder("Request failed for ")).append(j);
                    en.a();
                    en.a(generalsecurityexception);
                }
            }
        } while (true);
    }

    public final void a(int i1, TimeUnit timeunit)
    {
        b = timeunit.toMillis(i1);
    }

    public final void b()
    {
        c.open();
    }

    public final void c()
    {
        ay ay1 = f;
        d.open();
    }

    public final void d()
    {
        ay ay1 = f;
        d.close();
    }
}
