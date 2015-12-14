// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.social.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.d;
import com.bumptech.glide.k;
import com.socialin.android.activity.BaseActivity;
import myobfuscated.cx.a;
import myobfuscated.f.m;

public class SocialConnectionsActivity extends BaseActivity
{

    private a a;

    public SocialConnectionsActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (a != null)
        {
            a.onActivityResult(i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301f2);
        bundle = getFragmentManager().beginTransaction();
        bundle.setTransition(8194);
        a = new a();
        if (getIntent().hasExtra("isFromSettings"))
        {
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("isFromSettings", true);
            bundle1.putBoolean("isGridView", true);
            a.setArguments(bundle1);
        }
        bundle.add(0x7f1008ed, a);
        bundle.commit();
        bundle = m.a(this);
        if (bundle != null)
        {
            bundle.setText(0x7f08053b);
        }
        findViewById(0x7f1008ee).setOnClickListener(new android.view.View.OnClickListener() {

            private SocialConnectionsActivity a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = SocialConnectionsActivity.this;
                super();
            }
        });
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        b.a(this).a.onLowMemory();
    }
}
