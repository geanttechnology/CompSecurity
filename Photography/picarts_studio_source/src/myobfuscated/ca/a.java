// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ca;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.oauth2.OAuth2BaseActivity;

// Referenced classes of package myobfuscated.ca:
//            c, b

public final class a extends Fragment
{

    private static final String b = com/socialin/android/oauth2/OAuth2BaseActivity.getSimpleName();
    public b a;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private boolean j;
    private Context k;
    private View l;
    private String m;
    private FragmentActionsListener n;
    private String o;
    private ProgressBar p;

    public a()
    {
        f = "";
        g = "authorization_code";
        h = "";
        j = false;
    }

    static String a()
    {
        return b;
    }

    static String a(a a1)
    {
        return a1.o;
    }

    private void a(int i1, Intent intent)
    {
        n.onFragmentResult(i1, intent);
    }

    static void a(a a1, Intent intent)
    {
        a1.a(326, intent);
    }

    static void a(a a1, String s)
    {
        Intent intent = new Intent();
        intent.putExtra("oauth2FailedErrorDesc", s);
        a1.a(327, intent);
    }

    static Context b(a a1)
    {
        return a1.k;
    }

    static String b(a a1, String s)
    {
        a1.m = s;
        return s;
    }

    static String c(a a1)
    {
        return a1.d;
    }

    static String d(a a1)
    {
        return a1.e;
    }

    static String e(a a1)
    {
        return a1.f;
    }

    static String f(a a1)
    {
        return a1.g;
    }

    static String g(a a1)
    {
        return a1.m;
    }

    static boolean h(a a1)
    {
        return a1.j;
    }

    static ProgressBar i(a a1)
    {
        return a1.p;
    }

    static b j(a a1)
    {
        return a1.a;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        ActionBar actionbar;
        super.onActivityCreated(bundle);
        o = "https://picsart-oauth2-success";
        n = (FragmentActionsListener)getActivity();
        k = getActivity().getApplicationContext();
        bundle = getActivity().getIntent().getExtras();
        c = bundle.getString("oauth2AuthorizationEndpoint");
        d = bundle.getString("oauth2AccessTokenEndpoint");
        e = bundle.getString("oauth2ClientId");
        f = bundle.getString("oauth2ClientSecret", "");
        i = bundle.getInt("oauth2SocialKey");
        Object obj = getActivity().getIntent();
        actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (obj != null && ((Intent) (obj)).hasExtra("socialType"))
        {
            obj = ((Intent) (obj)).getStringExtra("socialType");
            actionbar.setTitle(((CharSequence) (obj)));
            if (((String) (obj)).equals("Instagram"))
            {
                actionbar.setIcon(getResources().getDrawable(0x7f020395));
            }
        }
        if (i != 2) goto _L2; else goto _L1
_L1:
        actionbar.setIcon(getResources().getDrawable(0x7f020345));
        actionbar.setTitle(getResources().getString(0x7f0802bc));
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(getResources().getDrawable(0x7f020781));
_L4:
        h = bundle.getString("oauth2scope", "");
        g = bundle.getString("oauth2GrantType", "authorization_code");
        j = bundle.getBoolean("oauth2UsePostRequest", false);
        o = bundle.getString("oauth2RedirectUrl", "https://picsart-oauth2-success");
        m = (new StringBuilder()).append(c).append("?client_id=").append(e).append("&response_type=code&redirect_uri=").append(o).toString();
        if (!TextUtils.isEmpty(h))
        {
            m = (new StringBuilder()).append(m).append("&scope=").append(h).toString();
        }
        bundle = (WebView)l.findViewById(0x7f100750);
        bundle.setWebViewClient(new c(this, (byte)0));
        bundle.getSettings().setJavaScriptEnabled(true);
        bundle.clearHistory();
        bundle.clearFormData();
        bundle.getSettings().setCacheMode(2);
        bundle.loadUrl(m);
        return;
_L2:
        if (i == 1)
        {
            actionbar.setIcon(getResources().getDrawable(0x7f02037e));
            actionbar.setTitle(getResources().getString(0x7f0802cf));
        } else
        if (i == 4)
        {
            actionbar.setIcon(getResources().getDrawable(0x7f020395));
            actionbar.setTitle(getResources().getString(0x7f0802e2));
        } else
        if (i == 0)
        {
            actionbar.setIcon(getResources().getDrawable(0x7f02033e));
            actionbar.setTitle(getResources().getString(0x7f0802b5));
        } else
        if (i == 5)
        {
            actionbar.setIcon(getResources().getDrawable(0x7f020420));
            actionbar.setTitle(getResources().getString(0x7f080375));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        l = layoutinflater.inflate(0x7f03017f, null);
        p = (ProgressBar)l.findViewById(0x7f100751);
        return l;
    }

}
