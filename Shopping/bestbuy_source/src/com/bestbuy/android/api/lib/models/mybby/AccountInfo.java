// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import gs;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.mybby:
//            Address, PhoneNumber

public class AccountInfo
{

    private static final String TAG = com/bestbuy/android/api/lib/models/mybby/AccountInfo.getSimpleName();
    private String accountId;
    private ArrayList addresses;
    private String category;
    private String categoryDescription;
    private String certPreferenceCategory;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String partyId;
    private ArrayList phoneNumbers;
    private String typeCode;

    public AccountInfo()
    {
    }

    public static AccountInfo loadData(JSONObject jsonobject)
    {
        AccountInfo accountinfo;
        boolean flag = false;
        accountinfo = new AccountInfo();
        JSONArray jsonarray;
        int i;
        try
        {
            accountinfo.accountId = jsonobject.optString("accountId");
            accountinfo.partyId = jsonobject.optString("partyId");
            accountinfo.typeCode = jsonobject.optString("typeCode");
            accountinfo.category = jsonobject.optString("statusCode");
            accountinfo.categoryDescription = jsonobject.optString("categoryDescription");
            accountinfo.firstName = jsonobject.optString("firstName");
            accountinfo.firstName = (new StringBuilder()).append(accountinfo.getFirstName().substring(0, 1).toUpperCase()).append(accountinfo.getFirstName().substring(1).toLowerCase()).toString();
            accountinfo.lastName = jsonobject.optString("lastName");
            accountinfo.lastName = (new StringBuilder()).append(accountinfo.getLastName().substring(0, 1).toUpperCase()).append(accountinfo.getLastName().substring(1).toLowerCase()).toString();
            accountinfo.certPreferenceCategory = jsonobject.optString("certPreferenceCategory");
            accountinfo.emailAddress = jsonobject.optJSONArray("emails").optJSONObject(0).optString("emailAddress");
            accountinfo.addresses = new ArrayList();
            jsonarray = jsonobject.optJSONArray("addresses");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            gs.d(TAG, (new StringBuilder()).append("Error Parsing RewardZone AccountInfo: ").append(jsonobject.getLocalizedMessage()).toString());
            throw jsonobject;
        }
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() <= 0) goto _L2; else goto _L3
_L3:
        i = 0;
_L4:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        accountinfo.addresses.add(Address.loadData(jsonarray.optJSONObject(i)));
        i++;
        if (true) goto _L4; else goto _L2
_L2:
        accountinfo.phoneNumbers = new ArrayList();
        jsonobject = jsonobject.optJSONArray("phones");
        if (jsonobject == null) goto _L6; else goto _L5
_L5:
        if (jsonobject.length() <= 0) goto _L6; else goto _L7
_L7:
        i = ((flag) ? 1 : 0);
_L8:
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        accountinfo.phoneNumbers.add(PhoneNumber.loadData(jsonobject.optJSONObject(i)));
        i++;
        if (true) goto _L8; else goto _L6
_L6:
        return accountinfo;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public ArrayList getAddresses()
    {
        return addresses;
    }

    public String getCategory()
    {
        return category;
    }

    public String getCategoryDescription()
    {
        return categoryDescription;
    }

    public String getCertPreferenceCategory()
    {
        return certPreferenceCategory;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPartyId()
    {
        return partyId;
    }

    public ArrayList getPhoneNumbers()
    {
        return phoneNumbers;
    }

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setCertPreferenceCategory(String s)
    {
        certPreferenceCategory = s;
    }

}
