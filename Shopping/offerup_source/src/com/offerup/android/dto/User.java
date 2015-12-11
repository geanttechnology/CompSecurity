// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            OfferUpBoolean, BackgroundImage, Rating

public class User
{

    boolean addedCard;
    String avatarLarge;
    String avatarSquare;
    BackgroundImage backgroundImage;
    boolean cardOnFile;
    a dateJoined;
    String email;
    String facebookId;
    a firstItemPosted;
    a firstMessageSent;
    String firstName;
    a firstPayoutMade;
    a firstPayoutReceived;
    int id;
    boolean itemsArchived;
    boolean itemsAutoArchived;
    String lastName;
    boolean paymentEnabled;
    String publicLocationName;
    Rating rating;
    boolean termsAccepted;
    String token;
    long userId;
    boolean usesDefaultAvatar;
    int verificationStatus;
    boolean verifiedUser;

    public User()
    {
    }

    public String getAvatarLarge()
    {
        return avatarLarge;
    }

    public String getAvatarSquare()
    {
        return avatarSquare;
    }

    public BackgroundImage getBackgroundImage()
    {
        return backgroundImage;
    }

    public a getDateJoined()
    {
        return dateJoined;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFacebookId()
    {
        return facebookId;
    }

    public a getFirstItemPosted()
    {
        return firstItemPosted;
    }

    public a getFirstMessageSent()
    {
        return firstMessageSent;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public a getFirstPayoutMade()
    {
        return firstPayoutMade;
    }

    public a getFirstPayoutReceived()
    {
        return firstPayoutReceived;
    }

    public int getId()
    {
        return id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPublicLocationName()
    {
        return publicLocationName;
    }

    public Rating getRating()
    {
        return rating;
    }

    public String getToken()
    {
        return token;
    }

    public long getUserId()
    {
        return userId;
    }

    public int getVerificationStatus()
    {
        return verificationStatus;
    }

    public boolean hasAddedCard()
    {
        return addedCard;
    }

    public boolean isCardOnFile()
    {
        return cardOnFile;
    }

    public boolean isItemsArchived()
    {
        return itemsArchived;
    }

    public boolean isItemsAutoArchived()
    {
        return itemsAutoArchived;
    }

    public boolean isPaymentEnabled()
    {
        return paymentEnabled;
    }

    public boolean isTermsAccepted()
    {
        return termsAccepted;
    }

    public boolean isUsingDefaultAvatar()
    {
        return usesDefaultAvatar;
    }

    public boolean isVerifiedUser()
    {
        return verifiedUser;
    }

    public void setAddedCard(boolean flag)
    {
        addedCard = flag;
    }

    public void setAvatarLarge(String s)
    {
        avatarLarge = s;
    }

    public void setAvatarSquare(String s)
    {
        avatarSquare = s;
    }

    public void setCardOnFile(boolean flag)
    {
        cardOnFile = flag;
    }

    public void setDateJoined(a a)
    {
        dateJoined = a;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setFacebookId(String s)
    {
        facebookId = s;
    }

    public void setFirstItemPosted(a a)
    {
        firstItemPosted = a;
    }

    public void setFirstMessageSent(a a)
    {
        firstMessageSent = a;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setFirstPayoutMade(a a)
    {
        firstPayoutMade = a;
    }

    public void setFirstPayoutReceived(a a)
    {
        firstPayoutReceived = a;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setItemsArchived(boolean flag)
    {
        itemsArchived = flag;
    }

    public void setItemsAutoArchived(boolean flag)
    {
        itemsAutoArchived = flag;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setPaymentEnabled(OfferUpBoolean offerupboolean)
    {
        boolean flag;
        if (offerupboolean != null)
        {
            flag = offerupboolean.value;
        } else
        {
            flag = false;
        }
        paymentEnabled = flag;
    }

    public void setPublicLocationName(String s)
    {
        publicLocationName = s;
    }

    public void setRating(Rating rating1)
    {
        rating = rating1;
    }

    public void setTermsAccepted(boolean flag)
    {
        termsAccepted = flag;
    }

    public void setToken(String s)
    {
        token = s;
    }

    public void setUserBackgroundImage(BackgroundImage backgroundimage)
    {
        backgroundImage = backgroundimage;
    }

    public void setUserId(long l)
    {
        userId = l;
    }

    public void setUsingDefaultAvatar(boolean flag)
    {
        usesDefaultAvatar = flag;
    }

    public void setVerificationStatus(int i)
    {
        verificationStatus = i;
    }

    public void setVerifiedUser(boolean flag)
    {
        verifiedUser = flag;
    }
}
