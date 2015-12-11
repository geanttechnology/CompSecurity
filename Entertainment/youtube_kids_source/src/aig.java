// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aig extends bmr
{

    private ahs a;

    aig(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    public final Object a()
    {
        android.content.Context context = ahs.e(a);
        akj akj1 = (akj)ahs.i(a).b_();
        String s = ahs.a(a).c;
        aku aku = a.b();
        chq chq = a.i();
        boolean flag;
        if (!ahs.a(a).a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new ajs(context, akj1, s, aku, chq, flag);
    }
}
