// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.model.RemindersList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

private final class <init> extends com.ebay.nautilus.kernel.util.nit>
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.nit> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("paymentToSend".equals(s1) || "watchEndingSoon".equals(s1) || "feedbackToSend".equals(s1) || "outbid".equals(s1) || "bidEndingSoon".equals(s1) || "paymentToReceive".equals(s1) || "bestOffer".equals(s1) || "shippingNeeded".equals(s1) || "sellEndingSoon".equals(s1) || "secondChanceOffer".equals(s1) || "pickupReady".equals(s1))
        {
            <init>(this._cls0.this).count = Integer.valueOf(attributes.getValue("count")).intValue();
            this._mth0(this._cls0.this).nextPageLocator = attributes.getValue("nextPageLocator");
            s = this._mth0(this._cls0.this);
            boolean flag;
            if (attributes.getValue("hasMore") != null && attributes.getValue("hasMore").equals("true"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s.hasMore = flag;
            return new ent(this._cls0.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ent()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
