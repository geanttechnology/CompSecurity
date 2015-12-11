// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.ajx;
import android.support.v7.app.ActionBar;
import android.support.v7.aqo;
import android.support.v7.dz;
import android.support.v7.io;
import android.support.v7.is;
import android.support.v7.iv;
import android.support.v7.kf;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.e;
import com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity;
import com.abtnprojects.ambatana.ui.activities.profile.EditLocationActivity;
import com.abtnprojects.ambatana.ui.signup.MainSignUpActivity;
import com.crashlytics.android.Crashlytics;
import com.facebook.d;
import com.facebook.f;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import java.util.Locale;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            c

public abstract class b extends c
{

    private boolean A;
    private BroadcastReceiver B;
    private IntentFilter n;
    protected ParseInstallation o;
    protected String p;

    public b()
    {
        B = new BroadcastReceiver() {

            final b a;

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
                    } else
                    if (context.equals(com.abtnprojects.ambatana.a.a.a.toString()) && intent != null && intent.hasExtra(com.abtnprojects.ambatana.a.b.a.toString()))
                    {
                        int i = intent.getIntExtra(com.abtnprojects.ambatana.a.b.a.toString(), 0);
                        if (a.u != null)
                        {
                            context = a.u;
                            if (i <= 0)
                            {
                                flag = false;
                            }
                            context.setVisible(flag);
                            return;
                        }
                    }
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
    }

    private void C()
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/signup/MainSignUpActivity);
        intent.setFlags(32768);
        startActivity(intent);
        finish();
    }

    protected static void a(String s, String s1, f f, Activity activity, d d, String s2, String s3, String s4)
    {
        s2 = iv.a(s2);
        s4 = String.format(activity.getResources().getString(0x7f09006c), new Object[] {
            s4, s1
        });
        activity = new kf(activity);
        activity.a(d, f);
        if (s == null)
        {
            s = null;
        } else
        {
            s = Uri.parse(s);
        }
        s1 = (com.facebook.share.model.ShareLinkContent.a)(new com.facebook.share.model.ShareLinkContent.a()).b(s4).a((new StringBuilder()).append(s1).append(": ").append(s3).toString()).a(Uri.parse(s2));
        if (s != null)
        {
            s1.b(s);
        }
        activity.a(s1.a());
    }

    private void l()
    {
        try
        {
            aqo.a("DrawableBase, registering event bus", new Object[0]);
            dz.a().b(z);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
    }

    protected abstract void a(Bundle bundle, boolean flag);

    protected void n()
    {
        ((LinearLayout)findViewById(0x7f1000fe)).setOnClickListener(new android.view.View.OnClickListener() {

            final b a;

            public void onClick(View view)
            {
                view = new Intent(a, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity);
                a.startActivity(view);
            }

            
            {
                a = b.this;
                super();
            }
        });
        ((LinearLayout)findViewById(0x7f100159)).setOnClickListener(new android.view.View.OnClickListener() {

            final b a;

            public void onClick(View view)
            {
                a.t();
            }

            
            {
                a = b.this;
                super();
            }
        });
    }

    protected void o()
    {
        startActivityForResult(new Intent(this, com/abtnprojects/ambatana/ui/activities/profile/EditLocationActivity), 4);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag1 = iv.b(this);
        boolean flag;
        if (!flag1 || w == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag1)
        {
            q();
        }
        if (w != null) goto _L2; else goto _L1
_L1:
        C();
_L4:
        if (!flag)
        {
            p = getResources().getConfiguration().locale.getLanguage();
            o = ParseInstallation.getCurrentInstallation();
            n = new IntentFilter();
            n.addAction(com.abtnprojects.ambatana.a.a.a.toString());
            io.a(w, o);
            if (!e.a.booleanValue())
            {
                Toast.makeText(this, getString(0x7f090075), 1).show();
            }
            v = is.a(this);
        }
        a(bundle, flag);
        l();
        A = true;
        return;
_L2:
        if (w.getObjectId() != null)
        {
            Crashlytics.setUserIdentifier(w.getObjectId());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null)
        {
            intent = intent.getData();
            if (intent != null && intent.getHost().equalsIgnoreCase("home") && intent.getPath().equalsIgnoreCase(""))
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
            unregisterReceiver(B);
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
        if (A)
        {
            A = false;
        } else
        {
            l();
        }
        registerReceiver(B, n);
        r();
    }

    protected void onStop()
    {
        super.onStop();
        iv.a(s);
    }

    public void setTitle(CharSequence charsequence)
    {
        t = charsequence;
        g().a(t);
    }
}
