// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.comcast.cim.android.view.common.Fade;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class this._cls0
    implements android.view.bletFeaturedFragment._cls1
{

    final TabletFeaturedFragment this$0;

    public void onClick(View view)
    {
        if (TabletFeaturedFragment.access$000(TabletFeaturedFragment.this) == null)
        {
            return;
        }
        if (isAccessibilityEnabled)
        {
            lastWatchedContainer.setVisibility(8);
        } else
        {
            TabletFeaturedFragment.access$100(TabletFeaturedFragment.this).hide(lastWatchedContainer, 8);
        }
        ((PlayerUserSettings)userManager.getUserSettings()).setShowLastWatched(false);
        userManager.saveUserAsync();
    }

    ()
    {
        this$0 = TabletFeaturedFragment.this;
        super();
    }
}
