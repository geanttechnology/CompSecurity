// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.shell.widget.CompositeArrayAdapter;
import java.util.List;

public class FollowingContentListAdapter extends CompositeArrayAdapter
    implements android.view.View.OnClickListener
{
    public static class FeedRow
    {

        public com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord record1;
        public com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord record2;
        public com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord record3;
        public com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord record4;
        public com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord record5;

        public FeedRow(com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord, com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord1, com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord2, com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord3, com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord4)
        {
            record1 = feedvaluerecord;
            record2 = feedvaluerecord1;
            record3 = feedvaluerecord2;
            record4 = feedvaluerecord3;
            record5 = feedvaluerecord4;
        }
    }

    public static class ViewCache
    {

        public TextView bid1;
        public TextView bid2;
        public TextView bid3;
        public TextView bid4;
        public TextView bid5;
        public RemoteImageView image1;
        public View image1Container;
        public RemoteImageView image2;
        public View image2Container;
        public RemoteImageView image3;
        public View image3Container;
        public RemoteImageView image4;
        public View image4Container;
        public RemoteImageView image5;
        public View image5Container;
        public TextView price1;
        public TextView price2;
        public TextView price3;
        public TextView price4;
        public TextView price5;
        private Resources resources;

        private void bind(View view, RemoteImageView remoteimageview, TextView textview, TextView textview1, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing)
        {
            byte byte0 = 4;
            if (listing != null)
            {
                remoteimageview.setRemoteImageUrl(listing.imageUrl);
                if (listing.imageUrl != null)
                {
                    byte0 = 0;
                }
                remoteimageview.setVisibility(byte0);
                if (listing.purchaseOptions.size() > 0)
                {
                    if (listing.purchaseOptions.contains(com.ebay.nautilus.domain.net.api.viewlisting.Listing.PurchaseOptionEnum.AUCTION))
                    {
                        textview.setText(EbayCurrencyUtil.formatDisplay(listing.currentBidPrice.currency, listing.currentBidPrice.value, 2));
                        textview1.setVisibility(0);
                        textview1.setText(resources.getQuantityString(0x7f08001b, listing.bidCount, new Object[] {
                            Integer.valueOf(listing.bidCount)
                        }));
                    } else
                    {
                        textview.setText(EbayCurrencyUtil.formatDisplay(listing.lowestFixedPrice.currency, listing.lowestFixedPrice.value, 2));
                        textview1.setVisibility(8);
                    }
                } else
                {
                    textview.setVisibility(8);
                    textview1.setVisibility(8);
                }
            } else
            {
                remoteimageview.setRemoteImageUrl(null);
                remoteimageview.setVisibility(4);
                textview.setVisibility(8);
                textview1.setVisibility(8);
            }
            view.setTag(listing);
        }

        public void bind(FeedRow feedrow)
        {
            resources = image1Container.getResources();
            if (feedrow == null)
            {
                image1Container.setVisibility(4);
                image2Container.setVisibility(4);
                image3Container.setVisibility(4);
                if (image4Container != null)
                {
                    image4Container.setVisibility(4);
                }
                if (image5Container != null)
                {
                    image5Container.setVisibility(4);
                }
                bind(image1Container, image1, price1, bid1, null);
                bind(image2Container, image2, price2, bid2, null);
                bind(image3Container, image3, price3, bid3, null);
                if (image4 != null)
                {
                    bind(image4Container, image4, price4, bid4, null);
                }
                if (image5 != null)
                {
                    bind(image5Container, image5, price5, bid5, null);
                }
            } else
            {
                image1Container.setVisibility(0);
                image2Container.setVisibility(0);
                image3Container.setVisibility(0);
                if (image4Container != null)
                {
                    image4Container.setVisibility(0);
                }
                if (image5Container != null && feedrow.record5 != null)
                {
                    image5Container.setVisibility(0);
                }
                byte byte0;
                int i;
                if (image5Container != null)
                {
                    byte0 = 5;
                } else
                if (image4Container != null)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 3;
                }
                i = 0;
                while (i < byte0) 
                {
                    Object obj;
                    if (i == 0)
                    {
                        obj = feedrow.record1;
                    } else
                    if (i == 1)
                    {
                        obj = feedrow.record2;
                    } else
                    if (i == 2)
                    {
                        obj = feedrow.record3;
                    } else
                    if (i == 3)
                    {
                        obj = feedrow.record4;
                    } else
                    {
                        obj = feedrow.record5;
                    }
                    if (obj != null)
                    {
                        obj = ((com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord) (obj)).listing;
                    } else
                    {
                        obj = null;
                    }
                    if (i == 0)
                    {
                        bind(image1Container, image1, price1, bid1, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (obj)));
                    } else
                    if (i == 1)
                    {
                        bind(image2Container, image2, price2, bid2, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (obj)));
                    } else
                    if (i == 2)
                    {
                        bind(image3Container, image3, price3, bid3, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (obj)));
                    } else
                    if (i == 3)
                    {
                        bind(image4Container, image4, price4, bid4, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (obj)));
                    } else
                    {
                        bind(image5Container, image5, price5, bid5, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (obj)));
                    }
                    i++;
                }
            }
        }

        public ViewCache()
        {
        }
    }


    private final android.view.View.OnClickListener imageOnClickListener;
    private final boolean isListFourAcross;
    private final float listingDetailsHeight;
    private final float margin2x;
    private final float smallImageSize;

    public FollowingContentListAdapter(Context context, int i, android.view.View.OnClickListener onclicklistener)
    {
        float f1 = 4F;
        super(context, i, 0x1020014);
        setHeaderViewResource(0x7f0300ad);
        float f;
        float f2;
        float f3;
        Point point;
        boolean flag;
        if (i == 0x7f0300a8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isListFourAcross = flag;
        imageOnClickListener = onclicklistener;
        onclicklistener = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        point = new Point();
        onclicklistener.getSize(point);
        margin2x = context.getResources().getDimension(0x7f090074);
        listingDetailsHeight = context.getResources().getDimension(0x7f090081);
        f2 = point.x;
        f3 = margin2x;
        if (isListFourAcross)
        {
            f = 4F;
        } else
        {
            f = 3F;
        }
        if (!isListFourAcross)
        {
            f1 = 3F;
        }
        smallImageSize = (f2 - f * f3) / f1;
    }

    private void setupViewFourAcross(int i, View view, ViewCache viewcache)
    {
        float f;
        int j;
        if (i == 0)
        {
            j = -1;
        } else
        {
            j = (i - 1) % 4;
        }
        i = 0;
        if (j == 0 || j == 2)
        {
            Object obj = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0x7f100125);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0x7f10012a);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.LinearLayout.LayoutParams)viewcache.image4.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image4.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image4Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0x7f100129);
            viewcache.image4Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            viewcache.image5Container.setVisibility(8);
        } else
        if (j == -1)
        {
            Object obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj1.width = (int)smallImageSize;
            obj1.height = (int)smallImageSize;
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(12);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj1.width = (int)smallImageSize;
            obj1.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(1);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, 0x7f100125);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj1.width = (int)(smallImageSize * 2.0F + margin2x);
            obj1.height = (int)((smallImageSize + margin2x) * 2.0F);
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            if (viewcache.image3.getVisibility() == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, 0x7f100125);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image4.getLayoutParams();
            obj1.width = (int)smallImageSize;
            obj1.height = (int)smallImageSize;
            viewcache.image4.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image4Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, 0x7f100129);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
            viewcache.image4Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image5.getLayoutParams();
            obj1.width = (int)smallImageSize;
            obj1.height = (int)smallImageSize;
            viewcache.image5.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image5Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, 0x7f100129);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, 0x7f10012b);
            viewcache.image5Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            viewcache.image5Container.setVisibility(0);
        } else
        if (j == 1)
        {
            Object obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj2.width = (int)smallImageSize;
            obj2.height = (int)smallImageSize;
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(12);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj2.width = (int)smallImageSize;
            obj2.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(1, 0x7f100125);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj2.width = (int)smallImageSize;
            obj2.height = (int)smallImageSize;
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(1);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, 0x7f100125);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image4.getLayoutParams();
            obj2.width = (int)smallImageSize;
            obj2.height = (int)smallImageSize;
            viewcache.image4.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image4Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, 0x7f10012a);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(1, 0x7f100129);
            viewcache.image4Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image5.getLayoutParams();
            obj2.width = (int)(smallImageSize * 2.0F + margin2x);
            obj2.height = (int)((smallImageSize + margin2x) * 2.0F);
            viewcache.image5.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            if (viewcache.image5.getVisibility() == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image5Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(1, 0x7f10012a);
            viewcache.image5Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            viewcache.image5Container.setVisibility(0);
        } else
        if (j == 3)
        {
            Object obj3 = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj3.width = (int)(smallImageSize * 2.0F + margin2x);
            obj3.height = (int)((smallImageSize + margin2x) * 2.0F);
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            if (viewcache.image1.getVisibility() == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj3 = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(9);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj3.width = (int)smallImageSize;
            obj3.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(1, 0x7f100125);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj3.width = (int)smallImageSize;
            obj3.height = (int)smallImageSize;
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(1, 0x7f10012a);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.LinearLayout.LayoutParams)viewcache.image4.getLayoutParams();
            obj3.width = (int)smallImageSize;
            obj3.height = (int)smallImageSize;
            viewcache.image4.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.RelativeLayout.LayoutParams)viewcache.image4Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(1, 0x7f100125);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(3, 0x7f10012a);
            viewcache.image4Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.LinearLayout.LayoutParams)viewcache.image5.getLayoutParams();
            obj3.width = (int)smallImageSize;
            obj3.height = (int)smallImageSize;
            viewcache.image5.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            obj3 = (android.widget.RelativeLayout.LayoutParams)viewcache.image5Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(1, 0x7f10012b);
            ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(3, 0x7f100129);
            viewcache.image5Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
            viewcache.image5Container.setVisibility(0);
        }
        viewcache = view.getLayoutParams();
        if (i != 0)
        {
            f = (smallImageSize + margin2x + listingDetailsHeight) * 2.0F;
        } else
        {
            f = smallImageSize + margin2x + listingDetailsHeight;
        }
        viewcache.height = (int)f;
        view.setLayoutParams(view.getLayoutParams());
    }

    private void setupViewThreeAcross(int i, View view, ViewCache viewcache)
    {
        int j = i % 4;
        i = 0;
        float f;
        if (j == 1 || j == 3)
        {
            Object obj = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0x7f100125);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj.width = (int)smallImageSize;
            obj.height = (int)smallImageSize;
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0x7f10012a);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        if (j == 0)
        {
            Object obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj1.width = (int)(smallImageSize * 2.0F + margin2x);
            obj1.height = (int)((smallImageSize + margin2x) * 2.0F);
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            if (viewcache.image1.getVisibility() == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj1.width = (int)smallImageSize;
            obj1.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, 0x7f100125);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj1.width = (int)smallImageSize;
            obj1.height = (int)smallImageSize;
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            obj1 = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, 0x7f100125);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, 0x7f10012a);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        } else
        if (j == 2)
        {
            Object obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image1.getLayoutParams();
            obj2.width = (int)smallImageSize;
            obj2.height = (int)smallImageSize;
            viewcache.image1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image1Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9);
            viewcache.image1Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image2.getLayoutParams();
            obj2.width = (int)smallImageSize;
            obj2.height = (int)smallImageSize;
            viewcache.image2.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image2Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(1);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, 0x7f100125);
            viewcache.image2Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = (android.widget.LinearLayout.LayoutParams)viewcache.image3.getLayoutParams();
            obj2.width = (int)(smallImageSize * 2.0F + margin2x);
            obj2.height = (int)((smallImageSize + margin2x) * 2.0F);
            viewcache.image3.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            if (viewcache.image3.getVisibility() == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj2 = (android.widget.RelativeLayout.LayoutParams)viewcache.image3Container.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).removeRule(3);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(1, 0x7f100125);
            viewcache.image3Container.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        }
        viewcache = view.getLayoutParams();
        if (i != 0)
        {
            f = (smallImageSize + margin2x + listingDetailsHeight) * 2.0F;
        } else
        {
            f = smallImageSize + margin2x + listingDetailsHeight;
        }
        viewcache.height = (int)f;
        view.setLayoutParams(view.getLayoutParams());
    }

    public void onClick(View view)
    {
    }

    protected void setupHeaderView(int i, CharSequence charsequence, View view)
    {
    }

    protected void setupView(int i, FeedRow feedrow, View view)
    {
        ViewCache viewcache1 = (ViewCache)view.getTag();
        ViewCache viewcache = viewcache1;
        if (viewcache1 == null)
        {
            ViewCache viewcache2 = new ViewCache();
            view.setTag(viewcache2);
            viewcache2.image1Container = view.findViewById(0x7f100125);
            viewcache2.image2Container = view.findViewById(0x7f10012a);
            viewcache2.image3Container = view.findViewById(0x7f100129);
            viewcache2.image4Container = view.findViewById(0x7f10012b);
            viewcache2.image5Container = view.findViewById(0x7f1001b5);
            viewcache2.image1 = (RemoteImageView)view.findViewById(0x7f1000f5);
            viewcache2.image2 = (RemoteImageView)view.findViewById(0x7f10010b);
            viewcache2.image3 = (RemoteImageView)view.findViewById(0x7f10010c);
            viewcache2.image4 = (RemoteImageView)view.findViewById(0x7f1001b4);
            viewcache2.image5 = (RemoteImageView)view.findViewById(0x7f1001b6);
            if (viewcache2.image1Container != null)
            {
                viewcache2.price1 = (TextView)viewcache2.image1Container.findViewById(0x7f1001b8);
                viewcache2.bid1 = (TextView)viewcache2.image1Container.findViewById(0x7f1001b9);
            }
            if (viewcache2.image2Container != null)
            {
                viewcache2.price2 = (TextView)viewcache2.image2Container.findViewById(0x7f1001b8);
                viewcache2.bid2 = (TextView)viewcache2.image2Container.findViewById(0x7f1001b9);
            }
            if (viewcache2.image3Container != null)
            {
                viewcache2.price3 = (TextView)viewcache2.image3Container.findViewById(0x7f1001b8);
                viewcache2.bid3 = (TextView)viewcache2.image3Container.findViewById(0x7f1001b9);
            }
            if (viewcache2.image4Container != null)
            {
                viewcache2.price4 = (TextView)viewcache2.image4Container.findViewById(0x7f1001b8);
                viewcache2.bid4 = (TextView)viewcache2.image4Container.findViewById(0x7f1001b9);
            }
            if (viewcache2.image5Container != null)
            {
                viewcache2.price5 = (TextView)viewcache2.image5Container.findViewById(0x7f1001b8);
                viewcache2.bid5 = (TextView)viewcache2.image5Container.findViewById(0x7f1001b9);
            }
            viewcache = viewcache2;
            if (imageOnClickListener != null)
            {
                viewcache2.image1Container.setOnClickListener(imageOnClickListener);
                viewcache2.image2Container.setOnClickListener(imageOnClickListener);
                viewcache2.image3Container.setOnClickListener(imageOnClickListener);
                if (viewcache2.image4Container != null)
                {
                    viewcache2.image4Container.setOnClickListener(imageOnClickListener);
                }
                viewcache = viewcache2;
                if (viewcache2.image5Container != null)
                {
                    viewcache2.image5Container.setOnClickListener(imageOnClickListener);
                    viewcache = viewcache2;
                }
            }
        }
        viewcache.bind(feedrow);
        if (isListFourAcross)
        {
            setupViewFourAcross(i, view, viewcache);
            return;
        } else
        {
            setupViewThreeAcross(i, view, viewcache);
            return;
        }
    }

    protected volatile void setupView(int i, Object obj, View view)
    {
        setupView(i, (FeedRow)obj, view);
    }
}
