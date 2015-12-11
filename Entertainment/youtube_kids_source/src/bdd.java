// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public final class bdd
{

    public bdi a;
    final bmi b;
    public String c;
    final bkn d;
    public cvi e;
    final SharedPreferences f;
    public String g;
    public bme h;
    public ctw i;

    public bdd(bmi bmi1, SharedPreferences sharedpreferences, bkn bkn1)
    {
        g = "";
        b = (bmi)b.a(bmi1);
        f = (SharedPreferences)b.a(sharedpreferences);
        d = (bkn)b.a(bkn1);
    }

    public final bdc a()
    {
        b.a(a);
        return new bdc(this);
    }
}
