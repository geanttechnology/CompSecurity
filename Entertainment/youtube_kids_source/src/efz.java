// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class efz extends efy
{

    private String b;
    private efy c;

    efz(efy efy1, efy efy2, String s)
    {
        c = efy1;
        b = s;
        super(efy2);
    }

    public final efy a()
    {
        throw new UnsupportedOperationException("already specified useForNull");
    }

    final CharSequence a(Object obj)
    {
        if (obj == null)
        {
            return b;
        } else
        {
            return c.a(obj);
        }
    }

    public final efy b(String s)
    {
        f.b(s);
        throw new UnsupportedOperationException("already specified useForNull");
    }
}
