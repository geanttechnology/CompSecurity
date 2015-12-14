// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountDetails
{
    public static class Benefit
    {

        public boolean active;
        public boolean available;
        public String benefitID;
        public long expiration;

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof Benefit))
            {
                if (available == ((Benefit) (obj = (Benefit)obj)).available && active == ((Benefit) (obj)).active && benefitID.equals(((Benefit) (obj)).benefitID) && expiration == ((Benefit) (obj)).expiration)
                {
                    return true;
                }
            }
            return false;
        }

        Benefit(JSONObject jsonobject)
        {
            active = jsonobject.optBoolean("active");
            available = jsonobject.optBoolean("available");
            benefitID = jsonobject.optString("benefitId");
            expiration = jsonobject.optLong("expiration");
        }
    }


    private String JSONString;
    private List benefits;
    private boolean photosBenefitAvailable;
    private boolean videosBenefitAvailable;

    public AccountDetails(JSONObject jsonobject)
        throws JSONException
    {
        JSONString = jsonobject.toString();
        benefits = new ArrayList();
        if (jsonobject.getJSONObject("primeStatus") != null)
        {
            photosBenefitAvailable = jsonobject.optBoolean("photoBenefitAvailable");
            videosBenefitAvailable = jsonobject.optBoolean("videoBenefitAvailable");
        }
        jsonobject = jsonobject.getJSONArray("benefits");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                benefits.add(new Benefit((JSONObject)jsonobject.get(i)));
            }

        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof AccountDetails))
        {
            if (((AccountDetails) (obj = (AccountDetails)obj)).photosBenefitAvailable == photosBenefitAvailable && ((AccountDetails) (obj)).videosBenefitAvailable == videosBenefitAvailable && benefits.equals(((AccountDetails) (obj)).benefits))
            {
                return true;
            }
        }
        return false;
    }

    public String getSerializedString()
    {
        return JSONString;
    }

    public boolean hasBenefit(String s)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < benefits.size())
                {
                    Benefit benefit = (Benefit)benefits.get(i);
                    if (!benefit.benefitID.equals(s))
                    {
                        break label0;
                    }
                    flag = flag1;
                    if (benefit.active)
                    {
                        flag = true;
                    }
                }
                return flag;
            }
            i++;
        } while (true);
    }
}
