// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.mopub.nativeads:
//            VisibilityTracker

static class 
{

    private final Rect mClipRect = new Rect();

    boolean hasRequiredTimeElapsed(long l, int i)
    {
        return SystemClock.uptimeMillis() - l >= (long)i;
    }

    boolean isVisible(View view, int i)
    {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.getGlobalVisibleRect(mClipRect))
        {
            long l = mClipRect.height();
            long l1 = mClipRect.width();
            long l2 = (long)view.getHeight() * (long)view.getWidth();
            if (l2 > 0L && 100L * (l * l1) >= (long)i * l2)
            {
                return true;
            }
        }
        return false;
    }

    ()
    {
    }
}
