// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import com.amazon.gallery.thor.removablestorage.RemovableStorageStateListener;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl

class this._cls0
    implements RemovableStorageStateListener
{

    final AutoSaveManagerImpl this$0;

    public void onMediaBadRemoval()
    {
    }

    public void onMediaMounted()
    {
    }

    public void onMediaUnmounted()
    {
        toSaveTagSet.REMOVABLE_TAGS.setAutoUploadFutureTags(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this), false);
        toSaveTagSet.REMOVABLE_TAGS.setDisplayNewTagDialog(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this), true);
    }

    toSaveTagSet()
    {
        this$0 = AutoSaveManagerImpl.this;
        super();
    }
}
