// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.widget.RelativeLayout;

// Referenced classes of package com.apprupt.sdk:
//            CvExpandActivity

class val.color
    implements Runnable
{

    final CvExpandActivity this$0;
    final int val$color;

    public void run()
    {
        CvExpandActivity.access$400(CvExpandActivity.this).setBackgroundColor(val$color);
    }

    ()
    {
        this$0 = final_cvexpandactivity;
        val$color = I.this;
        super();
    }
}
