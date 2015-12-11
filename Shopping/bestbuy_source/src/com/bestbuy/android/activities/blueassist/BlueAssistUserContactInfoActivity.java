// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bv;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.blueshirt.StoreAppointment;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fq;
import fr;
import hu;
import hy;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lu;
import nb;
import ne;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistAptConfirmationActivity

public class BlueAssistUserContactInfoActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener
{

    private String A;
    private String B;
    private InputFilter C;
    private InputFilter D;
    private EditText a;
    private EditText b;
    private EditText c;
    private EditText d;
    private BBYButton e;
    private RelativeLayout f;
    private BBYTextView g;
    private nb h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private BBYStore u;
    private String v;
    private ImageView w;
    private ImageView x;
    private Pattern y;
    private Matcher z;

    public BlueAssistUserContactInfoActivity()
    {
        i = false;
        j = false;
        k = false;
        l = false;
        A = "*\"':;!?)(+-&%$#@\\\251\256\u2122\u2105[]}{=\260^\245\u20AC\242\243\u2206\266\327\367\u03C0\u221A\u2022|`~.,<>/0123456789";
        B = "*\"':;!?)(+-&%$#@\\\251\256\u2122\u2105[]}{=\260^\245\u20AC\242\243\u2206\266\327\367\u03C0\u221A\u2022|`~.,<>/N";
        C = new InputFilter() {

            final BlueAssistUserContactInfoActivity a;

            public CharSequence filter(CharSequence charsequence, int i1, int j1, Spanned spanned, int k1, int l1)
            {
                if (charsequence != null && BlueAssistUserContactInfoActivity.r(a).contains((new StringBuilder()).append("").append(charsequence).toString()))
                {
                    return "";
                } else
                {
                    return null;
                }
            }

            
            {
                a = BlueAssistUserContactInfoActivity.this;
                super();
            }
        };
        D = new InputFilter() {

            final BlueAssistUserContactInfoActivity a;

            public CharSequence filter(CharSequence charsequence, int i1, int j1, Spanned spanned, int k1, int l1)
            {
                if (charsequence != null && BlueAssistUserContactInfoActivity.s(a).contains((new StringBuilder()).append("").append(charsequence).toString()))
                {
                    return "";
                } else
                {
                    return null;
                }
            }

            
            {
                a = BlueAssistUserContactInfoActivity.this;
                super();
            }
        };
    }

    public static BBYButton a(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.e;
    }

    static String a(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, String s1)
    {
        blueassistusercontactinfoactivity.p = s1;
        return s1;
    }

    static boolean a(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, boolean flag)
    {
        blueassistusercontactinfoactivity.t = flag;
        return flag;
    }

    static EditText b(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.a;
    }

    static String b(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, String s1)
    {
        blueassistusercontactinfoactivity.s = s1;
        return s1;
    }

    public static boolean b(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, boolean flag)
    {
        blueassistusercontactinfoactivity.i = flag;
        return flag;
    }

    static EditText c(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.d;
    }

    static String c(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, String s1)
    {
        blueassistusercontactinfoactivity.q = s1;
        return s1;
    }

    public static boolean c(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, boolean flag)
    {
        blueassistusercontactinfoactivity.j = flag;
        return flag;
    }

    static EditText d(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.c;
    }

    static String d(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, String s1)
    {
        blueassistusercontactinfoactivity.r = s1;
        return s1;
    }

    public static boolean d(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, boolean flag)
    {
        blueassistusercontactinfoactivity.k = flag;
        return flag;
    }

    static EditText e(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.b;
    }

    private String e(String s1)
    {
        String s2 = "";
        if (s1.contains("am") || s1.contains("pm"))
        {
            s2 = s1.replace("am", " AM").replace("pm", " PM");
        }
        return s2;
    }

    public static boolean e(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, boolean flag)
    {
        blueassistusercontactinfoactivity.l = flag;
        return flag;
    }

    static String f(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.v;
    }

    static String g(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.m;
    }

    static String h(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.n;
    }

    static String i(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.o;
    }

    static String j(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.q;
    }

    static String k(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.p;
    }

    static String l(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.s;
    }

    static String m(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.r;
    }

    public static boolean n(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.i;
    }

    public static boolean o(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.j;
    }

    public static boolean p(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.l;
    }

    public static boolean q(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.k;
    }

    static String r(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.A;
    }

    static String s(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity)
    {
        return blueassistusercontactinfoactivity.B;
    }

    public void a(String s1)
    {
        b(s1);
        Bundle bundle = getIntent().getExtras();
        v = s1;
        s1 = new Intent(this, com/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity);
        bundle.putBoolean("blueassist_update", t);
        bundle.putString(getResources().getString(0x7f0800b9), v);
        bundle.putString(getResources().getString(0x7f080141), p);
        bundle.putString(getResources().getString(0x7f080143), s);
        bundle.putString(getResources().getString(0x7f080144), r);
        bundle.putString(getResources().getString(0x7f080140), q);
        s1.putExtras(bundle);
        startActivity(s1);
    }

    public void b(String s1)
    {
        GregorianCalendar gregoriancalendar;
        StoreAppointment storeappointment;
label0:
        {
            storeappointment = new StoreAppointment();
            storeappointment.setAppointmentId(s1);
            gregoriancalendar = null;
            String s2 = (new StringBuilder()).append(n).append(" ").append(e(o)).toString();
            if (!s2.contains("am"))
            {
                s1 = s2;
                if (!s2.contains("pm"))
                {
                    break label0;
                }
            }
            s1 = s2.replace("am", "").replace("pm", "");
        }
        try
        {
            s1 = ne.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1 = gregoriancalendar;
        }
        gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTimeInMillis(s1.getTime());
        storeappointment.setAppointmentTime(gregoriancalendar.getTimeInMillis());
        storeappointment.setStoreAddress(u.getStoreDetails().getAddress());
        storeappointment.setStoreCity(u.getStoreDetails().getCity());
        storeappointment.setStoreId(u.getStoreId());
        storeappointment.setStoreName(u.getStoreDetails().getName());
        fq.a(storeappointment);
    }

