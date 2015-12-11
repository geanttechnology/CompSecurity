// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.appevents.AppEventsLogger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.w;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.models.f;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.network.managers:
//            ao, aq, a, an

public class ap
    implements ao
{

    private static final String a = com/smule/android/network/managers/ap.getName();
    private static ap b;
    private Context c;
    private w d;
    private List e;
    private boolean f;
    private boolean g;
    private String h;
    private long i;
    private String j;
    private String k;
    private long l;

    private ap()
    {
        f = true;
        g = false;
        i = 0L;
        j = "subscriptions";
        k = null;
        l = 0L;
    }

    static long a(ap ap1, long l1)
    {
        ap1.l = l1;
        return l1;
    }

    public static ap a()
    {
        com/smule/android/network/managers/ap;
        JVM INSTR monitorenter ;
        ap ap1;
        if (b == null)
        {
            b = new ap();
        }
        ap1 = b;
        com/smule/android/network/managers/ap;
        JVM INSTR monitorexit ;
        return ap1;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(ap ap1)
    {
        return ap1.k();
    }

    private void b(aq aq1)
    {
        if (aq1 != null && aq1.a != null && aq1.a.a())
        {
            h = aq1.d;
            if (aq1.b != null)
            {
                a(aq1.c, h);
            } else
            {
                aa.c(a, "No subscription found for this player.");
                a(0L, h);
            }
            l = SystemClock.elapsedRealtime();
        }
        g = false;
    }

    private void c(String s)
    {
        Intent intent = new Intent();
        intent.setAction(s);
        LocalBroadcastManager.getInstance(c).sendBroadcast(intent);
        com.smule.android.f.h.a().a(s, new Object[0]);
    }

    static String j()
    {
        return a;
    }

    private boolean k()
    {
        Object obj = com.smule.android.network.managers.a.a().a((new StringBuilder()).append(com.smule.android.network.core.b.d().n()).append(".").append(j).toString(), "definitions", k);
        if (obj == null || ((String) (obj)).length() == 0)
        {
            aa.a(a, "No definition value configured for A/B group subscriptions");
            return false;
        }
        e = new ArrayList();
        Object obj1;
        boolean flag;
        try
        {
            flag = n();
            obj = (JsonNode)com.smule.android.f.e.a().readValue(((String) (obj)), com/fasterxml/jackson/databind/JsonNode);
        }
        catch (JsonParseException jsonparseexception)
        {
            aa.b(a, "JSONParseException thrown parsing subscription packs JSON");
            return false;
        }
        catch (JsonMappingException jsonmappingexception)
        {
            aa.b(a, "JSONMappingException thrown parsing subscription packs JSON");
            return false;
        }
        catch (IOException ioexception)
        {
            aa.b(a, "IOException thrown parsing subscription packs JSON");
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = ((JsonNode) (obj)).iterator();
_L1:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj1 = (JsonNode)((Iterator) (obj)).next();
        obj1 = (f)com.smule.android.f.e.a().treeToValue(((com.fasterxml.jackson.core.TreeNode) (obj1)), com/smule/android/network/models/f);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj1.trial = false;
        e.add(obj1);
        aa.a(a, (new StringBuilder()).append("Subscription Pack:").append(((f) (obj1)).sku).append(" parsed from settings.").toString());
          goto _L1
        return true;
    }

    private void l()
    {
        SharedPreferences sharedpreferences = c.getSharedPreferences("SUBSCRIPTION_PREFERENCES", 0);
        i = sharedpreferences.getLong("PURCHASE_EXPIRATION_TIME", 0L);
        h = sharedpreferences.getString("PURCHASE_STATUS", null);
    }

    private void m()
    {
        android.content.SharedPreferences.Editor editor = c.getSharedPreferences("SUBSCRIPTION_PREFERENCES", 0).edit();
        editor.putBoolean("PURCHASE_SUBSCRIPTION", true);
        p.a(editor);
    }

    private boolean n()
    {
        return c.getSharedPreferences("SUBSCRIPTION_PREFERENCES", 0).getBoolean("PURCHASE_SUBSCRIPTION", false);
    }

    public void a(long l1)
    {
        i = l1;
        f = false;
        c("SUBSCRIPTION_UPDATED");
        com.smule.android.f.h.a().a("SUBSCRIPTION_UPDATED_NOTIFICATION", new Object[0]);
    }

    public void a(long l1, String s)
    {
        i = l1;
        android.content.SharedPreferences.Editor editor = c.getSharedPreferences("SUBSCRIPTION_PREFERENCES", 0).edit();
        editor.putLong("PURCHASE_EXPIRATION_TIME", i);
        editor.putString("PURCHASE_STATUS", s);
        p.a(editor);
        c("SUBSCRIPTION_UPDATED");
        com.smule.android.f.h.a().a("SUBSCRIPTION_UPDATED_NOTIFICATION", new Object[0]);
        aa.c(a, (new StringBuilder()).append("Subscription updated with expiration time: ").append(i).toString());
        if (g)
        {
            if (!b())
            {
                f = false;
            }
            String s1 = a;
            StringBuilder stringbuilder = (new StringBuilder()).append("Expiration update completed, Will ");
            if (f)
            {
                s = "";
            } else
            {
                s = "not ";
            }
            aa.c(s1, stringbuilder.append(s).append("check status on expiration.").toString());
        }
    }

    public void a(Context context)
    {
        c = context;
        d = w.a();
        context = new Observer() {

            final ap a;

            public void update(Observable observable, Object obj)
            {
                ap.a(a);
            }

            
            {
                a = ap.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("APP_SETTINGS_LOADED_EVENT", context);
        context = new Observer() {

            final ap a;

            public void update(Observable observable, Object obj)
            {
                ap.a(a, SystemClock.elapsedRealtime());
            }

            
            {
                a = ap.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("SUBSCRIPTION_PURCHASED", context);
        l();
    }

    public void a(aq aq1)
    {
        b(aq1);
    }

    public void a(String s)
    {
        k = s;
    }

    public void a(String s, int i1, String s1)
    {
        s = b(s);
        if (s != null)
        {
            s.a = i1;
            s.b = s1;
        }
    }

    public boolean a(String s, String s1, long l1, String s2)
    {
        s1 = d.a(s, s1, l1, s2);
        if (s1 != null)
        {
            m();
            s2 = new aq(this, s1);
            Iterator iterator = e.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                s1 = (f)iterator.next();
                if (((f) (s1)).sku.equals(s))
                {
                    if (((f) (s1)).trial)
                    {
                        s1 = "TRIAL";
                    } else
                    {
                        s1 = "PAID";
                    }
                    h = s1;
                }
            } while (true);
            a(((aq) (s2)).c, h);
            s = b(s);
            if (s != null && ((f) (s)).b != null)
            {
                float f1 = (float)((f) (s)).a / 1000000F;
                aa.a(a, (new StringBuilder()).append("Logging FBAppEvent.purchase(").append(f1).append(" ").append(((f) (s)).b).append(")").toString());
                AppEventsLogger.newLogger(c).logPurchase(new BigDecimal(f1), Currency.getInstance(((f) (s)).b));
            }
            return true;
        } else
        {
            return false;
        }
    }

    public f b(String s)
    {
        for (Iterator iterator = f().iterator(); iterator.hasNext();)
        {
            f f1 = (f)iterator.next();
            if (f1.sku.compareTo(s) == 0)
            {
                return f1;
            }
        }

        return null;
    }

    public boolean b()
    {
        boolean flag;
        if ((float)i > (float)System.currentTimeMillis() / 1000F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && i != 0L && !g && f)
        {
            aa.c(a, "subscription expired, updating status...");
            g = true;
            h();
        }
        return flag;
    }

    public boolean c()
    {
        return !b() && i != 0L;
    }

    public boolean d()
    {
        return b() && "TRIAL".equalsIgnoreCase(h);
    }

    public boolean e()
    {
        if (e == null)
        {
            return false;
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            if (((f)iterator.next()).trial)
            {
                return true;
            }
        }

        return false;
    }

    public List f()
    {
        if (e == null || e.size() == 0)
        {
            k();
        }
        return e;
    }

    public void g()
    {
        if (SystemClock.elapsedRealtime() - l < 0x927c0L)
        {
            aa.a(a, "updateSubscriptionStatusIfNeeded() - throttling");
            return;
        } else
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final ap a;

                public void run()
                {
                    a.h();
                }

            
            {
                a = ap.this;
                super();
            }
            });
            return;
        }
    }

    public void h()
    {
        (new an(this)).execute(new Void[0]);
    }

    public aq i()
    {
        return new aq(this, d.b());
    }

}
