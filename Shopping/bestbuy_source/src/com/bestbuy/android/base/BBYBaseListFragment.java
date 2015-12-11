// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import nb;

public class BBYBaseListFragment extends ListFragment
{

    protected Activity a;
    protected nb b;

    public BBYBaseListFragment()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = nb.a();
    }
}
