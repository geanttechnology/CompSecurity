// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.aqo;
import android.support.v7.ic;
import android.support.v7.io;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.view.MenuItem;
import android.widget.Toast;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.models.SearchParameters;
import com.abtnprojects.ambatana.ui.widgets.navigationdrawer.NavigationDrawerFragment;
import com.crashlytics.android.Crashlytics;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            c

public abstract class e extends c
{

    private BroadcastReceiver A;
    private IntentFilter n;
    protected NavigationDrawerFragment o;
    protected ic p;

    public e()
    {
        A = new BroadcastReceiver() {

            final e a;

            public void onReceive(Context context, Intent intent)
            {
                boolean flag = true;
                context = intent.getAction();
                aqo.a("Broadcast received : %s", new Object[] {
                    context
                });
                if (context != null)
                {
                    if (context.equals("com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver.USER_LOCATION_CHANGED"))
                    {
                        a.w = ParseUser.getCurrentUser();
                        a.o.e();
                    } else
                    if (context.equals(com.abtnprojects.ambatana.a.a.a.toString()) && intent.hasExtra(com.abtnprojects.ambatana.a.b.a.toString()))
                    {
                        int i = intent.getIntExtra(com.abtnprojects.ambatana.a.b.a.toString(), 0);
                        if (iu.c(a.w) && a.u != null)
                        {
                            context = a.u;
                            if (i <= 0)
                            {
                                flag = false;
                            }
                            context.setVisible(flag);
                        }
                        a.o.b(i);
                        return;
                    }
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
    }

    public SearchParameters C()
    {
        return is.a(this);
    }

    protected void a(int i)
    {
        super.a(i);
        o.c(i);
    }

    protected void a(CharSequence charsequence)
    {
        t = charsequence;
    }

    protected void c(Intent intent)
    {
        o.d();
        super.c(intent);
    }

    public void onBackPressed()
    {
        aqo.a("onBackPressed", new Object[0]);
        if (o != null && o.a())
        {
            o.c();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!iv.b(this))
        {
            q();
        }
        p = new ic(this);
        if (w.getObjectId() != null)
        {
            Crashlytics.setUserIdentifier(w.getObjectId());
        }
        n = new IntentFilter();
        n.addAction(com.abtnprojects.ambatana.a.a.a.toString());
        io.a(w, ParseInstallation.getCurrentInstallation());
        if (!com.abtnprojects.ambatana.e.a.booleanValue())
        {
            Toast.makeText(this, getString(0x7f090075), 1).show();
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null)
        {
            intent = intent.getData();
            if (intent != null && "home".equalsIgnoreCase(intent.getHost()) && "".equalsIgnoreCase(intent.getPath()))
            {
                t();
            }
        }
    }

    protected void onPause()
    {
        super.onPause();
        LetgoApplication.g();
        try
        {
            unregisterReceiver(A);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            aqo.b(illegalargumentexception, "onPause", new Object[0]);
        }
        iv.a(s);
    }

    protected void onResume()
    {
        super.onResume();
        registerReceiver(A, n);
        r();
    }

    protected void p()
    {
        super.p();
        o = (NavigationDrawerFragment)getFragmentManager().findFragmentById(0x7f100083);
        o.a(0x7f100083, (DrawerLayout)findViewById(0x7f100081), y);
    }
}
