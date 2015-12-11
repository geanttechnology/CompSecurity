// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.net.Uri;
import com.groupon.http.NameValuePair;
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.order.Order;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.HttpUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class Secure3DPurchase extends ECommercePurchase
{

    public static final int REQUEST_CODE = 10123;
    CurrentCountryManager currentCountryManager;
    CurrentCountryService currentCountryService;
    private LoginService loginService;

    public Secure3DPurchase()
    {
    }

    private String addClientIdQueryParam(String s)
    {
        s = new com.groupon.http.Uris.Builder((new StringBuilder()).append(s).append("/").toString());
        s.appendQueryParameter("client_id", "b9ab4fb791ccb18cac3a83c999a9d559");
        return s.build().toString();
    }

    protected boolean doExtraValidation(String s)
    {
        try
        {
            s = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s);
            return false;
        }
        if (!Strings.isEmpty(s.getQuery()))
        {
            s = HttpUtil.extractNameValuePairs(s).iterator();
            while (s.hasNext()) 
            {
                if (Strings.equalsIgnoreCase(((NameValuePair)s.next()).name, "success"))
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected List getNameValuePairs(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s2 = (String)iterator.next();
            String s1 = (String)hashmap.get(s2);
            if (Strings.notEmpty(s1))
            {
                String s = s1;
                if (Strings.equalsIgnoreCase(s2, "TermUrl"))
                {
                    s = addClientIdQueryParam(s1);
                }
                arraylist.add(new NameValuePair(s2, s));
            }
        } while (true);
        return arraylist;
    }

    protected String getResUrl()
    {
        return (new StringBuilder()).append(termUrl3dsecure).append("/?").toString();
    }

    protected void setResUrl()
    {
        Iterator iterator = super.getNameValuePairs(order.billingRecord.formParameters).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            if (!Strings.equalsIgnoreCase(namevaluepair.name, "TermUrl"))
            {
                continue;
            }
            termUrl3dsecure = namevaluepair.value;
            break;
        } while (true);
        if (!Strings.isEmpty(termUrl3dsecure))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        String s = currentCountryService.getBaseUrl(currentCountryManager.getCurrentCountry()).replace("http://", "https://");
        String s1 = order.id;
        String s2 = order.billingRecord.paymentType;
        termUrl3dsecure = String.format("%s/users/%s/orders/%s/%s/completeByPost", new Object[] {
            s, loginService.getUserId(), s1, s2
        });
        return;
        CountryNotSupportedException countrynotsupportedexception;
        countrynotsupportedexception;
    }
}
