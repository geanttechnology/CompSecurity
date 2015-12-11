// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class eki extends ehm
{

    private ekh a;

    eki(ekh ekh1)
    {
        a = ekh1;
        super();
    }

    final ehr e()
    {
        return a;
    }

    public final Object get(int i)
    {
        ekf ekf = ekd.a(a.a.a)[i];
        return ejr.a(ekf.getValue(), ekf.getKey());
    }
}
