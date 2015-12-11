// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.do;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.do:
//            c

public final class d
{

    private String a;
    private String b;
    private boolean c;
    private c d;

    public d()
    {
    }

    public d(Map map)
    {
        if (map.containsKey("service"))
        {
            a = (String)map.get("service");
        }
        if (map.containsKey("type"))
        {
            b = (String)map.get("type");
        }
        if (map.containsKey("finish"))
        {
            c = ((Boolean)map.get("finish")).booleanValue();
        }
        if (map.containsKey("condition"))
        {
            d = new c((Map)map.get("condition"));
        }
    }

    public final boolean a()
    {
        return c;
    }

    public final boolean a(String s, String s1, Map map)
    {
_L2:
        return false;
        if (a == null || a.length() == 0 || !a.equals("*") && !s1.equals(a)) goto _L2; else goto _L1
_L1:
        if (!"user".equals(b))
        {
            if ("length".equals(b))
            {
                if (!(map.get("content") instanceof List))
                {
                    break MISSING_BLOCK_LABEL_563;
                }
                s = Integer.toString(((List)map.get("content")).size());
            } else
            {
                s = ((String) (map.get(b)));
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_563;
                }
                if (s instanceof String)
                {
                    s = (String)s;
                } else
                {
                    s = (new Gson()).toJson(s);
                }
            }
        }
_L9:
        if (s != null)
        {
            if ("contains".equals(d.a()))
            {
                if (!"equal".equals(d.b()))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (s.indexOf(d.c()) != -1)
                {
                    return true;
                }
            } else
            {
label0:
                {
                    if (!"regex".equals(d.a()))
                    {
                        break label0;
                    }
                    s1 = new StringBuilder("(.*)");
                    s1.append(d.c());
                    s1.append("(.*)");
                    boolean flag;
                    try
                    {
                        flag = s.matches(s1.toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        flag = true;
                    }
                    if ("equal".equals(d.b()))
                    {
                        return flag;
                    }
                    if ("not".equals(d.b()) && !flag)
                    {
                        return true;
                    }
                }
            }
        }
          goto _L2
        if (!"not".equals(d.b()) || s.indexOf(d.c()) != -1) goto _L2; else goto _L3
_L3:
        return true;
        boolean flag1;
        if (!"array".equals(d.a()))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = d.d().iterator();
        do
        {
            if (!s1.hasNext())
            {
                break MISSING_BLOCK_LABEL_557;
            }
        } while (!((String)s1.next()).equals(s));
        flag1 = true;
_L8:
        if ("equal".equals(d.b()))
        {
            return flag1;
        }
        if (!"not".equals(d.b()) || flag1) goto _L2; else goto _L4
_L4:
        return true;
        if (!"number".equals(d.a())) goto _L2; else goto _L5
_L5:
        int i;
        int j;
        i = Integer.parseInt(s);
        j = Integer.parseInt(d.c());
        if ("equal".equals(d.b()))
        {
            if (i == j)
            {
                return true;
            }
        } else
        {
label1:
            {
                if (!"not".equals(d.b()))
                {
                    break label1;
                }
                if (i != j)
                {
                    return true;
                }
            }
        }
          goto _L2
        if (!"sup".equals(d.b()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i <= j) goto _L2; else goto _L6
_L6:
        return true;
        if (!"inf".equals(d.b()) || i >= j) goto _L2; else goto _L7
_L7:
        return true;
        flag1 = false;
          goto _L8
        s = null;
          goto _L9
    }
}
