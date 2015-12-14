// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

final class a
    implements android.view.aClickListener
{

    private WeakReference a;

    public final void onClick(View view)
    {
        InlineVideoView inlinevideoview = (InlineVideoView)a.get();
        if (inlinevideoview != null)
        {
            inlinevideoview.onMediaControllerClick(view);
        }
    }

    public (InlineVideoView inlinevideoview)
    {
        a = new WeakReference(inlinevideoview);
    }
}
