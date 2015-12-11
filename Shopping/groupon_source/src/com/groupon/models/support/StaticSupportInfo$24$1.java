// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.support;

import java.util.Arrays;

// Referenced classes of package com.groupon.models.support:
//            StaticSupportInfo

class prefixNegativeSymbol extends ncySettings
{

    final ncySettings this$0;

    ippingAddress()
    {
        this$0 = this._cls0.this;
        super();
        isCurrencyFirst = true;
        groupingSeparator = ".";
        decimalSeparator = ",";
        currencySymbol = "\u20AC";
        isCurrencyFromAmountSeparated = true;
        prefixNegativeSymbol = true;
    }

    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$24

/* anonymous class */
    static final class StaticSupportInfo._cls24 extends StaticSupportInfo
    {

            
            {
                defaultDivisionID = "amsterdam";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new StaticSupportInfo._cls24._cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "phoneNumber", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "postalCode", "city", "company"
                });
            }
    }

}
