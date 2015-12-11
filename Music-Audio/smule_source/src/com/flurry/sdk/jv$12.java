// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.BitSet;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            io, jz

final class tException extends ir
{

    public BitSet a(jx jx1)
    {
        jy jy1;
        BitSet bitset;
        int i;
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        bitset = new BitSet();
        jx1.a();
        jy1 = jx1.f();
        i = 0;
_L2:
        boolean flag;
        if (jy1 == jy.b)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        switch (a[jy1.ordinal()])
        {
        default:
            throw new io((new StringBuilder()).append("Invalid bitset value type: ").append(jy1).toString());

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 3: // '\003'
            break MISSING_BLOCK_LABEL_153;

        case 1: // '\001'
            if (jx1.m() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            break;
        }
_L3:
        if (flag)
        {
            bitset.set(i);
        }
        i++;
        jy1 = jx1.f();
        if (true) goto _L2; else goto _L1
_L1:
        flag = jx1.i();
          goto _L3
        String s = jx1.h();
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new io((new StringBuilder()).append("Error: Expecting: bitset number value (1, 0), Found: ").append(s).toString());
        }
        if (j != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L3
        jx1.b();
        return bitset;
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (BitSet)obj);
    }

    public void a(jz jz1, BitSet bitset)
    {
        if (bitset == null)
        {
            jz1.f();
            return;
        }
        jz1.b();
        int i = 0;
        while (i < bitset.length()) 
        {
            int j;
            if (bitset.get(i))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            jz1.a(j);
            i++;
        }
        jz1.c();
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    tException()
    {
    }
}
