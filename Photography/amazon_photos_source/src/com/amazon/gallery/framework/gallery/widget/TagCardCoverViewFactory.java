// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.CabVisibilityNotification;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.gallery.actions.DownloadAction;
import com.amazon.gallery.framework.gallery.actions.RenameAction;
import com.amazon.gallery.framework.gallery.actions.ShareAlbumAction;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.gallery.widget.holder.TagCardViewHolder;
import com.amazon.gallery.framework.kindle.action.ManualUploadAction;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.actions.FavoriteAction;
import com.amazon.gallery.thor.app.actions.ThorActionFactory;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            TagCoverViewFactory

public class TagCardCoverViewFactory extends TagCoverViewFactory
    implements com.amazon.gallery.framework.gallery.widget.holder.TagCardViewHolder.MultiselectModeChecker
{

    private final Map actionMap = new HashMap();
    private boolean isInMultiSelectMode;

    public TagCardCoverViewFactory(BeanAwareActivity beanawareactivity)
    {
        super(0x7f0300e1);
        Object obj = ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/DownloadAction);
        actionMap.put(Integer.valueOf(0x7f0c0246), obj);
        obj = ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/kindle/action/ManualUploadAction);
        actionMap.put(Integer.valueOf(0x7f0c0247), obj);
        obj = ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/DeleteAction);
        actionMap.put(Integer.valueOf(0x7f0c0245), obj);
        obj = ThorActionFactory.createSelectionAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/RenameAction);
        actionMap.put(Integer.valueOf(0x7f0c0248), obj);
        obj = ThorActionFactory.createSelectionAction(beanawareactivity, com/amazon/gallery/thor/app/actions/FavoriteAction);
        actionMap.put(Integer.valueOf(0x7f0c0243), obj);
        actionMap.put(Integer.valueOf(0x7f0c0249), ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/ShareAlbumAction));
    }

    public volatile ItemViewHolder createViewHolder(Persistable persistable, View view)
    {
        return createViewHolder((Tag)persistable, view);
    }

    public ItemViewHolder createViewHolder(Tag tag, View view)
    {
        return new TagCardViewHolder(tag, view, downloadManager, actionMap, this);
    }

    public boolean isInMultiSelectMode()
    {
        return isInMultiSelectMode;
    }

    public void onActivityPaused()
    {
        GlobalMessagingBus.unregister(this);
    }

    public void onActivityResumed()
    {
        GlobalMessagingBus.register(this);
    }

    public void onCabVisibilityNotification(CabVisibilityNotification cabvisibilitynotification)
    {
        isInMultiSelectMode = cabvisibilitynotification.show;
    }
}
