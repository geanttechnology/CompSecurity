// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.e.a;
import com.b.a.a.g;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Order;
import com.offerup.android.dto.Payment;
import com.offerup.android.dto.PaymentResponse;
import com.offerup.android.e.d;
import com.offerup.android.service.PaymentLocationService;
import com.offerup.android.utils.u;
import com.squareup.otto.Bus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            PayCashlessActivity, a, PostPaymentConfirmationActivity

final class ev
    implements Callback
{

    private PayCashlessActivity a;

    private ev(PayCashlessActivity paycashlessactivity)
    {
        a = paycashlessactivity;
        super();
    }

    ev(PayCashlessActivity paycashlessactivity, byte byte0)
    {
        this(paycashlessactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a(this, retrofiterror);
        a.i();
        a.a(a.getString(0x7f09017d), u.a(retrofiterror, a.getString(0x7f09018e)));
    }

    public final void success(Object obj, Response response)
    {
        response = (PaymentResponse)obj;
        a.i();
        obj = a;
        android.support.v4.e.a.j();
        android.support.v4.e.a.i();
        android.support.v4.e.a.k();
        com.offerup.android.utils.a.a(((PayCashlessActivity) (obj)).j.getId());
        com.offerup.android.b.a.getInstance().post(new d(((PayCashlessActivity) (obj)).j.getId()));
        com.offerup.android.activities.a a1 = ((PayCashlessActivity) (obj)).f;
        long l = response.getPayment().getId();
        Object obj1 = new Intent(a1.a.getApplicationContext(), com/offerup/android/service/PaymentLocationService);
        ((Intent) (obj1)).putExtra("paymentId", l);
        ((Intent) (obj1)).putExtra("isSeller", false);
        a1.a.startService(((Intent) (obj1)));
        a1 = ((PayCashlessActivity) (obj)).f;
        obj1 = ((PayCashlessActivity) (obj)).j;
        l = response.getPayment().getOrder().getId();
        response = response.getPayment().getAmount();
        Intent intent = new Intent(a1.a, com/offerup/android/activities/PostPaymentConfirmationActivity);
        intent.putExtra("item", ((android.os.Parcelable) (obj1)));
        intent.putExtra("orderId", l);
        intent.putExtra("price", response);
        a1.a.startActivity(intent);
        ((PayCashlessActivity) (obj)).finish();
    }
}
