// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            a, fb, fc, fd

public class PaymentInitialConfirmationActivity extends Activity
{

    Item a;
    BuyRequest b;
    com.offerup.android.activities.a c;

    public PaymentInitialConfirmationActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040030);
        c = new com.offerup.android.activities.a(this);
        Object obj = (Button)findViewById(0x7f100113);
        Object obj1 = (Button)findViewById(0x7f100112);
        bundle = (TextView)findViewById(0x7f100111);
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null)
        {
            if (bundle1.containsKey("item"))
            {
                a = (Item)bundle1.getParcelable("item");
            }
            if (bundle1.containsKey("currentBuyRequest"))
            {
                b = (BuyRequest)bundle1.getParcelable("currentBuyRequest");
            }
        }
        ((Button) (obj)).setOnClickListener(new fb(this));
        ((Button) (obj1)).setOnClickListener(new fc(this));
        obj = getString(0x7f0901a3);
        obj1 = new SpannableString(((CharSequence) (obj)));
        ((SpannableString) (obj1)).setSpan(new fd(this), 0, ((String) (obj)).length(), 0);
        bundle.setText(((CharSequence) (obj1)));
        bundle.setMovementMethod(new LinkMovementMethod());
    }

    protected void onResume()
    {
        super.onResume();
        com.offerup.android.tracker.a.a("payments_payseller_with_seller");
    }
}
