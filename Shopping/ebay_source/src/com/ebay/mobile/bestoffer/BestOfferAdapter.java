// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.BestOffer;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            SellerRespondToOfferActivity, BestOfferStatusLocale, BestOfferViewHelper

public class BestOfferAdapter extends ArrayAdapter
{
    protected static class BestOfferListItem
    {

        public OfferBucket bucket;
        public String expirationStr;
        public int expiresColor;
        public boolean header;
        public String headerStr;
        public BestOffer offer;
        public String statusLocalized;

        private static BestOfferListItem buildBestOfferListItem(Activity activity, DateFormat dateformat, DateFormat dateformat1, BestOffer bestoffer, OfferBucket offerbucket)
        {
            BestOfferListItem bestofferlistitem = new BestOfferListItem();
            bestofferlistitem.offer = bestoffer;
            bestofferlistitem.bucket = offerbucket;
            bestofferlistitem.statusLocalized = BestOfferStatusLocale.getCaption(activity, bestoffer.status);
            if (bestoffer.status.equals("Pending"))
            {
                bestofferlistitem.expirationStr = BestOfferViewHelper.getExpiresStr(activity.getResources(), bestoffer.timeLeft());
                bestofferlistitem.expiresColor = BestOfferViewHelper.getExpiresColor(activity, bestoffer.timeLeft());
                return bestofferlistitem;
            } else
            {
                offerbucket = new StringBuilder();
                offerbucket.append(dateformat.format(bestoffer.submissionDate())).append("  ");
                offerbucket.append(dateformat1.format(bestoffer.submissionDate()));
                bestofferlistitem.expirationStr = offerbucket.toString();
                bestofferlistitem.expiresColor = BestOfferViewHelper.getAttributeColor(activity, 0x7f01004e);
                return bestofferlistitem;
            }
        }

