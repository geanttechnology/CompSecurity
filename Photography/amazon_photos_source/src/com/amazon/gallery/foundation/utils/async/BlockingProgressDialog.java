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

public abstract class BlockingProgressDialog extends AsyncTask
{

    private static final String TAG = com/amazon/gallery/foundation/utils/async/BlockingProgressDialog.getName();
    protected final Context context;
    protected final AppCompatProgressDialog dialog;

    public BlockingProgressDialog(Context context1, int i, boolean flag)
    {
        context = context1;
        dialog = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(context1)).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.HORIZONTAL).setCancellable(false).setIndeterminate(flag).setMax(i).build();
    }

    protected void onPostExecute(Object obj)
    {
        try
        {
            if (dialog.isShowing())
            {
                dialog.dismiss();
                ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    protected void onPreExecute()
    {
        ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveAndPendingDialogs();
        (new ShowDialogSyncTask((Activity)context) {

            final BlockingProgressDialog this$0;

            protected Dialog createDialog()
            {
                return dialog;
            }

            
            {
                this$0 = BlockingProgressDialog.this;
                super(activity);
            }
        }).queue();
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
        if (!dialog.isIndeterminate())
        {
            dialog.updateProgress(ainteger[0].intValue());
        }
    }

    public volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }

    public void setDialogMessage(String s)
    {
        dialog.setMessage(s);
    }

    public void setDialogTitle(String s)
    {
        dialog.setTitle(s);
    }

}
