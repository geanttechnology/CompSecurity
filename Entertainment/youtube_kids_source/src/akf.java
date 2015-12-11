// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;

final class akf
    implements awk
{

    private awi a;
    private awk b;
    private akc c;

    akf(akc akc1, awi awi, awk awk1)
    {
        c = akc1;
        a = awi;
        b = awk1;
        super();
    }

    public final void a(int i)
    {
        b.a(i);
    }

    public final void a(Bundle bundle)
    {
        if (c.d)
        {
            bundle = c.a;
            return;
        } else
        {
            chq chq = c.a;
            c.b = a;
            b.a(bundle);
            return;
        }
    }
}
