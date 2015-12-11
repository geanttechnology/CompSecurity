// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.smile;

import com.amazon.mShop.control.smile.SmileController;
import com.amazon.mShop.feature.FeatureStateSubscriber;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.gno.GNOItemAdapter;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.util.ActivityUtils;
import java.util.List;

// Referenced classes of package com.amazon.mShop.smile:
//            SmileHelper

public class SmileUserListener
    implements FeatureStateSubscriber, UserListener
{

    private static SmileUserListener sInstance = new SmileUserListener();

    private SmileUserListener()
    {
    }

    public static SmileUserListener getInstance()
    {
        return sInstance;
    }

    private void refreshMenu()
    {
        if (SmileHelper.shouldSyncSmileInfo())
        {
            GNODrawer.getGNOItemAdapter().updateVisibleItems();
        }
    }

    public static void registerFeatureStateListener()
    {
        Features.getInstance().addFeatureStateSubscriber(getInstance());
    }

    public static void registerUserListener()
    {
        if (ActivityUtils.isSmileEnabled())
        {
            User.addUserListener(getInstance());
        }
    }

    private void syncSmileInfo()
    {
        if (ActivityUtils.isSmileEnabled())
        {
            SmileController.getInstance().syncSmileInfo();
        }
    }

    public void onCancel()
    {
    }

    public void onError(Exception exception)
    {
    }

    public void onFeatureStateReceived(List list)
    {
        if (!ActivityUtils.isSmileEnabled())
        {
            if (User.isLoggedIn() && User.getUser().isSmile())
            {
                SmileHelper.updateSmileInfo(false, "");
                GNODrawer.getGNOItemAdapter().updateVisibleItems();
            }
        } else
        if (SmileHelper.shouldSyncSmileInfo())
        {
            SmileController.getInstance().syncSmileInfo();
            return;
        }
    }

    public void userSignedIn(User user)
    {
        syncSmileInfo();
    }

    public void userSignedOut()
    {
    }

    public void userUpdated(User user)
    {
        refreshMenu();
    }

}
