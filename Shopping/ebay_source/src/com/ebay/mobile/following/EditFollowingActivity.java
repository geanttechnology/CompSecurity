// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.ebay.mobile.activities.BaseActivity;

// Referenced classes of package com.ebay.mobile.following:
//            EditFollowingFragment

public class EditFollowingActivity extends BaseActivity
{

    public EditFollowingActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b2);
        if (bundle == null)
        {
            Object obj = getIntent();
            bundle = new Bundle();
            bundle.putInt("followType", ((Intent) (obj)).getIntExtra("followType", 0));
            obj = new EditFollowingFragment();
            ((EditFollowingFragment) (obj)).setArguments(bundle);
            getFragmentManager().beginTransaction().add(0x7f1001c9, ((android.app.Fragment) (obj))).commit();
        }
    }
}
