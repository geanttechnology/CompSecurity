// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.app.Activity;
import android.app.Fragment;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanUtils

public static class eState extends com.ebay.common.view.r
{

    public com.ebay.common.view.r.HandleState handleError(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
    {
label0:
        {
            com.ebay.common.view.r.HandleState handlestate = com.ebay.common.view.r.HandleState.DefaultHandling;
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
            } while (((com.ebay.nautilus.kernel.content.e.DefaultHandling)resultstatus.next()).DefaultHandling() != 403);
            MyApp.signOutForIafTokenFailure(activity);
            fragment = com.ebay.common.view.r.HandleState.Handled;
        }
        return fragment;
    }

    public eState()
    {
    }
}
