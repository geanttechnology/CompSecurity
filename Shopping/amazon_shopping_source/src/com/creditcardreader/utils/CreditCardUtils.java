// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.utils;

import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.a9.creditcardreaderlibrary.CreditCardResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreditCardUtils
{

    private static Resources sResources;

    public CreditCardUtils()
    {
    }

    private static void addExpirationDates(String s, ArrayList arraylist, ArrayList arraylist1)
    {
        s = s.split("/");
        arraylist.add(s[0]);
        arraylist1.add(s[1]);
    }

    public static float convertDpToPx(int i)
    {
        return TypedValue.applyDimension(1, i, sResources.getDisplayMetrics());
    }

    public static Intent createSuccessIntent(CreditCardResult creditcardresult)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        arraylist.add(creditcardresult.getCardNumber());
        arraylist2.add("0.9");
        if (creditcardresult.getAlternateCardNumbers() != null)
        {
            for (Iterator iterator = creditcardresult.getAlternateCardNumbers().iterator(); iterator.hasNext(); arraylist2.add("0.7"))
            {
                arraylist.add((String)iterator.next());
            }

        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("CARD_NUMBERS", arraylist);
        intent.putStringArrayListExtra("NUMBER_CONFIDENCE", arraylist2);
        if (creditcardresult.getExpirationDate().length() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            ArrayList arraylist3 = new ArrayList();
            ArrayList arraylist4 = new ArrayList();
            addExpirationDates(creditcardresult.getExpirationDate(), arraylist1, arraylist3);
            arraylist4.add("0.9");
            if (creditcardresult.getAlternateExpirationDates() != null)
            {
                for (creditcardresult = creditcardresult.getAlternateExpirationDates().iterator(); creditcardresult.hasNext(); arraylist4.add("0.7"))
                {
                    addExpirationDates((String)creditcardresult.next(), arraylist1, arraylist3);
                }

            }
            intent.putStringArrayListExtra("CARD_EXPIRATION_MONTHS", arraylist1);
            intent.putStringArrayListExtra("CARD_EXPIRATION_YEARS", arraylist3);
            intent.putStringArrayListExtra("EXPIRAITON_CONFIDENCE", arraylist4);
        }
        return intent;
    }

    public static void setResources(Resources resources)
    {
        sResources = resources;
    }
}
