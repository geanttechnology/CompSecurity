// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.picsart.effectnew.RectangleF;
import com.socialin.android.photo.clone.CloneView;
import com.socialin.android.photo.clone.a;
import com.socialin.android.photo.clone.b;
import com.socialin.camera.opengl.k;
import com.socialin.camera.opengl.l;
import com.socialin.camera.opengl.m;
import com.socialin.picsin.camera.view.CustomVerticalSeekBar;
import com.socialin.picsin.camera.view.VerticalLabelView;

public final class g
{

    public final Bitmap a;
    public final Bitmap b;
    public final Paint c;
    public final Paint d;
    public final b e;
    public final float f;
    public final float g;
    public boolean h;
    public boolean i;
    public boolean j;
    public RectangleF k;
    public a l;
    public CloneView m;
    public float n;
    public float o;
    public float p;

    public final LinearLayout a(Activity activity, boolean flag)
    {
        activity = (LinearLayout)activity.getLayoutInflater().inflate(0x7f030051, null);
        if (flag)
        {
            n = 100F;
            o = 70F;
            p = 3F;
        }
        VerticalLabelView verticallabelview = (VerticalLabelView)activity.findViewById(0x7f10023a);
        verticallabelview.setText((new StringBuilder("Radius : ")).append(n).toString());
        CustomVerticalSeekBar customverticalseekbar = (CustomVerticalSeekBar)activity.findViewById(0x7f10023b);
        customverticalseekbar.setMax(100);
        customverticalseekbar.setProgressAndThumb((int)n);
        customverticalseekbar.setOnSeekBarChangeListener(new k(this, verticallabelview));
        verticallabelview = (VerticalLabelView)activity.findViewById(0x7f100236);
        verticallabelview.setText((new StringBuilder("Blur : ")).append(p).toString());
        customverticalseekbar = (CustomVerticalSeekBar)activity.findViewById(0x7f100237);
        customverticalseekbar.setMax(7);
        customverticalseekbar.setProgressAndThumb((int)p);
        customverticalseekbar.setOnSeekBarChangeListener(new l(this, verticallabelview));
        verticallabelview = (VerticalLabelView)activity.findViewById(0x7f100238);
        verticallabelview.setText((new StringBuilder("Hadrness : ")).append(o).toString());
        customverticalseekbar = (CustomVerticalSeekBar)activity.findViewById(0x7f100239);
        customverticalseekbar.setMax(100);
        customverticalseekbar.setProgressAndThumb((int)o);
        customverticalseekbar.setOnSeekBarChangeListener(new m(this, verticallabelview));
        return activity;
    }

    public final void a()
    {
        new Path(null);
        throw new NullPointerException();
    }
}
