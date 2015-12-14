// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumsWelcomeLetterHelper

public class this._cls0 extends ShowDialogSyncTask
{

    final AlbumsWelcomeLetterHelper this$0;

    public Dialog createDialog()
    {
        final SharedPreferences sharedPrefs = mActivity.getSharedPreferences("galleryKindleSharedPrefs", 0);
        String s = (new StringBuilder()).append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).toString();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mActivity.getString(0x7f0e0038)).append(s).append(mActivity.getString(0x7f0e0039)).append(s).append(mActivity.getString(0x7f0e003a)).append(s).append(mActivity.getString(0x7f0e003b));
        s = stringbuilder.toString();
        return (new DialogManager()).createDialog(mActivity, mActivity.getString(0x7f0e0091), null, s, new android.content.DialogInterface.OnClickListener() {

            final AlbumsWelcomeLetterHelper.ShowLetterDialogTask this$1;
            final SharedPreferences val$sharedPrefs;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                sharedPrefs.edit().putBoolean("show_albums_welcome_letter", false).apply();
                dialoginterface.dismiss();
            }

            
            {
                this$1 = AlbumsWelcomeLetterHelper.ShowLetterDialogTask.this;
                sharedPrefs = sharedpreferences;
                super();
            }
        });
    }

    public _cls1.val.sharedPrefs(Activity activity)
    {
        this$0 = AlbumsWelcomeLetterHelper.this;
        super(activity);
    }
}
