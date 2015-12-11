// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.registry:
//            Recipient

public class RegistryWishList
    implements Serializable, Comparable
{

    private static final long serialVersionUID = 1L;
    private String alias;
    private String baseType;
    private String city;
    private String coRegistrantFirstName;
    private String coRegistrantLastName;
    private long created;
    private String createdBy;
    private String createdOnChannel;
    private String description;
    private long effectiveTTL;
    private String firstName;
    private String firstUrl;
    private String lastName;
    private String lastUpdatedBy;
    private String lastUrl;
    private String location;
    private long modified;
    private boolean myRegistry;
    private String name;
    private String nextUrl;
    private String occasionDate;
    private String personalizedMessage;
    private String prevUrl;
    private String privacySetting;
    private Recipient recipient;
    private ArrayList recipientList;
    private ArrayList registryWishlistArray;
    private String retailListAlias;
    private String schoolName;
    private String shippingAddress;
    private String shortDescription;
    private String state;
    private String tags;
    private boolean theKnot;
    private boolean transientFlag;
    private String type;
    private String uuid;

    public RegistryWishList()
    {
    }

    public static RegistryWishList parseRegistryWishListData(JSONObject jsonobject)
    {
        RegistryWishList registrywishlist = new RegistryWishList();
        if (jsonobject != null)
        {
            registrywishlist.uuid = jsonobject.optString("uuid", "");
            registrywishlist.type = jsonobject.optString("type", "");
            if (!registrywishlist.type.endsWith("s"))
            {
                registrywishlist.type = (new StringBuilder()).append(registrywishlist.type).append("s").toString();
            }
            registrywishlist.created = jsonobject.optLong("created");
            registrywishlist.modified = jsonobject.optLong("modified");
            registrywishlist.transientFlag = jsonobject.optBoolean("transient", false);
            registrywishlist.baseType = jsonobject.optString("base-type", "");
            registrywishlist.alias = jsonobject.optString("alias", "");
            registrywishlist.createdBy = jsonobject.optString("created-by", "");
            registrywishlist.lastUpdatedBy = jsonobject.optString("last-updated-by", "");
            registrywishlist.name = jsonobject.optString("name", "");
            registrywishlist.createdOnChannel = jsonobject.optString("created-on-channel", "");
            registrywishlist.occasionDate = jsonobject.optString("occasion-date", "");
            registrywishlist.personalizedMessage = jsonobject.optString("personalized-message", "");
            registrywishlist.privacySetting = jsonobject.optString("privacy-setting", "");
            registrywishlist.shortDescription = jsonobject.optString("short-description", "");
            registrywishlist.description = jsonobject.optString("description", "");
            registrywishlist.tags = jsonobject.optString("tags", "");
            registrywishlist.effectiveTTL = jsonobject.optLong("effectiveTTL");
            JSONObject jsonobject1 = jsonobject.optJSONObject("occasion-notes");
            if (jsonobject1 != null)
            {
                registrywishlist.location = jsonobject1.optString("location", "");
                registrywishlist.city = jsonobject1.optString("city", "");
                registrywishlist.state = jsonobject1.optString("state", "");
            }
            jsonobject1 = jsonobject.optJSONObject("list-notes");
            if (jsonobject1 != null)
            {
                registrywishlist.firstName = jsonobject1.optString("first-name", "");
                registrywishlist.lastName = jsonobject1.optString("last-name", "");
            }
            registrywishlist.coRegistrantFirstName = jsonobject.optString("co-registrant-first-name", "");
            registrywishlist.coRegistrantLastName = jsonobject.optString("co-registrant-last-name", "");
            registrywishlist.retailListAlias = jsonobject.optString("retail-list-alias", "");
        }
        return registrywishlist;
    }

    public int compareTo(RegistryWishList registrywishlist)
    {
        return created - registrywishlist.getCreated() <= 0L ? 1 : -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RegistryWishList)obj);
    }

    public String getAlias()
    {
        return alias;
    }

    public String getBaseType()
    {
        return baseType;
    }

    public String getCity()
    {
        return city;
    }

    public String getCoRegistrantFirstName()
    {
        return coRegistrantFirstName;
    }

    public String getCoRegistrantLastName()
    {
        return coRegistrantLastName;
    }

    public long getCreated()
    {
        return created;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public String getCreatedOnChannel()
    {
        return createdOnChannel;
    }

    public String getDescription()
    {
        return description;
    }

    public long getEffectiveTTL()
    {
        return effectiveTTL;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getFirstUrl()
    {
        return firstUrl;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getLastUpdatedBy()
    {
        return lastUpdatedBy;
    }

    public String getLastUrl()
    {
        return lastUrl;
    }

    public String getLocation()
    {
        return location;
    }

    public long getModified()
    {
        return modified;
    }

    public String getName()
    {
        return name;
    }

    public String getNextUrl()
    {
        return nextUrl;
    }

    public String getOccasionDate()
    {
        return occasionDate;
    }

    public String getPersonalizedMessage()
    {
        return personalizedMessage;
    }

    public String getPrevUrl()
    {
        return prevUrl;
    }

    public String getPrivacySetting()
    {
        return privacySetting;
    }

    public Recipient getRecipient()
    {
        return recipient;
    }

    public ArrayList getRecipientList()
    {
        return recipientList;
    }

    public ArrayList getRegistryWishlistArray()
    {
        return registryWishlistArray;
    }

    public String getRetailListAlias()
    {
        return retailListAlias;
    }

    public String getSchoolName()
    {
        return schoolName;
    }

    public String getShippingAddress()
    {
        return shippingAddress;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getState()
    {
        return state;
    }

    public String getTags()
    {
        return tags;
    }

    public String getType()
    {
        return type;
    }

    public String getUuid()
    {
        return uuid;
    }

    public boolean isMyRegistry()
    {
        return myRegistry;
    }

    public boolean isTheKnot()
    {
        return theKnot;
    }

    public boolean isTransientFlag()
    {
        return transientFlag;
    }

    public void setAlias(String s)
    {
        alias = s;
    }

    public void setBaseType(String s)
    {
        baseType = s;
    }

    public void setCity(String s)
    {
        city = s;
    }

    public void setCoRegistrantFirstName(String s)
    {
        coRegistrantFirstName = s;
    }

    public void setCoRegistrantLastName(String s)
    {
        coRegistrantLastName = s;
    }

    public void setCreated(long l)
    {
        created = l;
    }

    public void setCreatedBy(String s)
    {
        createdBy = s;
    }

    public void setCreatedOnChannel(String s)
    {
        createdOnChannel = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setEffectiveTTL(long l)
    {
        effectiveTTL = l;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setFirstUrl(String s)
    {
        firstUrl = s;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setLastUpdatedBy(String s)
    {
        lastUpdatedBy = s;
    }

    public void setLastUrl(String s)
    {
        lastUrl = s;
    }

    public void setLocation(String s)
    {
        location = s;
    }

    public void setModified(long l)
    {
        modified = l;
    }

    public void setMyRegistry(boolean flag)
    {
        myRegistry = flag;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setNextUrl(String s)
    {
        nextUrl = s;
    }

    public void setOccasionDate(String s)
    {
        occasionDate = s;
    }

    public void setPersonalizedMessage(String s)
    {
        personalizedMessage = s;
    }

    public void setPrevUrl(String s)
    {
        prevUrl = s;
    }

    public void setPrivacySetting(String s)
    {
        privacySetting = s;
    }

    public void setRecipient(Recipient recipient1)
    {
        recipient = recipient1;
    }

    public void setRecipientList(ArrayList arraylist)
    {
        recipientList = arraylist;
    }

    public void setRegistryWishlistArray(ArrayList arraylist)
    {
        registryWishlistArray = arraylist;
    }

    public void setRetailListAlias(String s)
    {
        retailListAlias = s;
    }

    public void setSchoolName(String s)
    {
        schoolName = s;
    }

    public void setShippingAddress(String s)
    {
        shippingAddress = s;
    }

    public void setShortDescription(String s)
    {
        shortDescription = s;
    }

    public void setState(String s)
    {
        state = s;
    }

    public void setTags(String s)
    {
        tags = s;
    }

    public void setTheKnot(boolean flag)
    {
        theKnot = flag;
    }

    public void setTransientFlag(boolean flag)
    {
        transientFlag = flag;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUuid(String s)
    {
        uuid = s;
    }
}
