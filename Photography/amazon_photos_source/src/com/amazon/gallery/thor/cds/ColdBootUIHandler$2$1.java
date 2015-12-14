// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.os.Handler;
import android.widget.ProgressBar;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class val.progress
    implements Runnable
{

    final val.progress this$1;
    final int val$progress;

    public void run()
    {
        ColdBootUIHandler.access$300(_fld0, val$progress);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$progress = I.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/cds/ColdBootUIHandler$2

/* anonymous class */
    class ColdBootUIHandler._cls2
        implements Runnable
    {

        final ColdBootUIHandler this$0;

        public void run()
        {
            int i = ColdBootUIHandler.access$200(ColdBootUIHandler.this).getProgress();
            if (ColdBootUIHandler.access$000(ColdBootUIHandler.this) != i)
            {
                ColdBootUIHandler.access$002(ColdBootUIHandler.this, i);
                ColdBootUIHandler.access$400(ColdBootUIHandler.this).post(i. new ColdBootUIHandler._cls2._cls1());
                ColdBootUIHandler.access$400(ColdBootUIHandler.this).removeCallbacks(ColdBootUIHandler.access$500(ColdBootUIHandler.this));
                ColdBootUIHandler.access$400(ColdBootUIHandler.this).postDelayed(ColdBootUIHandler.access$500(ColdBootUIHandler.this), 1000L);
                if (i == 100)
                {
                    hide();
                    return;
                }
            }
        }

            
            {
                this$0 = ColdBootUIHandler.this;
                super();
            }
    }

}
