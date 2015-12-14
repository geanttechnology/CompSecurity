// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;
import com.pf.common.utility.m;

public class NoticeActivityLocked extends Activity
{

    private Handler a;
    private Runnable b;

    public NoticeActivityLocked()
    {
        a = new Handler();
        b = new Runnable() {

            final NoticeActivityLocked a;

            public void run()
            {
                a.getWindow().clearFlags(128);
                m.a("NoticeActivityLocked", (new StringBuilder()).append("removeFlag(), id").append(hashCode()).toString());
            }

            
            {
                a = NoticeActivityLocked.this;
                super();
            }
        };
    }

    private void a()
    {
        String s = (String)getIntent().getExtras().get("Msg");
        m.a("NoticeActivityLocked", (new StringBuilder()).append("processIntent() msg=").append(s).append(", id").append(hashCode()).toString());
        setContentView(0x7f030017);
        ((TextView)findViewById(0x7f0c017a)).setText(s);
    }

    private void b()
    {
        m.a("NoticeActivityLocked", (new StringBuilder()).append("turnScreenOn(), id=").append(hashCode()).toString());
        getWindow().addFlags(0x200000);
        getWindow().addFlags(0x80000);
        getWindow().addFlags(128);
        a.postDelayed(b, 1000L);
    }

    protected void onCreate(Bundle bundle)
    {
        m.a("NoticeActivityLocked", (new StringBuilder()).append("onCreate() in, id=").append(hashCode()).toString());
        super.onCreate(bundle);
        a();
        b();
    }
}
