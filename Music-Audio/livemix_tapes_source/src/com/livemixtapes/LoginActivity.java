// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.google.android.gms.analytics.Tracker;

// Referenced classes of package com.livemixtapes:
//            console, App, MainActivity

public class LoginActivity extends Activity
{

    public LoginActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030024);
        ((ImageView)findViewById(0x7f080095)).setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(LoginActivity.this, com/livemixtapes/MainActivity);
                startActivity(view);
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100000, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f08013c)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onResume()
    {
        super.onResume();
        console.log(new Object[] {
            "LOGGING LOGIN ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~LoginActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }
}
