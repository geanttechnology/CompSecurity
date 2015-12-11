// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class LdsError
    implements Parcelable
{

    public static final String AN_ERROR_OCCURRED = "100000036";
    public static final String CANT_ADD_PICTURES_AT_THIS_TIME = "121916796";
    private static final String CANT_EDIT_FROM_OTHER_SITE = "100000094";
    private static final String CANT_RELIST_SME = "100000196";
    private static final String CANT_REVISE_ENDED_AUCTION = "100000291";
    private static final String CLIENT_APP_TYPE_ANDROID = "12";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LdsError createFromParcel(Parcel parcel)
        {
            return new LdsError(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LdsError[] newArray(int i)
        {
            return new LdsError[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String DUPLICATE_LISTING = "121919067";
    public static final String EFT_DETAILS_NEEDED = "100000506";
    public static final String ELVIS_CANT_PUBLISH = "100000240";
    private static final String LEGACY_SELLER_REG_ERROR = "100000120";
    public static final String MANDATORY_CATALOG_CATEGORY = "121917221";
    private static final String MESSAGE_ID_SELLER_REG = "1013";
    private static final String MOBILE_RU_VALUE = "http://www.ebay.com/mobile-redirect-done";
    private static final String OUTCOME_SELLING_PRIVILEGE_REQUIRED = "SELLING_PRIVILEGE_REQUIRED";
    public static final String PRODUCT_INVALID_FOR_CATEGORY = "100012018";
    private static final String RISK_SERVICE_ERROR = "100000640";
    public static final String SELLER_LIMIT = "121919188";
    private static final String SESSION_NOT_FOUND = "121917048";
    public static final String SYI_BIZ_319 = "319";
    private static final String SYI_ERROR_SIGNATURE = "Id : SYI.BIZ.";
    public static final String WARN_FUNDS_HELD = "121917236";
    public static final String WARN_PAYPAL_EMAIL_NOT_LINKED = "121919158";
    private static final String WRONG_LISTING_MODE = "121917073";
    public String category;
    public String domain;
    public String id;
    public String inputRefId;
    public String longMessage;
    public String message;
    public String parameterClientTypePlaceHolder;
    public String parameterDecisionOutcomeReason;
    public String parameterMessage;
    public String parameterMessageId;
    public String parameterMessageUrl;
    public String parameterPaymentHoldUrl;
    public String parameterRedirectUrl;
    public String parameterRuPlaceHolder;
    public String parameterShortMessage;
    public String severity;

    public LdsError()
    {
    }

    private LdsError(Parcel parcel)
    {
        id = parcel.readString();
        message = parcel.readString();
        longMessage = parcel.readString();
        severity = parcel.readString();
        category = parcel.readString();
        domain = parcel.readString();
        inputRefId = parcel.readString();
        parameterMessage = parcel.readString();
        parameterShortMessage = parcel.readString();
        parameterPaymentHoldUrl = parcel.readString();
        parameterMessageUrl = parcel.readString();
        parameterRedirectUrl = parcel.readString();
        parameterRuPlaceHolder = parcel.readString();
        parameterClientTypePlaceHolder = parcel.readString();
        parameterDecisionOutcomeReason = parcel.readString();
        parameterMessageId = parcel.readString();
    }


    public static LdsError getFirstElvisError(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return null;
        }
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            LdsError ldserror = (LdsError)arraylist.next();
            if ("100000240".equals(ldserror.id))
            {
                return ldserror;
            }
        }

        return null;
    }

    public static LdsError getFirstRedirectError(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return null;
        }
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            LdsError ldserror = (LdsError)arraylist.next();
            if (!TextUtils.isEmpty(ldserror.parameterRedirectUrl))
            {
                return ldserror;
            }
        }

        return null;
    }

    public static LdsError getFirstSellerVerificationError(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return null;
        }
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            LdsError ldserror = (LdsError)arraylist.next();
            if (isSellerVerificationError(ldserror))
            {
                return ldserror;
            }
        }

        return null;
    }

    public static String getRedirectUrlWithReplacements(LdsError ldserror)
    {
        String s1;
        if (ldserror == null || TextUtils.isEmpty(ldserror.parameterRedirectUrl))
        {
            s1 = null;
        } else
        {
            s1 = ldserror.parameterRedirectUrl;
            String s = s1;
            if (!TextUtils.isEmpty(ldserror.parameterRuPlaceHolder))
            {
                s = s1.replace(ldserror.parameterRuPlaceHolder, "http://www.ebay.com/mobile-redirect-done");
            }
            s1 = s;
            if (!TextUtils.isEmpty(ldserror.parameterClientTypePlaceHolder))
            {
                return s.replace(ldserror.parameterClientTypePlaceHolder, "12");
            }
        }
        return s1;
    }

    public static boolean isOperationFailure(String s)
    {
        return "121917048".equals(s) || "100000291".equals(s) || "121917073".equals(s) || "100000094".equals(s) || "100000196".equals(s);
    }

    public static boolean isSellerVerificationError(LdsError ldserror)
    {
        boolean flag1 = true;
        if (ldserror != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if ("100000120".equals(ldserror.id)) goto _L4; else goto _L3
_L3:
        if (!"100000640".equals(ldserror.id) || !"SELLING_PRIVILEGE_REQUIRED".equals(ldserror.parameterDecisionOutcomeReason))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if ("1013".equals(ldserror.parameterMessageId)) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getSyiErrorId()
    {
        String s;
        try
        {
            s = longMessage.substring(longMessage.indexOf("Id : SYI.BIZ.") + "Id : SYI.BIZ.".length());
            s = s.substring(0, s.indexOf(","));
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return null;
        }
        return s;
    }

    public boolean isSyiErrorMessage()
    {
        return !TextUtils.isEmpty(longMessage) && longMessage.contains("Id : SYI.BIZ.");
    }

    public String toString()
    {
        return (new StringBuilder()).append(severity).append(": ").append(longMessage).append(" id:").append(id).append(" inputRefId:").append(inputRefId).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(message);
        parcel.writeString(longMessage);
        parcel.writeString(severity);
        parcel.writeString(category);
        parcel.writeString(domain);
        parcel.writeString(inputRefId);
        parcel.writeString(parameterMessage);
        parcel.writeString(parameterShortMessage);
        parcel.writeString(parameterPaymentHoldUrl);
        parcel.writeString(parameterMessageUrl);
        parcel.writeString(parameterRedirectUrl);
        parcel.writeString(parameterRuPlaceHolder);
        parcel.writeString(parameterClientTypePlaceHolder);
        parcel.writeString(parameterDecisionOutcomeReason);
        parcel.writeString(parameterMessageId);
    }

}
