// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            afm, agp, agq, afl, 
//            aeu

static final class b
    implements afm
{

    final Class a;
    final afl b;

    public afl a(aeu aeu, agq agq1)
    {
        if (a.isAssignableFrom(agq1.a()))
        {
            return b;
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Factory[typeHierarchy=").append(a.getName()).append(",adapter=").append(b).append("]").toString();
    }

    (Class class1, afl afl)
    {
        a = class1;
        b = afl;
        super();
    }
}
