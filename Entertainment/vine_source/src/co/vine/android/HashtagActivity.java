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
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;

// Referenced classes of package co.vine.android:
//            BaseTimelineActivity, BaseTimelineFragment, ExploreTimelineFragment

public class HashtagActivity extends BaseTimelineActivity
{

    private static final String FRAGMENT_TAG = "hashtag";

    public HashtagActivity()
    {
    }

    public static void start(Context context, String s)
    {
        context.startActivity((new Intent(context, co/vine/android/HashtagActivity)).putExtra("category", "tag").putExtra("tag", s.substring(1, s.length())));
    }

    protected BaseTimelineFragment getCurrentTimeLineFragment()
    {
        return (BaseTimelineFragment)getSupportFragmentManager().findFragmentByTag("hashtag");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("hashtag");
        if (fragment instanceof BaseTimelineFragment)
        {
            fragment.onActivityResult(i, j, intent);
        }
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, false);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
        Object obj = getIntent();
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setTitle((new StringBuilder()).append("#").append(((Intent) (obj)).getStringExtra("tag")).toString());
        }
        if (bundle == null)
        {
            bundle = new ExploreTimelineFragment();
            obj = ExploreTimelineFragment.prepareArguments(((Intent) (obj)), false);
            ((Bundle) (obj)).putBoolean("refresh", true);
            bundle.setArguments(((Bundle) (obj)));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "hashtag").commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f10000a, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
