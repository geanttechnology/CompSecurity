// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.framework.gallery.actions.PersistentDialogFragment;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DialogManager
{
    public static abstract class ShowDialogTask
        implements android.content.DialogInterface.OnDismissListener
    {

        protected final Activity mActivity;
        protected Bundle mBundle;
        protected android.content.DialogInterface.OnCancelListener mCancelListener;
        protected boolean mCancellable;
        protected final DialogManager mDialogManager;
        protected android.content.DialogInterface.OnDismissListener mDismissListener;

        protected abstract void cancel();

        protected void completeWithoutShowingDialog()
        {
            mDialogManager.completeTask();
        }

        protected abstract Dialog createDialog();

        protected abstract void execute();

        protected PersistentDialogFragment getDialogFragment()
        {
            PersistentDialogFragment persistentdialogfragment = new PersistentDialogFragment() {

                final ShowDialogTask this$0;

                public Dialog onCreateDialog(Bundle bundle)
                {
                    return createDialog();
                }

            
            {
                this$0 = ShowDialogTask.this;
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
            mDialogManager.completeTask();
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
                    mDialogManager.completeTask();
                    return;
                } else
                {
                    DialogManager.showDialogFragment(fragmentactivity, getDialogFragment());
                    return;
                }
            } else
            {
                createDialog().show();
                return;
            }
        }

        public ShowDialogTask useCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
        {
            mCancelListener = oncancellistener;
            return this;
        }

        public ShowDialogTask useDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
        {
            mDismissListener = ondismisslistener;
            return this;
        }

        protected ShowDialogTask(Activity activity)
        {
            mDismissListener = null;
            mCancelListener = null;
            mBundle = null;
            mCancellable = true;
            mActivity = activity;
            mDialogManager = (DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER);
        }
    }


    protected Dialog activeDialog;
    private ShowDialogTask currentDialogTask;
    private Queue pendingDialogTasks;

    public DialogManager()
    {
        activeDialog = null;
        pendingDialogTasks = new ConcurrentLinkedQueue();
        currentDialogTask = null;
    }

    private void clearInvalidDialog()
    {
        if (activeDialog != null && !activeDialog.getWindow().isActive())
        {
            activeDialog = null;
        }
    }

    private void completeTask()
    {
        if (currentDialogTask != null)
        {
            currentDialogTask.cancel();
            currentDialogTask = null;
        }
        executeNextDialogTask();
    }

    private void executeNextDialogTask()
    {
        while (currentDialogTask != null || pendingDialogTasks.isEmpty()) 
        {
            return;
        }
        currentDialogTask = (ShowDialogTask)pendingDialogTasks.remove();
        currentDialogTask.execute();
    }

    private static void showDialogFragment(FragmentActivity fragmentactivity, DialogFragment dialogfragment)
    {
        Object obj = fragmentactivity.getSupportFragmentManager();
        fragmentactivity = ((FragmentManager) (obj)).beginTransaction();
        obj = ((FragmentManager) (obj)).findFragmentByTag("DIALOG_FRAGMENT_TAG");
        if (obj != null)
        {
            fragmentactivity.remove(((android.support.v4.app.Fragment) (obj)));
        }
        fragmentactivity.add(dialogfragment, "DIALOG_FRAGMENT_TAG");
        fragmentactivity.commitAllowingStateLoss();
    }

    public AlertDialog createAutoSaveDialog(Context context, String s, String s1, android.content.DialogInterface.OnClickListener onclicklistener, android.widget.CompoundButton.OnCheckedChangeListener oncheckedchangelistener)
    {
        boolean flag;
        if (activeDialog != null && activeDialog.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertFalse(flag, "You are creating a dialog when one already is displayed");
        s = (new android.support.v7.app.AlertDialog.Builder(context)).setTitle(s).setMessage(s1).setPositiveButton(0x7f0e005f, onclicklistener).setNegativeButton(0x7f0e005e, onclicklistener).setCancelable(false);
        context = View.inflate(context, 0x7f030022, null);
        ((CheckBox)context.findViewById(0x7f0c009b)).setOnCheckedChangeListener(oncheckedchangelistener);
        s.setView(context);
        context = s.create();
        activeDialog = context;
        return context;
    }

    public AlertDialog createConfirmDialogWithOKButton(Activity activity, int i)
    {
        boolean flag;
        if (activeDialog != null && activeDialog.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertFalse(flag, "You are creating a dialog when one already is displayed");
        activity = new android.support.v7.app.AlertDialog.Builder(activity);
        activity.setTitle(i);
        activity.setPositiveButton(0x7f0e0093, new android.content.DialogInterface.OnClickListener() {

            final DialogManager this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
                activeDialog = null;
            }

            
            {
                this$0 = DialogManager.this;
                super();
            }
        });
        activity = activity.create();
        activeDialog = activity;
        return activity;
    }

    public AlertDialog createCustomDialog(Context context, String s, String s1, String s2, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        boolean flag;
        if (activeDialog != null && activeDialog.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertFalse(flag, "You are creating a dialog when one already is displayed");
        context = (new android.support.v7.app.AlertDialog.Builder(context)).setTitle(s).setMessage(s1).setPositiveButton(s2, onclicklistener).setCancelable(false).create();
        activeDialog = context;
        return context;
    }

    public AlertDialog createCustomDialog(Context context, String s, String s1, String s2, String s3, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        boolean flag;
        if (activeDialog != null && activeDialog.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertFalse(flag, "You are creating a dialog when one already is displayed");
        context = (new android.support.v7.app.AlertDialog.Builder(context)).setTitle(s).setMessage(s1).setPositiveButton(s2, onclicklistener).setNegativeButton(s3, onclicklistener).setCancelable(false).create();
        activeDialog = context;
        return context;
    }

    public AlertDialog createDialog(Activity activity, String s, String s1, String s2, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        boolean flag;
        if (activeDialog != null && activeDialog.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertFalse(flag, "You are creating a dialog when one already is displayed");
        activity = new android.support.v7.app.AlertDialog.Builder(activity);
        activity.setPositiveButton(s, onclicklistener);
        activity.setNegativeButton(s1, new android.content.DialogInterface.OnClickListener() {

            final DialogManager this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                activeDialog = null;
            }

            
            {
                this$0 = DialogManager.this;
                super();
            }
        });
        if (s2 != null)
        {
            activity.setMessage(s2);
        }
        activity = activity.create();
        activeDialog = activity;
        return activity;
    }

    public AlertDialog createDialog(Activity activity, String s, String s1, String s2, android.content.DialogInterface.OnClickListener onclicklistener, android.widget.CompoundButton.OnCheckedChangeListener oncheckedchangelistener)
    {
        android.support.v7.app.AlertDialog.Builder builder;
        boolean flag;
        if (activeDialog != null && activeDialog.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertFalse(flag, "You are creating a dialog when one already is displayed");
        builder = new android.support.v7.app.AlertDialog.Builder(activity);
        builder.setPositiveButton(s, onclicklistener);
        builder.setNegativeButton(s1, new android.content.DialogInterface.OnClickListener() {

            final DialogManager this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                activeDialog = null;
            }

            
            {
                this$0 = DialogManager.this;
                super();
            }
        });
        activity = View.inflate(activity, 0x7f03007e, null);
        s = (CheckBox)activity.findViewById(0x7f0c0069);
        s.setText(s2);
        s.setOnCheckedChangeListener(oncheckedchangelistener);
        builder.setView(activity);
        activity = builder.create();
        activeDialog = activity;
        return activity;
    }

    public void dismissActiveAndPendingDialogs()
    {
        pendingDialogTasks.clear();
        dismissActiveDialog();
    }

    public void dismissActiveDialog()
    {
        clearInvalidDialog();
        if (activeDialog != null)
        {
            if (activeDialog.isShowing())
            {
                activeDialog.dismiss();
            }
            activeDialog = null;
        }
    }

    public boolean isDialogActive()
    {
        clearInvalidDialog();
        return activeDialog != null && activeDialog.isShowing();
    }

    public void queueDialogTask(ShowDialogTask showdialogtask)
    {
        pendingDialogTasks.add(showdialogtask);
        executeNextDialogTask();
    }


}
