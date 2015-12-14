// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.removablestorage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.thor.removablestorage:
//            AndroidRemovableStorageManager, StorageLocationPreference

class this._cls0 extends ShowDialogSyncTask
{

    final AndroidRemovableStorageManager this$0;

    protected Dialog createDialog()
    {
        final SharedPreferences prefs = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        Resources resources = mActivity.getResources();
        return mDialogManager.createCustomDialog(mActivity, resources.getString(0x7f0e0204), resources.getString(0x7f0e0202), resources.getString(0x7f0e0203), resources.getString(0x7f0e0201), new android.content.DialogInterface.OnClickListener() {

            final AndroidRemovableStorageManager._cls1 this$1;
            final SharedPreferences val$prefs;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch -2 -1: default 24
            //                           -2 65
            //                           -1 35;
                   goto _L1 _L2 _L3
_L1:
                
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$1 = AndroidRemovableStorageManager._cls1.this;
                prefs = sharedpreferences;
                super();
            }
        });
    }


    _cls1.val.prefs(Activity activity)
    {
        this$0 = AndroidRemovableStorageManager.this;
        super(activity);
    }
}
