// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.e.a;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.netverify.sdk.NetverifySDK;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.offerup.android.network.b;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.v;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            k, ib, TruYouConfActivity, ie, 
//            ia, ic, hy, hz

public class TruYouInitActivity extends k
{

    private boolean a;
    private ImageView b;
    private ImageView c;
    private NetverifySDK d;
    private CallbackManager j;

    public TruYouInitActivity()
    {
    }

    static void a(TruYouInitActivity truyouinitactivity)
    {
        LoginManager.getInstance().registerCallback(truyouinitactivity.j, new ib(truyouinitactivity, (byte)0));
        LoginManager.getInstance().logInWithReadPermissions(truyouinitactivity, v.b);
    }

    static void a(TruYouInitActivity truyouinitactivity, AccessToken accesstoken)
    {
        com.b.a.a.j.a().f(accesstoken.getToken());
    }

    static boolean a(TruYouInitActivity truyouinitactivity, boolean flag)
    {
        truyouinitactivity.a = flag;
        return flag;
    }

    static void b(TruYouInitActivity truyouinitactivity)
    {
        if (truyouinitactivity.a)
        {
            truyouinitactivity.d.start();
            return;
        }
        try
        {
            truyouinitactivity.a("Step 1 Required", "You must first complete facebook verification");
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(truyouinitactivity, exception);
        }
        return;
    }

    static void c(TruYouInitActivity truyouinitactivity)
    {
        truyouinitactivity.b.setClickable(true);
    }

    static boolean d(TruYouInitActivity truyouinitactivity)
    {
        return truyouinitactivity.a;
    }

    static void e(TruYouInitActivity truyouinitactivity)
    {
        truyouinitactivity.b.setClickable(false);
        truyouinitactivity.b.setImageResource(0x7f02010f);
        truyouinitactivity.b.setOnTouchListener(null);
    }

    static void f(TruYouInitActivity truyouinitactivity)
    {
        truyouinitactivity.c.setClickable(false);
    }

    static void g(TruYouInitActivity truyouinitactivity)
    {
        truyouinitactivity.startActivityForResult(new Intent(truyouinitactivity, com/offerup/android/activities/TruYouConfActivity), 5);
        truyouinitactivity.finish();
    }

    final String b()
    {
        return "truyou_verification";
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
label0:
        {
label1:
            {
                super.onActivityResult(i, l, intent);
                j.onActivityResult(i, l, intent);
                if (i == NetverifySDK.REQUEST_CODE)
                {
                    if (l != 100)
                    {
                        break label0;
                    }
                    if (intent == null)
                    {
                        intent = "";
                    } else
                    {
                        intent = intent.getStringExtra("scanReference");
                    }
                    if (!StringUtils.isNotEmpty(intent))
                    {
                        break label1;
                    }
                    g = ProgressDialog.show(this, "", "Please wait...");
                    com.offerup.android.network.b.b(intent, new ie(this));
                }
                return;
            }
            com.b.a.a.g.c(getClass().getSimpleName(), "Got an empty scan reference back from Jumio");
            a(getString(0x7f09017d), getString(0x7f09017b));
            return;
        }
        if (l == 101)
        {
            if (intent != null)
            {
                intent.getStringExtra("scanReference");
            }
            intent.getIntExtra("errorCode", 0);
            if (intent != null)
            {
                intent.getStringExtra("errorMessage");
            }
            com.b.a.a.g.c(getClass().getSimpleName(), "Got a cancel result code from Jumio");
            return;
        } else
        {
            com.b.a.a.g.c(getClass().getSimpleName(), "Result code from Jumio are neither success nor cancel");
            a(getString(0x7f09017d), getString(0x7f09017a));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003f);
        bundle = (TextView)findViewById(0x7f100149);
        TextView textview = (TextView)findViewById(0x7f10014b);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "segoesc.ttf");
        bundle.setTypeface(typeface);
        textview.setTypeface(typeface);
        j = com.facebook.CallbackManager.Factory.create();
        b = (ImageView)findViewById(0x7f10014a);
        c = (ImageView)findViewById(0x7f10014c);
        b.setOnTouchListener(new ia(this, b));
        c.setOnTouchListener(new ia(this, c));
        if (StringUtils.isNotEmpty(ba.b()) && android.support.v4.e.a.b(getApplicationContext()))
        {
            (new ic(this)).execute(new Void[0]);
        }
        b.setOnClickListener(new hy(this));
        c.setOnClickListener(new hz(this));
        try
        {
            bundle = new ArrayList(1);
            bundle.add(NVDocumentType.DRIVER_LICENSE);
            d = NetverifySDK.create(this, "501f1258-0c0a-4ecd-b314-88430941edee", "9bb99a98b8d7541641e40f09237b7b5c", JumioDataCenter.US);
            d.setCustomerId(String.valueOf(e.n()));
            d.setRequireVerification(true);
            d.setRequireFaceMatch(true);
            d.setPreselectedCountry("USA");
            d.setPreselectedDocumentTypes(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.b.a.a.g.a(this, bundle);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110011, menu);
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        System.gc();
    }
}
