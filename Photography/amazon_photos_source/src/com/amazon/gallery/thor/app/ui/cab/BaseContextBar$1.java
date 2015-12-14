// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import com.amazon.gallery.thor.app.activity.GalleryActionModeCallback;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            BaseContextBar

class this._cls0
    implements GalleryActionModeCallback
{

    final BaseContextBar this$0;

    public boolean onActionItemClicked(GalleryActionMode galleryactionmode, MenuItem menuitem)
    {
        galleryactionmode = (SelectionAction)BaseContextBar.access$000(BaseContextBar.this).get(menuitem.getItemId());
        executeAction(galleryactionmode);
        return true;
    }

    public boolean onCreateActionMode(GalleryActionMode galleryactionmode, Menu menu)
    {
        return true;
    }

    public void onDestroyActionMode(GalleryActionMode galleryactionmode)
    {
        GlobalMessagingBus.post(new ActionCompleteEvent());
    }

    public boolean onPrepareActionMode(GalleryActionMode galleryactionmode, Menu menu)
    {
        BaseContextBar.this.onPrepareActionMode(galleryactionmode, menu);
        doSyncMenu();
        return true;
    }

    de()
    {
        this$0 = BaseContextBar.this;
        super();
    }
}
