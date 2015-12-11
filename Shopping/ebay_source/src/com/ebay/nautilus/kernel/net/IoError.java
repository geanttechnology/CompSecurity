// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class IoError
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{

    private final IOException exception;
    public volatile String message;

    public IoError(IOException ioexception)
    {
        exception = ioexception;
        message = ioexception.getLocalizedMessage();
    }

    public static boolean hasAnyIoError(ResultStatus resultstatus)
    {
        if (resultstatus != null)
        {
            if ((resultstatus = resultstatus.getMessages()) != null)
            {
                resultstatus = resultstatus.iterator();
                while (resultstatus.hasNext()) 
                {
                    if ((com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next() instanceof IoError)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean displayToUser()
    {
        return !TextUtils.isEmpty(message);
    }

    public String getCategory()
    {
        return "network";
    }

    public String getDomain()
    {
        return null;
    }

    public final IOException getException()
    {
        return exception;
    }

    public int getId()
    {
        return 0;
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
        return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        if (TextUtils.isEmpty(message))
        {
            return exception.getClass().getName();
        } else
        {
            return message;
        }
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("exception:").append(exception).toString();
    }
}
