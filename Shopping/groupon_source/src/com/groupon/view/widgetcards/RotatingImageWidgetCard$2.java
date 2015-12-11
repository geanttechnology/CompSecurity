// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.view.widgetcards:
//            RotatingImageWidgetCard

class this._cls0
    implements android.view.ageWidgetCard._cls2
{

    final RotatingImageWidgetCard this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            RotatingImageWidgetCard.access$000(RotatingImageWidgetCard.this).setPressed(true);
            break;
        }
        RotatingImageWidgetCard.access$100(RotatingImageWidgetCard.this).setPressed(true);
        return false;
    }

    ()
    {
        this$0 = RotatingImageWidgetCard.this;
        super();
    }
}
