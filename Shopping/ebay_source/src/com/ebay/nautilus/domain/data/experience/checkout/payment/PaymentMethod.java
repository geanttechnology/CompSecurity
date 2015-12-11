// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.payment;

import com.ebay.nautilus.domain.data.experience.checkout.XoActionType;
import com.ebay.nautilus.domain.data.experience.checkout.XoCallToAction;
import com.ebay.nautilus.domain.data.experience.checkout.details.ToolTip;
import com.ebay.nautilus.domain.data.experience.type.base.Image;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.payment:
//            PaymentInstrument, PaymentMethodPromotion

public class PaymentMethod
{

    private static final String ATTRIB_NAME_IDP_DISPLAY = "IdpDisplay";
    private static final String ATTRIB_NAME_RETURN_URL = "ReturnUrl";
    private static final String ATTRIB_VALUE_IDP_DISPLAY = "3";
    private static final String ATTRIB_VALUE_RETURN_URL = "http://prox.ebay.com/";
    public String accessibilityText;
    public Map actions;
    public boolean available;
    public List errors;
    public Image image;
    public String legendText;
    public boolean paymentDetailsComplete;
    public List paymentInstruments;
    public String paymentMethodId;
    public ToolTip paymentMethodInfo;
    public PaymentMethodPromotion promotion;
    public boolean requireFundingSourceOnSelect;
    public boolean selected;
    public boolean showIncentiveWarning;
    public String text;

    public PaymentMethod()
    {
    }

    public String getActionUrl()
    {
        XoCallToAction xocalltoaction;
        if (actions == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        xocalltoaction = (XoCallToAction)actions.get(XoActionType.SELECT_PAYMENT_INSTRUMENT);
        if (xocalltoaction == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        String s = xocalltoaction.getUrl();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        Iterator iterator = xocalltoaction.attributes.keySet().iterator();
_L2:
        String s1 = s;
        String s2;
        String s3;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_159;
        }
        s2 = (String)iterator.next();
        s3 = ((String)xocalltoaction.attributes.get(s2)).replaceAll("\\{", "\\\\{").replaceAll("\\}", "\\\\}");
        s1 = s;
        if (s2.equals("ReturnUrl"))
        {
            s1 = s.replaceAll(s3, URLEncoder.encode("http://prox.ebay.com/", "UTF-8"));
        }
        s = s1;
        if (!s2.equals("IdpDisplay")) goto _L2; else goto _L1
_L1:
        s = s1.replaceAll(s3, "3");
          goto _L2
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        s1 = null;
        return s1;
    }

    public PaymentInstrument getSelectedPaymentInstrument()
    {
        if (paymentInstruments == null)
        {
            return null;
        }
        for (Iterator iterator = paymentInstruments.iterator(); iterator.hasNext();)
        {
            PaymentInstrument paymentinstrument = (PaymentInstrument)iterator.next();
            if (paymentinstrument.selected)
            {
                return paymentinstrument;
            }
        }

        return null;
    }

    public boolean isActionSelectPaymentInstrument()
    {
        return actions != null && actions.get(XoActionType.SELECT_PAYMENT_INSTRUMENT) != null;
    }
}
