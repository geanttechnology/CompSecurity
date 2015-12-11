// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            afm, agp, agq, aeu, 
//            afl

static final class 
    implements afm
{

    public afl a(aeu aeu, agq agq1)
    {
        agq1 = agq1.a();
        if (!java/lang/Enum.isAssignableFrom(agq1) || agq1 == java/lang/Enum)
        {
            return null;
        }
        aeu = agq1;
        if (!agq1.isEnum())
        {
            aeu = agq1.getSuperclass();
        }
        return new init>(aeu);
    }

    ()
    {
    }
}
