// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class agu extends aha
{

    protected agw o;

    public agu()
    {
    }

    public void a(ags ags)
    {
        if (o != null)
        {
            int i = 0;
            while (i < o.a()) 
            {
                o.b(i).a(ags);
                i++;
            }
        }
    }

    protected final boolean a(agr agr1, int i)
    {
        int j = agr1.q();
        if (!agr1.b(i))
        {
            return false;
        }
        int k = ahd.b(i);
        ahc ahc1 = new ahc(i, agr1.a(j, agr1.q() - j));
        agr1 = null;
        Object obj;
        if (o == null)
        {
            o = new agw();
        } else
        {
            agr1 = o.a(k);
        }
        obj = agr1;
        if (agr1 == null)
        {
            obj = new agx();
            o.a(k, ((agx) (obj)));
        }
        ((agx) (obj)).a(ahc1);
        return true;
    }

    protected final boolean a(agu agu1)
    {
        if (o == null || o.b())
        {
            return agu1.o == null || agu1.o.b();
        } else
        {
            return o.equals(agu1.o);
        }
    }

    protected int c()
    {
        int j = 0;
        int k;
        if (o != null)
        {
            int i = 0;
            do
            {
                k = i;
                if (j >= o.a())
                {
                    break;
                }
                i += o.b(j).a();
                j++;
            } while (true);
        } else
        {
            k = 0;
        }
        return k;
    }

    protected final int d()
    {
        if (o == null || o.b())
        {
            return 0;
        } else
        {
            return o.hashCode();
        }
    }
}
