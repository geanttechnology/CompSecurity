// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.os.Handler;
import com.amazon.gallery.framework.network.exceptions.TerminalException;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayEmailFragment

class this._cls0
    implements com.amazon.gallery.framework.network.andler
{

    final ThisDayEmailFragment this$0;

    public void onFailure(TerminalException terminalexception)
    {
        ThisDayEmailFragment.access$100(ThisDayEmailFragment.this).post(new Runnable() {

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
        });
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((Void)obj);
    }

    public void onSuccess(Void void1)
    {
        ThisDayEmailFragment.access$100(ThisDayEmailFragment.this).post(new Runnable() {

            final ThisDayEmailFragment._cls1 this$1;

            public void run()
            {
                ThisDayEmailFragment.access$000(this$0);
                dismiss();
            }

            
            {
                this$1 = ThisDayEmailFragment._cls1.this;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = ThisDayEmailFragment.this;
        super();
    }
}
