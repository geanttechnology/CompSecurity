// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import hv;
import lu;
import nb;
import ne;
import nr;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistStoreSelectionActivity, BlueAssistDateTimeSelectionActivity

public class BlueAssistAptConfirmationActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener
{

    private BBYTextView a;
    private BBYTextView b;
    private BBYTextView c;
    private BBYTextView d;
    private RelativeLayout e;
    private BBYTextView f;
    private nb g;
    private BBYTextView h;
    private BBYTextView i;
    private BBYTextView j;
    private BBYTextView k;
    private BBYTextView l;
    private BBYStore m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private Dialog u;
    private ImageView v;
    private ImageView w;

    public BlueAssistAptConfirmationActivity()
    {
    }

    private String a(String s1)
    {
        java.util.Date date = ne.b(s1);
        if (s1.equals(ne.a()))
        {
            return (new StringBuilder()).append("Today, ").append(ne.a("EEE, MMM dd", date)).toString();
        } else
        {
            return ne.a("EEE, MMM dd", date);
        }
    }

    private void a()
    {
        h = (BBYTextView)findViewById(0x7f0c0022);
        i = (BBYTextView)findViewById(0x7f0c0024);
        j = (BBYTextView)findViewById(0x7f0c0025);
        k = (BBYTextView)findViewById(0x7f0c0026);
        l = (BBYTextView)findViewById(0x7f0c0027);
        Bundle bundle = getIntent().getExtras();
        n = bundle.getString(getResources().getString(0x7f080053));
        o = bundle.getString(getResources().getString(0x7f080054));
        p = bundle.getString(getResources().getString(0x7f0800b9));
        q = bundle.getString(getResources().getString(0x7f080140));
        String s1 = (new StringBuilder()).append(a(n)).append(" - ").append(b(o)).append(" at").toString();
        h.setText(s1);
        m = (BBYStore)bundle.getSerializable(getResources().getString(0x7f080050));
        if (m != null)
        {
            i.setText(m.getStoreDetails().getName().replace("Best Buy Mobile - ", "").trim());
            j.setText(m.getStoreDetails().getAddress());
            k.setText((new StringBuilder()).append(m.getStoreDetails().getCity()).append(", ").append(m.getStoreDetails().getState()).append(" ").append(m.getStoreDetails().getZipCode()).toString());
            l.setText(nr.a(m));
        }
    }

    static void a(BlueAssistAptConfirmationActivity blueassistaptconfirmationactivity)
    {
        blueassistaptconfirmationactivity.b();
    }

    private String b(String s1)
    {
        String s2 = "";
        if (s1.contains("am") || s1.contains("pm"))
        {
            s2 = s1.replace("am", " AM").replace("pm", " PM");
        }
        return s2;
    }

    private void b()
    {
        u = new Dialog(this);
        u.getWindow().requestFeature(1);
        u.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        u.setContentView(0x7f030015);
        u.show();
        b = (BBYTextView)u.findViewById(0x7f0c006a);
        d = (BBYTextView)u.findViewById(0x7f0c006b);
        b.setOnClickListener(this);
        d.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view == b)
        {
            lu.a(lu.aS);
            view = getIntent().getExtras();
            (new hv(this, m.getStoreId(), q, p, view)).execute(new Void[0]);
        } else
        {
            if (view == c)
            {
                view = new Intent(getApplicationContext(), com/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity);
                view.addFlags(0x4000000);
                Bundle bundle = getIntent().getExtras();
                bundle.putBoolean("blueassist_update", true);
                bundle.putString(getResources().getString(0x7f0800b9), p);
                bundle.putString(getResources().getString(0x7f080141), r);
                bundle.putString(getResources().getString(0x7f080143), s);
                bundle.putString(getResources().getString(0x7f080144), t);
                view.putExtras(bundle);
                startActivity(view);
                return;
            }
            if (view == d)
            {
                view = getIntent().getExtras();
                Intent intent = new Intent(getApplicationContext(), com/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity);
                intent.addFlags(0x4000000);
                view.putBoolean("blueassist_update", true);
                view.putString(getResources().getString(0x7f0800b9), p);
                view.putString(getResources().getString(0x7f080141), r);
                view.putString(getResources().getString(0x7f080143), s);
                view.putString(getResources().getString(0x7f080144), t);
                view.putString(getResources().getString(0x7f080053), n);
                view.putString(getResources().getString(0x7f080054), o);
                intent.putExtras(view);
                startActivity(intent);
                return;
            }
            if (view == w)
            {
                finish();
                return;
            }
            if (view == v)
            {
                view = new Intent(getApplicationContext(), com/bestbuy/android/activities/home/HomeActivity);
                view.addFlags(0x4000000);
                startActivity(view);
                finish();
                overridePendingTransition(0x7f040005, 0x7f040008);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        lu.a(lu.aR);
        g = nb.a();
        g.i(true);
        getActionBar().hide();
        a();
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            r = bundle.getString(getResources().getString(0x7f080141));
            s = bundle.getString(getResources().getString(0x7f080143));
            t = bundle.getString(getResources().getString(0x7f080144));
        }
        a = (BBYTextView)findViewById(0x7f0c0029);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final BlueAssistAptConfirmationActivity a;

            public void onClick(View view)
            {
                BlueAssistAptConfirmationActivity.a(a);
            }

            
            {
                a = BlueAssistAptConfirmationActivity.this;
                super();
            }
        });
        e = (RelativeLayout)findViewById(0x7f0c0020);
        f = (BBYTextView)e.findViewById(0x7f0c015e);
        bundle = (BBYTextView)e.findViewById(0x7f0c015f);
        f.setText(Html.fromHtml(getString(0x7f08021f)));
        bundle.setText(Html.fromHtml(getString(0x7f080231)));
        v = (ImageView)findViewById(0x7f0c0067);
        w = (ImageView)findViewById(0x7f0c0068);
        w.setVisibility(8);
        v.setOnClickListener(this);
    }

    protected void onPause()
    {
        super.onPause();
        if (u != null)
        {
            u.dismiss();
        }
    }
}
