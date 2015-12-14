// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.amazon.gallery.framework.gallery.actions.PersistentDialogFragment;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.framework.gallery.dialog:
//            DialogManager

public static abstract class mDialogManager
    implements android.content.ener
{

    protected final Activity mActivity;
    protected Bundle mBundle;
    protected android.content.ner mCancelListener;
    protected boolean mCancellable;
    protected final DialogManager mDialogManager;
    protected android.content.ener mDismissListener;

    protected abstract void cancel();

    protected void completeWithoutShowingDialog()
    {
        DialogManager.access$000(mDialogManager);
    }

    protected abstract Dialog createDialog();

    protected abstract void execute();

    protected PersistentDialogFragment getDialogFragment()
    {
        PersistentDialogFragment persistentdialogfragment = new PersistentDialogFragment() {

            final DialogManager.ShowDialogTask this$0;

            public Dialog onCreateDialog(Bundle bundle)
            {
                return createDialog();
            }

            
            {
                this$0 = DialogManager.ShowDialogTask.this;
                super();
            }
        };
        persistentdialogfragment.setOnDismissListener(this);
        persistentdialogfragment.setOnCancelListener(mCancelListener);
        persistentdialogfragment.setCancelable(mCancellable);
        if (mBundle != null)
        {
            persistentdialogfragment.setArguments(mBundle);
        }
        return persistentdialogfragment;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (mDismissListener != null)
        {
            mDismissListener.onDismiss(dialoginterface);
        }
        DialogManager.access$000(mDialogManager);
    }

    public void queue()
    {
        mDialogManager.queueDialogTask(this);
    }

    protected void showDialog()
    {
        if (mActivity instanceof FragmentActivity)
        {
            FragmentActivity fragmentactivity = (FragmentActivity)mActivity;
            if (fragmentactivity.getSupportFragmentManager().isDestroyed())
            {
                DialogManager.access$000(mDialogManager);
                return;
            } else
            {
                DialogManager.access$100(fragmentactivity, getDialogFragment());
                return;
            }
        } else
        {
            createDialog().show();
            return;
        }
    }

    public createDialog useCancelListener(android.content.ner ner)
    {
        mCancelListener = ner;
        return this;
    }

    public mCancelListener useDismissListener(android.content.ener ener)
    {
        mDismissListener = ener;
        return this;
    }

    protected it>(Activity activity)
    {
        mDismissListener = null;
        mCancelListener = null;
        mBundle = null;
        mCancellable = true;
        mActivity = activity;
        mDialogManager = (DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER);
    }
}
