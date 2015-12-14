// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanKey;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class PersistentDialogFragment extends DialogFragment
{

    private static final String TAG = com/amazon/gallery/framework/gallery/actions/PersistentDialogFragment.getName();
    private Dialog dialog;
    private android.content.DialogInterface.OnCancelListener onCancelListener;
    private android.content.DialogInterface.OnDismissListener onDismissListener;

    public PersistentDialogFragment()
    {
        dialog = null;
    }

    Object getApplicationBean(BeanAwareActivity beanawareactivity, BeanKey beankey)
    {
        return beanawareactivity.getApplicationBean(beankey);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (onCancelListener != null)
        {
            onCancelListener.onCancel(dialoginterface);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        if (dialog == null)
        {
            GLogger.e(TAG, "No dialog created", new Object[0]);
            return super.onCreateDialog(bundle);
        } else
        {
            return dialog;
        }
    }

    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (onDismissListener != null)
        {
            onDismissListener.onDismiss(dialoginterface);
        }
    }

    public void setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        onCancelListener = oncancellistener;
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        onDismissListener = ondismisslistener;
    }

}
