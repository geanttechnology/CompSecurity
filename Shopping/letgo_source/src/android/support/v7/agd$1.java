// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.GenericArrayType;

// Referenced classes of package android.support.v7:
//            afm, agd, agq, aft, 
//            aeu, afl

static final class ArrayType
    implements afm
{

    public afl a(aeu aeu1, agq agq1)
    {
        agq1 = agq1.b();
        if (!(agq1 instanceof GenericArrayType) && (!(agq1 instanceof Class) || !((Class)agq1).isArray()))
        {
            return null;
        } else
        {
            agq1 = aft.g(agq1);
            return new agd(aeu1, aeu1.a(agq.a(agq1)), aft.e(agq1));
        }
    }

    ArrayType()
    {
    }
}
