// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import b.a.a;
import com.offerup.android.dto.BackgroundImage;
import com.offerup.android.dto.OfferUpBoolean;
import com.offerup.android.dto.Rating;

public class 
{

    boolean addedCard;
    String avatarLarge;
    String avatarSquare;
    BackgroundImage backgroundImage;
    boolean cardOnFile;
    String facebookId;
    a firstItemPosted;
    a firstMessageSent;
    a firstPayoutMade;
    a firstPayoutReceived;
    boolean itemsArchived;
    boolean itemsAutoArchived;
    OfferUpBoolean paymentEnabled;
    String publicLocationName;
    Rating rating;
    boolean termsAccepted;
    int userId;
    boolean usesDefaultAvatar;
    int verificationStatus;
    OfferUpBoolean verified;

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

    public a getFirstPayoutMade()
    {
        return firstPayoutMade;
    }

    public a getFirstPayoutReceived()
    {
        return firstPayoutReceived;
    }

    public OfferUpBoolean getPaymentEnabled()
    {
        return paymentEnabled;
    }

    public String getPublicLocationName()
    {
        return publicLocationName;
    }

    public Rating getRating()
    {
        return rating;
    }

    public int getUserId()
    {
        return userId;
    }

    public int getVerificationStatus()
    {
        return verificationStatus;
    }

    public OfferUpBoolean getVerifiedUser()
    {
        return verified;
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

    public boolean isTermsAccepted()
    {
        return termsAccepted;
    }

    public boolean isUsingDefaultAvatar()
    {
        return usesDefaultAvatar;
    }

    public ()
    {
    }
}
