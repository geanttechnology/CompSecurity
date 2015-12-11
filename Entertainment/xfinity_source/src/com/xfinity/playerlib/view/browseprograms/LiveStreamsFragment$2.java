// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.xfinity.playerlib.view.DimmingPageTransformer;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class this._cls0
    implements android.content.issListener
{

    final LiveStreamsFragment this$0;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (LiveStreamsFragment.access$300(LiveStreamsFragment.this) != null)
        {
            dialoginterface = LiveStreamsFragment.access$300(LiveStreamsFragment.this).getChildAt(LiveStreamsFragment.access$300(LiveStreamsFragment.this).getCurrentItem());
            if (dialoginterface != null)
            {
                dialoginterface.setAlpha(DimmingPageTransformer.MAX_ALPHA);
            }
        }
    }

    ()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }
}
