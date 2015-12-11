// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;

public class Address
{

    private String city;
    private String name;
    private String phone;
    private String state;
    private String street;
    private String street2;
    private String type;
    private String zip;

    public Address()
    {
    }

    public void copy(Address address)
    {
        if (address != null)
        {
            name = address.name;
            street = address.street;
            street2 = address.street2;
            city = address.city;
            state = address.state;
            zip = address.zip;
            phone = address.phone;
            type = address.type;
        }
    }

    public String getCity()
    {
        return city;
    }

    public String getJsonString()
    {
        Gson gson = (new GsonBuilder()).create();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(this, com/poshmark/data_model/models/inner_models/Address);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, this, com/poshmark/data_model/models/inner_models/Address);
        }
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getState()
    {
        return state;
    }

    public String getStreet()
    {
        return street;
    }

    public String getStreet2()
    {
        return street2;
    }

    public String getType()
    {
        return type;
    }

    public String getZip()
    {
        return zip;
    }

    public boolean isDataAvailable()
    {
        boolean flag = true;
        if (name == null || street == null || city == null || state == null || zip == null)
        {
            flag = false;
        }
        return flag;
    }

    public boolean isSameAs(Address address)
    {
_L2:
        return false;
        if (address == null || !street.toLowerCase().equals(address.street.toLowerCase()) || !city.toLowerCase().equals(address.city.toLowerCase()) || !state.toLowerCase().equals(address.state.toLowerCase()) || !zip.toLowerCase().equals(address.zip.toLowerCase())) goto _L2; else goto _L1
_L1:
        if (street2 == null || address.street2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!street2.toLowerCase().equals(address.street2.toLowerCase()))
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        return true;
        if (street2 == null && address.street2 != null) goto _L2; else goto _L3
_L3:
        if (street2 != null && address.street2 == null)
        {
            return false;
        }
          goto _L4
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setCity(String s)
    {
        city = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPhone(String s)
    {
        phone = s;
    }

    public void setState(String s)
    {
        state = s;
    }

    public void setStreet(String s)
    {
        street = s;
    }

    public void setStreet2(String s)
    {
        street2 = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setZip(String s)
    {
        zip = s;
    }
}
