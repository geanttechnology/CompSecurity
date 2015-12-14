// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.bx.a;
import myobfuscated.ca.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.socialin.android.instagram:
//            d, a, b, h

public class g extends com.socialin.android.instagram.d
    implements b
{

    private static final String c = com/socialin/android/instagram/g.getSimpleName();
    private com.socialin.android.instagram.a d;
    private String e;

    public g()
    {
        e = "";
    }

    private List a(URL url)
    {
        ArrayList arraylist = new ArrayList();
        url = (JSONObject)(new JSONTokener(Utils.a(url.openConnection().getInputStream()))).nextValue();
        JSONArray jsonarray = url.getJSONArray("data");
        for (int i = 0; i < jsonarray.length(); i++)
        {
            Object obj = jsonarray.getJSONObject(i);
            String s = ((JSONObject) (obj)).optString("type", null);
            if (s == null || !"image".equals(s))
            {
                continue;
            }
            obj = a(((JSONObject) (obj)));
            if (obj != null)
            {
                arraylist.add(obj);
            }
        }

        url = url.optJSONObject("pagination");
        if (url != null && url.has("next_url"))
        {
            e = url.getString("next_url");
            return arraylist;
        } else
        {
            e = "";
            return arraylist;
        }
    }

    public final List a()
    {
        if (!e.isEmpty()) goto _L2; else goto _L1
_L1:
        if (super.a != null) goto _L4; else goto _L3
_L3:
        int i = 0;
_L7:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        Object obj = new URL((new StringBuilder("https://api.instagram.com/v1/users/")).append(d.b.a).append("/media/recent/?access_token=").append(d.a).toString());
_L8:
        if (obj == null) goto _L6; else goto _L5
_L5:
        return a(((URL) (obj)));
_L4:
        i = super.a.getCount();
          goto _L7
_L2:
        obj = new URL(e);
          goto _L8
        obj;
        com.socialin.android.d.b(c, "loadPhotos", ((Throwable) (obj)));
_L6:
        return new ArrayList();
        obj = null;
          goto _L8
    }

    public final void a(String s)
    {
        FragmentTransaction fragmenttransaction;
        Object obj;
        obj = getFragmentManager();
        fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
        obj = ((FragmentManager) (obj)).findFragmentByTag("oauthInstagramFragmentTag");
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        s = new com.socialin.android.instagram.a(new JSONObject(s));
        com.socialin.android.instagram.h.a(getActivity().getApplicationContext(), s);
        fragmenttransaction.hide(((android.app.Fragment) (obj))).commitAllowingStateLoss();
        c();
        return;
        s;
        com.socialin.android.d.b(c, "onAuthSuccess", s);
        return;
    }

    public final void b()
    {
        myobfuscated.ca.a a1;
        FragmentTransaction fragmenttransaction;
        FragmentManager fragmentmanager = getFragmentManager();
        fragmenttransaction = fragmentmanager.beginTransaction();
        a1 = (myobfuscated.ca.a)fragmentmanager.findFragmentByTag("oauthInstagramFragmentTag");
        if (com.socialin.android.instagram.h.b(getActivity().getApplicationContext())) goto _L2; else goto _L1
_L1:
        Object obj;
label0:
        {
            a(8);
            obj = getActivity().getIntent();
            ((Intent) (obj)).putExtra("oauth2AuthorizationEndpoint", "https://api.instagram.com/oauth/authorize/");
            ((Intent) (obj)).putExtra("oauth2AccessTokenEndpoint", "https://api.instagram.com/oauth/access_token");
            ((Intent) (obj)).putExtra("oauth2ClientSecret", "56e884c8c2c14146819ce990bf76b070");
            ((Intent) (obj)).putExtra("oauth2ClientId", "c73708fbbf72408eb6b5dd676da16dba");
            ((Intent) (obj)).putExtra("oauth2UsePostRequest", true);
            ((Intent) (obj)).putExtra("oauth2SocialKey", 4);
            if (a1 != null)
            {
                obj = a1;
                if (a1.isAdded())
                {
                    break label0;
                }
            }
            obj = new myobfuscated.ca.a();
            obj.a = this;
            fragmenttransaction.add(0x7f100690, ((android.app.Fragment) (obj)), "oauthInstagramFragmentTag");
        }
        fragmenttransaction.show(((android.app.Fragment) (obj)));
_L4:
        fragmenttransaction.commitAllowingStateLoss();
        return;
_L2:
        if (a1 != null && a1.isAdded())
        {
            fragmenttransaction.hide(a1);
            a(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void c()
    {
label0:
        {
            if (getActivity() != null && com.socialin.android.instagram.h.b(getActivity().getApplicationContext()))
            {
                d();
                d = com.socialin.android.instagram.h.a(getActivity().getApplicationContext());
                if (d != null && d.b != null)
                {
                    break label0;
                }
                FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
                fragmenttransaction.hide(this);
                fragmenttransaction.commitAllowingStateLoss();
            }
            return;
        }
        e();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.b = 0x7f03013d;
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

}
