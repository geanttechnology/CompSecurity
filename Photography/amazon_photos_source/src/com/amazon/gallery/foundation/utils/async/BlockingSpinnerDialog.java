// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.async;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

public class BlockingSpinnerDialog extends AsyncTask
{

    private Runnable backgroundTask;
    private final Context context;
    private final AppCompatProgressDialog dialog;
    private Runnable onPostExecuteTask;

    public BlockingSpinnerDialog(Context context1, Runnable runnable)
    {
        context = context1;
        backgroundTask = runnable;
        dialog = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(context1)).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.SPINNER).setCancellable(false).build();
    }

    public BlockingSpinnerDialog(Context context1, Runnable runnable, String s)
    {
        this(context1, runnable);
        dialog.setMessage(s);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        backgroundTask.run();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        try
        {
            if (dialog.isShowing())
            {
                dialog.dismiss();
                ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1) { }
        if (onPostExecuteTask != null)
        {
            onPostExecuteTask.run();
        }
    }

    protected void onPreExecute()
    {
        ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveAndPendingDialogs();
        (new ShowDialogSyncTask((Activity)context) {

            final BlockingSpinnerDialog this$0;

            protected Dialog createDialog()
            {
                return dialog;
            }

            
            {
                this$0 = BlockingSpinnerDialog.this;
                super(activity);
            }
        }).queue();
    }

    public void setDialogMessage(String s)
    {
        dialog.setMessage(s);
    }

    public void setDialogTitle(String s)
    {
        dialog.setTitle(s);
    }

    public void setPostExecuteTask(Runnable runnable)
    {
        onPostExecuteTask = runnable;
    }

}
