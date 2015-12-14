// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.view.animation.Animation;

// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

class val.callback
    implements android.view.animation.Listener
{

    final SelectedPlayList this$0;
    private final Runnable val$callback;

    public void onAnimationEnd(Animation animation)
    {
        if (val$callback != null)
        {
            val$callback.run();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    stener()
    {
        this$0 = final_selectedplaylist;
        val$callback = Runnable.this;
        super();
    }
}
