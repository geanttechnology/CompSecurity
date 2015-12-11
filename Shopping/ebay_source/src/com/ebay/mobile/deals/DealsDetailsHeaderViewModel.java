// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import com.ebay.mobile.common.view.ViewModel;

public class DealsDetailsHeaderViewModel extends ViewModel
{

    public final String subtitle;
    public final String title;

    public DealsDetailsHeaderViewModel(int i, String s, String s1, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        title = s;
        subtitle = s1;
    }
}