    public boolean c(String s1)
    {
        y = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        z = y.matcher(s1);
        return z.matches();
    }

    public boolean d(String s1)
    {
        return s1.matches("\\d{10}");
    }

    public void onClick(View view)
    {
        if (view == x)
        {
            finish();
        } else
        if (view == w)
        {
            view = new Intent(getApplicationContext(), com/bestbuy/android/activities/home/HomeActivity);
            view.addFlags(0x4000000);
            startActivity(view);
            finish();
            overridePendingTransition(0x7f040005, 0x7f040008);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        lu.a(lu.aQ);
        h = nb.a();
        h.i(true);
        getActionBar().hide();
        a = (EditText)findViewById(0x7f0c002a);
        d = (EditText)findViewById(0x7f0c002b);
        b = (EditText)findViewById(0x7f0c002c);
        c = (EditText)findViewById(0x7f0c002d);
        bundle = (InputMethodManager)getSystemService("input_method");
        bundle.showSoftInput(a, 1);
        bundle.showSoftInput(d, 1);
        a.addTextChangedListener(new bv(this, a));
        d.addTextChangedListener(new bv(this, d));
        b.addTextChangedListener(new bv(this, b));
        c.addTextChangedListener(new bv(this, c));
        a.setFilters(new InputFilter[] {
            C, new android.text.InputFilter.LengthFilter(50)
        });
        d.setFilters(new InputFilter[] {
            C, new android.text.InputFilter.LengthFilter(50)
        });
        b.setFilters(new InputFilter[] {
            D, new android.text.InputFilter.LengthFilter(10)
        });
        e = (BBYButton)findViewById(0x7f0c002e);
        e.setEnabled(false);
        w = (ImageView)findViewById(0x7f0c0067);
        x = (ImageView)findViewById(0x7f0c0068);
        x.setOnClickListener(this);
        w.setOnClickListener(this);
        if (fr.e() != null)
        {
            a.setText(fr.e());
        }
        if (fr.f() != null)
        {
            d.setText(fr.f());
        }
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            o = bundle.getString(getResources().getString(0x7f080054));
            n = bundle.getString(getResources().getString(0x7f080053));
            u = (BBYStore)bundle.getSerializable(getResources().getString(0x7f080050));
            nb.a().b();
            t = bundle.getBoolean("blueassist_update");
            v = bundle.getString(getResources().getString(0x7f0800b9));
            m = u.getStoreId();
            p = bundle.getString(getResources().getString(0x7f080141));
            s = bundle.getString(getResources().getString(0x7f080143));
            r = bundle.getString(getResources().getString(0x7f080144));
            q = bundle.getString(getResources().getString(0x7f080140));
        }
        if (p != null)
        {
            a.setText(p);
        }
        if (s != null)
        {
            d.setText(s);
        }
        if (r != null)
        {
            b.setText(r);
        }
        if (q != null)
        {
            c.setText(q);
        }
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final BlueAssistUserContactInfoActivity a;

            public void onClick(View view)
            {
                BlueAssistUserContactInfoActivity.a(a).setEnabled(false);
                BlueAssistUserContactInfoActivity.a(a, BlueAssistUserContactInfoActivity.b(a).getText().toString());
                BlueAssistUserContactInfoActivity.b(a, BlueAssistUserContactInfoActivity.c(a).getText().toString());
                BlueAssistUserContactInfoActivity.c(a, BlueAssistUserContactInfoActivity.d(a).getText().toString());
                BlueAssistUserContactInfoActivity.d(a, BlueAssistUserContactInfoActivity.e(a).getText().toString());
                if (BlueAssistUserContactInfoActivity.f(a) != null && !BlueAssistUserContactInfoActivity.f(a).isEmpty())
                {
                    BlueAssistUserContactInfoActivity.a(a, true);
                    (new hy(a, BlueAssistUserContactInfoActivity.g(a), BlueAssistUserContactInfoActivity.h(a), BlueAssistUserContactInfoActivity.i(a), BlueAssistUserContactInfoActivity.j(a), BlueAssistUserContactInfoActivity.f(a))).execute(new Void[0]);
                    return;
                } else
                {
                    BlueAssistUserContactInfoActivity.a(a, false);
                    (new hu(a, BlueAssistUserContactInfoActivity.g(a), BlueAssistUserContactInfoActivity.h(a), BlueAssistUserContactInfoActivity.i(a), BlueAssistUserContactInfoActivity.k(a), BlueAssistUserContactInfoActivity.l(a), BlueAssistUserContactInfoActivity.j(a), BlueAssistUserContactInfoActivity.m(a))).execute(new Void[0]);
                    return;
                }
            }

            
            {
                a = BlueAssistUserContactInfoActivity.this;
                super();
            }
        });
        f = (RelativeLayout)findViewById(0x7f0c0020);
        g = (BBYTextView)f.findViewById(0x7f0c015e);
        bundle = (BBYTextView)f.findViewById(0x7f0c015f);
        g.setText(Html.fromHtml(getString(0x7f08021f)));
        bundle.setText(Html.fromHtml(getString(0x7f08018c)));
    }
}
