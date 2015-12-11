// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Recipient
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String addressCity;
    private String addressLine1;
    private String addressLine2;
    private String addressState;
    private String addressZip;
    private String alias;
    private String country;
    private long created;
    private String emailAddress;
    private String firstName;
    private String isMobilePhoneNumber;
    private String lastName;
    private long modified;
    private String name;
    private String parentRef;
    private String parentType;
    private String parentUuid;
    private String phoneNumber;
    private String phoneNumberType;
    private boolean transientFlag;
    private String type;
    private String uuid;

    public Recipient()
    {
    }

    public static ArrayList parseRecipientResponse(JSONObject jsonobject)
    {
        ArrayList arraylist = new ArrayList();
        jsonobject = jsonobject.optJSONArray("entities");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                JSONObject jsonobject1 = jsonobject.optJSONObject(i);
                if (jsonobject1 == null)
                {
                    continue;
                }
                Recipient recipient = new Recipient();
                recipient.uuid = jsonobject1.optString("uuid");
                recipient.type = jsonobject1.optString("type");
                recipient.alias = jsonobject1.optString("alias");
                recipient.addressCity = jsonobject1.optString("address-city");
                recipient.addressLine1 = jsonobject1.optString("address-line1");
                recipient.addressLine2 = jsonobject1.optString("address-line2");
                recipient.addressState = jsonobject1.optString("address-state");
                recipient.addressZip = jsonobject1.optString("address-zip");
                recipient.country = jsonobject1.optString("country");
                recipient.emailAddress = jsonobject1.optString("email-address");
                recipient.firstName = jsonobject1.optString("first-name");
                recipient.lastName = jsonobject1.optString("last-name");
                recipient.isMobilePhoneNumber = jsonobject1.optString("is-mobile-phone-number");
                recipient.name = jsonobject1.optString("name");
                recipient.parentRef = jsonobject1.optString("parentRef");
                recipient.phoneNumber = jsonobject1.optString("phone-number");
                recipient.phoneNumberType = jsonobject1.optString("phone-number-type");
                JSONObject jsonobject2 = jsonobject1.optJSONObject("parent");
                if (jsonobject2 != null)
                {
                    recipient.parentType = jsonobject2.optString("type");
                    recipient.parentUuid = jsonobject2.optString("uuid");
                }
                recipient.created = jsonobject1.optLong("created");
                recipient.modified = jsonobject1.optLong("modified");
                recipient.transientFlag = jsonobject1.optBoolean("transient");
                arraylist.add(recipient);
            }

        }
        return arraylist;
    }

    public String getAddressCity()
    {
        return addressCity;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public String getAddressState()
    {
        return addressState;
    }

    public String getAddressZip()
    {
        return addressZip;
    }

    public String getAlias()
    {
        return alias;
    }

    public String getCountry()
    {
        return country;
    }

    public long getCreated()
    {
        return created;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getIsMobilePhoneNumber()
    {
        return isMobilePhoneNumber;
    }

    public String getLastName()
    {
        return lastName;
    }

    public long getModified()
    {
        return modified;
    }

    public String getName()
    {
        return name;
    }

    public String getParentRef()
    {
        return parentRef;
    }

    public String getParentType()
    {
        return parentType;
    }

    public String getParentUuid()
    {
        return parentUuid;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getPhoneNumberType()
    {
        return phoneNumberType;
    }

    public String getType()
    {
        return type;
    }

    public String getUuid()
    {
        return uuid;
    }

    public boolean isTransientFlag()
    {
        return transientFlag;
    }

    public void setAddressCity(String s)
    {
        addressCity = s;
    }

    public void setAddressLine1(String s)
    {
        addressLine1 = s;
    }

    public void setAddressLine2(String s)
    {
        addressLine2 = s;
    }

    public void setAddressState(String s)
    {
        addressState = s;
    }

    public void setAddressZip(String s)
    {
        addressZip = s;
    }

    public void setPhoneNumber(String s)
    {
        phoneNumber = s;
    }
}
