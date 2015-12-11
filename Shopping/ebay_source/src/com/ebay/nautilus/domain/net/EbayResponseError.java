// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class EbayResponseError
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{
    public static class LongDetails extends EbayResponseError
    {

        public String domain;
        public String exceptionId;
        public ArrayList parameters;
        public String subdomain;

        public final String categoryDescription()
        {
            switch (category)
            {
            default:
                return null;

            case 1: // '\001'
                return "Application";

            case 2: // '\002'
                return "Request";

            case 3: // '\003'
                return "System";
            }
        }

        public String getDomain()
        {
            return domain;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(toString());
            if (!TextUtils.isEmpty(domain))
            {
                stringbuilder.append(" (").append(domain);
                if (!TextUtils.isEmpty(subdomain))
                {
                    stringbuilder.append(" - ").append(subdomain);
                }
                stringbuilder.append(')');
            }
            if (!TextUtils.isEmpty(exceptionId))
            {
                stringbuilder.append(" EX: ").append(exceptionId);
            }
            return stringbuilder.toString();
        }

        public LongDetails()
        {
            domain = null;
            subdomain = null;
            exceptionId = null;
            parameters = null;
        }
    }

    public static class LongDetails.Parameter
    {

        public String name;
        public String value;

        public LongDetails.Parameter()
        {
            name = null;
            value = null;
        }
    }

    public static final class RecommendedAction extends Enum
    {

        private static final RecommendedAction $VALUES[];
        public static final RecommendedAction CONSULTTECHSUPPORT;
        public static final RecommendedAction CORRECTINPUTDATA;
        public static final RecommendedAction NONE;
        public static final RecommendedAction RETRY;

        public static RecommendedAction valueOf(String s)
        {
            return (RecommendedAction)Enum.valueOf(com/ebay/nautilus/domain/net/EbayResponseError$RecommendedAction, s);
        }

        public static RecommendedAction[] values()
        {
            return (RecommendedAction[])$VALUES.clone();
        }

        static 
        {
            NONE = new RecommendedAction("NONE", 0);
            RETRY = new RecommendedAction("RETRY", 1);
            CORRECTINPUTDATA = new RecommendedAction("CORRECTINPUTDATA", 2);
            CONSULTTECHSUPPORT = new RecommendedAction("CONSULTTECHSUPPORT", 3);
            $VALUES = (new RecommendedAction[] {
                NONE, RETRY, CORRECTINPUTDATA, CONSULTTECHSUPPORT
            });
        }

        private RecommendedAction(String s, int i)
        {
            super(s, i);
        }
    }

    public static class RecommendedAction.Deserializer
        implements JsonDeserializer
    {

        public RecommendedAction deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            type = RecommendedAction.values();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (jsondeserializationcontext.name().equalsIgnoreCase(jsonelement))
                {
                    return jsondeserializationcontext;
                }
            }

            return RecommendedAction.NONE;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public RecommendedAction.Deserializer()
        {
        }
    }

    public static class ShortDetails extends EbayResponseError
    {

        public final ArrayList parameters = new ArrayList();

        public ShortDetails()
        {
        }
    }


    public static final int CATEGORY_APPLICATION = 1;
    public static final int CATEGORY_REQUEST = 2;
    public static final int CATEGORY_SYSTEM = 3;
    public static final int CUSTOM_CODE = -1;
    public static final int NOT_SET = 0;
    public static final int SEVERITY_ERROR = 1;
    public static final int SEVERITY_WARNING = 2;
    public RecommendedAction actionToTake;
    public int category;
    public String code;
    public String longMessage;
    public int severity;
    public String shortMessage;
    public boolean userDisplay;

    public EbayResponseError()
    {
        category = 0;
        code = "";
        severity = 0;
        shortMessage = null;
        longMessage = null;
        userDisplay = true;
        actionToTake = RecommendedAction.NONE;
    }

    public boolean displayToUser()
    {
        return userDisplay && !TextUtils.isEmpty(shortMessage);
    }

    public String getCategory()
    {
        switch (category)
        {
        default:
            return null;

        case 1: // '\001'
            return "application";

        case 2: // '\002'
            return "request";

        case 3: // '\003'
            return "system";
        }
    }

    public String getDomain()
    {
        return null;
    }

    public int getId()
    {
        String s1 = code;
        if (!TextUtils.isEmpty(s1))
        {
            int i = s1.lastIndexOf('.');
            String s = s1;
            if (i != -1)
            {
                s = s1.substring(i + 1);
            }
            if (TextUtils.isDigitsOnly(s))
            {
                return Integer.parseInt(s);
            }
        }
        return 0;
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        if (shortMessage != null && longMessage != null && shortMessage.equals(longMessage))
        {
            return null;
        } else
        {
            return longMessage;
        }
    }

    public String getRemediationUrl()
    {
        return null;
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        switch (severity)
        {
        default:
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;

        case 2: // '\002'
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;

        case 1: // '\001'
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        }
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return shortMessage;
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        ebaycontext = getLongMessage(ebaycontext);
        return ebaycontext != null && ebaycontext.contains("</");
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append(getCategory()).append(' ').append(getSeverity()).append(' ').append(code);
        if (TextUtils.isEmpty(longMessage)) goto _L2; else goto _L1
_L1:
        stringbuilder.append(": \"").append(longMessage).append('"');
_L4:
        if (userDisplay)
        {
            stringbuilder.append(" (display to user)");
        }
        return stringbuilder.toString();
_L2:
        if (!TextUtils.isEmpty(shortMessage))
        {
            stringbuilder.append(": \"").append(shortMessage).append('"');
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
