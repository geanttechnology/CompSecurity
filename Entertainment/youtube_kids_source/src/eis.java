// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class eis extends ehm
{

    private eic a;
    private eir c;

    eis(eir eir, eic eic1)
    {
        c = eir;
        a = eic1;
        super();
    }

    final ehr e()
    {
        return c;
    }

    public final Object get(int i)
    {
        return ((java.util.Map.Entry)a.get(i)).getValue();
    }
}
