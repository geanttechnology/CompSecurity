// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel

public final class ResultStatusJsonModel extends JsonModel
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    public ResultStatusJsonModel(EbayContext ebaycontext, ResultStatus resultstatus)
    {
        if (resultstatus.hasError() || resultstatus.hasWarning())
        {
            errors = new ArrayList();
            if (resultstatus.hasMessage())
            {
                com.ebay.nautilus.kernel.content.ResultStatus.Message message;
                for (resultstatus = resultstatus.getMessages().iterator(); resultstatus.hasNext(); errors.add(new JsonModel.OperationError(ebaycontext, message)))
                {
                    message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next();
                }

            }
        }
    }
}
