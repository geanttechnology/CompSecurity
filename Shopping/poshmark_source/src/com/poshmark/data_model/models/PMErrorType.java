// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.HashMap;
import java.util.Map;

public final class PMErrorType extends Enum
{

    private static final PMErrorType $VALUES[];
    public static final PMErrorType ALREADY_EXISTS_ERROR;
    public static final PMErrorType BRAND_CHANGE_LIMIT_EXCEEDED;
    public static final PMErrorType BRAND_FOLLOWING_LIST_ERROR;
    public static final PMErrorType CONNECTION_FAILURE;
    public static final PMErrorType CONNECTION_TIMEOUT;
    public static final PMErrorType EMAIL_TAKEN;
    public static final PMErrorType EXTERNAL_AUTH_ERROR;
    public static final PMErrorType EXTERNAL_ID_TAKEN_ERROR;
    public static final PMErrorType FB_LOGIN_ERROR;
    public static final PMErrorType GOOGLE_PLUS_LOGIN_ERROR;
    public static final PMErrorType HTTP_ACCESS_FORBIDDEN;
    public static final PMErrorType HTTP_BAD_REQUEST;
    public static final PMErrorType HTTP_ERROR;
    public static final PMErrorType HTTP_GONE;
    public static final PMErrorType HTTP_INTERNAL_SERVER_ERROR;
    public static final PMErrorType HTTP_NOT_FOUND;
    public static final PMErrorType HTTP_SERVER_UNAVAILABLE;
    public static final PMErrorType HTTP_UNAUTHORIZED;
    public static final PMErrorType INSUFFICIENT_PRIVILEGES_ERROR;
    public static final PMErrorType INVALID_LISTING;
    public static final PMErrorType INVALID_REFERRAL_CODE;
    public static final PMErrorType JSON_PARSING_ERROR;
    public static final PMErrorType PINTEREST_LOGIN_ERROR;
    public static final PMErrorType TM_LOGIN_ERROR;
    public static final PMErrorType TW_LOGIN_ERROR;
    public static final PMErrorType UNKNOWN_ERROR;
    public static final PMErrorType USERNAME_TAKEN_ERROR;
    public static Map errorMap = new HashMap() {

            
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
    };

    private PMErrorType(String s, int i)
    {
        super(s, i);
    }

    public static PMErrorType valueOf(String s)
    {
        return (PMErrorType)Enum.valueOf(com/poshmark/data_model/models/PMErrorType, s);
    }

    public static PMErrorType[] values()
    {
        return (PMErrorType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN_ERROR = new PMErrorType("UNKNOWN_ERROR", 0);
        CONNECTION_FAILURE = new PMErrorType("CONNECTION_FAILURE", 1);
        CONNECTION_TIMEOUT = new PMErrorType("CONNECTION_TIMEOUT", 2);
        JSON_PARSING_ERROR = new PMErrorType("JSON_PARSING_ERROR", 3);
        HTTP_NOT_FOUND = new PMErrorType("HTTP_NOT_FOUND", 4);
        HTTP_GONE = new PMErrorType("HTTP_GONE", 5);
        HTTP_INTERNAL_SERVER_ERROR = new PMErrorType("HTTP_INTERNAL_SERVER_ERROR", 6);
        HTTP_BAD_REQUEST = new PMErrorType("HTTP_BAD_REQUEST", 7);
        HTTP_UNAUTHORIZED = new PMErrorType("HTTP_UNAUTHORIZED", 8);
        HTTP_ACCESS_FORBIDDEN = new PMErrorType("HTTP_ACCESS_FORBIDDEN", 9);
        HTTP_SERVER_UNAVAILABLE = new PMErrorType("HTTP_SERVER_UNAVAILABLE", 10);
        HTTP_ERROR = new PMErrorType("HTTP_ERROR", 11);
        USERNAME_TAKEN_ERROR = new PMErrorType("USERNAME_TAKEN_ERROR", 12);
        EMAIL_TAKEN = new PMErrorType("EMAIL_TAKEN", 13);
        INVALID_REFERRAL_CODE = new PMErrorType("INVALID_REFERRAL_CODE", 14);
        INSUFFICIENT_PRIVILEGES_ERROR = new PMErrorType("INSUFFICIENT_PRIVILEGES_ERROR", 15);
        FB_LOGIN_ERROR = new PMErrorType("FB_LOGIN_ERROR", 16);
        GOOGLE_PLUS_LOGIN_ERROR = new PMErrorType("GOOGLE_PLUS_LOGIN_ERROR", 17);
        EXTERNAL_ID_TAKEN_ERROR = new PMErrorType("EXTERNAL_ID_TAKEN_ERROR", 18);
        TW_LOGIN_ERROR = new PMErrorType("TW_LOGIN_ERROR", 19);
        INVALID_LISTING = new PMErrorType("INVALID_LISTING", 20);
        BRAND_CHANGE_LIMIT_EXCEEDED = new PMErrorType("BRAND_CHANGE_LIMIT_EXCEEDED", 21);
        BRAND_FOLLOWING_LIST_ERROR = new PMErrorType("BRAND_FOLLOWING_LIST_ERROR", 22);
        TM_LOGIN_ERROR = new PMErrorType("TM_LOGIN_ERROR", 23);
        EXTERNAL_AUTH_ERROR = new PMErrorType("EXTERNAL_AUTH_ERROR", 24);
        ALREADY_EXISTS_ERROR = new PMErrorType("ALREADY_EXISTS_ERROR", 25);
        PINTEREST_LOGIN_ERROR = new PMErrorType("PINTEREST_LOGIN_ERROR", 26);
        $VALUES = (new PMErrorType[] {
            UNKNOWN_ERROR, CONNECTION_FAILURE, CONNECTION_TIMEOUT, JSON_PARSING_ERROR, HTTP_NOT_FOUND, HTTP_GONE, HTTP_INTERNAL_SERVER_ERROR, HTTP_BAD_REQUEST, HTTP_UNAUTHORIZED, HTTP_ACCESS_FORBIDDEN, 
            HTTP_SERVER_UNAVAILABLE, HTTP_ERROR, USERNAME_TAKEN_ERROR, EMAIL_TAKEN, INVALID_REFERRAL_CODE, INSUFFICIENT_PRIVILEGES_ERROR, FB_LOGIN_ERROR, GOOGLE_PLUS_LOGIN_ERROR, EXTERNAL_ID_TAKEN_ERROR, TW_LOGIN_ERROR, 
            INVALID_LISTING, BRAND_CHANGE_LIMIT_EXCEEDED, BRAND_FOLLOWING_LIST_ERROR, TM_LOGIN_ERROR, EXTERNAL_AUTH_ERROR, ALREADY_EXISTS_ERROR, PINTEREST_LOGIN_ERROR
        });
    }
}
