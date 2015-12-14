// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.fotoable.comlib.ui:
//            HorizontalListView

public class a
    implements android.view.istView._cls1
{

    final HorizontalListView a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return HorizontalListView.access$100(a).onTouchEvent(motionevent);
    }

    (HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }
}
