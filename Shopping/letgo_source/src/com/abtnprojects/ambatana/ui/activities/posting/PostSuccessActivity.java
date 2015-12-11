// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.e;
import android.support.v7.gh;
import android.support.v7.hc;
import android.support.v7.ic;
import android.support.v7.if;
import android.support.v7.iu;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.parse.ParseUser;

public class PostSuccessActivity extends e
    implements android.support.v7.if.a
{

    private if n;
    TextView tvPostSuccessSubtitle;

    public PostSuccessActivity()
    {
    }

    void closeScreen()
    {
        n.a();
    }

    void goToPosting()
    {
        n.b();
    }

    public void k()
    {
        tvPostSuccessSubtitle.setText(getString(0x7f09011e, new Object[] {
            Integer.valueOf(10)
        }));
    }

    public void onBackPressed()
    {
        closeScreen();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040021);
        ButterKnife.bind(this);
        bundle = getIntent().getStringExtra("product_id");
        android.support.v7.hb hb = (new hc()).a(new gh(), ParseUser.getCurrentUser(), bundle, new iu());
        n = new if(this, this, new ic(this), ParseUser.getCurrentUser(), hb);
        n.a(bundle);
    }

    protected void onPause()
    {
        super.onPause();
        n.a(this);
    }

    protected void onResume()
    {
        super.onResume();
        n.b(this);
    }
}
