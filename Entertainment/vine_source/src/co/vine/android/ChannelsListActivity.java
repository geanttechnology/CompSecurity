// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, ChannelsListFragment, BaseCursorListFragment

public class ChannelsListActivity extends BaseControllerActionBarActivity
{

    public static final String EXTRA_CHANNEL = "channel";
    public static final String EXTRA_CHANNEL_ID = "channel_id";
    public static final String EXTRA_SELECTED_CHANNEL = "selected_channel";

    public ChannelsListActivity()
    {
    }

    public void onChannelSelected(long l, String s)
    {
        Intent intent = new Intent();
        intent.putExtra("channel", s);
        intent.putExtra("channel_id", l);
        setResult(-1, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setRequestedOrientation(1);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e01bd, Boolean.valueOf(true));
        Intent intent = getIntent();
        if (bundle == null)
        {
            bundle = new ChannelsListFragment();
            long l = intent.getLongExtra("selected_channel", -1L);
            intent.putExtra("refresh", false);
            intent.putExtra("take_focus", true);
            intent.putExtra("selected_channel", l);
            bundle.setArguments(BaseCursorListFragment.prepareArguments(intent, false));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle).commit();
        }
    }
}
