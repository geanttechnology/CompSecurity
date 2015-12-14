// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.text.TextUtils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import org.json.JSONException;
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
        FacebookWallPostActivity.a(a, exception.getMessage(), null);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        String s;
        String s1;
        Object obj1;
        Object obj2;
        obj2 = (String)obj;
        s = a.getString(0x7f0805ca);
        obj1 = null;
        s1 = obj1;
        request = s;
        if (TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj = s;
        obj2 = new JSONObject(((String) (obj2)));
        s1 = obj1;
        request = s;
        obj = s;
        if (((JSONObject) (obj2)).has("id"))
        {
            request = "";
            obj = request;
            try
            {
                s1 = ((JSONObject) (obj2)).getString("id");
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                request.printStackTrace();
                s1 = obj1;
                request = ((Request) (obj));
            }
        }
        FacebookWallPostActivity.a(a, request, s1);
        return;
    }

    (FacebookWallPostActivity facebookwallpostactivity)
    {
        a = facebookwallpostactivity;
        super();
    }
}
