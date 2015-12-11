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

// Referenced classes of package co.vine.android:
//            BaseTimelineActivity, BaseTimelineFragment, SingleFragment, BaseArrayListFragment

public class SingleActivity extends BaseTimelineActivity
{

    private static final String EXTRA_LOCKED = "locked";
    private static final String EXTRA_POST_ID = "post_id";
    private static final String EXTRA_SHARE_ID = "post_share_id";
    private static final String EXTRA_USERNAME = "username";
    private static final String EXTRA_USER_ID = "userId";
    private static final String FRAGMENT_TAG = "single_post";

    public SingleActivity()
    {
    }

    public static Intent getIntent(Context context, long l)
    {
        context = new Intent(context, co/vine/android/SingleActivity);
        context.putExtra("post_id", l);
        return context;
    }

    public static void start(Context context, long l)
    {
        context.startActivity(getIntent(context, l));
    }

    public static void start(Context context, String s)
    {
        Intent intent = new Intent(context, co/vine/android/SingleActivity);
        intent.putExtra("post_share_id", s);
        context.startActivity(intent);
    }

    public static void startLocked(Context context, long l, String s, long l1)
    {
        Intent intent = new Intent(context, co/vine/android/SingleActivity);
        intent.putExtra("post_id", l);
        intent.putExtra("locked", true);
        intent.putExtra("username", s);
        intent.putExtra("userId", l1);
        context.startActivity(intent);
    }

    protected BaseTimelineFragment getCurrentTimeLineFragment()
    {
        return (BaseTimelineFragment)getSupportFragmentManager().findFragmentByTag("single_post");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("single_post");
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
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e0248, Boolean.valueOf(true));
        Intent intent = getIntent();
        if (bundle == null)
        {
            bundle = new SingleFragment();
            intent.putExtra("take_focus", true);
            bundle.setArguments(BaseArrayListFragment.prepareArguments(intent, false));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "single_post").commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f10000a, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
