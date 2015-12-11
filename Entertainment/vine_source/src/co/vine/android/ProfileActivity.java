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
import android.view.Menu;
import android.view.MenuInflater;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            BaseTimelineActivity, BaseTimelineFragment, ProfileFragment, BaseArrayListFragment

public class ProfileActivity extends BaseTimelineActivity
{

    private static final String EXTRA_FOLLOW_EVENT_SOURCE = "event_source";
    private static final String EXTRA_SHOW_PROFILE_ACTIONS = "show_profile_actions";
    private static final String EXTRA_USER_ID = "user_id";
    private static final String EXTRA_VANITY_URL = "vanity_url";

    public ProfileActivity()
    {
    }

    public static void start(Context context, long l, String s)
    {
        start(context, l, s, true);
    }

    public static void start(Context context, long l, String s, boolean flag)
    {
        Intent intent = new Intent(context, co/vine/android/ProfileActivity);
        intent.putExtra("user_id", l);
        intent.putExtra("event_source", s);
        intent.putExtra("show_profile_actions", flag);
        context.startActivity(intent);
    }

    public static void start(Context context, ArrayList arraylist, String s)
    {
        Intent intent = new Intent(context, co/vine/android/ProfileActivity);
        intent.putStringArrayListExtra("vanity_url", arraylist);
        intent.putExtra("event_source", s);
        context.startActivity(intent);
    }

    protected BaseTimelineFragment getCurrentTimeLineFragment()
    {
        return (BaseTimelineFragment)getSupportFragmentManager().findFragmentByTag("profile");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("profile");
        if (fragment instanceof BaseTimelineFragment)
        {
            fragment.onActivityResult(i, j, intent);
        }
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setRequestedOrientation(1);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e019c, Boolean.valueOf(true));
        Intent intent = getIntent();
        if (bundle == null)
        {
            bundle = new ProfileFragment();
            intent.putExtra("refresh", true);
            intent.putExtra("take_focus", true);
            bundle.setArguments(BaseArrayListFragment.prepareArguments(intent, true));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "profile").commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f10000a, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
