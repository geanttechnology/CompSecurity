// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.InputFilter;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import com.b.a.a.g;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.models.CardBuilder;
import com.offerup.android.network.PaymentService;
import com.offerup.android.network.b;
import com.offerup.android.network.o;
import com.offerup.android.utils.as;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;

// Referenced classes of package com.offerup.android.activities:
//            k, fl, fg, ff, 
//            fj, fi, fh, fk, 
//            fe

public class PaymentMethodCaptureActivity extends k
{

    final Pattern a = Pattern.compile("([0-9]{0,4})|([0-9]{4}\\s)+|([0-9]{4}\\s[0-9]{0,4})+");
    final Pattern b = Pattern.compile("([0-9]{0,4})|([0-9]{4}\\s)+|([0-9]{4}\\s[0-9]{0,6})+");
    final Pattern c = Pattern.compile("([0-9]{0,2})|([0-9]{0,2})\\s|([0-9]{0,2})\\s\\/|([0-9]{0,2})\\s\\/\\s|([0-9]{0,2})\\s\\/\\s+");
    final Pattern d = Pattern.compile("^4[0-9]{6,}$");
    final Pattern j = Pattern.compile("^5[1-5][0-9]{5,}$");
    final Pattern k = Pattern.compile("^3[47][0-9]{5,}$");
    final Pattern l = Pattern.compile("^6(?:011|5[0-9]{2})[0-9]{3,}$");
    final Pattern m = Pattern.compile("^(?:2131|1800|35[0-9]{3})[0-9]{3,}$");
    final Pattern n = Pattern.compile("^3(?:0[0-5]|[68][0-9])[0-9]{4,}$");
    final InputFilter o[] = {
        new android.text.InputFilter.LengthFilter(19)
    };
    final InputFilter p[] = {
        new android.text.InputFilter.LengthFilter(17)
    };
    final InputFilter q[] = {
        new android.text.InputFilter.LengthFilter(4)
    };
    final InputFilter r[] = {
        new android.text.InputFilter.LengthFilter(3)
    };
    EditText s;
    EditText t;
    EditText u;
    EditText v;
    Button w;
    boolean x;
    private Braintree y;
    private ff z;

    public PaymentMethodCaptureActivity()
    {
    }

    static String a(PaymentMethodCaptureActivity paymentmethodcaptureactivity, CharSequence charsequence)
    {
        return a(charsequence);
    }

    private static String a(CharSequence charsequence)
    {
        return charsequence.toString().replaceAll("[^0-9]", "");
    }

    static void a(PaymentMethodCaptureActivity paymentmethodcaptureactivity, int i)
    {
        switch (i)
        {
        default:
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0200bc, 0);
            return;

        case 1: // '\001'
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201a4, 0);
            return;

