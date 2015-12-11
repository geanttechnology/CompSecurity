// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.dto.PaymentMethodResponse;
import com.offerup.android.utils.u;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            PayCashlessActivity

final class eu
    implements Callback
{

    private PayCashlessActivity a;

    private eu(PayCashlessActivity paycashlessactivity)
    {
        a = paycashlessactivity;
        super();
    }

    eu(PayCashlessActivity paycashlessactivity, byte byte0)
    {
        this(paycashlessactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a(this, retrofiterror);
        a.i();
        a.a(a.getString(0x7f09017d), u.a(retrofiterror, a.getString(0x7f090190)));
    }

    public final void success(Object obj, Response response)
    {
label0:
        {
            obj = (PaymentMethodResponse)obj;
            a.i();
            if (((PaymentMethodResponse) (obj)).isSuccess())
            {
                if (((PaymentMethodResponse) (obj)).getPaymentMethods() != null && ((PaymentMethodResponse) (obj)).getPaymentMethods().size() > 0)
                {
                    obj = ((PaymentMethodResponse) (obj)).getPaymentMethods();
                    Collections.sort(((List) (obj)));
                    a.a = (PaymentMethod)((List) (obj)).get(0);
                }
                if (a.a == null || !a.a.isAndroidPay())
                {
                    break label0;
                }
                if (StringUtils.isEmpty(a.k))
                {
                    PayCashlessActivity.a(a);
                    if (StringUtils.isEmpty(a.k))
                    {
                        a.k = "0.50";
                    }
                }
                a.a();
            }
            return;
        }
        PayCashlessActivity.c(a);
    }
}
