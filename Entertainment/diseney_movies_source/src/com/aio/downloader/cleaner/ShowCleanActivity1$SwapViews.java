// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.aio.downloader.views.Rotate3dAnimation;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

private final class <init>
    implements Runnable
{

    final ShowCleanActivity1 this$0;

    public void run()
    {
        ShowCleanActivity1.access$3(ShowCleanActivity1.this).setVisibility(4);
        ShowCleanActivity1.access$4(ShowCleanActivity1.this).setVisibility(4);
        Object obj = ShowCleanActivity1.this;
        ShowCleanActivity1.access$6(((ShowCleanActivity1) (obj)), ShowCleanActivity1.access$5(((ShowCleanActivity1) (obj))) + 1);
        if (ShowCleanActivity1.access$5(ShowCleanActivity1.this) % 2 == 0)
        {
            ShowCleanActivity1.access$7(ShowCleanActivity1.this, ShowCleanActivity1.access$3(ShowCleanActivity1.this));
        } else
        {
            ShowCleanActivity1.access$7(ShowCleanActivity1.this, ShowCleanActivity1.access$4(ShowCleanActivity1.this));
        }
        ShowCleanActivity1.access$8(ShowCleanActivity1.this).setVisibility(0);
        ShowCleanActivity1.access$8(ShowCleanActivity1.this).requestFocus();
        obj = new Rotate3dAnimation(-90F, 0.0F, ShowCleanActivity1.access$9(ShowCleanActivity1.this), ShowCleanActivity1.access$10(ShowCleanActivity1.this), ShowCleanActivity1.access$11(ShowCleanActivity1.this), false);
        ((Rotate3dAnimation) (obj)).setDuration(ShowCleanActivity1.access$12(ShowCleanActivity1.this));
        ((Rotate3dAnimation) (obj)).setFillAfter(true);
        ((Rotate3dAnimation) (obj)).setInterpolator(new DecelerateInterpolator());
        ShowCleanActivity1.access$8(ShowCleanActivity1.this).startAnimation(((android.view.animation.Animation) (obj)));
    }

    private ()
    {
        this$0 = ShowCleanActivity1.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
