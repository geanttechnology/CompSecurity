// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.d;

import com.a.a.a.k;
import com.liverail.library.a.b;
import com.liverail.library.a.d;
import com.liverail.library.g.e;
import com.liverail.library.g.i;
import java.util.ArrayList;
import java.util.HashMap;

public class a
{

    private d a;

    public a(d d1)
    {
        a = d1;
    }

    private void a(i j)
    {
        int i1 = j.u.size();
        StringBuilder stringbuilder = new StringBuilder();
        int l = 0;
        do
        {
            if (l >= i1)
            {
                if (com.liverail.library.b.a.a)
                {
                    com.liverail.library.b.a.a((new StringBuilder("Tracker type: ")).append(j.a()).append(stringbuilder.toString()).toString());
                }
                return;
            }
            String s = (String)j.u.get(l);
            a(s);
            if (com.liverail.library.b.a.a)
            {
                stringbuilder.append((new StringBuilder("\n ~~> ")).append(s).toString());
            }
            l++;
        } while (true);
    }

    private void a(String s)
    {
        com.a.a.a.a a1 = new com.a.a.a.a();
        a1.a(a.b());
        a.getClass();
        a1.a("Mozilla/5.0 (Linux; Android; Device) LiveRailSDK/2.1.0");
        try
        {
            a1.a(s, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.liverail.library.b.a.d((new StringBuilder("Tracker failed ")).append(s.getMessage()).toString());
        }
    }

    public void a(b b1)
    {
        HashMap hashmap = a.d;
        k k1 = new k(hashmap);
        k1.a("code", String.valueOf(b1.a()));
        k1.a("msg", b1.b());
        if (hashmap.containsKey("LR_INTEGRATION"))
        {
            k1.a("i", (String)hashmap.get("LR_INTEGRATION"));
        }
        Object obj = new StringBuilder("version=");
        a.getClass();
        StringBuilder stringbuilder = (new StringBuilder(String.valueOf(((StringBuilder) (obj)).append("2.1.0").toString()))).append("&os=");
        if (hashmap.containsKey("LR_OS"))
        {
            obj = (String)hashmap.get("LR_OS");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&osVer=");
        if (hashmap.containsKey("LR_OSVERS"))
        {
            obj = (String)hashmap.get("LR_OSVERS");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&make=");
        if (hashmap.containsKey("LR_MAKE"))
        {
            obj = (String)hashmap.get("LR_MAKE");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&model=");
        if (hashmap.containsKey("LR_MODEL"))
        {
            obj = (String)hashmap.get("LR_MODEL");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&bundle=");
        if (hashmap.containsKey("LR_BUNDLE"))
        {
            obj = (String)hashmap.get("LR_BUNDLE");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&appName=");
        if (hashmap.containsKey("LR_APPNAME"))
        {
            obj = (String)hashmap.get("LR_APPNAME");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&appVer=");
        if (hashmap.containsKey("LR_APPVERS"))
        {
            obj = (String)hashmap.get("LR_APPVERS");
        } else
        {
            obj = "";
        }
        stringbuilder = (new StringBuilder(String.valueOf(stringbuilder.append(((String) (obj))).toString()))).append("&carrier=");
        if (hashmap.containsKey("LR_CARRIER"))
        {
            obj = (String)hashmap.get("LR_CARRIER");
        } else
        {
            obj = "";
        }
        k1.a("pt", stringbuilder.append(((String) (obj))).toString());
        obj = new com.a.a.a.a();
        com.liverail.library.b.a.a((new StringBuilder("(log) ")).append(b1).toString());
        try
        {
            ((com.a.a.a.a) (obj)).b("http://log.liverail.com/mobile/", k1, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            com.liverail.library.b.a.d((new StringBuilder("Log failed: ")).append(b1.getMessage()).toString());
        }
    }

    public void a(com.liverail.library.g.a a1, int j)
    {
        a1 = (i)a1.o.get((new StringBuilder("view")).append(String.valueOf(j)).toString());
        if (a1 != null)
        {
            a(((i) (a1)));
        }
    }

    public void a(com.liverail.library.g.a a1, String s)
    {
        a1 = (i)a1.o.get(s);
        if (a1 != null)
        {
            a(((i) (a1)));
        }
    }

    public void a(e e1, String s)
    {
        e1 = (i)e1.e.get(s);
        if (e1 != null)
        {
            a(((i) (e1)));
        }
    }

    public void a(HashMap hashmap)
    {
        hashmap = (i)hashmap.get("embed");
        if (hashmap != null)
        {
            a(((i) (hashmap)));
        }
    }

    public void b(com.liverail.library.g.a a1, int j)
    {
        a1 = (i)a1.o.get("error");
        if (a1 == null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
        int l;
        int i1;
        i1 = ((i) (a1)).u.size();
        stringbuilder = new StringBuilder();
        l = 0;
_L6:
        if (l < i1) goto _L4; else goto _L3
_L3:
        if (com.liverail.library.b.a.a)
        {
            com.liverail.library.b.a.a((new StringBuilder("Tracker type: ")).append(a1.a()).append(stringbuilder.toString()).toString());
        }
_L2:
        return;
_L4:
        String s = ((String)((i) (a1)).u.get(l)).replaceAll("\\[ERRORCODE\\]", String.valueOf(j));
        a(s);
        if (com.liverail.library.b.a.a)
        {
            stringbuilder.append((new StringBuilder("\n ~~> ")).append(s).toString());
        }
        l++;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
