// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.facebook.login:
//            LoginClient

public class LoginFragment extends Fragment
    implements TraceFieldInterface
{

    private String a;
    private LoginClient b;
    private LoginClient.Request c;

    public LoginFragment()
    {
    }

    private void a(Activity activity)
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
        if (isAdded())
        {
            getActivity().setResult(i, result);
            getActivity().finish();
        }
    }

    static void a(LoginFragment loginfragment, LoginClient.Result result)
    {
        loginfragment.a(result);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        b.a(i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("LoginFragment");
        TraceMachine.enterMethod(_nr_trace, "LoginFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        NoSuchFieldError nosuchfielderror;
        if (bundle != null)
        {
            b = (LoginClient)bundle.getParcelable("loginClient");
            b.a(this);
        } else
        {
            b = new LoginClient(this);
        }
        b.a(new LoginClient.b() {

            final LoginFragment a;

            public void a(LoginClient.Result result)
            {
                LoginFragment.a(a, result);
            }

            
            {
                a = LoginFragment.this;
                super();
            }
        });
        bundle = getActivity();
        if (bundle == null)
        {
            TraceMachine.exitMethod();
            return;
        }
        break MISSING_BLOCK_LABEL_99;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "LoginFragment#onCreate", null);
          goto _L1
        a(bundle);
        if (bundle.getIntent() != null)
        {
            c = (LoginClient.Request)bundle.getIntent().getParcelableExtra("request");
        }
        TraceMachine.exitMethod();
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "LoginFragment#onCreateView", null);
_L1:
        layoutinflater = layoutinflater.inflate(com.facebook.v.c.com_facebook_login_fragment, viewgroup, false);
        b.a(new LoginClient.a(layoutinflater) {

            final View a;
            final LoginFragment b;

            public void a()
            {
                a.findViewById(com.facebook.v.b.com_facebook_login_activity_progress_bar).setVisibility(0);
            }

            public void b()
            {
                a.findViewById(com.facebook.v.b.com_facebook_login_activity_progress_bar).setVisibility(8);
            }

            
            {
                b = LoginFragment.this;
                a = view;
                super();
            }
        });
        TraceMachine.exitMethod();
        return layoutinflater;
        bundle;
        TraceMachine.enterMethod(null, "LoginFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        b.f();
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        getActivity().findViewById(com.facebook.v.b.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public void onResume()
    {
        super.onResume();
        if (a == null)
        {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        } else
        {
            b.a(c);
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
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
}
