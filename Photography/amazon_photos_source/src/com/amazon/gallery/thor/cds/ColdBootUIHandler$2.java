// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.os.Handler;
import android.widget.ProgressBar;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class this._cls0
    implements Runnable
{

    final ColdBootUIHandler this$0;

    public void run()
    {
        final int progress = ColdBootUIHandler.access$200(ColdBootUIHandler.this).getProgress();
        if (ColdBootUIHandler.access$000(ColdBootUIHandler.this) != progress)
        {
            ColdBootUIHandler.access$002(ColdBootUIHandler.this, progress);
            ColdBootUIHandler.access$400(ColdBootUIHandler.this).post(new Runnable() {

                final ColdBootUIHandler._cls2 this$1;
                final int val$progress;

                public void run()
                {
                    ColdBootUIHandler.access$300(this$0, progress);
                }

            
            {
                this$1 = ColdBootUIHandler._cls2.this;
                progress = i;
                super();
            }
            });
            ColdBootUIHandler.access$400(ColdBootUIHandler.this).removeCallbacks(ColdBootUIHandler.access$500(ColdBootUIHandler.this));
            ColdBootUIHandler.access$400(ColdBootUIHandler.this).postDelayed(ColdBootUIHandler.access$500(ColdBootUIHandler.this), 1000L);
            if (progress == 100)
            {
                hide();
                return;
            }
        }
    }

    _cls1.val.progress()
    {
        this$0 = ColdBootUIHandler.this;
        super();
    }
}
