// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary;

import com.a9.vs.mobile.library.impl.jni.CreditCardInfo;
import com.a9.vs.mobile.library.impl.jni.VectorOfString;
import java.util.ArrayList;
import java.util.List;

public class CreditCardResult
{

    private List m_alternateCardNumbers;
    private List m_alternateExpirationDates;
    private String m_cardHolderName;
    private String m_cardNumber;
    private String m_cardType;
    private String m_expirationDate;

    public CreditCardResult(CreditCardInfo creditcardinfo)
    {
        m_cardHolderName = creditcardinfo.getCardHolderName();
        m_cardNumber = creditcardinfo.getCardNumber();
        m_expirationDate = creditcardinfo.getExpirationDate();
        m_cardType = creditcardinfo.getType();
        VectorOfString vectorofstring = creditcardinfo.getCardNumberAlternatives();
        m_alternateCardNumbers = new ArrayList();
        for (int i = 0; (long)i < vectorofstring.size(); i++)
        {
            m_alternateCardNumbers.add(vectorofstring.get(i));
        }

        creditcardinfo = creditcardinfo.getCardDateAlternatives();
        m_alternateExpirationDates = new ArrayList();
        for (int j = 0; (long)j < creditcardinfo.size(); j++)
        {
            m_alternateExpirationDates.add(creditcardinfo.get(j));
        }

    }

    public List getAlternateCardNumbers()
    {
        return m_alternateCardNumbers;
    }

    public List getAlternateExpirationDates()
    {
        return m_alternateExpirationDates;
    }

    public String getCardNumber()
    {
        return m_cardNumber;
    }

    public String getExpirationDate()
    {
        return m_expirationDate;
    }
}
