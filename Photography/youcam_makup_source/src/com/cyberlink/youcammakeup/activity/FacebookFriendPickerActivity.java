// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.facebook.FacebookException;
import com.facebook.widget.FriendPickerFragment;
import com.facebook.widget.PickerFragment;
import java.util.UUID;

public class FacebookFriendPickerActivity extends FragmentActivity
{

    public static final UUID a = UUID.randomUUID();
    private static final String b = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private FriendPickerFragment c;

    public FacebookFriendPickerActivity()
    {
    }

    static void a(FacebookFriendPickerActivity facebookfriendpickeractivity)
    {
        facebookfriendpickeractivity.b();
    }

    static void a(FacebookFriendPickerActivity facebookfriendpickeractivity, String s)
    {
        facebookfriendpickeractivity.a(s);
    }

    private void a(String s)
    {
        s = new r() {

            final FacebookFriendPickerActivity a;

            public void a()
            {
                Globals.d().i().a(null);
                FacebookFriendPickerActivity.a(a);
            }

            
            {
                a = FacebookFriendPickerActivity.this;
                super();
            }
        };
        Globals.d().i().a(s);
        Globals.d().i().a(this, null, Globals.d().getString(0x7f07051d), true);
    }

    private void b()
    {
        Globals globals = Globals.d();
        if (c != null)
        {
            globals.a(c.getSelection());
        }
        finish();
    }

    protected void a()
    {
        Globals.d().c("facebookFriendPickerPage");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000e);
        StatusManager.j().a("facebookFriendPickerPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.g, this);
        if (Globals.d().v() == "facebookFriendPickerPage")
        {
            StatusManager.j().D();
        }
        Bundle bundle1 = getIntent().getExtras();
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (bundle == null)
        {
            c = new FriendPickerFragment(bundle1);
        } else
        {
            c = (FriendPickerFragment)fragmentmanager.findFragmentById(0x7f0c0112);
        }
        c.setFriendPickerType(com.facebook.widget.FriendPickerFragment.FriendPickerType.TAGGABLE_FRIENDS);
        if (Globals.d().E() != null)
        {
            c.setSelection(Globals.d().E());
            c.setInitialLoad(false);
        }
        c.setOnErrorListener(new com.facebook.widget.PickerFragment.OnErrorListener() {

            final FacebookFriendPickerActivity a;

            public void onError(PickerFragment pickerfragment, FacebookException facebookexception)
            {
                FacebookFriendPickerActivity.a(a, facebookexception.getMessage());
            }

            
            {
                a = FacebookFriendPickerActivity.this;
                super();
            }
        });
        c.setOnDoneButtonClickedListener(new com.facebook.widget.PickerFragment.OnDoneButtonClickedListener() {

            final FacebookFriendPickerActivity a;

            public void onDoneButtonClicked(PickerFragment pickerfragment)
            {
                FacebookFriendPickerActivity.a(a);
            }

            
            {
                a = FacebookFriendPickerActivity.this;
                super();
            }
        });
        bundle = c;
        fragmentmanager.beginTransaction().replace(0x7f0c0112, bundle).commit();
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.g, null);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            if (Globals.d().i().a())
            {
                return false;
            } else
            {
                finish();
                return true;
            }
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        a();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(b, StatusManager.j());
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("facebookFriendPickerPage");
        StatusManager.j().a(Boolean.valueOf(true));
        try
        {
            c.loadData(false);
            return;
        }
        catch (Exception exception)
        {
            a(exception.getMessage());
        }
    }

    public void onStop()
    {
        super.onStop();
    }

}
