// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.ActionBar;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.livemixtapes:
//            Login, MainActivity, User, App, 
//            console

public class SplashActivity extends Activity
{

    private Boolean loading;

    public SplashActivity()
    {
        loading = Boolean.valueOf(false);
    }

    private void openLogin()
    {
        startActivity(new Intent(this, com/livemixtapes/Login));
    }

    private void openMain()
    {
        startActivity(new Intent(this, com/livemixtapes/MainActivity));
    }

    private void refreshAuth()
    {
        if (loading.booleanValue())
        {
            return;
        } else
        {
            loading = Boolean.valueOf(true);
            User.refresh(new User.UserCallback() {

                final SplashActivity this$0;

                public void always()
                {
                    loading = Boolean.valueOf(false);
                }

                public void failure(int i, Exception exception)
                {
                    openLogin();
                }

                public void success(User.UserData userdata)
                {
                    openMain();
                }

            
            {
                this$0 = SplashActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((NotificationManager)App.context.getSystemService("notification")).cancelAll();
        getActionBar().hide();
        if (User.isLogged().booleanValue())
        {
            openMain();
            return;
        }
        if (!User.hasAuth().booleanValue())
        {
            openLogin();
            return;
        } else
        {
            setContentView(0x7f03003d);
            refreshAuth();
            return;
        }
    }

    public void onDestroy()
    {
        console.log(new Object[] {
            "SPLASH DESTROYED"
        });
        super.onDestroy();
        ((NotificationManager)App.context.getSystemService("notification")).cancel(1);
    }



}
