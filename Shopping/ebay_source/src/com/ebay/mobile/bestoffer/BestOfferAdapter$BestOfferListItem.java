// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Activity;
import android.content.res.Resources;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.BestOffer;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            BestOfferAdapter, BestOfferStatusLocale, BestOfferViewHelper

protected static class OfferBucket
{
    protected static final class OfferBucket extends Enum
    {

        private static final OfferBucket $VALUES[];
        public static final OfferBucket ACCEPTED;
        public static final OfferBucket PAST;
        public static final OfferBucket RECEIVED;
        public static final OfferBucket SENT;

        public static OfferBucket valueOf(String s)
        {
            return (OfferBucket)Enum.valueOf(com/ebay/mobile/bestoffer/BestOfferAdapter$BestOfferListItem$OfferBucket, s);
        }

        public static OfferBucket[] values()
        {
            return (OfferBucket[])$VALUES.clone();
        }

        static 
        {
            SENT = new OfferBucket("SENT", 0);
            RECEIVED = new OfferBucket("RECEIVED", 1);
            ACCEPTED = new OfferBucket("ACCEPTED", 2);
            PAST = new OfferBucket("PAST", 3);
            $VALUES = (new OfferBucket[] {
                SENT, RECEIVED, ACCEPTED, PAST
            });
        }

        private OfferBucket(String s, int i)
        {
            super(s, i);
        }
    }


    public OfferBucket bucket;
    public String expirationStr;
    public int expiresColor;
    public boolean header;
    public String headerStr;
    public BestOffer offer;
    public String statusLocalized;

    private static OfferBucket buildBestOfferListItem(Activity activity, DateFormat dateformat, DateFormat dateformat1, BestOffer bestoffer, OfferBucket offerbucket)
    {
        OfferBucket offerbucket1 = new <init>();
        offerbucket1.offer = bestoffer;
        offerbucket1.bucket = offerbucket;
        offerbucket1.statusLocalized = BestOfferStatusLocale.getCaption(activity, bestoffer.status);
        if (bestoffer.status.equals("Pending"))
        {
            offerbucket1.expirationStr = BestOfferViewHelper.getExpiresStr(activity.getResources(), bestoffer.timeLeft());
            offerbucket1.expiresColor = BestOfferViewHelper.getExpiresColor(activity, bestoffer.timeLeft());
            return offerbucket1;
        } else
        {
            offerbucket = new StringBuilder();
            offerbucket.append(dateformat.format(bestoffer.submissionDate())).append("  ");
            offerbucket.append(dateformat1.format(bestoffer.submissionDate()));
            offerbucket1.expirationStr = offerbucket.toString();
            offerbucket1.expiresColor = BestOfferViewHelper.getAttributeColor(activity, 0x7f01004e);
            return offerbucket1;
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
            OfferBucket offerbucket1 = new <init>();
            offerbucket1.header = true;
            offerbucket1.headerStr = activity.getResources().getString(0x7f07044a);
            arraylist.add(offerbucket1);
        }
        DateFormat dateformat = android.text.format.DateFormat.getDateFormat(activity);
        DateFormat dateformat1 = android.text.format.DateFormat.getTimeFormat(activity);
        for (obj3 = ((ArrayList) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj3)).next(), OfferBucket.RECEIVED))) { }
        if (((ArrayList) (obj2)).size() > 0)
        {
            OfferBucket offerbucket3 = new <init>();
            offerbucket3.header = true;
            offerbucket3.headerStr = activity.getResources().getString(0x7f07044b);
            arraylist.add(offerbucket3);
        }
        for (obj2 = ((ArrayList) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj2)).next(), OfferBucket.SENT))) { }
        if (((ArrayList) (obj1)).size() > 0)
        {
            OfferBucket offerbucket2 = new <init>();
            offerbucket2.header = true;
            offerbucket2.headerStr = activity.getResources().getString(0x7f070446);
            arraylist.add(offerbucket2);
        }
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); arraylist.add(buildBestOfferListItem(activity, dateformat, dateformat1, (BestOffer)((Iterator) (obj1)).next(), OfferBucket.ACCEPTED))) { }
        if (((ArrayList) (obj)).size() > 0)
        {
            OfferBucket offerbucket = new <init>();
            offerbucket.header = true;
            offerbucket.headerStr = activity.getResources().getString(0x7f070449);
            arraylist.add(offerbucket);
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

    protected OfferBucket()
    {
    }
}
