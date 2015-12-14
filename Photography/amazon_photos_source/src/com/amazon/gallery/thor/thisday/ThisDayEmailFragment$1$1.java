// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.os.Handler;
import com.amazon.gallery.framework.network.exceptions.TerminalException;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayEmailFragment

class this._cls1
    implements Runnable
{

    final iss this$1;

    public void run()
    {
        ThisDayEmailFragment.access$000(_fld0);
        dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/thisday/ThisDayEmailFragment$1

/* anonymous class */
    class ThisDayEmailFragment._cls1
        implements com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler
    {

        final ThisDayEmailFragment this$0;

        public void onFailure(TerminalException terminalexception)
        {
            ThisDayEmailFragment.access$100(ThisDayEmailFragment.this).post(new ThisDayEmailFragment._cls1._cls2());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((Void)obj);
        }

        public void onSuccess(Void void1)
        {
            ThisDayEmailFragment.access$100(ThisDayEmailFragment.this).post(new ThisDayEmailFragment._cls1._cls1());
        }

            
            {
                this$0 = ThisDayEmailFragment.this;
                super();
            }

        // Unreferenced inner class com/amazon/gallery/thor/thisday/ThisDayEmailFragment$1$2

/* anonymous class */
        class ThisDayEmailFragment._cls1._cls2
            implements Runnable
        {

            final ThisDayEmailFragment._cls1 this$1;

            public void run()
            {
                ThisDayEmailFragment.access$200(this$0);
                dismiss();
            }

                    
                    {
                        this$1 = ThisDayEmailFragment._cls1.this;
                        super();
                    }
        }

    }

}
