// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class akj
    implements amd, cfb
{

    static final IntentFilter a;
    private static final JSONObject h = new JSONObject();
    private static final Uri i = Uri.parse("http://");
    private static final long j;
    private static final Pattern k = Pattern.compile(".*#dial$");
    private static final IntentFilter l;
    private static final Map m;
    private boolean A;
    private cgc B;
    private final cff C;
    private final Map D = new HashMap();
    private Set E;
    private final String F;
    private final cgk G;
    private alw H;
    final Context b;
    final akn c = new akn(this);
    final aku d;
    final chq e;
    ame f;
    final Handler g;
    private final bmi n;
    private final ceq o;
    private final cfw p;
    private final bkn q;
    private final chf r;
    private final chl s;
    private final Map t = new HashMap();
    private final Map u = new HashMap();
    private final Map v = new HashMap();
    private final SharedPreferences w;
    private final cfm x;
    private final cho y;
    private final boolean z;

    public akj(Context context, bmi bmi1, bkn bkn, SharedPreferences sharedpreferences, cei cei, aku aku1, cho cho1, 
            chq chq1, chs chs, String s1, boolean flag, boolean flag1, cgk cgk1)
    {
        H = alw.f;
        n = (bmi)b.a(bmi1);
        w = (SharedPreferences)b.a(sharedpreferences);
        d = (aku)b.a(aku1);
        y = (cho)b.a(cho1);
        e = (chq)b.a(chq1);
        F = (String)b.a(s1);
        b = (Context)b.a(context);
        q = bkn;
        z = flag1;
        G = (cgk)b.a(cgk1);
        bmi1 = new chh(chs);
        p = new cfi(new chk(bmi1), chs);
        C = new cfh(cgk1.a());
        r = new chf(bmi1);
        s = new chi(bmi1);
        x = new cfm(flag, cgk1.a(), cgk1.a());
        bmi1 = new HandlerThread(getClass().getName(), 10);
        bmi1.start();
        g = new akq(this, bmi1.getLooper());
        context.registerReceiver(new aks(this), l);
        o = new ceq(context, cei, this, chq1);
    }

    static alu a(akj akj1, int i1)
    {
        switch (i1)
        {
        default:
            return alu.i;

        case 0: // '\0'
            return alu.b;

        case 1: // '\001'
            return alu.c;

        case 2: // '\002'
        case 3: // '\003'
            return alu.d;

        case 4: // '\004'
            return alu.f;
        }
    }

    private alw a(JSONObject jsonobject)
    {
        alx alx1 = (new alx()).b(jsonobject.optString("listId", ""));
        Object obj;
        int i1;
        if (jsonobject.has("videoId"))
        {
            obj = jsonobject.optString("videoId", "");
        } else
        {
            obj = jsonobject.optString("video_id", "");
        }
        obj = alx1.a(((String) (obj)));
        i1 = jsonobject.optInt("currentIndex", -1);
        if (i1 >= 0)
        {
            i1++;
        } else
        {
            i1 = -1;
        }
        return ((alx) (obj)).a(i1).a();
    }

    static ame a(akj akj1, ame ame1)
    {
        akj1.f = ame1;
        return ame1;
    }

    static cgc a(akj akj1, cgc cgc1)
    {
        if (cgc1.f != null)
        {
            return cgc1;
        }
        Object obj = akj1.e;
        if (akj1.u.containsKey(cgc1.c))
        {
            obj = akj1.e;
            obj = (cgj)akj1.u.get(cgc1.c);
        } else
        {
            obj = (cgj)akj1.r.a(Arrays.asList(new cgr[] {
                cgc1.c
            })).get(cgc1.c);
        }
        if (obj == null)
        {
            akj1 = akj1.e;
            cgc1 = String.valueOf(cgc1.c);
            akj1.b((new StringBuilder(String.valueOf(cgc1).length() + 45)).append("Unable to retrieve lounge token for screenId ").append(cgc1).toString());
            return null;
        } else
        {
            cgc cgc2 = cgc1.a(((cgj) (obj)));
            akj1.u.put(cgc1.c, obj);
            return cgc2;
        }
    }

    private cgf a(JSONObject jsonobject, cgh cgh1)
    {
        try
        {
            cgg cgg1 = new cgg();
            cgg1.a = cgh1;
            cgg1.b = jsonobject.getString("id");
            cgg1.c = jsonobject.getString("name");
            cgg1.d = new cgb(jsonobject.getString("clientName"));
            cgg1.e = jsonobject.getString("user");
            jsonobject = new cgf(cgg1.a, cgg1.b, null, cgg1.c, cgg1.d, cgg1.e);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            e.a("Error parsing device object", jsonobject);
            return null;
        }
        return jsonobject;
    }

    static chq a(akj akj1)
    {
        return akj1.e;
    }

    static void a(akj akj1, Context context, boolean flag)
    {
        if (akj1.o.h || akj1.o.a())
        {
            akj1.o.a(flag);
        }
        akj1.v();
        akj1 = akj1.d;
        akj1.l = "";
        akj1.k = "";
    }

    static void a(akj akj1, cgc cgc1, ako ako1)
    {
        akj1.a(cgc1, ako1);
    }

    static void a(akj akj1, cgl cgl1, cgo cgo1)
    {
        akj1.a(cgl1, cgo1);
    }

    static void a(akj akj1, cgw cgw1, ako ako1)
    {
        Object obj2 = null;
        if (!akj1.t.containsKey(cgw1)) goto _L2; else goto _L1
_L1:
        Object obj = (cgc)akj1.t.get(cgw1);
_L12:
        if (obj == null) goto _L4; else goto _L3
_L3:
        akj1.e.a("Found associated cloud screen %s for device %s", new Object[] {
            obj, cgw1
        });
        Object obj1;
        Object obj3;
        int i1;
        if (cgw1.d)
        {
            obj1 = akj1.C.a(cgw1.b);
        } else
        {
            obj1 = cgw1.a;
        }
        obj3 = akj1.e;
        i1 = ((cfy) (obj1)).c;
        (new StringBuilder(44)).append("Application status for device is ").append(i1);
        if (((cfy) (obj1)).c != 1) goto _L4; else goto _L5
_L5:
        obj1 = akj1.s.a(Arrays.asList(new cgc[] {
            obj
        }));
        boolean flag;
        if (obj1 != null && ((Map) (obj1)).containsKey(obj) && ((Boolean)((Map) (obj1)).get(obj)).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L6
_L6:
        obj1 = akj1.e;
        if (akj1.G.a()) goto _L8; else goto _L7
_L7:
        akj1.e.a("No a verticals remote, will not send a launch request.");
        akj1.a(((cgc) (obj)), ako1);
_L10:
        return;
_L2:
label0:
        {
            if (cgw1.a())
            {
                obj = cgw1.a.b;
            } else
            {
                obj = null;
            }
            obj1 = obj;
            if (obj == null)
            {
                obj = cgw1.g.toString();
                if (!akj1.w.contains(((String) (obj))))
                {
                    break label0;
                }
                obj1 = new cgr(akj1.w.getString(((String) (obj)), ""));
            }
            obj3 = (cgj)akj1.r.a(Arrays.asList(new cgr[] {
                obj1
            })).get(obj1);
            if (obj3 == null)
            {
                obj = akj1.e;
                obj1 = String.valueOf(obj1);
                ((chq) (obj)).b((new StringBuilder(String.valueOf(obj1).length() + 45)).append("Unable to retrieve lounge token for screenId ").append(((String) (obj1))).toString());
                obj = null;
            } else
            {
                if (cgw1.a() && cgw1.a.e)
                {
                    obj = cgn.c;
                } else
                {
                    obj = cgn.b;
                }
                obj = new cgc(((cgr) (obj1)), cgw1.c, null, ((cgj) (obj3)), ((cgn) (obj)));
                akj1.t.put(cgw1, obj);
            }
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        continue; /* Loop/switch isn't completed */
_L8:
        akj1.e.a("This is a verticals remote. Will stop the device first.");
        akj1.a(cgw1);
        akj1.t.remove(cgw1);
        akj1.w.edit().remove(cgw1.g.toString()).apply();
        obj = obj2;
_L4:
        akj1.a(cgw1, ako1);
        if (obj == null) goto _L10; else goto _L9
_L9:
        akj1.a(((cgc) (obj)), ako1);
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    static void a(akj akj1, cgw cgw1, cgc cgc1)
    {
        akj1.t.put(cgw1, cgc1);
        akj1.w.edit().putString(cgw1.g.toString(), cgc1.c.toString()).apply();
    }

    private void a(amb amb1)
    {
        if (amb1 == amb.g)
        {
            if (!d.f.a())
            {
                d.a(amn.b);
                d.b(amb.c);
            }
        } else
        {
            if (d.f.a())
            {
                d.c();
            }
            if (amb1.l)
            {
                d.a(amn.c);
            } else
            if (amb1 == amb.b)
            {
                d.a(amn.d);
            } else
            {
                d.a(amn.a);
            }
        }
        d.a(amb1);
    }

    private void a(cgc cgc1, ako ako1)
    {
        B = cgc1;
        b.registerReceiver(c, a);
        Object obj = new ceo();
        obj.c = cgc1.f;
        obj.e = cgc1.b;
        if (ako1.b.a())
        {
            obj.a = cgl.r;
            obj.b = e(ako1.b);
        }
        if (ako1.c)
        {
            obj.d = true;
        }
        ako1 = ((ceo) (obj)).a();
        cgc1 = String.valueOf(cgc1.c);
        obj = (new StringBuilder(String.valueOf(cgc1).length() + 20)).append("Connecting to ").append(cgc1).append(" with ").toString();
        if (ako1.a())
        {
            cgc1 = e;
            String s1 = String.valueOf(((cen) (ako1)).a);
            if (ako1.b())
            {
                cgc1 = ((cen) (ako1)).b;
            } else
            {
                cgc1 = "{}";
            }
            cgc1 = String.valueOf(cgc1);
            (new StringBuilder(String.valueOf(obj).length() + 3 + String.valueOf(s1).length() + String.valueOf(cgc1).length())).append(((String) (obj))).append(s1).append(" : ").append(cgc1);
        } else
        {
            cgc1 = e;
            String.valueOf(obj).concat("no message.");
        }
        o.a(ako1);
    }

    private void a(cgl cgl1, cgo cgo1)
    {
        Object obj = e;
        obj = String.valueOf(cgl1);
        String s1 = String.valueOf(cgo1);
        (new StringBuilder(String.valueOf(obj).length() + 11 + String.valueOf(s1).length())).append("Sending ").append(((String) (obj))).append(" : ").append(s1);
        o.a(cgl1, cgo1, ceq.a);
    }

    private void a(cgw cgw1)
    {
        if (cgw1.a == null || !cgw1.a.d) goto _L2; else goto _L1
_L1:
        if (!D.containsKey(cgw1.g)) goto _L4; else goto _L3
_L3:
        cgw1 = (Uri)D.get(cgw1.g);
_L6:
        chq chq1 = e;
        String s1 = String.valueOf(cgw1);
        chq1.a((new StringBuilder(String.valueOf(s1).length() + 24)).append("Sending stop request to ").append(s1).toString());
        if (cgw1 != null)
        {
            p.a(cgw1);
        }
_L2:
        return;
_L4:
        if (cgw1.d)
        {
            cgw1 = cgw1.b;
            if (cgw1 != null)
            {
                Object obj = C.a(cgw1);
                if (obj != null && ((cfy) (obj)).c == 1)
                {
                    obj = ((cfy) (obj)).a;
                    if (obj != null)
                    {
                        cgw1 = cgw1.buildUpon().appendPath(((String) (obj))).build();
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
        }
        cgw1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(akj akj1, boolean flag)
    {
        akj1.A = false;
        return false;
    }

    static Context b(akj akj1)
    {
        return akj1.b;
    }

    static cgc b(akj akj1, cgc cgc1)
    {
        akj1.B = null;
        return null;
    }

    private Map b(JSONObject jsonobject)
    {
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put(cgh.b, new HashSet());
        hashmap.put(cgh.a, new HashSet());
        jsonobject = new JSONArray(jsonobject.getString("devices"));
        int i1 = 0;
_L1:
        int j1 = jsonobject.length();
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        JSONObject jsonobject1;
        cgh cgh1;
        jsonobject1 = jsonobject.getJSONObject(i1);
        cgh1 = (cgh)m.get(jsonobject1.getString("type"));
        if (cgh1 == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        ((Set)hashmap.get(cgh1)).add(a(jsonobject1, cgh1));
_L2:
        i1++;
          goto _L1
        JSONException jsonexception;
        jsonexception;
        e.a("Error parsing lounge status message", jsonexception);
          goto _L2
        jsonobject;
        e.a("Error parsing lounge status message", jsonobject);
        return hashmap;
    }

    static void b(akj akj1, ame ame1)
    {
        if (ame1 != null && ame1.h() && akj1.u())
        {
            akj1.a(ame1.f().a);
        }
    }

    private void b(alw alw1)
    {
        H = alw1;
        if (H.a())
        {
            a(amb.i);
        }
    }

    static cgc c(akj akj1)
    {
        return akj1.B;
    }

    private void c(alw alw1)
    {
        if (d.i.a(alw1.a))
        {
            if (d.g != amb.c)
            {
                a();
            }
            return;
        } else
        {
            b(alw1);
            a(cgl.r, e(alw1));
            return;
        }
    }

    private void c(JSONObject jsonobject)
    {
        if (jsonobject.has("currentTime"))
        {
            d.a((long)jsonobject.getInt("currentTime") * 1000L);
        } else
        if (jsonobject.has("current_time"))
        {
            d.a((long)jsonobject.getInt("current_time") * 1000L);
            return;
        }
    }

    private static alw d(alw alw1)
    {
        if (!alw1.a())
        {
            return alw.f;
        }
        int i1;
        if ((long)alw1.b < 5000L)
        {
            i1 = 0;
        } else
        {
            i1 = alw1.b;
        }
        alw1 = new alx(alw1);
        alw1.b = i1;
        return alw1.a();
    }

    static ceq d(akj akj1)
    {
        return akj1.o;
    }

    private void d(JSONObject jsonobject)
    {
        if (jsonobject.has("state"))
        {
            a(amb.a(jsonobject.getInt("state")));
        }
    }

    static cfm e(akj akj1)
    {
        return akj1.x;
    }

    private static cgo e(alw alw1)
    {
        cgo cgo1 = new cgo();
        cgo1.a("videoId", alw1.a);
        cgo1.a("listId", alw1.d);
        int i1 = alw1.e;
        if (i1 > 0)
        {
            i1--;
        } else
        {
            i1 = -1;
        }
        cgo1.a("currentIndex", Integer.toString(i1));
        cgo1.a("currentTime", Long.toString(alw1.b / 1000));
        return cgo1;
    }

    private void e(JSONObject jsonobject)
    {
        if (d.j != null && jsonobject.has("currentTime"))
        {
            d.b(TimeUnit.SECONDS.toMillis(jsonobject.getInt("currentTime")));
        }
    }

    static Handler f(akj akj1)
    {
        return akj1.g;
    }

    private void f(JSONObject jsonobject)
    {
        if (d.j != null && jsonobject.has("adState"))
        {
            jsonobject = amb.a(jsonobject.getInt("adState"));
            if (((amb) (jsonobject)).l && !d.f.a())
            {
                d.a(amn.b);
                d.a(amb.g);
            }
            d.b(jsonobject);
        }
    }

    static aku g(akj akj1)
    {
        return akj1.d;
    }

    static cfw h(akj akj1)
    {
        return akj1.p;
    }

    static Map i(akj akj1)
    {
        return akj1.D;
    }

    static bkn j(akj akj1)
    {
        return akj1.q;
    }

    private void v()
    {
        d.a(amn.a);
        aku aku1 = d;
        aku1.a(amb.a);
        aku1.b();
        aku1.a(alw.f);
        d.c();
    }

    private void w()
    {
        if (i() != amj.b)
        {
            return;
        } else
        {
            y.a(new akk(this));
            return;
        }
    }

    public final void a()
    {
        a(cgl.j, cgo.a);
    }

    public final void a(int i1)
    {
        cgo cgo1 = new cgo();
        cgo1.a("newTime", String.valueOf(i1 / 1000));
        a(cgl.q, cgo1);
    }

    public final void a(int i1, int j1)
    {
        cgo cgo1 = new cgo();
        cgo1.a("delta", String.valueOf(j1));
        cgo1.a("volume", String.valueOf(i1));
        a(cgl.t, cgo1);
    }

    public final void a(alw alw1)
    {
        b.a(alw1.a());
        alw1 = d(alw1);
        if (d.d == amj.f)
        {
            a(f, alw1);
            return;
        } else
        {
            c(alw1);
            return;
        }
    }

    public final void a(ame ame1, alw alw1)
    {
        b.a(ame1);
        alw1 = d(alw1);
        boolean flag;
        if (d.d == amj.b && ame1.equals(f))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (alw1.a())
            {
                c(alw1);
                return;
            } else
            {
                ame1 = e;
                return;
            }
        } else
        {
            f = ame1;
            d.a(amj.a);
            v();
            E = new HashSet();
            b(alw1);
            ame1 = new ako(ame1, alw1, true);
            g.sendMessage(Message.obtain(g, 3, ame1));
            return;
        }
    }

    final void a(cgw cgw1, ako ako1)
    {
        if (!cgw1.d)
        {
            cgw1 = e;
            return;
        } else
        {
            A = true;
            Object obj = e;
            obj = String.valueOf(cgw1);
            String s1 = String.valueOf(cgw1.b);
            (new StringBuilder(String.valueOf(obj).length() + 31 + String.valueOf(s1).length())).append("Sending launch request for ").append(((String) (obj))).append(" to ").append(s1);
            p.a(cgw1.b, ako1.b.a, ako1.b.b, null, G.b, new akl(this, cgw1, ako1));
            return;
        }
    }

    public final void a(cxu cxu1)
    {
        b(cxu1);
    }

    public final void a(JSONArray jsonarray)
    {
_L2:
        return;
        if (i() == amj.e || jsonarray.length() == 0) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj = jsonarray.getString(0);
        if (jsonarray.length() > 1)
        {
            jsonarray = jsonarray.getJSONObject(1);
        } else
        {
            jsonarray = h;
        }
        obj2 = cgl.a(((String) (obj)));
        if (obj2 == null)
        {
            jsonarray = e;
            (new StringBuilder(String.valueOf(obj).length() + 27)).append("Invalid method: ").append(((String) (obj))).append(". Ignoring.");
            return;
        }
        obj = e;
        String s1 = String.valueOf(obj2);
        String s2 = String.valueOf(jsonarray);
        ((chq) (obj)).a((new StringBuilder(String.valueOf(s1).length() + 12 + String.valueOf(s2).length())).append("Received ").append(s1).append(" : ").append(s2).toString());
        akm.a[((cgl) (obj2)).ordinal()];
        JVM INSTR tableswitch 1 14: default 248
    //                   1 249
    //                   2 373
    //                   3 388
    //                   4 405
    //                   5 430
    //                   6 455
    //                   7 455
    //                   8 594
    //                   9 615
    //                   10 767
    //                   11 893
    //                   12 927
    //                   13 970
    //                   14 1258;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L16:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        jsonarray = b(jsonarray);
        E = (Set)jsonarray.get(cgh.a);
        jsonarray = (Set)jsonarray.get(cgh.b);
        if (!jsonarray.isEmpty())
        {
            d.a(amj.b);
            w();
            jsonarray = (cgf)jsonarray.iterator().next();
            v.put(B.c, ((cgf) (jsonarray)).b);
            return;
        }
        if (!A)
        {
            d.a(f);
            d.a(alu.g);
            return;
        }
          goto _L2
_L5:
        d.a(amj.b);
        w();
        return;
_L6:
        d.a(f);
        a(false);
        return;
_L7:
        jsonarray = a(((JSONObject) (jsonarray)), cgh.a);
        if (jsonarray != null)
        {
            E.add(jsonarray);
            return;
        }
          goto _L2
_L8:
        jsonarray = a(((JSONObject) (jsonarray)), cgh.a);
        if (jsonarray != null)
        {
            E.remove(jsonarray);
            return;
        }
          goto _L2
_L9:
        d.b();
        alw alw1 = a(((JSONObject) (jsonarray)));
        if (alw1.a())
        {
            d.a(alw1);
            if (!alw.f.equals(H))
            {
                if (d.i.a(H.a) && H.c != null)
                {
                    b(H.c);
                }
                H = alw.f;
            }
            c(jsonarray);
            d(jsonarray);
            return;
        }
        H = alw.f;
        v();
        if (!TextUtils.isEmpty(d.k))
        {
            d.a(d.k);
            return;
        }
          goto _L2
_L10:
        if (!H.a())
        {
            c(jsonarray);
            d(jsonarray);
            return;
        }
          goto _L2
_L11:
        Object obj1 = a(((JSONObject) (jsonarray)));
        if (!jsonarray.has("firstVideoId")) goto _L18; else goto _L17
_L17:
        d.b(jsonarray.getString("firstVideoId"));
_L20:
        if (!d.i.a(((alw) (obj1)).a))
        {
            e.a("CloudRemoteControl: playlist modified with new pending videoId: %s", new Object[] {
                ((alw) (obj1)).toString()
            });
            if (!((alw) (obj1)).a())
            {
                H = alw.f;
                return;
            }
            continue; /* Loop/switch isn't completed */
        } else
        {
            d.a(((alw) (obj1)).d);
            return;
        }
_L18:
        if (((alw) (obj1)).a()) goto _L20; else goto _L19
_L19:
        d.b("");
        d.a("");
        H = alw.f;
        return;
        if (H.a(((alw) (obj1)).a)) goto _L2; else goto _L21
_L21:
        H = ((alw) (obj1));
        return;
_L12:
        obj1 = jsonarray.optString("videoId", d.i.a);
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            int i1 = a.b(jsonarray.optString("format"), 1);
            jsonarray = cxu.a(jsonarray.optString("languageCode"), jsonarray.optString("languageName"), jsonarray.optString("trackName"), ((String) (obj1)), i1);
            obj1 = d;
            if (!b.a(((aku) (obj1)).i.c, jsonarray))
            {
                obj2 = new alx(((aku) (obj1)).i);
                obj2.c = jsonarray;
                obj1.i = ((alx) (obj2)).a();
                ((aku) (obj1)).a.d(new aml(jsonarray));
                return;
            }
        }
          goto _L2
_L13:
        if (jsonarray.has("errors") && jsonarray.getString("errors").length() > 0)
        {
            d.a(alu.i);
            return;
        }
          goto _L2
_L14:
        int j1 = jsonarray.optInt("volume", -1);
        if (j1 < 0) goto _L2; else goto _L22
_L22:
        jsonarray = d;
        jsonarray.r = j1;
        ((aku) (jsonarray)).a.d(new amp(j1));
        return;
_L15:
        if (!z) goto _L2; else goto _L23
_L23:
        obj2 = new bvd();
        if (!jsonarray.has("adVideoId")) goto _L25; else goto _L24
_L24:
        dla dla1;
        String s3;
        obj2.j = jsonarray.getString("adVideoId");
        dla1 = new dla();
        obj1 = String.valueOf("http://www.youtube.com/watch?v=");
        s3 = String.valueOf(jsonarray.getString("adVideoId"));
        if (s3.length() == 0) goto _L27; else goto _L26
_L26:
        obj1 = ((String) (obj1)).concat(s3);
_L28:
        dla1.c = ((String) (obj1));
        ((bvd) (obj2)).a(dla1);
_L32:
        obj2.c = jsonarray.getString("contentVideoId");
        if (jsonarray.has("isSkippable") && jsonarray.getBoolean("isSkippable"))
        {
            ((bvd) (obj2)).f(i);
        }
        obj2.r = jsonarray.getInt("duration");
        if (jsonarray.has("clickThroughUrl"))
        {
            obj2.w = Uri.parse(jsonarray.getString("clickThroughUrl"));
        }
        obj2.S = n.a() + j;
        d.j = ((bvd) (obj2)).a();
_L29:
        e(jsonarray);
        f(jsonarray);
        return;
_L27:
        obj1 = new String(((String) (obj1)));
          goto _L28
        JSONException jsonexception;
        jsonexception;
        e.a("Error receiving adPlaying message", jsonexception);
        d.c();
          goto _L29
_L25:
        dla1 = new dla();
        if (!jsonarray.has("adVideoUrl")) goto _L31; else goto _L30
_L30:
        jsonexception = jsonarray.getString("adVideoUrl");
_L33:
        dla1.c = jsonexception;
        ((bvd) (obj2)).a(dla1);
          goto _L32
_L31:
        jsonexception = "http://";
          goto _L33
        if (!z) goto _L2; else goto _L34
_L34:
        e(jsonarray);
        f(jsonarray);
        return;
    }

    public final void a(boolean flag)
    {
        if (d.d == amj.e)
        {
            return;
        } else
        {
            d.a(amj.d);
            Message message = Message.obtain(g, 4, new akp(f, flag));
            g.removeMessages(8);
            g.removeMessages(3);
            g.sendMessage(message);
            return;
        }
    }

    public final boolean a(ame ame1)
    {
        b.a(ame1);
        amj amj1 = d.d;
        return (amj1 == amj.b || amj1 == amj.a) && ame1.equals(f);
    }

    public final void b()
    {
        a(cgl.i, cgo.a);
    }

    public final void b(int i1)
    {
        cgo cgo1 = new cgo();
        cgo1.a("volume", String.valueOf(i1));
        a(cgl.t, cgo1);
    }

    void b(cxu cxu1)
    {
        cgo cgo1;
        sz sz1;
        HashMap hashmap;
        cyi cyi1;
        if (!d.i.a())
        {
            e.b("Can not send subtitle track, no confirmed video");
            return;
        }
        if (cxu1 == null || TextUtils.isEmpty(cxu1.a))
        {
            cxu1 = new cgo();
            cxu1.a("videoId", d.i.a);
            a(cgl.s, cxu1);
            return;
        }
        cgo1 = new cgo();
        cgo1.a("format", String.valueOf(cxu1.e));
        cgo1.a("kind", "");
        cgo1.a("languageCode", cxu1.a);
        cgo1.a("languageName", cxu1.b);
        cgo1.a("sourceLanguageCode", cxu1.a);
        cgo1.a("trackName", cxu1.c);
        cgo1.a("videoId", cxu1.d);
        sz1 = new sz(b, w, false, sz.a);
        float f1 = sz1.b();
        cyi1 = sz1.c();
        hashmap = new HashMap();
        hashmap.put("background", cyi.a(cyi1.a));
        hashmap.put("backgroundOpacity", cyi.b(cyi1.a));
        hashmap.put("color", cyi.a(cyi1.e));
        hashmap.put("textOpacity", cyi.b(cyi1.e));
        hashmap.put("fontSizeRelative", String.format("%.2f", new Object[] {
            Float.valueOf(f1)
        }));
        hashmap.put("windowColor", cyi.a(cyi1.b));
        hashmap.put("windowOpacity", cyi.b(cyi1.b));
        cyi1.d;
        JVM INSTR tableswitch 1 4: default 376
    //                   1 500
    //                   2 507
    //                   3 521
    //                   4 514;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        cxu1 = "none";
_L14:
        hashmap.put("charEdgeStyle", cxu1);
        cxu1 = "";
        cyi1.f;
        JVM INSTR tableswitch 0 6: default 440
    //                   0 528
    //                   1 535
    //                   2 542
    //                   3 549
    //                   4 556
    //                   5 563
    //                   6 570;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L6:
        break; /* Loop/switch isn't completed */
_L13:
        break MISSING_BLOCK_LABEL_570;
_L15:
        hashmap.put("fontFamilyOption", cxu1);
        cgo1.a("style", (new JSONObject(hashmap)).toString());
        if (sz1.c)
        {
            sz1.a().removeCaptioningChangeListener(sz1.d);
        } else
        {
            sz1.b.unregisterOnSharedPreferenceChangeListener(sz1);
        }
        a(cgl.s, cgo1);
        return;
_L2:
        cxu1 = "uniform";
          goto _L14
_L3:
        cxu1 = "dropShadow";
          goto _L14
_L5:
        cxu1 = "depressed";
          goto _L14
_L4:
        cxu1 = "raised";
          goto _L14
_L7:
        cxu1 = "monoSerif";
          goto _L15
_L8:
        cxu1 = "propSerif";
          goto _L15
_L9:
        cxu1 = "monoSans";
          goto _L15
_L10:
        cxu1 = "propSans";
          goto _L15
_L11:
        cxu1 = "casual";
          goto _L15
_L12:
        cxu1 = "cursive";
          goto _L15
        cxu1 = "smallCaps";
          goto _L15
    }

    public final void c()
    {
        H = alw.f;
        v();
        a(cgl.x, cgo.a);
    }

    public final boolean d()
    {
        return true;
    }

    public final void e()
    {
        a(cgl.l, new cgo());
    }

    public final boolean f()
    {
        return true;
    }

    public final void g()
    {
        a(cgl.e, new cgo());
    }

    public final String h()
    {
        return d.l;
    }

    public final amj i()
    {
        return d.d;
    }

    public final alu j()
    {
        return d.e;
    }

    public final amn k()
    {
        return d.f;
    }

    public final amb l()
    {
        return d.g;
    }

    public final amb m()
    {
        return d.h;
    }

    public final ame n()
    {
        return f;
    }

    public final String o()
    {
        if (!H.equals(alw.f))
        {
            return H.a;
        } else
        {
            return d.i.a;
        }
    }

    public final void onMdxUserAuthenticationChangedEvent(chn chn)
    {
        w();
    }

    public final long p()
    {
        aku aku1 = d;
        long l2 = aku1.n;
        long l1;
        if (!aku1.f.a() && aku1.g == amb.c)
        {
            l1 = aku1.c.b() - aku1.o;
        } else
        {
            l1 = 0L;
        }
        return l1 + l2;
    }

    public final long q()
    {
        aku aku1 = d;
        long l2 = aku1.p;
        long l1;
        if (aku1.f.a() && aku1.h == amb.c)
        {
            l1 = aku1.c.b() - aku1.q;
        } else
        {
            l1 = 0L;
        }
        return l1 + l2;
    }

    public final buz r()
    {
        return d.j;
    }

    public final void s()
    {
        a(cgl.v, cgo.a);
    }

    public final String t()
    {
        if (f != null && f.g())
        {
            Object obj = (alq)f;
            cgb cgb1 = (cgb)v.get(((alq) (obj)).a.c);
            obj = ((alq) (obj)).a.e;
            if (cgb1 != null)
            {
                return cgb1.toString();
            }
            if (obj != null)
            {
                return ((cgb) (obj)).toString();
            }
        }
        return null;
    }

    public final boolean u()
    {
label0:
        {
            Object obj = e;
            obj = String.valueOf(E);
            (new StringBuilder(String.valueOf(obj).length() + 22)).append("Connected remotes are ").append(((String) (obj)));
            if (E == null)
            {
                break label0;
            }
            obj = E.iterator();
            Object obj1;
            do
            {
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    obj1 = (cgf)((Iterator) (obj)).next();
                } while (((cgf) (obj1)).a.equals(F));
                obj1 = ((cgf) (obj1)).a;
            } while (k.matcher(((CharSequence) (obj1))).matches());
            return false;
        }
        return true;
    }

    static 
    {
        j = TimeUnit.MINUTES.toMillis(15L);
        a = new IntentFilter();
        l = new IntentFilter();
        a.addAction(cgi.h.toString());
        a.addAction(cgi.c.toString());
        a.addAction(cgi.b.toString());
        l.addAction("android.intent.action.SCREEN_OFF");
        l.addAction("android.intent.action.SCREEN_ON");
        HashMap hashmap = new HashMap();
        hashmap.put("LOUNGE_SCREEN", cgh.b);
        hashmap.put("REMOTE_CONTROL", cgh.a);
        m = Collections.unmodifiableMap(hashmap);
    }
}
