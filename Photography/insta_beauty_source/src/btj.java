// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class btj
{

    private final Context a;
    private final bws b;

    public btj(Context context)
    {
        a = context.getApplicationContext();
        b = new bwt(context, "TwitterAdvertisingInfoPreferences");
    }

    static bti a(btj btj1)
    {
        return btj1.e();
    }

    private void a(bti bti1)
    {
        (new Thread(new btk(this, bti1))).start();
    }

    static void a(btj btj1, bti bti1)
    {
        btj1.b(bti1);
    }

    private void b(bti bti1)
    {
        if (c(bti1))
        {
            b.a(b.b().putString("advertising_id", bti1.a).putBoolean("limit_ad_tracking_enabled", bti1.b));
            return;
        } else
        {
            b.a(b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
            return;
        }
    }

    private boolean c(bti bti1)
    {
        return bti1 != null && !TextUtils.isEmpty(bti1.a);
    }

    private bti e()
    {
        bti bti1 = c().a();
        if (!c(bti1))
        {
            bti1 = d().a();
            if (!c(bti1))
            {
                bso.h().a("Fabric", "AdvertisingInfo not present");
                return bti1;
            } else
            {
                bso.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
                return bti1;
            }
        } else
        {
            bso.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
            return bti1;
        }
    }

    public bti a()
    {
        bti bti1 = b();
        if (c(bti1))
        {
            bso.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(bti1);
            return bti1;
        } else
        {
            bti bti2 = e();
            b(bti2);
            return bti2;
        }
    }

    protected bti b()
    {
        return new bti(b.a().getString("advertising_id", ""), b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public btq c()
    {
        return new btl(a);
    }

    public btq d()
    {
        return new btm(a);
    }
}
