// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            afm, afk, afh, aez, 
//            afs, agq, aeu, afl

private static class <init>
    implements afm
{

    private final agq a;
    private final boolean b;
    private final Class c;
    private final afh d;
    private final aez e;

    public afl a(aeu aeu, agq agq1)
    {
        boolean flag;
        if (a != null)
        {
            if (a.equals(agq1) || b && a.b() == agq1.a())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = c.isAssignableFrom(agq1.a());
        }
        if (flag)
        {
            return new afk(d, e, aeu, agq1, this, null);
        } else
        {
            return null;
        }
    }

    private (Object obj, agq agq1, boolean flag, Class class1)
    {
        afh afh1;
        boolean flag1;
        if (obj instanceof afh)
        {
            afh1 = (afh)obj;
        } else
        {
            afh1 = null;
        }
        d = afh1;
        if (obj instanceof aez)
        {
            obj = (aez)obj;
        } else
        {
            obj = null;
        }
        e = ((aez) (obj));
        if (d != null || e != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        afs.a(flag1);
        a = agq1;
        b = flag;
        c = class1;
    }

    c(Object obj, agq agq1, boolean flag, Class class1, c c1)
    {
        this(obj, agq1, flag, class1);
    }
}
