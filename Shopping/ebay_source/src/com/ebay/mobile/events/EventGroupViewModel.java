// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import com.ebay.mobile.common.view.ViewModel;

public class EventGroupViewModel extends ViewModel
{

    public final String name;

    public EventGroupViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEventGroup rppeventgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        if (rppeventgroup == null)
        {
            name = null;
            return;
        } else
        {
            name = rppeventgroup.displayName;
            return;
        }
    }
}
