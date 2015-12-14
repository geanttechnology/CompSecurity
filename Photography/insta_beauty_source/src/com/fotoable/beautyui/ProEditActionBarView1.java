// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ka;
import kb;
import kc;

public class ProEditActionBarView1 extends FrameLayout
{

    ImageView img_acceptcrop;
    ImageView img_rotatephotocrop;
    View layout_precrop;
    public kc listener;

    public ProEditActionBarView1(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030117, this, true);
        img_acceptcrop = (ImageView)findViewById(0x7f0d040b);
        img_acceptcrop.setOnClickListener(new ka(this));
        layout_precrop = findViewById(0x7f0d040a);
        layout_precrop.setOnClickListener(new kb(this));
    }

    public String getActionBarTitle()
    {
        return null;
    }

    public void setOnAcceptListener(kc kc)
    {
        listener = kc;
    }
}
