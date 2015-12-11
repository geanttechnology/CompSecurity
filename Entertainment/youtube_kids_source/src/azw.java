// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class azw extends azg
{

    private static final String e = (new StringBuilder("urn:x-cast:")).append("com.google.cast.media").toString();
    private static final long f;
    private static final long g;
    private static final long h;
    private static final long i;
    public final List d;
    private aux j;
    private final Handler k;
    private final baa l;
    private final baa m;
    private final baa n;
    private final baa o;
    private final baa p;
    private final baa q;
    private final baa r;
    private final baa s;
    private final baa t;
    private final baa u;
    private final Runnable v;
    private boolean w;

    public azw()
    {
        this(null);
    }

    private azw(String s1)
    {
        super(e, "MediaControlChannel", null);
        k = new Handler(Looper.getMainLooper());
        v = new azx(this);
        d = new ArrayList();
        l = new baa(g);
        d.add(l);
        m = new baa(f);
        d.add(m);
        n = new baa(f);
        d.add(n);
        o = new baa(f);
        d.add(o);
        p = new baa(h);
        d.add(p);
        q = new baa(f);
        d.add(q);
        r = new baa(f);
        d.add(r);
        s = new baa(f);
        d.add(s);
        t = new baa(f);
        d.add(t);
        u = new baa(f);
        d.add(u);
        f();
    }

    static List a(azw azw1)
    {
        return azw1.d;
    }

    private void a(long l1, JSONObject jsonobject)
    {
        int i1;
        int j1;
label0:
        {
            j1 = 1;
            boolean flag1 = l.a(l1);
            boolean flag;
            if (p.b() && !p.a(l1))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (q.b())
            {
                flag = j1;
                if (!q.a(l1))
                {
                    break label0;
                }
            }
            if (r.b() && !r.a(l1))
            {
                flag = j1;
            } else
            {
                flag = false;
            }
        }
        if (i1 != 0)
        {
            i1 = 2;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (flag)
        {
            j1 = i1 | 1;
        }
        if (flag1 || j == null)
        {
            j = new aux(jsonobject);
            SystemClock.elapsedRealtime();
            i1 = 7;
        } else
        {
            i1 = j.a(jsonobject, j1);
        }
        if ((i1 & 1) != 0)
        {
            SystemClock.elapsedRealtime();
            a();
        }
        if ((i1 & 2) != 0)
        {
            SystemClock.elapsedRealtime();
            a();
        }
        if ((i1 & 4) != 0)
        {
            b();
        }
        for (jsonobject = d.iterator(); jsonobject.hasNext(); ((baa)jsonobject.next()).a(l1, 0, null)) { }
    }

    private void a(boolean flag)
    {
label0:
        {
            if (w != flag)
            {
                w = flag;
                if (!flag)
                {
                    break label0;
                }
                k.postDelayed(v, i);
            }
            return;
        }
        k.removeCallbacks(v);
    }

    static boolean a(azw azw1, boolean flag)
    {
        azw1.w = false;
        return false;
    }

    static void b(azw azw1, boolean flag)
    {
        azw1.a(flag);
    }

    private long e()
    {
        if (j == null)
        {
            throw new IllegalStateException("No current media session");
        } else
        {
            return j.a;
        }
    }

    private void f()
    {
        a(false);
        j = null;
        l.a();
        p.a();
        q.a();
    }

    public final long a(azz azz)
    {
        JSONObject jsonobject = new JSONObject();
        long l1 = c();
        s.a(l1, azz);
        a(true);
        try
        {
            jsonobject.put("requestId", l1);
            jsonobject.put("type", "GET_STATUS");
            if (j != null)
            {
                jsonobject.put("mediaSessionId", j.a);
            }
        }
        // Misplaced declaration of an exception variable
        catch (azz azz) { }
        a(jsonobject.toString(), l1, null);
        return l1;
    }

    public final long a(azz azz, long l1, int i1, JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        long l2;
        jsonobject1 = new JSONObject();
        l2 = c();
        p.a(l2, azz);
        a(true);
        jsonobject1.put("requestId", l2);
        jsonobject1.put("type", "SEEK");
        jsonobject1.put("mediaSessionId", e());
        jsonobject1.put("currentTime", (double)l1 / 1000D);
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        jsonobject1.put("resumeState", "PLAYBACK_START");
_L4:
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (azz azz) { }
        }
        a(jsonobject1.toString(), l2, null);
        return l2;
_L2:
        if (i1 != 2) goto _L4; else goto _L3
_L3:
        jsonobject1.put("resumeState", "PLAYBACK_PAUSE");
          goto _L4
    }

    public final long a(azz azz, JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = c();
        m.a(l1, azz);
        a(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "PAUSE");
        jsonobject1.put("mediaSessionId", e());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (azz azz) { }
        }
        a(jsonobject1.toString(), l1, null);
        return l1;
    }

    public void a()
    {
    }

    public final void a(String s1)
    {
        a.a("message received: %s", new Object[] {
            s1
        });
        Object obj;
        Object obj1;
        long l1;
        obj = new JSONObject(s1);
        obj1 = ((JSONObject) (obj)).getString("type");
        l1 = ((JSONObject) (obj)).optLong("requestId", -1L);
        if (!((String) (obj1)).equals("MEDIA_STATUS"))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj = ((JSONObject) (obj)).getJSONArray("status");
        if (((JSONArray) (obj)).length() > 0)
        {
            a(l1, ((JSONArray) (obj)).getJSONObject(0));
            return;
        }
        try
        {
            j = null;
            a();
            b();
            s.a(l1, 0, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.b("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s1
            });
        }
        return;
        if (((String) (obj1)).equals("INVALID_PLAYER_STATE"))
        {
            a.b("received unexpected error: Invalid Player State.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (obj1 = d.iterator(); ((Iterator) (obj1)).hasNext(); ((baa)((Iterator) (obj1)).next()).a(l1, 2100, ((JSONObject) (obj)))) { }
            break MISSING_BLOCK_LABEL_347;
        }
        if (((String) (obj1)).equals("LOAD_FAILED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            l.a(l1, 2100, ((JSONObject) (obj)));
            return;
        }
        if (((String) (obj1)).equals("LOAD_CANCELLED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            l.a(l1, 2101, ((JSONObject) (obj)));
            return;
        }
        if (((String) (obj1)).equals("INVALID_REQUEST"))
        {
            a.b("received unexpected error: Invalid Request.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (Iterator iterator = d.iterator(); iterator.hasNext(); ((baa)iterator.next()).a(l1, 2100, ((JSONObject) (obj)))) { }
        }
    }

    public final long b(azz azz, JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = c();
        n.a(l1, azz);
        a(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "PLAY");
        jsonobject1.put("mediaSessionId", e());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (azz azz) { }
        }
        a(jsonobject1.toString(), l1, null);
        return l1;
    }

    public void b()
    {
    }

    public final void d()
    {
        f();
    }

    static 
    {
        f = TimeUnit.HOURS.toMillis(24L);
        g = TimeUnit.HOURS.toMillis(24L);
        h = TimeUnit.HOURS.toMillis(24L);
        i = TimeUnit.SECONDS.toMillis(1L);
    }
}
