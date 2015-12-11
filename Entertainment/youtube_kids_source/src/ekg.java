// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ekg extends eho
{

    final ekd a;

    ekg(ekd ekd1)
    {
        a = ekd1;
        super();
    }

    final eiu c()
    {
        return new ekh(this);
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
            int j = a.b;
            ekf ekf1 = a.a[i & j];
            while (ekf1 != null) 
            {
                if (obj.equals(ekf1.getValue()))
                {
                    return ekf1.getKey();
                }
                ekf1 = ekf1.b();
            }
        }
        return null;
    }

    public final eho l_()
    {
        return a;
    }

    public final int size()
    {
        return a.size();
    }

    final Object writeReplace()
    {
        return new ekj(a);
    }
}
