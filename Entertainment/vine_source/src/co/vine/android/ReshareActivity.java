// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, ReshareFragment

public class ReshareActivity extends BaseControllerActionBarActivity
{

    public static final String EXTRA_NETWORK = "network";
    public static final String NETWORK_FACEBOOK = "facebook";
    public static final String NETWORK_TWITTER = "twitter";

    public ReshareActivity()
    {
    }

    public static Intent getReshareIntent(Context context, String s, Bundle bundle)
    {
        context = new Intent(context, co/vine/android/ReshareActivity);
        context.putExtras(bundle);
        context.putExtra("network", s);
        if ("twitter".equals(s))
        {
            context.putExtra("title", 0x7f0e0211);
        } else
        if ("facebook".equals(s))
        {
            context.putExtra("title", 0x7f0e0210);
            return context;
        }
        return context;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("reshare");
        if (fragment instanceof ReshareFragment)
        {
            fragment.onActivityResult(i, j, intent);
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = true;
        super.onCreate(bundle, 0x7f030046, true);
        setRequestedOrientation(1);
        Intent intent = getIntent();
        int i = intent.getIntExtra("title", 0);
        Integer integer;
        if (i <= 0)
        {
            flag = false;
        }
        if (i > 0)
        {
            integer = Integer.valueOf(i);
        } else
        {
            integer = null;
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(flag), integer.intValue(), null);
        if (bundle == null)
        {
            bundle = new ReshareFragment();
            bundle.setArguments(ReshareFragment.prepareArguments(intent));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "reshare").commit();
        }
    }
}
