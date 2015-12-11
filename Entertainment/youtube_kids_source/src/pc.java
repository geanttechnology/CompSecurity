// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public class pc extends cod
{

    private static final Uri a = Uri.parse("https://www.youtube.com/leanback_ajax?action_environment=1");
    private static final Uri g = Uri.parse("https://www.youtube-nocookie.com/device_204");
    private final SharedPreferences h;
    private final qs i;
    private final crb j;
    private final cpz k;
    private final bmj l;
    private final cnf m;
    private final ConnectivityManager n;
    private final TelephonyManager o;
    private final bhv p = new pd(this);

    public pc(Context context, Executor executor, HttpClient httpclient, bmi bmi1, SharedPreferences sharedpreferences, qs qs1, bmj bmj1, 
            cnf cnf1, cpz cpz1)
    {
        super(executor, httpclient, bmi1);
        b.a(context);
        n = (ConnectivityManager)context.getSystemService("connectivity");
        o = (TelephonyManager)context.getSystemService("phone");
        h = (SharedPreferences)b.a(sharedpreferences);
        i = (qs)b.a(qs1);
        l = (bmj)b.a(bmj1);
        m = (cnf)b.b(cnf1, "deviceClassification cannot be null");
        context = new pe(this);
        j = a(a(cpc.a, context));
        k = (cpz)b.a(cpz1);
    }

    static void a(pc pc1, String s, long l1)
    {
        boolean flag1 = pc1.i.a();
        Object obj;
        bnf bnf1;
        boolean flag;
        if (!pc1.h.contains("dev_retention_first_geo"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            pc1.h.edit().putString("dev_retention_first_geo", s).putLong("dev_retention_first_active", l1).apply();
        }
        if (flag1 && !pc1.h.contains("dev_retention_first_login"))
        {
            pc1.h.edit().putLong("dev_retention_first_login", l1).apply();
        }
        bnf1 = bnf.a(g);
        obj = pc1.h.getString("dev_retention_uuid", null);
        s = ((String) (obj));
        if (obj == null)
        {
            s = UUID.randomUUID().toString();
            pc1.h.edit().putString("dev_retention_uuid", s).apply();
        }
        obj = bnf1.a("app_anon_id", s);
        ((bnf) (obj)).a("firstactive", Long.toString(pc1.h.getLong("dev_retention_first_active", 0L))).a("firstactivegeo", pc1.h.getString("dev_retention_first_geo", ""));
        if (pc1.h.contains("dev_retention_first_login"))
        {
            ((bnf) (obj)).a("firstlogin", Long.toString(pc1.h.getLong("dev_retention_first_login", 0L)));
        }
        if (pc1.h.contains("dev_retention_prev_active"))
        {
            ((bnf) (obj)).a("prevactive", Long.toString(pc1.h.getLong("dev_retention_prev_active", 0L)));
        }
        if (pc1.h.contains("dev_retention_prev_login"))
        {
            ((bnf) (obj)).a("prevlogin", Long.toString(pc1.h.getLong("dev_retention_prev_login", 0L)));
        }
        if (pc1.h.contains("dev_retention_intercepted_url"))
        {
            ((bnf) (obj)).a("intercepted_url", pc1.h.getString("dev_retention_intercepted_url", ""));
            pc1.h.edit().remove("dev_retention_intercepted_url").apply();
        }
        if (flag1)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        ((bnf) (obj)).a("loginstate", s);
        pc1.m.a(((bnf) (obj)));
        s = pc1.n.getActiveNetworkInfo();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.getType() != 1) goto _L4; else goto _L3
_L3:
        s = "wifi";
_L6:
        if (s != null)
        {
            ((bnf) (obj)).a("cnetwork", s);
        }
        s = ((bnf) (obj)).a.build();
        obj = String.valueOf(s);
        bmo.d((new StringBuilder(String.valueOf(obj).length() + 16)).append("Retention ping: ").append(((String) (obj))).toString());
        obj = pc1.k;
        obj = cpz.a("drp", 0x323467f);
        ((cqd) (obj)).a(s);
        obj.d = true;
        pc1.k.a(((cqd) (obj)), cni.b);
        pc1 = pc1.h.edit();
        pc1.putLong("dev_retention_prev_active", l1);
        if (flag1)
        {
            pc1.putLong("dev_retention_prev_login", l1);
        }
        pc1.apply();
        return;
_L4:
        if (s.getType() == 0 || s.getType() == 4 || s.getType() == 5 || s.getType() == 2 || s.getType() == 3)
        {
            if (pc1.o != null)
            {
                s = pc1.o.getNetworkOperatorName();
            } else
            {
                s = "mobile";
            }
            continue; /* Loop/switch isn't completed */
        }
        if (s.getType() == 7)
        {
            s = "bluetooth";
            continue; /* Loop/switch isn't completed */
        }
        if (s.getType() == 9)
        {
            s = "ethernet";
            continue; /* Loop/switch isn't completed */
        }
        if (s.getType() == 6)
        {
            s = "wimax";
            continue; /* Loop/switch isn't completed */
        }
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(Uri uri)
    {
        if (uri != null)
        {
            h.edit().putString("dev_retention_intercepted_url", uri.toString()).apply();
        }
        long l1 = h.getLong("dev_retention_last_ping_time_ms", 0L);
        long l2 = c.a();
        if (l2 - l1 >= 0xdbba00L && l.b())
        {
            h.edit().putLong("dev_retention_last_ping_time_ms", l2).apply();
            j.a(a, p);
        }
    }

}
