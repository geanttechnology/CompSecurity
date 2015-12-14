// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.view.View;
import com.socialin.android.facebook.util.FacebookUtils;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class a
    implements android.view.llPostActivity._cls7
{

    final FacebookWallPostActivity a;

    public final void onClick(View view)
    {
    /* block-local class not found */
    class _cls1 {}

        FacebookUtils.approveFriendInfoAction(FacebookWallPostActivity.a(a), com.facebook.ate(), new _cls1());
    }

    _cls1(FacebookWallPostActivity facebookwallpostactivity)
    {
        a = facebookwallpostactivity;
        super();
    }
}
