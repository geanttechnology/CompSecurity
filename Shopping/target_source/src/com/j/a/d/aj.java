// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import com.j.a.c.e;
import com.j.a.g.b;
import com.j.a.g.w;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class aj
{

    private static aj a;
    private HashSet b;

    public aj()
    {
        b = new HashSet();
    }

    public static aj a()
    {
        if (a != null)
        {
            return a;
        } else
        {
            a = new aj();
            return a;
        }
    }

    private HashSet c(HashSet hashset)
    {
        if (hashset.contains(b.c.a()))
        {
            hashset.add(b.b.a());
            hashset.add(b.a.a());
            hashset.add(b.s.a());
            hashset.add(b.d.a());
        }
        if (hashset.contains(b.d.a()))
        {
            hashset.add(b.e.a());
            hashset.add(b.g.a());
            hashset.add(b.f.a());
            hashset.add(b.h.a());
        }
        if (hashset.contains(b.k.a()))
        {
            hashset.add(b.j.a());
            hashset.add(b.i.a());
            hashset.add(b.p.a());
            hashset.add(b.o.a());
            hashset.add(b.n.a());
        }
        return hashset;
    }

    private void d(HashSet hashset)
    {
        if (hashset.contains(b.c.a()))
        {
            b.remove(b.b.a());
            b.remove(b.a.a());
            b.remove(b.s.a());
            b.remove(b.d.a());
        }
        if (hashset.contains(b.d.a()))
        {
            b.remove(b.e.a());
            b.remove(b.g.a());
            b.remove(b.f.a());
            b.remove(b.h.a());
        }
        if (hashset.contains(b.k.a()))
        {
            b.remove(b.j.a());
            b.remove(b.i.a());
            b.remove(b.p.a());
            b.remove(b.o.a());
            b.remove(b.n.a());
        }
    }

    public void a(e e1)
    {
        if (e1 == null) goto _L2; else goto _L1
_L1:
        e1 = e1.c();
        if (e1 == null) goto _L4; else goto _L3
_L3:
        Object obj;
        int i;
        try
        {
            obj = e1.optJSONObject("settings").optJSONArray("disable");
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            w.b("error checking disabled sources", e1);
            return;
        }
        if (obj == null) goto _L4; else goto _L5
_L5:
        i = 0;
_L11:
        if (i >= ((JSONArray) (obj)).length()) goto _L7; else goto _L6
_L6:
        if (((JSONArray) (obj)).get(i) != null && (((JSONArray) (obj)).get(i) instanceof String))
        {
            b.add((String)((JSONArray) (obj)).get(i));
        }
          goto _L8
_L7:
        a(b);
_L4:
        if (e1 == null) goto _L2; else goto _L9
_L9:
        e1 = e1.optJSONObject("settings").optJSONArray("enable");
        if (e1 == null) goto _L2; else goto _L10
_L10:
        obj = new HashSet();
        i = 0;
_L12:
        if (i < e1.length())
        {
            if (e1.get(i) != null && (e1.get(i) instanceof String))
            {
                b.remove(e1.get(i));
                ((HashSet) (obj)).add(e1.get(i));
            }
            break MISSING_BLOCK_LABEL_189;
        }
        d(((HashSet) (obj)));
_L2:
        return;
_L8:
        i++;
          goto _L11
        i++;
          goto _L12
    }

    public void a(b b1)
    {
        b.add(b1.a());
    }

    public void a(HashSet hashset)
    {
        b = c(hashset);
    }

    public HashSet b()
    {
        return b;
    }

    public void b(HashSet hashset)
    {
        b = hashset;
    }
}
