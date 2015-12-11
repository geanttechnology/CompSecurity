// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwContext;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

static abstract class 
{

    private static final String MESSAGE_DIALOG_FRAGMENT_TAG = "messageDialog";
    private boolean showWarnings;

    public final void setShowWarnings(boolean flag)
    {
        showWarnings = flag;
    }

    public final void showMessage(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
    {
        NautilusKernel.verifyMain();
        if (!((FwActivity)activity).isStateSaved()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1 = resultstatus.getFirstError();
        Object obj;
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext;
        String s;
        boolean flag;
        int j;
        if (obj1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (showWarnings)
            {
                obj = resultstatus.getFirstWarning();
            }
        }
        if (obj == null) goto _L1; else goto _L3
_L3:
        ebaycontext = ((FwContext)activity).getEbayContext();
        s = ResultStatus.getSafeLongMessage(ebaycontext, ((com.ebay.nautilus.kernel.content.sage) (obj)));
        obj1 = new Bundle();
        ((Bundle) (obj1)).putString("message", s);
        j = ((com.ebay.nautilus.kernel.content.sage) (obj)).sage();
        if (j != 0)
        {
            ((Bundle) (obj1)).putInt("errorCode", j);
        }
        if (flag)
        {
            ((Bundle) (obj1)).putBoolean("isError", true);
        }
        if (i >= 0)
        {
            ((Bundle) (obj1)).putInt("id", i);
        }
        if (resultstatus.canRetry())
        {
            ((Bundle) (obj1)).putBoolean("allowRetry", true);
        }
        if (!((com.ebay.nautilus.kernel.content.sage) (obj)).MessageHtml(ebaycontext) && showMessageAsBar(((com.ebay.nautilus.kernel.content.ssageAsBar) (obj))))
        {
            ((Bundle) (obj1)).putBoolean("asMessageBar", true);
        }
        if (fragment != null)
        {
            activity = fragment.getFragmentManager();
        } else
        {
            activity = activity.getFragmentManager();
        }
        resultstatus = activity.findFragmentByTag("messageDialog");
        if (!(resultstatus instanceof DialogFragment)) goto _L5; else goto _L4
_L4:
        ((DialogFragment)resultstatus).dismiss();
_L7:
        resultstatus = activity.beginTransaction();
        resultstatus.addToBackStack(null);
        obj = new ErrorDialogFragment();
        ((ErrorDialogFragment) (obj)).setArguments(((Bundle) (obj1)));
        if (fragment != null)
        {
            ((ErrorDialogFragment) (obj)).setTargetFragment(fragment, 0);
        }
        ((ErrorDialogFragment) (obj)).show(resultstatus, "messageDialog");
        activity.executePendingTransactions();
        return;
_L5:
        if (resultstatus != null)
        {
            activity.beginTransaction().remove(resultstatus).commit();
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected abstract boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ssageAsBar ssageasbar);

    ()
    {
    }
}
