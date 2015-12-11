// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.an;
import com.offerup.android.utils.ap;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            h, aq, ap, ak, 
//            al, am, an, ao

public class ChangeLocationActivity extends h
{

    OfferUpLocation a;
    String b;
    boolean c;
    EditText d;
    Button j;
    private String k;
    private TextView l;
    private ImageButton m;
    private ScrollView n;

    public ChangeLocationActivity()
    {
        b = "";
        k = "";
        c = false;
    }

    public static boolean a(String s)
    {
        return Pattern.matches("^\\d{5}(-\\d{4})?$", s);
    }

    private void n()
    {
        n.setBackgroundResource(0x7f020161);
    }

    final void a()
    {
        Intent intent;
        if (c)
        {
            com.offerup.android.tracker.a.a(getApplicationContext(), a, l.getText().toString(), "ou_search_location_gps");
        } else
        {
            com.offerup.android.tracker.a.a(getApplicationContext(), a, l.getText().toString(), "ou_search_location_zip_code");
        }
        intent = new Intent();
        if (a != null)
        {
            intent.putExtra("address", "true");
            a.a(null);
            intent.putExtra("location", a);
        }
        intent.putExtra("zipCode", b);
        setResult(-1, intent);
        finish();
    }

    public final void a(OfferUpLocation offeruplocation)
    {
        i();
        if (offeruplocation != null)
        {
            c = true;
            an.a(ap.a, null);
            an.a(ap.a, offeruplocation.i());
            getApplicationContext();
            an.a(ap.a, offeruplocation);
        } else
        {
            an.a(ap.a, null);
            an.a(ap.a, null);
            getApplicationContext();
            an.a(ap.a, new OfferUpLocation());
        }
        runOnUiThread(new aq(this, offeruplocation));
    }

    final String b()
    {
        return "search_location_picker";
    }

    final void b(OfferUpLocation offeruplocation)
    {
        if (offeruplocation != null)
        {
            a = offeruplocation;
            l.setVisibility(0);
            if (StringUtils.isEmpty(offeruplocation.f()) || StringUtils.isEmpty(offeruplocation.h()))
            {
                l.setText(getString(0x7f090143));
                if (offeruplocation.d() != 0.0D && offeruplocation.c() != 0.0D)
                {
                    d.setText("");
                    e.p("");
                }
                return;
            }
            String s;
            String s1;
            if (offeruplocation.f() != null)
            {
                s = offeruplocation.f();
            } else
            {
                s = "";
            }
            if (offeruplocation.h() != null)
            {
                s1 = (new StringBuilder(", ")).append(offeruplocation.h()).toString();
            } else
            {
                s1 = "";
            }
            k = (new StringBuilder()).append(s).append(s1).toString();
            l.setText(k);
            n.fullScroll(33);
            if (offeruplocation.a() != null)
            {
                d.setText(offeruplocation.a());
                e.p(offeruplocation.a());
                return;
            } else
            {
                d.setText("");
                e.p("");
                return;
            }
        }
        offeruplocation = getString(0x7f090146);
        android.graphics.drawable.Drawable drawable = android.support.v4.b.a.a(getApplicationContext(), 0x7f0201e1);
        i();
        try
        {
            g = new ProgressDialog(this);
            g.setMessage(offeruplocation);
            g.setProgressStyle(0);
            g.setIndeterminateDrawable(drawable);
            g.setButton(-1, "OK", new com.offerup.android.activities.ap(this));
            g.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OfferUpLocation offeruplocation)
        {
            g.c("ChangeLocationActivity", Log.getStackTraceString(offeruplocation));
        }
    }

    protected final void m()
    {
        d.setError("Please enter a valid US zip code");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040025);
        getSupportActionBar().hide();
        d = (EditText)findViewById(0x7f1000e4);
        n = (ScrollView)findViewById(0x7f1000de);
        b = e.E();
        String s;
        if (StringUtils.isNotEmpty(e.I()))
        {
            bundle = e.I();
        } else
        {
            bundle = "";
        }
        if (StringUtils.isNotEmpty(e.J()))
        {
            s = e.J();
        } else
        {
            s = "";
        }
        if (StringUtils.isNotEmpty(bundle) && StringUtils.isNotEmpty(s))
        {
            k = (new StringBuilder()).append(bundle).append(", ").append(s).toString();
        }
        bundle = (TextView)findViewById(0x7f1000e0);
        bundle.setTypeface(Typeface.createFromAsset(getAssets(), "segoesc.ttf"));
        bundle.setShadowLayer(1.0F, 1.0F, 1.0F, 0x7f0e0095);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            try
            {
                n.setBackground(getResources().getDrawable(0x7f020161));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            try
            {
                n();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                return;
            }
        } else
        {
            n();
            return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (StringUtils.isNotEmpty(b) && !b.equals("null"))
        {
            d.setText(b);
        }
        d.setOnClickListener(new ak(this));
        EditText edittext = d;
        d.setOnEditorActionListener(new al(this, edittext));
        d.setOnClickListener(new am(this));
        l = (TextView)findViewById(0x7f1000e1);
        if (StringUtils.isNotEmpty(k))
        {
            l.setText(k);
            l.setVisibility(0);
        }
        j = (Button)findViewById(0x7f1000e5);
        j.setOnClickListener(new com.offerup.android.activities.an(this));
        m = (ImageButton)findViewById(0x7f1000e2);
        m.setOnClickListener(new ao(this));
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        android.view.ViewGroup.LayoutParams layoutparams = d.getLayoutParams();
        layoutparams.width = m.getWidth();
        d.setLayoutParams(layoutparams);
    }
}
