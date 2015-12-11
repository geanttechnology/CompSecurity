// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.core;

import com.jumio.netswipe.sdk.NetswipeCardInformation;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import jumiomobile.ab;
import jumiomobile.di;
import jumiomobile.fs;
import org.json.JSONObject;

public final class InternalCardInformation extends NetswipeCardInformation
{

    private boolean a;

    public InternalCardInformation()
    {
        a = false;
    }

    private StringBuilder h(StringBuilder stringbuilder)
    {
        int k = stringbuilder.length() - 1;
        int i = 0;
        int j;
        do
        {
            j = k;
            if (i >= k)
            {
                break;
            }
            j = k;
            if (stringbuilder.charAt(i) > ' ')
            {
                break;
            }
            i++;
        } while (true);
        for (; j >= i && stringbuilder.charAt(j) <= ' '; j--) { }
        StringBuilder stringbuilder1 = new StringBuilder();
        stringbuilder1.append(stringbuilder, i, j + 1);
        j = stringbuilder1.length() - 1;
        boolean flag = false;
        while (j >= 0) 
        {
            if (Character.isWhitespace(stringbuilder1.charAt(j)))
            {
                if (!flag)
                {
                    flag = true;
                } else
                {
                    stringbuilder1.deleteCharAt(j);
                }
            } else
            {
                flag = false;
            }
            j--;
        }
        return stringbuilder1;
    }

    public final InternalCardInformation a()
    {
        InternalCardInformation internalcardinformation = new InternalCardInformation();
        internalcardinformation.cardNumber = copyField(cardNumber);
        internalcardinformation.cardNumberGrouped = copyField(cardNumberGrouped);
        internalcardinformation.cardNumberMasked = copyField(cardNumberMasked);
        internalcardinformation.cardExpiryDateMonth = copyField(cardExpiryDateMonth);
        internalcardinformation.cardExpiryDateYear = copyField(cardExpiryDateYear);
        internalcardinformation.cardCvvCode = copyField(cardCvvCode);
        internalcardinformation.cardHolderName = copyField(cardHolderName);
        internalcardinformation.cardSortCode = copyField(cardSortCode);
        internalcardinformation.cardAccountNumber = copyField(cardAccountNumber);
        internalcardinformation.cardNumberManuallyEntered = cardNumberManuallyEntered;
        internalcardinformation.cardType = cardType;
        internalcardinformation.customFields = (HashMap)customFields.clone();
        internalcardinformation.cardSortCodeValid = cardSortCodeValid;
        internalcardinformation.cardAccountNumberValid = cardAccountNumberValid;
        internalcardinformation.nameToCompare = nameToCompare;
        internalcardinformation.a = a;
        return internalcardinformation;
    }

    public final void a(String s)
    {
        if (!cardNumberManuallyEntered && s != null && s.length() != 0)
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("generationtime", simpledateformat.format(new Date()));
                jsonobject.put("number", new String(getCardNumber()));
                jsonobject.put("holderName", new String(getCardHolderName()));
                jsonobject.put("cvc", new String(getCardCvvCode()));
                jsonobject.put("expiryMonth", new String(getCardExpiryDateMonth()));
                jsonobject.put("expiryYear", (new StringBuilder("20")).append(new String(getCardExpiryDateYear())).toString());
                encryptedAdyenString = (new di(s)).a(jsonobject.toString());
                if (encryptedAdyenString != null && encryptedAdyenString.length() != 0)
                {
                    s = cardType;
                    clear();
                    cardType = s;
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ab.a(s);
                return;
            }
        }
    }

    public final void a(String s, String s1)
    {
        customFields.put(s, s1);
    }

    public final void a(StringBuilder stringbuilder)
    {
        cardType = fs.b(stringbuilder);
        if (cardNumber != null)
        {
            Arrays.fill(cardNumber, '\0');
        }
        cardNumber = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardNumber, 0);
        if (cardNumberGrouped != null)
        {
            Arrays.fill(cardNumberGrouped, '\0');
        }
        fs.a(stringbuilder, cardType);
        cardNumberGrouped = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardNumberGrouped, 0);
        if (cardNumberMasked != null)
        {
            Arrays.fill(cardNumberMasked, '\0');
        }
        fs.e(stringbuilder);
        fs.a(stringbuilder, cardType);
        cardNumberMasked = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardNumberMasked, 0);
    }

    public final char[] a(boolean flag)
    {
        if (flag)
        {
            return getCardNumberMasked();
        } else
        {
            return getCardNumberGrouped();
        }
    }

    public final NetswipeCardInformation b()
    {
        return NetswipeCardInformation.create(this);
    }

    public final void b(String s)
    {
        nameToCompare = s;
    }

    public final void b(StringBuilder stringbuilder)
    {
        stringbuilder = h(stringbuilder);
        if (cardHolderName != null)
        {
            Arrays.fill(cardHolderName, '\0');
        }
        cardHolderName = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardHolderName, 0);
    }

    public final void b(boolean flag)
    {
        cardNumberManuallyEntered = flag;
    }

    public final void c(StringBuilder stringbuilder)
    {
        if (cardSortCode != null)
        {
            Arrays.fill(cardSortCode, '\0');
        }
        cardSortCode = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardSortCode, 0);
    }

    public final void c(boolean flag)
    {
        cardSortCodeValid = flag;
    }

    public final boolean c()
    {
        return a;
    }

    public final void d(StringBuilder stringbuilder)
    {
        if (cardAccountNumber != null)
        {
            Arrays.fill(cardAccountNumber, '\0');
        }
        cardAccountNumber = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardAccountNumber, 0);
    }

    public final void d(boolean flag)
    {
        cardAccountNumberValid = flag;
    }

    public final void e(StringBuilder stringbuilder)
    {
        if (cardExpiryDateMonth != null)
        {
            Arrays.fill(cardExpiryDateMonth, '\0');
        }
        cardExpiryDateMonth = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardExpiryDateMonth, 0);
    }

    public final void e(boolean flag)
    {
        a = flag;
    }

    public final void f(StringBuilder stringbuilder)
    {
        if (cardExpiryDateYear != null)
        {
            Arrays.fill(cardExpiryDateYear, '\0');
        }
        cardExpiryDateYear = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardExpiryDateYear, 0);
    }

    public final void g(StringBuilder stringbuilder)
    {
        if (cardCvvCode != null)
        {
            Arrays.fill(cardCvvCode, '\0');
        }
        cardCvvCode = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), cardCvvCode, 0);
    }
}
