// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.socialin.android.apiv3.util.Utils;
import com.socialin.android.d;
import com.socialin.android.facebook.p;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class d
    implements FacebookCallback
{

    final Activity a;
    final p b;
    private List c;
    private String d[];

    public final void onCancel()
    {
        com.socialin.android.d.b(FacebookUtils.access$700(), new Object[] {
            "loginFacebook: onCanceled"
        });
        if (FacebookUtils.SSO_CHECK_MODE)
        {
            b.a();
        } else
        if (AccessToken.getCurrentAccessToken() == null)
        {
            FacebookUtils.setSSOMode(true);
            return;
        }
    }

    public final void onError(FacebookException facebookexception)
    {
        com.socialin.android.d.b(FacebookUtils.access$700(), new Object[] {
            "loginFacebook: onError ", facebookexception.getMessage()
        });
        if (facebookexception.getMessage() == null) goto _L2; else goto _L1
_L1:
        Object obj;
        try
        {
            obj = new JSONObject(facebookexception.getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            obj = null;
        }
        facebookexception = facebookexception.getMessage().toLowerCase();
        if (!facebookexception.contains("invalid access_token")) goto _L4; else goto _L3
_L3:
        Utils.clearFacebookCookies(FacebookSdk.getApplicationContext());
_L2:
        if (FacebookUtils.SSO_CHECK_MODE)
        {
            b.a();
        }
        return;
_L4:
        if (facebookexception.contains("error validating access token"))
        {
            FacebookUtils.logoutFacebook(false);
        } else
        if (obj != null && ((JSONObject) (obj)).has("code"))
        {
            com.socialin.android.util.Utils.a(a, "permission is not granted", 0);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void onSuccess(Object obj)
    {
        obj = (LoginResult)obj;
        if (((LoginResult) (obj)).getRecentlyDeniedPermissions().size() == 0 || !c.containsAll(((LoginResult) (obj)).getRecentlyDeniedPermissions()))
        {
            FacebookUtils.manageFacebookAccounts(a, new p() {

                private FacebookUtils._cls17 a;

                public final void a()
                {
                    if (!FacebookUtils.SSO_CHECK_MODE)
                    {
                        FacebookUtils.sendFriendsAnal(a.a, true);
                    }
                    a.b.a();
                }

            
            {
                a = FacebookUtils._cls17.this;
                super();
            }
            }, d);
        }
    }

    _cls1.a(List list, Activity activity, p p1, String as[])
    {
        c = list;
        a = activity;
        b = p1;
        d = as;
        super();
    }
}
