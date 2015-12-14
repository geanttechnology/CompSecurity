// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.livemixtapes.ui.BaseActivity;

// Referenced classes of package com.livemixtapes:
//            ProfileFragment

public class ProfileActivity extends BaseActivity
{

    public ProfileActivity()
    {
    }

    public void onBackPressed()
    {
        int i = getFragmentManager().getBackStackEntryCount();
        if (i != 0)
        {
            if (i == 1)
            {
                onResume();
            }
            getFragmentManager().popBackStack();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030031);
        getFragmentManager().beginTransaction().add(0x7f0800cc, new ProfileFragment()).commit();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100002, menu);
        return true;
    }

    public volatile View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(view, s, context, attributeset);
    }

    public volatile View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(s, context, attributeset);
    }
}
