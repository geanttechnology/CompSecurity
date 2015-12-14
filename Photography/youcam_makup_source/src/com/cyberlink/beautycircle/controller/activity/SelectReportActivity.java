// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.controller.fragment.y;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            v

public class SelectReportActivity extends BaseActivity
{

    private AbsListView e;
    private ArrayAdapter f;
    private String g;
    private String h;
    private long i;

    public SelectReportActivity()
    {
        g = null;
        h = null;
    }

    static ArrayAdapter a(SelectReportActivity selectreportactivity)
    {
        return selectreportactivity.f;
    }

    static String a(SelectReportActivity selectreportactivity, String s)
    {
        selectreportactivity.g = s;
        return s;
    }

    private void o()
    {
        f = new v(this, k.bc_view_item_report_list, j.report_reason_text, j.report_reason_selector);
        e = (AbsListView)findViewById(j.bc_report_list_view);
        e.setChoiceMode(1);
        e.setAdapter(f);
        e.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SelectReportActivity a;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                SelectReportActivity.a(a, (String)SelectReportActivity.a(a).getItem(l));
                view.setSelected(true);
                a.b().d(i.bc_report_button_background);
                a.b().f(true);
                a.b().g(true);
            }

            
            {
                a = SelectReportActivity.this;
                super();
            }
        });
        f.add(getResources().getString(m.bc_me_report_SPAMMING));
        f.add(getResources().getString(m.bc_me_report_GRAPHIC));
        f.add(getResources().getString(m.bc_me_report_ABUSIVE));
        f.add(getResources().getString(m.bc_me_report_PRETENDING));
    }

    private String p()
    {
        if (!getResources().getString(m.bc_me_report_SPAMMING).equals(g))
        {
            if (getResources().getString(m.bc_me_report_GRAPHIC).equals(g))
            {
                return "GRAPHIC";
            }
            if (getResources().getString(m.bc_me_report_ABUSIVE).equals(g))
            {
                return "ABUSIVE";
            }
            if (getResources().getString(m.bc_me_report_PRETENDING).equals(g))
            {
                return "PRETENDING";
            }
        }
        return "SPAMMING";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_select_report);
        bundle = getIntent();
        if (bundle != null)
        {
            h = bundle.getStringExtra("UserDisplayName");
            i = bundle.getLongExtra("UserId", 0L);
            if (h != null)
            {
                bundle = String.format(Locale.getDefault(), getResources().getString(m.bc_me_report_someone), new Object[] {
                    h
                });
                ((TextView)findViewById(j.report_name)).setText(bundle);
            }
        }
        b(m.bc_me_report_user);
        b().a(0xc1000000, x.a, 0, y.h);
        b().f(false);
        b().g(false);
        o();
    }

    public void onRightBtnClick(View view)
    {
        NetworkUser.a(AccountManager.b(), Long.valueOf(i), p()).a(new com.perfectcorp.utility.m() {

            final SelectReportActivity a;

            public void a(int l)
            {
                Globals.b((new StringBuilder()).append("Fetching UserInfo error: ").append(l).toString());
            }

            public void a(Void void1)
            {
                Globals.b("Success");
            }

            public void b(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = SelectReportActivity.this;
                super();
            }
        });
        setResult(-1, null);
        super.e();
    }
}
