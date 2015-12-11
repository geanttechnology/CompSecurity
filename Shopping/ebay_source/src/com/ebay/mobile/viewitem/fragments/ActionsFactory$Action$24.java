// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;


// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment, ViewItemFragmentUtil

static final class it> extends it>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.verboseLogger)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        ViewItemFragmentUtil.sellOneLikeThis(actionsfactory.fragment, ActionsFactory.access$1900(actionsfactory));
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
