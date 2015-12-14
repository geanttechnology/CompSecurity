// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.view.View;
import android.widget.TextView;
import com.socialin.android.photo.draw.DrawingActivity;

public class e
{

    public DrawingActivity a;

    public e(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }

    public void a()
    {
        if (DrawingActivity.p(a) == null)
        {
            DrawingActivity.a(a, a.findViewById(0x7f1003a0));
        }
        if (DrawingActivity.p(a) != null)
        {
            DrawingActivity.p(a).setVisibility(0);
        }
    }

    public void a(int i)
    {
        if (DrawingActivity.q(a) == null)
        {
            DrawingActivity.a(a, (TextView)a.findViewById(0x7f1001fe));
        }
        if (DrawingActivity.q(a) != null)
        {
            DrawingActivity.q(a).setText((new StringBuilder()).append(i).append("%").toString());
        }
    }

    public void b()
    {
        if (DrawingActivity.p(a) == null)
        {
            DrawingActivity.a(a, a.findViewById(0x7f1003a0));
        }
        if (DrawingActivity.p(a) != null)
        {
            DrawingActivity.p(a).setVisibility(8);
        }
    }
}
