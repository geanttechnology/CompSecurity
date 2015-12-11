// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class VineError
    implements Parcelable
{
    public static final class VineKnownErrors extends Enum
    {

        private static final VineKnownErrors $VALUES[];
        public static final VineKnownErrors ACCESS_DENIED;
        public static final VineKnownErrors ACCOUNT_DEACTIVATED;
        public static final VineKnownErrors ADDRESS_BOOK_NOT_FOUND;
        public static final VineKnownErrors AVATAR_INVALID;
        public static final VineKnownErrors BAD_CREDENTIALS;
        public static final VineKnownErrors CANT_FLAG_SELF;
        public static final VineKnownErrors CANT_FOLLOW_SELF;
        public static final VineKnownErrors CAPTCHA;
        public static final VineKnownErrors COMMENT_INVALID_LENGTH;
        public static final VineKnownErrors DESCRIPTION_INVALID_LENGTH;
        public static final VineKnownErrors DUPLICATE_MENTIONS;
        public static final VineKnownErrors EMAIL_INVALID;
        public static final VineKnownErrors EMAIL_IN_USE;
        public static final VineKnownErrors EXPIRED_SESSION;
        public static final VineKnownErrors FACEBOOK_FF_DISABLED;
        public static final VineKnownErrors FACEBOOK_NOT_AUTHORIZED;
        public static final VineKnownErrors FSQUARE_VENUE_INVALID;
        public static final VineKnownErrors INVALID_ARGUMENT;
        public static final VineKnownErrors INVALID_ERROR_CODE;
        public static final VineKnownErrors INVALID_SESSION;
        public static final VineKnownErrors LOCATION_INVALID_LENGTH;
        public static final VineKnownErrors MESSAGE_RECIPIENT_INVALID_EMAIL_ADDRESS;
        public static final VineKnownErrors MESSAGE_RECIPIENT_OUT_OF_NETWORK;
        public static final VineKnownErrors MISSING_REQUIRED_FIELD;
        public static final VineKnownErrors NON_INTEGER_VALUE;
        public static final VineKnownErrors NOTIFICATION_REFERENCES_SELF;
        public static final VineKnownErrors NO_ARGUMENTS_PROVIDED;
        public static final VineKnownErrors ORPHANED_USER_ACCOUNT;
        public static final VineKnownErrors PASSWORD_INVALID;
        public static final VineKnownErrors PASSWORD_RESET_TOKEN_EXPIRED;
        public static final VineKnownErrors PHONE_INVALID;
        public static final VineKnownErrors RECORD_DOES_NOT_EXIST;
        public static final VineKnownErrors RELATIONSHIP_REQUIRES_ACTION;
        public static final VineKnownErrors REQUIRES_ADMIN_LOGIN;
        public static final VineKnownErrors REQUIRES_LOGIN;
        public static final VineKnownErrors TOO_MANY_MENTIONS;
        public static final VineKnownErrors TWITTER_NAME_IN_USE;
        public static final VineKnownErrors TWITTER_NOT_AUTHORIZED;
        public static final VineKnownErrors TWITTER_WRONG_ACCOUNT;
        public static final VineKnownErrors UNKNOWN_ERROR;
        public static final VineKnownErrors UNSUPPORTED_METHOD;
        public static final VineKnownErrors USERNAME_INVALID_CHARACTERS;
        public static final VineKnownErrors USERNAME_INVALID_LENGTH;
        public static final VineKnownErrors USERNAME_IN_USE;
        public static final VineKnownErrors USER_DESCRIPTION_INVALID_LENGTH;
        public static final VineKnownErrors VERIFY_CONTACT_MISMATCH;
        public static final VineKnownErrors VERIFY_PHONE_WRONG_USER;
        public static final VineKnownErrors VERIFY_TOKEN_EXPIRED;
        public static final VineKnownErrors VERIFY_TOKEN_NOT_FOUND;
        public static final VineKnownErrors VIDEOURL_INVALID;
        public final int code;
        public final int message;

        public static VineKnownErrors valueOf(int i)
        {
            switch (i)
            {
            default:
                return INVALID_ERROR_CODE;

            case 0: // '\0'
                return UNKNOWN_ERROR;

            case 1: // '\001'
                return UNSUPPORTED_METHOD;

            case 3: // '\003'
                return MISSING_REQUIRED_FIELD;

            case 4: // '\004'
                return ACCESS_DENIED;

            case 5: // '\005'
                return INVALID_ARGUMENT;

            case 6: // '\006'
                return NON_INTEGER_VALUE;

            case 100: // 'd'
                return REQUIRES_LOGIN;

            case 101: // 'e'
                return BAD_CREDENTIALS;

            case 102: // 'f'
                return EXPIRED_SESSION;

            case 103: // 'g'
                return INVALID_SESSION;

            case 104: // 'h'
                return FACEBOOK_NOT_AUTHORIZED;

            case 105: // 'i'
                return TWITTER_NOT_AUTHORIZED;

            case 106: // 'j'
                return ADDRESS_BOOK_NOT_FOUND;

            case 107: // 'k'
                return FACEBOOK_FF_DISABLED;

            case 150: 
                return REQUIRES_ADMIN_LOGIN;

            case 200: 
                return USERNAME_IN_USE;

            case 201: 
                return USERNAME_INVALID_CHARACTERS;

            case 202: 
                return USERNAME_INVALID_LENGTH;

            case 203: 
                return ORPHANED_USER_ACCOUNT;

            case 205: 
                return DESCRIPTION_INVALID_LENGTH;

            case 206: 
                return TOO_MANY_MENTIONS;

            case 207: 
                return DUPLICATE_MENTIONS;

            case 208: 
                return USER_DESCRIPTION_INVALID_LENGTH;

            case 210: 
                return PASSWORD_INVALID;

            case 211: 
                return PHONE_INVALID;

            case 212: 
                return LOCATION_INVALID_LENGTH;

            case 220: 
                return EMAIL_IN_USE;

            case 221: 
                return EMAIL_INVALID;

            case 222: 
                return TWITTER_NAME_IN_USE;

            case 223: 
                return TWITTER_WRONG_ACCOUNT;

            case 225: 
                return PASSWORD_RESET_TOKEN_EXPIRED;

            case 250: 
                return CANT_FOLLOW_SELF;

            case 251: 
                return CANT_FLAG_SELF;

            case 301: 
                return FSQUARE_VENUE_INVALID;

            case 302: 
                return VIDEOURL_INVALID;

            case 303: 
                return COMMENT_INVALID_LENGTH;

            case 304: 
                return AVATAR_INVALID;

            case 333: 
                return MESSAGE_RECIPIENT_INVALID_EMAIL_ADDRESS;

            case 400: 
                return RELATIONSHIP_REQUIRES_ACTION;

            case 419: 
                return CAPTCHA;

            case 500: 
                return NOTIFICATION_REFERENCES_SELF;

            case 620: 
                return VERIFY_TOKEN_EXPIRED;

            case 621: 
                return VERIFY_CONTACT_MISMATCH;

            case 623: 
                return VERIFY_PHONE_WRONG_USER;

            case 624: 
                return VERIFY_TOKEN_NOT_FOUND;

            case 666: 
                return MESSAGE_RECIPIENT_OUT_OF_NETWORK;

            case 900: 
                return RECORD_DOES_NOT_EXIST;

            case 901: 
                return NO_ARGUMENTS_PROVIDED;
            }
        }

        public static VineKnownErrors valueOf(VineError vineerror)
        {
            return valueOf(vineerror.errorCode);
        }

        public static VineKnownErrors valueOf(String s)
        {
            return (VineKnownErrors)Enum.valueOf(co/vine/android/api/VineError$VineKnownErrors, s);
        }

        public static VineKnownErrors[] values()
        {
            return (VineKnownErrors[])$VALUES.clone();
        }

        public String getMessage(Context context)
        {
            return context.getString(message);
        }

        static 
        {
            INVALID_ERROR_CODE = new VineKnownErrors("INVALID_ERROR_CODE", 0, -1, 0x7f0e0012);
            UNKNOWN_ERROR = new VineKnownErrors("UNKNOWN_ERROR", 1, 0, 0x7f0e0026);
            UNSUPPORTED_METHOD = new VineKnownErrors("UNSUPPORTED_METHOD", 2, 1, 0x7f0e0027);
            MISSING_REQUIRED_FIELD = new VineKnownErrors("MISSING_REQUIRED_FIELD", 3, 3, 0x7f0e0015);
            ACCESS_DENIED = new VineKnownErrors("ACCESS_DENIED", 4, 4, 0x7f0e0000);
            INVALID_ARGUMENT = new VineKnownErrors("INVALID_ARGUMENT", 5, 5, 0x7f0e0011);
            NON_INTEGER_VALUE = new VineKnownErrors("NON_INTEGER_VALUE", 6, 6, 0x7f0e0016);
            REQUIRES_LOGIN = new VineKnownErrors("REQUIRES_LOGIN", 7, 100, 0x7f0e0020);
            BAD_CREDENTIALS = new VineKnownErrors("BAD_CREDENTIALS", 8, 101, 0x7f0e0004);
            EXPIRED_SESSION = new VineKnownErrors("EXPIRED_SESSION", 9, 102, 0x7f0e000d);
            INVALID_SESSION = new VineKnownErrors("INVALID_SESSION", 10, 103, 0x7f0e0013);
            FACEBOOK_NOT_AUTHORIZED = new VineKnownErrors("FACEBOOK_NOT_AUTHORIZED", 11, 104, 0x7f0e000f);
            TWITTER_NOT_AUTHORIZED = new VineKnownErrors("TWITTER_NOT_AUTHORIZED", 12, 105, 0x7f0e0024);
            ADDRESS_BOOK_NOT_FOUND = new VineKnownErrors("ADDRESS_BOOK_NOT_FOUND", 13, 106, 0x7f0e0002);
            FACEBOOK_FF_DISABLED = new VineKnownErrors("FACEBOOK_FF_DISABLED", 14, 107, 0x7f0e000e);
            REQUIRES_ADMIN_LOGIN = new VineKnownErrors("REQUIRES_ADMIN_LOGIN", 15, 150, 0x7f0e001f);
            ACCOUNT_DEACTIVATED = new VineKnownErrors("ACCOUNT_DEACTIVATED", 16, 187, 0x7f0e0001);
            USERNAME_IN_USE = new VineKnownErrors("USERNAME_IN_USE", 17, 200, 0x7f0e002a);
            USERNAME_INVALID_CHARACTERS = new VineKnownErrors("USERNAME_INVALID_CHARACTERS", 18, 201, 0x7f0e0028);
            USERNAME_INVALID_LENGTH = new VineKnownErrors("USERNAME_INVALID_LENGTH", 19, 202, 0x7f0e0029);
            ORPHANED_USER_ACCOUNT = new VineKnownErrors("ORPHANED_USER_ACCOUNT", 20, 203, 0x7f0e0019);
            DESCRIPTION_INVALID_LENGTH = new VineKnownErrors("DESCRIPTION_INVALID_LENGTH", 21, 205, 0x7f0e0009);
            TOO_MANY_MENTIONS = new VineKnownErrors("TOO_MANY_MENTIONS", 22, 206, 0x7f0e0022);
            DUPLICATE_MENTIONS = new VineKnownErrors("DUPLICATE_MENTIONS", 23, 207, 0x7f0e000a);
            USER_DESCRIPTION_INVALID_LENGTH = new VineKnownErrors("USER_DESCRIPTION_INVALID_LENGTH", 24, 208, 0x7f0e002b);
            PASSWORD_INVALID = new VineKnownErrors("PASSWORD_INVALID", 25, 210, 0x7f0e001a);
            PHONE_INVALID = new VineKnownErrors("PHONE_INVALID", 26, 211, 0x7f0e001c);
            LOCATION_INVALID_LENGTH = new VineKnownErrors("LOCATION_INVALID_LENGTH", 27, 212, 0x7f0e0014);
            EMAIL_IN_USE = new VineKnownErrors("EMAIL_IN_USE", 28, 220, 0x7f0e000c);
            EMAIL_INVALID = new VineKnownErrors("EMAIL_INVALID", 29, 221, 0x7f0e000b);
            TWITTER_NAME_IN_USE = new VineKnownErrors("TWITTER_NAME_IN_USE", 30, 222, 0x7f0e0023);
            TWITTER_WRONG_ACCOUNT = new VineKnownErrors("TWITTER_WRONG_ACCOUNT", 31, 223, 0x7f0e0025);
            PASSWORD_RESET_TOKEN_EXPIRED = new VineKnownErrors("PASSWORD_RESET_TOKEN_EXPIRED", 32, 225, 0x7f0e001b);
            CANT_FOLLOW_SELF = new VineKnownErrors("CANT_FOLLOW_SELF", 33, 250, 0x7f0e0006);
            CANT_FLAG_SELF = new VineKnownErrors("CANT_FLAG_SELF", 34, 251, 0x7f0e0005);
            FSQUARE_VENUE_INVALID = new VineKnownErrors("FSQUARE_VENUE_INVALID", 35, 301, 0x7f0e0010);
            VIDEOURL_INVALID = new VineKnownErrors("VIDEOURL_INVALID", 36, 302, 0x7f0e002f);
            COMMENT_INVALID_LENGTH = new VineKnownErrors("COMMENT_INVALID_LENGTH", 37, 303, 0x7f0e0008);
            AVATAR_INVALID = new VineKnownErrors("AVATAR_INVALID", 38, 304, 0x7f0e0003);
            MESSAGE_RECIPIENT_INVALID_EMAIL_ADDRESS = new VineKnownErrors("MESSAGE_RECIPIENT_INVALID_EMAIL_ADDRESS", 39, 333, 0);
            RELATIONSHIP_REQUIRES_ACTION = new VineKnownErrors("RELATIONSHIP_REQUIRES_ACTION", 40, 400, 0x7f0e001e);
            CAPTCHA = new VineKnownErrors("CAPTCHA", 41, 419, 0x7f0e0007);
            NOTIFICATION_REFERENCES_SELF = new VineKnownErrors("NOTIFICATION_REFERENCES_SELF", 42, 500, 0x7f0e0017);
            RECORD_DOES_NOT_EXIST = new VineKnownErrors("RECORD_DOES_NOT_EXIST", 43, 900, 0x7f0e001d);
            NO_ARGUMENTS_PROVIDED = new VineKnownErrors("NO_ARGUMENTS_PROVIDED", 44, 901, 0x7f0e0018);
            VERIFY_TOKEN_EXPIRED = new VineKnownErrors("VERIFY_TOKEN_EXPIRED", 45, 620, 0x7f0e0021);
            VERIFY_CONTACT_MISMATCH = new VineKnownErrors("VERIFY_CONTACT_MISMATCH", 46, 621, 0x7f0e002c);
            VERIFY_PHONE_WRONG_USER = new VineKnownErrors("VERIFY_PHONE_WRONG_USER", 47, 623, 0x7f0e002d);
            VERIFY_TOKEN_NOT_FOUND = new VineKnownErrors("VERIFY_TOKEN_NOT_FOUND", 48, 624, 0x7f0e002e);
            MESSAGE_RECIPIENT_OUT_OF_NETWORK = new VineKnownErrors("MESSAGE_RECIPIENT_OUT_OF_NETWORK", 49, 666, 0);
            $VALUES = (new VineKnownErrors[] {
                INVALID_ERROR_CODE, UNKNOWN_ERROR, UNSUPPORTED_METHOD, MISSING_REQUIRED_FIELD, ACCESS_DENIED, INVALID_ARGUMENT, NON_INTEGER_VALUE, REQUIRES_LOGIN, BAD_CREDENTIALS, EXPIRED_SESSION, 
                INVALID_SESSION, FACEBOOK_NOT_AUTHORIZED, TWITTER_NOT_AUTHORIZED, ADDRESS_BOOK_NOT_FOUND, FACEBOOK_FF_DISABLED, REQUIRES_ADMIN_LOGIN, ACCOUNT_DEACTIVATED, USERNAME_IN_USE, USERNAME_INVALID_CHARACTERS, USERNAME_INVALID_LENGTH, 
                ORPHANED_USER_ACCOUNT, DESCRIPTION_INVALID_LENGTH, TOO_MANY_MENTIONS, DUPLICATE_MENTIONS, USER_DESCRIPTION_INVALID_LENGTH, PASSWORD_INVALID, PHONE_INVALID, LOCATION_INVALID_LENGTH, EMAIL_IN_USE, EMAIL_INVALID, 
                TWITTER_NAME_IN_USE, TWITTER_WRONG_ACCOUNT, PASSWORD_RESET_TOKEN_EXPIRED, CANT_FOLLOW_SELF, CANT_FLAG_SELF, FSQUARE_VENUE_INVALID, VIDEOURL_INVALID, COMMENT_INVALID_LENGTH, AVATAR_INVALID, MESSAGE_RECIPIENT_INVALID_EMAIL_ADDRESS, 
                RELATIONSHIP_REQUIRES_ACTION, CAPTCHA, NOTIFICATION_REFERENCES_SELF, RECORD_DOES_NOT_EXIST, NO_ARGUMENTS_PROVIDED, VERIFY_TOKEN_EXPIRED, VERIFY_CONTACT_MISMATCH, VERIFY_PHONE_WRONG_USER, VERIFY_TOKEN_NOT_FOUND, MESSAGE_RECIPIENT_OUT_OF_NETWORK
            });
        }

        private VineKnownErrors(String s, int i, int j, int k)
        {
            super(s, i);
            code = j;
            message = k;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineError createFromParcel(Parcel parcel)
        {
            return new VineError(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineError[] newArray(int i)
        {
            return new VineError[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String data;
    public final int errorCode;
    public final String message;

    public VineError(int i, String s)
    {
        this(i, s, null);
    }

    public VineError(int i, String s, String s1)
    {
        errorCode = i;
        message = s;
        data = s1;
    }

    public VineError(Parcel parcel)
    {
        errorCode = parcel.readInt();
        message = parcel.readString();
        data = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = true;
        boolean flag = true;
        if (obj != null)
        {
            if (obj.getClass() == getClass())
            {
                if (errorCode != ((VineError)obj).errorCode)
                {
                    flag = false;
                }
                return flag;
            }
            if (obj instanceof VineKnownErrors)
            {
                boolean flag1;
                if (errorCode == ((VineKnownErrors)obj).code)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                return flag1;
            }
        }
        return false;
    }

    public String getLocalizedMessage(Context context)
    {
        VineKnownErrors vineknownerrors = VineKnownErrors.valueOf(errorCode);
        if (vineknownerrors != VineKnownErrors.INVALID_ERROR_CODE)
        {
            return vineknownerrors.getMessage(context);
        } else
        {
            return message;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(errorCode);
        parcel.writeString(message);
        parcel.writeString(data);
    }

}
