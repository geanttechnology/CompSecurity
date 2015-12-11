// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.NamedParameter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionUrl
    implements Serializable
{

    public static final String ADD_BANK_FUNDING_SOURCE = "AddBankFundingSource";
    public static final String ADD_CARD_FUNDING_SOURCE = "AddCardFundingSource";
    public static final String SELECT_PAYMENT_INSTRUMENT = "SelectPaymentInstrument";
    public static final String SEPA_MANDATE_AGREEMENT = "PaymentAgreementMandate";
    private static final long serialVersionUID = 1L;
    public String action;
    public List placeHolders;
    protected Map placeHoldersMap;
    public String urlText;
    public String value;

    public ActionUrl()
    {
    }

    public Map getPlaceHoldersMap()
    {
        if (placeHoldersMap == null)
        {
            placeHoldersMap = new HashMap();
            if (placeHolders != null)
            {
                NamedParameter.addParameterListToMap(placeHolders, placeHoldersMap);
            }
        }
        return placeHoldersMap;
    }
}
