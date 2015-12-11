// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            bo, d, ci

class bw
{

    ArrayList a;

    bw()
    {
        a = new ArrayList();
    }

    int a()
    {
        return a.size();
    }

    bo a(int i)
    {
        return (bo)a.get(i);
    }

    bo a(String s)
    {
        for (int i = 0; i < a.size(); i++)
        {
            bo bo1 = (bo)a.get(i);
            if (bo1.a.equals(s))
            {
                return bo1;
            }
        }

        return null;
    }

    boolean a(d d1)
    {
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
                bo bo1 = new bo();
                if (!bo1.a(d1.a(i)))
                {
                    break label0;
                }
                a.add(bo1);
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    bo b()
    {
        return (bo)a.get(0);
    }

    bo b(int i)
    {
_L7:
        if (i >= a.size()) goto _L2; else goto _L1
_L1:
        bo bo1 = (bo)a.get(i);
        if (!bo1.v.a) goto _L4; else goto _L3
_L3:
        return bo1;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
label0:
        do
        {
label1:
            {
                if (i >= a.size())
                {
                    break label1;
                }
                bo bo2 = (bo)a.get(i);
                bo1 = bo2;
                if (bo2.v.a)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L3; else goto _L5
_L5:
        return null;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
