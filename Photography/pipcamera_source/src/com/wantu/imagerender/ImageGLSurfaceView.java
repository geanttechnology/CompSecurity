// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagerender;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import vb;
import vc;
import vd;
import ve;
import vf;
import vg;

public class ImageGLSurfaceView extends GLSurfaceView
{

    private float m_density;
    private vb m_render;

    public ImageGLSurfaceView(Context context)
    {
        super(context);
        m_density = 1.0F;
        setDebugFlags(3);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        getHolder().setFormat(1);
        setRenderer(new vb(context));
    }

    public ImageGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        m_density = 1.0F;
        setDebugFlags(3);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        getHolder().setFormat(1);
        setRenderer(new vb(context));
    }

    public void clear()
    {
        queueEvent(new Runnable() {

            final ImageGLSurfaceView a;

            public void run()
            {
                a.m_render.a();
            }

            
            {
                a = ImageGLSurfaceView.this;
                super();
            }
        });
    }

    public void fastLightingProcessImage(Bitmap bitmap, String s, Handler handler)
    {
        queueEvent(new vf(this, bitmap, s, 1.0F, true, handler, false));
    }

    public void fastProcessImage(Bitmap bitmap, String s, float f, Handler handler)
    {
        queueEvent(new vf(this, bitmap, s, f, false, handler, false));
    }

    public void fastProcessImage(Bitmap bitmap, String s, Handler handler)
    {
        queueEvent(new vf(this, bitmap, s, 1.0F, false, handler, false));
    }

    public float getDensity()
    {
        return m_density;
    }

    public vb getRender()
    {
        return m_render;
    }

    public void processImage(Bitmap bitmap, String s, float f, Handler handler)
    {
        queueEvent(new vf(this, bitmap, s, f, false, handler, true));
    }

    public void processImage(Bitmap bitmap, String s, Handler handler)
    {
        queueEvent(new vf(this, bitmap, s, 1.0F, false, handler, true));
    }

    public void processLightingImage(Bitmap bitmap, String s, Handler handler)
    {
        queueEvent(new vf(this, bitmap, s, 1.0F, true, handler, true));
    }

    public void setDensity(float f)
    {
        m_density = f;
    }

    public void setFilterName(String s)
    {
        queueEvent(new vc(this, s));
    }

    public void setLightFilterName(String s)
    {
        queueEvent(new vd(this, s));
    }

    public void setOpacity(float f)
    {
        queueEvent(new ve(this, f));
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer)
    {
        super.setRenderer(renderer);
        setRenderMode(0);
        m_render = (vb)renderer;
    }

    public void setSourceBitmap(Bitmap bitmap)
    {
        queueEvent(new vg(this, bitmap));
    }

}
