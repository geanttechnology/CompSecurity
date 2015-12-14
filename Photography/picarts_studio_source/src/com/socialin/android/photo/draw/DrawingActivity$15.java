// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.ImageButton;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private ImageButton a;
    private DrawingActivity b;

    public final void onClick(View view)
    {
        if (a.isSelected())
        {
            DrawingActivity.e(b);
            a.setSelected(false);
            return;
        } else
        {
            DrawingActivity.d(b);
            a.setSelected(true);
            return;
        }
    }

    (DrawingActivity drawingactivity, ImageButton imagebutton)
    {
        b = drawingactivity;
        a = imagebutton;
        super();
    }
}
