// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;

public class DepartmentNameViewModel extends ViewModel
{

    public final Channel channel;
    public boolean hasDisclosureArrow;
    public boolean isSelected;
    public final int position;
    public final int size;

    public DepartmentNameViewModel(int i, Channel channel1, int j, int k, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        isSelected = false;
        hasDisclosureArrow = false;
        channel = channel1;
        position = j;
        size = k;
    }
}
