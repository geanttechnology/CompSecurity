// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.p;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.b.a.a.j;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.login.widget.LoginButton;
import com.offerup.android.activities.a;
import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.network.b;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;
import com.offerup.android.utils.v;
import java.util.Set;

// Referenced classes of package com.offerup.android.g.b:
//            t, u, m, x, 
//            l, y, n, o, 
//            p, q, r, s, 
//            w

public final class k extends p
{

    private j a;
    private w b;
    private Button c;
    private Button d;
    private Dialog e;
    private x f;
    private a g;
    private LoginButton h;
    private CallbackManager i;

    public k()
    {
    }

    static LoginButton a(k k1)
    {
        return k1.h;
    }

    public static k a()
    {
        return new k();
    }

    static void a(k k1, AccessToken accesstoken)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (accesstoken == null)
                    {
                        break label0;
                    }
                    k1.a.f(accesstoken.getToken());
                    k1.b();
                    if (!ba.a())
                    {
                        if (AccessToken.getCurrentAccessToken() == null)
                        {
                            break label1;
                        }
                        if (AccessToken.getCurrentAccessToken().getPermissions().contains("email") && !c())
                        {
                            break label2;
                        }
                        k1.e();
                    }
                    return;
                }
                k1.a("", k1.getString(0x7f09014b));
                com.offerup.android.network.b.a(ba.b(), new t(k1));
                return;
            }
            k1.d();
            n.a(k1.getActivity(), k1.getString(0x7f090110), k1.getString(0x7f09010f));
            return;
        }
        k1.d();
        n.a(k1.getActivity(), "Facebook Log in Error", "Your Facebook session is out of date, please re-log in to the Facebook app before continuing.");
    }

    static void a(k k1, UserResponse userresponse)
    {
        com.offerup.android.network.b.a();
        userresponse = userresponse.getUser();
        ba.a(k1.getContext(), userresponse);
        userresponse = new Bundle();
        userresponse.putString("fb_registration_method", "Facebook");
        v.a(k1.getContext(), "fb_mobile_complete_registration", userresponse);
        k1.a.p(true);
    }

    private void a(String s1, String s2)
    {
        n.a(e);
        try
        {
            e = ProgressDialog.show(getContext(), s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
    }

    static CallbackManager b(k k1)
    {
        return k1.i;
    }

    private void b()
    {
        if (AccessToken.getCurrentAccessToken() == null || c())
        {
            h.setVisibility(0);
            return;
        } else
        {
            h.setVisibility(4);
            return;
        }
    }

    static x c(k k1)
    {
        return k1.f;
    }

    private static boolean c()
    {
        Set set = AccessToken.getCurrentAccessToken().getDeclinedPermissions();
        if (set != null)
        {
            return set.contains("email");
        } else
        {
            return false;
        }
    }

    static a d(k k1)
    {
        return k1.g;
    }

    private void d()
    {
        ba.a(getContext());
        h.setVisibility(0);
        a.p(false);
    }

    static Dialog e(k k1)
    {
        return k1.e;
    }

    private void e()
    {
        android.app.AlertDialog.Builder builder = n.c(getActivity());
        builder.setTitle(getString(0x7f090110));
        builder.setMessage(getString(0x7f09010e));
        builder.setPositiveButton(getString(0x7f090102), new u(this));
        builder.setNegativeButton(getString(0x7f0900da), new m(this));
        n.a(builder);
    }

    static void f(k k1)
    {
        k1.d();
    }

    static void g(k k1)
    {
        k1.b();
    }

    static w h(k k1)
    {
        return k1.b;
    }

    static boolean i(k k1)
    {
        return c();
    }

    static void j(k k1)
    {
        k1.e();
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i.onActivityResult(i1, j1, intent);
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        f = (x)activity;
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        bundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        bundle.setCanceledOnTouchOutside(false);
        bundle.setOnKeyListener(new l(this));
        setStyle(2, 0x7f0c00f4);
        return bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f040092, viewgroup, false);
        a = com.b.a.a.j.a();
        g = new a(getActivity());
        b = new y(this, (byte)0);
        i = com.facebook.CallbackManager.Factory.create();
        h = (LoginButton)layoutinflater.findViewById(0x7f10022c);
        h.setOnClickListener(new com.offerup.android.g.b.n(this));
        h.setFragment(this);
        d = (Button)layoutinflater.findViewById(0x7f10022f);
        c = (Button)layoutinflater.findViewById(0x7f10022e);
        a.s();
        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        d.setOnClickListener(new o(this));
        c.setOnClickListener(new com.offerup.android.g.b.p(this));
        viewgroup = (TextView)layoutinflater.findViewById(0x7f100230);
        bundle = viewgroup.getText().toString();
        Object obj = new SpannableString(bundle);
        ((SpannableString) (obj)).setSpan(new q(this), 0, bundle.length(), 0);
        viewgroup.setText(((CharSequence) (obj)));
        viewgroup.setMovementMethod(new LinkMovementMethod());
        viewgroup = (TextView)layoutinflater.findViewById(0x7f100228);
        bundle = viewgroup.getText().toString();
        obj = getString(0x7f09014c);
        int i1 = bundle.indexOf(((String) (obj)));
        int j1 = ((String) (obj)).length();
        obj = getString(0x7f09014a);
        int k1 = bundle.indexOf(((String) (obj)));
        int l1 = ((String) (obj)).length();
        bundle = new SpannableString(bundle);
        bundle.setSpan(new r(this), i1, j1 + i1, 0);
        bundle.setSpan(new s(this), k1, l1 + k1, 0);
        viewgroup.setText(bundle);
        viewgroup.setMovementMethod(new LinkMovementMethod());
        com.offerup.android.tracker.a.a("authenticate");
        return layoutinflater;
    }

    public final void onDetach()
    {
        f = null;
        super.onDetach();
    }
}
