// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            afm, afo, afl, agq, 
//            afu, afz, aeu

public final class agg
    implements afm
{

    private final afu a;

    public agg(afu afu1)
    {
        a = afu1;
    }

    static afl a(afu afu1, aeu aeu, agq agq1, afo afo1)
    {
        afo1 = afo1.a();
        if (android/support/v7/afl.isAssignableFrom(afo1))
        {
            return (afl)afu1.a(agq.b(afo1)).a();
        }
        if (android/support/v7/afm.isAssignableFrom(afo1))
        {
            return ((afm)afu1.a(agq.b(afo1)).a()).a(aeu, agq1);
        } else
        {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
        }
    }

    public afl a(aeu aeu, agq agq1)
    {
        afo afo1 = (afo)agq1.a().getAnnotation(android/support/v7/afo);
        if (afo1 == null)
        {
            return null;
        } else
        {
            return a(a, aeu, agq1, afo1);
        }
    }
}
