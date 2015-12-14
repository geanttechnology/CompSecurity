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
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.removablestorage:
//            RemovableStorageManagerCommon, StorageLocationPreference

public class AndroidRemovableStorageManager extends RemovableStorageManagerCommon
{

    protected AndroidRemovableStorageManager(Context context, BeanFactory beanfactory)
    {
        super(context, beanfactory);
    }

    protected File getDownloadRootDirectory()
    {
        return getFirstRemovableStorageDirectoryInArray(context.getExternalMediaDirs());
    }

    public StorageLocationPreference getStorageLocationPreference()
    {
        return StorageLocationPreference.fromString(context.getSharedPreferences("galleryKindleSharedPrefs", 0).getString("removable_storage_manager_storage_preference_key", ""));
    }

    public boolean isFileInReadOnlyRemovableStorageLocation(File file)
    {
        return isFileOnRemovableStorage(file) && !StringUtils.contains(file.getPath(), context.getPackageName());
    }

    protected boolean showStoragePreferencePrompt(Activity activity)
    {
        if (!StorageLocationPreference.UNSPECIFIED.equals(getStorageLocationPreference()))
        {
            return false;
        } else
        {
            (new ShowDialogSyncTask(activity) {

                final AndroidRemovableStorageManager this$0;

                protected Dialog createDialog()
                {
                    SharedPreferences sharedpreferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
                    Resources resources = mActivity.getResources();
                    return mDialogManager.createCustomDialog(mActivity, resources.getString(0x7f0e0204), resources.getString(0x7f0e0202), resources.getString(0x7f0e0203), resources.getString(0x7f0e0201), sharedpreferences. new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;
                        final SharedPreferences val$prefs;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            i;
                            JVM INSTR tableswitch -2 -1: default 24
                        //                                       -2 65
                        //                                       -1 35;
                               goto _L1 _L2 _L3
_L1:
                            
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$1 = final__pcls1;
                prefs = SharedPreferences.this;
                super();
            }
                    });
                }


            
            {
                this$0 = AndroidRemovableStorageManager.this;
                super(activity);
            }
            }).queue();
            return true;
        }
    }
}
