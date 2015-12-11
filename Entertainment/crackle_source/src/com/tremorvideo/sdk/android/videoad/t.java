// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.videoad.a.a;
import com.tremorvideo.sdk.android.videoad.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            u, aw, bv, bw, 
//            ad, ae, az, br

public class t extends u
{

    List r;
    List s;
    String t;
    boolean u;
    boolean v;

    public t(a a1, int j, boolean flag)
        throws Exception
    {
        super(j, flag);
        s = new ArrayList();
        u = true;
        v = true;
        v = false;
        a = n.b.e;
        p = true;
        s.addAll(a1.a());
        if (!a1.b())
        {
            z = a1.c();
            if (z.contains("?"))
            {
                z = z.substring(0, z.indexOf("?"));
            }
            B = (new StringBuilder()).append("H264-").append(a1.e()).append("x").append(a1.f()).append("-4x3").toString();
            t = a1.g();
            D = a1.h();
            T();
            if (!p)
            {
                a1 = new HashMap(4);
                a1.put("ad", this);
                a1.put("url", z.replace("|", "%7C"));
                a1.put("index", Integer.valueOf(0));
                r.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.b, "video", a1));
            }
        }
        if (b == null)
        {
            b = new ArrayList();
        }
    }

    public t(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        super(br, jsonobject);
        s = new ArrayList();
        u = true;
        v = true;
        v = true;
        w = 0;
        if (jsonobject.has("skip"))
        {
            x = jsonobject.getBoolean("skip");
        } else
        {
            x = false;
        }
        if (jsonobject.has("skip-delay"))
        {
            y = jsonobject.getInt("skip-delay");
        } else
        {
            y = 3;
        }
        E = com.tremorvideo.sdk.android.videoad.u.a.a;
        e = null;
        F = null;
        if (jsonobject.has("watermark"))
        {
            N = jsonobject.getBoolean("watermark");
        } else
        {
            N = true;
        }
        r = new ArrayList();
        if (!jsonobject.has("url")) goto _L2; else goto _L1
_L1:
        br = new HashMap(2);
        br.put("url", jsonobject.get("url"));
        r.add(new n.a(this, bf.d.e, "vast", br));
_L4:
        a(jsonobject);
        return;
_L2:
        if (jsonobject.has("vastdoc"))
        {
            a("vast", new a(jsonobject.getString("vastdoc")));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void T()
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        if (t == null || t.length() <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L8:
        if (j >= b.size()) goto _L4; else goto _L3
_L3:
        aw aw1 = (aw)b.get(j);
        if (aw1.a() != com.tremorvideo.sdk.android.videoad.aw.b.b) goto _L6; else goto _L5
_L5:
        b.remove(aw1);
_L4:
        if (v)
        {
            b.add(new aw(com.tremorvideo.sdk.android.videoad.aw.b.b, t, d("click")));
        } else
        {
            b.add(new aw(com.tremorvideo.sdk.android.videoad.aw.b.b, t, d("click"), 100));
        }
_L2:
        if (v)
        {
            bw abw[] = d("close");
            if (abw.length > 0)
            {
                aw aw2 = n();
                if (aw2 != null)
                {
                    b.remove(aw2);
                }
                b.add(new aw(aw.b.v, 0, abw));
            }
            return;
        } else
        {
            b.add(new aw(aw.b.v, 0, d("close"), 100));
            return;
        }
_L6:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void U()
    {
        if (u)
        {
            u = false;
            a(aw.b.j, 0, "impression");
            a(aw.b.j, 0, "creativeView");
            a(aw.b.j, 0, "start");
            a(aw.b.j, D / 4, "firstQuartile");
            a(aw.b.j, D / 2, "midPoint");
            a(aw.b.j, (D / 4) * 3, "thirdQuartile");
            a(aw.b.j, D, "complete");
        }
    }

    private void a(aw.b b1, int j, String s1)
    {
label0:
        {
            s1 = d(s1);
            if (s1.length > 0)
            {
                if (!v)
                {
                    break label0;
                }
                b.add(new aw(b1, j, s1));
            }
            return;
        }
        b.add(new aw(b1, j, s1, 100));
    }

    public int A()
    {
        return D;
    }

    public int E()
    {
        return Math.round((float)D / 1000F);
    }

    public List a()
    {
        return r;
    }

    public void a(Context context)
    {
        k = true;
        d = new bv();
        d.a();
    }

    public void a(String s1, Object obj)
        throws Exception
    {
        if (s1.equalsIgnoreCase("vast"))
        {
            s1 = (a)obj;
            s.addAll(s1.a());
            if (s1.b())
            {
                if (v)
                {
                    obj = new HashMap(2);
                    ((Map) (obj)).put("url", s1.d());
                    r.add(new n.a(this, bf.d.e, "vast", ((Map) (obj))));
                    if (r.size() > 100)
                    {
                        throw new Exception("Too many VAST hops.");
                    }
                }
            } else
            {
                z = s1.c();
                if (z.contains("?"))
                {
                    z = z.substring(0, z.indexOf("?"));
                }
                B = (new StringBuilder()).append("H264-").append(s1.e()).append("x").append(s1.f()).append("-4x3").toString();
                t = s1.g();
                D = s1.h();
                T();
                if (!p)
                {
                    s1 = new HashMap(4);
                    s1.put("ad", this);
                    s1.put("url", z.replace("|", "%7C"));
                    s1.put("index", Integer.valueOf(0));
                    r.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.b, "video", s1));
                }
            }
        }
    }

    protected void a(JSONObject jsonobject)
        throws Exception
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        if (jsonobject.has("event"))
        {
            jsonobject = jsonobject.getJSONArray("event");
            for (int j = 0; j < jsonobject.length(); j++)
            {
                aw aw1 = new aw(jsonobject.getJSONObject(j));
                b.add(aw1);
                if (aw1.a() == aw.b.av)
                {
                    n = aw1;
                }
            }

            if (o())
            {
                a(b);
            } else
            {
                b(b);
            }
            d(b);
        }
    }

    bw[] d(String s1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = s.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            if (b1.a.equalsIgnoreCase(s1))
            {
                arraylist.add(new bw(b1.b));
            }
        } while (true);
        return (bw[])arraylist.toArray(new bw[arraylist.size()]);
    }

    public boolean g(int j)
    {
        if (u && j > 0)
        {
            ad.d((new StringBuilder()).append("Building timer events with a duration of: ").append(j).append("ms").toString());
            D = j;
            U();
            return true;
        } else
        {
            return false;
        }
    }

    public String i()
    {
        return b(z);
    }

    public String[] k()
    {
        ArrayList arraylist = new ArrayList();
        if (!p)
        {
            arraylist.add(b(z));
        }
        if (c != null)
        {
            arraylist.add(b(c.c()));
        }
        if (e != null)
        {
            arraylist.add(b(e.c()));
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    public boolean m()
    {
        return z != null;
    }
}
