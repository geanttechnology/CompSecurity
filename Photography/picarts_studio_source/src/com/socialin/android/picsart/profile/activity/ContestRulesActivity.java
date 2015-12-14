// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.c;
import com.socialin.android.util.Utils;

public class ContestRulesActivity extends BaseActivity
{

    private c a;
    protected String b;
    protected String c;
    String d;
    private a e;

    public ContestRulesActivity()
    {
        c = "";
        d = "http://picsart.com/rules";
        a = new c() {

            private ContestRulesActivity a;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                ((WebView)view.findViewById(0x7f10038d)).loadUrl(com.socialin.android.picsart.profile.activity.ContestRulesActivity.a(a));
                a.refreshDialog(view);
            }

            
            {
                a = ContestRulesActivity.this;
                super();
            }
        };
    }

    static String a(ContestRulesActivity contestrulesactivity)
    {
        return contestrulesactivity.d;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (e != null)
        {
            refreshDialog(e.getView());
        }
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            e = (a)getFragmentManager().findFragmentByTag("contestRulesDialogTag");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ExceptionReportService.report(bundle);
        }
        if (e != null && e.isAdded())
        {
            e.a(a);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuItemCompat.setShowAsAction(menu.add(0, 1, 0, getString(0x7f08033f)), 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        if (menuitem.getItemId() == 1)
        {
            if (e == null)
            {
                menuitem = (new b()).a(1, 0x7f0c0190);
                menuitem.f = 0x7f0300a5;
                menuitem.e = 0x7f0205bd;
                menuitem.a = getResources().getString(0x7f0800fb);
                menuitem.h = false;
                menuitem = menuitem.a(getResources().getString(0x7f080311));
                menuitem.g = true;
                e = menuitem.a();
                e.a(a);
            }
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ContestReadRulesEvent(b));
            e.show(getFragmentManager(), "contestRulesDialogTag");
        }
        return true;
    }

    public void refreshDialog(View view)
    {
        int i = 320;
        if (view != null)
        {
            view = (WebView)view.findViewById(0x7f10038d);
            if (Math.max(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels) <= 320)
            {
                i = 200;
            }
            view = view.getLayoutParams();
            if (getResources().getConfiguration().orientation == 2)
            {
                i = (int)Utils.a(150F, this);
            } else
            {
                i = (int)Utils.a(i, this);
            }
            view.height = i;
        }
    }
}
