// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.UserCache;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.view.SearchResultListAdapter;
import com.ebay.common.view.ViewCache;
import com.ebay.mobile.bestoffer.BestOfferStatusLocale;
import com.ebay.mobile.bestoffer.BestOfferViewHelper;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.text.DateFormat;
import java.util.HashSet;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            ReminderItemsActivity

private class resources extends SearchResultListAdapter
{

    private final int colorTextDefault;
    private final int colorTextOutbid;
    private final Resources resources;
    final ReminderItemsActivity this$0;

    private String generateKey(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append(':');
        stringbuilder.append(s1);
        return stringbuilder.toString();
    }

    private boolean isPaid(MyEbayListItem myebaylistitem)
    {
        while (ItemTransaction.isPaidFor(myebaylistitem.transaction.es) || ItemTransaction.isPaidUsingTradingQuirk(myebaylistitem.transaction.es, myebaylistitem.transaction.es)) 
        {
            return true;
        }
        return ReminderItemsActivity.access$1300(ReminderItemsActivity.this, String.valueOf(myebaylistitem.id), myebaylistitem.transaction.es);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i == itemList.size() - 1)
        {
            ReminderItemsActivity.access$800(ReminderItemsActivity.this);
        }
        view = super.getView(i, view, viewgroup);
        viewgroup = (ViewCache)view.getTag();
        MyEbayListItem myebaylistitem = (MyEbayListItem)getItem(i);
        if (myebaylistitem.transaction != null && myebaylistitem.transaction. != null)
        {
            Object obj = String.valueOf(myebaylistitem.id);
            Object obj1;
            boolean flag;
            if (myebaylistitem.transaction. || ReminderItemsActivity.access$600(ReminderItemsActivity.this).hasLeftFeedback(((String) (obj)), myebaylistitem.transaction.))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0 && !myebaylistitem.transaction.)
            {
                myebaylistitem.transaction. = true;
            }
            obj1 = ((ViewCache) (viewgroup)).imageLeaveFeedback;
            if (i != 0)
            {
                i = 0x7f0201d4;
            } else
            {
                i = 0x7f0201d5;
            }
            ((ImageView) (obj1)).setImageResource(i);
            ((ViewCache) (viewgroup)).imageLeaveFeedback.setVisibility(0);
            flag = isPaid(myebaylistitem);
            obj1 = ((ViewCache) (viewgroup)).imageStampPaid;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((ImageView) (obj1)).setVisibility(i);
            obj1 = ((ViewCache) (viewgroup)).imageStampOutbid;
            if (ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 4)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((ImageView) (obj1)).setVisibility(i);
            obj1 = generateKey(((String) (obj)), myebaylistitem.transaction.eKey);
            if (ReminderItemsActivity.access$600(ReminderItemsActivity.this).isShipped(((String) (obj)), myebaylistitem.transaction.eKey) && !myebaylistitem.transaction.eKey)
            {
                myebaylistitem.transaction.eKey = true;
                ReminderItemsActivity.access$1000(ReminderItemsActivity.this).add(obj1);
            } else
            if (ReminderItemsActivity.access$1000(ReminderItemsActivity.this).contains(obj1))
            {
                myebaylistitem.transaction.eKey = ReminderItemsActivity.access$600(ReminderItemsActivity.this).isShipped(((String) (obj)), myebaylistitem.transaction.eKey);
            }
            if (myebaylistitem.transaction.eKey || ReminderItemsActivity.access$600(ReminderItemsActivity.this).isShipped(((String) (obj)), myebaylistitem.transaction.eKey))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj = ((ViewCache) (viewgroup)).imageItemShipped;
            if (i != 0)
            {
                i = 0x7f0201ea;
            } else
            {
                i = 0x7f0201e9;
            }
            ((ImageView) (obj)).setImageResource(i);
            ((ViewCache) (viewgroup)).imageItemShipped.setVisibility(0);
        }
        if (ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 4)
        {
            ((ViewCache) (viewgroup)).rightColumnText1.setTextColor(colorTextOutbid);
        }
        if (ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 13 || ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 14)
        {
            ((ViewCache) (viewgroup)).rightColumnText2.setTypeface(Typeface.DEFAULT, 0);
            ((ViewCache) (viewgroup)).rightColumnText2.setText(resources.getQuantityString(0x7f08003b, myebaylistitem.watchCount, new Object[] {
                Integer.valueOf(myebaylistitem.watchCount)
            }));
            ((ViewCache) (viewgroup)).rightColumnText2.setTextColor(colorTextDefault);
        }
        if (ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 10 || ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 11 || ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 12)
        {
            ((ViewCache) (viewgroup)).rightColumnText3.setText(myebaylistitem.highBidderId);
            ((ViewCache) (viewgroup)).rightColumnText3.setEllipsize(android.text.stAdapter.this._fld0);
        }
        if (ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 14)
        {
            if (myebaylistitem.bestOfferPendingCount > 0)
            {
                ((ViewCache) (viewgroup)).rightColumnText3.setText(BestOfferStatusLocale.getCaption(ReminderItemsActivity.this, "Pending"));
                ((ViewCache) (viewgroup)).rightColumnText3.setTextColor(BestOfferViewHelper.getStatusColor(getResources(), "Pending"));
            } else
            {
                ((ViewCache) (viewgroup)).rightColumnText3.setText("");
            }
        }
        if (ReminderItemsActivity.access$900(ReminderItemsActivity.this) == 5)
        {
            ((ViewCache) (viewgroup)).rightColumnText3.setText(BestOfferStatusLocale.getCaption(ReminderItemsActivity.this, myebaylistitem.bestOfferStatus));
            ((ViewCache) (viewgroup)).rightColumnText3.setTextColor(BestOfferViewHelper.getStatusColor(getResources(), myebaylistitem.bestOfferStatus));
        }
        ((ViewCache) (viewgroup)).rightColumnText4.setTextSize(16F);
        ((ViewCache) (viewgroup)).rightColumnText4.setSingleLine(true);
        if (myebaylistitem.transaction.xtDefault != null)
        {
            ((ViewCache) (viewgroup)).rightColumnText4.setText(ReminderItemsActivity.access$1100(ReminderItemsActivity.this).format(myebaylistitem.transaction.xtDefault));
            ((ViewCache) (viewgroup)).rightColumnText4.setTextColor(colorTextDefault);
        } else
        if (((ViewCache) (viewgroup)).rightColumnText4.getText().equals(ReminderItemsActivity.access$1200(ReminderItemsActivity.this)) && myebaylistitem.endDate != null)
        {
            ((ViewCache) (viewgroup)).rightColumnText4.setText(ReminderItemsActivity.access$1100(ReminderItemsActivity.this).format(myebaylistitem.endDate));
            ((ViewCache) (viewgroup)).rightColumnText4.setTextColor(colorTextDefault);
            return view;
        }
        return view;
    }

    public (Activity activity, boolean flag, boolean flag1, List list, int i)
    {
        this$0 = ReminderItemsActivity.this;
        super(activity, new (activity, flag, flag1, i), list, Integer.valueOf(0x7f03016d));
        resources = activity.getResources();
        colorTextDefault = resources.getColor(0x106000c);
        colorTextOutbid = resources.getColor(0x7f0d0064);
    }
}
