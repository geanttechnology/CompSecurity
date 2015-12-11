// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            ResultStatus

public class ResultStatusOwner
{

    private ResultStatus resultStatus;

    public ResultStatusOwner()
    {
        resultStatus = ResultStatus.SUCCESS;
    }

    public final void addResultMessage(Collection collection)
    {
        if (collection == null || collection.size() < 1)
        {
            return;
        }
        if (resultStatus == ResultStatus.SUCCESS)
        {
            resultStatus = ResultStatus.create(collection);
            return;
        } else
        {
            resultStatus.initializeMessages().addAll(collection);
            return;
        }
    }

    public final transient void addResultMessage(ResultStatus.Message amessage[])
    {
        if (amessage == null || amessage.length < 1)
        {
            return;
        }
        if (resultStatus == ResultStatus.SUCCESS)
        {
            resultStatus = ResultStatus.create(amessage);
            return;
        }
        if (amessage.length == 1)
        {
            resultStatus.initializeMessages().add(amessage[0]);
            return;
        } else
        {
            resultStatus.initializeMessages().addAll(Arrays.asList(amessage));
            return;
        }
    }

    public final ResultStatus getResultStatus()
    {
        return resultStatus;
    }

    public final void setResultStatus(ResultStatus resultstatus)
    {
        if (resultstatus == null)
        {
            throw new IllegalArgumentException("Status must not be null!");
        } else
        {
            resultStatus = resultstatus;
            return;
        }
    }
}
