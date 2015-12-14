// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import com.socialin.android.picsart.profile.fragment.n;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ContestRulesActivity

public class ContestByGroupActivity extends ContestRulesActivity
{

    private String a;

    public ContestByGroupActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03026b);
        bundle = getIntent();
        if (bundle != null && bundle.hasExtra("contestPrefix"))
        {
            a = bundle.getStringExtra("contestPrefix");
        }
        if (!TextUtils.isEmpty(a))
        {
            super.d = (new StringBuilder("http://picsart.com/")).append(a).append("rules").toString();
        }
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setDisplayShowHomeEnabled(true);
            bundle.setIcon(getResources().getDrawable(0x7f020404));
            bundle.setTitle((new StringBuilder()).append(a.toUpperCase()).append(" ").append(getString(0x7f0805b3).toLowerCase()).toString());
        }
        bundle = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("contestFragmentTag");
        if (fragment != null && fragment.isAdded())
        {
            bundle.show(fragment);
        } else
        {
            n n1 = new n();
            Bundle bundle1 = new Bundle();
            bundle1.putString("contestPrefix", a);
            n1.setArguments(bundle1);
            bundle.add(0x7f100add, n1, "contestFragmentTag");
        }
        bundle.commit();
    }
}
