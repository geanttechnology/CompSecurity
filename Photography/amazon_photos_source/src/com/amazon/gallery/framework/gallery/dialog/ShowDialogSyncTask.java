// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.app.Activity;

public abstract class ShowDialogSyncTask extends DialogManager.ShowDialogTask
{

    protected ShowDialogSyncTask(Activity activity)
    {
        super(activity);
    }

    protected void cancel()
    {
    }

    protected void execute()
    {
        mActivity.runOnUiThread(new Runnable() {

            final ShowDialogSyncTask this$0;

            public void run()
            {
                showDialog();
            }

            
            {
                this$0 = ShowDialogSyncTask.this;
                super();
            }
        });
    }
}
