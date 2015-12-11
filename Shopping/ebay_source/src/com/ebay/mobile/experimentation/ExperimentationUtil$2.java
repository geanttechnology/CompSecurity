// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.experimentation:
//            ExperimentationUtil

static final class val.context
    implements Runnable
{

    final EbayContext val$context;

    public void run()
    {
        if (ExperimentationUtil.getManager(val$context) != null)
        {
            boolean _tmp = ExperimentationUtil.access$402(true);
        }
    }

    (EbayContext ebaycontext)
    {
        val$context = ebaycontext;
        super();
    }
}
