// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.mybby:
//            AccountInfo, Points, Certificate

public class Profile
{

    private AccountInfo accountInfo;
    private ArrayList certs;
    private Points points;

    public Profile()
    {
    }

    public static Profile loadData(JSONObject jsonobject)
    {
        Profile profile = new Profile();
        profile.accountInfo = AccountInfo.loadData(jsonobject.optJSONObject("accountInfo"));
        profile.points = Points.loadData(jsonobject.optJSONObject("points"));
        jsonobject = jsonobject.optJSONObject("certs").optJSONArray("certificates");
        profile.certs = new ArrayList();
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                Certificate certificate = Certificate.loadData(jsonobject.optJSONObject(i));
                profile.certs.add(certificate);
            }

        }
        return profile;
    }

    public AccountInfo getAccountInfo()
    {
        return accountInfo;
    }

    public String getCertTotal()
    {
        int i = 0;
        int j = 0;
        for (; i < certs.size(); i++)
        {
            j += Integer.valueOf(((Certificate)certs.get(i)).getAmount()).intValue();
        }

        return String.valueOf(j);
    }

    public ArrayList getCertificates()
    {
        return certs;
    }

    public Points getPoints()
    {
        return points;
    }
}
