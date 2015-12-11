// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils.do.do;

import android.content.Context;
import io.presage.ads.NewAd;
import io.presage.formats.NewFormatDescriptor;
import io.presage.if.b;
import io.presage.if.c;
import io.presage.int.g;
import io.presage.int.i;
import io.presage.model.Parameter;
import io.presage.utils.do.a;
import io.presage.utils.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.HttpResponseException;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.GsonBuilder;
import shared_presage.com.google.gson.JsonObject;
import shared_presage.com.google.gson.JsonParser;
import shared_presage.com.loopj.android.http.AsyncHttpResponseHandler;

// Referenced classes of package io.presage.utils.do.do:
//            c, a, b, e

public final class d extends AsyncHttpResponseHandler
    implements io.presage.utils.do.do.c
{

    private i a;
    private Context b;
    private io.presage.utils.do.do.b c;
    private String d;
    private String e;
    private WeakReference f;
    private List g;
    private boolean h;

    public d(Context context, io.presage.utils.do.do.b b1)
    {
        b = context;
        c = b1;
        g = new ArrayList();
        h = false;
    }

    private static void a()
    {
        io.presage.utils.e.c(new String[] {
            "DEBUG", "Request failed"
        });
    }

    private void c(String s)
    {
        try
        {
            s = (Map)(new Gson()).fromJson(new String(s), java/util/Map);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            ((a)f.get()).a(this);
            return;
        }
        if (s != null)
        {
            Iterator iterator = s.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (String)iterator.next();
                if (a == null)
                {
                    a = i.a();
                }
                i j = a;
                obj = i.a(((String) (obj)), ((String) (obj)));
                if (obj != null)
                {
                    ((g) (obj)).a(s);
                    ((g) (obj)).a(g);
                    ((g) (obj)).a(c);
                }
            } while (true);
            if (c != null)
            {
                c.a(io.presage.utils.do.do.a.a("success", s));
            }
        }
        ((a)f.get()).a(this);
    }

    public final void a(a a1)
    {
        f = new WeakReference(a1);
    }

    public final void a(String s)
    {
        d = s;
    }

    public final void a(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", s);
        hashmap.put("content", s1);
        g.add(hashmap);
    }

    public final void a(boolean flag)
    {
        h = flag;
    }

    public final void b(String s)
    {
        e = s;
    }

    public final void onFailure(Throwable throwable)
    {
        if (c != null)
        {
            c.a(io.presage.utils.do.do.a.a("failure", null));
        }
        if (throwable instanceof HttpResponseException)
        {
            int j = ((HttpResponseException)throwable).getStatusCode();
            if (j >= 400 && j < 500)
            {
                return;
            }
        }
        a();
        ((a)f.get()).a(this);
    }

    public final void onFailure(Throwable throwable, String s)
    {
        if (c != null)
        {
            c.a(io.presage.utils.do.do.a.a("failure", null));
        }
        if (throwable instanceof HttpResponseException)
        {
            int j = ((HttpResponseException)throwable).getStatusCode();
            if (j >= 400 && j < 500)
            {
                return;
            }
        }
        a();
        ((a)f.get()).a(this);
    }

    public final void onSuccess(String s)
    {
        Object obj;
        try
        {
            obj = (JsonObject)(new JsonParser()).parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (((JsonObject) (obj)).has("ad"))
        {
            obj = (NewAd)(new GsonBuilder()).registerTypeAdapter(io/presage/model/Parameter, new c()).registerTypeAdapter((new io.presage.utils.do.do.e(this)).getType(), new b()).create().fromJson(((JsonObject) (obj)).getAsJsonObject("ad"), io/presage/ads/NewAd);
            String s1 = ((NewAd) (obj)).getFormatDescriptor().getType();
            String s2 = (String)((NewAd) (obj)).getFormatDescriptor().getParameterValue("helper", java/lang/String);
            boolean flag;
            if ("multi_webviews".equals(s1) || "launch_activity".equals(s1) && "multi_webviews".equals(s2))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (c != null)
                {
                    s = new HashMap();
                    s.put("flow", "new");
                    s.put("ad", obj);
                    c.a(io.presage.utils.do.do.a.a("success", s));
                }
                return;
            }
        }
        c(s);
    }
}
