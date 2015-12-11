// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finditem:
//            FindItemsResponse

class this._cls4 extends com.ebay.nautilus.kernel.util.._cls1
{

    final is._cls3 this$4;

    public void text(String s)
        throws SAXException
    {
        if ("ITEM_ID".equals(this._mth4(_fld3)))
        {
            _fld3._fld3 = Long.parseLong(s);
        } else
        {
            if ("TITLE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("LEAF_CATS".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("SITE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("PRODUCT_REFID".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("ITEM_CONDITION_NEW".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("BIN_PRICE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("CURRENT_PRICE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("CURRENCY".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("BID_COUNT".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = Integer.valueOf(s).intValue();
                return;
            }
            if ("SALE_TYPE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("SAFE_START_TIME".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = EbayDateUtils.parseXml(s);
                return;
            }
            if ("END_TIME".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = EbayDateUtils.parseXml(s);
                return;
            }
            if ("BUYER_FIXED_SHIPPING_COST".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("FLAT_SHIP_COST".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("FULL_CALCULATED_SHIPPING".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("MD5_IMAGE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("IS_FREE_SHIPPING".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = Boolean.valueOf(s).booleanValue();
                return;
            }
            if ("SHIPPING_FLAG".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("IS_INSURANCE_REQUIRED".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = Boolean.valueOf(s).booleanValue();
                return;
            }
            if ("SOLD_AS_BIN".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = Boolean.valueOf(s).booleanValue();
                return;
            }
            if ("START_PRICE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
        }
    }

    i()
    {
        this$4 = this._cls4.this;
        super();
    }
}
