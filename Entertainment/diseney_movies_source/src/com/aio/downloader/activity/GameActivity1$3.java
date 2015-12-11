// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.aio.downloader.activity:
//            GameActivity1

class this._cls0
    implements android.view.animation.ionListener
{

    final GameActivity1 this$0;

    public void onAnimationEnd(Animation animation)
    {
        GameActivity1.access$5(GameActivity1.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    stener()
    {
        this$0 = GameActivity1.this;
        super();
    }
}
