// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            NotificationsViewModel

public class NotificationsViewHolder extends ViewHolder
{
    private static class NotificationRowHolder
    {

        public final TextView itemCounter;
        public final TextView itemDetails;
        public final RemoteImageView itemImage;
        public final TextView itemTitle;
        View rootView;

        public NotificationRowHolder(View view)
        {
            rootView = view;
            itemCounter = (TextView)view.findViewById(0x7f100285);
            itemImage = (RemoteImageView)view.findViewById(0x7f100286);
            itemTitle = (TextView)view.findViewById(0x7f100287);
            itemDetails = (TextView)view.findViewById(0x7f100288);
        }
    }


    LinearLayout notificationsContent;
    NotificationRowHolder row0;
    NotificationRowHolder row1;
    NotificationRowHolder row2;
    View seeAll;

    public NotificationsViewHolder(View view)
    {
        super(view);
        row0 = new NotificationRowHolder(view.findViewById(0x7f10028a));
        row1 = new NotificationRowHolder(view.findViewById(0x7f10028b));
        row2 = new NotificationRowHolder(view.findViewById(0x7f10028c));
        seeAll = view.findViewById(0x7f10028d);
        row0.rootView.setOnClickListener(this);
        row1.rootView.setOnClickListener(this);
        row2.rootView.setOnClickListener(this);
        seeAll.setOnClickListener(this);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof NotificationsViewModel))
        {
            throw new IllegalArgumentException("Model is not instance of NotificationsViewModel");
        }
        boolean flag = itemView.getResources().getBoolean(0x7f0b0006);
        viewmodel = (NotificationsViewModel)viewmodel;
        if (((NotificationsViewModel) (viewmodel)).notifications != null)
        {
            if (((NotificationsViewModel) (viewmodel)).notifications.size() >= 1)
            {
                bindRow(row0, (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((NotificationsViewModel) (viewmodel)).notifications.get(0));
            } else
            {
                row0.rootView.setVisibility(8);
            }
            if (((NotificationsViewModel) (viewmodel)).notifications.size() >= 2)
            {
                bindRow(row1, (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((NotificationsViewModel) (viewmodel)).notifications.get(1));
            } else
            {
                row1.rootView.setVisibility(8);
            }
            if (((NotificationsViewModel) (viewmodel)).notifications.size() >= 3)
            {
                bindRow(row2, (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((NotificationsViewModel) (viewmodel)).notifications.get(2));
            } else
            {
                row2.rootView.setVisibility(8);
            }
            if (((NotificationsViewModel) (viewmodel)).notifications.size() <= 2 && flag)
            {
                seeAll.setVisibility(0);
                return;
            }
            if (flag)
            {
                seeAll.setVisibility(8);
                return;
            }
        }
    }

    public void bindRow(NotificationRowHolder notificationrowholder, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord)
    {
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification notification = contentrecord.notification;
        notificationrowholder.rootView.setVisibility(0);
        if (notification.title != null)
        {
            notificationrowholder.itemTitle.setText(notification.title.content);
        }
        if (notification.subTitle != null)
        {
            notificationrowholder.itemDetails.setText(notification.subTitle.content);
        }
        if (contentrecord.type == ContentTypeEnum.GROUPED)
        {
            notificationrowholder.itemCounter.setVisibility(0);
            notificationrowholder.itemImage.setVisibility(8);
            notificationrowholder.itemCounter.setText(String.valueOf(notification.count));
        } else
        if (contentrecord.type == ContentTypeEnum.SINGLE)
        {
            notificationrowholder.itemCounter.setVisibility(8);
            notificationrowholder.itemImage.setVisibility(0);
            if (notification.subject != null && notification.subject.listing != null)
            {
                notificationrowholder.itemImage.setRemoteImageUrl(notification.subject.listing.imageUrl);
                return;
            }
        }
    }
}
