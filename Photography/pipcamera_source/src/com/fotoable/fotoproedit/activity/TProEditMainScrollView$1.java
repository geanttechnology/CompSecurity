// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            TProEditMainScrollView, ItemView

class a
    implements android.view.EditMainScrollView._cls1
{

    final ItemView a;
    final TProEditMainScrollView b;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 || motionevent.getAction() == 2)
        {
            a.setIconColor(0xff007aff);
            a.setTextColor(0xff007aff);
        } else
        {
            a.setIconColor(0xff3a3a3a);
            a.setTextColor(0xff3a3a3a);
        }
        return false;
    }

    (TProEditMainScrollView tproeditmainscrollview, ItemView itemview)
    {
        b = tproeditmainscrollview;
        a = itemview;
        super();
    }
}
