// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogAsyncTask;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GalleryPermissionChecker
{

    private static AtomicBoolean dialogShownThisSession = new AtomicBoolean(false);
    private final Context appContext;
    private final PackageManager packageManager;
    private final String packageName;

    public GalleryPermissionChecker(Context context)
    {
        appContext = context.getApplicationContext();
        packageName = appContext.getPackageName();
        packageManager = appContext.getPackageManager();
    }

    private void addPermissionIfMissing(String s, List list)
    {
        if (!checkPermission(s))
        {
            list.add(s);
        }
    }

    public boolean checkPermission(String s)
    {
        return packageManager.checkPermission(s, packageName) == 0;
    }

    public void showMissingPermissionsIfNeeded(final Activity final_activity1)
    {
        if (dialogShownThisSession.get())
        {
            return;
        } else
        {
            (new ShowDialogAsyncTask(final_activity1) {

                List missingPermissions;
                final GalleryPermissionChecker this$0;
                final Activity val$activity;

                protected Dialog createDialog()
                {
                    Resources resources = activity.getResources();
                    String s = String.format(resources.getString(0x7f0e00e3), new Object[] {
                        missingPermissions.iterator().next()
                    });
                    return mDialogManager.createCustomDialog(activity, resources.getString(0x7f0e00e4), s, resources.getString(0x104000a), new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            GalleryPermissionChecker.dialogShownThisSession.set(true);
                            
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

                protected boolean shouldShowDialog()
                {
                    if (!GalleryPermissionChecker.dialogShownThisSession.get())
                    {
                        missingPermissions = new LinkedList();
                        if (!Api.isAtLeastMarshmallow())
                        {
                            addPermissionIfMissing("android.permission.AUTHENTICATE_ACCOUNTS", missingPermissions);
                        }
                        if (!missingPermissions.isEmpty())
                        {
                            return true;
                        }
                    }
                    return false;
                }


            
            {
                this$0 = GalleryPermissionChecker.this;
                activity = activity2;
                super(final_activity1);
            }
            }).queue();
            return;
        }
    }



}
