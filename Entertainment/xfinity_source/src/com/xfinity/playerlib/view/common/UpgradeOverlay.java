// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            OverlayFragment

public class UpgradeOverlay extends OverlayFragment
{

    protected Button closeButton;
    protected TextView primaryCopy;
    protected TextView secondaryCopy;
    protected final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public UpgradeOverlay()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.xfinity.playerlib.R.layout.upgrade_message_overlay, viewgroup, false);
        primaryCopy = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.primary_copy);
        secondaryCopy = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.secondary_copy);
        closeButton = (Button)layoutinflater.findViewById(com.xfinity.playerlib.R.id.close_button);
        primaryCopy.setText(com.xfinity.playerlib.R.string.overlay_upgrade_primary);
        secondaryCopy.setText(com.xfinity.playerlib.R.string.overlay_upgrade_secondary);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final UpgradeOverlay this$0;

            public void onClick(View view)
            {
                save();
                dismissOverlay("UpgradeOverlay");
            }

            
            {
                this$0 = UpgradeOverlay.this;
                super();
            }
        });
        return layoutinflater;
    }

    protected void save()
    {
        ((PlayerUserSettings)userManager.getUserSettings()).setHasSeenUpgradeMessage(true);
        userManager.saveUserAsync();
    }
}
