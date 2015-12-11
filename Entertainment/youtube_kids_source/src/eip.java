// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class eip extends ehm
{

    private eic a;
    private eio c;

    eip(eio eio, eic eic1)
    {
        c = eio;
        a = eic1;
        super();
    }

    final ehr e()
    {
        return c;
    }

    public final Object get(int i)
    {
        return ((java.util.Map.Entry)a.get(i)).getKey();
    }
}
