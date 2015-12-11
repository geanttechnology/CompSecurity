// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;


// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment, ViewItemFragmentPaymentUtil

static final class nit> extends nit>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        ViewItemFragmentPaymentUtil.payForItems(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory), ActionsFactory.access$100(actionsfactory), 1, Boolean.valueOf(false), 107, null, null);
    }

    til(String s, int i)
    {
        super(s, i, null);
    }
}
