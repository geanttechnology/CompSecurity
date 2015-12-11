// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.registry:
//            Recipient

public class WeddingRegistryData
    implements Serializable
{

    public String addDescription;
    public String addressFirstName;
    public String addressLastName;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String coregistrantFirstName;
    public String coregistrantLastName;
    public String createdBy;
    public String eventCity;
    public String eventDate;
    public String eventLocation;
    public String eventState;
    public String firstName;
    public String lastModifiedBy;
    public String lastName;
    private String listType;
    public String modified;
    private boolean myregistry;
    private String personalized_message;
    public String phone;
    private String privacySetting;
    private Recipient recepientInfo;
    private String recepientUuid;
    public String registryName;
    private String shippingAddress;
    public String state;
    private boolean theKnot;
    public String uuid;
    public String zipCode;

    public WeddingRegistryData()
    {
    }

    public String getAddDescription()
    {
        return addDescription;
    }

    public String getAddressFirstName()
    {
        return addressFirstName;
    }

    public String getAddressLastName()
    {
        return addressLastName;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public String getCity()
    {
        return city;
    }

    public String getCoRegistrantFirstName()
    {
        return coregistrantFirstName;
    }

    public String getCoRegistrantLastName()
    {
        return coregistrantLastName;
    }

    public String getCoregistrantFirstName()
    {
        return coregistrantFirstName;
    }

    public String getCoregistrantLastName()
    {
        return coregistrantLastName;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public String getEventCity()
    {
        return eventCity;
    }

    public String getEventDate()
    {
        return eventDate;
    }

    public String getEventLocation()
    {
        return eventLocation;
    }

    public String getEventState()
    {
        return eventState;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getListType()
    {
        return listType;
    }

    public String getModified()
    {
        return modified;
    }

    public String getModifiedDetails()
    {
        return modified;
    }

    public String getPersonalized_message()
    {
        return personalized_message;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getPrivacySetting()
    {
        return privacySetting;
    }

    public Recipient getRecepient()
    {
        return recepientInfo;
    }

    public String getRecepientUuid()
    {
        return recepientUuid;
    }

    public String getRegistryName()
    {
        return registryName;
    }

    public String getShippingAddress()
    {
        return shippingAddress;
    }

    public String getState()
    {
        return state;
    }

    public String getUuid()
    {
        return uuid;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public boolean isMyregistry()
    {
        return myregistry;
    }

    public boolean isTheKnot()
    {
        return theKnot;
    }

    public void setAddDescription(String s)
    {
        addDescription = s;
    }

    public void setAddressFirstName(String s)
    {
        addressFirstName = s;
    }

    public void setAddressLastName(String s)
    {
        addressLastName = s;
    }

    public void setAddressLine1(String s)
    {
        addressLine1 = s;
    }

    public void setAddressLine2(String s)
    {
        addressLine2 = s;
    }

    public void setCity(String s)
    {
        city = s;
    }

    public void setCoRegistrantFirstName(String s)
    {
        coregistrantFirstName = s;
    }

    public void setCoRegistrantLastName(String s)
    {
        coregistrantLastName = s;
    }

    public void setCoregistrantFirstName(String s)
    {
        coregistrantFirstName = s;
    }

    public void setCoregistrantLastName(String s)
    {
        coregistrantLastName = s;
    }

    public void setCreatedBy(String s)
    {
        createdBy = s;
    }

    public void setEventCity(String s)
    {
        eventCity = s;
    }

    public void setEventDate(String s)
    {
        eventDate = s;
    }

    public void setEventLocation(String s)
    {
        eventLocation = s;
    }

    public void setEventState(String s)
    {
        eventState = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setLastModifiedBy(String s)
    {
        lastModifiedBy = s;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setListType(String s)
    {
        listType = s;
    }

    public void setModified(String s)
    {
        modified = s;
    }

    public void setModifiedDetails(String s)
    {
        modified = s;
    }

    public void setMyregistry(boolean flag)
    {
        myregistry = flag;
    }

    public void setPersonalized_message(String s)
    {
        personalized_message = s;
    }

    public void setPhone(String s)
    {
        phone = s;
    }

    public void setPrivacySetting(String s)
    {
        privacySetting = s;
    }

    public void setRecepient(Recipient recipient)
    {
        recepientInfo = recipient;
    }

    public void setRecepientUuid(String s)
    {
        recepientUuid = s;
    }

    public void setRegistryName(String s)
    {
        registryName = s;
    }

    public void setShippingAddress(String s)
    {
        shippingAddress = s;
    }

    public void setState(String s)
    {
        state = s;
    }

    public void setTheKnot(boolean flag)
    {
        theKnot = flag;
    }

    public void setUuid(String s)
    {
        uuid = s;
    }

    public void setZipCode(String s)
    {
        zipCode = s;
    }
}
