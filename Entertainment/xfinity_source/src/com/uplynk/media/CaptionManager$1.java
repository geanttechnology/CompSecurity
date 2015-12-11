// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.widget.RelativeLayout;

// Referenced classes of package com.uplynk.media:
//            CaptionManager

class this._cls0
    implements android.view.OnGlobalLayoutListener
{

    final CaptionManager this$0;

    public void onGlobalLayout()
    {
        int j = 0;
        int i = 0;
        if (CaptionManager.access$10(CaptionManager.this) != null)
        {
            j = CaptionManager.access$10(CaptionManager.this).getWidth();
            i = CaptionManager.access$10(CaptionManager.this).getHeight();
        }
        if (j != CaptionManager.access$11(CaptionManager.this) || i != CaptionManager.access$7(CaptionManager.this))
        {
            updateMetrics();
        }
    }

    obalLayoutListener()
    {
        this$0 = CaptionManager.this;
        super();
    }
}
