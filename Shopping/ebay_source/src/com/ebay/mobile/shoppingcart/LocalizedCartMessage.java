// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.ebay.nautilus.kernel.content.EbayContext;

public class LocalizedCartMessage
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{

    private static final SparseIntArray errorCodeToMessageMap = new SparseIntArray() {

            
            {
                put(104, 0x7f070a87);
                put(106, 0x7f070a88);
                put(423, 0x7f070a8a);
                put(3005, 0x7f070a8c);
                put(11002, 0x7f070a86);
                put(1015, 0x7f070a89);
                put(147, 0x7f070aa6);
                put(1011, 0x7f070a85);
            }
    };
    private final com.ebay.nautilus.kernel.content.ResultStatus.Message innerMessage;

    public LocalizedCartMessage(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        innerMessage = message;
    }

    public static String getDisplayableErrorMessageFromErrorCode(EbayContext ebaycontext, Integer integer)
    {
label0:
        {
            Object obj = null;
            if (integer.intValue() != 0)
            {
                obj = Integer.valueOf(errorCodeToMessageMap.get(integer.intValue()));
                if (((Integer) (obj)).intValue() <= 0)
                {
                    break label0;
                }
                obj = ebaycontext.getString(((Integer) (obj)).intValue());
            }
            return ((String) (obj));
        }
        return (new StringBuilder()).append(ebaycontext.getString(0x7f070a8b)).append(" (").append(integer).append(")").toString();
    }

    public boolean displayToUser()
    {
        return innerMessage.displayToUser();
    }

    public String getCategory()
    {
        return innerMessage.getCategory();
    }

    public String getDomain()
    {
        return innerMessage.getDomain();
    }

    public int getId()
    {
        return innerMessage.getId();
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        String s1 = getDisplayableErrorMessageFromErrorCode(ebaycontext, Integer.valueOf(getId()));
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = innerMessage.getLongMessage(ebaycontext);
        }
        return s;
    }

    public String getRemediationUrl()
    {
        return innerMessage.getRemediationUrl();
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        return innerMessage.getSeverity();
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        String s1 = getDisplayableErrorMessageFromErrorCode(ebaycontext, Integer.valueOf(getId()));
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = innerMessage.getShortMessage(ebaycontext);
        }
        return s;
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return innerMessage.isLongMessageHtml(ebaycontext);
    }

}
