// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.EbayContext;

public final class InternalDomainError
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{

    public static final String CATEGORY = "internal";
    public static final String DOMAIN = "nautilus";
    public static final int ID_COUNTRY_NOT_SPECIFIED = 2;
    public static final int ID_DATA_IS_NULL = 5;
    public static final int ID_INVALID_ARGUMENT = 4;
    public static final int ID_NO_NETWORK = 6;
    public static final int ID_PLEASE_SIGN_IN = 1;
    public static final int ID_SERVER_RESPONSE_NOT_VALID = 3;
    private final boolean displayToUser;
    private final Object formatArgs[];
    private final int id;
    private final int messageResource;
    private final com.ebay.nautilus.kernel.content.ResultStatus.Severity severity;

    private InternalDomainError(int i, int j, com.ebay.nautilus.kernel.content.ResultStatus.Severity severity1, boolean flag)
    {
        this(i, j, severity1, flag, (Object[])null);
    }

    private transient InternalDomainError(int i, int j, com.ebay.nautilus.kernel.content.ResultStatus.Severity severity1, boolean flag, Object aobj[])
    {
        id = i;
        messageResource = j;
        severity = severity1;
        displayToUser = flag;
        formatArgs = aobj;
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message getCountryNotSpecifiedMessage()
    {
        return new InternalDomainError(2, com.ebay.nautilus.domain.R.string.domain_country_not_specified, com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error, false);
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message getDataIsNull()
    {
        return new InternalDomainError(5, com.ebay.nautilus.domain.R.string.domain_data_is_null, com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error, false);
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message getInvalidArgumentMessage()
    {
        return new InternalDomainError(4, com.ebay.nautilus.domain.R.string.domain_invalid_argument, com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error, true);
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message getNoNetworkMessage()
    {
        return new InternalDomainError(6, com.ebay.nautilus.domain.R.string.domain_no_network, com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error, true);
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message getPleaseSignInMessage()
    {
        return new InternalDomainError(1, com.ebay.nautilus.domain.R.string.domain_please_sign_in, com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error, true);
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message getServerResponseNotValidMessage()
    {
        return new InternalDomainError(3, com.ebay.nautilus.domain.R.string.domain_server_response_not_valid, com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error, true);
    }

    public static boolean isCountryNotSpecifiedMessage(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return isInternalError(message) == 2;
    }

    public static boolean isDataIsNull(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return isInternalError(message) == 5;
    }

    private static int isInternalError(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        if ("internal".equals(message.getCategory()) && "nautilus".equals(message.getDomain()))
        {
            return message.getId();
        } else
        {
            return 0;
        }
    }

    public static boolean isInvalidArgumentMessage(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return isInternalError(message) == 4;
    }

    public static boolean isNoNetworkMessage(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return isInternalError(message) == 6;
    }

    public static boolean isPleaseSignInMessage(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return isInternalError(message) == 1;
    }

    public static boolean isServerResponseNotValidMessage(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return isInternalError(message) == 3;
    }

    public boolean displayToUser()
    {
        return displayToUser;
    }

    public String getCategory()
    {
        return "internal";
    }

    public String getDomain()
    {
        return "nautilus";
    }

    public int getId()
    {
        return id;
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        return null;
    }

    public String getRemediationUrl()
    {
        return null;
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        return severity;
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return ebaycontext.getString(messageResource, formatArgs);
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return false;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("internal").append(' ').append(severity).append(' ').append(id);
        if (displayToUser)
        {
            stringbuilder.append(" (display to user)");
        }
        return stringbuilder.toString();
    }
}
