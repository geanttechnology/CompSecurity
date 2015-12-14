// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class val.progress
    implements Runnable
{

    final ColdBootUIHandler this$0;
    final int val$progress;

    public void run()
    {
        ColdBootUIHandler.access$200(ColdBootUIHandler.this).setProgress(val$progress);
        ColdBootUIHandler.access$300(ColdBootUIHandler.this, val$progress);
        ColdBootUIHandler.access$600(ColdBootUIHandler.this).setVisibility(0);
    }

    ()
    {
        this$0 = final_coldbootuihandler;
        val$progress = I.this;
        super();
    }
}
