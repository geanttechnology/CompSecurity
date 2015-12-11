// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.OfferUpBoolean;
import com.offerup.android.dto.User;

// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class UserResponse extends BaseResponse
{

    Data data;
    User user;

    public UserResponse()
    {
    }

    private void initUser()
    {
        user = new User();
        Object obj = data.getSession();
        if (obj == null)
        {
            return;
        }
        user.setToken(((Session) (obj)).getToken());
        Object obj1 = ((Session) (obj)).getFeatures();
        if (obj1 != null)
        {
            user.setPaymentEnabled(((Features) (obj1)).getPayments());
        }
        obj = ((Session) (obj)).getUser();
        user.setFirstName(((Usertemp) (obj)).getFirstName());
        user.setLastName(((Usertemp) (obj)).getLastName());
        user.setEmail(((Usertemp) (obj)).getEmail());
        user.setId(((Usertemp) (obj)).getId());
        user.setDateJoined(((Usertemp) (obj)).getDateJoined());
        obj = ((Usertemp) (obj)).getGetProfile();
        user.setFirstMessageSent(((GetProfile) (obj)).getFirstMessageSent());
        user.setAvatarLarge(((GetProfile) (obj)).getAvatarLarge());
        user.setUserId(((GetProfile) (obj)).getUserId());
        user.setPaymentEnabled(((GetProfile) (obj)).getPaymentEnabled());
        user.setFirstPayoutReceived(((GetProfile) (obj)).getFirstPayoutReceived());
        user.setFacebookId(((GetProfile) (obj)).getFacebookId());
        user.setTermsAccepted(((GetProfile) (obj)).isTermsAccepted());
        user.setFirstPayoutMade(((GetProfile) (obj)).getFirstPayoutMade());
        user.setAvatarSquare(((GetProfile) (obj)).getAvatarSquare());
        user.setFirstItemPosted(((GetProfile) (obj)).getFirstItemPosted());
        user.setVerificationStatus(((GetProfile) (obj)).getVerificationStatus());
        obj1 = user;
        boolean flag;
        if (((GetProfile) (obj)).getVerifiedUser() != null && ((GetProfile) (obj)).getVerifiedUser().value)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((User) (obj1)).setVerifiedUser(flag);
        user.setItemsArchived(((GetProfile) (obj)).isItemsArchived());
        user.setItemsAutoArchived(((GetProfile) (obj)).isItemsAutoArchived());
        user.setAddedCard(((GetProfile) (obj)).hasAddedCard());
        user.setCardOnFile(((GetProfile) (obj)).isCardOnFile());
        user.setUsingDefaultAvatar(((GetProfile) (obj)).isUsingDefaultAvatar());
        user.setRating(((GetProfile) (obj)).getRating());
        user.setPublicLocationName(((GetProfile) (obj)).getPublicLocationName());
        user.setUserBackgroundImage(((GetProfile) (obj)).getBackgroundImage());
        data = null;
    }

    public User getUser()
    {
        this;
        JVM INSTR monitorenter ;
        User user1;
        if (user == null)
        {
            initUser();
        }
        user1 = user;
        this;
        JVM INSTR monitorexit ;
        return user1;
        Exception exception;
        exception;
        throw exception;
    }

    private class Data
    {

        Session session;
        Usertemp user;

        public Session getSession()
        {
            return session;
        }

        public Usertemp getUser()
        {
            return user;
        }

        private Data()
        {
        }
    }


    private class Session
    {

        Features features;
        String token;
        Usertemp user;

        public Features getFeatures()
        {
            return features;
        }

        public String getToken()
        {
            return token;
        }

        public Usertemp getUser()
        {
            return user;
        }

        public Session()
        {
        }
    }


    private class Features
    {

        OfferUpBoolean payments;

        public OfferUpBoolean getPayments()
        {
            return payments;
        }

        public Features()
        {
        }
    }


    private class Usertemp
    {

        a dateJoined;
        String email;
        String firstName;
        GetProfile getProfile;
        int id;
        String lastName;

        public a getDateJoined()
        {
            return dateJoined;
        }

        public String getEmail()
        {
            return email;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public GetProfile getGetProfile()
        {
            return getProfile;
        }

        public int getId()
        {
            return id;
        }

        public String getLastName()
        {
            return lastName;
        }

        public Usertemp()
        {
        }
    }


    private class GetProfile
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

        public GetProfile()
        {
        }
    }

}
