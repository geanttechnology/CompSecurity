// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            ErrorFormatter, FormattedError

public class ChainedErrorFormatter
    implements ErrorFormatter
{

    private final List formatterChain;

    public ChainedErrorFormatter(List list)
    {
        Validate.notNull(list);
        formatterChain = list;
    }

    public FormattedError formatError(Throwable throwable)
    {
        for (Iterator iterator = formatterChain.iterator(); iterator.hasNext();)
        {
            FormattedError formattederror = ((ErrorFormatter)iterator.next()).formatError(throwable);
            if (formattederror != null)
            {
                return formattederror;
            }
        }

        return null;
    }
}
