// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.g;
import com.braintreepayments.api.Braintree;
import com.google.android.gms.wallet.Cart;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.CreditCard;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.GoogleWalletMetaData;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.dto.Person;
import com.offerup.android.network.PaymentService;
import com.offerup.android.network.b;
import com.offerup.android.network.o;
import com.offerup.android.utils.as;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.offerup.android.activities:
//            y, a, PaymentMethodsActivity, ev, 
//            es, et, eu

public class PayCashlessActivity extends y
{

    Item j;
    String k;
    double l;
    private BuyRequest m;
    private NumberFormat n;
    private boolean o;
    private Button p;
    private TextView q;
    private TextView r;
    private EditText s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private View w;

    public PayCashlessActivity()
    {
        n = new DecimalFormat("#0.00");
    }

    private void a(double d)
    {
        k = n.format(d);
    }

    static boolean a(PayCashlessActivity paycashlessactivity)
    {
        return paycashlessactivity.m();
    }

    static void b(PayCashlessActivity paycashlessactivity)
    {
label0:
        {
            if (paycashlessactivity.m())
            {
                if (paycashlessactivity.d == null || paycashlessactivity.a == null || !paycashlessactivity.a.isAndroidPay())
                {
                    break label0;
                }
                a a1 = paycashlessactivity.f;
                double d = paycashlessactivity.l;
                PaymentMethod paymentmethod = paycashlessactivity.a;
                paycashlessactivity = paycashlessactivity.d;
                Intent intent = new Intent(a1.a, com/offerup/android/activities/PaymentMethodsActivity);
                intent.putExtra("price", d);
                intent.putExtra("comingFrom", "fromPay");
                intent.putExtra("paymentMethod", paymentmethod);
                intent.putExtra("googleMaskedWallet", paycashlessactivity);
                a1.a.startActivityForResult(intent, 459);
            }
            return;
        }
        a a2 = paycashlessactivity.f;
        double d1 = paycashlessactivity.l;
        paycashlessactivity = new Intent(a2.a, com/offerup/android/activities/PaymentMethodsActivity);
        paycashlessactivity.putExtra("price", d1);
        paycashlessactivity.putExtra("comingFrom", "fromPay");
        a2.a.startActivityForResult(paycashlessactivity, 459);
    }

    static void c(PayCashlessActivity paycashlessactivity)
    {
        paycashlessactivity.n();
    }

    private void g()
    {
        a(0x7f090154);
        com.b.a.a.g.a("payments_debugger", "9. createFullWallet()");
        Cart cart = Cart.newBuilder().setCurrencyCode("USD").setTotalPrice(k).build();
        b.performAndroidPayFullWalletRequest(this, 261, cart, a.getGoogleWalletTransactionId());
    }

    private boolean m()
    {
        String s2 = s.getText().toString();
        String s1 = s2;
        if (StringUtils.isNotEmpty(s2))
        {
            s1 = s2;
            if (s2.contains("$"))
            {
                s1 = s2.replace("$", "");
            }
        }
        if (!NumberUtils.isNumber(s1) || Double.parseDouble(s1) <= 0.0D)
        {
            s.setError(getString(0x7f09018f));
            a(0.0D);
            return false;
        } else
        {
            l = Double.parseDouble(s1);
            a(l);
            return true;
        }
    }

    private void n()
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        p.setText(getString(0x7f090193));
        w.setVisibility(0);
        if (a.getCreditCard() == null) goto _L4; else goto _L3
_L3:
        Object obj = a.getCreditCard();
        if (!StringUtils.isNotEmpty(((CreditCard) (obj)).getCardType())) goto _L6; else goto _L5
_L5:
        r.setVisibility(0);
        r.setText((new StringBuilder("x")).append(((CreditCard) (obj)).getLastFour()).toString());
        q.setText(((CreditCard) (obj)).getDisplayName());
        obj = ((CreditCard) (obj)).getCardType();
        if (!StringUtils.isNotEmpty(((CharSequence) (obj)))) goto _L8; else goto _L7
_L7:
        obj = ((String) (obj)).toLowerCase();
        if (!((String) (obj)).contains("visa")) goto _L10; else goto _L9
_L9:
        int i = 0x7f0200c8;
_L15:
        if (i <= 0) goto _L12; else goto _L11
_L11:
        t.setVisibility(0);
        t.setImageResource(i);
_L6:
        return;
_L10:
        if (((String) (obj)).contains("ame"))
        {
            i = 0x7f0200c3;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).contains("mast"))
        {
            i = 0x7f0200c7;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).contains("disc"))
        {
            i = 0x7f0200c5;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).contains("jcb"))
        {
            i = 0x7f0200c6;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).contains("diner"))
        {
            i = 0x7f0200c4;
            continue; /* Loop/switch isn't completed */
        }
          goto _L8
_L12:
        t.setVisibility(4);
        return;
_L4:
        if (!a.isAndroidPay()) goto _L6; else goto _L13
