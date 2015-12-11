// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

// Referenced classes of package com.ant.liao:
//            GifReDraw

public class GifAnimation
{
    private class AnimationRunAble
        implements Runnable
    {

        final GifAnimation this$0;

        public void run()
        {
            int i = draw.reDraw();
            if (!pause)
            {
                if (i > 0)
                {
                    SystemClock.sleep(i);
                }
                synchronized (animation)
                {
                    if (!pause)
                    {
                        handler.post(animation);
                    }
                }
                return;
            } else
            {
                return;
            }
            exception;
            animationrunable;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private AnimationRunAble()
        {
            this$0 = GifAnimation.this;
            super();
        }

        AnimationRunAble(AnimationRunAble animationrunable)
        {
            this();
        }
    }


    private AnimationRunAble animation;
    private GifReDraw draw;
    private Handler handler;
    private boolean pause;

    public GifAnimation()
    {
        draw = null;
        pause = false;
        handler = new Handler(Looper.getMainLooper());
        animation = new AnimationRunAble(null);
    }

    public void destroy()
    {
        stopAnimation();
        draw = null;
    }

    public void pauseAnimation()
    {
        synchronized (animation)
        {
            handler.removeCallbacks(animation);
            pause = true;
        }
        return;
        exception;
        animationrunable;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void restartAnimation()
    {
        synchronized (animation)
        {
            pause = false;
            handler.post(animation);
        }
        return;
        exception;
        animationrunable;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void runAnimation()
    {
        pause = false;
        handler.post(animation);
    }

    public void setRedraw(GifReDraw gifredraw)
    {
        draw = gifredraw;
    }

    public void stopAnimation()
    {
        pauseAnimation();
    }




}
