// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogAsyncTask;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.app:
//            GalleryPermissionChecker

class this._cls1
    implements android.content.er
{

    final ss._cls000 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        GalleryPermissionChecker.access$000().set(true);
        
// JavaClassFileOutputException: get_constant: invalid tag

    ncTask()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/app/GalleryPermissionChecker$1

/* anonymous class */
    class GalleryPermissionChecker._cls1 extends ShowDialogAsyncTask
    {

        List missingPermissions;
        final GalleryPermissionChecker this$0;
        final Activity val$activity;

        protected Dialog createDialog()
        {
            Resources resources = activity.getResources();
            String s = String.format(resources.getString(0x7f0e00e3), new Object[] {
                missingPermissions.iterator().next()
            });
            return mDialogManager.createCustomDialog(activity, resources.getString(0x7f0e00e4), s, resources.getString(0x104000a), new _cls1());
        }

        protected boolean shouldShowDialog()
        {
            if (!GalleryPermissionChecker.access$000().get())
            {
                missingPermissions = new LinkedList();
                if (!Api.isAtLeastMarshmallow())
                {
                    GalleryPermissionChecker.access$100(GalleryPermissionChecker.this, "android.permission.AUTHENTICATE_ACCOUNTS", missingPermissions);
                }
                if (!missingPermissions.isEmpty())
                {
                    return true;
                }
            }
            return false;
        }


            
            {
                this$0 = final_gallerypermissionchecker;
                activity = activity2;
                super(Activity.this);
            }
    }

}
