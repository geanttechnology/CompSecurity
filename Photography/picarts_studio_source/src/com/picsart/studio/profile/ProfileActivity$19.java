// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.text.TextUtils;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.facebook.l;
import com.socialin.android.facebook.m;
import com.socialin.android.facebook.p;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements p
{

    private ProfileActivity a;

    public final void a()
    {
        if ("profile_image".equals(ProfileActivity.x(a)))
        {
            ProfileActivity.y(a).photo = FacebookUtils.getUserData().e;
        } else
        {
            Object obj = FacebookUtils.getUserData();
            if (((l) (obj)).f == null)
            {
                obj = "";
            } else
            {
                obj = ((l) (obj)).f.a;
            }
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                DialogUtils.dismissDialog(a, ProfileActivity.z(a));
                Utils.c(a, a.getString(0x7f08026a));
                return;
            }
            ProfileActivity.y(a).cover = ((String) (obj));
        }
        ProfileActivity.A(a).setRequestParams(ProfileActivity.y(a));
        ProfileActivity.A(a).doRequest("userUpdate", ProfileActivity.y(a));
    }

    serController(ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
