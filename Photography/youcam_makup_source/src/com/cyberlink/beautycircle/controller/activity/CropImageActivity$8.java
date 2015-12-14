// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.r;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CropImageActivity

class a extends m
{

    final CropImageActivity a;

    protected void a()
    {
        a.l();
        Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_update_user_info));
    }

    protected void a(int i)
    {
        a.l();
        if (i == 401 || i == 420)
        {
            CropImageActivity.a(a, 48258, null);
            return;
        } else
        {
            Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_update_user_info));
            return;
        }
    }

    protected void a(UserInfo userinfo)
    {
        String s;
        UserInfo userinfo1;
        s = AccountManager.b();
        userinfo1 = AccountManager.d();
        if (userinfo == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (CropImageActivity.d(a) != 48135)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        userinfo1.avatarUrl = userinfo.avatarUrl;
        r.a(userinfo.avatarUrl, CropImageActivity.e(a));
_L1:
        AccountManager.a(s, userinfo1, false);
        CropImageActivity.a(a, -1, null);
        a.l();
        return;
        userinfo1.coverUrl = userinfo.coverUrl;
        r.a(userinfo.coverUrl, CropImageActivity.e(a));
          goto _L1
        userinfo;
        userinfo.printStackTrace();
        Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_update_user_info));
        a.l();
        return;
        userinfo;
        a.l();
        throw userinfo;
    }

    protected void b(Object obj)
    {
        a((UserInfo)obj);
    }

    (CropImageActivity cropimageactivity)
    {
        a = cropimageactivity;
        super();
    }
}
