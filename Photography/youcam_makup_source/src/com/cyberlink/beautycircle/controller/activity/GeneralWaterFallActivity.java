// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.f;
import com.cyberlink.beautycircle.controller.fragment.n;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

public class GeneralWaterFallActivity extends BaseActivity
{

    private f e;

    public GeneralWaterFallActivity()
    {
        e = null;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_me);
        Intent intent = getIntent();
        int i;
        if (intent != null)
        {
            bundle = intent.getStringExtra("Title");
        } else
        {
            bundle = null;
        }
        b(bundle);
        b().a();
        if (intent != null)
        {
            i = intent.getIntExtra("ListMode", 1);
        } else
        {
            i = 1;
        }
        i;
        JVM INSTR tableswitch 1 1: default 72
    //                   1 130;
           goto _L1 _L2
_L1:
        if (e != null)
        {
            bundle = new Bundle();
            bundle.putAll(intent.getExtras());
            e.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
        }
        return;
_L2:
        e = new n();
        if (true) goto _L1; else goto _L3
_L3:
    }
}
