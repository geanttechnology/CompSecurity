// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;

public final class cof extends Enum
{

    public static final cof a;
    public static final cof b;
    public static final cof c;
    public static final cof d;
    private static final cof f[];
    final Uri e;

    private cof(String s, int i, String s1)
    {
        super(s, i);
        e = Uri.parse(s1);
    }

    public static int a()
    {
        return 0;
    }

    public static cof a(SharedPreferences sharedpreferences)
    {
        b.a(sharedpreferences);
        sharedpreferences = sharedpreferences.getString("ApiaryHostSelection", values()[0].toString());
        cof cof1;
        try
        {
            cof1 = valueOf(sharedpreferences);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            String s = String.valueOf("Bogus value in shared preferences for key ApiaryHostSelection value ");
            bmo.b((new StringBuilder(String.valueOf(s).length() + 25 + String.valueOf(sharedpreferences).length())).append(s).append(sharedpreferences).append(" returning default value.").toString());
            return values()[0];
        }
        return cof1;
    }

    public static cof valueOf(String s)
    {
        return (cof)Enum.valueOf(cof, s);
    }

    public static cof[] values()
    {
        return (cof[])f.clone();
    }

    static 
    {
        a = new cof("PRODUCTION", 0, "https://www.googleapis.com");
        b = new cof("STAGING", 1, "https://www-googleapis-staging.sandbox.google.com");
        c = new cof("TEST", 2, "https://www-googleapis-test.sandbox.google.com");
        d = new cof("PPG", 3, "http://127.0.0.1:8787");
        f = (new cof[] {
            a, b, c, d
        });
    }
}
