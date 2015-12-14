// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            ConvertFolderToAlbumBlockingProgressDialog

class this._cls0 extends ShowDialogSyncTask
{

    final ConvertFolderToAlbumBlockingProgressDialog this$0;

    protected Dialog createDialog()
    {
        return ConvertFolderToAlbumBlockingProgressDialog.access$000(ConvertFolderToAlbumBlockingProgressDialog.this);
    }

    Q(Activity activity)
    {
        this$0 = ConvertFolderToAlbumBlockingProgressDialog.this;
        super(activity);
    }
}
