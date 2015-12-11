// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.content.Context;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapterWithHeader;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            ItemLocationController

class hHeader extends RefineSingleOptionAdapterWithHeader
{

    final ItemLocationController this$0;

    hHeader(Context context, List list)
    {
        this$0 = ItemLocationController.this;
        super(context, list);
    }
}
