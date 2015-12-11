// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.os.Handler;
import android.os.SystemClock;

// Referenced classes of package com.ant.liao:
//            GifAnimation, GifReDraw

private class <init>
    implements Runnable
{

    final GifAnimation this$0;

    public void run()
    {
        int i = GifAnimation.access$0(GifAnimation.this).reDraw();
        if (!GifAnimation.access$1(GifAnimation.this))
        {
            if (i > 0)
            {
                SystemClock.sleep(i);
            }
            synchronized (GifAnimation.access$2(GifAnimation.this))
            {
                if (!GifAnimation.access$1(GifAnimation.this))
                {
                    GifAnimation.access$3(GifAnimation.this).post(GifAnimation.access$2(GifAnimation.this));
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        <init>1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ()
    {
        this$0 = GifAnimation.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
