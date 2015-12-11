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

    private static final long serialVersionUID = 1L;
    private String spclOfferName;
    private String spclOfferTarget;
    private String spclOfferUrl;

    public static ArrayList loadSpecialOffersData(JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L3:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        if (jsonobject != null)
        {
            try
            {
                  = new <init>();
                .spclOfferName = jsonobject.optString("name");
                .spclOfferTarget = jsonobject.optString("target");
                .spclOfferUrl = jsonobject.optString("url");
                arraylist.add();
            }
            catch (Exception exception)
            {
                gs.d(BuyingOptions.access$000(), (new StringBuilder()).append("Couldn't parse Special Offers data: ").append(exception.getLocalizedMessage()).toString());
            }
        }
        i++;
          goto _L3
_L2:
        return arraylist;
    }

    public String getSpclOfferName()
    {
        return spclOfferName;
    }

    public String getSpclOfferTarget()
    {
        return spclOfferTarget;
    }

    public String getSpclOfferUrl()
    {
        return spclOfferUrl;
    }

    public ()
    {
    }
}
