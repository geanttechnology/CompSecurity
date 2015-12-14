// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import com.facebook.GraphResponse;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.l;
import com.socialin.android.facebook.p;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class d
    implements com.facebook.hJSONObjectCallback
{

    private Activity a;
    private g b;
    private p c;
    private String d[];

    public final void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
    {
        DialogUtils.dismissDialog(a, b);
        l _tmp = FacebookUtils.access$302(new l(jsonobject));
        if (FacebookUtils.SSO_CHECK_MODE)
        {
            c.a();
            return;
        }
        FacebookUtils.access$400();
        if (!FacebookUtils.isUserConnected())
        {
            FacebookUtils.access$500(a, c, d);
            return;
        } else
        {
            c.a();
            return;
        }
    }

    _cls9(Activity activity, g g, p p1, String as[])
    {
        a = activity;
        b = g;
        c = p1;
        d = as;
        super();
    }
}