        public static ArrayList sortAndConvert(Activity activity, ArrayList arraylist)
        {
            Object obj2 = new ArrayList();
            Object obj3 = new ArrayList();
            Object obj1 = new ArrayList();
            Object obj = new ArrayList();
            for (arraylist = arraylist.iterator(); arraylist.hasNext();)
            {
                BestOffer bestoffer = (BestOffer)arraylist.next();
                if (bestoffer.status.equals("Pending") && bestoffer.codeType.equals("SellerCounterOffer"))
                {
                    ((ArrayList) (obj2)).add(bestoffer);
                } else
                if (bestoffer.status.equals("Pending") && !bestoffer.codeType.equals("SellerCounterOffer"))
                {
                    ((ArrayList) (obj3)).add(bestoffer);
                } else
                if (bestoffer.status.equals("Accepted"))
                {
                    ((ArrayList) (obj1)).add(bestoffer);
                } else
                {
                    ((ArrayList) (obj)).add(bestoffer);
                }
            }

            arraylist = new ArrayList();
            if (((ArrayList) (obj3)).size() > 0)
            {
                BestOfferListItem bestofferlistitem1 = new BestOfferListItem();
                bestofferlistitem1.header = true;
                bestofferlistitem1.headerStr = activity.getResources().getString(0x7f07044a);
                arraylist.add(bestofferlistitem1);
            }
            DateFormat dateformat = android.text.format.DateFormat.getDateFormat(activity);
            DateFormat dateformat1 = android.text.format.DateFormat.getTimeFormat(activity);
            for (obj3 = ((ArrayList) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj3)).next(), OfferBucket.RECEIVED))) { }
            if (((ArrayList) (obj2)).size() > 0)
            {
                BestOfferListItem bestofferlistitem3 = new BestOfferListItem();
                bestofferlistitem3.header = true;
                bestofferlistitem3.headerStr = activity.getResources().getString(0x7f07044b);
                arraylist.add(bestofferlistitem3);
            }
            for (obj2 = ((ArrayList) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj2)).next(), OfferBucket.SENT))) { }
            if (((ArrayList) (obj1)).size() > 0)
            {
                BestOfferListItem bestofferlistitem2 = new BestOfferListItem();
                bestofferlistitem2.header = true;
                bestofferlistitem2.headerStr = activity.getResources().getString(0x7f070446);
                arraylist.add(bestofferlistitem2);
            }
            for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj1)).next(), OfferBucket.ACCEPTED))) { }
            if (((ArrayList) (obj)).size() > 0)
            {
                BestOfferListItem bestofferlistitem = new BestOfferListItem();
                bestofferlistitem.header = true;
                bestofferlistitem.headerStr = activity.getResources().getString(0x7f070449);
                arraylist.add(bestofferlistitem);
            }
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj)).next(), OfferBucket.PAST))) { }
            return arraylist;
        }

        public String toString()
        {
            if (header)
            {
                return headerStr;
            } else
            {
                return (new StringBuilder()).append(bucket.name()).append(" ").append(EbayCurrencyUtil.formatDisplay(offer.currentOffer, 0)).toString();
            }
        }

        protected BestOfferListItem()
        {
        }
    }

    protected static final class BestOfferListItem.OfferBucket extends Enum
    {

        private static final BestOfferListItem.OfferBucket $VALUES[];
        public static final BestOfferListItem.OfferBucket ACCEPTED;
        public static final BestOfferListItem.OfferBucket PAST;
        public static final BestOfferListItem.OfferBucket RECEIVED;
        public static final BestOfferListItem.OfferBucket SENT;

        public static BestOfferListItem.OfferBucket valueOf(String s)
        {
            return (BestOfferListItem.OfferBucket)Enum.valueOf(com/ebay/mobile/bestoffer/BestOfferAdapter$BestOfferListItem$OfferBucket, s);
        }

        public static BestOfferListItem.OfferBucket[] values()
        {
            return (BestOfferListItem.OfferBucket[])$VALUES.clone();
        }

        static 
        {
            SENT = new BestOfferListItem.OfferBucket("SENT", 0);
            RECEIVED = new BestOfferListItem.OfferBucket("RECEIVED", 1);
            ACCEPTED = new BestOfferListItem.OfferBucket("ACCEPTED", 2);
            PAST = new BestOfferListItem.OfferBucket("PAST", 3);
            $VALUES = (new BestOfferListItem.OfferBucket[] {
                SENT, RECEIVED, ACCEPTED, PAST
            });
        }

        private BestOfferListItem.OfferBucket(String s, int i)
        {
            super(s, i);
        }
    }


    private LayoutInflater inflater;
    private List list;

    public BestOfferAdapter(Activity activity, ArrayList arraylist)
    {
        super(activity, 0x7f030190);
        list = new ArrayList();
        list = BestOfferListItem.sortAndConvert(activity, arraylist);
        inflater = LayoutInflater.from(activity);
    }

    public int getCount()
    {
        return list.size();
    }

    public BestOfferListItem getItem(int i)
    {
        return (BestOfferListItem)list.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = inflater.inflate(0x7f030190, viewgroup, false);
        }
        viewgroup = getItem(i);
        if (((BestOfferListItem) (viewgroup)).header)
        {
            TextView textview = (TextView)view.findViewById(0x7f1000f9);
            textview.setVisibility(0);
            textview.setText(((BestOfferListItem) (viewgroup)).headerStr);
            textview.setEnabled(true);
            view.findViewById(0x7f1000f8).setVisibility(8);
            return view;
        }
        view.findViewById(0x7f1000f9).setVisibility(8);
        view.findViewById(0x7f1000f8).setVisibility(0);
        Object obj;
        if (((BestOfferListItem) (viewgroup)).bucket.equals(BestOfferListItem.OfferBucket.RECEIVED))
        {
            view.findViewById(0x7f100497).setVisibility(0);
            view.findViewById(0x7f10049a).setVisibility(0);
        } else
        {
            view.findViewById(0x7f100497).setVisibility(8);
            view.findViewById(0x7f10049a).setVisibility(8);
        }
        ((TextView)view.findViewById(0x7f100162)).setTextColor(((BestOfferListItem) (viewgroup)).expiresColor);
        obj = (TextView)view.findViewById(0x7f100495);
        if (((BestOfferListItem) (viewgroup)).offer.buyerFeedbackScore != null)
        {
            ((TextView) (obj)).setText((new StringBuilder()).append(((BestOfferListItem) (viewgroup)).offer.buyerId).append(" (").append(((BestOfferListItem) (viewgroup)).offer.buyerFeedbackScore).append(")").toString());
        } else
        {
            ((TextView) (obj)).setText(((BestOfferListItem) (viewgroup)).offer.buyerId);
        }
        ((TextView)view.findViewById(0x7f1001b8)).setText(EbayCurrencyUtil.formatDisplay(((BestOfferListItem) (viewgroup)).offer.currentOffer, 0));
        ((TextView)view.findViewById(0x7f100496)).setText((new StringBuilder()).append("").append(((BestOfferListItem) (viewgroup)).offer.quantity).toString());
        ((TextView)view.findViewById(0x7f100188)).setText(((BestOfferListItem) (viewgroup)).statusLocalized);
        ((TextView)view.findViewById(0x7f100162)).setText(((BestOfferListItem) (viewgroup)).expirationStr);
        obj = view.findViewById(0x7f100498);
        viewgroup = SellerRespondToOfferActivity.getShipToString(((BestOfferListItem) (viewgroup)).offer);
        if (TextUtils.isEmpty(viewgroup))
        {
            ((View) (obj)).setVisibility(8);
            return view;
        } else
        {
            ((TextView)view.findViewById(0x7f100499)).setText(viewgroup);
            ((View) (obj)).setVisibility(0);
            return view;
        }
    }

    public boolean isEnabled(int i)
    {
        if (((BestOfferListItem)list.get(i)).header)
        {
            return false;
        } else
        {
            return ((BestOfferListItem)list.get(i)).bucket.equals(BestOfferListItem.OfferBucket.RECEIVED);
        }
    }
}
