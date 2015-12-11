// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.os.Handler;
import android.widget.TextView;

// Referenced classes of package com.gotv.crackle.fragments:
//            SeekIndicatorFragment

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (SeekIndicatorFragment.access$000(_fld0).getVisibility() == 0)
        {
            SeekIndicatorFragment.access$000(_fld0).setVisibility(4);
        } else
        {
            SeekIndicatorFragment.access$000(_fld0).setVisibility(0);
        }
        SeekIndicatorFragment.access$100(_fld0);
    }

    l.handler()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/fragments/SeekIndicatorFragment$1

/* anonymous class */
    class SeekIndicatorFragment._cls1
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
            handler.post(new SeekIndicatorFragment._cls1._cls1());
        }

            
            {
                this$0 = final_seekindicatorfragment;
                handler = Handler.this;
                super();
            }
    }

}
