// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.support;

import java.util.Arrays;

// Referenced classes of package com.groupon.models.support:
//            StaticSupportInfo

class isCurrencyFromAmountSeparated extends encySettings
{

    final encySettings this$0;

    ippingAddressMulti()
    {
        this$0 = this._cls0.this;
        super();
        isCurrencyFirst = true;
        groupingSeparator = ".";
        decimalSeparator = ",";
        currencySymbol = "$";
        isCurrencyFromAmountSeparated = false;
    }

    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$1

/* anonymous class */
    static final class StaticSupportInfo._cls1 extends StaticSupportInfo
    {

            
            {
                defaultDivisionID = "buenos-aires";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new StaticSupportInfo._cls1._cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK=mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "pid", "phoneNumber", "state", "additionalInformationAR", "shippingStreet", "requiredStreetNumber", "postalCode"
                });
                shippingAddressMulti = null;
            }
    }

}
