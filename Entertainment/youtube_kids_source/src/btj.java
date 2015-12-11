// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;

public final class btj
    implements bnj, bvz
{

    public final dwn a;
    private btk b;
    private bqw c;

    public btj(dwn dwn1)
    {
        a = dwn1;
    }

    private bqw d()
    {
        dwo dwo1 = a.a;
        if (c == null && dwo1 != null && dwo1.b != null)
        {
            c = new bqw(dwo1.b, this);
        }
        return c;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        btk btk1 = c();
        if (btk1 != null)
        {
            btk1.a(bnk1);
        }
    }

    public final byte[] a()
    {
        return a.c;
    }

    public final bvz b()
    {
        return null;
    }

    public final btk c()
    {
        Object obj;
        if (b != null)
        {
            return b;
        }
        obj = a.a;
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((dwo) (obj)).a == null) goto _L4; else goto _L3
_L3:
        obj = new btk(((dwo) (obj)).a);
_L7:
        b = ((btk) (obj));
_L2:
        return b;
_L4:
        if (d() == null) goto _L2; else goto _L5
_L5:
        obj = d();
        if (((bqw) (obj)).b == null)
        {
            if (((bqw) (obj)).a.c == null || ((bqw) (obj)).a.c.a == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj.b = new btk(((bqw) (obj)).a.c.a);
        }
_L8:
        obj = ((bqw) (obj)).b;
        if (true) goto _L7; else goto _L6
_L6:
        if (((bqw) (obj)).c() == null)
        {
            break;
        }
        Iterator iterator = ((bqw) (obj)).c().iterator();
        bti bti1;
label0:
        do
        {
            btk btk1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                bti1 = (bti)iterator.next();
                if (bti1.b == null && bti1.a != null && bti1.a.c != null && bti1.a.c.a != null)
                {
                    bti1.b = new btk(bti1.a.c.a);
                }
                btk1 = bti1.b;
            } while (btk1 == null || ((bqw) (obj)).b != null && !bti1.a.a);
            obj.b = btk1;
        } while (!bti1.a.a);
          goto _L8
        if (true) goto _L7; else goto _L9
_L9:
    }
}
