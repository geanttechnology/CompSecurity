// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            h

class cp
{

    ArrayList a;
    ArrayList b;
    ArrayList c;
    HashMap d;

    cp()
    {
        a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
        d = new HashMap();
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            ArrayList arraylist = h1.c("update");
            a = arraylist;
            if (arraylist != null)
            {
                ArrayList arraylist1 = h1.c("install");
                b = arraylist1;
                if (arraylist1 != null)
                {
                    h1 = h1.c("session_start");
                    c = h1;
                    if (h1 != null)
                    {
                        d.put("update", a);
                        d.put("install", b);
                        d.put("session_start", c);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
