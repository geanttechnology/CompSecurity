// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            h

class cr
{

    String a;
    String b;
    boolean c;

    cr()
    {
    }

    boolean a()
    {
        return true;
    }

    boolean a(h h1)
    {
        if (h1 == null)
        {
            return false;
        }
        c = h1.g("enabled");
        if (!c)
        {
            return true;
        } else
        {
            a = (String)h1.c("product_ids").get(0);
            b = h1.d("in_progress");
            return true;
        }
    }
}
