// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            OfferUpBoolean, Store

public class Profile
{

    private int active;
    private String avatar;
    private String avatarSquare;
    private int credits;
    private int dealSpringer;
    private String email;
    private String firstName;
    private OfferUpBoolean hasReceivedFirstPayout;
    private int id;
    private String lastName;
    private String notification;
    private OfferUpBoolean paymentEnabled;
    private Store store;
    private boolean termsAccepted;
    private String token;
    private String username;
    private String verificationStatus;

    public Profile()
    {
    }

    public int getActive()
    {
        return active;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String getAvatarSquare()
    {
        return avatarSquare;
    }

    public int getCredits()
    {
        return credits;
    }

    public int getDeal_springer()
    {
        return dealSpringer;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public int getId()
    {
        return id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getNotification()
    {
        return notification;
    }

    public boolean getPaymentEnabled()
    {
        if (paymentEnabled == null)
        {
            return false;
        } else
        {
            return paymentEnabled.value;
        }
    }

    public Store getStore()
    {
        return store;
    }

    public String getToken()
    {
        return token;
    }

    public String getUsername()
    {
        return username;
    }

    public String getVerification_status()
    {
        return verificationStatus;
    }

    public boolean hasReceivedFirstPayout()
    {
        if (hasReceivedFirstPayout == null)
        {
            return false;
        } else
        {
            return hasReceivedFirstPayout.value;
        }
    }

    public boolean isTermsAccepted()
    {
        return termsAccepted;
    }

    public void setActive(int i)
    {
        active = i;
    }

    public void setAvatar(String s)
    {
        avatar = s;
    }

    public void setCredits(int i)
    {
        credits = i;
    }

    public void setDeal_springer(int i)
    {
        dealSpringer = i;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setNotification(String s)
    {
        notification = s;
    }

    public void setStore(Store store1)
    {
        store = store1;
    }

    public void setToken(String s)
    {
        token = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }

    public void setVerification_status(String s)
    {
        verificationStatus = s;
    }

    public String toString()
    {
        return (new StringBuilder("Profile [username=")).append(username).append(", verificationStatus=").append(verificationStatus).append(", firstName=").append(firstName).append(", notification=").append(notification).append(", dealSpringer=").append(dealSpringer).append(", credits=").append(credits).append(", token=").append(token).append(", email=").append(email).append(", avatar=").append(avatar).append(", lastName=").append(lastName).append(", active=").append(active).append(", id=").append(id).append(", store=").append(store).append("]").toString();
    }
}
