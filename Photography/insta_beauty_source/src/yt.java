// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.fotoable.comlib.ui.HorizontalListView;

public class yt
    implements android.view.View.OnTouchListener
{

    final HorizontalListView a;

    public yt(HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return HorizontalListView.access$100(a).onTouchEvent(motionevent);
    }
}
