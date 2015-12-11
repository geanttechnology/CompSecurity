// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            FIRSErrorType, XMLParserHelpers, FIRSError

public final class FIRSErrorParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/FIRSErrorParser.getName();

    private FIRSErrorParser()
    {
    }

    public static FIRSError parseError(Document document)
    {
        document = document.getDocumentElement();
        if (document == null || !document.getTagName().equals("error"))
        {
            return null;
        }
        if (XMLParserHelpers.hasElementWithTag(document, FIRSErrorType.FIRSErrorTypeCustomerNotFound.getErrorCode()))
        {
            document = FIRSErrorType.FIRSErrorTypeCustomerNotFound;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, FIRSErrorType.FIRSErrorTypeDeviceAlreadyRegistered.getErrorCode()))
        {
            document = FIRSErrorType.FIRSErrorTypeDeviceAlreadyRegistered;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, FIRSErrorType.FIRSErrorTypeDuplicateAccountName.getErrorCode()))
        {
            document = FIRSErrorType.FIRSErrorTypeDuplicateAccountName;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, FIRSErrorType.FIRSErrorTypeInternalError.getErrorCode()))
        {
            document = FIRSErrorType.FIRSErrorTypeInternalError;
        } else
        if (XMLParserHelpers.hasElementWithTag(document, FIRSErrorType.FIRSErrorTypeInvalidAccountFound.getErrorCode()))
        {
            document = FIRSErrorType.FIRSErrorTypeInvalidAccountFound;
        } else
        {
            document = FIRSErrorType.FIRSErrorTypeUnrecognized;
        }
        MAPLog.w(TAG, (new StringBuilder("FIRSError type=")).append(document).toString());
        return new FIRSError(document);
    }

}
