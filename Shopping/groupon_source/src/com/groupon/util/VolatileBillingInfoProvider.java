// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Strings;

public class VolatileBillingInfoProvider
{

    private HashMap billingRecord;
    private boolean isCVVRequiredForCard;
    private HashMap paymentDetails;

    public VolatileBillingInfoProvider()
    {
        billingRecord = new HashMap();
        paymentDetails = new HashMap();
    }

    public void addPaymentDetailsParams(List list)
    {
        Iterator iterator = paymentDetails.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (isCVVRequiredForCard || !Strings.equalsIgnoreCase(entry.getKey(), "billing_record[cvv]"))
            {
                list.add(entry.getKey());
                list.add(entry.getValue());
            }
        } while (true);
    }

    public void clear()
    {
        paymentDetails.clear();
        billingRecord.clear();
    }

    public List getBillingInfoParams()
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (Iterator iterator = billingRecord.entrySet().iterator(); iterator.hasNext(); arraylist.add(entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            arraylist.add(entry.getKey());
        }

        return arraylist;
    }

    public String getBillingRecordCardNumber()
    {
        return (String)paymentDetails.get("billing_record[card_number]");
    }

    public String getBillingRecordCardType()
    {
        return (String)paymentDetails.get("billing_record[card_type]");
    }

    public String getBillingRecordElvAccountNumber()
    {
        return (String)paymentDetails.get("billing_record[elv_account_number]");
    }

    public String getBillingRecordMaskedCardNumber()
    {
        boolean flag = hasElvAccountNumber();
        boolean flag1 = hasSepaIban();
        String s;
        if (flag)
        {
            s = getBillingRecordElvAccountNumber();
        } else
        if (flag1)
        {
            s = getBillingRecordSepaIban();
        } else
        {
            s = getBillingRecordCardNumber();
        }
        if (flag)
        {
            return s.substring(0, Math.min(s.length(), 4));
        } else
        {
            return s.substring(Math.max(0, s.length() - 4));
        }
    }

    public String getBillingRecordSepaIban()
    {
        return (String)paymentDetails.get("billing_record[iban]");
    }

    public boolean hasCreditCardDetails()
    {
        return paymentDetails.containsKey("billing_record[card_type]");
    }

    public boolean hasElvAccountNumber()
    {
        return paymentDetails.containsKey("billing_record[elv_account_number]");
    }

    public boolean hasSepaIban()
    {
        return paymentDetails.containsKey("billing_record[iban]");
    }

    public void setBillingRecordAddress(String s)
    {
        paymentDetails.put("billing_record[address]", s);
    }

    public void setBillingRecordCVV(String s)
    {
        paymentDetails.put("billing_record[cvv]", s);
    }

    public void setBillingRecordCardNumber(String s)
    {
        paymentDetails.put("billing_record[card_number]", s);
    }

    public void setBillingRecordCardType(String s)
    {
        paymentDetails.put("billing_record[card_type]", s);
    }

    public void setBillingRecordCpf(String s)
    {
        billingRecord.put("cpf", s);
    }

    public void setBillingRecordElvAccountNumber(String s)
    {
        paymentDetails.put("billing_record[elv_account_number]", s);
    }

    public void setBillingRecordElvBankCode(String s)
    {
        paymentDetails.put("billing_record[elv_blz]", s);
    }

    public void setBillingRecordExpirationMonth(String s)
    {
        paymentDetails.put("billing_record[expiration_month]", s);
    }

    public void setBillingRecordExpirationYear(String s)
    {
        paymentDetails.put("billing_record[expiration_year]", s);
    }

    public void setBillingRecordFirstName(String s)
    {
        paymentDetails.put("billing_record[first_name]", s);
    }

    public void setBillingRecordIssuerNumber(String s)
    {
        paymentDetails.put("billing_record[issuer_number]", s);
    }

    public void setBillingRecordLastName(String s)
    {
        paymentDetails.put("billing_record[last_name]", s);
    }

    public void setBillingRecordPostalCode(String s)
    {
        paymentDetails.put("billing_record[postal_code]", s);
    }

    public void setBillingRecordSepaBic(String s)
    {
        paymentDetails.put("billing_record[bic]", s);
    }

    public void setBillingRecordSepaIban(String s)
    {
        paymentDetails.put("billing_record[iban]", s);
    }

    public void setBillingRecordType(String s)
    {
        paymentDetails.put("billing_record[type]", s);
    }

    public void setBillingRecordValidFromMonth(String s)
    {
        paymentDetails.put("billing_record[valid_from_month]", s);
    }

    public void setBillingRecordValidFromYear(String s)
    {
        paymentDetails.put("billing_record[valid_from_year]", s);
    }

    public void setBillingRecordValidToMonth(String s)
    {
        paymentDetails.put("billing_record[valid_to_month]", s);
    }

    public void setBillingRecordValidToYear(String s)
    {
        paymentDetails.put("billing_record[valid_to_year]", s);
    }

    public void setCVVRequiredForCard(boolean flag)
    {
        isCVVRequiredForCard = flag;
    }

    public void setCity(String s)
    {
        billingRecord.put("city", s);
    }

    public void setFirstName(String s)
    {
        billingRecord.put("first_name", s);
    }

    public void setLastName(String s)
    {
        billingRecord.put("last_name", s);
    }

    public void setPostalCode(String s)
    {
        billingRecord.put("postal_code", s);
    }

    public void setStreetAddress1(String s)
    {
        billingRecord.put("street_address_1", s);
    }

    public void setStreetNumber(String s)
    {
        billingRecord.put("street_number", s);
    }
}
