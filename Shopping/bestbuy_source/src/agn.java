// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class agn extends agu
{

    private static volatile agn c[];
    public String a;
    public ago b;

    public agn()
    {
        b();
    }

    public static agn[] a()
    {
        if (c == null)
        {
            synchronized (agy.a)
            {
                if (c == null)
                {
                    c = new agn[0];
                }
            }
        }
        return c;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public agn a(agr agr1)
    {
        do
        {
            int i = agr1.a();
            switch (i)
            {
            default:
                if (a(agr1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                a = agr1.h();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new ago();
                }
                agr1.a(b);
                break;
            }
        } while (true);
    }

    public void a(ags ags1)
    {
        ags1.a(1, a);
        if (b != null)
        {
            ags1.a(2, b);
        }
        super.a(ags1);
    }

    public agn b()
    {
        a = "";
        b = null;
        o = null;
        p = -1;
        return this;
    }

    public aha b(agr agr1)
    {
        return a(agr1);
    }

    protected int c()
    {
        int j = super.c() + ags.b(1, a);
        int i = j;
        if (b != null)
        {
            i = j + ags.c(2, b);
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof agn)) goto _L4; else goto _L3
_L3:
        obj = (agn)obj;
        if (a != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((agn) (obj)).a != null) goto _L4; else goto _L7
_L7:
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        flag = flag1;
        if (((agn) (obj)).b != null) goto _L4; else goto _L8
_L8:
        return a(((agu) (obj)));
_L6:
        if (!a.equals(((agn) (obj)).a))
        {
            return false;
        }
          goto _L7
        if (!b.equals(((agn) (obj)).b))
        {
            return false;
        }
          goto _L8
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b != null)
        {
            j = b.hashCode();
        }
        return ((i + 527) * 31 + j) * 31 + d();
    }
}
