// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

// Referenced classes of package com.ebay.app:
//            DialogFragmentCallback

public class ProgressDialogFragment extends DialogFragment
{

    public CharSequence message;
    public CharSequence title;

    public ProgressDialogFragment()
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (getTargetFragment() != null && (getTargetFragment() instanceof DialogFragmentCallback))
        {
            ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(this, getTargetRequestCode(), 3);
        } else
        if (getActivity() instanceof DialogFragmentCallback)
        {
            ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(this, getTargetRequestCode(), 3);
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new ProgressDialog(getActivity());
        bundle.setTitle(title);
        bundle.setMessage(message);
        bundle.setIndeterminate(true);
        bundle.setCancelable(true);
        bundle.setCanceledOnTouchOutside(false);
        return bundle;
    }
}
