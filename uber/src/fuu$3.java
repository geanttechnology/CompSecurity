// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ang.Object
    implements hst
{

    final fuv a;
    final fuu b;

    private drc b()
    {
        drc drc = fuv.a(a).aN();
        if (drc == null)
        {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        } else
        {
            return drc;
        }
    }

    public final Object a()
    {
        return b();
    }

    (fuu fuu1, fuv fuv1)
    {
        b = fuu1;
        a = fuv1;
        super();
    }
}
