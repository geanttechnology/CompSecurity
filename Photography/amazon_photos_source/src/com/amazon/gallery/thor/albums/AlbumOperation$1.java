// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation

class DialogSyncTask extends ShowDialogSyncTask
{

    final AlbumOperation this$0;

    protected Dialog createDialog()
    {
        AlbumOperation.access$002(AlbumOperation.this, (new com.amazon.gallery.thor.widget.Dialog.Builder(getActivity())).setStyle(com.amazon.gallery.thor.widget.Dialog.ProgressStyle.SPINNER).setMessage(mActivity.getString(getProgressMessage())).setCancellable(false).build());
        return AlbumOperation.access$000(AlbumOperation.this);
    }

    Dialog.ProgressStyle(Activity activity)
    {
        this$0 = AlbumOperation.this;
        super(activity);
    }
}
