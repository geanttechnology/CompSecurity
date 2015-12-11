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
//            h, az, ay, at, 
//            au, av, aw, ax

public class ChangePostLocationActivity extends h
{

    OfferUpLocation a;
    String b;
    boolean c;
    boolean d;
    EditText j;
    Button k;
    private String l;
    private TextView m;
    private ImageButton n;
    private ScrollView o;

    public ChangePostLocationActivity()
    {
        b = "";
        l = "";
        c = false;
        d = false;
    }

    public static boolean a(String s)
    {
        return Pattern.matches("^\\d{5}(-\\d{4})?$", s);
    }

    private void n()
    {
        o.setBackgroundResource(0x7f020161);
    }

    final void a()
    {
        Intent intent;
        if (d)
        {
            com.offerup.android.tracker.a.a(getApplicationContext(), a, m.getText().toString(), "ou_item_post_location_gps");
        } else
        {
            com.offerup.android.tracker.a.a(getApplicationContext(), a, m.getText().toString(), "ou_item_post_location_zip_code");
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
            an.a(ap.b, offeruplocation.i());
            an.a(ap.b, offeruplocation);
            d = true;
            b(offeruplocation);
        } else
        {
            an.a(ap.b, null);
            an.a(ap.b, new OfferUpLocation());
        }
        runOnUiThread(new az(this, offeruplocation));
    }

    final String b()
    {
        return "post_location_picker";
    }

    final void b(OfferUpLocation offeruplocation)
    {
        if (offeruplocation != null)
        {
            a = offeruplocation;
            m.setVisibility(0);
            if (StringUtils.isEmpty(offeruplocation.f()) || StringUtils.isEmpty(offeruplocation.h()))
            {
                m.setText(getString(0x7f090143));
                if (offeruplocation.d() != 0.0D && offeruplocation.c() != 0.0D)
                {
                    j.setText("");
                    e.A("");
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
            l = (new StringBuilder()).append(s).append(s1).toString();
            m.setText(l);
            o.fullScroll(33);
            if (offeruplocation.a() != null)
            {
                j.setText(offeruplocation.a());
                e.A(offeruplocation.a());
                return;
            } else
            {
                j.setText("");
                e.A("");
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
            g.setButton(-1, "OK", new ay(this));
            g.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OfferUpLocation offeruplocation)
        {
            g.c("ChangePostLocationActivity", Log.getStackTraceString(offeruplocation));
        }
    }

    protected final void m()
    {
        j.setError("Please enter a valid US zip code");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040025);
        getSupportActionBar().hide();
        j = (EditText)findViewById(0x7f1000e4);
        o = (ScrollView)findViewById(0x7f1000de);
        bundle = (TextView)findViewById(0x7f1000e0);
        bundle.setTypeface(Typeface.createFromAsset(getAssets(), "segoesc.ttf"));
        bundle.setShadowLayer(1.0F, 1.0F, 1.0F, 0x7f0e0095);
        String s;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            try
            {
                o.setBackground(getResources().getDrawable(0x7f020161));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                try
                {
                    n();
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle) { }
            }
        } else
        {
            n();
        }
        b = e.K();
        if (StringUtils.isNotEmpty(e.N()))
        {
            bundle = e.N();
        } else
        {
            bundle = "";
        }
        if (StringUtils.isNotEmpty(e.O()))
        {
            s = e.O();
        } else
        {
            s = "";
        }
        if (StringUtils.isNotEmpty(bundle) && StringUtils.isNotEmpty(s))
        {
            l = (new StringBuilder()).append(bundle).append(", ").append(s).toString();
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
            j.setText(b);
        }
        j.setOnClickListener(new at(this));
        EditText edittext = j;
        j.setOnEditorActionListener(new au(this, edittext));
        j.setOnClickListener(new av(this));
        m = (TextView)findViewById(0x7f1000e1);
        if (StringUtils.isNotEmpty(l))
        {
            m.setText(l);
            m.setVisibility(0);
        }
        k = (Button)findViewById(0x7f1000e5);
        k.setOnClickListener(new aw(this));
        n = (ImageButton)findViewById(0x7f1000e2);
        n.setOnClickListener(new ax(this));
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        android.view.ViewGroup.LayoutParams layoutparams = j.getLayoutParams();
        layoutparams.width = n.getWidth();
        j.setLayoutParams(layoutparams);
    }
}
