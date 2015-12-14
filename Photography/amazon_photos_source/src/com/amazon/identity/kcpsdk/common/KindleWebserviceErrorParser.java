// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            XMLParserHelpers, KindleWebserviceErrorType, KindleWebserviceError

public final class KindleWebserviceErrorParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/KindleWebserviceErrorParser.getName();

    private KindleWebserviceErrorParser()
    {
    }

    public static KindleWebserviceError parseError(Document document)
    {
        document = document.getDocumentElement();
        if (document == null || !document.getTagName().equals("KindleWebServicesError"))
        {
            return null;
        }
        if (XMLParserHelpers.hasElementWithTag(document, "FileNotFoundError"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeFileNotFound;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "DeviceAlreadyRegistered"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeDeviceAlreadyRegistered;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "CredentialsRequired"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeCredentialsRequired;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "InvalidAsin"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeInvalidAsin;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "InvalidOrder"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeInvalidOrder;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "InsufficientFunds"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeInsufficientFunds;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "UnknownError"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeUnknownError;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "UnBuyError"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeUnbuyError;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "DuplicateDeviceName"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeDuplicateDeviceName;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, "InternalError"))
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeInternalError;
        } else
        {
            document = KindleWebserviceErrorType.KindleWebserviceErrorTypeUnrecognized;
        }
        MAPLog.w(TAG, (new StringBuilder("KindleWebserviceError type=")).append(document).toString());
        return new KindleWebserviceError(document);
    }

}
