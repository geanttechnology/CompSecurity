// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            h

class cj
{

    boolean a;
    boolean b;
    String c;
    String d;
    String e;

    cj()
    {
    }

    boolean a(h h1)
    {
        boolean flag = true;
        if (h1 == null)
        {
            flag = false;
        } else
        {
            a = h1.g("enabled");
            if (a)
            {
                b = h1.g("in_app");
                c = h1.d("click_action_type");
                e = h1.d("click_action");
                d = h1.d("label");
                return true;
            }
        }
        return flag;
    }
}
