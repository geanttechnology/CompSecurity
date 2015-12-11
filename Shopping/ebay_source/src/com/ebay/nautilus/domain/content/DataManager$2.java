// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.concurrent.Callable;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

static final class val.key
    implements Callable
{

    final EbayContext val$context;
    final taManagerKeyParams val$key;

    public DataManager call()
    {
        return DataManager.access$000(val$context, val$key);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    taManagerKeyParams(EbayContext ebaycontext, taManagerKeyParams tamanagerkeyparams)
    {
        val$context = ebaycontext;
        val$key = tamanagerkeyparams;
        super();
    }
}
