// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.d.a;
import com.smule.pianoandroid.d.b;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            y

public class MagicGLSurfaceView extends GLSurfaceView
    implements b
{

    private static final String a = com/smule/pianoandroid/magicpiano/MagicGLSurfaceView.getCanonicalName();
    private y b;
    private boolean c;
    private boolean d;
    private Observer e;

    public MagicGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = true;
        d = false;
        e = new Observer() {

            final MagicGLSurfaceView a;

            public void update(Observable observable, Object obj)
            {
                if (com.smule.pianoandroid.magicpiano.MagicGLSurfaceView.a(a))
                {
                    com.smule.pianoandroid.magicpiano.MagicGLSurfaceView.a(a, false);
                }
            }

            
            {
                a = MagicGLSurfaceView.this;
                super();
            }
        };
    }

    static boolean a(MagicGLSurfaceView magicglsurfaceview)
    {
        return magicglsurfaceview.d;
    }

    static boolean a(MagicGLSurfaceView magicglsurfaceview, boolean flag)
    {
        magicglsurfaceview.c = flag;
        return flag;
    }

    public void a(float f, float f1, int i, int j)
    {
        boolean flag = false;
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = ((flag) ? 1 : 0);
        j;
        JVM INSTR tableswitch 0 6: default 60
    //                   0 64
    //                   1 94
    //                   2 100
    //                   3 106
    //                   4 64
    //                   5 64
    //                   6 94;
           goto _L3 _L4 _L5 _L6 _L7 _L4 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        k = ((flag) ? 1 : 0);
_L11:
        if (getHolder().getSurface().isValid())
        {
            PianoCoreBridge.handleTouch(f, (float)getHeight() - f1, i, k);
            return;
        }
          goto _L8
_L5:
        k = 2;
          goto _L9
_L6:
        k = 1;
          goto _L9
_L7:
        k = 3;
_L9:
        if (true) goto _L11; else goto _L10
_L10:
_L8:
        if (true) goto _L1; else goto _L12
_L12:
    }

    public void a(Context context)
    {
        b = new y(context);
        setRenderer(b);
    }

    public int getRendererHeight()
    {
        return b.b;
    }

    public int getRendererWidth()
    {
        return b.a;
    }

    public void onPause()
    {
        super.onPause();
        h.a().b("RENDERER_INITIALIZED", e);
        d = false;
        c = true;
    }

    public void onResume()
    {
        super.onResume();
        h.a().a("RENDERER_INITIALIZED", e);
        if (b.a())
        {
            c = false;
        }
        d = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (c)
        {
            aa.c(a, "Skip touch!");
            return true;
        } else
        {
            return com.smule.pianoandroid.d.a.a(motionevent, this);
        }
    }

}
