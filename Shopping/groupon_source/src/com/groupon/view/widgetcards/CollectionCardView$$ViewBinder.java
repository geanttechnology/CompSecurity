// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.PlaceholderUrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            CollectionCardView

public class A
    implements butterknife.View..ViewBinder
{

    public void bind(butterknife.View..ViewBinder viewbinder, CollectionCardView collectioncardview, Object obj)
    {
        collectioncardview.backgroundImageView = (PlaceholderUrlImageView)viewbinder.backgroundImageView((View)viewbinder.View(obj, 0x7f100299, "field 'backgroundImageView'"), 0x7f100299, "field 'backgroundImageView'");
        collectioncardview.iconImageView = (PlaceholderUrlImageView)viewbinder.iconImageView((View)viewbinder.View(obj, 0x7f10029a, "field 'iconImageView'"), 0x7f10029a, "field 'iconImageView'");
        collectioncardview.collectionSizeView = (TextView)viewbinder.collectionSizeView((View)viewbinder.View(obj, 0x7f1002c3, "field 'collectionSizeView'"), 0x7f1002c3, "field 'collectionSizeView'");
        collectioncardview.titleView = (TextView)viewbinder.titleView((View)viewbinder.View(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        collectioncardview.discountView = (TextView)viewbinder.discountView((View)viewbinder.View(obj, 0x7f100272, "field 'discountView'"), 0x7f100272, "field 'discountView'");
        collectioncardview.callToActionView = (TextView)viewbinder.callToActionView((View)viewbinder.View(obj, 0x7f10029c, "field 'callToActionView'"), 0x7f10029c, "field 'callToActionView'");
    }

    public volatile void bind(butterknife.View..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (CollectionCardView)obj, obj1);
    }

    public void unbind(CollectionCardView collectioncardview)
    {
        collectioncardview.backgroundImageView = null;
        collectioncardview.iconImageView = null;
        collectioncardview.collectionSizeView = null;
        collectioncardview.titleView = null;
        collectioncardview.discountView = null;
        collectioncardview.callToActionView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((CollectionCardView)obj);
    }

    public A()
    {
    }
}
