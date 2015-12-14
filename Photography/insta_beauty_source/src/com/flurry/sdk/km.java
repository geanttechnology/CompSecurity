// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            lt

public class km
{

    private final HashMap a = new HashMap();

    public km()
    {
    }

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj = a.entrySet();
        if (((Set) (obj)).size() > 0)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append("&"))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                stringbuilder.append(lt.c((String)entry.getKey()));
                stringbuilder.append("=");
                stringbuilder.append(lt.c((String)entry.getValue()));
            }

            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        }
        return stringbuilder.toString();
    }

    public void a(String s, String s1)
    {
        if (s == null)
        {
            return;
        } else
        {
            a.put(s, s1);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (km)obj;
        if (a == null) goto _L4; else goto _L3
_L3:
        if (a.equals(((km) (obj)).a)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((km) (obj)).a == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        if (a != null)
        {
            return a.hashCode();
        } else
        {
            return 0;
        }
    }
}
