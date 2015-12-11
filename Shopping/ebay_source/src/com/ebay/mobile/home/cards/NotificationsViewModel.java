// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import java.util.List;

public class NotificationsViewModel extends ViewModel
{

    public final List notifications;

    public NotificationsViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        if (contentgroup.contentSource != ContentSourceEnum.TODO)
        {
            throw new IllegalArgumentException("contentGroup.contentSource doesn't match what this viewModel accepts");
        }
        if (contentgroup.contents != null)
        {
            notifications = contentgroup.contents;
            return;
        } else
        {
            notifications = null;
            return;
        }
    }
}
