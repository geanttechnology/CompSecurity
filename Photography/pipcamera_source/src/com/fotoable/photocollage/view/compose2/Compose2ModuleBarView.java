// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import ew;

public class Compose2ModuleBarView extends FrameLayout
{

    View ly_module_sub_container;

    public Compose2ModuleBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ad, this, true);
        ly_module_sub_container = findViewById(0x7f0c02a7);
        int i = (int)(((float)ew.a(getContext()) * 3F) / 4F);
        ly_module_sub_container.getLayoutParams().width = ew.a(getContext(), i);
        ly_module_sub_container.requestLayout();
    }
}
