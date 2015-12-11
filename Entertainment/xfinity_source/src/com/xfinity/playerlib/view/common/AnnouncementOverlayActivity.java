// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            OverlayDismissedListener, CellularEnabledOverlay, UpgradeOverlay, ParentalControlsOverlay

public class AnnouncementOverlayActivity extends BaseActivity
    implements OverlayDismissedListener
{

    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public AnnouncementOverlayActivity()
    {
    }

    private boolean isOverlayCreated()
    {
        android.app.Fragment fragment = getFragmentManager().findFragmentByTag("CellularEnabledOverlay");
        if (fragment == null)
        {
            getFragmentManager().findFragmentByTag("UpgradeOverlay");
        }
        if (fragment == null)
        {
            getFragmentManager().findFragmentByTag("ParentalControlsOverlay");
        }
        return fragment != null;
    }

    public void onBackPressed()
    {
        if (!((PlayerUserSettings)userManager.getUserSettings()).getHasSeenParentalControlsMessage())
        {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(0x10000000);
            startActivity(intent);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            setContentView(com.xfinity.playerlib.R.layout.announcement_overlay);
            if (bundle == null)
            {
                if (((PlayerUserSettings)userManager.getUserSettings()).getHasSeenCellularEnabledMessage())
                {
                    break label0;
                }
                getFragmentManager().beginTransaction().replace(com.xfinity.playerlib.R.id.container, new CellularEnabledOverlay(), "CellularEnabledOverlay").commit();
            }
            return;
        }
        if (!((PlayerUserSettings)userManager.getUserSettings()).getHasSeenUpgradeMessage())
        {
            getFragmentManager().beginTransaction().replace(com.xfinity.playerlib.R.id.container, new UpgradeOverlay(), "UpgradeOverlay").commit();
            return;
        } else
        {
            getFragmentManager().beginTransaction().replace(com.xfinity.playerlib.R.id.container, new ParentalControlsOverlay(), "ParentalControlsOverlay").commit();
            return;
        }
    }

    public void onOverlayDismissed(String s)
    {
        FragmentTransaction fragmenttransaction;
        fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.setCustomAnimations(com.xfinity.playerlib.R.anim.slide_in_right, com.xfinity.playerlib.R.anim.slide_out_left);
        if (!s.equals("CellularEnabledOverlay")) goto _L2; else goto _L1
_L1:
        if (((PlayerUserSettings)userManager.getUserSettings()).getHasSeenUpgradeMessage()) goto _L4; else goto _L3
_L3:
        fragmenttransaction.replace(com.xfinity.playerlib.R.id.container, new UpgradeOverlay(), "UpgradeOverlay").commit();
_L6:
        return;
_L4:
        if (!((PlayerUserSettings)userManager.getUserSettings()).getHasSeenParentalControlsMessage())
        {
            fragmenttransaction.replace(com.xfinity.playerlib.R.id.container, new ParentalControlsOverlay(), "ParentalControlsOverlay").commit();
            return;
        } else
        {
            finish();
            return;
        }
_L2:
        if (s.equals("UpgradeOverlay"))
        {
            if (!((PlayerUserSettings)userManager.getUserSettings()).getHasSeenParentalControlsMessage())
            {
                fragmenttransaction.replace(com.xfinity.playerlib.R.id.container, new ParentalControlsOverlay(), "ParentalControlsOverlay").commit();
                return;
            } else
            {
                finish();
                return;
            }
        }
        if (s.equals("ParentalControlsOverlay"))
        {
            finish();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
