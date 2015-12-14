// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

class a
    implements android.view.oTouchListener
{

    private WeakReference a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        InlineVideoView inlinevideoview = (InlineVideoView)a.get();
        if (inlinevideoview != null)
        {
            return inlinevideoview.onTouch(view, motionevent);
        } else
        {
            return true;
        }
    }

    public (InlineVideoView inlinevideoview)
    {
        a = new WeakReference(inlinevideoview);
    }
}
