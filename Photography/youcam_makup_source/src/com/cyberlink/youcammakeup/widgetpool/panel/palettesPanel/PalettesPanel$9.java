// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel

class a extends android.view.SimpleOnGestureListener
{

    final PalettesPanel a;

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        PalettesPanel.k(a);
        return false;
    }

    (PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
