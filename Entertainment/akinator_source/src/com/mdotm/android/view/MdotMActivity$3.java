// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.mdotm.android.view:
//            MdotMActivity

class this._cls0
    implements android.view.ener
{

    final MdotMActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 && !MdotMActivity.access$3(MdotMActivity.this))
        {
            MdotMActivity.access$4(MdotMActivity.this, true);
            clicked();
        }
        return true;
    }

    ()
    {
        this$0 = MdotMActivity.this;
        super();
    }
}
