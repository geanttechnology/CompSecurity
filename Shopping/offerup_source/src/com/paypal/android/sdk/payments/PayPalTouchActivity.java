// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.cz;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.fa;
import com.paypal.android.sdk.fi;
import com.paypal.android.sdk.fj;
import com.paypal.android.sdk.fk;
import com.paypal.android.sdk.r;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bk, PayPalService, bm, PayPalOAuthScopes, 
//            PayPalConfiguration, PayPalTouchConfirmation, PayPalTouchResponseBundle, br

public final class PayPalTouchActivity extends Activity
{

    private static final String a = com/paypal/android/sdk/payments/PayPalTouchActivity.getSimpleName();
    private boolean b;
    private PayPalService c;
    private final ServiceConnection d = new bk(this);
    private boolean e;

    public PayPalTouchActivity()
    {
    }

    static PayPalService a(PayPalTouchActivity paypaltouchactivity, PayPalService paypalservice)
    {
        paypaltouchactivity.c = paypalservice;
        return paypalservice;
    }

    static String a()
    {
        return a;
    }

    private static void a(Bundle bundle)
    {
        if (bundle != null)
        {
            for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Object obj = bundle.get(s);
                if (obj == null)
                {
                    String.format("%s:null", new Object[] {
                        s
                    });
                } else
                {
                    String.format("%s:%s (%s)", new Object[] {
                        s, obj.toString(), obj.getClass().getName()
                    });
                }
            }

        }
    }

    static void a(PayPalTouchActivity paypaltouchactivity)
    {
label0:
        {
            if (paypaltouchactivity.b)
            {
                if (paypaltouchactivity.c.e() != null)
                {
                    break label0;
                }
                Log.e(a, "Service state invalid.  Did you start the PayPalService?");
                paypaltouchactivity.setResult(2);
                paypaltouchactivity.finish();
            }
            return;
        }
        bm bm1 = new bm(paypaltouchactivity.getIntent(), paypaltouchactivity.c.e());
        if (!bm1.e())
        {
            Log.e(a, "Service extras invalid.  Please see the docs.");
            paypaltouchactivity.setResult(2);
            paypaltouchactivity.finish();
            return;
        }
        if (!bm1.a())
        {
            Log.e(a, "Extras invalid.  Please see the docs.");
            paypaltouchactivity.setResult(2);
            paypaltouchactivity.finish();
            return;
        } else
        {
            (new StringBuilder("isValidScarecrowAuthenticatorPresent:")).append((new cz()).a(paypaltouchactivity, paypaltouchactivity.c.u()));
            (new StringBuilder("isValidV1TouchAuthenticatorPresent:")).append((new r()).a(paypaltouchactivity, paypaltouchactivity.c.u()));
            new r();
            Intent intent = r.a();
            intent.putExtra("version", "1.0");
            intent.putExtra("app_guid", paypaltouchactivity.c.c().d().e());
            intent.putExtra("client_id", paypaltouchactivity.c.g());
            intent.putExtra("app_name", paypaltouchactivity.c.c().d().c());
            intent.putExtra("environment", paypaltouchactivity.c.f());
            intent.putExtra("environment_url", paypaltouchactivity.c.a());
            intent.putExtra("scope", ((PayPalOAuthScopes)paypaltouchactivity.getIntent().getExtras().get("com.paypal.android.sdk.requested_scopes")).b());
            intent.putExtra("response_type", "code");
            intent.putExtra("privacy_url", paypaltouchactivity.c.e().l());
            intent.putExtra("agreement_url", paypaltouchactivity.c.e().m());
            (new StringBuilder("startActivityForResult(")).append(intent).append(", 1) extras: ").append(intent.getExtras());
            Log.w("paypal.sdk", (new StringBuilder("requesting ")).append(intent.getStringExtra("response_type")).append(" with scope={").append(intent.getStringExtra("scope")).append("} from Authenticator.").toString());
            paypaltouchactivity.startActivityForResult(intent, 1);
            return;
        }
    }

    static PayPalService b(PayPalTouchActivity paypaltouchactivity)
    {
        return paypaltouchactivity.c;
    }

    private static void b(Bundle bundle)
    {
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (obj == null)
            {
                s = String.format("%s:null", new Object[] {
                    s
                });
            } else
            {
                s = String.format("%s:%s (%s)", new Object[] {
                    s, obj.toString(), obj.getClass().getName()
                });
            }
            Log.w("paypal.sdk", s);
        }
    }

    public final void finish()
    {
        super.finish();
        (new StringBuilder()).append(a).append(".finish");
    }

    protected final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        (new StringBuilder()).append(a).append(".onActivityResult(").append(i).append(",").append(j).append(",").append(intent).append(")");
        if (intent != null)
        {
            a(intent.getExtras());
        }
        switch (i)
        {
        default:
            Log.wtf(a, (new StringBuilder("unexpected request code ")).append(i).append(" call it a cancel").toString());
            return;

        case 1: // '\001'
            break;
        }
        if (intent != null && intent.getExtras() != null && !intent.getExtras().isEmpty())
        {
            if (j == -1)
            {
                intent = intent.getExtras();
                intent = new PayPalTouchConfirmation(new PayPalTouchResponseBundle(intent.getString("version"), intent.getString("display_name"), intent.getString("access_token"), intent.getString("response_type"), intent.getString("authorization_code"), intent.getString("expires_in"), intent.getString("scope"), intent.getString("email"), intent.getString("photo_url"), intent.getString("error"), null));
                Intent intent1 = new Intent();
                intent1.putExtra("com.paypal.android.sdk.loginConfirmation", intent);
                setResult(-1, intent1);
                finish();
            } else
            {
                Intent intent2 = new Intent();
                intent2.putExtras(intent.getExtras());
                Log.w("paypal.sdk", "RESULT_CANCELED");
                b(intent.getExtras());
                setResult(0, intent2);
            }
        } else
        {
            setResult(0);
        }
        finish();
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        (new StringBuilder()).append(a).append(".onCreate");
        if (bundle == null)
        {
            (new fk(this)).a();
            (new fj(this)).a();
            (new fi(this)).a(Arrays.asList(new String[] {
                com/paypal/android/sdk/payments/PayPalTouchActivity.getName()
            }));
            (new dd(this)).a(com/paypal/android/sdk/payments/PayPalTouchActivity);
            b = true;
        } else
        {
            b = false;
        }
        e = bindService(com.paypal.android.sdk.payments.br.a(this), d, 1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setTheme(0x1030010);
    }

    protected final Dialog onCreateDialog(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            return com.paypal.android.sdk.payments.br.a(this, fa.bc, bundle, i);

        case 2: // '\002'
            return com.paypal.android.sdk.payments.br.a(this, fa.be, bundle, i);
        }
    }

    protected final void onDestroy()
    {
        (new StringBuilder()).append(a).append(".onDestroy");
        if (c != null)
        {
            c.r();
        }
        if (e)
        {
            unbindService(d);
            e = false;
        }
        super.onDestroy();
    }

}
