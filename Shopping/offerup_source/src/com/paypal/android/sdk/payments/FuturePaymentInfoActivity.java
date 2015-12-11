// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fa;

// Referenced classes of package com.paypal.android.sdk.payments:
//            k, l, br, j

public final class FuturePaymentInfoActivity extends Activity
{

    private l a;

    public FuturePaymentInfoActivity()
    {
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (k)getIntent().getExtras().getSerializable("com.paypal.details.scope");
        dd.b(this);
        dd.a(this);
        a = new l(this, bundle);
        setContentView(a.a);
        br.a(this, a.b, null);
        a.c.setText(ex.a(fa.d));
        a.c.setOnClickListener(new j(this));
    }
}
