// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.xfinity.playerlib.view.PagerContainer;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class this._cls0
    implements android.support.v4.view.Listener
{

    final LiveStreamsFragment this$0;

    public void onPageScrollStateChanged(int i)
    {
        LiveStreamsFragment.access$200(LiveStreamsFragment.this).onPageScrollStateChanged(i);
    }

    public void onPageScrolled(int i, float f, int j)
    {
        LiveStreamsFragment.access$200(LiveStreamsFragment.this).onPageScrolled(i, f, j);
    }

    public void onPageSelected(int i)
    {
        LiveStreamsFragment.access$200(LiveStreamsFragment.this).onPageSelected(i);
        LiveStreamsFragment.access$802(LiveStreamsFragment.this, i);
    }

    ()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }
}
