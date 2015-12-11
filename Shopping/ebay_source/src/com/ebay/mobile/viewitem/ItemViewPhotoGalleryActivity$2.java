// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.common.PhotoGalleryWidget;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewPhotoGalleryActivity

class this._cls0
    implements com.ebay.mobile.common.tedEvent
{

    final ItemViewPhotoGalleryActivity this$0;

    public void OnPhotoSelected(int i)
    {
        ItemViewPhotoGalleryActivity.access$100(ItemViewPhotoGalleryActivity.this).setSelectedIndex(i);
        ItemViewPhotoGalleryActivity.access$100(ItemViewPhotoGalleryActivity.this).reloadPhotoIfNeeded(i);
    }

    dEvent()
    {
        this$0 = ItemViewPhotoGalleryActivity.this;
        super();
    }
}
