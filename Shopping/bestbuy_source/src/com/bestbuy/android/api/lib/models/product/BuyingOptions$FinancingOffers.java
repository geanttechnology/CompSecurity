// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import gs;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.product:
//            BuyingOptions

public class 
    implements Serializable
{

    public static final long serialVersionUID = 1L;
    private String financeOfferName;
    private String financeOfferUrl;

    public static ArrayList loadFinanceOffersData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
          = new <init>();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            try
            {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                .financeOfferName = jsonobject.optString("name");
                .financeOfferUrl = jsonobject.optString("url");
                arraylist.add();
            }
            catch (Exception exception)
            {
                gs.d(BuyingOptions.access$000(), (new StringBuilder()).append("Couldn't parse Finance Offers Data: ").append(exception.getLocalizedMessage()).toString());
            }
            i++;
        }
        return arraylist;
    }

    public String getFinanceOfferName()
    {
        return financeOfferName;
    }

    public String getFinanceOfferUrl()
    {
        return financeOfferUrl;
    }

    public ()
    {
    }
}
