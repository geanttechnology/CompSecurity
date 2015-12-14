// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.fotoable.beautyui.newui.MNewCanSelButton;

public class tr
    implements android.view.View.OnTouchListener
{

    final MNewCanSelButton a;

    public tr(MNewCanSelButton mnewcanselbutton)
    {
        a = mnewcanselbutton;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a.isSelected() || !a.isEnabled())
        {
            return false;
        }
        switch (motionevent.getAction())
        {
        case 1: // '\001'
        default:
            a.getBackground().setColorFilter(MNewCanSelButton.access$100(a), android.graphics.PorterDuff.Mode.SRC_IN);
            return false;

        case 0: // '\0'
            a.getBackground().setColorFilter(MNewCanSelButton.access$000(a), android.graphics.PorterDuff.Mode.SRC_IN);
            return false;

        case 2: // '\002'
            a.getBackground().setColorFilter(MNewCanSelButton.access$000(a), android.graphics.PorterDuff.Mode.SRC_IN);
            break;
        }
        return false;
    }
}
