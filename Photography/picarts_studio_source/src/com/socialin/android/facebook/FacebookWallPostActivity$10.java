// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.text.TextUtils;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class a
    implements d
{

    private FacebookWallPostActivity a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        exception.printStackTrace();
        DialogUtils.dismissDialog(FacebookWallPostActivity.a(a), FacebookWallPostActivity.b(a));
        FacebookUtils.dismissDialog(FacebookWallPostActivity.a(a));
        Utils.c(FacebookWallPostActivity.a(a), exception.getLocalizedMessage());
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        String s = (String)obj;
        request = "";
        obj = request;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                obj = (new JSONObject(s)).optString("uri");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                obj = request;
            }
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            com.socialin.android.d.b(FacebookWallPostActivity.b(), new Object[] {
                (new StringBuilder("postToWall: imageUrl=  ")).append(((String) (obj))).toString()
            });
            FacebookWallPostActivity.a(a, ((String) (obj)), null, Boolean.valueOf(true));
            return;
        } else
        {
            DialogUtils.dismissDialog(FacebookWallPostActivity.a(a), FacebookWallPostActivity.b(a));
            FacebookUtils.dismissDialog(FacebookWallPostActivity.a(a));
            return;
        }
    }

    (FacebookWallPostActivity facebookwallpostactivity)
    {
        a = facebookwallpostactivity;
        super();
    }
}
