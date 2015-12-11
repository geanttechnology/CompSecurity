// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;

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
        obj = actionsfactory.fragment.getResources();
        ViewItemFragmentUtil.showDialog(actionsfactory.fragment, ((Resources) (obj)).getString(0x7f070601), null, ((Resources) (obj)).getString(0x7f070738), ((Resources) (obj)).getString(0x7f0701cc), 2);
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
