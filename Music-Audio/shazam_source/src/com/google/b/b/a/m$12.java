// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.u;
import com.google.b.x;
import java.util.BitSet;

// Referenced classes of package com.google.b.b.a:
//            m

static final class Exception extends x
{

    private static BitSet b(a a1)
    {
        b b1;
        BitSet bitset;
        int i;
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        bitset = new BitSet();
        a1.a();
        b1 = a1.f();
        i = 0;
_L2:
        boolean flag;
        if (b1 == b.b)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        switch (com.google.b.b.a.a[b1.ordinal()])
        {
        default:
            throw new u((new StringBuilder("Invalid bitset value type: ")).append(b1).toString());

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 3: // '\003'
            break MISSING_BLOCK_LABEL_147;

        case 1: // '\001'
            if (a1.n() != 0)
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
        b1 = a1.f();
        if (true) goto _L2; else goto _L1
_L1:
        flag = a1.j();
          goto _L3
        String s = a1.i();
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new u((new StringBuilder("Error: Expecting: bitset number value (1, 0), Found: ")).append(s).toString());
        }
        if (j != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L3
        a1.b();
        return bitset;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final void a(c c1, Object obj)
    {
        obj = (BitSet)obj;
        if (obj == null)
        {
            c1.f();
            return;
        }
        c1.b();
        int i = 0;
        while (i < ((BitSet) (obj)).length()) 
        {
            int j;
            if (((BitSet) (obj)).get(i))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            c1.a(j);
            i++;
        }
        c1.c();
    }

    Exception()
    {
    }
}
