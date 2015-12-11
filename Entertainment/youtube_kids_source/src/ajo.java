// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ajo
    implements bxr
{

    private final amd a;

    public ajo(amd amd1)
    {
        a = (amd)b.a(amd1);
    }

    public final void a(bxu bxu1)
    {
        String s = a.t();
        if (s != null)
        {
            if (s.equals("tvlite"))
            {
                bxu1.E = 8;
                return;
            }
            if (s.equals("xbox"))
            {
                bxu1.E = 11;
                return;
            }
        }
        bxu1.E = 7;
    }
}
