// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.livemixtapes.ui:
//            FadeImageButton

class this._cls0
    implements android.view.er
{

    final FadeImageButton this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            setColorFilter(0x99000000);
            Log.d("FadeButton", "Darkened");
            return false;

        case 1: // '\001'
            setColorFilter(0);
            break;
        }
        Log.d("FadeButton", "Lightened");
        return false;
    }

    ()
    {
        this$0 = FadeImageButton.this;
        super();
    }
}
