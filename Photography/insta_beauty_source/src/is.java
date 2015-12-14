// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import com.fotoable.beautyui.NewFilterContainer;

public class is
    implements android.view.View.OnTouchListener
{

    final NewFilterContainer a;

    public is(NewFilterContainer newfiltercontainer)
    {
        a = newfiltercontainer;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a.mListener != null)
        {
            a.mListener.a(motionevent);
        }
        return true;
    }
}
