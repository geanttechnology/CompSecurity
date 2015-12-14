// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.ToggleButton;
import ew;
import mf;

public class Compose2ModuleCornorView extends FrameLayout
{

    View layout_compose_module_cornor;
    mf listener;
    SeekBar module_seek_cornor;
    SeekBar module_seek_edge;
    ToggleButton tgBiankuang;
    ToggleButton tgShade;

    public Compose2ModuleCornorView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300af, this, true);
        initView();
    }

    public Compose2ModuleCornorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300af, this, true);
        initView();
    }

    private void initView()
    {
        module_seek_cornor = (SeekBar)findViewById(0x7f0c02b8);
        module_seek_cornor.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final Compose2ModuleCornorView a;

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                i = (int)((float)i / 3F);
                i = ew.a(a.getContext(), i);
                a.setRadius(i);
                if (a.listener != null)
                {
                    a.listener.b(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = Compose2ModuleCornorView.this;
                super();
            }
        });
        module_seek_edge = (SeekBar)findViewById(0x7f0c02b7);
        module_seek_edge.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final Compose2ModuleCornorView a;

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                i = (int)((float)i / 3F);
                i = ew.a(a.getContext(), i);
                a.setEdge(i);
                if (a.listener != null)
                {
                    a.listener.c(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = Compose2ModuleCornorView.this;
                super();
            }
        });
        tgShade = (ToggleButton)findViewById(0x7f0c02b4);
        tgShade.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Compose2ModuleCornorView a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (a.listener != null)
                {
                    a.listener.c(flag);
                }
            }

            
            {
                a = Compose2ModuleCornorView.this;
                super();
            }
        });
        tgBiankuang = (ToggleButton)findViewById(0x7f0c02b6);
        tgBiankuang.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Compose2ModuleCornorView a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (a.listener != null)
                {
                    a.listener.d(flag);
                }
            }

            
            {
                a = Compose2ModuleCornorView.this;
                super();
            }
        });
    }

    public int getDisplayHeight()
    {
        return ew.a(getContext(), 80F);
    }

    public void setEdge(float f)
    {
        int i = ew.d(getContext(), f);
        module_seek_edge.setProgress(i * 3);
    }

    public void setIsBK(boolean flag)
    {
        tgBiankuang.setChecked(flag);
    }

    public void setIsShadow(boolean flag)
    {
        tgShade.setChecked(flag);
    }

    public void setOnCornorChangeListener(mf mf)
    {
        listener = mf;
    }

    public void setRadius(float f)
    {
        int i = ew.d(getContext(), f);
        module_seek_cornor.setProgress(i * 3);
    }
}
