// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import android.widget.CheckBox;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.widget.ItemMetadataViewHolder;
import com.amazon.gallery.framework.gallery.widget.MediaItemListAdapter;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.ui.cab.CleanupManagerActivityContextBar;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            CleanupManagerActivity

class this._cls0
    implements android.view.leanupManagerActivity._cls2
{

    final CleanupManagerActivity this$0;

    public void onClick(View view)
    {
        int i = ((android.support.v7.widget.Activity)view.getTag()).etPosition();
        MediaItem mediaitem = (MediaItem)CleanupManagerActivity.access$100(CleanupManagerActivity.this).getItem(i);
        if (!CleanupManagerActivity.access$200(CleanupManagerActivity.this).isContextBarActive())
        {
            GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.tranceType.TAP));
        }
        ItemMetadataViewHolder itemmetadataviewholder = (ItemMetadataViewHolder)(ItemMetadataViewHolder)view.getTag();
        if (itemmetadataviewholder == null)
        {
            view = (CheckBox)view.findViewById(0x7f0c017c);
        } else
        {
            view = itemmetadataviewholder.checkBox;
        }
        view.performClick();
        if (view.isChecked())
        {
            CleanupManagerActivity.access$200(CleanupManagerActivity.this).addSelectable(mediaitem);
            return;
        } else
        {
            CleanupManagerActivity.access$200(CleanupManagerActivity.this).removeSelectable(mediaitem);
            return;
        }
    }

    lder()
    {
        this$0 = CleanupManagerActivity.this;
        super();
    }
}
