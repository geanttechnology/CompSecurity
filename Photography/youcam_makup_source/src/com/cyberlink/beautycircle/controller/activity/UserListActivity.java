// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.ac;
import com.cyberlink.beautycircle.controller.a.v;
import com.cyberlink.beautycircle.controller.a.w;
import com.cyberlink.beautycircle.controller.fragment.u;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.a.b;

public class UserListActivity extends BaseActivity
{

    com.cyberlink.beautycircle.model.network.NetworkUser.UserListType e;

    public UserListActivity()
    {
    }

    private void a(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType userlisttype)
    {
        if (userlisttype == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f)
        {
            b.a(new w());
        } else
        {
            if (userlisttype == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g)
            {
                b.a(new v());
                return;
            }
            if (userlisttype == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h)
            {
                b.a(new ac());
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
label0:
        {
            obj = null;
            super.onCreate(bundle);
            setContentView(k.bc_activity_user_list);
            if (bundle == null)
            {
                bundle = getIntent();
                if (bundle != null)
                {
                    bundle = (com.cyberlink.beautycircle.model.network.NetworkUser.UserListType)bundle.getSerializableExtra("UserListType");
                } else
                {
                    bundle = null;
                }
                e = bundle;
                if (e != null)
                {
                    break label0;
                }
                Globals.b("No user list type.");
                super.e();
            }
            return;
        }
        u u1 = new u();
        if (e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.c || e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a)
        {
            bundle = Integer.valueOf(m.bc_me_status_follower);
        } else
        if (e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b)
        {
            bundle = Integer.valueOf(m.bc_me_followed_people);
        } else
        if (e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.e)
        {
            bundle = Integer.valueOf(m.bc_joinlist_title);
        } else
        if (e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f)
        {
            bundle = Integer.valueOf(m.bc_brands_title);
        } else
        if (e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g)
        {
            bundle = Integer.valueOf(m.bc_celebrities_title);
        } else
        {
            bundle = obj;
            if (e == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h)
            {
                bundle = Integer.valueOf(m.bc_discovery_editorial);
            }
        }
        if (u1 != null && bundle != null)
        {
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, u1).commit();
            b(bundle.intValue());
            return;
        } else
        {
            Globals.b("Invalid user list type.");
            super.e();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        a(e);
    }
}
