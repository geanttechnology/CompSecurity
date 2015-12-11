// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.content.Intent;
import android.view.View;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.settings.PlayNowSettingsFragmentActivity;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            ParentalControlsOverlay

class this._cls0
    implements android.view.talControlsOverlay._cls1
{

    final ParentalControlsOverlay this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity);
        view.putExtra("resource", "parental_control_prefs");
        ((PlayerUserSettings)ParentalControlsOverlay.access$000(ParentalControlsOverlay.this).getUserSettings()).setHasSeenParentalControlsMessage(true);
        ParentalControlsOverlay.access$000(ParentalControlsOverlay.this).saveUserAsync();
        dismissOverlay("ParentalControlsOverlay");
        startActivity(view);
    }

    ctivity()
    {
        this$0 = ParentalControlsOverlay.this;
        super();
    }
}
