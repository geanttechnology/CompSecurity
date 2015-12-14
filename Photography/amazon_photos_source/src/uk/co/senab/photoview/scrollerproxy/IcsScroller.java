// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;
import android.widget.OverScroller;

// Referenced classes of package uk.co.senab.photoview.scrollerproxy:
//            GingerScroller

public class IcsScroller extends GingerScroller
{

    public IcsScroller(Context context)
    {
        super(context);
    }

    public boolean computeScrollOffset()
    {
        return mScroller.computeScrollOffset();
    }
}
