// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen, CountryListAdapterItem

class val.countries extends ArrayAdapter
{

    final WelcomeScreen this$0;
    final CountryListAdapterItem val$countries[];

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        ((TextView)view.findViewById(0x1020014)).setCompoundDrawablesWithIntrinsicBounds(0, 0, val$countries[i].getFlagIcon().intValue(), 0);
        return view;
    }

    erItem(int i, int j, CountryListAdapterItem acountrylistadapteritem[], CountryListAdapterItem acountrylistadapteritem1[])
    {
        this$0 = final_welcomescreen;
        val$countries = acountrylistadapteritem1;
        super(Context.this, i, j, acountrylistadapteritem);
    }
}
