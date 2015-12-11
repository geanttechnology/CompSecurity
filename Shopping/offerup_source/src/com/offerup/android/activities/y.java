// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import com.b.a.a.g;
import com.braintreepayments.api.Braintree;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.MaskedWallet;
import com.offerup.android.dto.GoogleWalletMetaData;
import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.network.b;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            k, aa

public abstract class y extends k
{

    PaymentMethod a;
    Braintree b;
    String c;
    MaskedWallet d;
    private boolean j;

    public y()
    {
    }

    final void a()
    {
        g.a("payments_debugger", "1. getBraintreeTokenFromServer()");
        a(0x7f0901b1);
        com.offerup.android.network.b.b(new aa(this));
    }

    final void a(PaymentMethod paymentmethod)
    {
        if (paymentmethod == null || d == null) goto _L2; else goto _L1
_L1:
        InstrumentInfo ainstrumentinfo[] = d.getInstrumentInfos();
        if (ainstrumentinfo == null || ainstrumentinfo.length <= 0 || ainstrumentinfo[0] == null) goto _L2; else goto _L3
_L3:
        String s;
        Object obj;
        obj = ainstrumentinfo[0];
        s = ((InstrumentInfo) (obj)).getInstrumentType();
        if (!StringUtils.isNotEmpty(s)) goto _L5; else goto _L4
_L4:
        s = s.toLowerCase();
        if (!s.contains("visa")) goto _L7; else goto _L6
_L6:
        s = "Visa";
_L9:
        obj = ((InstrumentInfo) (obj)).getInstrumentDetails();
        if (StringUtils.isNotEmpty(s) && StringUtils.isNotEmpty(((CharSequence) (obj))))
        {
            paymentmethod.setGoogleWalletMetaData(new GoogleWalletMetaData(s, ((String) (obj))));
        }
_L2:
        return;
_L7:
        if (s.contains("ame"))
        {
            s = "American Express";
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("mast"))
        {
            s = "Mastercard";
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("disc"))
        {
            s = "Discover";
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("jcb"))
        {
            s = "JCP";
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("diner"))
        {
            s = "Diners Club";
            continue; /* Loop/switch isn't completed */
        }
_L5:
        s = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void a(String s)
    {
    }

    public void b(PaymentMethod paymentmethod)
    {
    }

    public void b(String s)
    {
    }

    public void b(boolean flag)
    {
    }

    final void c(String s)
    {
        g.a("payments_debugger", (new StringBuilder("6. createMaskedWallet() with amount of $")).append(s).toString());
        s = Cart.newBuilder().setCurrencyCode("USD").setTotalPrice(s).build();
        b.performAndroidPayMaskedWalletRequest(this, 260, s);
    }

    final void f()
    {
        b.performAndroidPayChangeMaskedWalletRequest(this, 262, c);
    }

    public void onActivityResult(int i, int l, Intent intent)
    {
        if (i == 113)
        {
            if (l == -1 && intent.hasExtra("paymentMethod"))
            {
                a = (PaymentMethod)intent.getParcelableExtra("paymentMethod");
                j = true;
            }
        } else
        if (i == 459)
        {
            if (l == -1 && intent.hasExtra("paymentMethod"))
            {
                a = (PaymentMethod)intent.getParcelableExtra("paymentMethod");
                if (intent.hasExtra("googleMaskedWallet"))
                {
                    d = (MaskedWallet)intent.getParcelableExtra("googleMaskedWallet");
                    if (d != null)
                    {
                        c = d.getGoogleTransactionId();
                    }
                }
                b(a);
                return;
            }
        } else
        if (i == 260 || i == 262)
        {
            StringBuilder stringbuilder = new StringBuilder("7. maskedWalletOnActivityResult() isOK = ");
            boolean flag;
            if (l == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            g.a("payments_debugger", stringbuilder.append(Boolean.toString(flag)).toString());
            if (l == -1)
            {
                String s = b.getAndroidPayGoogleTransactionId(intent);
                g.a("payments_debugger", "8. receivedGoogleTransactionId(googleTransactionId)");
                if (StringUtils.isNotEmpty(s))
                {
                    d = (MaskedWallet)intent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
                }
                b(s);
                return;
            } else
            {
                a("Error", "An error has occurred. If this problem persists, please contact support.");
                d = null;
                c = null;
                b(((String) (null)));
                return;
            }
        } else
        {
            super.onActivityResult(i, l, intent);
            return;
        }
    }

    protected void onPostResume()
    {
        super.onPostResume();
        if (j)
        {
            b(a);
            j = false;
        }
    }
}
