// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cleanupmanager;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.format.Formatter;
import android.view.View;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.CleanupManagerActivity;

public class CleanupManagerDialogHelper
{

    private CleanupManagerActivity activity;

    public CleanupManagerDialogHelper(CleanupManagerActivity cleanupmanageractivity)
    {
        activity = cleanupmanageractivity;
    }

    private void createAndShowDialog(String s, String s1, String s2, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        (new ShowDialogSyncTask(onclicklistener) {

            final CleanupManagerDialogHelper this$0;
            final String val$cancel;
            final String val$confirm;
            final String val$message;
            final android.content.DialogInterface.OnClickListener val$onClickListener;

            protected Dialog createDialog()
            {
                return ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).createDialog(activity, confirm, cancel, message, onClickListener);
            }

            
            {
                this$0 = CleanupManagerDialogHelper.this;
                confirm = s;
                cancel = s1;
                message = s2;
                onClickListener = onclicklistener;
                super(final_activity1);
            }
        }).queue();
    }

    public void showDeleteDialog(boolean flag, long l)
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CleanupManagerDialogHelper this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = CleanupManagerDialogHelper.this;
                super();
            }
        };
        String s = activity.getString(0x7f0e0075);
        String s1 = Formatter.formatShortFileSize(activity, l);
        createAndShowDialog(s, null, activity.getString(0x7f0e0074, new Object[] {
            s1
        }), onclicklistener);
    }

    public void showInstructionDialog(final boolean isNoDupesFound)
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CleanupManagerDialogHelper this$0;
            final boolean val$isNoDupesFound;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                activity.setCleanupPreference(true);
                if (isNoDupesFound)
                {
                    showNoDupesFoundDialog();
                }
            }

            
            {
                this$0 = CleanupManagerDialogHelper.this;
                isNoDupesFound = flag;
                super();
            }
        };
        createAndShowDialog(activity.getString(0x7f0e0093), null, activity.getString(0x7f0e0076), onclicklistener);
    }

    public void showNoDupesFoundDialog()
    {
        if (!activity.getCleanupPreference())
        {
            return;
        } else
        {
            activity.findViewById(0x7f0c0115).setVisibility(8);
            android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                final CleanupManagerDialogHelper this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = CleanupManagerDialogHelper.this;
                super();
            }
            };
            createAndShowDialog(activity.getString(0x7f0e0093), null, activity.getString(0x7f0e0078), onclicklistener);
            return;
        }
    }

}
