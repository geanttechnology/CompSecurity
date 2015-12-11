// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Shipping;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ShippingLineModel

public static class ShippingMessageType.DEFAULT
{
    public static final class ShippingMessageType extends Enum
    {

        private static final ShippingMessageType $VALUES[];
        public static final ShippingMessageType DEFAULT;
        public static final ShippingMessageType SUPER_SAVER_SHIPPING;

        public static ShippingMessageType valueOf(String s)
        {
            return (ShippingMessageType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/views/messaging/ShippingLineModel$Builder$ShippingMessageType, s);
        }

        public static ShippingMessageType[] values()
        {
            return (ShippingMessageType[])$VALUES.clone();
        }

        static 
        {
            SUPER_SAVER_SHIPPING = new ShippingMessageType("SUPER_SAVER_SHIPPING", 0);
            DEFAULT = new ShippingMessageType("DEFAULT", 1);
            $VALUES = (new ShippingMessageType[] {
                SUPER_SAVER_SHIPPING, DEFAULT
            });
        }

        private ShippingMessageType(String s, int i)
        {
            super(s, i);
        }
    }


    private ShippingMessageType shippingMessageType;

    public ShippingLineModel build(Shipping shipping)
    {
        if (shipping != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        switch (hMap.com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder.ShippingMessageType[shippingMessageType.ordinal()])
        {
        default:
            shipping = shipping.getMessage();
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */
        }
_L4:
        if (!Utils.isEmpty(shipping))
        {
            ShippingLineModel shippinglinemodel = new ShippingLineModel();
            ShippingLineModel.access$000(shippinglinemodel, shipping);
            return shippinglinemodel;
        }
        if (true) goto _L1; else goto _L3
_L3:
        shipping = shipping.getSss();
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public ShippingMessageType setShippingMessageType(ShippingMessageType shippingmessagetype)
    {
        if (shippingmessagetype != null)
        {
            shippingMessageType = shippingmessagetype;
        }
        return this;
    }

    public ShippingMessageType()
    {
        shippingMessageType = ShippingMessageType.DEFAULT;
    }
}
