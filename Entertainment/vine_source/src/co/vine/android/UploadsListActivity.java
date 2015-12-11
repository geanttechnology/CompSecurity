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
//            BaseControllerActionBarActivity, UploadsListFragment, BaseCursorListFragment

public class UploadsListActivity extends BaseControllerActionBarActivity
{

    public UploadsListActivity()
    {
    }

    public static void start(Context context)
    {
        Intent intent = new Intent(context, co/vine/android/UploadsListActivity);
        intent.setFlags(0x4000000);
        context.startActivity(intent);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0a0102);
        if (fragment != null)
        {
            fragment.onActivityResult(i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setRequestedOrientation(1);
        Intent intent = getIntent();
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e025c, Boolean.valueOf(false));
        if (bundle == null)
        {
            bundle = new UploadsListFragment();
            intent.putExtra("take_focus", true);
            intent.putExtra("refresh", false);
            intent.putExtra("empty_desc", 0x7f0e0153);
            bundle.setArguments(BaseCursorListFragment.prepareArguments(intent, false));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle).commit();
        }
    }
}
