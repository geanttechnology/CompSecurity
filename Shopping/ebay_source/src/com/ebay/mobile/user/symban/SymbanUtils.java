// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.app.Activity;
import android.app.Fragment;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.Iterator;
import java.util.List;

public final class SymbanUtils
{
    public static class SymbanErrorHandler extends com.ebay.common.view.EbayErrorHandler.OverrideHandler
    {

        public com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState handleError(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
        {
label0:
            {
                com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState handlestate = com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState.DefaultHandling;
                fragment = handlestate;
                if (!MyApp.getPrefs().isSignedIn())
                {
                    break label0;
                }
                resultstatus = resultstatus.getMessages();
                fragment = handlestate;
                if (resultstatus == null)
                {
                    break label0;
                }
                resultstatus = resultstatus.iterator();
                do
                {
                    fragment = handlestate;
                    if (!resultstatus.hasNext())
                    {
                        break label0;
                    }
                } while (((com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next()).getId() != 403);
                MyApp.signOutForIafTokenFailure(activity);
                fragment = com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState.Handled;
            }
            return fragment;
        }

        public SymbanErrorHandler()
        {
        }
    }


    private SymbanUtils()
    {
    }

    public static final SymbanDataManager initalizeDataManager(DataManagerContainer datamanagercontainer)
    {
        SymbanDataManager symbandatamanager = null;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.Symban))
        {
            symbandatamanager = (SymbanDataManager)datamanagercontainer.initialize(SymbanDataManager.KEY, new com.ebay.nautilus.domain.content.dm.SymbanDataManager.SimpleObserver() {

                public void onSymbanCountChanged(SymbanDataManager symbandatamanager1, int i)
                {
                    MyApp.setAppBadgeCount(i);
                }

            });
        }
        return symbandatamanager;
    }
}
