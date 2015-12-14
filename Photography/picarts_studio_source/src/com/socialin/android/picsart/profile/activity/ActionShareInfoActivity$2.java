// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.SharedPreferences;
import com.socialin.android.picsart.profile.util.GalleryUtils;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ActionShareInfoActivity

final class a extends Thread
{

    private ActionShareInfoActivity a;

    public final void run()
    {
        if (!"og.likes".equals(ActionShareInfoActivity.b(a)) || ActionShareInfoActivity.c(a) == null) goto _L2; else goto _L1
_L1:
        ActionShareInfoActivity.d(a).edit().utBoolean("enable_fb_action_like", true).ommit();
        GalleryUtils.a(a, ActionShareInfoActivity.c(a), ActionShareInfoActivity.b(a));
_L4:
        ActionShareInfoActivity.e(a);
        return;
_L2:
        if ("vote".equals(ActionShareInfoActivity.b(a)) && ActionShareInfoActivity.c(a) != null)
        {
            ActionShareInfoActivity.d(a).edit().utBoolean("enable_fb_action_vote", true).ommit();
            GalleryUtils.a(a, ActionShareInfoActivity.c(a), ActionShareInfoActivity.b(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (ActionShareInfoActivity actionshareinfoactivity)
    {
        a = actionshareinfoactivity;
        super();
    }
}
