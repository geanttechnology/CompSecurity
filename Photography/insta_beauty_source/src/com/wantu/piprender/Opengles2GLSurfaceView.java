// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import ble;
import blf;
import blg;
import blk;
import com.wantu.model.res.pip.TDFSceneInfo;

public class Opengles2GLSurfaceView extends GLSurfaceView
{

    private float m_density;
    private GestureDetector m_gesture;
    private blk m_render;

    public Opengles2GLSurfaceView(Context context)
    {
        super(context);
        m_density = 1.0F;
        setDebugFlags(3);
        m_gesture = new GestureDetector(context, new ble(this));
    }

    public Opengles2GLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        m_density = 1.0F;
        setDebugFlags(3);
        m_gesture = new GestureDetector(context, new ble(this));
    }

    public void clear()
    {
        queueEvent(new blf(this));
    }

    public float getDensity()
    {
        return m_density;
    }

    public void onMove(float f, float f1)
    {
        f = f / m_density / 50F;
        f1 = f1 / m_density / 50F;
        m_render.a(f, f1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return m_gesture.onTouchEvent(motionevent);
    }

    public void setDensity(float f)
    {
        m_density = f;
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer, float f)
    {
        super.setRenderer(renderer);
        setDensity(f);
        m_render = (blk)renderer;
        m_render.b(f);
    }

    public void setSceneConfig(TDFSceneInfo tdfsceneinfo)
    {
        queueEvent(new blg(this, tdfsceneinfo));
    }

}
