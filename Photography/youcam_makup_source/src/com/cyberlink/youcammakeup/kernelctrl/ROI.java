// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.jniproxy.as;
import java.io.Serializable;

public class ROI
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private float angle;
    private int height;
    private int left;
    private int top;
    private int width;

    public ROI(int i, int j, int k, int l)
    {
        angle = 0.0F;
        left = i;
        top = j;
        width = k;
        height = l;
    }

    public ROI(int i, int j, int k, int l, float f)
    {
        angle = 0.0F;
        left = i;
        top = j;
        width = k;
        height = l;
        angle = f;
    }

    public ROI(ROI roi)
    {
        angle = 0.0F;
        left = roi.left;
        top = roi.top;
        width = roi.width;
        height = roi.height;
        angle = roi.angle;
    }

    public int a()
    {
        return left;
    }

    public void a(int i)
    {
        left = i;
    }

    public int b()
    {
        return top;
    }

    public void b(int i)
    {
        top = i;
    }

    public int c()
    {
        return width;
    }

    public void c(int i)
    {
        width = i;
    }

    public int d()
    {
        return height;
    }

    public void d(int i)
    {
        height = i;
    }

    public as e()
    {
        return new as(left, top, width, height);
    }

    public String toString()
    {
        return (new StringBuilder("ROI: (left,top,width,height,angle)=(")).append(left).append(",").append(top).append(",").append(width).append(",").append(height).append(",").append(angle).append(")").toString();
    }
}