        case 2: // '\002'
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f02019f, 0);
            return;

        case 3: // '\003'
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201a3, 0);
            return;

        case 4: // '\004'
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201a1, 0);
            return;

        case 5: // '\005'
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201a2, 0);
            return;

        case 6: // '\006'
            paymentmethodcaptureactivity.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201a0, 0);
            break;
        }
    }

    static void a(PaymentMethodCaptureActivity paymentmethodcaptureactivity, String s1)
    {
        paymentmethodcaptureactivity = new fl(paymentmethodcaptureactivity, (byte)0);
        com.offerup.android.network.o.k(com.offerup.android.network.o.a(Executors.newCachedThreadPool())).addCard(s1, paymentmethodcaptureactivity);
    }

    private void a(Callback callback)
    {
        try
        {
            g = ProgressDialog.show(this, "", "Processing...");
        }
        catch (Exception exception)
        {
            g.a(getClass().getSimpleName(), exception);
        }
        com.offerup.android.network.b.b(callback);
    }

    static boolean a(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        Object obj = paymentmethodcaptureactivity.s.getText().toString();
        if (StringUtils.isEmpty(((CharSequence) (obj))))
        {
            as.a(paymentmethodcaptureactivity.s, "You must enter a valid number.");
            return false;
        }
        obj = ((String) (obj)).replaceAll("\\s", "").replace("-", "");
        if (StringUtils.isNumericSpace(((CharSequence) (obj))) && (((String) (obj)).length() < 15 || ((String) (obj)).length() > 16))
        {
            as.a(paymentmethodcaptureactivity.s, "You must enter a valid number.");
            return false;
        }
        int j1 = ((String) (obj)).length() - 1;
        boolean flag1 = false;
        int l1 = 0;
        while (j1 >= 0) 
        {
            int i2 = Integer.parseInt(((String) (obj)).substring(j1, j1 + 1));
            int i = i2;
            if (flag1)
            {
                i2 <<= 1;
                i = i2;
                if (i2 > 9)
                {
                    i = i2 % 10 + 1;
                }
            }
            l1 += i;
            if (!flag1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            j1--;
            flag1 = i;
        }
        boolean flag;
        if (l1 % 10 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            as.a(paymentmethodcaptureactivity.s, "You must enter a valid number.");
            return false;
        }
        String s1 = paymentmethodcaptureactivity.t.getText().toString();
        if (StringUtils.isEmpty(s1) || a(((CharSequence) (s1))).length() != 4 || !StringUtils.isNumeric(a(((CharSequence) (s1)))))
        {
            as.a(paymentmethodcaptureactivity.t, "Invalid date.");
            return false;
        }
        obj = Calendar.getInstance();
        int i1 = ((Calendar) (obj)).get(1);
        s1 = a(((CharSequence) (s1)));
        j1 = Integer.parseInt(s1.substring(2, 4)) + 2000;
        if (j1 < i1)
        {
            as.a(paymentmethodcaptureactivity.t, "Invalid date.");
            return false;
        }
        int k1 = Integer.parseInt(s1.substring(0, 2));
        l1 = ((Calendar) (obj)).get(2);
        if (k1 > 12 || k1 <= 0)
        {
            as.a(paymentmethodcaptureactivity.t, "Invalid date.");
            return false;
        }
        if (j1 == i1 && k1 <= l1 + 1)
        {
            as.a(paymentmethodcaptureactivity.t, "Invalid date.");
            return false;
        }
        obj = paymentmethodcaptureactivity.u.getText().toString();
        if (StringUtils.isEmpty(((CharSequence) (obj))) || ((String) (obj)).trim().length() > 4 || ((String) (obj)).trim().length() < 3 || !StringUtils.isNumeric(((String) (obj)).trim()))
        {
            as.a(paymentmethodcaptureactivity.u, "You must enter a valid value.");
            return false;
        }
        obj = paymentmethodcaptureactivity.v.getText().toString();
        if (StringUtils.isEmpty(((CharSequence) (obj))) || a(((CharSequence) (obj))).length() != 5)
        {
            as.a(paymentmethodcaptureactivity.v, "You must enter a valid postal code.");
            return false;
        } else
        {
            return true;
        }
    }

    static void b(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        paymentmethodcaptureactivity.a(new fg(paymentmethodcaptureactivity, (new CardBuilder()).cardNumber(paymentmethodcaptureactivity.s.getText().toString().replaceAll("\\s", "")).cvv(paymentmethodcaptureactivity.u.getText().toString()).postalCode(paymentmethodcaptureactivity.v.getText().toString().trim()).expirationDate(paymentmethodcaptureactivity.t.getText().toString().replaceAll("\\s", "")), (byte)0));
    }

    public final void a(String s1)
    {
        if (StringUtils.isNotEmpty(s1))
        {
            a("Error", s1);
            return;
        } else
        {
            a("Error", "There was an error adding your card. Please try again.");
            return;
        }
    }

    protected final void a(String s1, CardBuilder cardbuilder)
    {
        z = new ff(this, (byte)0);
        y = Braintree.getInstance(getApplicationContext(), s1);
        y.addListener(z);
        y.tokenize(cardbuilder);
    }

    final String b()
    {
        return "payments_paymentmethod_entry";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040032);
        bundle = getSupportActionBar();
        bundle.setHomeButtonEnabled(true);
        bundle.setDisplayShowHomeEnabled(true);
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setDisplayUseLogoEnabled(false);
        bundle.setDisplayShowTitleEnabled(true);
        bundle.setTitle("Add Card");
        s = (EditText)findViewById(0x7f100115);
        t = (EditText)findViewById(0x7f100116);
        u = (EditText)findViewById(0x7f100117);
        v = (EditText)findViewById(0x7f100118);
        w = (Button)findViewById(0x7f100119);
        s.addTextChangedListener(new fj(this, s));
        t.addTextChangedListener(new fi(this, t));
        u.addTextChangedListener(new fh(this));
        v.addTextChangedListener(new fk(this));
        w.setOnClickListener(new fe(this));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onPause()
    {
        super.onPause();
        if (y != null && z != null)
        {
            y.lockListeners();
            y.removeListener(z);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (y != null && z != null)
        {
            y.addListener(z);
            y.unlockListeners();
        }
    }
}
