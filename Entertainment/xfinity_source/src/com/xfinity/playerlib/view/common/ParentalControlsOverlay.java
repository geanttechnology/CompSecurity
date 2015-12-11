// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.settings.PlayNowSettingsFragmentActivity;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            OverlayFragment

public class ParentalControlsOverlay extends OverlayFragment
{

    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public ParentalControlsOverlay()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.xfinity.playerlib.R.layout.parental_controls_message_overlay, viewgroup, false);
        viewgroup = layoutinflater.findViewById(com.xfinity.playerlib.R.id.overlay_parental_controls_go_to_button);
        bundle = layoutinflater.findViewById(com.xfinity.playerlib.R.id.overlay_parental_controls_do_not_show_again_button);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final ParentalControlsOverlay this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity);
                view.putExtra("resource", "parental_control_prefs");
                ((PlayerUserSettings)userManager.getUserSettings()).setHasSeenParentalControlsMessage(true);
                userManager.saveUserAsync();
                dismissOverlay("ParentalControlsOverlay");
                startActivity(view);
            }

            
            {
                this$0 = ParentalControlsOverlay.this;
                super();
            }
        });
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final ParentalControlsOverlay this$0;

            public void onClick(View view)
            {
                ((PlayerUserSettings)userManager.getUserSettings()).setHasSeenParentalControlsMessage(true);
                userManager.saveUserAsync();
                dismissOverlay("ParentalControlsOverlay");
            }

            
            {
                this$0 = ParentalControlsOverlay.this;
                super();
            }
        });
        return layoutinflater;
    }

}
