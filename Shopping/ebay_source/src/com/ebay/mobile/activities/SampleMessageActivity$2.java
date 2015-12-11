// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Fragment;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.activities:
//            SampleMessageActivity, ErrorDialogActivity

static final class er.HandleState extends com.ebay.common.view.eHandler
{

    public com.ebay.common.view.eHandler.HandleState handleError(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
    {
        com.ebay.nautilus.kernel.content.dleState dlestate = resultstatus.getFirstError();
        if (dlestate != null)
        {
            ErrorDialogActivity.StartActivity(activity, String.valueOf(dlestate.Id()), ResultStatus.getSafeLongMessage(((SampleMessageActivity)activity).getEbayContext(), dlestate));
            return com.ebay.common.view.eHandler.HandleState.Handled;
        } else
        {
            return super.handleError(activity, fragment, i, resultstatus);
        }
    }

    public com.ebay.common.view.eHandler.HandleState handleWarning(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
    {
        com.ebay.nautilus.kernel.content.dleState dlestate = resultstatus.getFirstWarning();
        if (dlestate != null)
        {
            i = dlestate.Id();
            fragment = ResultStatus.getSafeLongMessage(((SampleMessageActivity)activity).getEbayContext(), dlestate);
            ErrorDialogActivity.StartActivity(activity, activity.getString(0x7f070130), String.valueOf(i), fragment, false);
            return com.ebay.common.view.eHandler.HandleState.Handled;
        } else
        {
            return super.handleWarning(activity, fragment, i, resultstatus);
        }
    }

    er.HandleState()
    {
    }
}
