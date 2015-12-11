// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cw, cr, cu, ew

public final class cq extends cw
{

    private String a;
    private String b;
    private cr c;
    private String d;
    private String e;
    private String f;

    public cq(cr cr1)
    {
        cr cr2;
        if (cr1 != cr.a)
        {
            cr2 = cr.b;
        }
        a = cu.a.a();
        b = ew.a.a();
        c = cr1;
    }

    public cq(cr cr1, String s)
    {
        cr cr2;
        if (cr1 != cr.c)
        {
            cr2 = cr.d;
        }
        a = cu.a.a();
        b = ew.a.a();
        c = cr1;
        d = s;
    }

    public cq(cr cr1, String s, String s1)
    {
        cr cr2 = cr.e;
        a = cu.a.a();
        b = ew.a.a();
        c = cr1;
        e = s;
        f = s1;
    }

    public final JSONArray a()
    {
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put("change", Integer.valueOf(c.ordinal()));
        if (c != cr.c && c != cr.d) goto _L2; else goto _L1
_L1:
        hashmap.put("type", d);
_L4:
        return (new JSONArray()).put(b).put(4).put(new JSONObject(hashmap));
_L2:
        if (c == cr.e)
        {
            hashmap.put("oldType", e);
            hashmap.put("newType", f);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String f()
    {
        return a;
    }
}
