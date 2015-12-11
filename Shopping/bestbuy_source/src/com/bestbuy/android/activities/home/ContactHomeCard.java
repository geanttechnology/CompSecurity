// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class ContactHomeCard extends BBYBaseFragment
{

    private String a;

    public ContactHomeCard()
    {
    }

    public ContactHomeCard(String s)
    {
        a = s;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030040, viewgroup, false);
        ((BBYTextView)layoutinflater.findViewById(0x7f0c0108)).setText(a);
        return layoutinflater;
    }
}
