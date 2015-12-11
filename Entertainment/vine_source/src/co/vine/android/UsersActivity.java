// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, UsersFragment

public class UsersActivity extends BaseControllerActionBarActivity
{

    public static final String EXTRA_ANCHOR = "anchor";
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";
    public static final String EXTRA_POST_ID = "post_id";
    public static final String EXTRA_USERS_TYPE = "u_type";
    public static final String EXTRA_USER_ID = "p_id";
    private UsersFragment mFragment;

    public UsersActivity()
    {
    }

    public static void launchUserListForNotification(Context context, long l, long l1)
    {
        Intent intent = new Intent(context, co/vine/android/UsersActivity);
        intent.putExtra("u_type", 12);
        intent.putExtra("notification_id", l);
        intent.putExtra("anchor", l1);
        context.startActivity(intent);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        mFragment.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        Intent intent;
        ActionBar actionbar;
        super.onCreate(bundle, 0x7f0300a2, true);
        intent = getIntent();
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
        actionbar = getSupportActionBar();
        intent.getIntExtra("u_type", 0);
        JVM INSTR lookupswitch 5: default 92
    //                   1: 149
    //                   2: 158
    //                   5: 167
    //                   9: 176
    //                   12: 185;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if (bundle == null)
        {
            mFragment = new UsersFragment();
            bundle = UsersFragment.prepareArguments(intent, false);
            bundle.putBoolean("refresh", true);
            mFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, mFragment).commit();
        }
        return;
_L2:
        actionbar.setTitle(0x7f0e0267);
        continue; /* Loop/switch isn't completed */
_L3:
        actionbar.setTitle(0x7f0e0266);
        continue; /* Loop/switch isn't completed */
_L4:
        actionbar.setTitle(0x7f0e0268);
        continue; /* Loop/switch isn't completed */
_L5:
        actionbar.setTitle(0x7f0e01b3);
        continue; /* Loop/switch isn't completed */
_L6:
        actionbar.setTitle("");
        if (true) goto _L1; else goto _L7
_L7:
    }
}
