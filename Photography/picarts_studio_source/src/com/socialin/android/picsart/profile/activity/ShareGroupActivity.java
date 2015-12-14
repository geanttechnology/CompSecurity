// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.adapter.al;
import com.socialin.android.views.PredicateLayout;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

public class ShareGroupActivity extends BaseActivity
{

    BaseSocialinApiRequestController a;
    GetUsersParams b;
    String c;
    private PredicateLayout d;
    private SearchView e;
    private Handler f;

    public ShareGroupActivity()
    {
        a = RequestControllerFactory.createSearchUsersController();
        b = new GetUsersParams();
        f = new Handler();
        c = "";
    }

    private void a()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (inputmethodmanager.isAcceptingText() && getWindow().getCurrentFocus() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            e.clearFocus();
        }
    }

    static void a(ShareGroupActivity sharegroupactivity)
    {
        sharegroupactivity.a();
    }

    static void a(ShareGroupActivity sharegroupactivity, String s)
    {
        s = sharegroupactivity. new Runnable(s) {

            private String a;
            private ShareGroupActivity b;

            public final void run()
            {
                ShareGroupActivity.b(b, a);
                if (!TextUtils.isEmpty(ShareGroupActivity.c(b)))
                {
                    ShareGroupActivity sharegroupactivity1 = b;
                    AnalyticUtils.getInstance(sharegroupactivity1).track(new com.socialin.android.apiv3.events.EventsFactory.SearchEvent(null, sharegroupactivity1.getClass().getSimpleName(), sharegroupactivity1.c));
                    sharegroupactivity1.b.query = sharegroupactivity1.c;
                    sharegroupactivity1.a.doRequest("SearchGroup", sharegroupactivity1.b);
                }
            }

            
            {
                b = ShareGroupActivity.this;
                a = s;
                super();
            }
        };
        sharegroupactivity.f.removeCallbacksAndMessages(null);
        sharegroupactivity.f.postDelayed(s, 200L);
    }

    static SearchView b(ShareGroupActivity sharegroupactivity)
    {
        return sharegroupactivity.e;
    }

    static String b(ShareGroupActivity sharegroupactivity, String s)
    {
        sharegroupactivity.c = s;
        return s;
    }

    static String c(ShareGroupActivity sharegroupactivity)
    {
        return sharegroupactivity.c;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 2)
        {
            a();
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301cd);
        d = (PredicateLayout)findViewById(0x7f100852);
        bundle = getLayoutInflater().inflate(0x7f0301cc, null, false);
        ((TextView)bundle.findViewById(0x7f100850)).setText("some name");
        d.addView(bundle);
        d.invalidate();
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setTitle(getString(0x7f08054d));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(0x7f0f008d)));
        }
        new al(this);
        a.setRequestCompleteListener(new d() {

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final volatile void onSuccess(Object obj, Request request)
            {
            }

        });
        e = (SearchView)findViewById(0x7f100851);
        e.setIconified(false);
        e.setQueryHint(getString(0x7f080343));
        e.requestFocus();
        bundle = e.findViewById(0x7f100111);
        bundle.setVisibility(8);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            private ShareGroupActivity a;

            public final void onClick(View view)
            {
                ShareGroupActivity.a(a);
                ShareGroupActivity.b(a).clearFocus();
            }

            
            {
                a = ShareGroupActivity.this;
                super();
            }
        });
        e.setOnQueryTextFocusChangeListener(new android.view.View.OnFocusChangeListener(bundle) {

            private View a;
            private ShareGroupActivity b;

            public final void onFocusChange(View view, boolean flag)
            {
                if (!flag && TextUtils.isEmpty(ShareGroupActivity.c(b)))
                {
                    a.setVisibility(8);
                } else
                if (!TextUtils.isEmpty(ShareGroupActivity.c(b)))
                {
                    a.setVisibility(0);
                    return;
                }
            }

            
            {
                b = ShareGroupActivity.this;
                a = view;
                super();
            }
        });
        e.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener(bundle) {

            private View a;
            private ShareGroupActivity b;

            public final boolean onQueryTextChange(String s)
            {
                View view = a;
                byte byte0;
                if ("".equals(s) || s.trim().length() == 0)
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                }
                view.setVisibility(byte0);
                ShareGroupActivity.a(b, s);
                return false;
            }

            public final boolean onQueryTextSubmit(String s)
            {
                ShareGroupActivity.b(b).clearFocus();
                return false;
            }

            
            {
                b = ShareGroupActivity.this;
                a = view;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110011, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        return true;
    }
}
