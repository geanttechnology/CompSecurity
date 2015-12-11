// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.Locale;

final class aap extends bmr
{

    private aaa a;

    aap(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        bdd bdd1 = new bdd(a.c.b(), a.c.i(), a.c.h());
        android.telephony.TelephonyManager telephonymanager = a.c.k();
        bdd1.a = (bdi)b.a((bdi)a.z.b_());
        bdd1.c = bnh.a(telephonymanager, Locale.getDefault());
        bdd1.e = a.w();
        bdd1.g = (String)b.a(bce.a(a.a.getContentResolver(), "youtube_client_id", "android-google"));
        bdd1.h = a.r();
        bdd1.i = (ctw)a.B.b_();
        if (a.e(a.a))
        {
            bgs bgs1 = new bgs(a.c.i());
            if (bgs1.a())
            {
                return new bgr(bdd1, bgs1);
            }
        }
        return bdd1.a();
    }
}
