// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class akx
    implements ami
{

    final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    final bhv c = new ale(this);
    final Context d;
    final amd e;
    final Map f = new ConcurrentHashMap();
    final Map g = new ConcurrentHashMap();
    final Map h = new ConcurrentHashMap();
    final CopyOnWriteArrayList i = new CopyOnWriteArrayList();
    final Handler j;
    final bkn k;
    final chq l;
    boolean m;
    private final CopyOnWriteArrayList n = new CopyOnWriteArrayList();
    private final SharedPreferences o;
    private final amr p;
    private final cfu q;
    private final boolean r;
    private final Set s = new HashSet();
    private final bje t;
    private final boolean u;
    private boolean v;

    public akx(Context context, Executor executor, bje bje1, SharedPreferences sharedpreferences, amr amr1, bkn bkn1, amd amd1, 
            boolean flag, boolean flag1, chq chq1, cgk cgk1)
    {
        p = (amr)b.a(amr1);
        k = (bkn)b.a(bkn1);
        e = (amd)b.a(amd1);
        l = (chq)b.a(chq1);
        t = (bje)b.a(bje1);
        o = (SharedPreferences)b.a(sharedpreferences);
        r = flag;
        u = flag1;
        b.a(executor);
        d = context;
        q = new cfm(flag, cgk1.a(), cgk1.a());
        executor.execute(new aky(this));
        j = new ala(this, bkn1, amr1, chq1, flag1, amd1, cqg.a(executor, new akz(this, new cfh(cgk1.a()))));
    }

    static als a(akx akx1, cgt cgt1)
    {
        return akx1.a(cgt1);
    }

    private als a(cgt cgt1)
    {
        for (Iterator iterator = n.iterator(); iterator.hasNext();)
        {
            als als1 = (als)(ame)iterator.next();
            if (als1.a.g.equals(cgt1))
            {
                return als1;
            }
        }

        return null;
    }

    static void a(akx akx1, als als1)
    {
        als als2 = akx1.a(als1.a.g);
        if (als2 != null)
        {
            Object obj = akx1.l;
            obj = String.valueOf(als2);
            (new StringBuilder(String.valueOf(obj).length() + 26)).append("Removing duplicate device ").append(((String) (obj)));
            akx1.a(als2);
        }
        akx1.n.add(als1);
        akx1.a.add(als1);
        akx1.a(((ame) (als1)));
    }

    String a(cgw cgw1)
    {
        this;
        JVM INSTR monitorenter ;
        c();
        if (!g.containsKey(cgw1.g)) goto _L2; else goto _L1
_L1:
        cgw1 = ((alc)g.get(cgw1.g)).a;
_L4:
        this;
        JVM INSTR monitorexit ;
        return cgw1;
_L2:
        cgw1 = cgw1.c;
        if (true) goto _L4; else goto _L3
_L3:
        cgw1;
        throw cgw1;
    }

    public final List a()
    {
        return a;
    }

    void a(als als1)
    {
        Object obj = l;
        obj = String.valueOf(als1);
        (new StringBuilder(String.valueOf(obj).length() + 21)).append("Removing dial device ").append(((String) (obj)));
        n.remove(als1);
        a.remove(als1);
        h.remove(als1.a.g);
        b(als1);
    }

    void a(ame ame1)
    {
        t.d(new amg(true, ame1));
    }

    public final void a(String s1)
    {
        s.remove(s1);
        if (s.isEmpty())
        {
            m = false;
            j.removeMessages(0);
            j.removeMessages(1);
        }
    }

    void b()
    {
        j.removeMessages(2);
        if (!k.c() && !k.d() || !k.a())
        {
            chq chq1;
            if (!n.isEmpty())
            {
                chq1 = l;
            }
            ame ame1;
            for (Iterator iterator = n.iterator(); iterator.hasNext(); b(ame1))
            {
                ame1 = (ame)iterator.next();
                a.remove(ame1);
            }

            n.clear();
            return;
        } else
        {
            bmx bmx1 = new bmx(new ConcurrentHashMap());
            bmx1.addAll(n);
            j.sendMessageDelayed(Message.obtain(j, 2, bmx1), 9500L);
            q.a(new alf(this, bmx1));
            return;
        }
    }

    void b(ame ame1)
    {
        t.d(new amg(false, ame1));
    }

    public final void b(String s1)
    {
        if (s.isEmpty())
        {
            m = true;
            p.b(null);
            p.a(c);
            b();
            m = true;
            if (u)
            {
                j.sendEmptyMessageDelayed(0, 500L);
            } else
            {
                j.sendEmptyMessageDelayed(0, 5000L);
            }
            j.sendEmptyMessageDelayed(1, 10000L);
        }
        s.add(s1);
    }

    void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (!r) goto _L2; else goto _L1
_L1:
        boolean flag = v;
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        Object obj = o.getString("youtube.mdx:dial_devices", "[]");
        JSONArray jsonarray = new JSONArray(((String) (obj)));
        int i1 = 0;
_L4:
        if (i1 >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = jsonarray.optJSONObject(i1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        Integer integer;
        cgt cgt1;
        String s1;
        String s2;
        String s3;
        if (!((JSONObject) (obj)).has("id"))
        {
            break MISSING_BLOCK_LABEL_190;
        }
        cgt1 = new cgt(((JSONObject) (obj)).getString("id"));
        s1 = ((JSONObject) (obj)).optString("name", "unnamed");
        s2 = ((JSONObject) (obj)).optString("ssid", null);
        s3 = ((JSONObject) (obj)).optString("mac", null);
        integer = Integer.valueOf(((JSONObject) (obj)).optInt("timeout", -1));
        obj = integer;
        if (integer.intValue() <= 0)
        {
            obj = null;
        }
        obj = new alc(s1, s3, ((Integer) (obj)), s2);
        g.put(cgt1, obj);
        i.add(cgt1);
        i1++;
          goto _L4
        Object obj1;
        obj1;
        bmo.a("Error loading dial devices from pref", ((Throwable) (obj1)));
        v = true;
        if (true) goto _L2; else goto _L5
_L5:
        obj1;
        throw obj1;
    }

    void c(ame ame1)
    {
        Object obj = l;
        obj = String.valueOf(ame1);
        (new StringBuilder(String.valueOf(obj).length() + 22)).append("Removing cloud screen ").append(((String) (obj)));
        b.remove(ame1);
        a.remove(ame1);
        b(ame1);
    }

    void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (r) goto _L2; else goto _L1
_L1:
        String s1 = (new JSONArray()).toString();
        o.edit().putString("youtube.mdx:dial_devices", s1).apply();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        for (; i.size() > 10; g.remove(i.remove(0))) { }
        break MISSING_BLOCK_LABEL_84;
        Exception exception;
        exception;
        throw exception;
        JSONArray jsonarray;
        Iterator iterator;
        jsonarray = new JSONArray();
        iterator = i.iterator();
_L3:
        cgt cgt1;
        alc alc1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_216;
            }
            cgt1 = (cgt)iterator.next();
            alc1 = (alc)g.get(cgt1);
        } while (alc1 == null);
        jsonarray.put((new JSONObject()).putOpt("id", cgt1).putOpt("name", alc1.a).putOpt("ssid", alc1.d).putOpt("mac", alc1.b).putOpt("timeout", alc1.c));
          goto _L3
        JSONException jsonexception;
        jsonexception;
        bmo.a("Error saving dial devices to pref", jsonexception);
          goto _L3
        o.edit().putString("youtube.mdx:dial_devices", jsonarray.toString()).apply();
          goto _L4
    }

    public final void onMdxScreenDisconnecting(amh amh1)
    {
        amh1 = amh1.a;
        if (a.contains(amh1) && amh1.g())
        {
            b.remove(amh1);
            a.remove(amh1);
            b(amh1);
        }
    }
}
