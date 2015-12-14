// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import com.socialin.android.facebook.util.FacebookUtils;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a
    implements g
{

    private MainPagerActivity a;

    public final void a(String s, m m)
    {
        FacebookUtils.openInviteFriendChooser(a, null, s);
    }

    (MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
