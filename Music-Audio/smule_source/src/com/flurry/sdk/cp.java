// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            gi, a, b, ap, 
//            fe, fl, hp, gd, 
//            fd, at, fp, r, 
//            e

public class cp extends gi
{

    private static final String a = com/flurry/sdk/cp.getSimpleName();

    public cp()
    {
    }

    private String a(a a1, String s, String s1)
    {
        Object obj = a1.c().b();
        Object obj1 = a1.c().f();
        a1 = a1.c().c().a();
        if (a("fids", s1))
        {
            a1 = new StringBuilder();
            obj = fe.a().h().entrySet().iterator();
            boolean flag = true;
            while (((Iterator) (obj)).hasNext()) 
            {
                obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                if (!flag)
                {
                    a1.append(",");
                }
                a1.append(((fl)((java.util.Map.Entry) (obj1)).getKey()).d).append(":");
                if (((fl)((java.util.Map.Entry) (obj1)).getKey()).e)
                {
                    a1.append(new String((byte[])((java.util.Map.Entry) (obj1)).getValue()));
                } else
                {
                    a1.append(hp.a((byte[])((java.util.Map.Entry) (obj1)).getValue()));
                }
                flag = false;
            }
            gd.a(3, a, (new StringBuilder()).append("Replacing param fids with: ").append(a1.toString()).toString());
            a1 = s.replace(s1, hp.c(a1.toString()));
        } else
        {
            if (a("sid", s1))
            {
                a1 = String.valueOf(fd.a().c());
                gd.a(3, a, (new StringBuilder()).append("Replacing param sid with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("lid", s1))
            {
                a1 = String.valueOf(((at) (obj1)).a());
                gd.a(3, a, (new StringBuilder()).append("Replacing param lid with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("guid", s1))
            {
                a1 = ((at) (obj1)).b();
                gd.a(3, a, (new StringBuilder()).append("Replacing param guid with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("ats", s1))
            {
                a1 = String.valueOf(System.currentTimeMillis());
                gd.a(3, a, (new StringBuilder()).append("Replacing param ats with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("apik", s1))
            {
                a1 = fp.a().d();
                gd.a(3, a, (new StringBuilder()).append("Replacing param apik with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("hid", s1))
            {
                a1 = ((AdUnit) (a1)).adSpace;
                gd.a(3, a, (new StringBuilder()).append("Replacing param hid with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("eso", s1))
            {
                a1 = Long.toString(System.currentTimeMillis() - fd.a().c());
                gd.a(3, a, (new StringBuilder()).append("Replacing param eso with: ").append(a1).toString());
                return s.replace(s1, hp.c(a1));
            }
            if (a("uc", s1))
            {
                a1 = ((r) (obj)).l();
                if (a1 != null)
                {
                    Iterator iterator = a1.getUserCookies().entrySet().iterator();
                    a1 = "";
                    do
                    {
                        obj = a1;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        obj = (java.util.Map.Entry)iterator.next();
                        a1 = (new StringBuilder()).append(a1).append("c_").append(hp.c((String)((java.util.Map.Entry) (obj)).getKey())).append("=").append(hp.c((String)((java.util.Map.Entry) (obj)).getValue())).append("&").toString();
                    } while (true);
                } else
                {
                    obj = "";
                }
                gd.a(3, a, (new StringBuilder()).append("Replacing param uc with: ").append(((String) (obj))).toString());
                s = s.replace(s1, ((CharSequence) (obj)));
                a1 = s;
                if (((String) (obj)).equals(""))
                {
                    a1 = s;
                    if (s.length() > 0)
                    {
                        return s.substring(0, s.length() - 1);
                    }
                }
            } else
            {
                gd.a(3, a, (new StringBuilder()).append("Unknown param: ").append(s1).toString());
                return s.replace(s1, "");
            }
        }
        return a1;
    }

    public String a(a a1, String s)
    {
        String s2 = a(s);
        String s1 = s;
        for (s = s2; s != null; s = a(s1))
        {
            s1 = a(a1, s1, s);
        }

        return s1;
    }

}
