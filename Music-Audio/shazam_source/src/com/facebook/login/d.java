// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.AccessToken;
import com.facebook.h;
import java.util.ArrayList;

// Referenced classes of package com.facebook.login:
//            LoginClient, LoginMethodHandler, c, GetTokenLoginMethodHandler, 
//            KatanaProxyLoginMethodHandler, WebViewLoginMethodHandler

public final class d extends Fragment
{

    private String a;
    private LoginClient b;
    private LoginClient.Request c;

    public d()
    {
    }

    static void a(d d1, LoginClient.Result result)
    {
        d1.c = null;
        Bundle bundle;
        int j;
        if (result.a == LoginClient.Result.a.b)
        {
            j = 0;
        } else
        {
            j = -1;
        }
        bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        result = new Intent();
        result.putExtras(bundle);
        if (d1.isAdded())
        {
            d1.getActivity().setResult(j, result);
            d1.getActivity().finish();
        }
    }

    public final void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        LoginClient loginclient = b;
        if (loginclient.g != null)
        {
            loginclient.b().a(k, intent);
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            b = (LoginClient)bundle.getParcelable("loginClient");
            bundle = b;
            if (((LoginClient) (bundle)).c != null)
            {
                throw new h("Can't set fragment once it is already set.");
            }
            bundle.c = this;
        } else
        {
            b = new LoginClient(this);
        }
        b.d = new LoginClient.b() {

            final d a;

            public final void a(LoginClient.Result result)
            {
                d.a(a, result);
            }

            
            {
                a = d.this;
                super();
            }
        };
        bundle = getActivity();
        if (bundle != null)
        {
            ComponentName componentname = bundle.getCallingActivity();
            if (componentname != null)
            {
                a = componentname.getPackageName();
            }
            if (bundle.getIntent() != null)
            {
                c = (LoginClient.Request)bundle.getIntent().getParcelableExtra("request");
                return;
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.facebook.x.c.com_facebook_login_fragment, viewgroup, false);
        b.e = new LoginClient.a(layoutinflater) {

            final View a;
            final d b;

            public final void a()
            {
                a.findViewById(com.facebook.x.b.com_facebook_login_activity_progress_bar).setVisibility(0);
            }

            public final void b()
            {
                a.findViewById(com.facebook.x.b.com_facebook_login_activity_progress_bar).setVisibility(8);
            }

            
            {
                b = d.this;
                a = view;
                super();
            }
        };
        return layoutinflater;
    }

    public final void onDestroy()
    {
        LoginClient loginclient = b;
        if (loginclient.b >= 0)
        {
            loginclient.b().b();
        }
        super.onDestroy();
    }

    public final void onPause()
    {
        super.onPause();
        getActivity().findViewById(com.facebook.x.b.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public final void onResume()
    {
        super.onResume();
        if (a == null)
        {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
        } else
        {
            LoginClient loginclient = b;
            Object obj = c;
            boolean flag;
            if (loginclient.g != null && loginclient.b >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && obj != null)
            {
                if (loginclient.g != null)
                {
                    throw new h("Attempted to authorize while a request is pending.");
                }
                if (AccessToken.a() == null || loginclient.c())
                {
                    loginclient.g = ((LoginClient.Request) (obj));
                    ArrayList arraylist = new ArrayList();
                    obj = ((LoginClient.Request) (obj)).a;
                    if (((c) (obj)).d)
                    {
                        arraylist.add(new GetTokenLoginMethodHandler(loginclient));
                        arraylist.add(new KatanaProxyLoginMethodHandler(loginclient));
                    }
                    if (((c) (obj)).e)
                    {
                        arraylist.add(new WebViewLoginMethodHandler(loginclient));
                    }
                    LoginMethodHandler aloginmethodhandler[] = new LoginMethodHandler[arraylist.size()];
                    arraylist.toArray(aloginmethodhandler);
                    loginclient.a = aloginmethodhandler;
                    loginclient.d();
                    return;
                }
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", b);
    }
}
