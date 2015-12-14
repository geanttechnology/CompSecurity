// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.facebook.util.FacebookUtils;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            FriendInviteDialogActivity

final class a
    implements g
{

    private ImageItem a;
    private FriendInviteDialogActivity b;

    public final void a(String s, m m)
    {
        FacebookUtils.openInviteFriendChooser(b, a, s);
    }

    (FriendInviteDialogActivity friendinvitedialogactivity, ImageItem imageitem)
    {
        b = friendinvitedialogactivity;
        a = imageitem;
        super();
    }
}
