// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Shipping;
import java.util.List;

public class ShippingLineModel
{
    public static class Builder
    {

        private ShippingMessageType shippingMessageType;

        public ShippingLineModel build(Shipping shipping)
        {
            if (shipping != null) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$views$messaging$ShippingLineModel$Builder$ShippingMessageType[];

                static 
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$views$messaging$ShippingLineModel$Builder$ShippingMessageType = new int[Builder.ShippingMessageType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$android$ui$results$views$messaging$ShippingLineModel$Builder$ShippingMessageType[Builder.ShippingMessageType.SUPER_SAVER_SHIPPING.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.views.messaging.ShippingLineModel.Builder.ShippingMessageType[shippingMessageType.ordinal()])
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
                shippinglinemodel.setStyledText(shipping);
                return shippinglinemodel;
            }
            if (true) goto _L1; else goto _L3
_L3:
            shipping = shipping.getSss();
              goto _L4
            if (true) goto _L1; else goto _L5
_L5:
        }

        public Builder setShippingMessageType(ShippingMessageType shippingmessagetype)
        {
            if (shippingmessagetype != null)
            {
                shippingMessageType = shippingmessagetype;
            }
            return this;
        }

        public Builder()
        {
            shippingMessageType = ShippingMessageType.DEFAULT;
        }
    }

    public static final class Builder.ShippingMessageType extends Enum
    {

        private static final Builder.ShippingMessageType $VALUES[];
        public static final Builder.ShippingMessageType DEFAULT;
        public static final Builder.ShippingMessageType SUPER_SAVER_SHIPPING;

        public static Builder.ShippingMessageType valueOf(String s)
        {
            return (Builder.ShippingMessageType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/views/messaging/ShippingLineModel$Builder$ShippingMessageType, s);
        }

        public static Builder.ShippingMessageType[] values()
        {
            return (Builder.ShippingMessageType[])$VALUES.clone();
        }

        static 
        {
            SUPER_SAVER_SHIPPING = new Builder.ShippingMessageType("SUPER_SAVER_SHIPPING", 0);
            DEFAULT = new Builder.ShippingMessageType("DEFAULT", 1);
            $VALUES = (new Builder.ShippingMessageType[] {
                SUPER_SAVER_SHIPPING, DEFAULT
            });
        }

        private Builder.ShippingMessageType(String s, int i)
        {
            super(s, i);
        }
    }


    private List styledText;

    public ShippingLineModel()
    {
    }

    private void setStyledText(List list)
    {
        styledText = list;
    }

    public List getStyledText()
    {
        return styledText;
    }

}
