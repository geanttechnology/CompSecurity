// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.signup.json;

import com.groupon.models.signup.Flags;
import com.groupon.models.signup.SignupResponse;
import com.groupon.models.signup.User;
import java.util.Map;

// Referenced classes of package com.groupon.models.signup.json:
//            User, SignupResponse

public class Converter
{

    public Converter()
    {
    }

    private Flags flagsFromJson(Object obj)
    {
        Flags flags = new Flags();
        if (obj instanceof Map)
        {
            obj = ((Map)obj).get("isFeedEnabled");
            boolean flag;
            if (obj != null && ((Boolean)obj).booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flags.isFeedEnabled = flag;
        }
        return flags;
    }

    private User userFromJson(com.groupon.models.signup.json.User user)
    {
        User user1 = new User();
        user1.billingRecords = user.billingRecords;
        user1.consumerId = user.consumerId;
        user1.creditsAvailable = user.creditsAvailable;
        user1.dealTypes = user.dealTypes;
        user1.emailVerifiedAt = user.emailVerifiedAt;
        user1.facebookToken = user.facebookToken;
        user1.firstName = user.firstName;
        user1.flags = flagsFromJson(user.flags);
        user1.id = user.id;
        user1.legalTermsAccepted = user.legalTermsAccepted;
        user1.maskedName = user.maskedName;
        user1.merchants = user.merchants;
        user1.lastName = user.lastName;
        user1.primaryEmailAddress = user.primaryEmailAddress;
        user1.referralCode = user.referralCode;
        user1.rewardPointsAvailable = user.rewardPointsAvailable;
        user1.timeZone = user.timeZone;
        return user1;
    }

    public SignupResponse fromJson(com.groupon.models.signup.json.SignupResponse signupresponse)
    {
        SignupResponse signupresponse1 = new SignupResponse();
        signupresponse1.accessToken = signupresponse.accessToken;
        signupresponse1.user = userFromJson(signupresponse.user);
        return signupresponse1;
    }
}
