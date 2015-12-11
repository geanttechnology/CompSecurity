// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bsd
    implements bnj, bvz
{

    public final dom a;
    public List b;
    private final bvz c;
    private List d;

    public bsd(dom dom1, bvz bvz1)
    {
        a = (dom)b.a(dom1);
        c = bvz1;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        Iterator iterator = c().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj instanceof bnj)
            {
                ((bnj)obj).a(bnk1);
            }
        } while (true);
    }

    public final byte[] a()
    {
        return a.c;
    }

    public final bvz b()
    {
        return c;
    }

    public final List c()
    {
        doo adoo[];
        int i;
        int j;
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_1386;
        }
        d = new ArrayList(a.a.length);
        adoo = a.a;
        j = adoo.length;
        i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_1386;
        }
        obj = adoo[i];
        if (((doo) (obj)).f == null)
        {
            break; /* Loop/switch isn't completed */
        }
        d.add(new bra(((doo) (obj)).f, this));
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (((doo) (obj)).L != null)
        {
            d.add(new brb(((doo) (obj)).L));
        } else
        if (((doo) (obj)).d != null)
        {
            d.add(new brd(((doo) (obj)).d, this));
        } else
        if (((doo) (obj)).c != null)
        {
            d.add(new brg(((doo) (obj)).c, this));
        } else
        if (((doo) (obj)).H != null)
        {
            d.add(new bre(((doo) (obj)).H, this));
        } else
        if (((doo) (obj)).p != null)
        {
            d.add(new brc(((doo) (obj)).p, this));
        } else
        if (((doo) (obj)).b != null)
        {
            d.add(new bqm(((doo) (obj)).b, this));
        } else
        if (((doo) (obj)).x != null)
        {
            d.add(new buh(((doo) (obj)).x, this));
        } else
        if (((doo) (obj)).w != null)
        {
            d.add(new bue(((doo) (obj)).w, this));
        } else
        if (((doo) (obj)).i != null)
        {
            d.add(new bsh(((doo) (obj)).i, this));
        } else
        if (((doo) (obj)).k != null)
        {
            d.add(new brf(((doo) (obj)).k, this));
        } else
        if (((doo) (obj)).g != null)
        {
            d.add(new buc(((doo) (obj)).g, this));
        } else
        if (((doo) (obj)).t != null)
        {
            d.add(new btf(((doo) (obj)).t, this));
        } else
        {
label0:
            {
                if (((doo) (obj)).D == null)
                {
                    break label0;
                }
                d.add(new bqi(((doo) (obj)).D));
            }
        }
          goto _L3
label1:
        {
            if (((doo) (obj)).e == null)
            {
                break MISSING_BLOCK_LABEL_659;
            }
            obj = ((doo) (obj)).e;
            b.a(obj);
            if (((dkq) (obj)).a == null)
            {
                break label1;
            }
            if (((dkq) (obj)).a.c != null)
            {
                obj = new bsx(((dkq) (obj)), this);
            } else
            if (((dkq) (obj)).a.d != null)
            {
                obj = new bqt(((dkq) (obj)), this);
            } else
            if (((dkq) (obj)).a.e != null)
            {
                obj = new bqr(((dkq) (obj)), this);
            } else
            if (((dkq) (obj)).a.b != null)
            {
                obj = new btz(((dkq) (obj)), this);
            } else
            {
                if (((dkq) (obj)).a.f == null)
                {
                    break label1;
                }
                obj = new bsb(((dkq) (obj)), this);
            }
        }
_L4:
        if (obj != null)
        {
            d.add(obj);
        }
          goto _L3
        obj = null;
          goto _L4
        if (((doo) (obj)).q != null)
        {
            d.add(new bsg(((doo) (obj)).q, this));
        } else
        if (((doo) (obj)).r != null)
        {
            d.add(new bsl(((doo) (obj)).r, this));
        } else
        if (((doo) (obj)).v != null)
        {
            d.add(new bsj(((doo) (obj)).v, this));
        } else
        if (((doo) (obj)).u != null)
        {
            d.add(new bsk(((doo) (obj)).u, this));
        } else
        if (((doo) (obj)).s != null)
        {
            d.add(new bsm(((doo) (obj)).s, this));
        } else
        if (((doo) (obj)).h != null)
        {
            d.add(new bub(((doo) (obj)).h, this));
        } else
        if (((doo) (obj)).l != null)
        {
            d.add(new bua(((doo) (obj)).l, this));
        } else
        if (((doo) (obj)).n != null)
        {
            d.add(new brw(((doo) (obj)).n, this));
        } else
        if (((doo) (obj)).m != null)
        {
            d.add(new btr(((doo) (obj)).m, this));
        } else
        if (((doo) (obj)).o != null)
        {
            d.add(new brl(((doo) (obj)).o, this));
        } else
        if (((doo) (obj)).F != null)
        {
            d.add(new brp(((doo) (obj)).F, this));
        } else
        if (((doo) (obj)).B != null)
        {
            d.add(new bsp(((doo) (obj)).B, this));
        } else
        if (((doo) (obj)).A != null)
        {
            d.add(new brh(((doo) (obj)).A, this));
        } else
        if (((doo) (obj)).E != null)
        {
            d.add(new bth(((doo) (obj)).E, this));
        } else
        if (((doo) (obj)).y != null)
        {
            d.add(new bqz(((doo) (obj)).y));
        } else
        if (((doo) (obj)).j != null)
        {
            d.add(new bqy(((doo) (obj)).j));
        } else
        if (((doo) (obj)).G != null)
        {
            d.add(new buo(((doo) (obj)).G, this));
        } else
        if (((doo) (obj)).C != null)
        {
            d.add(new bqs(((doo) (obj)).C, this));
        } else
        if (((doo) (obj)).I != null)
        {
            d.add(new bqq(((doo) (obj)).I, this));
        } else
        if (((doo) (obj)).K != null)
        {
            d.add(new bqn(((doo) (obj)).K));
        } else
        if (((doo) (obj)).J != null)
        {
            d.add(new bqp());
        } else
        if (((doo) (obj)).M != null)
        {
            d.add(new bqo(((doo) (obj)).M));
        } else
        if (((doo) (obj)).N != null)
        {
            d.add(new bsa(((doo) (obj)).N, this));
        }
          goto _L3
        return d;
    }
}
