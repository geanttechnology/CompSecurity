// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.EditText;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumDialog, CreateAlbumTask

class val.albumNameInput
    implements android.content.ickListener
{

    final CreateAlbumDialog this$0;
    final EditText val$albumNameInput;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = val$albumNameInput.getText().toString();
        if (s.length() == 0)
        {
            return;
        } else
        {
            (new CreateAlbumTask(getActivity(), s, CreateAlbumDialog.access$200(CreateAlbumDialog.this), CreateAlbumDialog.access$300(CreateAlbumDialog.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            GlobalMessagingBus.post(new ActionCompleteEvent());
            dialoginterface.dismiss();
            return;
        }
    }

    lMessagingBus()
    {
        this$0 = final_createalbumdialog;
        val$albumNameInput = EditText.this;
        super();
    }
}
