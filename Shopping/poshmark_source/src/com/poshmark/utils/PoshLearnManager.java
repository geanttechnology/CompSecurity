// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.support.v4.app.FragmentManager;
import com.poshmark.application.PMApplicationSession;

// Referenced classes of package com.poshmark.utils:
//            PoshLearnDialog, AppInfoCache

public class PoshLearnManager
{
    private static class SingletonHolder
    {

        public static final PoshLearnManager INSTANCE = new PoshLearnManager();


        private SingletonHolder()
        {
        }
    }


    private boolean deepLinkLaunchFlag;

    public PoshLearnManager()
    {
        deepLinkLaunchFlag = false;
    }

    public static PoshLearnManager getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void lauchPoshLearn(FragmentManager fragmentmanager)
    {
        (new PoshLearnDialog()).show(fragmentmanager, "pmLoveDlg");
    }

    public void setDeepLinkLaunchFlag(boolean flag)
    {
        deepLinkLaunchFlag = flag;
    }

    public boolean shouldShowPoshLearnScreen()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if ((new AppInfoCache()).getCurrentVersion() == null)
        {
            flag = flag1;
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                flag = flag1;
                if (!deepLinkLaunchFlag)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
