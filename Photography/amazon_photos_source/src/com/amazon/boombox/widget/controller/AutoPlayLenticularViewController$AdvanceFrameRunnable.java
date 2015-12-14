// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget.controller;

import android.os.Handler;
import com.amazon.boombox.widget.LenticularView;

// Referenced classes of package com.amazon.boombox.widget.controller:
//            AutoPlayLenticularViewController

private class <init>
    implements Runnable
{

    final AutoPlayLenticularViewController this$0;

    private void advanceFrame()
    {
        if (AutoPlayLenticularViewController.access$300(AutoPlayLenticularViewController.this) != null)
        {
            AutoPlayLenticularViewController.access$412(AutoPlayLenticularViewController.this, 600);
            long l = AutoPlayLenticularViewController.access$400(AutoPlayLenticularViewController.this) / 600;
            if (AutoPlayLenticularViewController.access$300(AutoPlayLenticularViewController.this).getCount() != 0)
            {
                int i = (int)(l % (long)AutoPlayLenticularViewController.access$300(AutoPlayLenticularViewController.this).getCount());
                AutoPlayLenticularViewController.access$300(AutoPlayLenticularViewController.this).setPosition(i);
                return;
            }
        }
    }

    public void run()
    {
        advanceFrame();
        AutoPlayLenticularViewController.access$200(AutoPlayLenticularViewController.this).postDelayed(AutoPlayLenticularViewController.access$100(AutoPlayLenticularViewController.this), 600L);
    }

    private ()
    {
        this$0 = AutoPlayLenticularViewController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
