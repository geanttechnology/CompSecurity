// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import com.amazon.gallery.thor.app.activity.GalleryActionMode;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AddToAlbumContextBar

class this._cls0
    implements Runnable
{

    final AddToAlbumContextBar this$0;

    public void run()
    {
        AddToAlbumContextBar.access$000(AddToAlbumContextBar.this);
        AddToAlbumContextBar.access$100(AddToAlbumContextBar.this).invalidate();
    }

    ()
    {
        this$0 = AddToAlbumContextBar.this;
        super();
    }
}
