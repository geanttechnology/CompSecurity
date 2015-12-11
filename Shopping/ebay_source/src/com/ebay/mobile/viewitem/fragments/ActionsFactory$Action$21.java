// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.EbnOrderDetailsActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.verboseLogger)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        EbnOrderDetailsActivity.StartActivity(actionsfactory.fragment.getActivity(), ActionsFactory.access$100(actionsfactory), new SourceIdentification(((BaseActivity)actionsfactory.fragment.getActivity()).getTrackingEventName()));
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
