// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.fotoable.beautyui.BeautyAdjutItemView;

public class ii
    implements android.view.View.OnTouchListener
{

    final BeautyAdjutItemView a;

    public ii(BeautyAdjutItemView beautyadjutitemview)
    {
        a = beautyadjutitemview;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a.isSelected())
        {
            return false;
        }
        switch (motionevent.getAction())
        {
        case 1: // '\001'
        default:
            a.imgview.getDrawable().setColorFilter(a.unselectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            a.tx_tip.setTextColor(a.unselectedColor);
            return false;

        case 0: // '\0'
            a.imgview.getDrawable().setColorFilter(a.selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            a.tx_tip.setTextColor(a.selectedColor);
            return false;

        case 2: // '\002'
            a.imgview.getDrawable().setColorFilter(a.selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            break;
        }
        a.tx_tip.setTextColor(a.selectedColor);
        return false;
    }
}
