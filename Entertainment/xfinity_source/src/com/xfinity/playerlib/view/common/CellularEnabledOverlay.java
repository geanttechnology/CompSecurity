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
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            UpgradeOverlay

public class CellularEnabledOverlay extends UpgradeOverlay
{

    public CellularEnabledOverlay()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        primaryCopy.setText(com.xfinity.playerlib.R.string.cellular_upgrade_overlay_primary);
        secondaryCopy.setText(com.xfinity.playerlib.R.string.cellular_upgrade_overlay_secondary);
        closeButton.setText(com.xfinity.playerlib.R.string.cellular_upgrade_close_button);
        return layoutinflater;
    }

    protected void save()
    {
        ((PlayerUserSettings)userManager.getUserSettings()).setHasSeenCellularEnabledMessage(true);
        userManager.saveUserAsync();
    }
}
