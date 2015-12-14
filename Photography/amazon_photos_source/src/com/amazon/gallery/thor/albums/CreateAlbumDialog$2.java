// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.DialogInterface;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumDialog

class this._cls0
    implements android.content.ickListener
{

    final CreateAlbumDialog this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        GlobalMessagingBus.post(new ActionCompleteEvent());
        dialoginterface.dismiss();
    }

    lMessagingBus()
    {
        this$0 = CreateAlbumDialog.this;
        super();
    }
}
