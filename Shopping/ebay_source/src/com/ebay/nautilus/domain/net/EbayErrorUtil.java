// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.uas.IsValidForRequest;
import com.ebay.nautilus.domain.net.api.uas.IsValidForResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Response;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponseError

public class EbayErrorUtil
{

    private static final String IGNORED_SUFFIX = "_IGNORED";
    private static final int INVALID_IAF_TOKEN = 0x14e6d38;
    private static final int SOA_INVALID_IAF_TOKEN = 11002;

    public EbayErrorUtil()
    {
    }

    private static boolean invalidIafToken(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        int i = message.getId();
        return (message instanceof EbayResponseError) && (i == 0x14e6d38 || i == 11002 && "Security".equals(message.getDomain()));
    }

    public static boolean invalidIafToken(ResultStatus resultstatus)
    {
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.B.invalidIafTokenValidation) && resultstatus != null && resultstatus.hasMessage())
        {
            resultstatus = resultstatus.getMessages().iterator();
            while (resultstatus.hasNext()) 
            {
                if (invalidIafToken((com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void validateInvalidIafTokenError(EbayContext ebaycontext, String s, String s1, Response response)
        throws InterruptedException
    {
        NautilusKernel.verifyNotMain();
        response = response.getResultStatus();
        break MISSING_BLOCK_LABEL_8;
        if (response.hasMessage() && !TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && ((IsValidForResponse)ebaycontext.getConnector().sendRequest(new IsValidForRequest(s, s1))).isValid())
        {
            ebaycontext = response.getMessages().iterator();
            while (ebaycontext.hasNext()) 
            {
                s = (com.ebay.nautilus.kernel.content.ResultStatus.Message)ebaycontext.next();
                if (invalidIafToken(s))
                {
                    s = (EbayResponseError)s;
                    s.code = (new StringBuilder()).append(((EbayResponseError) (s)).code).append("_IGNORED").toString();
                }
            }
        }
        return;
    }
}
