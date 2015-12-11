// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.os.Bundle;
import android.support.v4.app.t;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.activities:
//            ci, ch, ce, cf, 
//            cg

public class FirstQuestionHelpActivity extends t
{

    int a;
    ViewPager b;
    ImageView c;
    ImageView d;
    ImageView e;
    TextView f;
    private ci g;

    public FirstQuestionHelpActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040022);
        bundle = getWindow();
        bundle.setLayout(-1, -1);
        bundle.setBackgroundDrawableResource(0x7f0200d2);
        b = (ViewPager)findViewById(0x7f1000cf);
        c = (ImageView)findViewById(0x7f1000d2);
        d = (ImageView)findViewById(0x7f1000d4);
        e = (ImageView)findViewById(0x7f1000d0);
        f = (TextView)findViewById(0x7f1000d3);
        g = new ci(this, getSupportFragmentManager());
        b.setAdapter(g);
        b.setOnPageChangeListener(new ch(this, (byte)0));
        d.setOnClickListener(new ce(this));
        c.setVisibility(8);
        c.setOnClickListener(new cf(this));
        f.setOnClickListener(new cg(this));
    }
}
