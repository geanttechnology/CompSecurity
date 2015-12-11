// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            bq, bl, d

class bt
{

    ArrayList a;

    bt()
    {
    }

    int a()
    {
        return a.size();
    }

    bq a(int i)
    {
        return (bq)a.get(i);
    }

    bq a(String s)
    {
        for (int i = 0; i < a.size(); i++)
        {
            bq bq1 = (bq)a.get(i);
            if (bq1.a.equals(s))
            {
                return bq1;
            }
        }

        bl.a.a("No such zone: ").b(s);
        return null;
    }

    boolean a(d d1)
    {
        a = new ArrayList();
        if (d1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= d1.a_())
                {
                    break label1;
                }
                bq bq1 = new bq();
                if (!bq1.a(d1.a(i)))
                {
                    break label0;
                }
                a.add(bq1);
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }
}
