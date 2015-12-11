// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.os.Handler;
import android.widget.TextView;

// Referenced classes of package com.gotv.crackle.fragments:
//            SeekIndicatorFragment

class val.handler
    implements Runnable
{

    final SeekIndicatorFragment this$0;
    final Handler val$handler;

    public void run()
    {
        long l = 500;
        try
        {
            Thread.sleep(l);
        }
        catch (Exception exception) { }
        val$handler.post(new Runnable() {

            final SeekIndicatorFragment._cls1 this$1;

            public void run()
            {
                if (SeekIndicatorFragment.access$000(this$0).getVisibility() == 0)
                {
                    SeekIndicatorFragment.access$000(this$0).setVisibility(4);
                } else
                {
                    SeekIndicatorFragment.access$000(this$0).setVisibility(0);
                }
                SeekIndicatorFragment.access$100(this$0);
            }

            
            {
                this$1 = SeekIndicatorFragment._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_seekindicatorfragment;
        val$handler = Handler.this;
        super();
    }
}
