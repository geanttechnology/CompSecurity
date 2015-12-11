// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.HashMap;

// Referenced classes of package com.poshmark.data_model.models:
//            PMErrorType

static final class TP_NOT_FOUND extends HashMap
{

    ()
    {
        put("UsernameTakenError", PMErrorType.USERNAME_TAKEN_ERROR);
        put("EmailTakenError", PMErrorType.EMAIL_TAKEN);
        put("InvalidReferralCodeError", PMErrorType.INVALID_REFERRAL_CODE);
        put("InsufficientPrivilegesError", PMErrorType.INSUFFICIENT_PRIVILEGES_ERROR);
        put("ExternalUserIdTakenError", PMErrorType.EXTERNAL_ID_TAKEN_ERROR);
        put("PostValidationError", PMErrorType.INVALID_LISTING);
        put("BrandChangeError", PMErrorType.BRAND_CHANGE_LIMIT_EXCEEDED);
        put("ExternalAuthenticationError", PMErrorType.EXTERNAL_AUTH_ERROR);
        put("BrandFollowingListError", PMErrorType.BRAND_FOLLOWING_LIST_ERROR);
        put("AlreadyExistsError", PMErrorType.ALREADY_EXISTS_ERROR);
        put("NotFoundError", PMErrorType.HTTP_NOT_FOUND);
    }
}
