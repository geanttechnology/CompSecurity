// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

public class FreeSampleListActivity extends BaseActivity
{

    private PageFreeSampleListFragment e;

    public FreeSampleListActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_free_sample_list);
        c();
        if (bundle == null)
        {
            e = new PageFreeSampleListFragment();
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
        }
    }

    public void onRightBtnClick(View view)
    {
        c.a(this, "");
        finish();
    }
}
