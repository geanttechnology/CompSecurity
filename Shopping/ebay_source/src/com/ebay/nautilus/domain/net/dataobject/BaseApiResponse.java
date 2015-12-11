// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.dataobject;

import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.net.EbayResponseError;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.net.dataobject:
//            ErrorMessageContainer

public abstract class BaseApiResponse extends BaseDataMapped
{

    protected String ack;
    protected String ackValue;
    protected String build;
    protected ErrorMessageContainer errorMessages;
    protected List errors;
    protected Date timestamp;
    protected String version;

    public BaseApiResponse()
    {
    }

    protected static int getAckOverride(List list)
    {
        byte byte0 = 2;
        if (list == null || list.isEmpty())
        {
            byte0 = 1;
        } else
        {
            EbayResponseError ebayresponseerror = (EbayResponseError)list.get(0);
            Iterator iterator = list.iterator();
            do
            {
                list = ebayresponseerror;
                if (!iterator.hasNext())
                {
                    break;
                }
                list = (EbayResponseError)iterator.next();
            } while (((EbayResponseError) (list)).severity != 1);
            if (((EbayResponseError) (list)).severity != 2)
            {
                return -1;
            }
        }
        return byte0;
    }

    public int getAck()
    {
        String s;
        if (TextUtils.isEmpty(ackValue))
        {
            s = ack;
        } else
        {
            s = ackValue;
        }
        if (!TextUtils.isEmpty(s))
        {
            s = s.toLowerCase(Locale.US);
        } else
        {
            s = "";
        }
        if (s.equals("success"))
        {
            return 1;
        }
        if (s.equals("warning"))
        {
            return 2;
        }
        if (s.equals("customcode"))
        {
            return 0;
        }
        if (s.equals("partialfailure"))
        {
            return -2;
        }
        if (s.equals("failure"))
        {
            return -1;
        } else
        {
            return getAckOverride(getErrors());
        }
    }

    public String getBuild()
    {
        return build;
    }

    public List getErrors()
    {
        if (errors != null && !errors.isEmpty())
        {
            return errors;
        }
        if (errorMessages != null)
        {
            return errorMessages.getErrors();
        } else
        {
            return null;
        }
    }

    public long getHostTime()
    {
        if (timestamp == null)
        {
            return 0L;
        } else
        {
            return timestamp.getTime();
        }
    }

    public String getVersion()
    {
        return version;
    }

    public void setBuild(String s)
    {
        build = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
