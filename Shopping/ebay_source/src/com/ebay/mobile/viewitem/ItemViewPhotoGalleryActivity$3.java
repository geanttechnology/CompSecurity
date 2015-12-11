// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewPhotoGalleryActivity

class this._cls0
    implements com.ebay.mobile.common.dEvent
{

    final ItemViewPhotoGalleryActivity this$0;

    public void OnPhotoLoaded(String s)
    {
        Util.setAppStatus(ItemViewPhotoGalleryActivity.this, ItemViewPhotoGalleryActivity.access$200(ItemViewPhotoGalleryActivity.this));
    }

    vent()
    {
        this$0 = ItemViewPhotoGalleryActivity.this;
        super();
    }
}
