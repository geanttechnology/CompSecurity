// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.tracker.a;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Referenced classes of package com.offerup.android.activities:
//            a, ex, ey, ez, 
//            fa

public class PaymentFinalConfirmationActivity extends Activity
{

    double a;
    PaymentMethod b;
    com.offerup.android.activities.a c;
    private NumberFormat d;

    public PaymentFinalConfirmationActivity()
    {
        d = new DecimalFormat("#0.00");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04002f);
        c = new com.offerup.android.activities.a(this);
        TextView textview1 = (TextView)findViewById(0x7f10010b);
        TextView textview = (TextView)findViewById(0x7f10010c);
        bundle = (Button)findViewById(0x7f10010e);
        Button button = (Button)findViewById(0x7f10010d);
        Object obj = getIntent().getExtras();
        if (obj != null)
        {
            if (((Bundle) (obj)).containsKey("price"))
            {
                a = ((Bundle) (obj)).getDouble("price");
            }
            if (((Bundle) (obj)).containsKey("paymentMethod"))
            {
                b = (PaymentMethod)((Bundle) (obj)).getParcelable("paymentMethod");
            }
        }
        bundle.setOnClickListener(new ex(this));
        obj = d.format(a);
        bundle = ((Bundle) (obj));
        if (((String) (obj)).endsWith(".00"))
        {
            bundle = ((String) (obj)).substring(0, ((String) (obj)).length() - 3);
        }
        button.setText((new StringBuilder()).append(getResources().getText(0x7f09019e)).append("  |  $").append(bundle).toString());
        button.setOnClickListener(new ey(this));
        bundle = textview1.getText().toString();
        obj = getString(0x7f09019f);
        int i = bundle.indexOf(((String) (obj)));
        int j = ((String) (obj)).length();
        bundle = new SpannableString(bundle);
        bundle.setSpan(new ez(this, (byte)0), i, j + i, 0);
        textview1.setText(bundle);
        textview1.setMovementMethod(new LinkMovementMethod());
        bundle = textview.getText().toString();
        obj = getString(0x7f0901a0);
        i = bundle.indexOf(((String) (obj)));
        j = ((String) (obj)).length();
        bundle = new SpannableString(bundle);
        bundle.setSpan(new fa(this, (byte)0), i, j + i, 0);
        textview.setText(bundle);
        textview.setMovementMethod(new LinkMovementMethod());
    }

    protected void onResume()
    {
        super.onResume();
        com.offerup.android.tracker.a.a("payments_payseller_confirmation");
    }
}
