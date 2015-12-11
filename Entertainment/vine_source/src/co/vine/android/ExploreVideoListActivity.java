// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

// Referenced classes of package co.vine.android:
//            BaseTimelineActivity, BaseTimelineFragment, ExploreTimelineFragment

public class ExploreVideoListActivity extends BaseTimelineActivity
{

    private static final String FRAGMENT_TAG = "explore_video_list";
    private static final String QUERY_TITLE = "title";

    public ExploreVideoListActivity()
    {
    }

    public static Intent getIntent(Context context, String s, String s1)
    {
        Intent intent = new Intent(context, co/vine/android/ExploreVideoListActivity);
        s = (new StringBuilder()).append("vine://").append(s);
        if (s1 != null)
        {
            context = (new StringBuilder()).append("/").append(s1).toString();
        } else
        {
            context = "";
        }
        return intent.setData(Uri.parse(s.append(context).toString()));
    }

    public static void start(Context context, Uri uri)
    {
        Intent intent = new Intent(context, co/vine/android/ExploreVideoListActivity);
        intent.setData(uri);
        context.startActivity(intent);
    }

    protected BaseTimelineFragment getCurrentTimeLineFragment()
    {
        return (BaseTimelineFragment)getSupportFragmentManager().findFragmentByTag("explore_video_list");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("explore_video_list");
        if (fragment instanceof BaseTimelineFragment)
        {
            fragment.onActivityResult(i, j, intent);
        }
        super.onActivityResult(i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        Intent intent = getIntent();
        Uri uri = getIntent().getData();
        if (uri == null)
        {
            throw new IllegalAccessError("You can't access video list without specifying a url.");
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
        ActionBar actionbar = getSupportActionBar();
        if ("tag".equals(uri.getHost()))
        {
            actionbar.setTitle((new StringBuilder()).append("#").append(uri.getLastPathSegment()).toString());
        } else
        if ("trending-people".equals(uri.getHost()))
        {
            actionbar.setTitle(0x7f0e0166);
        } else
        if ("popular-now".equals(uri.getHost()))
        {
            actionbar.setTitle(0x7f0e0178);
        } else
        if ("timelines".equals(uri.getHost()))
        {
            String s = uri.getQueryParameter("title");
            if (!TextUtils.isEmpty(s))
            {
                actionbar.setTitle(s.replace('+', ' '));
            } else
            {
                actionbar.setTitle(getString(0x7f0e023e));
            }
        } else
        {
            Toast.makeText(this, "All post is not supported at this moment, it's just here to tease you. ", 0).show();
            finish();
            return;
        }
        if (bundle == null)
        {
            bundle = new ExploreTimelineFragment();
            intent.putExtra("refresh", true);
            bundle.setArguments(ExploreTimelineFragment.prepareArguments(intent, true, uri.getHost(), uri.getLastPathSegment(), uri));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "explore_video_list").commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f10000a, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
