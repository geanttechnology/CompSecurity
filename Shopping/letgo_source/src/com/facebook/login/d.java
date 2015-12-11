// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

// Referenced classes of package com.facebook.login:
//            LoginClient

public class d extends Fragment
    implements TraceFieldInterface
{

    private String a;
    private LoginClient b;
    private LoginClient.Request c;

    public d()
    {
    }

    static Bundle a(LoginClient.Request request)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        return bundle;
    }

    private void a(LoginClient.Result result)
    {
        c = null;
        Bundle bundle;
        int i;
        if (result.a == LoginClient.Result.a.b)
        {
            i = 0;
        } else
        {
            i = -1;
        }
        bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        result = new Intent();
        result.putExtras(bundle);
        if (n())
        {
            j().setResult(i, result);
            j().finish();
        }
    }

    static void a(d d1, LoginClient.Result result)
    {
        d1.a(result);
    }

    private void b(Activity activity)
    {
        activity = activity.getCallingActivity();
        if (activity == null)
        {
            return;
        } else
        {
            a = activity.getPackageName();
            return;
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.facebook.x.c.com_facebook_login_fragment, viewgroup, false);
        b.a(new LoginClient.a(layoutinflater) {

            final View a;
            final d b;

            public void a()
            {
                a.findViewById(com.facebook.x.b.com_facebook_login_activity_progress_bar).setVisibility(0);
            }

            public void b()
            {
                a.findViewById(com.facebook.x.b.com_facebook_login_activity_progress_bar).setVisibility(8);
            }

            
            {
                b = d.this;
                a = view;
                super();
            }
        });
        return layoutinflater;
    }

    public void a(int i, int j, Intent intent)
    {
        super.a(i, j, intent);
        b.a(i, j, intent);
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        if (bundle != null)
        {
            b = (LoginClient)bundle.getParcelable("loginClient");
            b.a(this);
        } else
        {
            b = new LoginClient(this);
        }
        b.a(new LoginClient.b() {

            final d a;

            public void a(LoginClient.Result result)
            {
                d.a(a, result);
            }

            
            {
                a = d.this;
                super();
            }
        });
        bundle = j();
        if (bundle != null)
        {
            b(bundle);
            if (bundle.getIntent() != null)
            {
                c = (LoginClient.Request)bundle.getIntent().getParcelableExtra("request");
                return;
            }
        }
    }

    public void e(Bundle bundle)
    {
        super.e(bundle);
        bundle.putParcelable("loginClient", b);
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void u()
    {
        super.u();
        if (a == null)
        {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            j().finish();
            return;
        } else
        {
            b.a(c);
            return;
        }
    }

    public void v()
    {
        super.v();
        j().findViewById(com.facebook.x.b.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public void w()
    {
        b.f();
        super.w();
    }
}
