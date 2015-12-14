// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddFollowingController;
import com.socialin.android.apiv3.controllers.RemoveFollowingController;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements android.widget.eckedChangeListener
{

    private ProfileActivity a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.PageOpenEvent("user_profile", "follow"));
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        ViewerUser vieweruser;
        ProfileActivity.q(a).setEnabled(false);
        compoundbutton = a;
        vieweruser = ProfileActivity.c(a);
        if (!compoundbutton.a(1003) || compoundbutton.d()) goto _L4; else goto _L3
_L3:
        AnalyticUtils.getInstance(compoundbutton).trackLocalAction("profile:FOLLOW");
        AnalyticUtils.getInstance(compoundbutton).track(new com.socialin.android.apiv3.events.wEvent("profile", vieweruser.id));
        ((ProfileActivity) (compoundbutton)).c.userId = vieweruser.id;
        ((ProfileActivity) (compoundbutton)).a.setRequestParams(((ProfileActivity) (compoundbutton)).c);
        ((ProfileActivity) (compoundbutton)).a.setRequestCompleteListener(new init>(compoundbutton, vieweruser));
        ((ProfileActivity) (compoundbutton)).a.doRequest("addFollowing", ((ProfileActivity) (compoundbutton)).c);
_L6:
        return;
_L4:
        ((ProfileActivity) (compoundbutton)).e.setEnabled(true);
        ((ProfileActivity) (compoundbutton)).e.setChecked(false);
        return;
_L2:
        ProfileActivity.q(a).setEnabled(false);
        compoundbutton = a;
        ViewerUser vieweruser1 = ProfileActivity.c(a);
        if (compoundbutton.a(1003) && !compoundbutton.d())
        {
            AnalyticUtils.getInstance(compoundbutton).trackLocalAction("profile:unFollow");
            AnalyticUtils.getInstance(compoundbutton).track(new com.socialin.android.apiv3.events.lowEvent("profile", vieweruser1.id));
            ((ProfileActivity) (compoundbutton)).c.userId = vieweruser1.id;
            ((ProfileActivity) (compoundbutton)).b.setRequestParams(((ProfileActivity) (compoundbutton)).c);
            ((ProfileActivity) (compoundbutton)).b.setRequestCompleteListener(new init>(compoundbutton, vieweruser1));
            ((ProfileActivity) (compoundbutton)).b.doRequest("removeFollowing", ((ProfileActivity) (compoundbutton)).c);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ollowingController(ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
