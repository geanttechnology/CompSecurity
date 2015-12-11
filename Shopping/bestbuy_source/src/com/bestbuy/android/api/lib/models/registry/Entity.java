// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gu;
import java.io.Serializable;

public class Entity
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String activated;
    private String certTotalAvailableValue;
    private String created;
    private String expires_in;
    private String firstName;
    private String invalidLogins;
    private String lastName;
    private String locked;
    private String lockedAt;
    private String modified;
    private String pointsBalance;
    private String postalCode;
    private String rzLinkStatus;
    private String rzMemberId;
    private String rzStatus;
    private String rzTierStatus;
    private String rzTotalCerts;
    private String rzTotalPoints;
    private String transientValue;
    private String type;
    private String username;
    private String uuid;

    public Entity()
    {
    }

    public String getActivated()
    {
        return activated;
    }

    public String getCertTotalAvailableValue()
    {
        return certTotalAvailableValue;
    }

    public String getCreated()
    {
        return created;
    }

    public String getExpires_in()
    {
        return expires_in;
    }

    public String getFirstName()
    {
        firstName = firstName.toLowerCase();
        char c = Character.toUpperCase(firstName.charAt(0));
        return (new StringBuilder()).append(c).append(firstName.substring(1)).toString();
    }

    public String getInvalidLogins()
    {
        return invalidLogins;
    }

    public String getLastName()
    {
        lastName = lastName.toLowerCase();
        char c = Character.toUpperCase(lastName.charAt(0));
        return (new StringBuilder()).append(c).append(lastName.substring(1)).toString();
    }

    public String getLocked()
    {
        return locked;
    }

    public String getLockedAt()
    {
        return lockedAt;
    }

    public String getModified()
    {
        return modified;
    }

    public String getPointsBalance()
    {
        return pointsBalance;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getRzLinkStatus()
    {
        return rzLinkStatus;
    }

    public String getRzMemberId()
    {
        return rzMemberId;
    }

    public String getRzStatus()
    {
        return rzStatus;
    }

    public String getRzTierStatus()
    {
        return rzTierStatus;
    }

    public String getRzTotalCerts()
    {
        return rzTotalCerts;
    }

    public String getRzTotalPoints()
    {
        return rzTotalPoints;
    }

    public String getTransientValue()
    {
        return transientValue;
    }

    public String getType()
    {
        return type;
    }

    public String getUsername()
    {
        return username;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setActivated(String s)
    {
        activated = s;
    }

    public void setCertTotalAvailableValue(String s)
    {
        certTotalAvailableValue = s;
    }

    public void setCreated(String s)
    {
        created = s;
    }

    public void setExpires_in(String s)
    {
        expires_in = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setInvalidLogins(String s)
    {
        invalidLogins = s;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setLocked(String s)
    {
        locked = s;
    }

    public void setLockedAt(String s)
    {
        lockedAt = s;
    }

    public void setModified(String s)
    {
        modified = s;
    }

    public void setPointsBalance(String s)
    {
        pointsBalance = s;
    }

    public void setPostalCode(String s)
    {
        postalCode = s;
    }

    public void setRzLinkStatus(String s)
    {
        rzLinkStatus = s;
    }

    public void setRzMemberId(String s)
    {
        rzMemberId = s;
    }

    public void setRzStatus(String s)
    {
        rzStatus = s;
    }

    public void setRzTierStatus(String s)
    {
        rzTierStatus = s;
    }

    public void setRzTotalCerts(String s)
    {
        rzTotalCerts = s;
    }

    public void setRzTotalPoints(String s)
    {
        rzTotalPoints = s;
    }

    public void setTransientValue(String s)
    {
        transientValue = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }

    public void setUuid(String s)
    {
        uuid = s;
    }
}
