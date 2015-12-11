// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.analytics:
//            RoiTrackEventRequest

public static final class secondaryCategoryId
{

    private final String itemId;
    private final ItemCurrency orderTotal;
    private final String primaryCategoryId;
    private final String quantity;
    private final String secondaryCategoryId;
    private final String sellerName;
    private final String uniqueTransactionId;

    final void add(XmlSerializer xmlserializer)
        throws IOException
    {
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sellerName", sellerName);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "itemId", itemId);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "uniqueTransactionId", uniqueTransactionId);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "quantity", quantity);
        if (orderTotal != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "orderTotal");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "currencyId", orderTotal.code);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "amount", orderTotal.value);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "orderTotal");
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "primaryCategoryId", primaryCategoryId);
        if (!TextUtils.isEmpty(secondaryCategoryId))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "secondaryCategoryId", secondaryCategoryId);
        }
    }

    public (String s, String s1, String s2, String s3, ItemCurrency itemcurrency, String s4, String s5)
    {
        sellerName = s;
        itemId = s1;
        uniqueTransactionId = s2;
        quantity = s3;
        orderTotal = itemcurrency;
        primaryCategoryId = s4;
        secondaryCategoryId = s5;
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("sellerName");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new NullPointerException("itemId");
        }
        if (TextUtils.isEmpty(s2))
        {
            throw new NullPointerException("uniqueTransactionId");
        }
        if (TextUtils.isEmpty(s3))
        {
            throw new NullPointerException("quantity");
        }
        if (TextUtils.isEmpty(s4))
        {
            throw new NullPointerException("primaryCategoryId");
        } else
        {
            return;
        }
    }
}
