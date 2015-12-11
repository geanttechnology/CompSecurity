// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mdot;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import lu;

// Referenced classes of package com.bestbuy.android.activities.mdot:
//            MdotWebFragment

public class MdotWebActivity extends BBYBaseFragmentActivity
{

    private BBYBaseFragment a;
    private String b;
    private String c;

    public MdotWebActivity()
    {
        b = "";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000c);
        Bundle bundle1 = getIntent().getExtras();
        if (getIntent().hasExtra(getResources().getString(0x7f080055)))
        {
            c = bundle1.getString(getResources().getString(0x7f080055));
        }
        if (findViewById(0x7f0c0056) == null || bundle != null)
        {
            return;
        } else
        {
            a = new MdotWebFragment();
            a.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(0x7f0c0056, a).commit();
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        lu.a();
    }

    public void onResume()
    {
        super.onResume();
        lu.a(this);
    }
}
