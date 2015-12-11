// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.os.Bundle;
import android.support.v4.app.t;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.activities:
//            ge, gd, ga, gb, 
//            gc

public class PrePostingHelpActivity extends t
{

    int a;
    ViewPager b;
    ImageView c;
    ImageView d;
    ImageView e;
    TextView f;
    private ge g;

    public PrePostingHelpActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040036);
        b = (ViewPager)findViewById(0x7f1000cf);
        c = (ImageView)findViewById(0x7f1000d2);
        d = (ImageView)findViewById(0x7f1000d4);
        e = (ImageView)findViewById(0x7f1000d0);
        f = (TextView)findViewById(0x7f1000d3);
        g = new ge(this, getSupportFragmentManager());
        b.setAdapter(g);
        b.setOnPageChangeListener(new gd(this, (byte)0));
        d.setOnClickListener(new ga(this));
        c.setVisibility(8);
        c.setOnClickListener(new gb(this));
        f.setOnClickListener(new gc(this));
    }
}
