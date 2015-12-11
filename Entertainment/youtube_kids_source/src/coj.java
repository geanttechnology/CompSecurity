// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public final class coj extends Enum
{

    public static final coj a;
    private static coj c;
    private static coj d;
    private static coj e;
    private static final coj f[];
    final String b;

    private coj(String s, int i, String s1)
    {
        super(s, i);
        b = s1;
    }

    public static int a()
    {
        return 0;
    }

    public static coj a(SharedPreferences sharedpreferences)
    {
        b.a(sharedpreferences);
        sharedpreferences = sharedpreferences.getString("InnerTubeApiSelection", values()[0].toString());
        coj coj1;
        try
        {
            coj1 = valueOf(sharedpreferences);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            String s = String.valueOf("Bogus value in shared preferences for key InnerTubeApiSelection value ");
            bmo.b((new StringBuilder(String.valueOf(s).length() + 25 + String.valueOf(sharedpreferences).length())).append(s).append(sharedpreferences).append(" returning default value.").toString());
            return values()[0];
        }
        return coj1;
    }

    public static coj valueOf(String s)
    {
        return (coj)Enum.valueOf(coj, s);
    }

    public static coj[] values()
    {
        return (coj[])f.clone();
    }

    static 
    {
        c = new coj("V1", 0, "youtubei/v1");
        a = new coj("V1RELEASE_ONLY_WORKS_IN_STAGING", 1, "youtubei/v1release");
        d = new coj("PRERELEASE", 2, "youtubei/vi");
        e = new coj("VIX", 3, "youtubei/vix");
        f = (new coj[] {
            c, a, d, e
        });
    }
}
