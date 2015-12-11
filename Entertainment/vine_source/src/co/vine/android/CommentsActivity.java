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
import co.vine.android.client.AppController;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, VineLoggingException, CommentsFragment

public class CommentsActivity extends BaseControllerActionBarActivity
{

    public static final String EXTRA_HIDE_KEYBOARD = "hide_keyboard";
    public static final String EXTRA_POST_AUTHOR_ID = "post_author_id";
    public static final String EXTRA_POST_ID = "post_id";
    private static final String TAG = "commentsthread";

    public CommentsActivity()
    {
    }

    public static void start(Context context, long l, long l1, boolean flag)
    {
        Intent intent = new Intent(context, co/vine/android/CommentsActivity);
        intent.putExtra("post_id", l);
        intent.putExtra("post_author_id", l1);
        intent.putExtra("hide_keyboard", flag);
        context.startActivity(intent);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("commentsthread");
        if (fragment != null)
        {
            fragment.onActivityResult(i, j, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        if (mAppController == null)
        {
            mAppController = AppController.getInstance(this);
            CrashUtil.logException(new VineLoggingException(), (new StringBuilder()).append("App controller is null here, and now? ").append(mAppController).toString(), new Object[0]);
        }
        if (mAppController != null && mAppController.isLoggedIn())
        {
            setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e0067, Boolean.valueOf(true));
            Intent intent = getIntent();
            if (bundle == null)
            {
                bundle = new CommentsFragment();
                Bundle bundle1 = CommentsFragment.prepareArguments(intent, false);
                boolean flag = intent.getBooleanExtra("hide_keyboard", false);
                bundle1.putLong("post_id", intent.getLongExtra("post_id", -1L));
                bundle1.putLong("post_author_id", intent.getLongExtra("post_author_id", -1L));
                bundle1.putInt("empty_desc", 0x7f0e0064);
                bundle1.putBoolean("hide_keyboard", flag);
                bundle.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "commentsthread").commit();
                return;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100000, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
