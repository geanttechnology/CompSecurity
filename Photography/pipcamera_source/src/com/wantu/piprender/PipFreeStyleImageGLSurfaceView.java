// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.AttributeSet;
import vk;
import vl;
import vm;
import vn;
import vo;
import vp;
import vq;
import vr;

public class PipFreeStyleImageGLSurfaceView extends GLSurfaceView
{

    private float m_density;
    private vk m_render;

    public PipFreeStyleImageGLSurfaceView(Context context)
    {
        super(context);
        m_density = 1.0F;
        setDebugFlags(3);
    }

    public PipFreeStyleImageGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        m_density = 1.0F;
        setDebugFlags(3);
    }

    public void fastProcessImage(Bitmap bitmap, String s, Handler handler)
    {
        queueEvent(new vm(this, bitmap, s, handler, false));
    }

    public float getDensity()
    {
        return m_density;
    }

    public android.opengl.GLSurfaceView.Renderer getRender()
    {
        return m_render;
    }

    public void processImage(Bitmap bitmap, String s, Handler handler)
    {
        queueEvent(new vm(this, bitmap, s, handler, true));
    }

    public void refresh()
    {
        queueEvent(new vn(this));
    }

    public void setBlurRadius(float f)
    {
        queueEvent(new vo(this, f));
    }

    public void setDensity(float f)
    {
        m_density = f;
    }

    public void setFilterName(String s)
    {
        queueEvent(new vl(this, s));
    }

    public void setMaskImage(Bitmap bitmap)
    {
        queueEvent(new vp(this, bitmap));
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer, float f)
    {
        super.setRenderer(renderer);
        setRenderMode(0);
        setDensity(f);
        m_render = (vk)renderer;
        m_render.b(f);
    }

    public void setSourceBitmap(Bitmap bitmap)
    {
        queueEvent(new vq(this, bitmap));
    }

    public void takeScreenShot(Handler handler)
    {
        queueEvent(new vr(this, handler));
    }

}
