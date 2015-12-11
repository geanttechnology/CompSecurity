// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils.do;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.NetworkInfo;
import io.presage.Presage;
import io.presage.do.d;
import io.presage.services.PresageServiceImp;
import io.presage.utils.c;
import io.presage.utils.do.do.a;
import io.presage.utils.do.do.f;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.entity.StringEntity;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.loopj.android.http.AsyncHttpClient;

// Referenced classes of package io.presage.utils.do:
//            a

public final class b
    implements io.presage.utils.do.a
{

    private String a;
    private String b;
    private int c;
    private List d;
    private Context e;
    private f f;
    private List g;
    private List h;
    private long i;
    private AsyncHttpClient j;
    private AsyncHttpClient k;
    private AsyncHttpClient l;
    private String m;
    private ThreadPoolExecutor n;

    public b()
    {
        n = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        b = "1.7.3";
        c = 27;
        i = Presage.getInstance().getContext().getSharedPreferences("presage", 0).getLong("timestampOffset", 0L);
        g = new CopyOnWriteArrayList();
        h = new ArrayList();
        j = new AsyncHttpClient();
        k = new AsyncHttpClient();
        l = new AsyncHttpClient();
        SharedPreferences sharedpreferences = Presage.getInstance().getContext().getSharedPreferences("presage", 0);
        int i1 = sharedpreferences.getInt("timeout_requests", 30000);
        int j1 = sharedpreferences.getInt("timeout_ads_inter", 5000);
        int k1 = sharedpreferences.getInt("timeout_ads_post", 5000);
        j.setTimeout(i1);
        k.setTimeout(j1);
        l.setTimeout(k1);
        j.setUserAgent(b());
        k.setUserAgent(b());
        l.setUserAgent(b());
        j.setThreadPool(n);
        k.setThreadPool(n);
        l.setThreadPool(n);
    }

    private HashMap a(Object obj)
    {
        HashMap hashmap;
        boolean flag;
        hashmap = new HashMap();
        hashmap.put("at", c());
        hashmap.put("version", b);
        hashmap.put("build", String.valueOf(c));
        Object obj1;
        try
        {
            obj1 = d().getResources().getConfiguration().locale.getISO3Country();
        }
        catch (MissingResourceException missingresourceexception)
        {
            missingresourceexception = "ZZZ";
        }
        hashmap.put("country", obj1);
        hashmap.put("apps_publishers", d);
        hashmap.put("content", obj);
        try
        {
            obj = io.presage.utils.c.a(d());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            hashmap.put("connectivity", "NONE");
            return hashmap;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        hashmap.put("connectivity", "UNKNOWN");
        return hashmap;
        missingresourceexception = io.presage.utils.c.a(d());
        if (missingresourceexception == null) goto _L2; else goto _L1
_L1:
        if (!missingresourceexception.isConnected() || missingresourceexception.getType() != 1) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap.put("connectivity", ((NetworkInfo) (obj)).getTypeName());
        return hashmap;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        StringBuilder stringbuilder = new StringBuilder(((NetworkInfo) (obj)).getTypeName());
        stringbuilder.append(" - ");
        stringbuilder.append(((NetworkInfo) (obj)).getSubtypeName());
        hashmap.put("connectivity", stringbuilder.toString());
        return hashmap;
    }

    private AsyncHttpClient a(a.a a1)
    {
        if (a1 == null)
        {
            return j;
        }
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[io.presage.utils.do.a.a.values().length];
                try
                {
                    a[io.presage.utils.do.a.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (io.presage.utils.do._cls1.a[a1.ordinal()])
        {
        default:
            return j;

        case 1: // '\001'
            return k;

        case 2: // '\002'
            return l;
        }
    }

    private boolean a(String s, String s1, Map map)
    {
        for (Iterator iterator = h.iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            boolean flag = d1.a(s, s1, map);
            if (flag && d1.a())
            {
                return false;
            }
            if (flag && !d1.a())
            {
                return true;
            }
        }

        return false;
    }

    private String c()
    {
        Object obj = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        simpledateformat.setTimeZone(((TimeZone) (obj)));
        try
        {
            obj = simpledateformat.format(Long.valueOf(simpledateformat.parse(a).getTime() - i * 1000L));
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
            return a;
        }
        return ((String) (obj));
    }

    private Context d()
    {
        if (e == null)
        {
            e = Presage.getInstance().getContext();
        }
        return e;
    }

    public final void a(int i1)
    {
        if (k != null && i1 > 0)
        {
            k.setTimeout(i1);
        }
    }

    public final void a(long l1)
    {
        i = l1;
    }

    public final void a(io.presage.utils.do.do.c c1)
    {
        g.remove(c1);
    }

    public final void a(String s, Object obj)
    {
        a(s, obj, ((io.presage.utils.do.do.b) (null)));
    }

    public final void a(String s, Object obj, io.presage.utils.do.do.b b1)
    {
        a(s, obj, b1, null);
    }

    public final void a(String s, Object obj, io.presage.utils.do.do.b b1, a.a a1)
    {
        Object obj1 = TimeZone.getTimeZone("UTC");
        Object obj2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        ((DateFormat) (obj2)).setTimeZone(((TimeZone) (obj1)));
        a = ((DateFormat) (obj2)).format(new Date());
        obj1 = Presage.getInstance().getId();
        d = Presage.getInstance().getAppsPublishers();
        if (obj1 != null && ((String) (obj1)).length() > 0)
        {
            a(a1).addHeader("User", ((String) (obj1)));
        }
        obj2 = a(obj);
        obj = (new Gson()).toJson(obj2).toString();
        Presage.getInstance().notifyAds(s, ((String) (obj)));
        if (a(((String) (obj1)), s, ((Map) (obj2))))
        {
            if (b1 != null)
            {
                b1.a(io.presage.utils.do.do.a.a("failure", null));
            }
            return;
        }
        obj1 = Presage.getInstance().getApiUrl(s);
        if (f == null)
        {
            f = io.presage.utils.do.do.f.a();
        }
        obj2 = f;
        b1 = io.presage.utils.do.do.f.a(d(), b1);
        b1.a(this);
        b1.a(((String) (obj1)));
        b1.b(((String) (obj)));
        boolean flag;
        if (a1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b1.a(flag);
        obj2 = g.iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            io.presage.utils.do.do.c c1 = (io.presage.utils.do.do.c)((Iterator) (obj2)).next();
            if (c1 != null)
            {
                c1.a(s, ((String) (obj)));
            }
        } while (true);
        g.add(b1);
        try
        {
            s = new StringEntity(((String) (obj)));
            a(a1).post(d(), ((String) (obj1)), s, "application/json", b1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public final void a(List list)
    {
        h = list;
    }

    public final boolean a()
    {
        if (d().getSharedPreferences("presage", 0).getBoolean("kill_sdk", false) || android.os.Build.VERSION.SDK_INT < 11)
        {
            if (Presage.getInstance().getService() != null)
            {
                Intent intent = new Intent();
                intent.setClass(d(), io/presage/services/PresageServiceImp);
                Presage.getInstance().getContext().stopService(intent);
            }
            return false;
        } else
        {
            return true;
        }
    }

    public final String b()
    {
        if (m == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            (new Formatter(stringbuilder)).format("%s/%s/%s", new Object[] {
                "1.7.3", Presage.getInstance().getKey(), android.os.Build.VERSION.RELEASE
            });
            m = stringbuilder.toString();
        }
        return m;
    }

    public final void b(int i1)
    {
        if (l != null && i1 > 0)
        {
            l.setTimeout(i1);
        }
    }

    public final void c(int i1)
    {
        if (j != null && i1 > 0)
        {
            j.setTimeout(i1);
        }
    }
}
