// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

private final class <init>
    implements android.view.animation.iew
{

    final ShowCleanActivity1 this$0;

    public void onAnimationEnd(Animation animation)
    {
        ShowCleanActivity1.access$2(ShowCleanActivity1.this).post(new (ShowCleanActivity1.this, null));
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
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
