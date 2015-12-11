// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

// Referenced classes of package android.support.v7:
//            aot, aos, amj, amn, 
//            alt, amc, aml, amm, 
//            amp

class amk
{

    private final Context a;
    private final aos b;

    public amk(Context context)
    {
        a = context.getApplicationContext();
        b = new aot(context, "TwitterAdvertisingInfoPreferences");
    }

    static amj a(amk amk1)
    {
        return amk1.e();
    }

    private void a(amj amj1)
    {
        (new Thread(new amp(amj1) {

            final amj a;
            final amk b;

            public void onRun()
            {
                amj amj2 = amk.a(b);
                if (!a.equals(amj2))
                {
                    alt.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    amk.a(b, amj2);
                }
            }

            
            {
                b = amk.this;
                a = amj1;
                super();
            }
        })).start();
    }

    static void a(amk amk1, amj amj1)
    {
        amk1.b(amj1);
    }

    private void b(amj amj1)
    {
        if (c(amj1))
        {
            b.a(b.b().putString("advertising_id", amj1.a).putBoolean("limit_ad_tracking_enabled", amj1.b));
            return;
        } else
        {
            b.a(b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
            return;
        }
    }

    private boolean c(amj amj1)
    {
        return amj1 != null && !TextUtils.isEmpty(amj1.a);
    }

    private amj e()
    {
        amj amj1 = c().a();
        if (!c(amj1))
        {
            amj1 = d().a();
            if (!c(amj1))
            {
                alt.h().a("Fabric", "AdvertisingInfo not present");
                return amj1;
            } else
            {
                alt.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
                return amj1;
            }
        } else
        {
            alt.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
            return amj1;
        }
    }

    public amj a()
    {
        amj amj1 = b();
        if (c(amj1))
        {
            alt.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(amj1);
            return amj1;
        } else
        {
            amj amj2 = e();
            b(amj2);
            return amj2;
        }
    }

    protected amj b()
    {
        return new amj(b.a().getString("advertising_id", ""), b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public amn c()
    {
        return new aml(a);
    }

    public amn d()
    {
        return new amm(a);
    }
}
