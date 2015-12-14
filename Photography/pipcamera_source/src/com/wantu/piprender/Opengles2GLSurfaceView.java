// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.wantu.model.res.pip.TDFSceneInfo;
import vj;
import vv;

public class Opengles2GLSurfaceView extends GLSurfaceView
{

    private float m_density;
    private vv m_render;

    public Opengles2GLSurfaceView(Context context)
    {
        super(context);
        m_density = 1.0F;
        setDebugFlags(3);
    }

    public Opengles2GLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        m_density = 1.0F;
        setDebugFlags(3);
    }

    public void clear()
    {
        queueEvent(new Runnable() {

            final Opengles2GLSurfaceView a;

            public void run()
            {
                a.m_render.a();
            }

            
            {
                a = Opengles2GLSurfaceView.this;
                super();
            }
        });
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

    public void setDensity(float f)
    {
        m_density = f;
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer, float f)
    {
        super.setRenderer(renderer);
        setRenderMode(0);
        setDensity(f);
        m_render = (vv)renderer;
        m_render.b(f);
    }

    public void setSceneConfig(TDFSceneInfo tdfsceneinfo)
    {
        queueEvent(new vj(this, tdfsceneinfo));
    }

}
