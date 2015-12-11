// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aia extends bmr
{

    private ahs a;

    aia(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    public final Object a()
    {
        aly aly1;
label0:
        {
            aly1 = new aly(a.g(), a.i());
            if (ahs.h(a).u().b)
            {
                ajm ajm1 = new ajm(a.k());
                if (aly1.c != null)
                {
                    break label0;
                }
                aly1.c = (ama)b.b(ajm1, "provider cannot be null");
            }
            return aly1;
        }
        chq chq = aly1.b;
        return aly1;
    }
}
