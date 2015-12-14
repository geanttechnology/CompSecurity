// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.content.SharedPreferences;
import com.socialin.android.apiv3.model.ContestItem;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.picsart.profile.util.p;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.List;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            aa

public final class aj
    implements d
{

    private ContestItem a;
    private aa b;

    public aj(aa aa1, ContestItem contestitem)
    {
        b = aa1;
        super();
        a = contestitem;
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        com.socialin.android.d.a(aa.a, exception);
        Utils.c(b.getActivity(), "Fail to Vote for photo !");
        a.setVoting(false);
        aa.a(b).a();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        boolean flag = false;
        a.voted = true;
        obj = a;
        obj.voteCount = ((ContestItem) (obj)).voteCount + 1;
        a.setVoting(false);
        aa.t(b);
        aa.u(b);
        aa.v(b).add(a.photo.url);
        aa.a(b).a();
        boolean flag1 = aa.w(b).getBoolean("vote_accept", false);
        if (aa.w(b) == null || aa.w(b).getBoolean("enable_fb_action_vote", true))
        {
            flag = true;
        }
        aa.a(b).a("vote", flag1, a.photo, b.getString(0x7f08058a), flag);
    }
}
