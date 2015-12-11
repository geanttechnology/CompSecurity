// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.groupon.view.PopupWindowAboveView;

// Referenced classes of package com.groupon.activity:
//            Thanks

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        Thanks.access$802(_fld0, false);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/Thanks$5

/* anonymous class */
    class Thanks._cls5
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final Thanks this$0;

        public void onGlobalLayout()
        {
            if (Thanks.access$800(Thanks.this) && (Thanks.access$900(Thanks.this) == null || !Thanks.access$900(Thanks.this).isShowing()))
            {
                Thanks.access$902(Thanks.this, new PopupWindowAboveView(Thanks.this, new Thanks._cls5._cls1(), requestAppointmentView.getWidth(), -2));
                android.view.View view = getLayoutInflater().inflate(0x7f030214, null);
                Thanks.access$900(Thanks.this).showAboveView(requestAppointmentView, view, (int)getResources().getDimension(0x7f0b020d));
            }
            requestAppointmentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

            
            {
                this$0 = Thanks.this;
                super();
            }
    }

}
