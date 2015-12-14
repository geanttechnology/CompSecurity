// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.fragment.l;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;

public class DiscoverActivity extends BaseActivity
{

    private l e;

    public DiscoverActivity()
    {
    }

    protected void onActivityResult(int i, int i1, Intent intent)
    {
        super.onActivityResult(i, i1, intent);
        if (e != null)
        {
            e.onActivityResult(i, i1, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_discover);
        b(m.bc_developer_multi_column);
        if (bundle == null)
        {
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
        }
    }
}
