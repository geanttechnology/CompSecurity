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
import com.cyberlink.beautycircle.controller.fragment.j;
import com.cyberlink.beautycircle.k;

public class CircleGroupActivity extends BaseActivity
{

    private j e;

    public CircleGroupActivity()
    {
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        if (e != null)
        {
            e.onActivityResult(i, l, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_circle_group);
        Object obj = getIntent();
        if (obj != null)
        {
            obj = ((Intent) (obj)).getStringExtra("Title");
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            obj = "";
        }
        b(((String) (obj)));
        b().a();
        if (bundle == null)
        {
            e = new j();
            getSupportFragmentManager().beginTransaction().add(com.cyberlink.beautycircle.j.fragment_main_panel, e).commit();
        }
    }
}
