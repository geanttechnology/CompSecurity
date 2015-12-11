// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.component.creditcardscanner;

import android.content.Intent;
import com.groupon.activity.EditCreditCard;
import com.jumio.netswipe.sdk.NetswipeSDK;
import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.component.creditcardscanner:
//            CreditCardScanner

public class JumioCreditCardScanner
    implements CreditCardScanner
{

    private static final String k = "56084d44-836a-4cf5-bc02-d67c28402a7c";
    private static final String s = "BfJv8R44Aa1Ls9zyXW55BOkQDPBKjAX6";
    private NetswipeSDK sdk;

    public JumioCreditCardScanner()
    {
    }

    public void handleScanResult(EditCreditCard editcreditcard, int i, int j, Intent intent)
    {
        if (i == NetswipeSDK.REQUEST_CODE)
        {
            if (j == -1)
            {
                HashMap hashmap = new HashMap(4);
                NetswipeCardInformation netswipecardinformation = (NetswipeCardInformation)intent.getParcelableExtra("EXTRA_CARD_INFORMATION");
                hashmap.put("card_number", new String(netswipecardinformation.getCardNumber()));
                hashmap.put("cvv_code", new String(netswipecardinformation.getCvvCode()));
                hashmap.put("expiry_date_month", new String(netswipecardinformation.getExpiryDateMonth()));
                hashmap.put("expiry_date_year", new String(netswipecardinformation.getExpiryDateYear()));
                String s3 = new String(netswipecardinformation.getCardHolderName());
                intent = "";
                String s2 = "";
                String s1 = s2;
                if (s3 != null)
                {
                    String as[] = s3.split("\\s+", 2);
                    s3 = as[0].trim();
                    intent = s3;
                    s1 = s2;
                    if (as.length > 1)
                    {
                        s1 = as[1].trim();
                        intent = s3;
                    }
                }
                hashmap.put("first_name", intent);
                hashmap.put("last_name", s1);
                netswipecardinformation.clear();
                editcreditcard.onScannerFinished(hashmap);
            } else
            if (j == 0)
            {
                editcreditcard.onScannerCanceled();
                return;
            }
        }
    }

    public boolean isOn()
    {
        return true;
    }

    public void startScannerActivity(EditCreditCard editcreditcard)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList(CreditCardType.values().length);
        CreditCardType acreditcardtype[] = CreditCardType.values();
        for (int j = acreditcardtype.length; i < j; i++)
        {
            arraylist.add(acreditcardtype[i]);
        }

        try
        {
            sdk = new NetswipeSDK(editcreditcard, "56084d44-836a-4cf5-bc02-d67c28402a7c", "BfJv8R44Aa1Ls9zyXW55BOkQDPBKjAX6");
            sdk.setSupportedCreditCardTypes(arraylist);
            sdk.setSortCodeAndAccountNumberRequired(false);
            sdk.setManualEntryEnabled(false);
            sdk.setExpiryRequired(true);
            sdk.setCardHolderNameRequired(true);
            sdk.setCardHolderNameEditable(true);
            sdk.setCvvRequired(true);
            sdk.setVibrationEffectEnabled(true);
            editcreditcard.onSdkInitialized();
        }
        // Misplaced declaration of an exception variable
        catch (EditCreditCard editcreditcard)
        {
            Ln.e(editcreditcard);
        }
        sdk.start();
    }
}
