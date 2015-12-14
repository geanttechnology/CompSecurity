// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiLibraryView

class a
    implements android.view.braryView._cls2
{

    final TTieZhiLibraryView a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 2 || motionevent.getAction() == 0)
        {
            a.txt_refresh.setTextColor(0x7affffff);
        } else
        {
            a.txt_refresh.setTextColor(-1);
        }
        return true;
    }

    (TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }
}
