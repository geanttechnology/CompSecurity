// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.animation.Animation;

// Referenced classes of package com.livemixtapes:
//            SearchFragment

class val.callback
    implements android.view.animation.onListener
{

    final SearchFragment this$0;
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

    nimationListener()
    {
        this$0 = final_searchfragment;
        val$callback = Runnable.this;
        super();
    }
}