_L13:
        q.setText(getString(0x7f090191));
        if (a.getGoogleWalletMetaData() != null)
        {
            r.setVisibility(0);
            GoogleWalletMetaData googlewalletmetadata = a.getGoogleWalletMetaData();
            r.setText((new StringBuilder()).append(googlewalletmetadata.getDisplayName()).append(" x").append(googlewalletmetadata.getLastFour()).toString());
        } else
        {
            r.setVisibility(8);
        }
        t.setImageResource(0x7f020126);
        return;
_L2:
        p.setText(getString(0x7f090192));
        w.setVisibility(8);
        return;
_L8:
        i = 0;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public final void a(String s1)
    {
        String s2 = k;
        a(0x7f090154);
        long l1 = j.getId();
        ev ev1 = new ev(this, (byte)0);
        com.offerup.android.network.o.k(com.offerup.android.network.o.c(Executors.newSingleThreadExecutor())).payForItemWithNonce(l1, s2, s1, ev1);
    }

    final String b()
    {
        return "payments_payseller_cart";
    }

    public final void b(PaymentMethod paymentmethod)
    {
        a = paymentmethod;
        n();
    }

    public final void b(String s1)
    {
        if (StringUtils.isNotEmpty(s1))
        {
            c = s1;
            a = new PaymentMethod(s1);
            if (!o)
            {
                a(a);
                n();
                return;
            } else
            {
                o = false;
                g();
                return;
            }
        } else
        {
            p.setText(getString(0x7f090192));
            a = null;
            w.setVisibility(8);
            return;
        }
    }

    public final void b(boolean flag)
    {
label0:
        {
            if (flag)
            {
                if (!StringUtils.isNotEmpty(c))
                {
                    break label0;
                }
                g();
            }
            return;
        }
        a(0x7f0901b1);
        c(k);
    }

    public void onActivityResult(int i, int i1, Intent intent)
    {
        i();
        super.onActivityResult(i, i1, intent);
        if (i != 10) goto _L2; else goto _L1
_L1:
        if (i1 == -1 && intent.getBooleanExtra("submit", false))
        {
            double d = intent.getDoubleExtra("price", 0.0D);
            k = n.format(d);
            a = (PaymentMethod)intent.getParcelableExtra("paymentMethod");
            intent = k;
            String s1 = a.getToken();
            a(0x7f090154);
            long l1 = j.getId();
            ev ev1 = new ev(this, (byte)0);
            com.offerup.android.network.o.k(com.offerup.android.network.o.c(Executors.newSingleThreadExecutor())).payForItem(l1, intent, s1, ev1);
        }
_L4:
        return;
_L2:
        if (i != 17)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i1 != -1) goto _L4; else goto _L3
_L3:
        o = true;
        double d1 = intent.getDoubleExtra("price", 0.0D);
        k = n.format(d1);
        if (StringUtils.isNotEmpty(c) && this.d != null && b != null)
        {
            g();
            return;
        } else
        {
            a();
            return;
        }
        if (i != 261) goto _L4; else goto _L5
_L5:
        com.b.a.a.g.a("payments_debugger", "10. fullWalletOnActivityResult()");
        a(0x7f090154);
        com.b.a.a.g.a("payments_debugger", "11. getNonceFromFullWallet()");
        b.getNonceFromAndroidPayFullWalletResponse(i1, intent);
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040093);
        bundle = getIntent();
        j = (Item)bundle.getParcelableExtra("item");
        m = (BuyRequest)bundle.getParcelableExtra("currentBuyRequest");
        bundle.getLongExtra("orderKey", 0L);
        ImageView imageview = (ImageView)findViewById(0x7f100231);
        TextView textview = (TextView)findViewById(0x7f100236);
        s = (EditText)findViewById(0x7f100237);
        q = (TextView)findViewById(0x7f10023a);
        r = (TextView)findViewById(0x7f10023b);
        p = (Button)findViewById(0x7f100238);
        t = (ImageView)findViewById(0x7f100239);
        w = findViewById(0x7f100232);
        u = (ImageView)findViewById(0x7f100233);
        v = (TextView)findViewById(0x7f100234);
        if (m != null && StringUtils.isNotEmpty(m.getOffer()))
        {
            bundle = m.getOffer();
        } else
        {
            bundle = j.getPrice();
        }
        if (StringUtils.isNotEmpty(bundle))
        {
            s.setText((new StringBuilder("$")).append(bundle).toString());
            s.setSelection(s.getText().length());
        }
        as.a(s);
        bundle = j.getOwner();
        Picasso.with(getApplicationContext()).load(bundle.getGetProfile().getAvatarNormal()).into(u);
        v.setText(bundle.getFirstName());
        Picasso.with(getApplicationContext()).load(j.getGetImgPermalinkMedium()).into(imageview);
        textview.setText(j.getTitle());
        p.setOnClickListener(new es(this));
        w.setOnClickListener(new et(this));
        if (a != null)
        {
            n();
            return;
        } else
        {
            g = ProgressDialog.show(this, "", getString(0x7f0901b1));
            com.offerup.android.network.b.a(new eu(this, (byte)0));
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110002, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            h = true;
            onBackPressed();
            return true;

        case 2131755393: 
            finish();
            break;
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        if (b != null)
        {
            b.onPause(this);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (b != null)
        {
            b.onResume(this);
        }
        s.requestFocus();
        as.a(this, s);
    }
}
