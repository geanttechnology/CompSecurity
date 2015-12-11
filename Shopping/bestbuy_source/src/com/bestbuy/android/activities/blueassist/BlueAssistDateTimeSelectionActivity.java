// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import bt;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.blueshirt.AppointmentSlots;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import hw;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lu;
import nb;
import ne;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistAptConfirmationActivity, BlueAssistUserContactInfoActivity

public class BlueAssistDateTimeSelectionActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    private android.app.DatePickerDialog.OnDateSetListener a;
    private Calendar b;
    private String c;
    private ListView d;
    private String e;
    private List f;
    private BBYStore g;
    private bt h;
    private ProgressBar i;
    private BBYTextView j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private ImageView s;
    private ImageView t;
    private DatePickerDialog u;

    public BlueAssistDateTimeSelectionActivity()
    {
    }

    static String a(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity, String s1)
    {
        blueassistdatetimeselectionactivity.e = s1;
        return s1;
    }

    static Calendar a(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity)
    {
        return blueassistdatetimeselectionactivity.b;
    }

    static void a(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity, String s1, String s2)
    {
        blueassistdatetimeselectionactivity.a(s1, s2);
    }

    private void a(String s1, String s2)
    {
        (new hw(this, s1, s2, "", i)).executeOnExecutor(nb.h, new Void[0]);
    }

    static String b(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity)
    {
        return blueassistdatetimeselectionactivity.e;
    }

    static String b(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity, String s1)
    {
        blueassistdatetimeselectionactivity.r = s1;
        return s1;
    }

    private void b()
    {
        getActionBar().hide();
        Object obj = (RelativeLayout)findViewById(0x7f0c0020);
        BBYTextView bbytextview = (BBYTextView)((RelativeLayout) (obj)).findViewById(0x7f0c015e);
        obj = (BBYTextView)((RelativeLayout) (obj)).findViewById(0x7f0c015f);
        bbytextview.setText(Html.fromHtml(getString(0x7f08021f)));
        ((BBYTextView) (obj)).setText(Html.fromHtml(getString(0x7f0802fb)));
        bbytextview = (BBYTextView)findViewById(0x7f0c0062);
        bbytextview.setOnClickListener(this);
        if (q != null && !q.isEmpty())
        {
            bbytextview.setText(ne.a("EEE, MMM dd", ne.b(r)));
        } else
        {
            bbytextview.setText((new StringBuilder()).append("Today - ").append(ne.c("EEE, MMM dd")).toString());
        }
        i = (ProgressBar)findViewById(0x7f0c0065);
        j = (BBYTextView)findViewById(0x7f0c0066);
        j.setVisibility(8);
        b = Calendar.getInstance();
        a = new android.app.DatePickerDialog.OnDateSetListener(bbytextview) {

            final BBYTextView a;
            final BlueAssistDateTimeSelectionActivity b;

            private void a()
            {
                a.setText(ne.a("EEE, MMM dd", BlueAssistDateTimeSelectionActivity.a(b).getTime()));
            }

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                BlueAssistDateTimeSelectionActivity.a(b).set(1, i1);
                BlueAssistDateTimeSelectionActivity.a(b).set(2, j1);
                BlueAssistDateTimeSelectionActivity.a(b).set(5, k1);
                a();
                BlueAssistDateTimeSelectionActivity.a(b, ne.a("MM/dd/yyyy", BlueAssistDateTimeSelectionActivity.a(b).getTime()));
                BlueAssistDateTimeSelectionActivity.b(b, BlueAssistDateTimeSelectionActivity.b(b));
                BlueAssistDateTimeSelectionActivity.a(b, BlueAssistDateTimeSelectionActivity.c(b), BlueAssistDateTimeSelectionActivity.b(b));
            }

            
            {
                b = BlueAssistDateTimeSelectionActivity.this;
                a = bbytextview;
                super();
            }
        };
    }

    static String c(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity)
    {
        return blueassistdatetimeselectionactivity.c;
    }

    public static String d(BlueAssistDateTimeSelectionActivity blueassistdatetimeselectionactivity)
    {
        return blueassistdatetimeselectionactivity.o;
    }

    public void a()
    {
        if (u == null)
        {
            u = new DatePickerDialog(this, 0x7f0e0012, a, b.get(1), b.get(2), b.get(5));
            u.getDatePicker().setMinDate(System.currentTimeMillis() - 1000L);
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, 90);
            u.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        }
        u.show();
    }

    public void a(ArrayList arraylist)
    {
label0:
        {
label1:
            {
                if (arraylist != null)
                {
                    arraylist = (AppointmentSlots)arraylist.get(0);
                    if (arraylist == null || arraylist.getSlots().size() <= 0)
                    {
                        break label0;
                    }
                    j.setVisibility(8);
                    f.clear();
                    f.addAll(arraylist.getSlots());
                    if (h == null)
                    {
                        break label1;
                    }
                    h.notifyDataSetChanged();
                }
                return;
            }
            h = new bt(this, this, f);
            d = (ListView)findViewById(0x102000a);
            d.setAdapter(h);
            d.setOnItemClickListener(this);
            d.setBackgroundResource(0x7f02002d);
            return;
        }
        j.setVisibility(0);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131492962 2131492962: default 24
    //                   2131492962 240;
           goto _L1 _L2
_L1:
        if (view != t) goto _L4; else goto _L3
_L3:
        if (q == null || q.isEmpty()) goto _L6; else goto _L5
_L5:
        view = new Intent(getApplicationContext(), com/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity);
        view.addFlags(0x4000000);
        Bundle bundle = getIntent().getExtras();
        bundle.putString(getResources().getString(0x7f080054), o);
        bundle.putString(getResources().getString(0x7f080053), r);
        bundle.putSerializable(getResources().getString(0x7f080050), g);
        bundle.putString(getResources().getString(0x7f080141), l);
        bundle.putString(getResources().getString(0x7f080143), m);
        bundle.putString(getResources().getString(0x7f080144), n);
        bundle.putString(getResources().getString(0x7f080140), p);
        bundle.putString(getResources().getString(0x7f0800b9), q);
        view.putExtras(bundle);
        startActivity(view);
        finish();
_L8:
        return;
_L2:
        a();
        continue; /* Loop/switch isn't completed */
_L6:
        finish();
        return;
_L4:
        if (view != s) goto _L8; else goto _L7
_L7:
        view = new Intent(getApplicationContext(), com/bestbuy/android/activities/home/HomeActivity);
        view.addFlags(0x4000000);
        startActivity(view);
        finish();
        overridePendingTransition(0x7f040005, 0x7f040008);
        return;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030012);
        lu.a(lu.aP);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            k = bundle.getBoolean("blueassist_update");
            l = bundle.getString(getResources().getString(0x7f080141));
            m = bundle.getString(getResources().getString(0x7f080143));
            n = bundle.getString(getResources().getString(0x7f080144));
            p = bundle.getString(getResources().getString(0x7f080140));
            q = bundle.getString(getResources().getString(0x7f0800b9));
            g = (BBYStore)bundle.getSerializable(getResources().getString(0x7f080050));
            c = g.getStoreId();
            r = bundle.getString(getResources().getString(0x7f080053));
            o = bundle.getString(getResources().getString(0x7f080054));
        }
        b();
        if (c != null && !c.isEmpty())
        {
            f = new ArrayList();
            e = ne.a();
            if (q != null && !q.isEmpty())
            {
                k = true;
                a(c, r);
            } else
            {
                k = false;
                a(c, ne.a());
            }
        }
        s = (ImageView)findViewById(0x7f0c0067);
        t = (ImageView)findViewById(0x7f0c0068);
        t.setOnClickListener(this);
        s.setOnClickListener(this);
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        adapterview = getIntent().getExtras();
        adapterview.putString(getResources().getString(0x7f080054), (String)f.get(i1));
        if (q != null && !q.isEmpty())
        {
            adapterview.putString(getResources().getString(0x7f080053), r);
        } else
        {
            adapterview.putString(getResources().getString(0x7f080053), e);
        }
        adapterview.putSerializable(getResources().getString(0x7f080050), g);
        if (k)
        {
            adapterview.putString(getResources().getString(0x7f080141), l);
            adapterview.putString(getResources().getString(0x7f080143), m);
            adapterview.putString(getResources().getString(0x7f080144), n);
            adapterview.putString(getResources().getString(0x7f080140), p);
            adapterview.putString(getResources().getString(0x7f0800b9), q);
        }
        view = new Intent(this, com/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity);
        view.putExtras(adapterview);
        startActivity(view);
    }
}
