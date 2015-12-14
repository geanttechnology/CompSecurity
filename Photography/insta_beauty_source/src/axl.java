// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.fotoable.sketch.view.TTieZhiLibraryView;

public class axl
    implements android.view.View.OnTouchListener
{

    final TTieZhiLibraryView a;

    public axl(TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }

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
}
