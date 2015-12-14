// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel

class a
    implements android.view.ener
{

    final PalettesPanel a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.performClick();
        return PalettesPanel.l(a).onTouchEvent(motionevent);
    }

    (PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
