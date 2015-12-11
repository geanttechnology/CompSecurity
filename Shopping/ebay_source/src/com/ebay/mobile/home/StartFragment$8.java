// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.NotificationsViewModel;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.mobile.user.symban.SymbanActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.kListener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof NotificationsViewModel) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Intent intent;
        NotificationsViewModel notificationsviewmodel = (NotificationsViewModel)viewmodel;
        viewmodel = null;
        byte byte0 = -1;
        SourceIdentification sourceidentification = new SourceIdentification("HomePage", "notifications", "activity");
        intent = new Intent();
        intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        if (view.getId() == 0x7f10028a)
        {
            byte0 = 0;
        } else
        if (view.getId() == 0x7f10028b)
        {
            byte0 = 1;
        } else
        if (view.getId() == 0x7f10028c)
        {
            byte0 = 2;
        }
        if (byte0 != -1)
        {
            if (notificationsviewmodel.notifications.size() >= byte0 + 1)
            {
                viewmodel = ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord)notificationsviewmodel.notifications.get(byte0)).notification;
            }
            if (viewmodel != null)
            {
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action.name == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId != null)
                {
                    if (com.ebay.nautilus.domain.data.on.ActionEnum.PAY_NOW.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action.name))
                    {
                        ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ItemKind.Won, intent);
                    } else
                    if (com.ebay.nautilus.domain.data.on.ActionEnum.SHIP_ITEM.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action.name))
                    {
                        ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ItemKind.Sold, intent);
                    } else
                    if (com.ebay.nautilus.domain.data.on.ActionEnum.RAISE_BID.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action.name))
                    {
                        ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ItemKind.Bidding, intent);
                    } else
                    if (com.ebay.nautilus.domain.data.on.ActionEnum.REVIEW_OFFER.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action.name))
                    {
                        ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ItemKind.Unknown, intent);
                    } else
                    if (com.ebay.nautilus.domain.data.on.ActionEnum.VIEW_ITEM.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).action.name))
                    {
                        ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ItemKind.Unknown, intent);
                    } else
                    {
                        ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ItemKind.Unknown, intent);
                    }
                } else
                {
                    ItemViewActivity.StartActivity(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), com.ebay.common.ItemKind.Unknown);
                }
            }
        }
_L5:
        if (view.getId() == 0x7f10028d)
        {
            view = new Intent(getActivity(), com/ebay/mobile/user/symban/SymbanActivity);
            view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
            getActivity().startActivity(view);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).name == null) goto _L5; else goto _L4
_L4:
        if ("BUYER_PAID".equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).name))
        {
            viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
            viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.ity.ListType.SOLD);
            viewmodel.putExtra("filter", "AwaitingShipment");
            viewmodel.putExtras(intent);
            startActivity(viewmodel);
        } else
        if ("SELLER_OFFER_RECEIVED".equals(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Notification) (viewmodel)).name))
        {
            viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
            viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.ity.ListType.ACTIVE);
            viewmodel.putExtra("filter", "NewOffers");
            viewmodel.putExtras(intent);
            startActivity(viewmodel);
        }
          goto _L5
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
