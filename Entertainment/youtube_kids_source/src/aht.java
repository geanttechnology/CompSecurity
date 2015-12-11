// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aht extends bmr
{

    private ahs a;

    aht(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    public final Object a()
    {
        iq iq1 = (new iq()).a("MDX_MEDIA_ROUTE_CONTROL_CATEGORY").a(a.h(ahs.a(a).c));
        chr chr1 = ahs.b(a);
        boolean flag;
        if (chr1.b)
        {
            flag = true;
        } else
        {
            flag = chr1.a.e;
        }
        if (flag)
        {
            iq1.a("android.media.intent.category.LIVE_AUDIO");
        }
        return iq1.a();
    }
}
