// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.deeplinking;

import android.net.Uri;
import android.text.TextUtils;
import io.branch.referral.i;
import io.branch.referral.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.deeplinking:
//            UrlDeepLinkingActivity

final class a
    implements i
{

    private Uri a;
    private UrlDeepLinkingActivity b;

    public final void a(JSONObject jsonobject, m m)
    {
        if (m != null) goto _L2; else goto _L1
_L1:
        jsonobject = jsonobject.optString("hook_action");
        if (TextUtils.isEmpty(jsonobject)) goto _L4; else goto _L3
_L3:
        b.a(jsonobject);
_L6:
        return;
_L4:
        com.socialin.android.picsart.profile.invite.i.a(true);
_L2:
        jsonobject = b;
        m = a;
        if (m != null)
        {
            jsonobject.a(m.toString());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (UrlDeepLinkingActivity urldeeplinkingactivity, Uri uri)
    {
        b = urldeeplinkingactivity;
        a = uri;
        super();
    }
}
