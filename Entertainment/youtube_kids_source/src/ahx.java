// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

final class ahx extends bmr
{

    private ahs a;

    ahx(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    private chs c()
    {
        String s = ahs.c(a).i().getString("MdxServerSelection", "");
        chs chs1;
        try
        {
            chs1 = chs.valueOf(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            a.i().c("Bogus value in shared preferences for key %s value %s, returning default value.", new Object[] {
                "MdxServerSelection", s
            });
            return chs.d;
        }
        return chs1;
    }

    public final Object a()
    {
        return c();
    }
}
