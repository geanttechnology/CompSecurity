// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ekm extends eij
{

    private static final long serialVersionUID = 0L;
    private final transient eko a[];
    private final transient eko b[];
    private final transient int c;

    transient ekm(java.util.Map.Entry aentry[])
    {
        int k = aentry.length;
        a = new eko[k];
        int i = ehl.a(k, 1.2D);
        b = new eko[i];
        c = i - 1;
        for (int j = 0; j < k; j++)
        {
            Object obj = aentry[j];
            Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
            int l = ehl.a(obj1.hashCode());
            l = c & l;
            eko eko1 = b[l];
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if (eko1 == null)
            {
                obj = new ekq(obj1, obj);
            } else
            {
                obj = new ekp(obj1, obj, eko1);
            }
            obj = (eko)obj;
            b[l] = ((eko) (obj));
            a[j] = ((eko) (obj));
            obj = eko1;
            while (obj != null) 
            {
                boolean flag;
                if (!obj1.equals(((eko) (obj)).getKey()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f.a(flag, "duplicate key: %s", new Object[] {
                    obj1
                });
                obj = ((eko) (obj)).a();
            }
        }

    }

    static eko[] a(ekm ekm1)
    {
        return ekm1.a;
    }

    final eiu c()
    {
        return new ekn(this);
    }

    public final boolean containsValue(Object obj)
    {
        if (obj != null)
        {
            eko aeko[] = a;
            int j = aeko.length;
            int i = 0;
            while (i < j) 
            {
                if (aeko[i].getValue().equals(obj))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    final boolean e()
    {
        return false;
    }

    public final Object get(Object obj)
    {
        if (obj != null)
        {
            int i = ehl.a(obj.hashCode());
            int j = c;
            eko eko1 = b[i & j];
            while (eko1 != null) 
            {
                if (obj.equals(eko1.getKey()))
                {
                    return eko1.getValue();
                }
                eko1 = eko1.a();
            }
        }
        return null;
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final int size()
    {
        return a.length;
    }
}
