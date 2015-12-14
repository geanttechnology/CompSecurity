// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.youcammakeup.activity.NoticeActivity;
import com.pf.common.utility.m;

public class NoticeActivityUnlocked extends Activity
{

    private Handler a;
    private Runnable b;

    public NoticeActivityUnlocked()
    {
        a = new Handler();
        b = new Runnable() {

            final NoticeActivityUnlocked a;

            public void run()
            {
                m.a("NoticeActivityUnlocked", (new StringBuilder()).append("NoticeActivityTranslucent::autoFinish, id").append(hashCode()).toString());
                a.finish();
            }

            
            {
                a = NoticeActivityUnlocked.this;
                super();
            }
        };
    }

    private void a()
    {
        String s = (String)getIntent().getExtras().get("Msg");
        m.a("NoticeActivityUnlocked", (new StringBuilder()).append("processIntent() msg=").append(s).append(", id").append(hashCode()).toString());
        setContentView(0x7f030018);
        TextView textview = (TextView)findViewById(0x7f0c017a);
        textview.setText(s);
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final NoticeActivityUnlocked a;

            public void onClick(View view)
            {
                view = new Intent(a.getBaseContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
                a.startActivity(view);
            }

            
            {
                a = NoticeActivityUnlocked.this;
                super();
            }
        });
        a.postDelayed(b, 5000L);
    }

    protected void onCreate(Bundle bundle)
    {
        m.a("NoticeActivityUnlocked", (new StringBuilder()).append("onCreate() in, id=").append(hashCode()).toString());
        super.onCreate(bundle);
        a();
    }

    public void onPause()
    {
        m.a("NoticeActivityUnlocked", (new StringBuilder()).append("onPause() in, id=").append(hashCode()).toString());
        super.onPause();
        finish();
    }
}
