// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;

public final class bbl extends bbo
{

    private final azb a;
    private final bae b;

    public bbl(String s, Context context)
    {
        a = bac.a(s, context);
        b = new bae(a);
    }

    public final ayh a(ayh ayh, ayh ayh1)
    {
        try
        {
            ayh = (Uri)ayk.a(ayh);
            ayh1 = (Context)ayk.a(ayh1);
            ayh = ayk.a(b.a(ayh, ayh1, null, false));
        }
        // Misplaced declaration of an exception variable
        catch (ayh ayh)
        {
            return null;
        }
        return ayh;
    }

    public final String a()
    {
        return "ms";
    }

    public final void a(String s)
    {
        b.c = s.split(",");
    }

    public final void a(String s, String s1)
    {
        bae bae1 = b;
        bae1.a = s;
        bae1.b = s1;
    }

    public final boolean a(ayh ayh)
    {
        ayh = (Uri)ayk.a(ayh);
        return b.a(ayh);
    }

    public final boolean b(ayh ayh)
    {
        ayh = (Uri)ayk.a(ayh);
        return b.b(ayh);
    }

    public final String c(ayh ayh)
    {
        ayh = (Context)ayk.a(ayh);
        return a.a(ayh);
    }
}
