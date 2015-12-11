// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.activities.AfterSalesWebViewActivity;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory

static final class it> extends it>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        AfterSalesWebViewActivity.startActivity(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), com.ebay.mobile.activities..AfterSalesType.CANCEL_ENTRY);
    }

    lesType(String s, int i)
    {
        super(s, i, null);
    }
}
