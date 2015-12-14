// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.content.ContentResolver;
import android.content.Context;
import com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            HideAction

class this._cls0
    implements Runnable
{

    final HideAction this$0;

    public void run()
    {
        if (HideAction.access$200(HideAction.this) != 0L)
        {
            android.net.Uri uri = GalleryInternalContentProvider.createDynamicAlbumMediaUri(HideAction.access$200(HideAction.this));
            context.getContentResolver().notifyChange(uri, null);
        }
    }

    alContentProvider()
    {
        this$0 = HideAction.this;
        super();
    }
}
