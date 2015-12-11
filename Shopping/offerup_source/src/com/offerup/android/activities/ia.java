// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.offerup.android.activities:
//            TruYouInitActivity

final class ia
    implements android.view.View.OnTouchListener
{

    private ImageView a;
    private Drawable b;
    private TruYouInitActivity c;

    public ia(TruYouInitActivity truyouinitactivity, ImageView imageview)
    {
        c = truyouinitactivity;
        super();
        a = imageview;
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        case 2: // '\002'
        default:
            return false;

        case 0: // '\0'
            if (b == null)
            {
                b = a.getDrawable();
            }
            if (b == null)
            {
                b = c.getResources().getDrawable(0x7f02018e);
            }
            view = b;
            motionevent = c.getResources().getDrawable(0x7f020155);
            a.setImageDrawable(new LayerDrawable(new Drawable[] {
                view, motionevent
            }));
            return false;

        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
            a.setImageDrawable(b);
            return false;
        }
    }
}
