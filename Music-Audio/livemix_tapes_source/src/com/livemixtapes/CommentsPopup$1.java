// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

// Referenced classes of package com.livemixtapes:
//            CommentsPopup

class val.frameLayout
    implements android.widget.smissListener
{

    final CommentsPopup this$0;
    private final FrameLayout val$frameLayout;

    public void onDismiss()
    {
        val$frameLayout.getForeground().setAlpha(0);
    }

    e()
    {
        this$0 = final_commentspopup;
        val$frameLayout = FrameLayout.this;
        super();
    }
}
