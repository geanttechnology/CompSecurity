// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AddToAlbumDialog, CreateAlbumHelper

class val.activity
    implements android.view.r
{

    final AddToAlbumDialog this$0;
    final Activity val$activity;

    public void onClick(View view)
    {
        GlobalMessagingBus.post(new ActionCompleteEvent());
        AddToAlbumDialog.access$200(AddToAlbumDialog.this).dismiss();
        (new CreateAlbumHelper((BeanAwareActivity)val$activity, AddToAlbumDialog.access$300(AddToAlbumDialog.this), AddToAlbumDialog.access$100(AddToAlbumDialog.this).getText(), AddToAlbumDialog.access$400(AddToAlbumDialog.this))).execute();
    }

    tivity()
    {
        this$0 = final_addtoalbumdialog;
        val$activity = Activity.this;
        super();
    }
}
