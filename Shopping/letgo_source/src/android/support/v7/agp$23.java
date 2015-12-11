// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            afm, agp, agq, afl, 
//            aeu

static final class c
    implements afm
{

    final Class a;
    final Class b;
    final afl c;

    public afl a(aeu aeu, agq agq1)
    {
        aeu = agq1.a();
        if (aeu == a || aeu == b)
        {
            return c;
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Factory[type=").append(a.getName()).append("+").append(b.getName()).append(",adapter=").append(c).append("]").toString();
    }

    (Class class1, Class class2, afl afl)
    {
        a = class1;
        b = class2;
        c = afl;
        super();
    }
}
