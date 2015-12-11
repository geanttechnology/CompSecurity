// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;

import android.content.SharedPreferences;
import c.a.a.a.a.b.l;
import c.a.a.a.a.f.c;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import org.json.JSONObject;

// Referenced classes of package c.a.a.a.a.g:
//            q, g, t, s, 
//            v, u

public class r
{

    private final u a;
    private final t b;
    private final c.a.a.a.a.b.r c;
    private final g d;
    private final v e;
    private final n f;
    private final c g;

    public r(n n1, u u, c.a.a.a.a.b.r r1, t t1, g g1, v v1)
    {
        f = n1;
        a = u;
        c = r1;
        b = t1;
        d = g1;
        e = v1;
        g = new c(f);
    }

    private static void a(JSONObject jsonobject, String s1)
    {
        c.a.a.a.e.d().a("Fabric", (new StringBuilder()).append(s1).append(jsonobject.toString()).toString());
    }

    private s b(c.a.a.a.a.g.q q1)
    {
        Object obj = null;
        if (q.b.equals(q1)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = d.a();
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        s s1;
        long l1;
        s1 = b.a(c, jsonobject);
        a(jsonobject, "Loaded cached settings: ");
        l1 = c.a();
        if (c.a.a.a.a.g.q.c.equals(q1)) goto _L6; else goto _L5
_L5:
        long l2 = s1.g;
        boolean flag;
        if (l2 < l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L7; else goto _L6
_L6:
        c.a.a.a.e.d().a("Fabric", "Returning cached settings.");
_L8:
        return s1;
_L7:
        c.a.a.a.e.d().a("Fabric", "Cached settings have expired.");
        return null;
        q1;
        s1 = obj;
_L9:
        c.a.a.a.e.d().c("Fabric", "Failed to get cached settings", q1);
        return s1;
_L4:
        c.a.a.a.e.d().a("Fabric", "No cached settings data found.");
_L2:
        s1 = null;
          goto _L8
        q1;
          goto _L9
    }

    public s a()
    {
        return a(q.a);
    }

    public s a(c.a.a.a.a.g.q q1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (c.a.a.a.e.e())
        {
            break MISSING_BLOCK_LABEL_25;
        }
        obj = obj1;
        if (!d())
        {
            obj = b(q1);
        }
        Exception exception;
        q1 = ((c.a.a.a.a.g.q) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        q1 = ((c.a.a.a.a.g.q) (obj));
        JSONObject jsonobject;
        try
        {
            jsonobject = e.a(a);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            continue; /* Loop/switch isn't completed */
        }
        q1 = ((c.a.a.a.a.g.q) (obj));
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        q1 = ((c.a.a.a.a.g.q) (obj));
        obj = b.a(c, jsonobject);
        q1 = ((c.a.a.a.a.g.q) (obj));
        d.a(((s) (obj)).g, jsonobject);
        q1 = ((c.a.a.a.a.g.q) (obj));
        a(jsonobject, "Loaded settings: ");
        q1 = ((c.a.a.a.a.g.q) (obj));
        a(b());
        q1 = ((c.a.a.a.a.g.q) (obj));
        obj = q1;
        if (q1 != null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = b(c.a.a.a.a.g.q.c);
        return ((s) (obj));
        exception;
        q1 = null;
_L2:
        c.a.a.a.e.d().c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", exception);
        return q1;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    boolean a(String s1)
    {
        android.content.SharedPreferences.Editor editor = g.b();
        editor.putString("existing_instance_identifier", s1);
        return g.a(editor);
    }

    String b()
    {
        return l.a(new String[] {
            l.k(f.getContext())
        });
    }

    String c()
    {
        return g.a().getString("existing_instance_identifier", "");
    }

    boolean d()
    {
        return !c().equals(b());
    }
}
