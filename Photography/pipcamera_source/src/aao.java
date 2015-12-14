// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class aao
{

    private final Context a;
    private final adf b;

    public aao(Context context)
    {
        a = context.getApplicationContext();
        b = new adg(context, "TwitterAdvertisingInfoPreferences");
    }

    static aan a(aao aao1)
    {
        return aao1.e();
    }

    private void a(aan aan1)
    {
        (new Thread(new aav(aan1) {

            final aan a;
            final aao b;

            public void onRun()
            {
                aan aan2 = aao.a(b);
                if (!a.equals(aan2))
                {
                    zw.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    aao.a(b, aan2);
                }
            }

            
            {
                b = aao.this;
                a = aan1;
                super();
            }
        })).start();
    }

    static void a(aao aao1, aan aan1)
    {
        aao1.b(aan1);
    }

    private void b(aan aan1)
    {
        if (c(aan1))
        {
            b.a(b.b().putString("advertising_id", aan1.a).putBoolean("limit_ad_tracking_enabled", aan1.b));
            return;
        } else
        {
            b.a(b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
            return;
        }
    }

    private boolean c(aan aan1)
    {
        return aan1 != null && !TextUtils.isEmpty(aan1.a);
    }

    private aan e()
    {
        aan aan1 = c().a();
        if (!c(aan1))
        {
            aan1 = d().a();
            if (!c(aan1))
            {
                zw.h().a("Fabric", "AdvertisingInfo not present");
                return aan1;
            } else
            {
                zw.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
                return aan1;
            }
        } else
        {
            zw.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
            return aan1;
        }
    }

    public aan a()
    {
        aan aan1 = b();
        if (c(aan1))
        {
            zw.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(aan1);
            return aan1;
        } else
        {
            aan aan2 = e();
            b(aan2);
            return aan2;
        }
    }

    protected aan b()
    {
        return new aan(b.a().getString("advertising_id", ""), b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public aat c()
    {
        return new aap(a);
    }

    public aat d()
    {
        return new aaq(a);
    }
}
